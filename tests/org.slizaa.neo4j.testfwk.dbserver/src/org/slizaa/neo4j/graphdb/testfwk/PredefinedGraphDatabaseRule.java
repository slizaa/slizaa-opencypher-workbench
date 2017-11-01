package org.slizaa.neo4j.graphdb.testfwk;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.rules.ExternalResource;
import org.slizaa.neo4j.graphdb.testfwk.internal.FileUtils;
import org.slizaa.neo4j.graphdb.testfwk.internal.UnZip;
import org.slizaa.scanner.core.api.graphdb.IGraphDb;
import org.slizaa.scanner.core.api.graphdb.IGraphDbFactory;
import org.slizaa.scanner.services.mvnresolver.MvnResolverServiceFactory;
import org.slizaa.scanner.services.mvnresolver.api.MvnResolverService;

public class PredefinedGraphDatabaseRule extends ExternalResource {

  /** - */
  private TestDB      _testDB;

  /** - */
  private int         _port;

  /** - */
  private Path        _tempParentDirectoryPath;

  /** - */
  private IGraphDb    _graphDatabase;

  /** - */
  private ClassLoader _classLoader;

  /**
   * <p>
   * Creates a new instance of type {@link PredefinedGraphDatabaseRule}.
   * </p>
   *
   * @param testDB
   */
  public PredefinedGraphDatabaseRule(TestDB testDB, int port) {
    _testDB = checkNotNull(testDB);
    _port = port;
  }

  @Override
  protected void before() throws Throwable {

    //
    _tempParentDirectoryPath = Files.createTempDirectory("TestNeo4jServerCreatorServiceTempDirectory");

    //
    File databaseDirectory = unzipDatabase(_testDB, _tempParentDirectoryPath);

    //
    _graphDatabase = createGraphDb(_port, databaseDirectory);
  }

  @Override
  protected void after() {

    //
    try {
      _graphDatabase.close();
    } catch (Exception e) {
      //
    }

    //
    if (_tempParentDirectoryPath != null) {
      try {
        FileUtils.delete(_tempParentDirectoryPath);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

  private File unzipDatabase(TestDB testDB, Path parentDirectory) {

    //
    checkNotNull(testDB);
    checkNotNull(parentDirectory);

    //
    File databaseDirectory = new File(parentDirectory.toFile(), testDB.getName());

    //
    if (!databaseDirectory.exists()) {
      try (InputStream inputStream = PredefinedGraphDatabaseRule.class.getResourceAsStream(testDB.getPath())) {
        UnZip.unzip(inputStream, databaseDirectory);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    //
    return databaseDirectory;
  }

  /**
   * <p>
   * </p>
   */
  private IGraphDb createGraphDb(int port, File databaseDir)
      throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

    //
    MvnResolverService mvnResolverService = MvnResolverServiceFactory.createNewResolverService();
    File[] files = mvnResolverService
        .resolve("org.slizaa.scanner.neo4j:org.slizaa.scanner.neo4j.graphdbfactory:1.0.0-SNAPSHOT");

    //
    List<URL> urls = new ArrayList<>(files.length);
    for (File file : files) {
      urls.add(file.toURI().toURL());
    }

    //
    _classLoader = new URLClassLoader(urls.toArray(new URL[0]));
    Class<?> clazz = _classLoader.loadClass("org.slizaa.scanner.neo4j.graphdbfactory.GraphDbFactory");

    //
    IGraphDbFactory graphDbFactory = (IGraphDbFactory) clazz.newInstance();

    // create new GraphDb
    return graphDbFactory.newGraphDb(port, databaseDir).create();
  }
}
