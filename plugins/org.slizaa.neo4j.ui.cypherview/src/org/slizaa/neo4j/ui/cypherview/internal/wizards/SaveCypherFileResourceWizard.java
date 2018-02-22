package org.slizaa.neo4j.ui.cypherview.internal.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.internal.ide.DialogUtil;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

public class SaveCypherFileResourceWizard extends BasicNewResourceWizard {

  /**
   * The wizard id for creating new files in the workspace.
   * 
   * @since 3.4
   */
  public static final String        WIZARD_ID = "org.eclipse.ui.wizards.new.file"; //$NON-NLS-1$

  private WizardNewFileCreationPage mainPage;

  /**
   * Creates a wizard for creating a new file resource in the workspace.
   */
  public SaveCypherFileResourceWizard() {
    super();
  }

  @Override
  public void addPages() {
    super.addPages();
    mainPage = new WizardSaveCypherFileCreationPage("newFilePage1", getSelection());//$NON-NLS-1$
    mainPage.setTitle("File");
    mainPage.setDescription("Create a new file resource.");
    addPage(mainPage);
  }

  @Override
  public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
    super.init(workbench, currentSelection);
    setWindowTitle("New File");
    setNeedsProgressMonitor(true);
  }

  @Override
  protected void initializeDefaultPageImageDescriptor() {
    ImageDescriptor desc = IDEWorkbenchPlugin.getIDEImageDescriptor("wizban/newfile_wiz.png");//$NON-NLS-1$
    setDefaultPageImageDescriptor(desc);
  }

  @Override
  public boolean performFinish() {
    IFile file = mainPage.createNewFile();
    if (file == null) {
      return false;
    }

    selectAndReveal(file);

    // Open editor on new file.
    IWorkbenchWindow dw = getWorkbench().getActiveWorkbenchWindow();
    try {
      if (dw != null) {
        IWorkbenchPage page = dw.getActivePage();
        if (page != null) {
          IDE.openEditor(page, file, true);
        }
      }
    } catch (PartInitException e) {
      DialogUtil.openError(dw.getShell(), "Problems Opening Editor", e.getMessage(), e);
    }

    return true;
  }
}
