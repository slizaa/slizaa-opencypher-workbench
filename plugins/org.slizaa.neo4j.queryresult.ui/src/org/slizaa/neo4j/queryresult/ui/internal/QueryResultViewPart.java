/*******************************************************************************
 * Copyright (c) Gerd W�therich 2012-2016. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *
 * Contributors: Gerd Wuetherich (gerd@gerd-wuetherich.de) - initial API and implementation
 ******************************************************************************/
package org.slizaa.neo4j.queryresult.ui.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.menu.MDirectToolItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuFactory;
import org.eclipse.e4.ui.model.application.ui.menu.MToolBar;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.exceptions.Neo4jException;
import org.slizaa.neo4j.dbadapter.GsonConverter;
import org.slizaa.neo4j.queryresult.ui.internal.action.CleanQueryResultHandler;
import org.slizaa.neo4j.queryresult.ui.internal.functions.GetColumnNamesAsJsonFunction;
import org.slizaa.neo4j.queryresult.ui.internal.functions.GetRecordsAsJsonFunction;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class QueryResultViewPart {

  /** - */
  public static final String PART_ID = QueryResultViewPart.class.getName();

  /** - */
  private Browser            _browser;

  /** - */
  private List<String>       _columnNames;

  /** - */
  private JsonArray          _records;

  /** - */
  // private ServiceRegistration<IQueryResultConsumer> _serviceRegistration;

  /**
   * <p>
   * </p>
   *
   * @param parent
   */
  @PostConstruct
  public void createComposite(Composite parent, MPart mPart) {

    //
    this._columnNames = new ArrayList<>();

    // create the toolbar entries
    MToolBar toolbar = MMenuFactory.INSTANCE.createToolBar();
    MDirectToolItem element = MMenuFactory.INSTANCE.createDirectToolItem();
    element.setElementId("myToolItemId");
    element.setIconURI("platform:/plugin/org.slizaa.neo4j.queryresult.ui/icons/remove.png");
    element
        .setContributionURI("bundleclass://org.slizaa.neo4j.queryresult.ui/" + CleanQueryResultHandler.class.getName());
    element.setVisible(true);
    element.setEnabled(true);

    toolbar.getChildren().add(element);
    mPart.setToolbar(toolbar);

    //
    GridLayout layout = new GridLayout(1, false);
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    parent.setLayout(layout);

    this._browser = new Browser(parent, SWT.NONE);
    GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
    this._browser.setLayoutData(gridData);
    this._browser.setUrl(Activator.getDefault().getMainUrl());
    // _browser.addControlListener(new ControlAdapter() {
    //
    // @Override
    // public void controlResized(ControlEvent e) {
    // System.out.println("resized");
    // _browser.refresh();
    // }
    // });

    //
    new GetColumnNamesAsJsonFunction(this._browser, () -> this._columnNames);
    new GetRecordsAsJsonFunction(this._browser, () -> this._records);

    //
    Activator.getDefault().setQueryResultViewPart(this);
  }

  @PreDestroy
  public void dispose() {

    //
    Activator.getDefault().setQueryResultViewPart(null);
  }

  /**
   * <p>
   * </p>
   */
  public void handleQueryStarted() {

    // set the current result to null
    this._records = null;
    this._columnNames.clear();

    //
    Display.getDefault().syncExec(() -> this._browser.setUrl(Activator.getDefault().getInProgressUrl()));
  }

  /**
   * <p>
   * </p>
   *
   * @param cypherQuery
   * @param result
   */
  public void handleQueryResultReceived(String cypherQuery, StatementResult statementResult) {

    //
    this._columnNames = new ArrayList<>(statementResult.keys());

    Gson gson = GsonConverter.createGson();

    //
    this._records = new JsonArray();
    while (statementResult.hasNext()) {
      Record record = statementResult.next();
      Map<String, Object> map = record.asMap();
      JsonElement json = gson.toJsonTree(map);
      this._records.add(json);
    }

    //
    Display.getDefault().syncExec(() -> {
      this._browser.setUrl(Activator.getDefault().getMainUrl());
    });
  }

  /**
   * <p>
   * </p>
   *
   * @param cypherQuery
   * @param result
   * @param exception
   */
  public void handleError(String cypherQuery, StatementResult result, Neo4jException exception) {
    System.out.println("TODO: Handle error!!");
  }

  /**
   * <p>
   * </p>
   */
  public void clean() {

    //
    this._columnNames = null;
    this._records = null;

    //
    Display.getDefault().syncExec(() -> {
      try {
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
            .showView("org.slizaa.neo4j.queryresult.ui.QueryResultViewPart");
      } catch (PartInitException e) {
        // do nothing
      }
      this._browser.setUrl(Activator.getDefault().getMainUrl());
    });
  }

}
