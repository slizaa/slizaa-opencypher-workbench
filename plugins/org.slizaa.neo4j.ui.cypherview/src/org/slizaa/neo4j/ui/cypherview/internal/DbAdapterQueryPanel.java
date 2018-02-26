package org.slizaa.neo4j.ui.cypherview.internal;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.function.Supplier;

import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceRegistration;
import org.slizaa.neo4j.dbadapter.INeo4jClientListener;
import org.slizaa.neo4j.dbadapter.Neo4jClient;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class DbAdapterQueryPanel extends Composite implements INeo4jClientListener {

  /** - */
  private Text                    _activeDatabaseLabel;

  /** - */
  private Neo4jClient             _boltClient;

  /** - */
  private Composite               _panel;

  /** - */
  private ServiceRegistration<?>  _serviceRegistration;

  /** - */
  private CommandContributionItem _item;

  /**
   * <p>
   * Creates a new instance of type {@link DbAdapterQueryPanel}.
   * </p>
   *
   * @param parent
   * @param cypherQuerySupplier
   */
  public DbAdapterQueryPanel(Composite parent, Supplier<String> cypherQuerySupplier) {
    super(parent, SWT.NONE);

    //
    checkNotNull(cypherQuerySupplier);

    this.setLayout(GridLayoutFactory.fillDefaults().equalWidth(false).numColumns(1).margins(0, 0).create());

    createQueryComposite(this, cypherQuerySupplier);

    _panel = new Composite(this, SWT.NONE);
    _panel.setLayout(new FillLayout());
    _panel.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public Neo4jClient getBoltClient() {
    return _boltClient;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public Composite getEditorArea() {
    return _panel;
  }

  @Override
  public void neo4jClientAdded(Neo4jClient client) {

    setBoltClient(client);

  }

  @Override
  public void neo4jClientRemoved(Neo4jClient adapter) {
    // TODO Auto-generated method stub

  }

  /**
   * <p>
   * </p>
   */
  public void registerGraphDatabaseClientAdapterAwareOSGiService() {

    // register as OSGi service
    try {
      _serviceRegistration = FrameworkUtil.getBundle(DbAdapterQueryPanel.class).getBundleContext()
          .registerService(new String[] { INeo4jClientListener.class.getName() }, this, null);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * <p>
   * </p>
   */
  public void unregisterGraphDatabaseClientAdapterAwareOSGiService() {

    if (_serviceRegistration != null) {
      // deregister as OSGi service
      _serviceRegistration.unregister();
    }
  }

  /**
   * <p>
   * </p>
   *
   * @param parent
   */
  private void createQueryComposite(Composite parent, Supplier<String> cypherQuerySupplier) {

    //
    Composite composite = new Composite(parent, SWT.NONE);
    GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 5;
    gridLayout.makeColumnsEqualWidth = false;
    composite.setLayout(gridLayout);
    composite.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));

    //
    Label label = new Label(composite, SWT.NO_BACKGROUND);
    label.setText("Query against:");
    label.setAlignment(SWT.RIGHT);
    label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, true));

    //
    _activeDatabaseLabel = new Text(composite, SWT.NONE);
    _activeDatabaseLabel.setEditable(false);
    // TODO!!
    // _activeDatabaseLabel.setBackground(CustomOpenCypherActivator.getCustomOpenCypherActivator().getLightGray());
    GridData gridData = new GridData(30 * 10, SWT.DEFAULT);
    _activeDatabaseLabel.setLayoutData(gridData);

    //
    ToolBar toolBar = new ToolBar(composite, SWT.FLAT);
    toolBar.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true));

    //
    IWorkbench wb = PlatformUI.getWorkbench();
    IWorkbenchWindow win = wb.getActiveWorkbenchWindow();

    CommandContributionItemParameter param = new CommandContributionItemParameter(win, "myCommand",
        "org.slizaa.neo4j.ui.cypherview.executeCypherQuery", CommandContributionItem.STYLE_PUSH);
    param.icon = OpenCypherUiImages.EXECUTE_QUERY.getImageDescriptor();
    param.mode = 0;
    param.style = CommandContributionItem.STYLE_PUSH;
    _item = new CommandContributionItem(param);
    _item.fill(toolBar, -1);

    // _executeAction = new ToolItem(toolBar, SWT.PUSH);
    // _executeAction.setEnabled(false);
    // _executeAction.setImage(OpenCypherUiImages.EXECUTE_QUERY.getImage());
    // _executeAction.addSelectionListener(new SelectionListener() {
    // @Override
    // public void widgetSelected(SelectionEvent e) {
    //
    // String cypherString = cypherQuerySupplier.get();
    //
    // if (_queryResultConsumers.size() == 0) {
    // return;
    // }
    //
    // if (_boltClient != null) {
    // _executeAction.setEnabled(false);
    // try {
    //
    // //
    // final Future<?> future = _boltClient.executeCypherQuery(cypherString, _queryResultConsumers.get(0));
    // new Thread(() -> {
    // try {
    // while (!(future.isDone() || future.isCancelled())) {
    // Thread.sleep(500);
    // }
    // } catch (Exception exception) {
    // exception.printStackTrace();
    // } finally {
    // Display.getDefault().syncExec(() -> _executeAction.setEnabled(true));
    // }
    // }).start();
    //
    // } catch (Exception exception) {
    // _executeAction.setEnabled(true);
    // }
    // }
    //
    // }
    //
    // @Override
    // public void widgetDefaultSelected(SelectionEvent e) {
    // //
    // }
    // });
  }

  /**
   * <p>
   * </p>
   *
   * @param client
   */
  private void setBoltClient(Neo4jClient client) {

    //
    if (isDisposed()) {
      return;
    }

    // set the bolt client
    _boltClient = client;

    // update ui
    Display.getDefault().syncExec(() -> {
      if (_boltClient != null) {
        _activeDatabaseLabel.setText(_boltClient.getName());
      } else {
        _activeDatabaseLabel.setText("");
      }

      //
      _item.isEnabled();
    });
  }
}
