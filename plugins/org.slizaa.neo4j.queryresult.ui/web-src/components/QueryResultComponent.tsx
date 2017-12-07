import * as React from "react";
import * as ReactDOM from "react-dom";
import * as styles from "./queryResultComponent.scss";
import { SortDirection, AutoSizer, Table, Column, List } from "react-virtualized"

export interface QueryResultComponentProps { columnNames: string[]; records: string[]; }

export class QueryResultComponent extends React.PureComponent<QueryResultComponentProps, {}> {

    // height cache
    private heightCache: number[] = [];

    // the constructor
    constructor(props: QueryResultComponentProps) {
        super(props);

        // 
        this.computeHeight = this.computeHeight.bind(this);
    }

    render() {

        const { columnNames, records } = this.props;

        return (
            <div className={styles.tableSpace}>
                <AutoSizer >
                    {({ height, width }) => (
                        <Table
                            className={styles.tableHeader}
                            width={width}
                            height={height}
                            headerHeight={30}
                            estimatedRowSize={180}
                            rowHeight={this.computeHeight}
                            rowCount={records.length}
                            rowGetter={({ index }) => records[index]}
                            noRowsRenderer={this.noRowsRenderer}
                        >
                            {columnNames.map((name) => <Column className={styles.tableColumn} key={name} width={this.computeWidth()} label={name} dataKey={name} cellDataGetter={this.getCellData} cellRenderer={({ cellData }) => this.renderCell(cellData)} />)}
                        </Table>
                    )}
                </AutoSizer>
            </div>
        );
    }

    noRowsRenderer() {
        return <div className={styles.noRows}>No Rows</div>
    }

    computeWidth(): number {
        var canvas = document.createElement('canvas');
        var ctx = canvas.getContext("2d");
        ctx.font = "12px Arial";
        // TODO
        var width = ctx.measureText("sourceFileName <K:Ljava/lang/Object;V:Ljava/lang/Object;>()Ljava/util/Map<TK;TV;>;").width;
        return width;
    }

    computeHeight({ index }: any): number {

        const { records } = this.props;
        let record = records[index];
        let currentHeight = 22;

        let values: any[] = Object.keys(record).map(key => (record as any)[key]);
        for (var i = 0; i < values.length; i++) {
            let cellData = values[i];

            if (typeof cellData === 'object' && cellData.hasOwnProperty('properties')) {
                let count = Object.keys(cellData.properties).length + 2;

                console.log()
                if (isNaN(this.heightCache[count])) {
                    this.heightCache[count] = this.computeTableHeight(count);
                }
                let newHeight = this.heightCache[count];
                if (newHeight > currentHeight) {
                    currentHeight = newHeight;
                }
            }
        }

        return currentHeight;
    }

    getCellData({
        columnData,
        dataKey,
        rowData
        }: any) {
        return rowData[dataKey];
    }

    renderCell(cellData: any) {

        //
        if (typeof cellData === 'object') {

            // TODO: key!
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

    computeTableHeight(rowCount: number): number {

        var tbl = window.document.createElement("table");
        tbl.className += ' nodeTable';
        tbl.style.visibility = "hidden";
        var tblBody = window.document.createElement("tbody");
        tbl.appendChild(tblBody);

        for (var i = 0; i < rowCount; i++) {
            var tr = window.document.createElement("tr");
            tblBody.appendChild(tr);
            var cell = window.document.createElement("td");
            var cellText = window.document.createTextNode("a cell is a cell");
            cell.appendChild(cellText);
            tr.appendChild(cell);
        }

        document.body.appendChild(tbl);
        let height = tbl.offsetHeight;
        document.body.removeChild(tbl);
        return height + 5;
    }
}