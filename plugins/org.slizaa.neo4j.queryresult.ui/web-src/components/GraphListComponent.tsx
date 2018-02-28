import * as React from "react";
import * as ReactDOM from "react-dom";
import * as styles from "./QueryResultComponents.scss";
import {renderCell} from './GraphComponentRenderer'


interface GraphListComponentState {
  items: any[];
}

export class GraphListComponent extends React.Component<GraphListComponentState, {}> {


  constructor(props: GraphListComponentState) {
    super(props);
  }

  render() {

    //
    const anyArray = this.props.items;

    let rows = [];
    for (let i = 0; i < anyArray.length; i++) {

        rows.push(
          <tr>
            <td>{renderCell(anyArray[i])}</td>
          </tr>);

    }

    return <table className={styles.graphPath}>
      <tbody>{rows}</tbody>
    </table>
  }
}