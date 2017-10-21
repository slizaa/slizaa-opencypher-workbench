package org.slizaa.neo4j.graphdb.testfwk;

import static com.google.common.base.Preconditions.checkNotNull;

import org.junit.rules.ExternalResource;
import org.slizaa.neo4j.graphdb.testfwk.internal.TestNeo4jServerCreatorServiceImpl;

public class PredefinedGraphDatabaseRule extends ExternalResource {

  private TestDB                            _testDB;

  /** - */
  private TestNeo4jServerCreatorServiceImpl _databaseCreator;

  /** - */
  private AutoCloseable                     _databaseServer;

  /**
   * <p>
   * Creates a new instance of type {@link PredefinedGraphDatabaseRule}.
   * </p>
   *
   * @param testDB
   */
  public PredefinedGraphDatabaseRule(TestDB testDB) {
    _testDB = checkNotNull(testDB);
  }

  @Override
  protected void before() throws Throwable {

    _databaseCreator = new TestNeo4jServerCreatorServiceImpl();
    _databaseCreator.activate();

    //
    _databaseServer = _databaseCreator.createNeo4jServer(_testDB);
  }

  @Override
  protected void after() {

    try {
      _databaseServer.close();
    } catch (Exception e) {
      //
    }
    
    //
    _databaseCreator.cleanUp();
  }
}
