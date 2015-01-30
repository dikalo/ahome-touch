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

package com.ait.toolkit.sencha.touch.client.core;

import com.ait.toolkit.sencha.shared.client.core.handlers.CallbackRegistration;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;

/**
 * This is the delegate class for TouchWidget, so JSNI invocations are separated
 * into a logically independent compile unit.
 */
public class AbstractBaseWidget {
	private TouchWidget widget;

	/**
	 * Constructor
	 */
	public AbstractBaseWidget() {
	}

	public void setWidget(TouchWidget touchWidget) {
		this.widget = touchWidget;
	}

	static native JavaScriptObject getComponentJS(String id)/*-{
		var cmp = $wnd.Ext.ComponentMgr.get(id);
		return (cmp === undefined || cmp == null) ? null : cmp;
	}-*/;

	public JavaScriptObject getJsObj() {
		JavaScriptObject jsObj = getComponentJS(widget.id);
		return jsObj;
	}

	// create only, dont render
	public JavaScriptObject getOrCreateJsObj() {
		JavaScriptObject jsObj = getComponentJS(widget.id);
		if (jsObj != null) {
			return jsObj;
		} else {
			// create object here
			return widget.create(widget.getConfig());
		}
	}

	protected native CallbackRegistration addWidgetListener(String event,
			JavaScriptObject fn) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.AbstractBaseWidget::getOrCreateJsObj()();
		//var widget = this.@com.ait.toolkit.sencha.touch.client.core.AbstractBaseWidget::widget;
		//var peer = widget.getOrCreateJsObj();
		component.addListener(event, fn);
		var listener = fn;
		var toReturn = @com.ait.toolkit.sencha.shared.client.core.handlers.CallbackRegistration::new(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(component,event,listener);
		return toReturn;
	}-*/;

	/**
	 * @return true if component has been rendered
	 */
	public native boolean isRendered() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.AbstractBaseWidget::getJsObj()();
		return component != null && component.rendered;
	}-*/;

	protected native Element getElement(JavaScriptObject jsObj) /*-{
		var extEl = jsObj.element;
		if (extEl == null || extEl === undefined) {
			return null;
		}
		var el = extEl.dom;
		if (el == null || el === undefined) {
			return null;
		} else {
			return el.dom || el;
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ait.toolkit.sencha.touch.client.core.EventDispatcher#addEvent(java
	 * .lang.String )
	 */
	public native void addEvent(String event) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.AbstractBaseWidget::getOrCreateJsObj()();
		component.addEvents(event);
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ait.toolkit.sencha.touch.client.core.EventDispatcher#fireEvent(java
	 * .lang .String)
	 */
	public native void fireEvent(String event) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.AbstractBaseWidget::getOrCreateJsObj()();
		component.fireEvent(event);
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ait.toolkit.sencha.touch.client.core.EventDispatcher#purgeListeners()
	 */
	public native void purgeListeners() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.AbstractBaseWidget::getOrCreateJsObj()();
		component.purgeListeners();
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ait.toolkit.sencha.touch.client.core.EventDispatcher#resumeEvents()
	 */
	public native void resumeEvents() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.AbstractBaseWidget::getOrCreateJsObj()();
		component.resumeEvents();
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ait.toolkit.sencha.touch.client.core.EventDispatcher#suspendEvents()
	 */
	public native void suspendEvents() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.AbstractBaseWidget::getOrCreateJsObj()();
		component.suspendEvents();
	}-*/;

	static native boolean doIsCreated(String id)/*-{
		var cmp = $wnd.Ext.ComponentMgr.get(id);
		return cmp == null || cmp === undefined ? false : true;
	}-*/;
}
