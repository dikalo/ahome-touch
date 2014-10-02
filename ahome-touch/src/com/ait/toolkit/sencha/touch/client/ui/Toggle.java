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
import com.ait.toolkit.sencha.touch.client.core.config.ToggleConfig;
import com.ait.toolkit.sencha.touch.client.events.toggle.ToggleChangeHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * Specialized Slider with a single thumb and only two values. By default the toggle component can be switched between the values of 0 and 1.
 */
public class Toggle extends Slider {

	@Override
	protected native void init()/*-{
		var c = new $wnd.Ext.field.Toggle();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
	}-*/;

	@Override
	public String getXType() {
		return XType.TOGGLE_FIELD.getValue();
	}

	@Override
	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.field.Toggle(config);
	}-*/;

	public Toggle(ToggleConfig config) {
		super(config.getJsObj());
	}

	public Toggle() {
	}

	protected Toggle(JavaScriptObject jso) {
		super(jso);
	}

	/**
	 * Returns the value of maxValueCls.
	 * 
	 * @return
	 */
	public native String getMaxValueCls() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.getMaxValueCls();
		}
	}-*/;

	/**
	 * Returns the value of minValueCls.
	 * 
	 * @return
	 */
	public native String getMinValueCls() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.getMinValueCls();
		}
	}-*/;

	/**
	 * Sets the value of minValueCls.
	 * 
	 * @param value
	 */
	public native void setMinValueCls(String value) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setMinValueCls(value);
		}
	}-*/;

	/**
	 * Sets the value of maxValueCls.
	 * 
	 * @param value
	 */
	public native void setMaxValueCls(String value) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setMaxValueCls(value);
		}
	}-*/;

	/**
	 * Toggles the value of this toggle field.
	 */
	public native void toggle() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.toggle();
		}
	}-*/;

	public native HandlerRegistration addToggleChangeHandler(ToggleChangeHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, v, o) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.CheckBox::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.toggle.ToggleChangeEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/CheckBox;ZZ)(comp,v,o);
			handler.@com.ait.toolkit.sencha.touch.client.events.toggle.ToggleChangeHandler::onToggleChange(Lcom/ait/toolkit/sencha/touch/client/events/toggle/ToggleChangeEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.toggle.ToggleChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

}
