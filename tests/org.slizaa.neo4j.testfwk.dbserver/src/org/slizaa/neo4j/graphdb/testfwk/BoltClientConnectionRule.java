package org.slizaa.neo4j.graphdb.testfwk;

import static com.google.common.base.Preconditions.checkNotNull;

import org.junit.rules.ExternalResource;
import org.slizaa.neo4j.dbadapter.DbAdapterFactory;
import org.slizaa.neo4j.dbadapter.Neo4jClient;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class BoltClientConnectionRule extends ExternalResource {

  /** - */
  private Neo4jClient _boltClient;

  /** - */
  private String      _host;

  /** - */
  private int         _port;

  /**
   * <p>
   * Creates a new instance of type {@link BoltClientConnectionRule}.
   * </p>
   *
   * @param host
   * @param port
   */
  public BoltClientConnectionRule(String host, int port) {
    _host = checkNotNull(host);
    _port = port;
  }

  /**
   * <p>
   * </p>
   *
   * @return the neo4JRemoteRepository
   */
  public Neo4jClient getBoltClient() {
    return _boltClient;
  }

  @Override
  protected void before() throws Throwable {
    _boltClient = DbAdapterFactory.eINSTANCE.createNeo4jClient();
    _boltClient.setUri(String.format("bolt://%s:%s", _host, _port));
    _boltClient.connect();
  }

  @Override
  protected void after() {

    try {
      _boltClient.disconnect();
    } catch (Exception e) {
      //
    }
  }
}
