/**
 */
package org.slizaa.neo4j.dbadapter;

import java.util.List;
import java.util.Map;

import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Function;
import org.eclipse.emf.ecore.EObject;

import org.neo4j.driver.v1.StatementResult;

import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;
import org.slizaa.neo4j.opencypher.spi.IGraphMetaDataProvider;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Neo4j Client</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.slizaa.neo4j.dbadapter.Neo4jClient#getName <em>Name</em>}</li>
 *   <li>{@link org.slizaa.neo4j.dbadapter.Neo4jClient#getDescription <em>Description</em>}</li>
 *   <li>{@link org.slizaa.neo4j.dbadapter.Neo4jClient#isConnected <em>Connected</em>}</li>
 *   <li>{@link org.slizaa.neo4j.dbadapter.Neo4jClient#getUri <em>Uri</em>}</li>
 * </ul>
 *
 * @see org.slizaa.neo4j.dbadapter.DbAdapterPackage#getNeo4jClient()
 * @model superTypes="org.slizaa.neo4j.dbadapter.IGraphMetaDataProvider"
 * @generated
 */
public interface Neo4jClient extends EObject, IGraphMetaDataProvider {
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.slizaa.neo4j.dbadapter.DbAdapterPackage#getNeo4jClient_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.slizaa.neo4j.dbadapter.Neo4jClient#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see org.slizaa.neo4j.dbadapter.DbAdapterPackage#getNeo4jClient_Description()
   * @model
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link org.slizaa.neo4j.dbadapter.Neo4jClient#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * Returns the value of the '<em><b>Connected</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Connected</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Connected</em>' attribute.
   * @see org.slizaa.neo4j.dbadapter.DbAdapterPackage#getNeo4jClient_Connected()
   * @model transient="true" changeable="false"
   * @generated
   */
  boolean isConnected();

  /**
   * Returns the value of the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Uri</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Uri</em>' attribute.
   * @see #setUri(String)
   * @see org.slizaa.neo4j.dbadapter.DbAdapterPackage#getNeo4jClient_Uri()
   * @model
   * @generated
   */
  String getUri();

  /**
   * Sets the value of the '{@link org.slizaa.neo4j.dbadapter.Neo4jClient#getUri <em>Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Uri</em>' attribute.
   * @see #getUri()
   * @generated
   */
  void setUri(String value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  void connect();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  void disconnect();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   * @generated
   */
  List<String> getNodeLabels();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   * @generated
   */
  List<String> getPropertyKeys();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   * @generated
   */
  List<String> getRelationshipTypes();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model dataType="org.slizaa.neo4j.dbadapter.Node" nodeIdRequired="true"
   * @generated
   */
  Node getNode(long nodeId);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model dataType="org.slizaa.neo4j.dbadapter.Relationship" nodeIdRequired="true"
   * @generated
   */
  Relationship getRelationship(long nodeId);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model dataType="org.slizaa.neo4j.dbadapter.Future&lt;org.slizaa.neo4j.dbadapter.StatementResult&gt;"
   * @generated
   */
  Future<StatementResult> executeCypherQuery(String cypherQuery);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model dataType="org.slizaa.neo4j.dbadapter.Future&lt;org.slizaa.neo4j.dbadapter.StatementResult&gt;"
   * @generated
   */
  Future<StatementResult> executeCypherQuery(String cypherQuery, Map<String, Object> params);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model dataType="org.slizaa.neo4j.dbadapter.Future&lt;org.slizaa.neo4j.dbadapter.Void&gt;" consumerDataType="org.slizaa.neo4j.dbadapter.Consumer&lt;org.slizaa.neo4j.dbadapter.StatementResult&gt;"
   * @generated
   */
  Future<Void> executeCypherQuery(String cypherQuery, Consumer<StatementResult> consumer);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model dataType="org.slizaa.neo4j.dbadapter.Future&lt;org.slizaa.neo4j.dbadapter.Void&gt;" consumerDataType="org.slizaa.neo4j.dbadapter.Consumer&lt;org.slizaa.neo4j.dbadapter.StatementResult&gt;"
   * @generated
   */
  Future<Void> executeCypherQuery(String cypherQuery, Map<String, Object> params, Consumer<StatementResult> consumer);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model dataType="org.slizaa.neo4j.dbadapter.Future&lt;T&gt;" consumerDataType="org.slizaa.neo4j.dbadapter.Function&lt;org.slizaa.neo4j.dbadapter.StatementResult, T&gt;"
   * @generated
   */
  <T> Future<T> executeCypherQueryAndTransformResult(String cypherQuery, Function<StatementResult, T> consumer);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model dataType="org.slizaa.neo4j.dbadapter.Future&lt;T&gt;" consumerDataType="org.slizaa.neo4j.dbadapter.Function&lt;org.slizaa.neo4j.dbadapter.StatementResult, T&gt;"
   * @generated
   */
  <T> Future<T> executeCypherQueryAndTransformResult(String cypherQuery, Map<String, Object> params, Function<StatementResult, T> consumer);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model dataType="org.slizaa.neo4j.dbadapter.Future&lt;org.slizaa.neo4j.dbadapter.Void&gt;" consumerDataType="org.slizaa.neo4j.dbadapter.IQueryResultConsumer"
   * @generated
   */
  Future<Void> executeCypherQuery(String cypherQuery, IQueryResultConsumer consumer);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model dataType="org.slizaa.neo4j.dbadapter.Future&lt;org.slizaa.neo4j.dbadapter.Void&gt;" consumerDataType="org.slizaa.neo4j.dbadapter.IQueryResultConsumer"
   * @generated
   */
  Future<Void> executeCypherQuery(String cypherQuery, Map<String, Object> params, IQueryResultConsumer consumer);

} // Neo4jClient
