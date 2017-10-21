package org.slizaa.neo4j.dbadapter.internal;

import java.lang.reflect.Type;

import org.neo4j.driver.internal.InternalNode;
import org.neo4j.driver.v1.Value;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class InternalNodeAdapter implements JsonSerializer<InternalNode> {

  @Override
  public JsonElement serialize(InternalNode node, Type typeOfSrc, JsonSerializationContext context) {

    // create result
    JsonObject result = new JsonObject();

    // add the id
    result.addProperty("id", node.id());

    // create the labels array
    JsonArray labels = new JsonArray();
    result.add("labels", labels);
    node.labels().forEach(label -> labels.add(label));

    // create the properties object
    JsonObject properties = new JsonObject();
    result.add("properties", properties);
    node.keys().forEach(key -> {
      Value value = node.get(key);
      switch (value.type().name()) {
      case "STRING": {
        properties.addProperty(key, value.asString());
        break;
      }
      case "INTEGER": {
        properties.addProperty(key, value.asInt());
        break;
      }
      case "BOOLEAN": {
        properties.addProperty(key, value.asBoolean());
        break;
      }
      default: {
        properties.addProperty(key, value.asString());
        break;
      }
      }
    });

    // return result
    return result;
  }
}