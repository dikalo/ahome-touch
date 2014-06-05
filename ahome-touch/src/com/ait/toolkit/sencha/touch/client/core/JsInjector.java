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

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.HeadElement;
import com.google.gwt.dom.client.ScriptElement;

/**
 * Utility class to inject Javascript in the hosted page
 * 
 */
public class JsInjector {

    private static HeadElement head;

    private JsInjector() {

    }

    public static void intject(String javaScript) {
        HeadElement head = getHead();
        ScriptElement element = createScriptElement();
        element.setText(javaScript);
        head.appendChild(element);
    }

    private static ScriptElement createScriptElement() {
        ScriptElement script = Document.get().createScriptElement();
        script.setAttribute("type", "text/javascript");
        return script;
    }

    private static HeadElement getHead() {
        if (head == null) {
            Element element = Document.get().getElementsByTagName("head").getItem(0);
            assert element != null : "HTML Head element required";
            HeadElement headElement = HeadElement.as(element);
            head = headElement;
        }
        return head;
    }
}
