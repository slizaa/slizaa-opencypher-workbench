package org.slizaa.neo4j.graphdb.testfwk.internal;

import static org.joor.Reflect.on;

import java.io.IOException;
import java.net.URI;

import org.slizaa.neo4j.graphdb.testfwk.TestDB;

public class Neo4jServerStarter {

  public static void main(String[] args) throws Exception {

    // start the test jqa server
    TestNeo4jServerCreatorServiceImpl service = new TestNeo4jServerCreatorServiceImpl();
    service.activate();

    //
    try (AutoCloseable server = service.createNeo4jServer(TestDB.MAPSTRUCT)) {

      //
      System.out.println("graph database server started (" + (URI) on(server).call("boltURI").get() + ").");

      //
      promptEnterKey();

      //
      System.out.println("Shutting down graph database server...");
    }

    // deactivate
    service.cleanUp();

    //
    System.out.println("Done!");
  }

  /**
   * <p>
   * </p>
   * 
   * @throws IOException
   */
  private static void promptEnterKey() throws IOException {
    System.out.println("Press \"ENTER\" to continue...");
    while (System.in.available() == 0) {
      // Do whatever you want
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        //
      }
    }
  }
}
