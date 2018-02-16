import * as React from "react";
import * as ReactDOM from "react-dom";
import { IGraphNode } from "./QueryResultModel";
import * as styles from "./queryResultComponent.scss";


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
      <table className={styles.nodeTable}>
        <tbody>
          <tr><td className={styles.nodeKey}>ID</td><td className="nodeValue">{graphNode.id}</td></tr>
          <tr><td className={styles.nodeKey}>Labels</td><td className="nodeValue">{"[" + graphNode.labels + "]"}</td></tr>
          {Object.keys(graphNode.properties).map(key => <tr><td className={styles.nodeKey}>{key}</td><td className="nodeValue">{"" + graphNode.properties[key]}</td></tr>)}
        </tbody>
      </table>);
  }
}