package org.slizaa.neo4j.ui.cypherview.internal;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.action.Action;
import org.slizaa.neo4j.ui.cypherview.CypherViewPart;

public final class HandlerOne extends Action {

  @Execute
  public void run(@Named(IServiceConstants.ACTIVE_PART) MPart mPart) {

    CypherViewPart part = (CypherViewPart) mPart.getObject();
    System.out.println("BUMM-DA-DA" + part.getModel());
  }
}