import React from 'react';
import Immutable from "immutable";
import PropTypes from "prop-types";
import { SortDirection, AutoSizer, Table, Column, List } from "react-virtualized"
import styles from "./queryresult-styles.css";
import 'react-virtualized/styles.css'; // only needs to be imported once


export default class QueryResultComponent extends React.PureComponent {

    // define the property types
    static propTypes = {
        columnNames: PropTypes.instanceOf(Immutable.List).isRequired,
        records: PropTypes.instanceOf(Immutable.List).isRequired
    };

    // the constructor
    constructor(props) {
        super(props);

        this.heightCache = new Map();
        this.computeHeight = this.computeHeight.bind(this);
    }

    // the render method
    render() {

        const { columnNames, records } = this.props;

        return (
            <div className="tableSpace">
                <AutoSizer >
                    {({ height, width }) => (
                        <Table
                            className="tableHeader"
                            width={width}
                            height={height}
                            headerHeight={20}
                            estimatedRowSize={180}
                            rowHeight={this.computeHeight}
                            rowCount={records.size}
                            rowGetter={({ index }) => records.get(index)}
                            noRowsRenderer={this.noRowsRenderer}
                        >
                            {columnNames.map((name) => <Column className="hurz" key={name} width={this.computeWidth()} label={name} dataKey={name} cellDataGetter={this.getCellData} cellRenderer={({ cellData }) => this.renderCell(cellData)} />)}
                        </Table>
                    )}
                </AutoSizer>
            </div>
        );
    }

    noRowsRenderer() {
        return <div className="noRows">No Rows</div>
    }

    computeWidth() {
        var canvas = document.createElement('canvas');
        var ctx = canvas.getContext("2d");
        ctx.font = "12px Arial";
        var width = ctx.measureText("com.buschmais.jqassistant.commandline.task.DefaultTaskFactoryImpl$1").width;
        return width;
    }

    computeHeight({ index }) {

        const { records } = this.props;
        let record = records.get(index);
        let currentHeight = 22;

        let keys = Object.keys(record);
        for (var index = 0; index < keys.length; index++) {
            let cellData = record[keys[index]];
            if (typeof cellData === 'object' && cellData.hasOwnProperty('properties')) {
                let count = Object.keys(cellData.properties).length + 2;
                if (!this.heightCache.has(count)) {
                    this.heightCache.set(count, this.test(count));
                }
                let newHeight = this.heightCache.get(count);
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
        }) {
        return rowData[dataKey];
    }

    renderCell(cellData) {

        //
        if (typeof cellData === 'object') {
            return <table className="nodeTable">
                <tbody>
                    <tr><td>ID</td><td>{cellData.id}</td></tr>
                    <tr><td>Labels</td><td>{"[" + cellData.labels + "]"}</td></tr>
                    {Object.keys(cellData.properties).map(key => <tr><td>{key}</td><td>{"" + cellData.properties[key]}</td></tr>)}
                </tbody>
            </table>
        }
        
        //
        else {
            return <div className="attributeValue">{cellData}</div>
        }
    }

    test(count) {
        var tbl = window.document.createElement("table");
        tbl.className += ' nodeTable';
        tbl.style.visibility = "hidden";
        var tblBody = window.document.createElement("tbody");
        tbl.appendChild(tblBody);

        for (var i = 0; i < count; i++) {
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