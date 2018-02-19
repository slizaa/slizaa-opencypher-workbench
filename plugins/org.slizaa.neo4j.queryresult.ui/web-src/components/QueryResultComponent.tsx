import * as React from "react";
import * as ReactDOM from "react-dom";
import ReactTable, { Column } from 'react-table';
import * as styles from "./queryResultComponent.scss";
import { IGraphNode } from "./QueryResultModel";
import { GraphNodeComponent } from "./GraphNodeComponent";

export interface QueryResultComponentProps { columnNames: string[]; records: string[]; }

/**
 * 
 */
export class QueryResultComponent extends React.Component<QueryResultComponentProps, {}> {

  // the constructor
  constructor(props: QueryResultComponentProps) {
    super(props);
  }

  // 
  render() {

    //
    const { columnNames, records } = this.props;

    return (<div>
      <ReactTable
        showPaginationTop={true}
        showPaginationBottom={false}
        sortable={false}
        defaultPageSize={20}
        data={records}
        columns={this.computeColumns(columnNames)}
        // className="-striped -highlight"
      />
    </div>);
  }

  computeColumns(columnNames: string[]) {

    //
    let columns: Column[] = [];

    //
    for (let i = 0; i < columnNames.length; i++) {
      let headerName: string = columnNames[i];
      let newColumn = {
        Header: headerName,
        id: headerName,
        accessor: (d: any) => d[headerName],
        Cell: (props: any) => this.renderCell(props)
      };
      columns.push(newColumn);
    }

    //
    return columns;
  }

  renderCell(props: any) {

    let value = props.value;

    //
    if (typeof value === 'object') {

      //
      let graphNode = value as IGraphNode;

      //
      return <GraphNodeComponent {...graphNode} />
    }

    //
    else {
      return <div className={styles.attributeValue}>{value}</div>
    }
  }
}
