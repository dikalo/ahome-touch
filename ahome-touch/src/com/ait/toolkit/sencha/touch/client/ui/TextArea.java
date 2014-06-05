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

import com.ait.toolkit.sencha.touch.client.core.config.TextAreaConfig;
import com.ait.toolkit.sencha.shared.client.core.XType;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Creates an HTML textarea field on the page. This is useful whenever you need
 * the user to enter large amounts of text (i.e. more than a few words).
 * Typically, text entry on mobile devices is not a pleasant experience for the
 * user so it's good to limit your use of text areas to only those occasions
 * when freeform text is required or alternative input methods like select boxes
 * or radio buttons are not possible. Text Areas are usually created inside
 * forms.
 * 
 */
public class TextArea extends Text<String> {
    
    @Override
    protected native void init()/*-{
		var c = new $wnd.Ext.field.TextArea();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
    }-*/;

    @Override
    public String getXType() {
        return XType.TEXTAREA_FIELD.getValue();
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.field.TextArea(config);
    }-*/;

    public TextArea(TextAreaConfig selectConfig) {
        super(selectConfig.getJsObj());
    }

    public TextArea() {
    }

    protected TextArea(JavaScriptObject jso) {
        super(jso);
    }

    /**
     * Sets the value of maxRows.
     * 
     * @param value
     */
    public native void setMaxRows(double value) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setMaxRows(value);
		}
    }-*/;

    /**
     * Returns the value of maxRows.
     * 
     * @return
     */
    public native double getMaxRows() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.getMaxRows();
		}
    }-*/;

}
