import * as React from "react";
import * as ReactDOM from "react-dom";
import * as styles from "./queryResultComponent.scss";
import 'react-virtualized/styles.css'; // only needs to be imported once
import { SortDirection, AutoSizer, Table, Column, List } from "react-virtualized"

export interface QueryResultComponentProps { columnNames: string[]; records: string[]; }

export class QueryResultComponent extends React.PureComponent<QueryResultComponentProps, {}> {

    private heightCache: Map<string, number>;

    // the constructor
    constructor(props: QueryResultComponentProps) {
        super(props);

        // 
        this.heightCache = new Map();
    }

    render() {

        const { columnNames, records } = this.props;

        return (

            <Table
                className={styles.tableHeader}
                width={600}
                height={600}
                headerHeight={20}
                estimatedRowSize={180}
                rowHeight={this.computeHeight}
                rowCount={records.length}
                rowGetter={({ index }) => records[index]}
                noRowsRenderer={this.noRowsRenderer}
            >
                {columnNames.map((name) => <Column className={styles.tableColumn} key={name} width={this.computeWidth()} label={name} dataKey={name} cellDataGetter={this.getCellData} cellRenderer={({ cellData }) => this.renderCell(cellData)} />)}
            </Table>

        );
    }

    noRowsRenderer() {
        return <div className={styles.noRows}>No Rows</div>
    }

    computeWidth(): number {
        return 50;
    }

    computeHeight({ index }: any): number {
        return 200;
    }

    getCellData({
        columnData,
        dataKey,
        rowData
        }: any) {
        return rowData[dataKey];
    }

    renderCell(cellData: any) {

        console.log("renderCell")

        //
        if (typeof cellData === 'object') {
            return <table className={styles.nodeTable}>
                <tbody>
                    <tr><td>ID</td><td>{cellData.id}</td></tr>
                    <tr><td>Labels</td><td>{"[" + cellData.labels + "]"}</td></tr>
                    {Object.keys(cellData.properties).map(key => <tr><td>{key}</td><td>{"" + cellData.properties[key]}</td></tr>)}
                </tbody>
            </table>
        }

        //
        else {
            return <div className={styles.attributeValue}>{cellData}</div>
        }
    }
}