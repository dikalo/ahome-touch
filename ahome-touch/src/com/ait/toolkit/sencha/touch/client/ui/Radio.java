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

public class Radio extends CheckBox {
   
    @Override
    protected native void init()/*-{
		var c = new $wnd.Ext.field.Radio();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
    }-*/;

    @Override
    public String getXType() {
        return XType.RADIO_FIELD.getValue();
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.field.Radio(config);
    }-*/;

    public Radio() {
    }

    protected Radio(JavaScriptObject jso) {
        super(jso);
    }

    /**
     * Returns the selected value if this radio is part of a group (other radio
     * fields with the same name, in the same FormPanel),
     * 
     * @return
     */
    public native String getGroupValue() /*-{
		var radioField = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (radioField != null) {
			return radioField.getGroupValue();
		}
    }-*/;

    /**
     * Set the matched radio field's status (that has the same value as the
     * given string) to checked.
     * 
     * @param value
     */
    public native void setGroupValue(String value) /*-{
		var radioField = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (radioField != null) {
			radioField.setGroupValue(value);
		}
    }-*/;

}
