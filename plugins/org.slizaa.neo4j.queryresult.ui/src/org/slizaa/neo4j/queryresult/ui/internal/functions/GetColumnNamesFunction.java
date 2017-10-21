package org.slizaa.neo4j.queryresult.ui.internal.functions;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;
import java.util.function.Supplier;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

import com.google.gson.GsonBuilder;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class GetColumnNamesFunction extends BrowserFunction {

  /** - */
  private Supplier<List<String>> _columnNameSupplier;

  /**
   * <p>
   * Creates a new instance of type {@link GetColumnNamesFunction}.
   * </p>
   *
   * @param browser
   */
  public GetColumnNamesFunction(Browser browser, Supplier<List<String>> columnNameSupplier) {
    super(browser, "getColumnNames");

    _columnNameSupplier = checkNotNull(columnNameSupplier);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object function(Object[] arguments) {
    return new GsonBuilder().disableHtmlEscaping().create().toJson(_columnNameSupplier.get());
  }
}