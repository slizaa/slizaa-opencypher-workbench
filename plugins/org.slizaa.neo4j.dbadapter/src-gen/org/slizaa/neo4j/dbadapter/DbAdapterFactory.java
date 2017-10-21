/**
 */
package org.slizaa.neo4j.dbadapter;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.slizaa.neo4j.dbadapter.DbAdapterPackage
 * @generated
 */
public interface DbAdapterFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DbAdapterFactory eINSTANCE = org.slizaa.neo4j.dbadapter.impl.DbAdapterFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Neo4j Client</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Neo4j Client</em>'.
   * @generated
   */
  Neo4jClient createNeo4jClient();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  DbAdapterPackage getDbAdapterPackage();

} //DbAdapterFactory
