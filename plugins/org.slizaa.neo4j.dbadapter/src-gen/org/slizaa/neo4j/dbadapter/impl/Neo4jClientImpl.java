/**
 */
package org.slizaa.neo4j.dbadapter.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.List;
import java.util.Map;

import java.util.concurrent.Future;

import java.util.function.Consumer;
import java.util.function.Function;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.neo4j.driver.v1.StatementResult;

import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;
import org.slizaa.neo4j.dbadapter.DbAdapterPackage;
import org.slizaa.neo4j.dbadapter.IQueryResultConsumer;
import org.slizaa.neo4j.dbadapter.Neo4jClient;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Neo4j Client</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.slizaa.neo4j.dbadapter.impl.Neo4jClientImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.slizaa.neo4j.dbadapter.impl.Neo4jClientImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.slizaa.neo4j.dbadapter.impl.Neo4jClientImpl#isConnected <em>Connected</em>}</li>
 *   <li>{@link org.slizaa.neo4j.dbadapter.impl.Neo4jClientImpl#getUri <em>Uri</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Neo4jClientImpl extends MinimalEObjectImpl.Container implements Neo4jClient {
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected String description = DESCRIPTION_EDEFAULT;

  /**
   * The default value of the '{@link #isConnected() <em>Connected</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isConnected()
   * @generated
   * @ordered
   */
  protected static final boolean CONNECTED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isConnected() <em>Connected</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isConnected()
   * @generated
   * @ordered
   */
  protected boolean connected = CONNECTED_EDEFAULT;

  /**
   * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUri()
   * @generated
   * @ordered
   */
  protected static final String URI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUri()
   * @generated
   * @ordered
   */
  protected String uri = URI_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Neo4jClientImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return DbAdapterPackage.Literals.NEO4J_CLIENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName() {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName) {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DbAdapterPackage.NEO4J_CLIENT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDescription() {
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(String newDescription) {
    String oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DbAdapterPackage.NEO4J_CLIENT__DESCRIPTION, oldDescription, description));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isConnected() {
    return connected;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getUri() {
    return uri;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUri(String newUri) {
    String oldUri = uri;
    uri = newUri;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DbAdapterPackage.NEO4J_CLIENT__URI, oldUri, uri));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void connect() {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void disconnect() {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List<String> getNodeLabels() {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List<String> getPropertyKeys() {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List<String> getRelationshipTypes() {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Node getNode(long nodeId) {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Relationship getRelationship(long nodeId) {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Future<StatementResult> executeCypherQuery(String cypherQuery) {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Future<StatementResult> executeCypherQuery(String cypherQuery, Map<String, Object> params) {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Future<Void> executeCypherQuery(String cypherQuery, Consumer<StatementResult> consumer) {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Future<Void> executeCypherQuery(String cypherQuery, Map<String, Object> params, Consumer<StatementResult> consumer) {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public <T> Future<T> executeCypherQueryAndTransformResult(String cypherQuery, Function<StatementResult, T> consumer) {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public <T> Future<T> executeCypherQueryAndTransformResult(String cypherQuery, Map<String, Object> params, Function<StatementResult, T> consumer) {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Future<Void> executeCypherQuery(String cypherQuery, IQueryResultConsumer consumer) {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Future<Void> executeCypherQuery(String cypherQuery, Map<String, Object> params, IQueryResultConsumer consumer) {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case DbAdapterPackage.NEO4J_CLIENT__NAME:
        return getName();
      case DbAdapterPackage.NEO4J_CLIENT__DESCRIPTION:
        return getDescription();
      case DbAdapterPackage.NEO4J_CLIENT__CONNECTED:
        return isConnected();
      case DbAdapterPackage.NEO4J_CLIENT__URI:
        return getUri();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case DbAdapterPackage.NEO4J_CLIENT__NAME:
        setName((String)newValue);
        return;
      case DbAdapterPackage.NEO4J_CLIENT__DESCRIPTION:
        setDescription((String)newValue);
        return;
      case DbAdapterPackage.NEO4J_CLIENT__URI:
        setUri((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case DbAdapterPackage.NEO4J_CLIENT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case DbAdapterPackage.NEO4J_CLIENT__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
        return;
      case DbAdapterPackage.NEO4J_CLIENT__URI:
        setUri(URI_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case DbAdapterPackage.NEO4J_CLIENT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case DbAdapterPackage.NEO4J_CLIENT__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
      case DbAdapterPackage.NEO4J_CLIENT__CONNECTED:
        return connected != CONNECTED_EDEFAULT;
      case DbAdapterPackage.NEO4J_CLIENT__URI:
        return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  @SuppressWarnings("unchecked")
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
      case DbAdapterPackage.NEO4J_CLIENT___CONNECT:
        connect();
        return null;
      case DbAdapterPackage.NEO4J_CLIENT___DISCONNECT:
        disconnect();
        return null;
      case DbAdapterPackage.NEO4J_CLIENT___GET_NODE_LABELS:
        return getNodeLabels();
      case DbAdapterPackage.NEO4J_CLIENT___GET_PROPERTY_KEYS:
        return getPropertyKeys();
      case DbAdapterPackage.NEO4J_CLIENT___GET_RELATIONSHIP_TYPES:
        return getRelationshipTypes();
      case DbAdapterPackage.NEO4J_CLIENT___GET_NODE__LONG:
        return getNode((Long)arguments.get(0));
      case DbAdapterPackage.NEO4J_CLIENT___GET_RELATIONSHIP__LONG:
        return getRelationship((Long)arguments.get(0));
      case DbAdapterPackage.NEO4J_CLIENT___EXECUTE_CYPHER_QUERY__STRING:
        return executeCypherQuery((String)arguments.get(0));
      case DbAdapterPackage.NEO4J_CLIENT___EXECUTE_CYPHER_QUERY__STRING_MAP:
        return executeCypherQuery((String)arguments.get(0), (Map<String, Object>)arguments.get(1));
      case DbAdapterPackage.NEO4J_CLIENT___EXECUTE_CYPHER_QUERY__STRING_CONSUMER:
        return executeCypherQuery((String)arguments.get(0), (Consumer<StatementResult>)arguments.get(1));
      case DbAdapterPackage.NEO4J_CLIENT___EXECUTE_CYPHER_QUERY__STRING_MAP_CONSUMER:
        return executeCypherQuery((String)arguments.get(0), (Map<String, Object>)arguments.get(1), (Consumer<StatementResult>)arguments.get(2));
      case DbAdapterPackage.NEO4J_CLIENT___EXECUTE_CYPHER_QUERY_AND_TRANSFORM_RESULT__STRING_FUNCTION:
        return executeCypherQueryAndTransformResult((String)arguments.get(0), (Function)arguments.get(1));
      case DbAdapterPackage.NEO4J_CLIENT___EXECUTE_CYPHER_QUERY_AND_TRANSFORM_RESULT__STRING_MAP_FUNCTION:
        return executeCypherQueryAndTransformResult((String)arguments.get(0), (Map<String, Object>)arguments.get(1), (Function)arguments.get(2));
      case DbAdapterPackage.NEO4J_CLIENT___EXECUTE_CYPHER_QUERY__STRING_IQUERYRESULTCONSUMER:
        return executeCypherQuery((String)arguments.get(0), (IQueryResultConsumer)arguments.get(1));
      case DbAdapterPackage.NEO4J_CLIENT___EXECUTE_CYPHER_QUERY__STRING_MAP_IQUERYRESULTCONSUMER:
        return executeCypherQuery((String)arguments.get(0), (Map<String, Object>)arguments.get(1), (IQueryResultConsumer)arguments.get(2));
    }
    return super.eInvoke(operationID, arguments);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", description: ");
    result.append(description);
    result.append(", connected: ");
    result.append(connected);
    result.append(", uri: ");
    result.append(uri);
    result.append(')');
    return result.toString();
  }

} //Neo4jClientImpl
