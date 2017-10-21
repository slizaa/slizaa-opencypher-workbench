package org.slizaa.neo4j.dbadapter;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public interface INeo4jClientListener {

  /**
   * <p>
   * </p>
   *
   * @param adapter
   */
  void neo4jClientAdded(Neo4jClient adapter);

  /**
   * <p>
   * </p>
   *
   * @param adapter
   */
  void neo4jClientRemoved(Neo4jClient adapter);
}
