package org.slizaa.neo4j.dbadapter.test;

import java.util.concurrent.ExecutionException;

import org.junit.ClassRule;
import org.junit.Test;
import org.neo4j.driver.v1.StatementResult;
import org.slizaa.neo4j.graphdb.testfwk.BoltClientConnectionRule;
import org.slizaa.neo4j.graphdb.testfwk.PredefinedGraphDatabaseRule;
import org.slizaa.neo4j.graphdb.testfwk.StatementResultUtil;
import org.slizaa.neo4j.graphdb.testfwk.TestDB;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class ExampleTest {

  @ClassRule
  public static PredefinedGraphDatabaseRule graphDatabase        = new PredefinedGraphDatabaseRule(TestDB.MAPSTRUCT);

  @ClassRule
  public static BoltClientConnectionRule    boltClientConnection = new BoltClientConnectionRule("localhost", 5001);

  /**
   * <p>
   * </p>
   *
   * @throws InterruptedException
   * @throws ExecutionException
   */
  @Test
  public void test() throws InterruptedException, ExecutionException {

    //
    StatementResult statementResult = boltClientConnection.getBoltClient()
        .executeCypherQuery("MATCH (c:CLASS) RETURN c LIMIT 10").get();

    //
    StatementResultUtil.dumpStatement(statementResult);
  }

  @Test
  public void test_2() throws InterruptedException, ExecutionException {

    //
    boltClientConnection.getBoltClient()
        .executeCypherQuery("MATCH (t:TYPE) RETURN t", sr -> StatementResultUtil.dumpStatement(sr)).get();
  }

  // /**
  // * <p>
  // * </p>
  // *
  // * @throws InterruptedException
  // * @throws ExecutionException
  // */
  // @Test
  // public void testGetNode() throws InterruptedException, ExecutionException {
  //
  // //
  // Node node = this.getNeo4JRemoteRepository().getNode(300);
  //
  // // TODO
  // // c
  // // ID: 300
  // // TYPE, CLASS,
  // // accessFlags : "21"
  // // fqn : "org.mapstruct.factory.Mappers"
  // // nodetype : "CLASS"
  // // classVersion : "50.0 (50)"
  // // accessLevel : "PUBLIC"
  // // name : "Mappers"
  // System.out.println(node.id());
  // System.out.println(StreamSupport.stream(node.labels().spliterator(), false).collect(Collectors.toList()));
  // System.out.println(node.asMap());
  // assertThat(node.get("fqn").asString()).isEqualTo("org.mapstruct.factory.Mappers");
  // }
  //
  // @Test
  // public void testLabels() throws InterruptedException, ExecutionException {
  //
  // //
  // Stopwatch stopwatch;
  // List<String> result;
  //
  // //
  // for (int i = 0; i < 10; i++) {
  // stopwatch = Stopwatch.createStarted();
  // result = this.getNeo4JRemoteRepository().getNodeLabels();
  // System.out.println(stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));
  // System.out.println(result);
  // }
  //
  // //
  // for (int i = 0; i < 10; i++) {
  // stopwatch = Stopwatch.createStarted();
  // result = this.getNeo4JRemoteRepository().getPropertyKeys();
  // System.out.println(stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));
  // System.out.println(result);
  // }
  //
  // //
  // for (int i = 0; i < 10; i++) {
  // stopwatch = Stopwatch.createStarted();
  // result = this.getNeo4JRemoteRepository().getRelationshipTypes();
  // System.out.println(stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));
  // System.out.println(result);
  // }
  // }

  // executeCypherQuery(String)
  // executeCypherQuery(String, Consumer<JsonObject>)
  // executeCypherQuery(String, Map<String, String>)
  // executeCypherQuery(String, Map<String, String>, Consumer<JsonObject>)
  // getAllLabels()
  // getAllPropertyKeys()
  // getAllRelationshipTypes()
  // getBaseURI()
  // getExtension(Class<T>)
  // getLabelsForNode(long)
  // getName()
  // getPropertiesForNode(long)
  // getPropertiesForRelationship(long)
  // getThreadPoolSize()
  // hasExtension(Class<T>)
  // registerExtension(Class<T>)
  // setBaseURI(String)
  // setName(String)
  // setThreadPoolSize(int)
}
