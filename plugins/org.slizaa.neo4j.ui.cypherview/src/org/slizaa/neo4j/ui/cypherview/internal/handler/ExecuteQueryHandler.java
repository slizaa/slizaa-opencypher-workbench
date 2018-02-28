package org.slizaa.neo4j.ui.cypherview.internal.handler;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.slizaa.neo4j.dbadapter.IQueryResultConsumer;
import org.slizaa.neo4j.ui.cypherview.CypherViewPart;
import org.slizaa.neo4j.ui.cypherview.internal.osgi.CypherViewActivator;

public class ExecuteQueryHandler extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    execute();
    return null;
  }

  @CanExecute
  @Override
  public boolean isEnabled() {
    return CypherViewActivator.getInstance().getCurrentCypherViewPart() != null
        && CypherViewActivator.getInstance().getCurrentCypherViewPart().getBoltClient() != null;
  }

  @Execute
  public void execute() {

    //
    CypherViewPart cypherViewPart = CypherViewActivator.getInstance().getCurrentCypherViewPart();

    List<IQueryResultConsumer> queryResultConsumers = CypherViewActivator.getInstance().getQueryResultConsumers();

    // TODO!!
    if (cypherViewPart != null && cypherViewPart.getBoltClient() != null && !queryResultConsumers.isEmpty()) {

      try {

        //
        FocusSettingDelegatingQueryResultConsumer consumer = new FocusSettingDelegatingQueryResultConsumer(
            queryResultConsumers.get(0));

        //
        cypherViewPart.getBoltClient().executeCypherQuery(cypherViewPart.getModel(), consumer);

      } catch (Exception exception) {
        // _executeAction.setEnabled(true);
      }
    }
  }
}
