import React from 'react';
import ReactDOM from 'react-dom';
import { List } from "immutable";
import TestComponent from './QueryResultComponent';

export function renderQueryResult(columnNames, records) {

    let immutableColumnNameList = List(columnNames)
    let immutableRecordList = List(records)

    ReactDOM.render(
        <TestComponent columnNames={immutableColumnNameList} records={immutableRecordList} />,
        document.getElementById('root')
    );
}

