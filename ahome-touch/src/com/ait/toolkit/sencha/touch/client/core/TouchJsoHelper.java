/*
 Copyright (c) 2014 Ahomé Innovation Technologies. All rights reserved.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package com.ait.toolkit.sencha.touch.client.core;

import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.touch.client.ui.ComponentFactory;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Core Helper class to deal with Component objects in the Touch4j package.
 */
public class TouchJsoHelper extends JsoHelper {
    
    private TouchJsoHelper() {
    }

    public static Component[] convertToJavaComponentArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new Component[] {};
        }
        JavaScriptObject[] componentsj = TouchJsoHelper.toArray(nativeArray);
        Component[] components = new Component[componentsj.length];
        for (int i = 0; i < componentsj.length; i++) {
            JavaScriptObject componentJS = componentsj[i];
            components[i] = ComponentFactory.getComponent(componentJS);
        }
        return components;
    }
}
