import * as React from "react";
import * as ReactDOM from "react-dom";
import { QueryResultComponent } from "./components/QueryResultComponent";

const columnNames = ["BLA", "BLUBB"];
const records = ["BLA", "BLUBB"];

ReactDOM.render(
    <QueryResultComponent columnNames={columnNames}  records={records} />,
    document.getElementById("root")
);