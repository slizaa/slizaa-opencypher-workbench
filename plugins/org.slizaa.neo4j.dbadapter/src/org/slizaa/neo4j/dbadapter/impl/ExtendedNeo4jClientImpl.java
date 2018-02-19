/*******************************************************************************
 * Copyright (c) Gerd Wuetherich 2012-2016.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *    Gerd W�therich (gerd@gerd-wuetherich.de) - initial API and implementation
 ******************************************************************************/
package org.slizaa.neo4j.dbadapter.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.function.Consumer;

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
    _driver = GraphDatabase.driver(getUri(), config);

    // register adapter
    try {
      _serviceRegistration = FrameworkUtil.getBundle(ExtendedNeo4jClientImpl.class).getBundleContext().registerService(
          new String[] { IGraphMetaDataProvider.class.getName(), Neo4jClient.class.getName() }, this, null);
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
    if (_serviceRegistration != null) {
      _serviceRegistration.unregister();
    }

    //
    _driver.close();

    //
    setConnected(false);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Relationship getRelationship(long nodeId) {

    assertConnected();

    try (Session session = _driver.session()) {
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

    try (Session session = _driver.session()) {
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

    try (Session session = _driver.session()) {

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

    try (Session session = _driver.session()) {

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

    try (Session session = _driver.session()) {

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

    try (Session session = _driver.session()) {

      // create future task
      FutureTask<StatementResult> futureTask = new FutureTask<StatementResult>(
          new StatementCallable(_driver, checkNotNull(cypherQuery), params));

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
   * @param cypher
   * @param serializer
   * @param defaultLimit
   */
  @Override
  public Future<Void> executeCypherQuery(String cypherString, IQueryResultConsumer consumer) {

    //
    consumer.handleQueryStarted(cypherString);

    //
    Future<Void> future = executeCypherQuery(cypherString, result -> {

      //
      try {
        
        consumer.handleQueryResultReceived(cypherString, result);
      } catch (Neo4jException e) {
        consumer.handleError(cypherString, result, e);
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

    try (Session session = _driver.session()) {

      // create future task
      FutureTask<Void> futureTask = new FutureTask<Void>(
          new StatementResultConsumerCallable(_driver, checkNotNull(cypherQuery), null, consumer, this));

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
    boolean oldConnected = connected;
    connected = newConnected;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DbAdapterPackage.NEO4J_CLIENT__CONNECTED, oldConnected,
          connected));
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
