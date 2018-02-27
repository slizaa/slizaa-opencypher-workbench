package org.slizaa.neo4j.queryresult.ui.internal;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.osgi.service.urlconversion.URLConverter;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.slizaa.neo4j.dbadapter.IQueryResultConsumer;

public class QueryResultActivator extends AbstractUIPlugin {

  // The plug-in ID
  public static final String                         PLUGIN_ID = "org.slizaa.neo4j.hierarchicalgraph.mapping.service"; //$NON-NLS-1$

  // The shared instance
  private static QueryResultActivator                _instance;

  /** - */
  private QueryResultViewPart                        _queryResultViewPart;

  /** - */
  private ServiceTracker<URLConverter, URLConverter> _urlConverterServiceTracker;

  /** - */
  private Map<String, String>                        _resolvedUrlCache;

  /**
   * {@inheritDoc}
   */
  @Override
  public void start(BundleContext context) throws Exception {

    //
    super.start(context);

    //
    _urlConverterServiceTracker = new ServiceTracker<URLConverter, URLConverter>(context, URLConverter.class, null);
    _urlConverterServiceTracker.open();

    //
    _resolvedUrlCache = new HashMap<>();

    //
    _instance = this;

    //
    CustomQueryResultConsumer queryResultConsumer = new CustomQueryResultConsumer();
    context.registerService(IQueryResultConsumer.class, queryResultConsumer, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void stop(BundleContext context) throws Exception {

    //
    _instance = null;

    //
    _urlConverterServiceTracker.close();
    _resolvedUrlCache.clear();

    //
    super.stop(context);
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public String getMainUrl() {

    //
    return getCachedUrl("/content/index.html");
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public String getInProgressUrl() {

    //
    return getCachedUrl("/content/spinner/spinner.html");
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public String getErrorUrl() {

    //
    return getCachedUrl("/content/error.html");
  }

  
  /**
   * <p>
   * </p>
   *
   * @return
   */
  public boolean hasQueryResultViewPart() {
    return this._queryResultViewPart != null;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public QueryResultViewPart getQueryResultViewPart() {
    return this._queryResultViewPart;
  }

  /**
   * <p>
   * </p>
   *
   * @param queryResultViewPart
   */
  public void setQueryResultViewPart(QueryResultViewPart queryResultViewPart) {
    this._queryResultViewPart = queryResultViewPart;
  }

  /**
   * Returns the shared instance
   *
   * @return the shared instance
   */
  public static QueryResultActivator getDefault() {
    return _instance;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  private String getCachedUrl(String path) {

    //
    if (!_resolvedUrlCache.containsKey(checkNotNull(path))) {

      //
      URL url = getBundle().getEntry(path);

      try {
        return _urlConverterServiceTracker.getService().toFileURL(url).toExternalForm();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return null;
      }
    }

    //
    return _resolvedUrlCache.get(checkNotNull(path));
  }
}
