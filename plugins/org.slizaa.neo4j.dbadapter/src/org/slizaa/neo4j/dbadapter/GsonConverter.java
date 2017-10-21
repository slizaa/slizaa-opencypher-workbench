package org.slizaa.neo4j.dbadapter;

import org.neo4j.driver.internal.InternalNode;
import org.neo4j.driver.internal.value.NodeValue;
import org.neo4j.driver.v1.types.Node;
import org.slizaa.neo4j.dbadapter.internal.InternalNodeAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonConverter {

  public static Gson createGson() {
    return new GsonBuilder().disableHtmlEscaping().registerTypeAdapter(InternalNode.class, new InternalNodeAdapter()).create();
  }
}
