/**
 *
 */
package org.slizaa.neo4j.graphdb.testfwk.internal;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.neo4j.driver.v1.StatementResult;
import org.slizaa.neo4j.dbadapter.GsonConverter;
import org.slizaa.neo4j.dbadapter.Neo4jClient;
import org.slizaa.neo4j.graphdb.testfwk.BoltClientConnectionRule;

import com.google.gson.Gson;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 *
 */
public class BoltClientMain extends BoltClientConnectionRule {

  /**
   * <p>
   * Creates a new instance of type {@link BoltClientMain}.
   * </p>
   *
   * @param host
   * @param port
   */
  public BoltClientMain(String host, int port) {
    super(host, port);
  }

  /**
   * <p>
   * </p>
   *
   * @param args
   * @throws Throwable
   */
  public static void main(String[] args) throws Throwable {

    //
    BoltClientMain connectionRule = new BoltClientMain("localhost", 5001);
    connectionRule.before();

    //
    Neo4jClient neo4jClient = connectionRule.getBoltClient();
    neo4jClient.connect();

    Scanner scanner = new Scanner(System.in);
    boolean terminate = false;

    //
    while (!terminate) {
      System.out.print(">");

      String query = scanner.nextLine();

      try {

        Future<StatementResult> resultFuture = neo4jClient.executeCypherQuery(query);
        StatementResult result = resultFuture.get();

        System.out.println(result);

        //
        result.forEachRemaining(record -> {

          System.out.println(record.get(0).asRelationship());

          Gson gson = GsonConverter.createGson();

          Map<String, Object> resultMap = record.asMap();
          for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
            System.out.println(gson.toJson(entry.getValue()));
          }
        });
      }
      //
      catch (ExecutionException exception) {
        System.out.println(exception.getCause().getMessage());
      }
    }
  }
}
