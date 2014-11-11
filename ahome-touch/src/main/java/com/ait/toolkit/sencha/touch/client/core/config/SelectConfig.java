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
package com.ait.toolkit.sencha.touch.client.core.config;

import com.ait.toolkit.core.client.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class SelectConfig extends TextConfig {

    public SelectConfig() {
    }

    /**
     * The underlying data value name (or numeric Array index) to bind to this
     * Select control. This resolved value is the visibly rendered value of the
     * available selection options. (defaults to 'text')
     * 
     * @param value
     */
    public void setDisplayField(String value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.DISPLAY_FIELD.getValue(), value);
    }

    /**
     * The underlying data value name (or numeric Array index) to bind to this
     * Select control. This resolved value is the visibly rendered value of the
     * available selection options. (defaults to 'text')
     * 
     * @param value
     */
    public void setDisplayField(double value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.DISPLAY_FIELD.getValue(), value);
    }

    /**
     * Specify a hiddenName if you're using the standardSubmit option. This name
     * will be used to post the underlying value of the select to the server.
     * 
     * @param value
     */
    public void setHiddenName(String value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.HIDDEN_NAME.getValue(), value);
    }

    /**
     * (Optional) An array of select options.
     * 
     * @param value
     */
    public void setOptions(JsArray<JavaScriptObject> value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.OPTIONS.getValue(), value);
    }

    /**
     * The underlying data value name (or numeric Array index) to bind to this
     * Select control. (defaults to 'value').
     * 
     * @param value
     */
    public void setValueField(String value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.VALUE_FIELD.getValue(), value);
    }

    /**
     * The underlying data value name (or numeric Array index) to bind to this
     * Select control. (defaults to 'value')
     * 
     * @param value
     */
    public void setValueField(double value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.VALUE_FIELD.getValue(), value);
    }

}
