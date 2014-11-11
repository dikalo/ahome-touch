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
package com.ait.toolkit.sencha.touch.client.ui;

import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.shared.client.core.XType;
import com.ait.toolkit.sencha.touch.client.layout.AbstractLayout;

public class DataItemConfig extends JsObject {

    public DataItemConfig() {
        jsObj = JsoHelper.createObject();
    }

    public void setComponentProperty(XType xType, boolean value) {
        JsoHelper.setAttribute(jsObj, xType.getValue(), value);
    }
    
    public void setComponentProperty(String name, boolean value) {
        JsoHelper.setAttribute(jsObj, name, value);
    }

    public void setLayout(AbstractLayout layout) {
        JsoHelper.setAttribute(jsObj, "layout", layout.getJSO());
    }

    public void setComponentProperty(XType xType, JsObject value) {
        JsoHelper.setAttribute(jsObj, xType.getValue(), value.getJsObj());
    }
    
    public void setComponentProperty(String type, JsObject value) {
        JsoHelper.setAttribute(jsObj, type, value.getJsObj());
    }

}
