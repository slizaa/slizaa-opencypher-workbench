package org.slizaa.neo4j.ui.cypherview;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;
import org.slizaa.neo4j.opencypher.ui.internal.OpencypherActivator;
import org.slizaa.neo4j.ui.cypherview.internal.DbAdapterQueryPanel;

import com.google.inject.Injector;

@SuppressWarnings("restriction")
public class CypherViewPart {

  /** - */
  private DbAdapterQueryPanel       _panel;

  /** - */
  private EmbeddedEditorModelAccess _model;

  @PostConstruct
  public void createComposite(Composite parent) {

    //
    OpencypherActivator activator = OpencypherActivator.getInstance();
    Injector injector = activator.getInjector(OpencypherActivator.ORG_SLIZAA_NEO4J_OPENCYPHER_OPENCYPHER);

    //
    OpenCypherResourceProvider provider = injector.getInstance(OpenCypherResourceProvider.class);
    EmbeddedEditorFactory factory = injector.getInstance(EmbeddedEditorFactory.class);

    //
    _panel = new DbAdapterQueryPanel(parent, () -> {
      return _model.getSerializedModel();
    });

    //
    Composite interim = new Composite(_panel.getEditorArea(), SWT.NONE);
    interim.setLayout(GridLayoutFactory.fillDefaults().extendedMargins(0, 0, 0, 0).margins(0, 0).create());
    EmbeddedEditor editor = factory.newEditor(provider).showErrorAndWarningAnnotations().withParent(interim);
    _model = editor.createPartialEditor();

    // Allow data to be copied or moved to the drop target
    int operations = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT;
    DropTarget target = new DropTarget(editor.getViewer().getControl(), operations);

    // Receive data in Text or File format
    final TextTransfer textTransfer = TextTransfer.getInstance();
    final FileTransfer fileTransfer = FileTransfer.getInstance();
    Transfer[] types = new Transfer[] { fileTransfer, textTransfer };
    target.setTransfer(types);

    // Configuring default font
    StyledText textWidget = editor.getViewer().getTextWidget();
    textWidget.setFont(JFaceResources.getFont(JFaceResources.TEXT_FONT));

    //
    _panel.registerGraphDatabaseClientAdapterAwareOSGiService();
  }

  @PreDestroy
  public void dispose() {

    //
    _panel.unregisterGraphDatabaseClientAdapterAwareOSGiService();
  }
}
