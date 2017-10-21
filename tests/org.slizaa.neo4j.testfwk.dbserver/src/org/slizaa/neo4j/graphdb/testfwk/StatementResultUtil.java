package org.slizaa.neo4j.graphdb.testfwk;

import static com.google.common.base.Preconditions.checkNotNull;

import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Value;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.util.Pair;

public class StatementResultUtil {

  /**
   * <p>
   * </p>
   *
   * @param statementResult
   */
  public static void dumpStatement(StatementResult statementResult) {

    //
    checkNotNull(statementResult);

    // Each Cypher execution returns a stream of records.
    while (statementResult.hasNext()) {

      Record record = statementResult.next();
      // Values can be extracted from a record by index or name.

      for (Pair<String, Value> pair : record.fields()) {

        // System.out.println(pair.value().type().name());

        switch (pair.value().type().name()) {
        case "NODE": {
          System.out.println("-------------------------------");
          System.out.println(pair.key());
          Node node = pair.value().asNode();
          System.out.println("ID: " + node.id());
          for (String label : node.labels()) {
            System.out.print(label + ", ");
          }
          System.out.println();
          for (String key : node.keys()) {
            System.out.println(key + " : " + node.get(key));
          }
          break;
        }
        case "STRING": {
          System.out.println("STRING: " + pair.value().asString());
          break;
        }
        case "INTEGER": {
          System.out.println("INTEGER: " + pair.value().asInt());
          break;
        }
        default:
          break;
        }
      }
    }
  }
}
