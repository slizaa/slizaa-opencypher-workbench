package org.slizaa.neo4j.ui.cypherview.internal.wizards;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

public class SaveAsCypherFileWizardCreationPage extends WizardNewFileCreationPage {

  /** - */
  private String _initialContent;

  /**
   * <p>
   * Creates a new instance of type {@link SaveAsCypherFileWizardCreationPage}.
   * </p>
   *
   * @param pageName
   * @param selection
   * @param intialContent
   */
  public SaveAsCypherFileWizardCreationPage(String pageName, IStructuredSelection selection, String intialContent) {
    super(pageName, selection);

    //
    _initialContent = checkNotNull(intialContent);

    //
    setFileExtension("cypher");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected InputStream getInitialContents() {
    return new ByteArrayInputStream(_initialContent.getBytes(StandardCharsets.UTF_8));
  }
}
