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

import com.ait.toolkit.sencha.touch.client.core.config.DatePickerConfig;
import com.ait.toolkit.sencha.touch.client.core.config.Event;
import com.ait.toolkit.sencha.shared.client.core.XType;
import com.ait.toolkit.sencha.shared.client.core.handlers.CallbackRegistration;
import com.ait.toolkit.sencha.touch.client.core.handlers.field.datepicker.DatePickerChangeHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsDate;

/**
 * This is a specialized field which shows a Ext.picker.Date when tapped. If it
 * has a predefined value, or a value is selected in the Ext.picker.Date, it
 * will be displayed like a normal Ext.field.Text (but not
 * selectable/changable).
 */
public class DatePickerField extends Text<JsDate> {

    protected native void init()/*-{
		var c = new $wnd.Ext.field.DatePicker();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
    }-*/;

    @Override
    public String getXType() {
        return XType.DATEPICKER_FIELD.getValue();
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		config.value = new $wnd.Date();
		if (!config.picker) {
			config.picker = {};
		}
		return new $wnd.Ext.field.DatePicker(config);
    }-*/;

    public DatePickerField() {
    }

    public DatePickerField(DatePickerConfig datePickerConfig) {
        super(datePickerConfig.getJsObj());
    }

    protected DatePickerField(JavaScriptObject jso) {
        super(jso);
    }

    /**
     * Returns the value of the field, which will be a Date unless the format
     * parameter is true.
     * 
     * @return
     */
    public native boolean getDestroyPickerOnHide() /*-{
		var comp = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (comp != null) {
			return comp.getDestroyPickerOnHide();
		}
    }-*/;

    /**
     * Returns the value of picker.
     * 
     * @param format
     * @return
     */
    public native String getFormattedValue(String format) /*-{
		var comp = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (comp != null) {
			return comp.getFormattedValue(format);
		}
    }-*/;

    /**
     * Returns the value of value.
     * 
     * @param <T>
     * @return
     */
    public native <T> T getPicker() /*-{
		var comp = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (comp != null) {
			return comp.getPicker();
		}
    }-*/;

    public native JsDate getValue() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.getValue();
		}
    }-*/;

    /**
     * Sets the value of destroyPickerOnHide.
     * 
     * @param value
     */
    public native void setDestroyPickerOnHide(boolean value) /*-{
		var comp = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (comp != null) {
			comp.setDestroyPickerOnHide(value);
		}
    }-*/;

    /**
     * Sets the value of picker.
     * 
     * @param value
     */

    public void setPicker(DatePickerField value) {
        setPicker(value.getJsObj());
    }

    protected native void setPicker(JavaScriptObject value) /*-{
		var comp = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (comp != null) {
			comp.setPicker(value);
		}
    }-*/;

    /**
     * Sets the value of picker.
     * 
     * @param value
     */
    public native void setPicker(JsDate value) /*-{
		var comp = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (comp != null) {
			comp.setPicker(value);
		}
    }-*/;

    /**
     * Sets the value of value.
     * 
     * @param value
     */
    public native void setValue(JsDate value) /*-{
		var comp = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (comp != null) {
			comp.setValue(value);
		}
    }-*/;

    /**
     * Sets the value of value.
     * 
     * @param value
     */
    protected native void setValue(JavaScriptObject value) /*-{
		var comp = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (comp != null) {
			comp.setValue(value);
		}
    }-*/;

    /**
     * Fires when a date is selected.
     * 
     * @param handler
     */
    public CallbackRegistration addChangeHandler(DatePickerChangeHandler handler) {
        return this.addWidgetListener(Event.CHANGE.getValue(), handler.getJsoPeer());
    }

}
