package org.slizaa.neo4j.graphdb.testfwk.internal;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import org.slizaa.scanner.core.api.graphdb.IGraphDb;
import org.slizaa.scanner.core.api.graphdb.IGraphDbFactory;
import org.slizaa.scanner.services.mvnresolver.MvnResolverServiceFactory;
import org.slizaa.scanner.services.mvnresolver.api.MvnResolverService;

public class Main {

  public static void main(String[] args)
      throws Exception {

    //
    MvnResolverService mvnResolverService = MvnResolverServiceFactory.createNewResolverService();
    File[] files = mvnResolverService
        .resolve("org.slizaa.scanner.neo4j:org.slizaa.scanner.neo4j.graphdbfactory:1.0.0-SNAPSHOT");

    List<URL> urls = new ArrayList<>(files.length);

    for (File file : files) {
      urls.add(file.toURI().toURL());
    }

    URLClassLoader classLoader = new URLClassLoader(urls.toArray(new URL[0]));
    Class<?> clazz = classLoader.loadClass("org.slizaa.scanner.neo4j.graphdbfactory.GraphDbFactory");

    System.out.println(clazz);

    IGraphDbFactory graphDbFactory = (IGraphDbFactory) clazz.newInstance();

    try (IGraphDb graphDb = graphDbFactory.newGraphDb(5001, new File("c:\\tempa")).create()) {
      System.out.println("JIPPIE: " + graphDb);
    }
  }
}
