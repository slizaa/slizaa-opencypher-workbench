package org.slizaa.neo4j.dbadapter;

import org.neo4j.driver.v1.Value;
import org.slizaa.neo4j.dbadapter.internal.InternalValueAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonConverter {

  public static Gson createGson() {
    return new GsonBuilder().disableHtmlEscaping().registerTypeAdapter(Value.class, new InternalValueAdapter())
        .create();
  }
}
