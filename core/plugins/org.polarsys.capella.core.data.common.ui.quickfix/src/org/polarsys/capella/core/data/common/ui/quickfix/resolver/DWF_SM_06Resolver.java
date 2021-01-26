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
package org.polarsys.capella.core.data.common.ui.quickfix.resolver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.core.data.capellacommon.AbstractState;
import org.polarsys.capella.core.data.capellacommon.FinalState;
import org.polarsys.capella.core.data.capellacommon.Pseudostate;
import org.polarsys.capella.core.data.capellacommon.Region;
import org.polarsys.capella.core.data.capellacommon.State;
import org.polarsys.capella.core.data.capellacommon.impl.ModeImpl;
import org.polarsys.capella.core.data.capellacommon.impl.StateImpl;
import org.polarsys.capella.core.validation.ui.ide.quickfix.AbstractDeleteCommandResolver;

public class DWF_SM_06Resolver extends AbstractDeleteCommandResolver {

  /**
   * {@inheritDoc}
   */
  @Override
  public Object getElementToDelete(Object obj) {
    if (obj != null) {
      return getChildrenMixedStates(obj);
    }
    return null;
  }

  @Override
  public boolean enabled(Collection<IMarker> markers) {
    for (IMarker marker : markers) {
      EObject modelElement = getModelElements(marker).get(0);
      if ((null != modelElement) && (modelElement instanceof AbstractState)) {
        return getChildrenMixedStates(modelElement).size() > 0;
      }
    }
    return false;
  }

  private List<AbstractState> getChildrenMixedStates(Object obj) {
    List<AbstractState> lstStates = new ArrayList<>();
    if (obj instanceof State) {
      EList<Region> regions = ((State) obj).getOwnedRegions();
      for (Region region : regions) {
        for (AbstractState state : region.getOwnedStates()) {
          if (areMixedStateMode(obj, state)) {
            lstStates.add(state);
          }
        }
      }
    }
    return lstStates;
  }
  
  private boolean areMixedStateMode(Object object, AbstractState state) {
      if ((state instanceof Pseudostate) || (state instanceof FinalState)) {
        return false;
      }
       
      return !object.getClass().equals(state.getClass());
    }
  
}
