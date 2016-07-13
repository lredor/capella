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
package org.polarsys.capella.common.queries.queryContext;

import java.util.HashMap;
import java.util.Map;

import org.polarsys.capella.common.queries.exceptions.EntryAlreadyExistInContextException;

/**
 */
public class QueryContext extends AbstractQueryContext {

  private final Map<String, Object> map = new HashMap<String, Object>();

  @Override
  public boolean hasValue(String key) {
    return map.containsKey(key);
  }

  @Override
  public void putValue(String key, Object value) throws EntryAlreadyExistInContextException {
    if (!hasValue(key)) {
      map.put(key, value);
    } else {
      throw new EntryAlreadyExistInContextException(key);
    }
  }

  @Override
  public Object getValue(String key) {
    return map.get(key);
  }

  @Override
  public void overwriteValue(String key, Object value) {
    map.put(key, value);
  }

}
