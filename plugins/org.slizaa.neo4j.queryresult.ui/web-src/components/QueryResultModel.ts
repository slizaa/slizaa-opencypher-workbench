export interface IGraphNode {

    id: number;
    labels: string[];
    properties: any;
}

export interface IGraphRelationship {

    id: number;
    start: number;
    end: number;
    type: string;
    properties: any;
}

export interface IGraphPath {

    nodes: IGraphNode[];
    relationships: IGraphRelationship[];
    segments: IGraphPathSegment[];
}

export interface IGraphPathSegment {

    id: number;
    labels: string[];
    properties: any;
}
/**
 * 
 * @enum {number}
 */
export enum ResultElementType {
    LIST,
    MAP,
    NODE,
    PATH,
    RELATIONSHIP,
    UNKNOWN
}

export function checkObject(value: object): ResultElementType {

    //
    if (value.hasOwnProperty('id') && value.hasOwnProperty('labels') && value.hasOwnProperty('properties')) {
        return ResultElementType.NODE
    }

    //
    else if (value.hasOwnProperty('id') && value.hasOwnProperty('start') && value.hasOwnProperty('end') && value.hasOwnProperty('type') && value.hasOwnProperty('properties')) {
        return ResultElementType.RELATIONSHIP
    }

    //
    else if (value.hasOwnProperty('nodes') && value.hasOwnProperty('relationships') && value.hasOwnProperty('segments')) {
        return ResultElementType.PATH
    }

    //
    else {
        return ResultElementType.UNKNOWN
    }
}