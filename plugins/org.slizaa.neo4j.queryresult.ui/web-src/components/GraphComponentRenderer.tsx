import * as React from "react";
import * as ReactDOM from "react-dom";

import * as QueryResultModel from "./QueryResultModel";
import { GraphNodeComponent } from "./GraphNodeComponent";
import { GraphRelationshipComponent } from "./GraphRelationshipComponent";
import { GraphPathComponent } from "./GraphPathComponent";
import * as styles from "./QueryResultComponents.scss";
import { GraphListComponent } from "./GraphListComponent";

export function renderCell(value: any) : JSX.Element {

    // handle QueryResultModel.ResultElementType.LIST: {
    if (Array.isArray(value)) {
      return <GraphListComponent items={value} />
    }

    //
    else if (typeof value === 'object') {

      let elementType = QueryResultModel.checkObject(value);

      switch (elementType) {
        case QueryResultModel.ResultElementType.NODE: {
          let graphNode = value as QueryResultModel.IGraphNode;
          return <GraphNodeComponent {...graphNode} />
        }
        case QueryResultModel.ResultElementType.RELATIONSHIP: {
          let graphRelationship = value as QueryResultModel.IGraphRelationship;
          return <GraphRelationshipComponent {...graphRelationship} />
        }
        case QueryResultModel.ResultElementType.PATH: {
          let graphPath = value as QueryResultModel.IGraphPath;
          return <GraphPathComponent {...graphPath} />
        }
        case QueryResultModel.ResultElementType.MAP: {
          //statements; 
          break;
        }
        default: {
          //statements; 
          break;
        }
      }
    }

    // handle anything else
    else {
      return <div className={styles.attributeValue}>{value == null ? 'null' : value.toString()}</div>
    }
  }