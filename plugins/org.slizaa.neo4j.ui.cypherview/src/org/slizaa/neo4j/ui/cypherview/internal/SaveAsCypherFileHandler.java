package org.slizaa.neo4j.ui.cypherview.internal;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.slizaa.neo4j.ui.cypherview.CypherViewPart;
import org.slizaa.neo4j.ui.cypherview.internal.wizards.SaveAsCypherFileWizard;

public final class SaveAsCypherFileHandler extends Action {

  @Execute
  public void run(@Named(IServiceConstants.ACTIVE_PART) MPart mPart, final Shell shell) {

    CypherViewPart part = (CypherViewPart) mPart.getObject();

    //
    String model = part.getModel();

    //
    SaveAsCypherFileWizard wizard = new SaveAsCypherFileWizard(model);
    wizard.init(PlatformUI.getWorkbench(), new StructuredSelection());
    WizardDialog dialog = new WizardDialog(shell, wizard);
    dialog.open();
  }
}