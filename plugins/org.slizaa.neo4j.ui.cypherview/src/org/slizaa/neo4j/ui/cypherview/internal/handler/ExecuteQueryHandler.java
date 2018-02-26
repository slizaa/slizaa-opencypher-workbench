package org.slizaa.neo4j.ui.cypherview.internal.handler;

import java.util.List;
import java.util.concurrent.Future;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.slizaa.neo4j.dbadapter.IQueryResultConsumer;
import org.slizaa.neo4j.ui.cypherview.CypherViewPart;
import org.slizaa.neo4j.ui.cypherview.internal.osgi.CypherViewActivator;

public class ExecuteQueryHandler extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {

    System.out.println(this.hashCode());

    //
    CypherViewPart cypherViewPart = CypherViewActivator.getInstance().getCurrentCypherViewPart();

    List<IQueryResultConsumer> queryResultConsumers = CypherViewActivator.getInstance().getQueryResultConsumers();

    // TODO!!
    if (cypherViewPart != null && cypherViewPart.getBoltClient() != null && !queryResultConsumers.isEmpty()) {

      try {

        //
        final Future<?> future = cypherViewPart.getBoltClient().executeCypherQuery(cypherViewPart.getModel(),
            queryResultConsumers.get(0));

        new Thread(() -> {
          try {
            while (!(future.isDone() || future.isCancelled())) {
              Thread.sleep(500);
            }
          } catch (Exception exception) {
            exception.printStackTrace();
          } finally {
            // Display.getDefault().syncExec(() -> _executeAction.setEnabled(true));
          }
        }).start();

      } catch (Exception exception) {
        // _executeAction.setEnabled(true);
      }
    }
    return null;
  }

  @Override
  public boolean isEnabled() {
    return CypherViewActivator.getInstance().getCurrentCypherViewPart() != null
        && CypherViewActivator.getInstance().getCurrentCypherViewPart().getBoltClient() != null;
  }
}
