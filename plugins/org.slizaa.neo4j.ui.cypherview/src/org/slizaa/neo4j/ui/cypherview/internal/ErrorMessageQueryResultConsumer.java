package org.slizaa.neo4j.ui.cypherview.internal;

import static com.google.common.base.Preconditions.checkNotNull;

import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.exceptions.ClientException;
import org.neo4j.driver.v1.exceptions.Neo4jException;
import org.slizaa.neo4j.dbadapter.IQueryResultConsumer;

public class ErrorMessageQueryResultConsumer implements IQueryResultConsumer {

  /** - */
  private IQueryResultConsumer _queryResultConsumer;

  /**
   * <p>
   * Creates a new instance of type {@link ErrorMessageQueryResultConsumer}.
   * </p>
   *
   * @param queryResultConsumer
   */
  public ErrorMessageQueryResultConsumer(IQueryResultConsumer queryResultConsumer) {
    _queryResultConsumer = checkNotNull(queryResultConsumer);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean canConsume(String cypherQuery) {
    return _queryResultConsumer.canConsume(cypherQuery);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void handleQueryStarted(String cypherQuery) {
    _queryResultConsumer.handleQueryStarted(cypherQuery);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void handleQueryResultReceived(String cypherQuery, StatementResult result) {
    _queryResultConsumer.handleQueryResultReceived(cypherQuery, result);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void handleError(String cypherQuery, StatementResult statementResult, Neo4jException exception) {

    //
    System.out.println("FEHLERMELDUNG!!!");

    //
    _queryResultConsumer.handleQueryResultReceived(cypherQuery, statementResult);
  }
}
