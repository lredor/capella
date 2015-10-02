/*******************************************************************************
 * Copyright (c) 2006, 2015 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.core.data.cs;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Physical Link End</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.core.data.cs.PhysicalLinkEnd#getPort <em>Port</em>}</li>
 *   <li>{@link org.polarsys.capella.core.data.cs.PhysicalLinkEnd#getPart <em>Part</em>}</li>
 * </ul>
 *
 * @see org.polarsys.capella.core.data.cs.CsPackage#getPhysicalLinkEnd()
 * @model annotation="http://www.polarsys.org/capella/2007/BusinessInformation Label='PhysicalLinkEnd'"
 *        annotation="http://www.polarsys.org/kitalpha/ecore/documentation description='an endpoint of a physical link\r\n\r\nA connector end is an endpoint of a connector, which attaches the connector to a connectable element. Each connector\r\nend is part of one connector.\r\n[source: UML superstructure v2.2]' usage\040guideline='n/a' used\040in\040levels='operational,system,logical,physical' usage\040examples='n/a' constraints='none' comment/notes='none' reference\040documentation='none'"
 *        annotation="http://www.polarsys.org/capella/MNoE/CapellaLike/Mapping UML/SysML\040semantic\040equivalences='' base\040metaclass\040in\040UML/SysML\040profile\040='uml::ConnectorEnd' explanation='none' constraints='none'"
 * @generated
 */
public interface PhysicalLinkEnd extends AbstractPhysicalLinkEnd {





	/**
	 * Returns the value of the '<em><b>Port</b></em>' reference.

	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' reference.
	 * @see #setPort(PhysicalPort)
	 * @see org.polarsys.capella.core.data.cs.CsPackage#getPhysicalLinkEnd_Port()
	 * @model annotation="http://www.polarsys.org/capella/2007/UML2Mapping featureName='role' featureOwner='ConnectorEnd'"
	 *        annotation="http://www.polarsys.org/capella/2007/BusinessInformation Label='port'"
	 *        annotation="http://www.polarsys.org/kitalpha/ecore/documentation description='the port to which this communication endpoint is attached\r\n[source: Capella study]' constraints='none' comment/notes='none'"
	 *        annotation="http://www.polarsys.org/capella/MNoE/CapellaLike/Mapping UML/SysML\040semantic\040equivalences='uml::ConnectorEnd::role' explanation='none' constraints='uml::ConnectorEnd::role elements on which PhysicalPort stereotype or any stereotype that inherits from it is applied'"
	 * @generated
	 */

	PhysicalPort getPort();




	/**
	 * Sets the value of the '{@link org.polarsys.capella.core.data.cs.PhysicalLinkEnd#getPort <em>Port</em>}' reference.

	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' reference.
	 * @see #getPort()
	 * @generated
	 */

	void setPort(PhysicalPort value);







	/**
	 * Returns the value of the '<em><b>Part</b></em>' reference.

	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part</em>' reference.
	 * @see #setPart(Part)
	 * @see org.polarsys.capella.core.data.cs.CsPackage#getPhysicalLinkEnd_Part()
	 * @model annotation="http://www.polarsys.org/capella/2007/UML2Mapping featureName='partWithPort' featureOwner='ConnectorEnd'"
	 *        annotation="http://www.polarsys.org/capella/2007/BusinessInformation Label='part'"
	 *        annotation="http://www.polarsys.org/kitalpha/ecore/documentation description='the part to which this connect endpoint is attached\r\n[source: Capella study]' constraints='none' comment/notes='none'"
	 *        annotation="http://www.polarsys.org/capella/MNoE/CapellaLike/Mapping UML/SysML\040semantic\040equivalences='uml::ConnectorEnd::partWithPort' explanation='none' constraints='none'"
	 * @generated
	 */

	Part getPart();




	/**
	 * Sets the value of the '{@link org.polarsys.capella.core.data.cs.PhysicalLinkEnd#getPart <em>Part</em>}' reference.

	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Part</em>' reference.
	 * @see #getPart()
	 * @generated
	 */

	void setPart(Part value);





} // PhysicalLinkEnd
