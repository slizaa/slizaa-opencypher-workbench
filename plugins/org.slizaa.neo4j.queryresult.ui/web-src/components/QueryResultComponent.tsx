import * as React from "react";
import * as ReactDOM from "react-dom";
import * as CSS from "./queryResultComponent.css";

export interface QueryResultComponentProps { columnNames: string[]; records: string[]; }

export class QueryResultComponent extends React.PureComponent<QueryResultComponentProps, {}> {
    
    render() {
        return <h1>Hello from {this.props.columnNames} and {this.props.records}!</h1>;
    }
}