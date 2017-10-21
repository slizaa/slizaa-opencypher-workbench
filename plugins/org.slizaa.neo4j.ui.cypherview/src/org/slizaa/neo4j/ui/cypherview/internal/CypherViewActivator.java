package org.slizaa.neo4j.ui.cypherview.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class CypherViewActivator extends AbstractUIPlugin {

  public static final String         ORG_SLIZAA_NEO4J_OPENCYPHER_OPENCYPHER = "org.slizaa.neo4j.opencypher.OpenCypher";

  private static CypherViewActivator INSTANCE;

  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    INSTANCE = this;
  }

  @Override
  public void stop(BundleContext context) throws Exception {
    INSTANCE = null;
    super.stop(context);
  }

  public static CypherViewActivator getInstance() {
    return INSTANCE;
  }
}
