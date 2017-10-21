/*******************************************************************************
 * Copyright (c) Gerd W�therich 2012-2016.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *    Gerd W�therich (gerd@gerd-wuetherich.de) - initial API and implementation
 ******************************************************************************/
package org.slizaa.neo4j.dbadapter.internal.bolt;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.slizaa.neo4j.dbadapter.Neo4jClient;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class StatementResultConsumerCallable implements Callable<Void> {

  /** - */
  private Driver                    _driver;

  /** - */
  private String                    _statement;

  /** - */
  private Map<String, Object>       _params;

  /** the consumer */
  private Consumer<StatementResult> _consumer;

  /** - */
  private Neo4jClient               _neo4jClient;

  /**
   * <p>
   * Creates a new instance of type {@link StatementResultConsumerCallable}.
   * </p>
   *
   * @param driver
   * @param statement
   * @param params
   * @param consumer
   */
  public StatementResultConsumerCallable(Driver driver, String statement, Map<String, Object> params,
      Consumer<StatementResult> consumer, Neo4jClient neo4jClient) {
    _driver = checkNotNull(driver);
    _statement = checkNotNull(statement);
    _params = params;
    _consumer = consumer;
    _neo4jClient = checkNotNull(neo4jClient);
  }

  /**
   * {@inheritDoc}
   */
  public Void call() throws Exception {

    try (Session session = _driver.session()) {

      //
      StatementResult statementResult = _params == null ? session.run(_statement) : session.run(_statement, _params);

      if (_consumer != null) {
        
        // we have to synchronize the consumption to avoid race conditions
        synchronized (_neo4jClient) {
          _consumer.accept(statementResult);
        } 
      }
    }

    //
    return null;
  }
}
