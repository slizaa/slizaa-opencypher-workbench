package org.slizaa.neo4j.graphdb.testfwk.internal;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.joor.Reflect.on;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.aether.RepositorySystem;
import org.slizaa.neo4j.graphdb.testfwk.TestDB;
import org.slizaa.neo4j.graphdb.testfwk.internal.aether.TransitiveDependenciesResolver;

public class TestNeo4jServerCreatorServiceImpl {

  /** - */
  private Path        _tempDirectoryPath;

  /** - */
  private ClassLoader _classLoader;

  /**
   * <p>
   * </p>
   */
  public void activate() {

    //
    try {
      _tempDirectoryPath = Files.createTempDirectory("TestNeo4jServerCreatorServiceTempDirectory");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    // resolve all required dependencies
    URL[] urls = TransitiveDependenciesResolver.resolve("org.neo4j.test:neo4j-harness:3.2.1");

    //
    List<URL> completeUrls = new ArrayList<>(Arrays.asList(urls));

    // we need this patch in order to set the database directory!
    try {
      String urlAether = RepositorySystem.class.getProtectionDomain().getCodeSource().getLocation().toString();
      String urlPatch = urlAether.replace("aether-api-1.0.2.v20150114.jar",
          "org.slizaa.neo4j.graphdb.testfwk.patch-3.2.1.jar");
      completeUrls.add(new URL(urlPatch));
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    _classLoader = new URLClassLoader(completeUrls.toArray(new URL[0]));
  }

  /**
   * <p>
   * </p>
   */
  public void cleanUp() {

    if (_tempDirectoryPath != null) {
      try {
        FileUtils.delete(_tempDirectoryPath);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

  /**
   * <p>
   * </p>
   *
   * @param databaseDirectory
   * @return
   */
  public AutoCloseable createNeo4jServer(TestDB testDB) {
    checkNotNull(testDB);

    try {

      //
      return TCCLExecuter.execute(_classLoader, () -> {

        //
        AutoCloseable server = on("org.slizaa.neo4j.graphdb.testfwk.patch.ServerStarter", _classLoader)
            .call("startServer", _tempDirectoryPath.getParent().toAbsolutePath().toString(),
                _tempDirectoryPath.getFileName().toString(), unzip(testDB).toString())
            .get();

        //
        return server;
      });

    } catch (Throwable e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * <p>
   * </p>
   *
   * @param testDB
   */
  private File unzip(TestDB testDB) {

    //
    checkNotNull(testDB);

    //
    if (_tempDirectoryPath == null) {
      activate();
    }

    //
    File databaseDirectory = new File(_tempDirectoryPath.toFile(), testDB.getName());

    //
    if (!databaseDirectory.exists()) {
      try (InputStream inputStream = TestNeo4jServerCreatorServiceImpl.class.getResourceAsStream(testDB.getPath())) {
        UnZip.unzip(inputStream, databaseDirectory);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    //
    return databaseDirectory;
  }
}
