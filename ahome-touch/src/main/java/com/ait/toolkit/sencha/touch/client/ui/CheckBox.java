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
import com.ait.toolkit.sencha.touch.client.core.config.CheckBoxConfig;
import com.ait.toolkit.sencha.touch.client.events.checkbox.CheckChangeHandler;
import com.ait.toolkit.sencha.touch.client.events.checkbox.CheckHandler;
import com.ait.toolkit.sencha.touch.client.events.checkbox.UnCheckHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.client.adapters.TakesValueEditor;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasValue;

/**
 * The checkbox field is an enhanced version of the native browser checkbox and is great for enabling your user to choose one or more items from a set (for example choosing
 * toppings for a pizza order). It works like any other field and is usually found in the context of a form.
 * 
 */
public class CheckBox extends Field implements HasValue<Boolean>, IsEditor<LeafValueEditor<Boolean>> {

	private LeafValueEditor<Boolean> editor;

	@Override
	protected native void init()/*-{
		var c = new $wnd.Ext.field.Checkbox();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
	}-*/;

	@Override
	public String getXType() {
		return XType.CHECKBOX_FIELD.getValue();
	}

	@Override
	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.field.Checkbox(config);
	}-*/;

	public CheckBox() {
	}

	public CheckBox(CheckBoxConfig checkBoxConfig) {
		super(checkBoxConfig.getJsObj());
	}

	protected CheckBox(JavaScriptObject jso) {
		super(jso);
	}

	/**
	 * Set the checked state of the checkbox to true.
	 */
	@Override
	public native void check() /*-{
		var checkBox = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (checkBox != null) {
			checkBox.check();
		}
	}-*/;

	/**
	 * Method called when this Ext.field.Checkbox has been checked.
	 */
	public native void doChecked() /*-{
		var checkBox = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (checkBox != null) {
			checkBox.doChecked();
		}
	}-*/;

	/**
	 * Method called when this Ext.field.Checkbox has been unchecked.
	 */
	public native void doUnChecked() /*-{
		var checkBox = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (checkBox != null) {
			checkBox.doUnChecked();
		}
	}-*/;

	/**
	 * Returns the field checked value.
	 * 
	 * @param <T>
	 * @return
	 */
	public native <T> T getChecked() /*-{
		var checkBox = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (checkBox != null) {
			return checkBox.getChecked();
		}
	}-*/;

	/**
	 * Returns an array of values from the checkboxes in the group that are checked.
	 * 
	 * @return
	 */
	public native JsArray<JavaScriptObject> getGroupValues() /*-{
		var checkBox = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (checkBox != null) {
			return checkBox.getGroupValues();
		}
	}-*/;

	// /**
	// * Returns the value of value.
	// */
	// @SuppressWarnings("unchecked")
	// @Override
	// public native String getValue() /*-{
	// var checkBox =
	// this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
	// if (checkBox != null) {
	// return checkBox.getValue();
	// }
	// }-*/;

	/**
	 * Returns the value of value.
	 */
	public native String getSubmitValue() /*-{
		var checkBox = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (checkBox != null) {
			return checkBox.getSubmitValue();
		}
	}-*/;

	/**
	 * Returns the checked state of the checkbox.
	 * 
	 * @return
	 */
	public native boolean isChecked() /*-{
		var checkBox = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (checkBox != null) {
			return checkBox.isChecked();
		}
	}-*/;

	/**
	 * Resets the status of all matched checkboxes in the same group to checked.
	 * 
	 * @param values
	 */
	public native void resetGroupValues(JsArray<JavaScriptObject> values) /*-{
		var checkBox = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (checkBox != null) {
			checkBox.resetGroupValues(values);
		}
	}-*/;

	/**
	 * Sets the value of checked.
	 * 
	 * @param value
	 */
	public native void setChecked(boolean value) /*-{
		var checkBox = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (checkBox != null) {
			checkBox.setChecked(value);
		}
	}-*/;

	/**
	 * Set the status of all matched checkboxes in the same group to checked.
	 * 
	 * @param values
	 */
	public native void setGroupValues(JsArray<JavaScriptObject> values) /*-{
		var checkBox = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (checkBox != null) {
			checkBox.setGroupValues(values);
		}
	}-*/;

	/**
	 * Sets the value of value.
	 * 
	 * @param value
	 */
	public native void setValue(String value) /*-{
		var checkBox = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (checkBox != null) {
			checkBox.setValue(value);
		}
	}-*/;

	/**
	 * Set the checked state of the checkbox to false.
	 */
	public native void uncheck() /*-{
		var checkBox = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (checkBox != null) {
			checkBox.uncheck();
		}
	}-*/;

	@Override
	public LeafValueEditor<Boolean> asEditor() {
		if (editor == null) {
			editor = TakesValueEditor.of(this);
		}
		return editor;
	}

	public native HandlerRegistration addCheckChangeHandler(CheckChangeHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, v, o) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.CheckBox::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.checkbox.CheckChangeEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/CheckBox;ZZ)(comp,v,o);
			handler.@com.ait.toolkit.sencha.touch.client.events.checkbox.CheckChangeHandler::onCheckChange(Lcom/ait/toolkit/sencha/touch/client/events/checkbox/CheckChangeEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.checkbox.CheckChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addCheckHandler(CheckHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, e) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.CheckBox::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.checkbox.CheckEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/CheckBox;Lcom/google/gwt/core/client/JavaScriptObject;)(comp,e);
			handler.@com.ait.toolkit.sencha.touch.client.events.checkbox.CheckHandler::onCheck(Lcom/ait/toolkit/sencha/touch/client/events/checkbox/CheckEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.checkbox.CheckEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addUnCheckHandler(UnCheckHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, e) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.CheckBox::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.checkbox.UnCheckEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/CheckBox;Lcom/google/gwt/core/client/JavaScriptObject;)(comp,e);
			handler.@com.ait.toolkit.sencha.touch.client.events.checkbox.UnCheckHandler::onUnCheck(Lcom/ait/toolkit/sencha/touch/client/events/checkbox/UnCheckEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.checkbox.UnCheckEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	@Override
	public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Boolean> handler) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValue(Boolean value) {
		setChecked(value);
	}

	@Override
	public void setValue(Boolean value, boolean fireEvents) {
		setChecked(value);
	}

	@Override
	public Boolean getValue() {
		return isChecked();
	}
}
