/**
 */
package org.slizaa.neo4j.dbadapter.impl;

import java.util.concurrent.Future;

import java.util.function.Consumer;

import java.util.function.Function;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.neo4j.driver.v1.types.Relationship;

import org.slizaa.neo4j.dbadapter.*;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class DbAdapterFactoryImpl extends EFactoryImpl implements DbAdapterFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public static DbAdapterFactory init() {
    try {
      DbAdapterFactory theDbAdapterFactory = (DbAdapterFactory)EPackage.Registry.INSTANCE.getEFactory(DbAdapterPackage.eNS_URI);
      if (theDbAdapterFactory != null) {
        return theDbAdapterFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new DbAdapterFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public DbAdapterFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
      case DbAdapterPackage.NEO4J_CLIENT: return createNeo4jClient();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue) {
    switch (eDataType.getClassifierID()) {
      case DbAdapterPackage.FUTURE:
        return createFutureFromString(eDataType, initialValue);
      case DbAdapterPackage.CONSUMER:
        return createConsumerFromString(eDataType, initialValue);
      case DbAdapterPackage.RELATIONSHIP:
        return createRelationshipFromString(eDataType, initialValue);
      case DbAdapterPackage.VOID:
        return createVoidFromString(eDataType, initialValue);
      case DbAdapterPackage.FUNCTION:
        return createFunctionFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue) {
    switch (eDataType.getClassifierID()) {
      case DbAdapterPackage.FUTURE:
        return convertFutureToString(eDataType, instanceValue);
      case DbAdapterPackage.CONSUMER:
        return convertConsumerToString(eDataType, instanceValue);
      case DbAdapterPackage.RELATIONSHIP:
        return convertRelationshipToString(eDataType, instanceValue);
      case DbAdapterPackage.VOID:
        return convertVoidToString(eDataType, instanceValue);
      case DbAdapterPackage.FUNCTION:
        return convertFunctionToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public Neo4jClient createNeo4jClient() {
    return new ExtendedNeo4jClientImpl();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Future<?> createFutureFromString(EDataType eDataType, String initialValue) {
    return (Future<?>)super.createFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String convertFutureToString(EDataType eDataType, Object instanceValue) {
    return super.convertToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Consumer<?> createConsumerFromString(EDataType eDataType, String initialValue) {
    return (Consumer<?>)super.createFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String convertConsumerToString(EDataType eDataType, Object instanceValue) {
    return super.convertToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Relationship createRelationshipFromString(EDataType eDataType, String initialValue) {
    return (Relationship)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String convertRelationshipToString(EDataType eDataType, Object instanceValue) {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Void createVoidFromString(EDataType eDataType, String initialValue) {
    return (Void)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String convertVoidToString(EDataType eDataType, Object instanceValue) {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Function<?, ?> createFunctionFromString(EDataType eDataType, String initialValue) {
    return (Function<?, ?>)super.createFromString(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertFunctionToString(EDataType eDataType, Object instanceValue) {
    return super.convertToString(instanceValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public DbAdapterPackage getDbAdapterPackage() {
    return (DbAdapterPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static DbAdapterPackage getPackage() {
    return DbAdapterPackage.eINSTANCE;
  }

} // DbAdapterFactoryImpl
