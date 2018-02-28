package org.slizaa.neo4j.dbadapter.internal;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;
import org.slizaa.neo4j.dbadapter.INeo4jClientListener;
import org.slizaa.neo4j.dbadapter.IQueryResultConsumer;
import org.slizaa.neo4j.dbadapter.IQueryResultConsumerListener;
import org.slizaa.neo4j.dbadapter.Neo4jClient;

@Component
public class Neo4jClientQueryResultDispatcherComponent {

  /** - */
  private Neo4jClient                        _currentNeo4jClient;

  /** - */
  private List<IQueryResultConsumer>         _queryResultConsumers      = new CopyOnWriteArrayList<>();

  /** - */
  private List<INeo4jClientListener>         _neo4jClientListeners      = new CopyOnWriteArrayList<>();

  /** - */
  private List<IQueryResultConsumerListener> _queryResultConsumerAwares = new CopyOnWriteArrayList<>();

  /**
   * <p>
   * </p>
   */
  @Reference(cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC)
  public void addGraphDatabaseClientAdapterConsumer(INeo4jClientListener consumer) {

    //
    if (this._currentNeo4jClient != null) {
      consumer.neo4jClientAdded(this._currentNeo4jClient);
    }

    //
    this._neo4jClientListeners.add(consumer);
  }

  /**
   * <p>
   * </p>
   */
  public void removeGraphDatabaseClientAdapterConsumer(INeo4jClientListener consumer) {

    //
    this._neo4jClientListeners.remove(consumer);

    //
    if (this._currentNeo4jClient != null) {
      consumer.neo4jClientRemoved(this._currentNeo4jClient);
    }
  }

  /**
   * <p>
   * </p>
   *
   * @param clientAdapter
   */
  @Reference(cardinality = ReferenceCardinality.OPTIONAL, policy = ReferencePolicy.DYNAMIC, policyOption = ReferencePolicyOption.GREEDY)
  public void setNeo4jClient(Neo4jClient client) {

    //
    this._currentNeo4jClient = client;

    //
    for (INeo4jClientListener consumer : this._neo4jClientListeners) {
      consumer.neo4jClientAdded(this._currentNeo4jClient);
    }
  }

  /**
   * <p>
   * </p>
   *
   * @param client
   */
  public void unsetNeo4jClient(Neo4jClient client) {

    //
    for (INeo4jClientListener consumer : this._neo4jClientListeners) {
      consumer.neo4jClientRemoved(this._currentNeo4jClient);
    }

    //
    this._currentNeo4jClient = null;
  }

  /**
   * <p>
   * </p>
   *
   * @param consumerAware
   */
  @Reference(cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC)
  public void addQueryResultConsumerListener(IQueryResultConsumerListener consumerAware) {

    //
    for (IQueryResultConsumer resultConsumer : this._queryResultConsumers) {
      consumerAware.queryResultConsumerAdded(resultConsumer);
    }

    //
    this._queryResultConsumerAwares.add(consumerAware);
  }

  /**
   * <p>
   * </p>
   *
   * @param consumerAware
   */
  public void removeQueryResultConsumerListener(IQueryResultConsumerListener consumerAware) {

    //
    for (IQueryResultConsumer resultConsumer : this._queryResultConsumers) {
      consumerAware.queryResultConsumerRemoved(resultConsumer);
    }

    //
    this._queryResultConsumerAwares.remove(consumerAware);
  }

  /**
   * <p>
   * </p>
   *
   * @param queryResultConsumer
   */
  @Reference(cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC)
  public void addQueryResultConsumer(IQueryResultConsumer queryResultConsumer) {

    //
    for (IQueryResultConsumerListener aware : this._queryResultConsumerAwares) {
      aware.queryResultConsumerAdded(queryResultConsumer);
    }

    //
    this._queryResultConsumers.add(queryResultConsumer);
  }

  /**
   * <p>
   * </p>
   */
  public void removeQueryResultConsumer(IQueryResultConsumer queryResultConsumer) {

    //
    this._queryResultConsumers.remove(queryResultConsumer);

    //
    for (IQueryResultConsumerListener aware : this._queryResultConsumerAwares) {
      aware.queryResultConsumerRemoved(queryResultConsumer);
    }
  }
}
