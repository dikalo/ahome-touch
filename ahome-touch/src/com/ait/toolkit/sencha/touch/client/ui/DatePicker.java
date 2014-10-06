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
import com.ait.toolkit.sencha.touch.client.events.datepicker.ChangeHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.shared.HandlerRegistration;

public class DatePicker extends Picker {

	@Override
	protected native void init()/*-{
		var c = new $wnd.Ext.picker.Date();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
	}-*/;

	@Override
	public String getXType() {
		return XType.DATEPICKER.getValue();
	}

	@Override
	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.picker.Date(config);
	}-*/;

	public DatePicker() {
	}

	protected static DatePicker instance(JavaScriptObject obj) {
		return new DatePicker(obj);
	}

	protected DatePicker(JavaScriptObject obj) {
		super(obj);
	}

	/**
	 * Returns the value of dayText.
	 * 
	 * @return
	 */
	public native String getDayText() /*-{
		var date = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (date != null) {
			return date.getDayText();
		}
	}-*/;

	/**
	 * Returns the value of monthText.
	 * 
	 * @return
	 */
	public native String getMonthText() /*-{
		var date = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (date != null) {
			return date.getMonthText();
		}
	}-*/;

	/**
	 * Returns the value of slotOrder.
	 * 
	 * @return
	 */
	public native JsArray<JavaScriptObject> getSlotOrder() /*-{
		var date = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (date != null) {
		    return @com.ait.toolkit.core.client.JsoHelper::convertToJavaScriptArray([Ljava/lang/Object;)(date.getSlotOrder());
		}
    }-*/;

	/**
	 * Returns the value of value.
	 * 
	 * @return
	 */
	public native DatePicker getDateValue() /*-{
		var date = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (date != null) {
			return date.getValue();
		}
	}-*/;

	/**
	 * Returns the value of yearFrom.
	 * 
	 * @return
	 */
	public native int getYearFrom() /*-{
		var date = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (date != null) {
			return date.getYearFrom();
		}
	}-*/;

	/**
	 * Returns the value of yearText.
	 * 
	 * @return
	 */
	public native String getYearText() /*-{
		var date = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (date != null) {
			return date.getYearText();
		}
	}-*/;

	/**
	 * Returns the value of yearTo.
	 * 
	 * @return
	 */
	public native int getYearTo() /*-{
		var date = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (date != null) {
			return date.getYearTo();
		}
	}-*/;

	/**
	 * Sets the value of dayText.
	 * 
	 * @param value
	 */
	public native void setDayText(String value) /*-{
		var date = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (date != null) {
			date.setDayText(value);
		}
	}-*/;

	/**
	 * Sets the value of monthText.
	 * 
	 * @param value
	 */
	public native void setMonthText(String value) /*-{
		var date = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (date != null) {
			date.setMonthText(value);
		}
	}-*/;

	/**
	 * Sets the value of slotOrder.
	 * 
	 * @param orderArray
	 */
	public native void setSlotOrder(JsArray<JavaScriptObject> orderArray) /*-{
		var date = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var order = @com.ait.toolkit.core.client.JsoHelper::convertToJavaScriptArray([Ljava/lang/Object;)(orderArray);
		if (date != null) {
			date.setSlotOrder(order);
		}
	}-*/;

	/**
	 * Sets the value of value.
	 * 
	 * @param value
	 */
	protected native void setValue(JavaScriptObject value) /*-{
		var date = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (date != null) {
			date.setValue(value);
		}
	}-*/;

	/**
	 * Sets the value of value.
	 * 
	 * @param value
	 */
	public native void setValue(DatePicker value) /*-{
		var date = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (date != null) {
			date.setValue(value);
		}
	}-*/;

	/**
	 * Sets the value of yearFrom.
	 * 
	 * @param value
	 */
	public native void setYearFrom(int value) /*-{
		var date = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (date != null) {
			date.setYearFrom(value);
		}
	}-*/;

	/**
	 * Sets the value of yearText.
	 * 
	 * @param value
	 */
	public native void setYearText(String value) /*-{
		var date = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (date != null) {
			date.setYearText(value);
		}
	}-*/;

	/**
	 * Sets the value of yearTo.
	 * 
	 * @param value
	 */
	public native void setYearTo(int value) /*-{
		var date = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (date != null) {
			date.setYearTo(value);
		}
	}-*/;

	/**
	 * Updates the dayText configuraton
	 * 
	 * @param newDayText
	 * @param oldDayText
	 */
	protected native void updateDayText(JavaScriptObject newDayText, JavaScriptObject oldDayText) /*-{
		var date = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (date != null) {
			date.updateDayText(newDayText, oldDayText);
		}
	}-*/;

	/**
	 * Updates the monthText configuration
	 * 
	 * @param newMonthText
	 * @param oldMonthText
	 */
	protected native void updateMonthText(JavaScriptObject newMonthText, JavaScriptObject oldMonthText) /*-{
		var date = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (date != null) {
			date.updateMonthText(newMonthText, oldMonthText);
		}
	}-*/;

	/**
	 * Updates the yearFrom configuration
	 */
	public native void updateYearFrom() /*-{
		var date = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (date != null) {
			date.updateYearFrom();
		}
	}-*/;

	public native HandlerRegistration addChangeHandler(ChangeHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, v) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.DatePicker::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.datepicker.ChangeEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/DatePicker;Lcom/google/gwt/core/client/JsDate;)(comp,v);
			handler.@com.ait.toolkit.sencha.touch.client.events.datepicker.ChangeHandler::onChange(Lcom/ait/toolkit/sencha/touch/client/events/datepicker/ChangeEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.datepicker.ChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	/**
	 * Updates the yearText configuration
	 * 
	 * @param value
	 */
	protected native void updateYearText(JavaScriptObject value) /*-{
		var date = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (date != null) {
			date.updateYearText(value);
		}
	}-*/;

	/**
	 * Updates the yearTo configuration
	 */
	public native void updateYearTo() /*-{
		var date = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (date != null) {
			date.updateYearTo();
		}
	}-*/;

}
