/**
 *
 */
package org.slizaa.neo4j.queryresult.ui.internal;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.function.Consumer;

import org.eclipse.core.runtime.FileLocator;
import org.osgi.framework.Bundle;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class ContentExtractor {

  /**
   * <p>
   * </p>
   *
   * @param bundle
   * @param path
   * @param urlConsumer
   */
  public static void extractContent(Bundle bundle, String path, Consumer<URL> urlConsumer) {

    //
    checkNotNull(bundle);
    checkNotNull(path);

    //
    Enumeration<String> contentEnumeration = bundle.getEntryPaths(path);

    //
    if (contentEnumeration == null) {
      return;
    }

    //
    Collections.list(contentEnumeration).forEach((entry) -> {

      //
      if (entry.endsWith("/")) {
        extractContent(bundle, entry, urlConsumer);
      }

      //
      else {

        //
        try {

          //
          URL fileUrl = FileLocator.toFileURL(bundle.getEntry(entry));

          if (urlConsumer != null) {
            urlConsumer.accept(fileUrl);
          }

        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    });
  }
}
