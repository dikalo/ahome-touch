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
import com.ait.toolkit.sencha.touch.client.core.config.SpinnerConfig;
import com.ait.toolkit.sencha.shared.client.core.XType;
import com.ait.toolkit.sencha.shared.client.core.handlers.CallbackRegistration;
import com.ait.toolkit.sencha.touch.client.core.handlers.field.spinner.SpinnerSpinDownHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.field.spinner.SpinnerSpinHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.field.spinner.SpinnerSpinUpHandler;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Wraps an HTML5 number field
 */
public class Spinner<T> extends NumberField<T> {

    @Override
    protected native void init()/*-{
		var c = new $wnd.Ext.field.Spinner();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
    }-*/;

    @Override
    public String getXType() {
        return XType.SPINNER_FIELD.getValue();
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.field.Spinner(config);
    }-*/;

    public Spinner(SpinnerConfig selectConfig) {
        super(selectConfig.getJsObj());
    }

    public Spinner() {
    }

    protected Spinner(JavaScriptObject jso) {
        super(jso);
    }

    /**
     * Returns the value of accelerateOnTapHold.
     * 
     * @return
     */
    public native boolean getAccelerateOnTapHold() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.getAccelerateOnTapHold();
		}
    }-*/;

    /**
     * Returns the value of cycle.
     * 
     * @return
     */
    public native boolean getCycle() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.getCycle();
		}
    }-*/;

    /**
     * Returns the value of incrementValue.
     * 
     * @return
     */
    public native double getIncrement() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.getIncrement();
		}
    }-*/;

    /**
     * Sets the value of accelerateOnTapHold.
     * 
     * @param value
     */
    public native void setAccelerateOnTapHold(boolean value) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setAccelerateOnTapHold(value);
		}
    }-*/;

    /**
     * Sets the value of cycle.
     * 
     * @param value
     */
    public native void setCycle(boolean value) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setCycle(value);
		}
    }-*/;

    /**
     * Sets the value of incrementValue. Deprecated. Please use setStepValue
     * 
     * @param value
     */
    @Deprecated
    public native void setIncrement(double value) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setStepValue(value);
		}
    }-*/;

    /**
     * Value that is added or subtracted from the current value when a spinner
     * is used.
     * <p>
     * Defaults to: 0.1
     */
    public native void setStepValue(double value) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setStepValue(value);
		}
    }-*/;

    /**
     * Fires when the value is changed via either spinner buttons
     * 
     * @param handler
     */
    public CallbackRegistration addSpinHandler(SpinnerSpinHandler handler) {
        return this.addListener(Event.SPIN.getValue(), handler);
    }

    /**
     * Fires when the value is changed via the spinner down button
     * 
     * @param handler
     */
    public CallbackRegistration addSpinDownHandler(SpinnerSpinDownHandler handler) {
        return this.addListener(Event.SPIN_DOWN.getValue(), handler);
    }

    /**
     * Fires when the value is changed via the spinner up button
     * 
     * @param handler
     */
    public CallbackRegistration addSpinUpHandler(SpinnerSpinUpHandler handler) {
        return this.addListener(Event.SPIN_UP.getValue(), handler);
    }

}
