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

import com.ait.toolkit.sencha.touch.client.core.config.NumberConfig;
import com.ait.toolkit.sencha.shared.client.core.XType;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * The Number field creates an HTML5 number input and is usually created inside
 * a form. Because it creates an HTML number input field, most browsers will
 * show a specialized virtual keyboard for entering numbers. The Number field
 * only accepts numerical input and also provides additional spinner UI that
 * increases or decreases the current value by a configured step value
 * 
 */
public class NumberField<T> extends Text<T> {
  
    @Override
    protected native void init()/*-{
		var c = new $wnd.Ext.field.Number();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
    }-*/;

    @Override
    public String getXType() {
        return XType.NUMBER_FIELD.getValue();
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.field.Number(config);
    }-*/;

    public NumberField() {
    }

    public NumberField(NumberConfig numberConfig) {
        super(numberConfig.getJsObj());
    }

    protected NumberField(JavaScriptObject jso) {
        super(jso);
    }

    /**
     * Returns the value of maxValue.
     * 
     * @return double
     */
    public native double getMaxValue() /*-{
		var numberField = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (numberField != null) {
			return numberField.getMaxValue();
		}
    }-*/;

    /**
     * Returns the value of minValue.
     * 
     * @return
     */
    public native double getMinValue() /*-{
		var numberField = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (numberField != null) {
			return numberField.getMinValue();
		}
    }-*/;

    /**
     * Returns the value of stepValue.
     * 
     * @return
     */
    public native double getStepValue() /*-{
		var numberField = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (numberField != null) {
			return numberField.getStepValue();
		}
    }-*/;

    /**
     * Sets the value of maxValue.
     * 
     * @param value
     */
    public native void setMaxValue(double value) /*-{
		var numberField = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (numberField != null) {
			numberField.setMaxValue(value);
		}
    }-*/;

    /**
     * Sets the value of minValue.
     * 
     * @param value
     */
    public native void setMinValue(double value) /*-{
		var numberField = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (numberField != null) {
			numberField.setMinValue(value);
		}
    }-*/;

    /**
     * Sets the value of stepValue.
     * 
     * @param value
     */
    public native void setStepValue(double value) /*-{
		var numberField = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (numberField != null) {
			numberField.setStepValue(value);
		}
    }-*/;
    
}
