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

import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class StatementCallable implements Callable<StatementResult> {

  private Driver              _driver;

  /** - */
  private String              _statement;

  /** - */
  private Map<String, Object> _params;

  /**
   * <p>
   * Creates a new instance of type {@link StatementCallable}.
   * </p>
   *
   * @param driver
   * @param statement
   * @param params
   */
  public StatementCallable(Driver driver, String statement, Map<String, Object> params) {
    _driver = checkNotNull(driver);
    _statement = checkNotNull(statement);
    _params = params;
  }

  /**
   * {@inheritDoc}
   */
  public StatementResult call() throws Exception {

    try (Session session = _driver.session()) {

      if (_params == null) {
        return session.run(_statement);
      }
      //
      else {
        return session.run(_statement, _params);
      }
    }
  }
}
