/*
 * Copyright 2010-2020 Alfresco Software, Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.activiti.engine.test.bpmn.multiinstance;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**

 */
public class MultiInstanceDelegate implements JavaDelegate {

  public void execute(DelegateExecution execution) {
    Integer result = (Integer) execution.getVariable("result");

    Integer item = (Integer) execution.getVariable("item");
    if (item != null) {
      result = result * item;
    } else {
      result = result * 2;
    }
    execution.setVariable("result", result);
  }

}
