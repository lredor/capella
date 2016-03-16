/*******************************************************************************
 * Copyright (c) 2006, 2016 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.common.re.properties;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.flexibility.properties.property.AbstractProperty;
import org.polarsys.capella.common.flexibility.properties.schema.ICompoundProperty;
import org.polarsys.capella.common.flexibility.properties.schema.IProperty;
import org.polarsys.capella.common.flexibility.properties.schema.IPropertyContext;
import org.polarsys.capella.common.libraries.IModel;
import org.polarsys.capella.common.libraries.ILibraryManager;
import org.polarsys.capella.common.libraries.manager.LibraryManagerExt;
import org.polarsys.capella.common.re.CatalogElementPkg;
import org.polarsys.capella.common.re.constants.IReConstants;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;

/**
 *
 */
public class InvalidSharedElementsProperty extends AbstractProperty implements ICompoundProperty {

  /**
   * {@inheritDoc}
   */
  @Override
  public Object getValue(IPropertyContext context) {

    IContext ctx = (IContext) context.getSource();
    if (!ctx.exists(IReConstants.PROPERTY__INVALID_SHARED_ELEMENTS) || (ctx.get(IReConstants.PROPERTY__INVALID_SHARED_ELEMENTS) == null)) {
      Collection<EObject> scopeElements = (Collection) context.getCurrentValue(context.getProperties().getProperty(IReConstants.PROPERTY__SHARED_ELEMENTS));

      if (scopeElements == null) {
        ctx.put(IReConstants.PROPERTY__INVALID_SHARED_ELEMENTS, Collections.emptyList());
      } else {

        Collection<EObject> result = new HashSet<EObject>();
        CatalogElementPkg pkg = (CatalogElementPkg) context.getCurrentValue(context.getProperties().getProperty(IReConstants.PROPERTY__LOCATION_TARGET));
        if (pkg != null) {

          IModel targetModel = ILibraryManager.INSTANCE.getModel(pkg);
          if (targetModel != null) {
            Collection<IModel> referencedLibraries = LibraryManagerExt.getAllReferences(targetModel);
            if (targetModel != null) {
              for (Object object : scopeElements) {
                if (object instanceof EObject) {
                  IModel sourceModel = ILibraryManager.INSTANCE.getModel((EObject) object);
                  if (!targetModel.equals(sourceModel) && !referencedLibraries.contains(sourceModel)) {
                    result.add((EObject) object);
                  }
                }
              }
            }
          }
        }

        ctx.put(IReConstants.PROPERTY__INVALID_SHARED_ELEMENTS, new HashSet<Object>(result));
      }
    }

    return ctx.get(IReConstants.PROPERTY__INVALID_SHARED_ELEMENTS);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public IStatus validate(Object newValue, IPropertyContext context) {

    if (newValue instanceof Collection) {
      if (!((Collection) newValue).isEmpty()) {
        return new Status(IStatus.WARNING, getId(),
            "Some referenced elements are not available in the target location.\nReferences to such elements will be lost.");
      }
    }

    return Status.OK_STATUS;

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object getType() {
    return Collection.class;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object toType(Object value, IPropertyContext context) {
    return value;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String[] getRelatedProperties() {
    return new String[] { IReConstants.PROPERTY__SHARED_ELEMENTS, IReConstants.PROPERTY__LOCATION_TARGET };
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void updatedValue(IProperty property, IPropertyContext context) {
    IContext ctx = (IContext) context.getSource();
    ctx.put(IReConstants.PROPERTY__INVALID_SHARED_ELEMENTS, null);
  }
}
