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
import com.ait.toolkit.sencha.touch.client.core.config.SpinnerConfig;
import com.ait.toolkit.sencha.touch.client.events.HandlerRegistration;
import com.ait.toolkit.sencha.touch.client.events.spinner.SpinDownHandler;
import com.ait.toolkit.sencha.touch.client.events.spinner.SpinHandler;
import com.ait.toolkit.sencha.touch.client.events.spinner.SpinUpHandler;
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

	public Spinner(SpinnerConfig spinner) {
		super(spinner.getJsObj());
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
	 * Value that is added or subtracted from the current value when a spinner is used.
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
	public native HandlerRegistration addSpinHandler(SpinHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(s, v, d) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.Spinner::new(Lcom/google/gwt/core/client/JavaScriptObject;)(s);
			var releaseEvent = @com.ait.toolkit.sencha.touch.client.events.spinner.SpinEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/Spinner;ILjava/lang/String;)(comp,v,d);
			handler.@com.ait.toolkit.sencha.touch.client.events.spinner.SpinHandler::onSpin(Lcom/ait/toolkit/sencha/touch/client/events/spinner/SpinEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.spinner.SpinEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	/**
	 * Fires when the value is changed via the spinner down button
	 * 
	 * @param handler
	 */
	public native HandlerRegistration addSpinDownHandler(SpinDownHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(s, v) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.Spinner::new(Lcom/google/gwt/core/client/JavaScriptObject;)(s);
			var releaseEvent = @com.ait.toolkit.sencha.touch.client.events.spinner.SpinDownEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/Spinner;I)(comp,v);
			handler.@com.ait.toolkit.sencha.touch.client.events.spinner.SpinDownHandler::onSpinDown(Lcom/ait/toolkit/sencha/touch/client/events/spinner/SpinDownEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.spinner.SpinDownEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	/**
	 * Fires when the value is changed via the spinner up button
	 * 
	 * @param handler
	 */
	public native HandlerRegistration addSpinUpHandler(SpinUpHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(s, v) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.Spinner::new(Lcom/google/gwt/core/client/JavaScriptObject;)(s);
			var releaseEvent = @com.ait.toolkit.sencha.touch.client.events.spinner.SpinUpEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/Spinner;I)(comp,v);
			handler.@com.ait.toolkit.sencha.touch.client.events.spinner.SpinUpHandler::onSpinUp(Lcom/ait/toolkit/sencha/touch/client/events/spinner/SpinUpEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.spinner.SpinDownEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

}
