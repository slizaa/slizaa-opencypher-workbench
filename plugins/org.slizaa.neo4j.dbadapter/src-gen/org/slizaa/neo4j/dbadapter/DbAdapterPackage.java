/**
 */
package org.slizaa.neo4j.dbadapter;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.slizaa.neo4j.dbadapter.DbAdapterFactory
 * @model kind="package"
 * @generated
 */
public interface DbAdapterPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "dbadapter";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://org/slizaa/neo4j/dbadapter";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "org.slizaa.neo4j.dbadapter";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DbAdapterPackage eINSTANCE = org.slizaa.neo4j.dbadapter.impl.DbAdapterPackageImpl.init();

  /**
   * The meta object id for the '{@link org.slizaa.neo4j.dbadapter.impl.Neo4jClientImpl <em>Neo4j Client</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.slizaa.neo4j.dbadapter.impl.Neo4jClientImpl
   * @see org.slizaa.neo4j.dbadapter.impl.DbAdapterPackageImpl#getNeo4jClient()
   * @generated
   */
  int NEO4J_CLIENT = 0;

  /**
   * The meta object id for the '<em>Future</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.util.concurrent.Future
   * @see org.slizaa.neo4j.dbadapter.impl.DbAdapterPackageImpl#getFuture()
   * @generated
   */
  int FUTURE = 2;

  /**
   * The meta object id for the '<em>Consumer</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.util.function.Consumer
   * @see org.slizaa.neo4j.dbadapter.impl.DbAdapterPackageImpl#getConsumer()
   * @generated
   */
  int CONSUMER = 3;

  /**
   * The meta object id for the '<em>IFile</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.core.resources.IFile
   * @see org.slizaa.neo4j.dbadapter.impl.DbAdapterPackageImpl#getIFile()
   * @generated
   */
  int IFILE = 4;

  /**
   * The meta object id for the '<em>Statement Result</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.neo4j.driver.v1.StatementResult
   * @see org.slizaa.neo4j.dbadapter.impl.DbAdapterPackageImpl#getStatementResult()
   * @generated
   */
  int STATEMENT_RESULT = 5;

  /**
   * The meta object id for the '<em>Node</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.neo4j.driver.v1.types.Node
   * @see org.slizaa.neo4j.dbadapter.impl.DbAdapterPackageImpl#getNode()
   * @generated
   */
  int NODE = 6;

  /**
   * The meta object id for the '<em>Relationship</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.neo4j.driver.v1.types.Relationship
   * @see org.slizaa.neo4j.dbadapter.impl.DbAdapterPackageImpl#getRelationship()
   * @generated
   */
  int RELATIONSHIP = 7;


  /**
   * The meta object id for the '<em>Void</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.Void
   * @see org.slizaa.neo4j.dbadapter.impl.DbAdapterPackageImpl#getVoid()
   * @generated
   */
  int VOID = 8;


  /**
   * The meta object id for the '{@link org.slizaa.neo4j.opencypher.spi.IGraphMetaDataProvider <em>IGraph Meta Data Provider</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.slizaa.neo4j.opencypher.spi.IGraphMetaDataProvider
   * @see org.slizaa.neo4j.dbadapter.impl.DbAdapterPackageImpl#getIGraphMetaDataProvider()
   * @generated
   */
  int IGRAPH_META_DATA_PROVIDER = 1;


  /**
   * The number of structural features of the '<em>IGraph Meta Data Provider</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IGRAPH_META_DATA_PROVIDER_FEATURE_COUNT = 0;

  /**
   * The number of operations of the '<em>IGraph Meta Data Provider</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IGRAPH_META_DATA_PROVIDER_OPERATION_COUNT = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEO4J_CLIENT__NAME = IGRAPH_META_DATA_PROVIDER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEO4J_CLIENT__DESCRIPTION = IGRAPH_META_DATA_PROVIDER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Connected</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEO4J_CLIENT__CONNECTED = IGRAPH_META_DATA_PROVIDER_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEO4J_CLIENT__URI = IGRAPH_META_DATA_PROVIDER_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Neo4j Client</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEO4J_CLIENT_FEATURE_COUNT = IGRAPH_META_DATA_PROVIDER_FEATURE_COUNT + 4;

  /**
   * The operation id for the '<em>Connect</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEO4J_CLIENT___CONNECT = IGRAPH_META_DATA_PROVIDER_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Disconnect</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEO4J_CLIENT___DISCONNECT = IGRAPH_META_DATA_PROVIDER_OPERATION_COUNT + 1;

  /**
   * The operation id for the '<em>Get Node Labels</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEO4J_CLIENT___GET_NODE_LABELS = IGRAPH_META_DATA_PROVIDER_OPERATION_COUNT + 2;

  /**
   * The operation id for the '<em>Get Property Keys</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEO4J_CLIENT___GET_PROPERTY_KEYS = IGRAPH_META_DATA_PROVIDER_OPERATION_COUNT + 3;

  /**
   * The operation id for the '<em>Get Relationship Types</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEO4J_CLIENT___GET_RELATIONSHIP_TYPES = IGRAPH_META_DATA_PROVIDER_OPERATION_COUNT + 4;

  /**
   * The operation id for the '<em>Get Node</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEO4J_CLIENT___GET_NODE__LONG = IGRAPH_META_DATA_PROVIDER_OPERATION_COUNT + 5;

  /**
   * The operation id for the '<em>Get Relationship</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEO4J_CLIENT___GET_RELATIONSHIP__LONG = IGRAPH_META_DATA_PROVIDER_OPERATION_COUNT + 6;

  /**
   * The operation id for the '<em>Execute Cypher Query</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEO4J_CLIENT___EXECUTE_CYPHER_QUERY__STRING = IGRAPH_META_DATA_PROVIDER_OPERATION_COUNT + 7;

  /**
   * The operation id for the '<em>Execute Cypher Query</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEO4J_CLIENT___EXECUTE_CYPHER_QUERY__STRING_MAP = IGRAPH_META_DATA_PROVIDER_OPERATION_COUNT + 8;

  /**
   * The operation id for the '<em>Execute Cypher Query</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEO4J_CLIENT___EXECUTE_CYPHER_QUERY__STRING_CONSUMER = IGRAPH_META_DATA_PROVIDER_OPERATION_COUNT + 9;

  /**
   * The operation id for the '<em>Execute Cypher Query</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEO4J_CLIENT___EXECUTE_CYPHER_QUERY__STRING_MAP_CONSUMER = IGRAPH_META_DATA_PROVIDER_OPERATION_COUNT + 10;

  /**
   * The operation id for the '<em>Execute Cypher Query</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEO4J_CLIENT___EXECUTE_CYPHER_QUERY__STRING_FUNCTION = IGRAPH_META_DATA_PROVIDER_OPERATION_COUNT + 11;

  /**
   * The operation id for the '<em>Execute Cypher Query</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEO4J_CLIENT___EXECUTE_CYPHER_QUERY__STRING_MAP_FUNCTION = IGRAPH_META_DATA_PROVIDER_OPERATION_COUNT + 12;

  /**
   * The operation id for the '<em>Execute Cypher Query</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEO4J_CLIENT___EXECUTE_CYPHER_QUERY__STRING_IQUERYRESULTCONSUMER = IGRAPH_META_DATA_PROVIDER_OPERATION_COUNT + 13;

  /**
   * The operation id for the '<em>Execute Cypher Query</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEO4J_CLIENT___EXECUTE_CYPHER_QUERY__STRING_MAP_IQUERYRESULTCONSUMER = IGRAPH_META_DATA_PROVIDER_OPERATION_COUNT + 14;

  /**
   * The number of operations of the '<em>Neo4j Client</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEO4J_CLIENT_OPERATION_COUNT = IGRAPH_META_DATA_PROVIDER_OPERATION_COUNT + 15;


  /**
   * The meta object id for the '<em>IQuery Result Consumer</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.slizaa.neo4j.dbadapter.IQueryResultConsumer
   * @see org.slizaa.neo4j.dbadapter.impl.DbAdapterPackageImpl#getIQueryResultConsumer()
   * @generated
   */
  int IQUERY_RESULT_CONSUMER = 9;

  /**
   * The meta object id for the '<em>Function</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.util.function.Function
   * @see org.slizaa.neo4j.dbadapter.impl.DbAdapterPackageImpl#getFunction()
   * @generated
   */
  int FUNCTION = 10;

  /**
   * Returns the meta object for class '{@link org.slizaa.neo4j.dbadapter.Neo4jClient <em>Neo4j Client</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Neo4j Client</em>'.
   * @see org.slizaa.neo4j.dbadapter.Neo4jClient
   * @generated
   */
  EClass getNeo4jClient();

  /**
   * Returns the meta object for the attribute '{@link org.slizaa.neo4j.dbadapter.Neo4jClient#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.slizaa.neo4j.dbadapter.Neo4jClient#getName()
   * @see #getNeo4jClient()
   * @generated
   */
  EAttribute getNeo4jClient_Name();

  /**
   * Returns the meta object for the attribute '{@link org.slizaa.neo4j.dbadapter.Neo4jClient#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see org.slizaa.neo4j.dbadapter.Neo4jClient#getDescription()
   * @see #getNeo4jClient()
   * @generated
   */
  EAttribute getNeo4jClient_Description();

  /**
   * Returns the meta object for the attribute '{@link org.slizaa.neo4j.dbadapter.Neo4jClient#isConnected <em>Connected</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Connected</em>'.
   * @see org.slizaa.neo4j.dbadapter.Neo4jClient#isConnected()
   * @see #getNeo4jClient()
   * @generated
   */
  EAttribute getNeo4jClient_Connected();

  /**
   * Returns the meta object for the attribute '{@link org.slizaa.neo4j.dbadapter.Neo4jClient#getUri <em>Uri</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Uri</em>'.
   * @see org.slizaa.neo4j.dbadapter.Neo4jClient#getUri()
   * @see #getNeo4jClient()
   * @generated
   */
  EAttribute getNeo4jClient_Uri();

  /**
   * Returns the meta object for the '{@link org.slizaa.neo4j.dbadapter.Neo4jClient#connect() <em>Connect</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Connect</em>' operation.
   * @see org.slizaa.neo4j.dbadapter.Neo4jClient#connect()
   * @generated
   */
  EOperation getNeo4jClient__Connect();

  /**
   * Returns the meta object for the '{@link org.slizaa.neo4j.dbadapter.Neo4jClient#disconnect() <em>Disconnect</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Disconnect</em>' operation.
   * @see org.slizaa.neo4j.dbadapter.Neo4jClient#disconnect()
   * @generated
   */
  EOperation getNeo4jClient__Disconnect();

  /**
   * Returns the meta object for the '{@link org.slizaa.neo4j.dbadapter.Neo4jClient#getNodeLabels() <em>Get Node Labels</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Node Labels</em>' operation.
   * @see org.slizaa.neo4j.dbadapter.Neo4jClient#getNodeLabels()
   * @generated
   */
  EOperation getNeo4jClient__GetNodeLabels();

  /**
   * Returns the meta object for the '{@link org.slizaa.neo4j.dbadapter.Neo4jClient#getPropertyKeys() <em>Get Property Keys</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Property Keys</em>' operation.
   * @see org.slizaa.neo4j.dbadapter.Neo4jClient#getPropertyKeys()
   * @generated
   */
  EOperation getNeo4jClient__GetPropertyKeys();

  /**
   * Returns the meta object for the '{@link org.slizaa.neo4j.dbadapter.Neo4jClient#getRelationshipTypes() <em>Get Relationship Types</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Relationship Types</em>' operation.
   * @see org.slizaa.neo4j.dbadapter.Neo4jClient#getRelationshipTypes()
   * @generated
   */
  EOperation getNeo4jClient__GetRelationshipTypes();

  /**
   * Returns the meta object for the '{@link org.slizaa.neo4j.dbadapter.Neo4jClient#getNode(long) <em>Get Node</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Node</em>' operation.
   * @see org.slizaa.neo4j.dbadapter.Neo4jClient#getNode(long)
   * @generated
   */
  EOperation getNeo4jClient__GetNode__long();

  /**
   * Returns the meta object for the '{@link org.slizaa.neo4j.dbadapter.Neo4jClient#getRelationship(long) <em>Get Relationship</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Relationship</em>' operation.
   * @see org.slizaa.neo4j.dbadapter.Neo4jClient#getRelationship(long)
   * @generated
   */
  EOperation getNeo4jClient__GetRelationship__long();

  /**
   * Returns the meta object for the '{@link org.slizaa.neo4j.dbadapter.Neo4jClient#executeCypherQuery(java.lang.String) <em>Execute Cypher Query</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Execute Cypher Query</em>' operation.
   * @see org.slizaa.neo4j.dbadapter.Neo4jClient#executeCypherQuery(java.lang.String)
   * @generated
   */
  EOperation getNeo4jClient__ExecuteCypherQuery__String();

  /**
   * Returns the meta object for the '{@link org.slizaa.neo4j.dbadapter.Neo4jClient#executeCypherQuery(java.lang.String, java.util.Map) <em>Execute Cypher Query</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Execute Cypher Query</em>' operation.
   * @see org.slizaa.neo4j.dbadapter.Neo4jClient#executeCypherQuery(java.lang.String, java.util.Map)
   * @generated
   */
  EOperation getNeo4jClient__ExecuteCypherQuery__String_Map();

  /**
   * Returns the meta object for the '{@link org.slizaa.neo4j.dbadapter.Neo4jClient#executeCypherQuery(java.lang.String, java.util.function.Consumer) <em>Execute Cypher Query</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Execute Cypher Query</em>' operation.
   * @see org.slizaa.neo4j.dbadapter.Neo4jClient#executeCypherQuery(java.lang.String, java.util.function.Consumer)
   * @generated
   */
  EOperation getNeo4jClient__ExecuteCypherQuery__String_Consumer();

  /**
   * Returns the meta object for the '{@link org.slizaa.neo4j.dbadapter.Neo4jClient#executeCypherQuery(java.lang.String, java.util.Map, java.util.function.Consumer) <em>Execute Cypher Query</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Execute Cypher Query</em>' operation.
   * @see org.slizaa.neo4j.dbadapter.Neo4jClient#executeCypherQuery(java.lang.String, java.util.Map, java.util.function.Consumer)
   * @generated
   */
  EOperation getNeo4jClient__ExecuteCypherQuery__String_Map_Consumer();

  /**
   * Returns the meta object for the '{@link org.slizaa.neo4j.dbadapter.Neo4jClient#executeCypherQuery(java.lang.String, java.util.function.Function) <em>Execute Cypher Query</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Execute Cypher Query</em>' operation.
   * @see org.slizaa.neo4j.dbadapter.Neo4jClient#executeCypherQuery(java.lang.String, java.util.function.Function)
   * @generated
   */
  EOperation getNeo4jClient__ExecuteCypherQuery__String_Function();

  /**
   * Returns the meta object for the '{@link org.slizaa.neo4j.dbadapter.Neo4jClient#executeCypherQuery(java.lang.String, java.util.Map, java.util.function.Function) <em>Execute Cypher Query</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Execute Cypher Query</em>' operation.
   * @see org.slizaa.neo4j.dbadapter.Neo4jClient#executeCypherQuery(java.lang.String, java.util.Map, java.util.function.Function)
   * @generated
   */
  EOperation getNeo4jClient__ExecuteCypherQuery__String_Map_Function();

  /**
   * Returns the meta object for the '{@link org.slizaa.neo4j.dbadapter.Neo4jClient#executeCypherQuery(java.lang.String, org.slizaa.neo4j.dbadapter.IQueryResultConsumer) <em>Execute Cypher Query</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Execute Cypher Query</em>' operation.
   * @see org.slizaa.neo4j.dbadapter.Neo4jClient#executeCypherQuery(java.lang.String, org.slizaa.neo4j.dbadapter.IQueryResultConsumer)
   * @generated
   */
  EOperation getNeo4jClient__ExecuteCypherQuery__String_IQueryResultConsumer();

  /**
   * Returns the meta object for the '{@link org.slizaa.neo4j.dbadapter.Neo4jClient#executeCypherQuery(java.lang.String, java.util.Map, org.slizaa.neo4j.dbadapter.IQueryResultConsumer) <em>Execute Cypher Query</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Execute Cypher Query</em>' operation.
   * @see org.slizaa.neo4j.dbadapter.Neo4jClient#executeCypherQuery(java.lang.String, java.util.Map, org.slizaa.neo4j.dbadapter.IQueryResultConsumer)
   * @generated
   */
  EOperation getNeo4jClient__ExecuteCypherQuery__String_Map_IQueryResultConsumer();

  /**
   * Returns the meta object for data type '{@link org.slizaa.neo4j.dbadapter.IQueryResultConsumer <em>IQuery Result Consumer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>IQuery Result Consumer</em>'.
   * @see org.slizaa.neo4j.dbadapter.IQueryResultConsumer
   * @model instanceClass="org.slizaa.neo4j.dbadapter.IQueryResultConsumer" serializeable="false"
   * @generated
   */
  EDataType getIQueryResultConsumer();

  /**
   * Returns the meta object for data type '{@link java.util.function.Function <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Function</em>'.
   * @see java.util.function.Function
   * @model instanceClass="java.util.function.Function" typeParameters="T R"
   * @generated
   */
  EDataType getFunction();

  /**
   * Returns the meta object for data type '{@link java.util.concurrent.Future <em>Future</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Future</em>'.
   * @see java.util.concurrent.Future
   * @model instanceClass="java.util.concurrent.Future" typeParameters="T"
   * @generated
   */
  EDataType getFuture();

  /**
   * Returns the meta object for data type '{@link java.util.function.Consumer <em>Consumer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Consumer</em>'.
   * @see java.util.function.Consumer
   * @model instanceClass="java.util.function.Consumer" typeParameters="T"
   * @generated
   */
  EDataType getConsumer();

  /**
   * Returns the meta object for data type '{@link org.eclipse.core.resources.IFile <em>IFile</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>IFile</em>'.
   * @see org.eclipse.core.resources.IFile
   * @model instanceClass="org.eclipse.core.resources.IFile" serializeable="false"
   * @generated
   */
  EDataType getIFile();

  /**
   * Returns the meta object for data type '{@link org.neo4j.driver.v1.StatementResult <em>Statement Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Statement Result</em>'.
   * @see org.neo4j.driver.v1.StatementResult
   * @model instanceClass="org.neo4j.driver.v1.StatementResult" serializeable="false"
   * @generated
   */
  EDataType getStatementResult();

  /**
   * Returns the meta object for data type '{@link org.neo4j.driver.v1.types.Node <em>Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Node</em>'.
   * @see org.neo4j.driver.v1.types.Node
   * @model instanceClass="org.neo4j.driver.v1.types.Node" serializeable="false"
   * @generated
   */
  EDataType getNode();

  /**
   * Returns the meta object for data type '{@link org.neo4j.driver.v1.types.Relationship <em>Relationship</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Relationship</em>'.
   * @see org.neo4j.driver.v1.types.Relationship
   * @model instanceClass="org.neo4j.driver.v1.types.Relationship"
   * @generated
   */
  EDataType getRelationship();

  /**
   * Returns the meta object for data type '{@link java.lang.Void <em>Void</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Void</em>'.
   * @see java.lang.Void
   * @model instanceClass="java.lang.Void"
   * @generated
   */
  EDataType getVoid();

  /**
   * Returns the meta object for class '{@link org.slizaa.neo4j.opencypher.spi.IGraphMetaDataProvider <em>IGraph Meta Data Provider</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>IGraph Meta Data Provider</em>'.
   * @see org.slizaa.neo4j.opencypher.spi.IGraphMetaDataProvider
   * @model instanceClass="org.slizaa.neo4j.opencypher.spi.IGraphMetaDataProvider"
   * @generated
   */
  EClass getIGraphMetaDataProvider();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  DbAdapterFactory getDbAdapterFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each operation of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals {
    /**
     * The meta object literal for the '{@link org.slizaa.neo4j.dbadapter.impl.Neo4jClientImpl <em>Neo4j Client</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.slizaa.neo4j.dbadapter.impl.Neo4jClientImpl
     * @see org.slizaa.neo4j.dbadapter.impl.DbAdapterPackageImpl#getNeo4jClient()
     * @generated
     */
    EClass NEO4J_CLIENT = eINSTANCE.getNeo4jClient();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NEO4J_CLIENT__NAME = eINSTANCE.getNeo4jClient_Name();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NEO4J_CLIENT__DESCRIPTION = eINSTANCE.getNeo4jClient_Description();

    /**
     * The meta object literal for the '<em><b>Connected</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NEO4J_CLIENT__CONNECTED = eINSTANCE.getNeo4jClient_Connected();

    /**
     * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NEO4J_CLIENT__URI = eINSTANCE.getNeo4jClient_Uri();

    /**
     * The meta object literal for the '<em><b>Connect</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation NEO4J_CLIENT___CONNECT = eINSTANCE.getNeo4jClient__Connect();

    /**
     * The meta object literal for the '<em><b>Disconnect</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation NEO4J_CLIENT___DISCONNECT = eINSTANCE.getNeo4jClient__Disconnect();

    /**
     * The meta object literal for the '<em><b>Get Node Labels</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation NEO4J_CLIENT___GET_NODE_LABELS = eINSTANCE.getNeo4jClient__GetNodeLabels();

    /**
     * The meta object literal for the '<em><b>Get Property Keys</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation NEO4J_CLIENT___GET_PROPERTY_KEYS = eINSTANCE.getNeo4jClient__GetPropertyKeys();

    /**
     * The meta object literal for the '<em><b>Get Relationship Types</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation NEO4J_CLIENT___GET_RELATIONSHIP_TYPES = eINSTANCE.getNeo4jClient__GetRelationshipTypes();

    /**
     * The meta object literal for the '<em><b>Get Node</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation NEO4J_CLIENT___GET_NODE__LONG = eINSTANCE.getNeo4jClient__GetNode__long();

    /**
     * The meta object literal for the '<em><b>Get Relationship</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation NEO4J_CLIENT___GET_RELATIONSHIP__LONG = eINSTANCE.getNeo4jClient__GetRelationship__long();

    /**
     * The meta object literal for the '<em><b>Execute Cypher Query</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation NEO4J_CLIENT___EXECUTE_CYPHER_QUERY__STRING = eINSTANCE.getNeo4jClient__ExecuteCypherQuery__String();

    /**
     * The meta object literal for the '<em><b>Execute Cypher Query</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation NEO4J_CLIENT___EXECUTE_CYPHER_QUERY__STRING_MAP = eINSTANCE.getNeo4jClient__ExecuteCypherQuery__String_Map();

    /**
     * The meta object literal for the '<em><b>Execute Cypher Query</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation NEO4J_CLIENT___EXECUTE_CYPHER_QUERY__STRING_CONSUMER = eINSTANCE.getNeo4jClient__ExecuteCypherQuery__String_Consumer();

    /**
     * The meta object literal for the '<em><b>Execute Cypher Query</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation NEO4J_CLIENT___EXECUTE_CYPHER_QUERY__STRING_MAP_CONSUMER = eINSTANCE.getNeo4jClient__ExecuteCypherQuery__String_Map_Consumer();

    /**
     * The meta object literal for the '<em><b>Execute Cypher Query</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation NEO4J_CLIENT___EXECUTE_CYPHER_QUERY__STRING_FUNCTION = eINSTANCE.getNeo4jClient__ExecuteCypherQuery__String_Function();

    /**
     * The meta object literal for the '<em><b>Execute Cypher Query</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation NEO4J_CLIENT___EXECUTE_CYPHER_QUERY__STRING_MAP_FUNCTION = eINSTANCE.getNeo4jClient__ExecuteCypherQuery__String_Map_Function();

    /**
     * The meta object literal for the '<em><b>Execute Cypher Query</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation NEO4J_CLIENT___EXECUTE_CYPHER_QUERY__STRING_IQUERYRESULTCONSUMER = eINSTANCE.getNeo4jClient__ExecuteCypherQuery__String_IQueryResultConsumer();

    /**
     * The meta object literal for the '<em><b>Execute Cypher Query</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation NEO4J_CLIENT___EXECUTE_CYPHER_QUERY__STRING_MAP_IQUERYRESULTCONSUMER = eINSTANCE.getNeo4jClient__ExecuteCypherQuery__String_Map_IQueryResultConsumer();

    /**
     * The meta object literal for the '<em>IQuery Result Consumer</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.slizaa.neo4j.dbadapter.IQueryResultConsumer
     * @see org.slizaa.neo4j.dbadapter.impl.DbAdapterPackageImpl#getIQueryResultConsumer()
     * @generated
     */
    EDataType IQUERY_RESULT_CONSUMER = eINSTANCE.getIQueryResultConsumer();

    /**
     * The meta object literal for the '<em>Function</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.function.Function
     * @see org.slizaa.neo4j.dbadapter.impl.DbAdapterPackageImpl#getFunction()
     * @generated
     */
    EDataType FUNCTION = eINSTANCE.getFunction();

    /**
     * The meta object literal for the '<em>Future</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.concurrent.Future
     * @see org.slizaa.neo4j.dbadapter.impl.DbAdapterPackageImpl#getFuture()
     * @generated
     */
    EDataType FUTURE = eINSTANCE.getFuture();

    /**
     * The meta object literal for the '<em>Consumer</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.function.Consumer
     * @see org.slizaa.neo4j.dbadapter.impl.DbAdapterPackageImpl#getConsumer()
     * @generated
     */
    EDataType CONSUMER = eINSTANCE.getConsumer();

    /**
     * The meta object literal for the '<em>IFile</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.core.resources.IFile
     * @see org.slizaa.neo4j.dbadapter.impl.DbAdapterPackageImpl#getIFile()
     * @generated
     */
    EDataType IFILE = eINSTANCE.getIFile();

    /**
     * The meta object literal for the '<em>Statement Result</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.neo4j.driver.v1.StatementResult
     * @see org.slizaa.neo4j.dbadapter.impl.DbAdapterPackageImpl#getStatementResult()
     * @generated
     */
    EDataType STATEMENT_RESULT = eINSTANCE.getStatementResult();

    /**
     * The meta object literal for the '<em>Node</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.neo4j.driver.v1.types.Node
     * @see org.slizaa.neo4j.dbadapter.impl.DbAdapterPackageImpl#getNode()
     * @generated
     */
    EDataType NODE = eINSTANCE.getNode();

    /**
     * The meta object literal for the '<em>Relationship</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.neo4j.driver.v1.types.Relationship
     * @see org.slizaa.neo4j.dbadapter.impl.DbAdapterPackageImpl#getRelationship()
     * @generated
     */
    EDataType RELATIONSHIP = eINSTANCE.getRelationship();

    /**
     * The meta object literal for the '<em>Void</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.Void
     * @see org.slizaa.neo4j.dbadapter.impl.DbAdapterPackageImpl#getVoid()
     * @generated
     */
    EDataType VOID = eINSTANCE.getVoid();

    /**
     * The meta object literal for the '{@link org.slizaa.neo4j.opencypher.spi.IGraphMetaDataProvider <em>IGraph Meta Data Provider</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.slizaa.neo4j.opencypher.spi.IGraphMetaDataProvider
     * @see org.slizaa.neo4j.dbadapter.impl.DbAdapterPackageImpl#getIGraphMetaDataProvider()
     * @generated
     */
    EClass IGRAPH_META_DATA_PROVIDER = eINSTANCE.getIGraphMetaDataProvider();

  }

} //DbAdapterPackage
