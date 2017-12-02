import * as React from "react";
import * as ReactDOM from "react-dom";
import * as styles from "./queryResultComponent.css";

export interface QueryResultComponentProps { columnNames: string[]; records: string[]; }

export class QueryResultComponent extends React.PureComponent<QueryResultComponentProps, {}> {
    
    render() {
        return <h1 className={styles.noRows}>Hello from {this.props.columnNames} and {this.props.records}!</h1>;
    }
}