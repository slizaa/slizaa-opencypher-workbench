package org.slizaa.neo4j.graphdb.testfwk;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.junit.rules.ExternalResource;
import org.slizaa.scanner.core.api.graphdb.IGraphDb;
import org.slizaa.scanner.core.api.graphdb.IGraphDbFactory;
import org.slizaa.scanner.core.mvnresolver.MvnResolverServiceFactoryFactory;
import org.slizaa.scanner.core.mvnresolver.api.IMvnResolverService;

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
    this._testDB = checkNotNull(testDB);
    this._port = port;
  }

  @Override
  protected void before() throws Throwable {

    //
    this._tempParentDirectoryPath = Files.createTempDirectory("TestNeo4jServerCreatorServiceTempDirectory");

    //
    File databaseDirectory = unzipDatabase(this._testDB, this._tempParentDirectoryPath);

    //
    this._graphDatabase = createGraphDb(this._port, databaseDirectory);
  }

  @Override
  protected void after() {

    //
    try {
      this._graphDatabase.close();
    } catch (Exception e) {
      //
    }

    //
    if (this._tempParentDirectoryPath != null) {
      try {
        delete(this._tempParentDirectoryPath);
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
        unzip(inputStream, databaseDirectory);
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
    IMvnResolverService mvnResolverService = MvnResolverServiceFactoryFactory.createNewResolverServiceFactory()
        .newMvnResolverService().withDefaultRemoteRepository()
        .withRemoteRepository("ossrh", "https://oss.sonatype.org/content/repositories/snapshots").create();

    File[] files = mvnResolverService
        .resolve("org.slizaa.scanner.neo4j:org.slizaa.scanner.neo4j.graphdbfactory:1.0.0-SNAPSHOT");

    //
    List<URL> urls = new ArrayList<>(files.length);
    for (File file : files) {
      if (file.getName().contains("org.slizaa.scanner.core.spi-api")) {
        continue;
      }
      urls.add(file.toURI().toURL());
    }

    //
    this._classLoader = new URLClassLoader(urls.toArray(new URL[0]),
        PredefinedGraphDatabaseRule.class.getClassLoader());
    Class<?> clazz = this._classLoader.loadClass("org.slizaa.scanner.neo4j.graphdbfactory.internal.GraphDbFactory");

    //
    ClassLoader oldClassLoader = Thread.currentThread().getContextClassLoader();
    try {

      Thread.currentThread().setContextClassLoader(this._classLoader);

      //
      IGraphDbFactory graphDbFactory = (IGraphDbFactory) clazz.newInstance();

      // create new GraphDb
      return graphDbFactory.newGraphDb(port, databaseDir).create();
    }

    // don't forget to reset the old class loader
    finally {

      //
      Thread.currentThread().setContextClassLoader(oldClassLoader);
    }
  }

  /**
   * <p>
   * </p>
   *
   * @param path
   * @throws IOException
   */
  private static void delete(Path path) throws IOException {

    //
    Files.walkFileTree(path, new SimpleFileVisitor<Path>() {

      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Files.delete(file);
        return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        Files.delete(dir);
        return FileVisitResult.CONTINUE;
      }

    });
  }

  private static void unzip(InputStream inputStream, File folder) {

    checkNotNull(inputStream);
    checkNotNull(folder);

    byte[] buffer = new byte[1024];

    try {

      // create output directory is not exists
      if (!folder.exists()) {
        folder.mkdir();
      }

      // get the zip file content
      try (ZipInputStream zis = new ZipInputStream(inputStream)) {
        // get the zipped file list entry
        ZipEntry ze = zis.getNextEntry();

        while (ze != null) {

          if (!ze.isDirectory()) {

            String fileName = ze.getName();
            File newFile = new File(folder + File.separator + fileName);

            // create all non exists folders
            // else you will hit FileNotFoundException for compressed folder
            new File(newFile.getParent()).mkdirs();

            try (FileOutputStream fos = new FileOutputStream(newFile)) {
              int len;
              while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
              }
            }
          }
          ze = zis.getNextEntry();
        }

        zis.closeEntry();
        zis.close();
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
