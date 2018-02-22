package org.slizaa.neo4j.ui.cypherview.internal;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.newresource.BasicNewFileResourceWizard;
import org.slizaa.neo4j.ui.cypherview.CypherViewPart;
import org.slizaa.neo4j.ui.cypherview.internal.wizards.SaveCypherFileResourceWizard;

public final class HandlerOne extends Action {

  @Execute
  public void run(@Named(IServiceConstants.ACTIVE_PART) MPart mPart, final Shell shell) {

    CypherViewPart part = (CypherViewPart) mPart.getObject();
    System.out.println("BUMM-DA-DA" + part.getModel());

    SaveCypherFileResourceWizard wizard = new SaveCypherFileResourceWizard();
    wizard.init(PlatformUI.getWorkbench(), new StructuredSelection());
    WizardDialog dialog = new WizardDialog(shell, wizard);
    dialog.open();
  }
}