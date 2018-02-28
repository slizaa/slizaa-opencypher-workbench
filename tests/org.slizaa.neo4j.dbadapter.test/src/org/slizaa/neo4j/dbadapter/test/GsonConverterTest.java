/**
 *
 */
package org.slizaa.neo4j.dbadapter.test;

import java.util.concurrent.ExecutionException;

import org.junit.ClassRule;
import org.junit.Test;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.StatementResult;
import org.slizaa.neo4j.dbadapter.GsonConverter;
import org.slizaa.neo4j.graphdb.testfwk.BoltClientConnectionRule;
import org.slizaa.neo4j.graphdb.testfwk.PredefinedGraphDatabaseRule;
import org.slizaa.neo4j.graphdb.testfwk.StatementResultUtil;
import org.slizaa.neo4j.graphdb.testfwk.TestDB;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 *
 */
public class GsonConverterTest {

  @ClassRule
  public static PredefinedGraphDatabaseRule graphDatabase        = new PredefinedGraphDatabaseRule(TestDB.MAPSTRUCT,
      5001);

  @ClassRule
  public static BoltClientConnectionRule    boltClientConnection = new BoltClientConnectionRule("localhost", 5001);

  @Test
  public void test_typeMap() throws InterruptedException, ExecutionException {

    //
    StatementResult statementResult = boltClientConnection.getBoltClient()
        .executeCypherQuery("MATCH (c1:Class)-[rel:DEPENDS_ON]->(c2:Class) RETURN c1 { .name, .fqn } as result").get();

    //
    Gson gson = GsonConverter.createGson();

    //
    while (statementResult.hasNext()) {

      Record record = statementResult.next();
      JsonElement json = gson.toJsonTree(record.asMap());
      System.out.println(json);
    }

    //
    StatementResultUtil.dumpStatement(statementResult);
  }

  @Test
  public void test_typeRelationship() throws InterruptedException, ExecutionException {

    //
    StatementResult statementResult = boltClientConnection.getBoltClient()
        .executeCypherQuery("MATCH (c1:Class)-[rel:DEPENDS_ON]->(c2:Class) RETURN rel LIMIT 1").get();

    //
    Gson gson = GsonConverter.createGson();

    //
    while (statementResult.hasNext()) {
      JsonElement json = gson.toJsonTree(statementResult.next().asMap());
      System.out.println(json);
    }

    //
    StatementResultUtil.dumpStatement(statementResult);
  }

  @Test
  public void test_typePath() throws InterruptedException, ExecutionException {

    //
    StatementResult statementResult = boltClientConnection.getBoltClient()
        .executeCypherQuery("MATCH p=(c1:Class)-[rel:DEPENDS_ON]->(c2:Class) RETURN p LIMIT 1").get();

    //
    Gson gson = GsonConverter.createGson();

    //
    while (statementResult.hasNext()) {
      JsonElement json = gson.toJsonTree(statementResult.next().asMap());
      System.out.println(json);
    }

    //
    StatementResultUtil.dumpStatement(statementResult);
  }

  @Test
  public void test_typePropertiesArrays() throws InterruptedException, ExecutionException {

    //
    StatementResult statementResult = boltClientConnection.getBoltClient().executeCypherQuery(
        "MATCH (c:Class {fqn: \"org.mapstruct.ap.internal.model.source.builtin.XmlGregorianCalendarToJodaLocalDate\"}) set c.testArray=[0, 1, 2] RETURN c LIMIT 10")
        .get();

    //
    Gson gson = GsonConverter.createGson();

    //
    while (statementResult.hasNext()) {
      JsonElement json = gson.toJsonTree(statementResult.next().asMap());
      System.out.println(json);
    }

    //
    StatementResultUtil.dumpStatement(statementResult);
  }
}
