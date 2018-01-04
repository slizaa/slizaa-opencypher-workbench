package org.slizaa.neo4j.queryresult.ui.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.slizaa.neo4j.dbadapter.IQueryResultConsumer;

public class Activator extends AbstractUIPlugin {

  // The plug-in ID
  public static final String  PLUGIN_ID = "org.slizaa.neo4j.hierarchicalgraph.mapping.service"; //$NON-NLS-1$

  // The shared instance
  private static Activator    plugin;

  /** - */
  private String              _mainUrl;

  /** - */
  private String              _inProgressUrl;

  /** - */
  private QueryResultViewPart _queryResultViewPart;

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public String getMainUrl() {
    return this._mainUrl;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public String getInProgressUrl() {
    return this._inProgressUrl;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    plugin = this;

    //
    Bundle bundle = context.getBundle();

    // extract content
    ContentExtractor.extractContent(bundle, "content/", u -> {
      if (u.getFile().endsWith("index.html")) {
        this._mainUrl = u.toExternalForm();
      } else if (u.getFile().endsWith("spinner.html")) {
        this._inProgressUrl = u.toExternalForm();
      }
    });

    //
    if (this._mainUrl == null) {
      throw new RuntimeException("Missing resource '/content/index.html'.");
    }

    //
    CustomQueryResultConsumer queryResultConsumer = new CustomQueryResultConsumer();
    context.registerService(IQueryResultConsumer.class, queryResultConsumer, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void stop(BundleContext context) throws Exception {
    plugin = null;
    super.stop(context);
  }

  public boolean hasQueryResultViewPart() {
    return this._queryResultViewPart != null;
  }

  public QueryResultViewPart getQueryResultViewPart() {
    return this._queryResultViewPart;
  }

  public void setQueryResultViewPart(QueryResultViewPart queryResultViewPart) {
    this._queryResultViewPart = queryResultViewPart;
  }

  /**
   * Returns the shared instance
   *
   * @return the shared instance
   */
  public static Activator getDefault() {
    return plugin;
  }
}
