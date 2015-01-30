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
package com.ait.toolkit.sencha.touch.client.util;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.HeadElement;
import com.google.gwt.dom.client.LinkElement;

public class CSS {

    private static HeadElement head;

    /**
     * Injects the css url code into a
     * {@code <link rel="stylesheet" href="...." />} element in the document
     * header.
     * 
     * @param javascript
     *            the JavaScript code
     */
    public static void injectStyleSheet(String href) {
        HeadElement head = getHead();
        LinkElement element = createLinkElement();
        element.setHref(href);
        head.appendChild(element);
    }

    private static HeadElement getHead() {
        if (head == null) {
            Element element = Document.get().getElementsByTagName("head").getItem(0);
            assert element != null : "HTML Head element required";
            head = HeadElement.as(element);
        }
        return head;
    }

    private static LinkElement createLinkElement() {
        LinkElement link = Document.get().createLinkElement();
        link.setRel("stylesheet");
        link.setType("text/css");
        return link;

    }

}
