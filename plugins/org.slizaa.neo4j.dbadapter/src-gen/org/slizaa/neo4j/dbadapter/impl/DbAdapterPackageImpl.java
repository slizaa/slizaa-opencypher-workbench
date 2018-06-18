/**
 */
package org.slizaa.neo4j.dbadapter.impl;

import java.util.concurrent.Future;

import java.util.function.Consumer;

import java.util.function.Function;
import org.eclipse.core.resources.IFile;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.neo4j.driver.v1.StatementResult;

import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;
import org.slizaa.neo4j.dbadapter.DbAdapterFactory;
import org.slizaa.neo4j.dbadapter.DbAdapterPackage;
import org.slizaa.neo4j.dbadapter.IQueryResultConsumer;
import org.slizaa.neo4j.dbadapter.Neo4jClient;
import org.slizaa.neo4j.opencypher.spi.IGraphMetaDataProvider;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DbAdapterPackageImpl extends EPackageImpl implements DbAdapterPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass neo4jClientEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass iGraphMetaDataProviderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType futureEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType consumerEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType iFileEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType statementResultEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType nodeEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType relationshipEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType voidEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType iQueryResultConsumerEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType functionEDataType = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.slizaa.neo4j.dbadapter.DbAdapterPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private DbAdapterPackageImpl() {
    super(eNS_URI, DbAdapterFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link DbAdapterPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static DbAdapterPackage init() {
    if (isInited) return (DbAdapterPackage)EPackage.Registry.INSTANCE.getEPackage(DbAdapterPackage.eNS_URI);

    // Obtain or create and register package
    DbAdapterPackageImpl theDbAdapterPackage = (DbAdapterPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DbAdapterPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DbAdapterPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theDbAdapterPackage.createPackageContents();

    // Initialize created meta-data
    theDbAdapterPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theDbAdapterPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(DbAdapterPackage.eNS_URI, theDbAdapterPackage);
    return theDbAdapterPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNeo4jClient() {
    return neo4jClientEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNeo4jClient_Name() {
    return (EAttribute)neo4jClientEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNeo4jClient_Description() {
    return (EAttribute)neo4jClientEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNeo4jClient_Connected() {
    return (EAttribute)neo4jClientEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNeo4jClient_Uri() {
    return (EAttribute)neo4jClientEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getNeo4jClient__Connect() {
    return neo4jClientEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getNeo4jClient__Disconnect() {
    return neo4jClientEClass.getEOperations().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getNeo4jClient__GetNodeLabels() {
    return neo4jClientEClass.getEOperations().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getNeo4jClient__GetPropertyKeys() {
    return neo4jClientEClass.getEOperations().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getNeo4jClient__GetRelationshipTypes() {
    return neo4jClientEClass.getEOperations().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getNeo4jClient__GetNode__long() {
    return neo4jClientEClass.getEOperations().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getNeo4jClient__GetRelationship__long() {
    return neo4jClientEClass.getEOperations().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getNeo4jClient__ExecuteCypherQuery__String() {
    return neo4jClientEClass.getEOperations().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getNeo4jClient__ExecuteCypherQuery__String_Map() {
    return neo4jClientEClass.getEOperations().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getNeo4jClient__ExecuteCypherQuery__String_Consumer() {
    return neo4jClientEClass.getEOperations().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getNeo4jClient__ExecuteCypherQuery__String_Map_Consumer() {
    return neo4jClientEClass.getEOperations().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getNeo4jClient__ExecuteCypherQuery__String_Function() {
    return neo4jClientEClass.getEOperations().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getNeo4jClient__ExecuteCypherQuery__String_Map_Function() {
    return neo4jClientEClass.getEOperations().get(12);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getNeo4jClient__ExecuteCypherQuery__String_IQueryResultConsumer() {
    return neo4jClientEClass.getEOperations().get(13);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getNeo4jClient__ExecuteCypherQuery__String_Map_IQueryResultConsumer() {
    return neo4jClientEClass.getEOperations().get(14);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getIQueryResultConsumer() {
    return iQueryResultConsumerEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getFunction() {
    return functionEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getFuture() {
    return futureEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getConsumer() {
    return consumerEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getIFile() {
    return iFileEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getStatementResult() {
    return statementResultEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getNode() {
    return nodeEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getRelationship() {
    return relationshipEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getVoid() {
    return voidEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIGraphMetaDataProvider() {
    return iGraphMetaDataProviderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DbAdapterFactory getDbAdapterFactory() {
    return (DbAdapterFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents() {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    neo4jClientEClass = createEClass(NEO4J_CLIENT);
    createEAttribute(neo4jClientEClass, NEO4J_CLIENT__NAME);
    createEAttribute(neo4jClientEClass, NEO4J_CLIENT__DESCRIPTION);
    createEAttribute(neo4jClientEClass, NEO4J_CLIENT__CONNECTED);
    createEAttribute(neo4jClientEClass, NEO4J_CLIENT__URI);
    createEOperation(neo4jClientEClass, NEO4J_CLIENT___CONNECT);
    createEOperation(neo4jClientEClass, NEO4J_CLIENT___DISCONNECT);
    createEOperation(neo4jClientEClass, NEO4J_CLIENT___GET_NODE_LABELS);
    createEOperation(neo4jClientEClass, NEO4J_CLIENT___GET_PROPERTY_KEYS);
    createEOperation(neo4jClientEClass, NEO4J_CLIENT___GET_RELATIONSHIP_TYPES);
    createEOperation(neo4jClientEClass, NEO4J_CLIENT___GET_NODE__LONG);
    createEOperation(neo4jClientEClass, NEO4J_CLIENT___GET_RELATIONSHIP__LONG);
    createEOperation(neo4jClientEClass, NEO4J_CLIENT___EXECUTE_CYPHER_QUERY__STRING);
    createEOperation(neo4jClientEClass, NEO4J_CLIENT___EXECUTE_CYPHER_QUERY__STRING_MAP);
    createEOperation(neo4jClientEClass, NEO4J_CLIENT___EXECUTE_CYPHER_QUERY__STRING_CONSUMER);
    createEOperation(neo4jClientEClass, NEO4J_CLIENT___EXECUTE_CYPHER_QUERY__STRING_MAP_CONSUMER);
    createEOperation(neo4jClientEClass, NEO4J_CLIENT___EXECUTE_CYPHER_QUERY__STRING_FUNCTION);
    createEOperation(neo4jClientEClass, NEO4J_CLIENT___EXECUTE_CYPHER_QUERY__STRING_MAP_FUNCTION);
    createEOperation(neo4jClientEClass, NEO4J_CLIENT___EXECUTE_CYPHER_QUERY__STRING_IQUERYRESULTCONSUMER);
    createEOperation(neo4jClientEClass, NEO4J_CLIENT___EXECUTE_CYPHER_QUERY__STRING_MAP_IQUERYRESULTCONSUMER);

    iGraphMetaDataProviderEClass = createEClass(IGRAPH_META_DATA_PROVIDER);

    // Create data types
    futureEDataType = createEDataType(FUTURE);
    consumerEDataType = createEDataType(CONSUMER);
    iFileEDataType = createEDataType(IFILE);
    statementResultEDataType = createEDataType(STATEMENT_RESULT);
    nodeEDataType = createEDataType(NODE);
    relationshipEDataType = createEDataType(RELATIONSHIP);
    voidEDataType = createEDataType(VOID);
    iQueryResultConsumerEDataType = createEDataType(IQUERY_RESULT_CONSUMER);
    functionEDataType = createEDataType(FUNCTION);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents() {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters
    addETypeParameter(futureEDataType, "T");
    addETypeParameter(consumerEDataType, "T");
    addETypeParameter(functionEDataType, "T");
    addETypeParameter(functionEDataType, "R");

    // Set bounds for type parameters

    // Add supertypes to classes
    neo4jClientEClass.getESuperTypes().add(this.getIGraphMetaDataProvider());

    // Initialize classes, features, and operations; add parameters
    initEClass(neo4jClientEClass, Neo4jClient.class, "Neo4jClient", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNeo4jClient_Name(), ecorePackage.getEString(), "name", null, 0, 1, Neo4jClient.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNeo4jClient_Description(), ecorePackage.getEString(), "description", null, 0, 1, Neo4jClient.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNeo4jClient_Connected(), ecorePackage.getEBoolean(), "connected", null, 0, 1, Neo4jClient.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNeo4jClient_Uri(), ecorePackage.getEString(), "uri", null, 0, 1, Neo4jClient.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEOperation(getNeo4jClient__Connect(), null, "connect", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getNeo4jClient__Disconnect(), null, "disconnect", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getNeo4jClient__GetNodeLabels(), ecorePackage.getEString(), "getNodeLabels", 0, -1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getNeo4jClient__GetPropertyKeys(), ecorePackage.getEString(), "getPropertyKeys", 0, -1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getNeo4jClient__GetRelationshipTypes(), ecorePackage.getEString(), "getRelationshipTypes", 0, -1, IS_UNIQUE, IS_ORDERED);

    EOperation op = initEOperation(getNeo4jClient__GetNode__long(), this.getNode(), "getNode", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getELong(), "nodeId", 1, 1, IS_UNIQUE, IS_ORDERED);

    op = initEOperation(getNeo4jClient__GetRelationship__long(), this.getRelationship(), "getRelationship", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getELong(), "nodeId", 1, 1, IS_UNIQUE, IS_ORDERED);

    op = initEOperation(getNeo4jClient__ExecuteCypherQuery__String(), null, "executeCypherQuery", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "cypherQuery", 0, 1, IS_UNIQUE, IS_ORDERED);
    EGenericType g1 = createEGenericType(this.getFuture());
    EGenericType g2 = createEGenericType(this.getStatementResult());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    op = initEOperation(getNeo4jClient__ExecuteCypherQuery__String_Map(), null, "executeCypherQuery", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "cypherQuery", 0, 1, IS_UNIQUE, IS_ORDERED);
    g1 = createEGenericType(ecorePackage.getEMap());
    g2 = createEGenericType(ecorePackage.getEString());
    g1.getETypeArguments().add(g2);
    g2 = createEGenericType(ecorePackage.getEJavaObject());
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "params", 0, 1, IS_UNIQUE, IS_ORDERED);
    g1 = createEGenericType(this.getFuture());
    g2 = createEGenericType(this.getStatementResult());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    op = initEOperation(getNeo4jClient__ExecuteCypherQuery__String_Consumer(), null, "executeCypherQuery", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "cypherQuery", 0, 1, IS_UNIQUE, IS_ORDERED);
    g1 = createEGenericType(this.getConsumer());
    g2 = createEGenericType(this.getStatementResult());
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "consumer", 0, 1, IS_UNIQUE, IS_ORDERED);
    g1 = createEGenericType(this.getFuture());
    g2 = createEGenericType(this.getVoid());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    op = initEOperation(getNeo4jClient__ExecuteCypherQuery__String_Map_Consumer(), null, "executeCypherQuery", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "cypherQuery", 0, 1, IS_UNIQUE, IS_ORDERED);
    g1 = createEGenericType(ecorePackage.getEMap());
    g2 = createEGenericType(ecorePackage.getEString());
    g1.getETypeArguments().add(g2);
    g2 = createEGenericType(ecorePackage.getEJavaObject());
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "params", 0, 1, IS_UNIQUE, IS_ORDERED);
    g1 = createEGenericType(this.getConsumer());
    g2 = createEGenericType(this.getStatementResult());
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "consumer", 0, 1, IS_UNIQUE, IS_ORDERED);
    g1 = createEGenericType(this.getFuture());
    g2 = createEGenericType(this.getVoid());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    op = initEOperation(getNeo4jClient__ExecuteCypherQuery__String_Function(), null, "executeCypherQuery", 0, 1, IS_UNIQUE, IS_ORDERED);
    ETypeParameter t1 = addETypeParameter(op, "T");
    addEParameter(op, ecorePackage.getEString(), "cypherQuery", 0, 1, IS_UNIQUE, IS_ORDERED);
    g1 = createEGenericType(this.getFunction());
    g2 = createEGenericType(this.getStatementResult());
    g1.getETypeArguments().add(g2);
    g2 = createEGenericType(t1);
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "consumer", 0, 1, IS_UNIQUE, IS_ORDERED);
    g1 = createEGenericType(this.getFuture());
    g2 = createEGenericType(t1);
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    op = initEOperation(getNeo4jClient__ExecuteCypherQuery__String_Map_Function(), null, "executeCypherQuery", 0, 1, IS_UNIQUE, IS_ORDERED);
    t1 = addETypeParameter(op, "T");
    addEParameter(op, ecorePackage.getEString(), "cypherQuery", 0, 1, IS_UNIQUE, IS_ORDERED);
    g1 = createEGenericType(ecorePackage.getEMap());
    g2 = createEGenericType(ecorePackage.getEString());
    g1.getETypeArguments().add(g2);
    g2 = createEGenericType(ecorePackage.getEJavaObject());
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "params", 0, 1, IS_UNIQUE, IS_ORDERED);
    g1 = createEGenericType(this.getFunction());
    g2 = createEGenericType(this.getStatementResult());
    g1.getETypeArguments().add(g2);
    g2 = createEGenericType(t1);
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "consumer", 0, 1, IS_UNIQUE, IS_ORDERED);
    g1 = createEGenericType(this.getFuture());
    g2 = createEGenericType(t1);
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    op = initEOperation(getNeo4jClient__ExecuteCypherQuery__String_IQueryResultConsumer(), null, "executeCypherQuery", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "cypherQuery", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getIQueryResultConsumer(), "consumer", 0, 1, IS_UNIQUE, IS_ORDERED);
    g1 = createEGenericType(this.getFuture());
    g2 = createEGenericType(this.getVoid());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    op = initEOperation(getNeo4jClient__ExecuteCypherQuery__String_Map_IQueryResultConsumer(), null, "executeCypherQuery", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "cypherQuery", 0, 1, IS_UNIQUE, IS_ORDERED);
    g1 = createEGenericType(ecorePackage.getEMap());
    g2 = createEGenericType(ecorePackage.getEString());
    g1.getETypeArguments().add(g2);
    g2 = createEGenericType(ecorePackage.getEJavaObject());
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "params", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getIQueryResultConsumer(), "consumer", 0, 1, IS_UNIQUE, IS_ORDERED);
    g1 = createEGenericType(this.getFuture());
    g2 = createEGenericType(this.getVoid());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(iGraphMetaDataProviderEClass, IGraphMetaDataProvider.class, "IGraphMetaDataProvider", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

    // Initialize data types
    initEDataType(futureEDataType, Future.class, "Future", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(consumerEDataType, Consumer.class, "Consumer", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(iFileEDataType, IFile.class, "IFile", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(statementResultEDataType, StatementResult.class, "StatementResult", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(nodeEDataType, Node.class, "Node", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(relationshipEDataType, Relationship.class, "Relationship", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(voidEDataType, Void.class, "Void", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(iQueryResultConsumerEDataType, IQueryResultConsumer.class, "IQueryResultConsumer", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(functionEDataType, Function.class, "Function", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //DbAdapterPackageImpl
