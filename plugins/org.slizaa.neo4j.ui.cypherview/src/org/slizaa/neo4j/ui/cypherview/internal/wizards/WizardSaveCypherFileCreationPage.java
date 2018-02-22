package org.slizaa.neo4j.ui.cypherview.internal.wizards;

import java.io.InputStream;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

public class WizardSaveCypherFileCreationPage extends WizardNewFileCreationPage{

  public WizardSaveCypherFileCreationPage(String pageName, IStructuredSelection selection) {
    super(pageName, selection);
    
    setFileExtension("cypher");
  }

  @Override
  protected InputStream getInitialContents() {
    // TODO Auto-generated method stub
    return super.getInitialContents();
  }
}
