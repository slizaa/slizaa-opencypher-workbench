/**
 *
 */
package org.slizaa.neo4j.dbadapter.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.ExecutionException;

import org.junit.ClassRule;
import org.junit.Test;
import org.neo4j.driver.v1.StatementResult;
import org.slizaa.neo4j.dbadapter.GsonConverter;
import org.slizaa.neo4j.graphdb.testfwk.BoltClientConnectionRule;
import org.slizaa.neo4j.graphdb.testfwk.PredefinedGraphDatabaseRule;
import org.slizaa.neo4j.graphdb.testfwk.TestDB;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

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

  /**
   * <p>
   * </p>
   *
   * @throws InterruptedException
   * @throws ExecutionException
   */
  @Test
  public void test_typeNode() throws InterruptedException, ExecutionException {

    //
    JsonObject jsonObject = getSingleResultRecordAsJson("MATCH (c1:Class) RETURN c1 LIMIT 1").getAsJsonObject()
        .get("c1").getAsJsonObject();

    //
    assertThat(jsonObject.entrySet()).hasSize(4);

    //
    assertThat(jsonObject.has("id"));
    assertThat(jsonObject.get("id").getAsLong()).isEqualTo(5);
    assertThat(jsonObject.has("labels"));
    assertThat(jsonObject.get("labels").getAsJsonArray().toString()).isEqualTo("[\"Type\",\"Class\"]");
    assertThat(jsonObject.has("properties"));

    assertThat(jsonObject.has("__type"));
    assertThat(jsonObject.get("__type").getAsString()).isEqualTo("NODE");

    // {"id":5,
    // "labels":["Type","Class"],
    // "properties":{"name":"Mappers","fqn":"org.mapstruct.factory.Mappers","sourceFileName":"Mappers.java","classVersion":"50","visibility":"public"},
    // "__type":"NODE"}
  }

  /**
   * <p>
   * </p>
   *
   * @throws InterruptedException
   * @throws ExecutionException
   */
  @Test
  public void test_typeRelationship() throws InterruptedException, ExecutionException {

    //
    JsonObject jsonObject = getSingleResultRecordAsJson(
        "MATCH (c1:Class)-[rel:DEPENDS_ON]->(c2:Class) RETURN rel LIMIT 1").getAsJsonObject().get("rel")
            .getAsJsonObject();

    //
    assertThat(jsonObject.entrySet()).hasSize(6);

    //
    assertThat(jsonObject.has("id"));
    assertThat(jsonObject.get("id").getAsLong()).isEqualTo(166994l);
    assertThat(jsonObject.has("start"));
    assertThat(jsonObject.get("start").getAsLong()).isEqualTo(1076l);
    assertThat(jsonObject.has("end"));
    assertThat(jsonObject.get("end").getAsLong()).isEqualTo(486l);
    assertThat(jsonObject.has("type"));
    assertThat(jsonObject.get("type").getAsString()).isEqualTo("DEPENDS_ON");
    assertThat(jsonObject.has("properties"));
    assertThat(jsonObject.get("properties").getAsJsonObject().get("derived").getAsBoolean()).isTrue();

    assertThat(jsonObject.has("__type"));
    assertThat(jsonObject.get("__type").getAsString()).isEqualTo("RELATIONSHIP");
  }

  @Test
  public void test_typePath() throws InterruptedException, ExecutionException {

    //
    JsonObject jsonObject = getSingleResultRecordAsJson(
        "MATCH p=(c1:Class)-[rel:DEPENDS_ON]->(c2:Class) RETURN p LIMIT 1").getAsJsonObject().get("p")
            .getAsJsonObject();

    //
    assertThat(jsonObject.entrySet()).hasSize(4);

    //
    assertThat(jsonObject.has("nodes"));
    assertThat(jsonObject.get("nodes").getAsJsonArray()).hasSize(2);
    assertThat(jsonObject.has("relationships"));
    assertThat(jsonObject.get("relationships").getAsJsonArray()).hasSize(1);
    assertThat(jsonObject.has("segments"));
    assertThat(jsonObject.get("segments").getAsJsonArray()).hasSize(1);

    assertThat(jsonObject.has("__type"));
    assertThat(jsonObject.get("__type").getAsString()).isEqualTo("PATH");

    System.out.println(jsonObject);
    // {"nodes":[{"id":1076,"labels":["Type","Class"],"properties":{"name":"BuiltInMappingMethods","fqn":"org.mapstruct.ap.internal.model.source.builtin.BuiltInMappingMethods","sourceFileName":"BuiltInMappingMethods.java","classVersion":"50","visibility":"public"},"__type":"NODE"},{"id":486,"labels":["Type","Class"],"properties":{"name":"StringToXmlGregorianCalendar","fqn":"org.mapstruct.ap.internal.model.source.builtin.StringToXmlGregorianCalendar","sourceFileName":"StringToXmlGregorianCalendar.java","classVersion":"50","visibility":"public"},"__type":"NODE"}],"relationships":[{"id":166994,"start":1076,"end":486,"type":"DEPENDS_ON","properties":{"derived":true},"__type":"RELATIONSHIP"}],"segments":[{"start":{"id":1076,"labels":["Type","Class"],"properties":{"name":"BuiltInMappingMethods","fqn":"org.mapstruct.ap.internal.model.source.builtin.BuiltInMappingMethods","sourceFileName":"BuiltInMappingMethods.java","classVersion":"50","visibility":"public"},"__type":"NODE"},"relationship":{"id":166994,"start":1076,"end":486,"type":"DEPENDS_ON","properties":{"derived":true},"__type":"RELATIONSHIP"},"end":{"id":486,"labels":["Type","Class"],"properties":{"name":"StringToXmlGregorianCalendar","fqn":"org.mapstruct.ap.internal.model.source.builtin.StringToXmlGregorianCalendar","sourceFileName":"StringToXmlGregorianCalendar.java","classVersion":"50","visibility":"public"},"__type":"NODE"}}],"__type":"PATH"}
  }

  /**
   * <p>
   * </p>
   *
   * @return
   * @throws InterruptedException
   * @throws ExecutionException
   */
  private JsonElement getSingleResultRecordAsJson(String query) throws InterruptedException, ExecutionException {

    //
    StatementResult statementResult = boltClientConnection.getBoltClient().executeCypherQuery(query).get();

    //
    Gson gson = GsonConverter.createGson();

    //
    if (statementResult.hasNext()) {
      return gson.toJsonTree(statementResult.next().asMap());
    }

    throw new AssertionError();
  }

  // @Test
  // public void test_typeMap() throws InterruptedException, ExecutionException {
  //
  // //
  // StatementResult statementResult = boltClientConnection.getBoltClient()
  // .executeCypherQuery("MATCH (c1:Class)-[rel:DEPENDS_ON]->(c2:Class) RETURN c1 { .name, .fqn } as result").get();
  //
  // //
  // Gson gson = GsonConverter.createGson();
  //
  // //
  // while (statementResult.hasNext()) {
  //
  // Record record = statementResult.next();
  // JsonElement json = gson.toJsonTree(record.asMap());
  // System.out.println(json);
  // }
  // }

  //
  // @Test
  // public void test_typePropertiesArrays() throws InterruptedException, ExecutionException {
  //
  // //
  // StatementResult statementResult = boltClientConnection.getBoltClient().executeCypherQuery(
  // "MATCH (c:Class {fqn: \"org.mapstruct.ap.internal.model.source.builtin.XmlGregorianCalendarToJodaLocalDate\"}) set
  // c.testArray=[0, 1, 2] RETURN c LIMIT 10")
  // .get();
  //
  // //
  // Gson gson = GsonConverter.createGson();
  //
  // //
  // while (statementResult.hasNext()) {
  // JsonElement json = gson.toJsonTree(statementResult.next().asMap());
  // System.out.println(json);
  // }
  //
  // //
  // StatementResultUtil.dumpStatement(statementResult);
  // }
}
