/*******************************************************************************
 * Copyright (c) Gerd Wuetherich 2012-2016. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *
 * Contributors: Gerd W�therich (gerd@gerd-wuetherich.de) - initial API and implementation
 ******************************************************************************/
package org.slizaa.neo4j.dbadapter.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.function.Consumer;
import java.util.function.Function;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.neo4j.driver.v1.Config;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.exceptions.Neo4jException;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceRegistration;
import org.slizaa.neo4j.dbadapter.DbAdapterPackage;
import org.slizaa.neo4j.dbadapter.IQueryResultConsumer;
import org.slizaa.neo4j.dbadapter.Neo4jClient;
import org.slizaa.neo4j.dbadapter.internal.Activator;
import org.slizaa.neo4j.dbadapter.internal.bolt.StatementCallable;
import org.slizaa.neo4j.dbadapter.internal.bolt.StatementResultConsumerCallable;
import org.slizaa.neo4j.opencypher.spi.IGraphMetaDataProvider;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class ExtendedNeo4jClientImpl extends Neo4jClientImpl {

  /** - */
  private Driver                 _driver;

  /** - */
  private ServiceRegistration<?> _serviceRegistration;

  /**
   * {@inheritDoc}
   */
  @Override
  public void connect() {

    //
    Config config = Config.build().withoutEncryption().toConfig();
    this._driver = GraphDatabase.driver(getUri(), config);

    // register adapter
    try {
      this._serviceRegistration = FrameworkUtil.getBundle(ExtendedNeo4jClientImpl.class).getBundleContext()
          .registerService(new String[] { IGraphMetaDataProvider.class.getName(), Neo4jClient.class.getName() }, this,
              null);
    } catch (Exception exception) {
      //
    }

    //
    setConnected(true);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void disconnect() {

    // register adapter
    if (this._serviceRegistration != null) {
      this._serviceRegistration.unregister();
    }

    //
    this._driver.close();

    //
    setConnected(false);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Relationship getRelationship(long nodeId) {

    assertConnected();

    try (Session session = this._driver.session()) {
      StatementResult result = session.run(String.format("MATCH ()-[r]->() WHERE id(r) = %s RETURN r ", nodeId));
      return result.single().get("r").asRelationship();
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Node getNode(long nodeId) {

    assertConnected();

    try (Session session = this._driver.session()) {
      StatementResult result = session.run(String.format("MATCH (n) WHERE id(n) = %s RETURN n ", nodeId));
      return result.single().get("n").asNode();
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<String> getRelationshipTypes() {

    assertConnected();

    try (Session session = this._driver.session()) {

      StatementResult result = session.run("CALL db.relationshipTypes");

      return result.list(r -> r.get("relationshipType").asString());
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<String> getNodeLabels() {

    assertConnected();

    try (Session session = this._driver.session()) {

      StatementResult result = session.run("CALL db.labels");

      return result.list(r -> r.get("label").asString());
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<String> getPropertyKeys() {

    assertConnected();

    try (Session session = this._driver.session()) {

      StatementResult result = session.run("CALL db.propertyKeys");

      return result.list(r -> r.get("propertyKey").asString());
    }

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Future<StatementResult> executeCypherQuery(String cypherQuery) {
    return executeCypherQuery(cypherQuery, (Map<String, Object>) null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Future<StatementResult> executeCypherQuery(String cypherQuery, Map<String, Object> params) {

    //
    assertConnected();
    checkNotNull(cypherQuery);

    try (Session session = this._driver.session()) {

      // create future task
      FutureTask<StatementResult> futureTask = new FutureTask<StatementResult>(
          new StatementCallable<StatementResult>(this._driver, checkNotNull(cypherQuery), params, result -> result));

      // execute
      getExecutor().execute(futureTask);

      // return the running task
      return futureTask;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public <T> Future<T> executeCypherQueryAndTransformResult(String cypherQuery, Function<StatementResult, T> function) {
    return this.executeCypherQueryAndTransformResult(cypherQuery, (Map<String, Object>) null, function);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public <T> Future<T> executeCypherQueryAndTransformResult(String cypherQuery, Map<String, Object> params,
      Function<StatementResult, T> function) {

    //
    assertConnected();
    checkNotNull(cypherQuery);

    try (Session session = this._driver.session()) {

      // create future task
      FutureTask<T> futureTask = new FutureTask<T>(
          new StatementCallable<T>(this._driver, checkNotNull(cypherQuery), params, function));

      // execute
      getExecutor().execute(futureTask);

      // return the running task
      return futureTask;
    }

    //
    // //
    // Future<T> future = executeCypherQuery(cypherQuery, result -> {
    // return consumer.apply(result);
    // });
    //
    // //
    // return future;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Future<Void> executeCypherQuery(String cypherQuery, IQueryResultConsumer consumer) {
    return this.executeCypherQuery(cypherQuery, (Map<String, Object>) null, consumer);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Future<Void> executeCypherQuery(String cypherQuery, Map<String, Object> params,
      IQueryResultConsumer consumer) {

    //
    consumer.handleQueryStarted(cypherQuery);

    //
    Future<Void> future = executeCypherQuery(cypherQuery, result -> {

      //
      try {

        consumer.handleQueryResultReceived(cypherQuery, result);
      } catch (Neo4jException e) {
        consumer.handleError(cypherQuery, result, e);
      }

    });

    //
    return future;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Future<Void> executeCypherQuery(String cypherQuery, Consumer<StatementResult> consumer) {
    return executeCypherQuery(cypherQuery, null, consumer);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Future<Void> executeCypherQuery(String cypherQuery, Map<String, Object> params,
      Consumer<StatementResult> consumer) {

    //
    assertConnected();
    checkNotNull(cypherQuery);

    try (Session session = this._driver.session()) {

      // create future task
      FutureTask<Void> futureTask = new FutureTask<Void>(
          new StatementResultConsumerCallable(this._driver, checkNotNull(cypherQuery), null, consumer, this));

      // execute
      getExecutor().execute(futureTask);

      // return the running task
      return futureTask;
    }
  }

  /**
   * <p>
   * </p>
   *
   * @param newConnected
   */
  protected void setConnected(boolean newConnected) {
    boolean oldConnected = this.connected;
    this.connected = newConnected;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, DbAdapterPackage.NEO4J_CLIENT__CONNECTED, oldConnected,
          this.connected));
    }
  }

  /**
   * <p>
   * </p>
   */
  private void assertConnected() {
    if (!isConnected()) {
      throw new RuntimeException();
    }
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  private ExecutorService getExecutor() {
    return Activator.getExecutor();
  }
}
