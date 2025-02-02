/*******************************************************************************
 * Copyright (c) 2006, 2020 THALES GLOBAL SERVICES.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.core.data.la.validation.capabilityRealization;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;

import org.polarsys.capella.common.helpers.EcoreUtil2;
import org.polarsys.capella.core.data.interaction.InteractionPackage;
import org.polarsys.capella.core.data.la.CapabilityRealization;
import org.polarsys.capella.core.data.la.LaPackage;
import org.polarsys.capella.core.model.helpers.RefinementLinkExt;
import org.polarsys.capella.core.validation.rule.AbstractValidationRule;

/**
 * Check CapabilityRealization in LogicalArchitecture layer is refined toward CapabilityRealization in PhysicalArchitecture layer.
 */
public class MDCHK_CapabilityRealization_Refinement_2 extends AbstractValidationRule {
  /**
   * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
   */
  @Override
  public IStatus validate(IValidationContext ctx) {
    EObject eObj = ctx.getTarget();
    EMFEventType eType = ctx.getEventType();

    if (eType == EMFEventType.NULL) {
      if (eObj instanceof CapabilityRealization) {
        CapabilityRealization capability = (CapabilityRealization) eObj;

        if (EcoreUtil2.isContainedBy(capability, LaPackage.Literals.LOGICAL_ARCHITECTURE)) {
          if (RefinementLinkExt.getRefinementRelatedSourceElements(capability, InteractionPackage.Literals.ABSTRACT_CAPABILITY).size() == 0) {
            return createFailureStatus(ctx, new Object[] { capability.getName() });
          }
        }
      }
    }
    return ctx.createSuccessStatus();
  }
}
