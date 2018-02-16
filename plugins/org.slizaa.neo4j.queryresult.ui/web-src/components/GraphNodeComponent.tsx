import * as React from "react";
import * as ReactDOM from "react-dom";
import { IGraphNode } from "./QueryResultModel";
import * as styles from "./GraphNodeComponent.scss";


/**
 * 
 * @export
 * @class GraphNodeComponent
 * @extends React.Component<IGraphNode, {}>
 */
export class GraphNodeComponent extends React.Component<IGraphNode, {}> {

  /**
   * Creates an instance of GraphNodeComponent.
   * 
   * @param  {IGraphNode} props 
   * @memberof GraphNodeComponent
   */
  constructor(props: IGraphNode) {
    super(props);
  }

  /**
   * 
   * @return 
   * @memberof GraphNodeComponent
   */
  render() {

    const graphNode = this.props;

    //
    return (
      <table className={styles.graphNodeTable}>
        <tbody className={styles.graphNodeTableBody}>
          <tr><td className={styles.graphNodeKey}>ID</td><td className="nodeValue">{graphNode.id}</td></tr>
          <tr><td className={styles.graphNodeKey}>Labels</td><td className="nodeValue">{"[" + graphNode.labels + "]"}</td></tr>
          {Object.keys(graphNode.properties).map(key => <tr><td className={styles.nodeKey}>{key}</td><td className="nodeValue">{"" + graphNode.properties[key]}</td></tr>)}
        </tbody>
      </table>);
  }

  /**
   * <table class="graphNode"><tbody class="graphNode">
   * <tr class="graphNode graphNode_row graphNode_id"><td class="graphNode graphNode_id" colspan="2"> node['id'] </td></tr>;
   * <tr class="graphNode graphNode_row graphNode_labels"><td class="graphNode graphNode_labels" colspan="2"> '[' + node['labels'] + ']' </td></tr>;
   *          
   * <tr class="graphNode graphNode_row">
   *     <td class="graphNode graphNode_data_empty"> (empty) </td>
   * </tr>
   * 
   * <tr class="graphNode graphNode_row">
   * <td class="graphNode graphNode_data graphNode_data_key">' + property + '</td>
   * <td class="graphNode graphNode_data graphNode_data_value">' + properties[property].replace('<', '&lt;').replace('>', '&gt;'); + '</td>';
   * </tr>
   * 
   * </tbody></table>
   */
}