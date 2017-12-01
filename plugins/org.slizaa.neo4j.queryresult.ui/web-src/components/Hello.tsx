import * as React from "react";
import * as ReactDOM from "react-dom";
import * as Immutable from "immutable";
import * as PropTypes from "prop-types";

import * as CSS from "./hello.css";

export interface HelloProps { compiler: string; framework: string; }

// 'HelloProps' describes the shape of props.
// State is never set so we use the '{}' type.
export class Hello extends React.PureComponent<HelloProps, {}> {
    render() {
        return <h1>Hello from {this.props.compiler} and {this.props.framework}!</h1>;
    }
}