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

import com.ait.toolkit.sencha.touch.client.core.config.Event;
import com.ait.toolkit.sencha.touch.client.core.config.FieldSetConfig;
import com.ait.toolkit.sencha.shared.client.core.XType;
import com.ait.toolkit.sencha.shared.client.core.handlers.CallbackRegistration;
import com.ait.toolkit.sencha.touch.client.core.handlers.form.BeforeSubmitFormHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.form.SubmitFormHandler;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * The Form panel presents a set of form fields and provides convenient ways to
 * load and save data. Usually a form panel just contains the set of fields you
 * want to display.
 */
public class FormPanel extends Panel {

    public FormPanel() {
    }

    public FormPanel(FieldSetConfig selectConfig) {
        super(selectConfig.getJsObj());
    }

    protected FormPanel(JavaScriptObject jso) {
        super(jso);
    }

    @Override
    protected native void init()/*-{
		var c = new $wnd.Ext.form.Panel();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
    }-*/;

    @Override
    public String getXType() {
        return XType.FORMPANEL.getValue();
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.form.Panel(config);
    }-*/;

    /**
     * Returns the value of standardSubmit.
     * 
     * @return
     */
    public native boolean getStandardSubmit() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.getStandardSubmit();
		}
    }-*/;

    /**
     * Returns the value of submitOnAction.
     * 
     * @return
     */
    public native <T> T getSubmitOnAction() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.getSubmitOnAction();
		}
    }-*/;

    /**
     * Returns the value of url.
     * 
     * @return
     */
    public native String getUrl() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.getUrl();
		}
    }-*/;

    /**
     * Resets all fields in the form back to their original values
     */
    public native void reset() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.reset();
		}
    }-*/;

    /**
     * Sets the value of standardSubmit.
     * 
     * @param value
     */
    public native void setStandardSubmit(boolean value) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setStandardSubmit(value);
		}
    }-*/;

    /**
     * Sets the value of submitOnAction
     * 
     * @param value
     */
    public native void setSubmitOnAction(boolean value) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setSubmitOnAction(value);
		}
    }-*/;

    /**
     * Sets the value of url.
     * 
     * @param value
     */
    public native void setUrl(boolean value) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setUrl(value);
		}
    }-*/;

    /**
     * Performs a Ajax-based submission of form values (if standardSubmit is
     * false) or otherwise executes a standard HTML Form submit action.
     * 
     * @param options
     * @param params
     * @param headers
     * @param autoAbort
     * @param waitMsg
     */
    public native void submit(JavaScriptObject options, JavaScriptObject params, JavaScriptObject headers,
                    Boolean autoAbort, JavaScriptObject waitMsg) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.submit(options, params, params, autoAbort, waitMsg);
		}
    }-*/;

    /**
     * 
     * Performs a Ajax-based submission of form values (if standardSubmit is
     * false) or otherwise executes a standard HTML Form submit action.
     * 
     * @param options
     * @param params
     * @param headers
     * @param autoAbort
     * @param waitMsg
     */
    public native void submit(String options, String params, String headers, Boolean autoAbort, String waitMsg) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.submit(options, params, params, autoAbort, waitMsg);
		}
    }-*/;

    /**
     * Fires immediately preceding any Form submit action. Implementations may
     * adjust submitted form values or options prior to execution. A return
     * value of false from this listener will abort the submission attempt
     * (regardless of standardSubmit configuration)
     * 
     * @param handler
     */
    public CallbackRegistration addOnBeforeSubmitFormHandler(BeforeSubmitFormHandler handler) {
        return this.addWidgetListener(Event.BEFORE_SUBMIT.getValue(), handler.getJsoPeer());
    }

    public CallbackRegistration addSubmitFormHandler(SubmitFormHandler handler) {
        return this.addWidgetListener(Event.SUBMIT.getValue(), handler.getJsoPeer());
    }

}
