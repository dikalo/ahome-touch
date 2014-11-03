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

import com.ait.toolkit.sencha.shared.client.core.XType;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * The Search field creates an HTML5 search input and is usually created inside
 * a form. Because it creates an HTML search input type, the visual styling of
 * this input is slightly different to normal text input contrls (the corners
 * are rounded), though the virtual keyboard displayed by the operating system
 * is the standard keyboard control.
 * 
 * As with all other form fields in Sencha Touch, the search field gains a
 * "clear" button that appears whenever there is text entered into the form, and
 * which removes that text when tapped.
 * 
 */
public class Search extends Text<String> {

    @Override
    protected native void init()/*-{
		var c = new $wnd.Ext.field.Search();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
    }-*/;

    @Override
    public String getXType() {
        return XType.SEARCH_FIELD.getValue();
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.field.Search(config);
    }-*/;

    public Search() {
    }

    protected Search(JavaScriptObject jso) {
        super(jso);
    }

}
