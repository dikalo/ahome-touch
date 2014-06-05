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
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Represents an Object displayed in the select field.
 */
public class SelectOption extends JsObject {

    public SelectOption(String text, String value) {
        this();
        setText(text);
        setValue(value);
    }

    public SelectOption() {
        jsObj = JsoHelper.createObject();
    }

    public SelectOption(JavaScriptObject obj) {
        super(obj);
    }

    public void setText(String text) {
        JsoHelper.setAttribute(jsObj, "text", text);
    }

    public void setValue(String value) {
        JsoHelper.setAttribute(jsObj, "value", value);
    }

    public String getText() {
        return JsoHelper.getAttribute(jsObj, "text");
    }

    public String getValue() {
        return JsoHelper.getAttribute(jsObj, "value");
    }
}
