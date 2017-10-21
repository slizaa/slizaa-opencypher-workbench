package org.slizaa.neo4j.ui.cypherview.internal;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.action.Action;

public final class HandlerOne extends Action {

  @Execute
  public void run() {
    System.out.println("BUMM-DA-DA");
  }
}