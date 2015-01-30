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

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.shared.client.core.IsComponentElement;
import com.ait.toolkit.sencha.shared.client.core.handlers.AbstractHandler;
import com.ait.toolkit.sencha.shared.client.core.handlers.CallbackRegistration;
import com.ait.toolkit.sencha.touch.client.ui.MessageBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;

public abstract class TouchWidget extends Widget implements EventDispatcher, IsComponentElement {

	protected JavaScriptObject config;
	protected String id;

	@SuppressWarnings("rawtypes")
	private Map configListeners = new HashMap();
	private boolean isElementSet = false;

	// JSNI delegate
	private AbstractBaseWidget delegate = GWT.create(AbstractBaseWidget.class);

	public TouchWidget() {
		delegate.setWidget(this);
	}

	protected abstract JavaScriptObject create(JavaScriptObject config);

	protected abstract JavaScriptObject getConfigPrototype();

	protected static native JavaScriptObject getComponentJS(String id)/*-{
		var cmp = $wnd.Ext.ComponentMgr.get(id);
		return (cmp === undefined || cmp == null) ? null : cmp;
	}-*/;

	protected CallbackRegistration addListener(String event, JavaScriptObject fn) {
		return addWidgetListener(event, fn);
	}

	protected CallbackRegistration addWidgetListener(String event, JavaScriptObject fn) {
		return delegate.addWidgetListener(event, fn);
	}

	public JavaScriptObject getJsObj() {
		return delegate.getJsObj();
	}

	// create only, dont render

	public JavaScriptObject getOrCreateJsObj() {
		return delegate.getOrCreateJsObj();
	}

	public JavaScriptObject getConfig() {
		return config;
	}

	/**
	 * @return true if the underlying widget object has been created
	 */
	public boolean isCreated() {
		return doIsCreated(id);
	}

	/**
	 * @return true if component has been rendered
	 */
	public boolean isRendered() {
		return delegate.isRendered();
	}

	@Override
	public Element getElement() {
		return getElement(true);
	}

	public Element getElement(boolean allowPreRender) {
		if (!isElementSet) {
			JavaScriptObject jsObj = getComponentJS(id);
			if (!isRendered()) {
				if (!allowPreRender) {
					error("This method should only be called after the component has been rendered");
				}

				if (jsObj == null) {
					jsObj = create(config);
				}
			}
			setElement(getElement(jsObj));
		}
		return super.getElement();
	}

	@Override
	protected void setElement(Element elem) {
		super.setElement(elem);
		isElementSet = true;
	}

	protected Element getElement(JavaScriptObject jsObj) {
		return delegate.getElement(jsObj);
	}

	protected void error(String attribute, String value, boolean allowPostCreate) throws IllegalStateException {
		if (allowPostCreate) {
			error("Cannot change configuration property '" + attribute + "' after the component has been rendered.");
		} else {
			error("Cannot change configuration property '" + attribute + "' after the component has been created.");
		}
	}

	protected void error(String message) throws IllegalStateException {
		if (!GWT.isScript()) {
			MessageBox.alert("Error", message);
			throw new IllegalStateException(message);
		}
	}

	protected void check() throws IllegalStateException {
		if (isRendered()) {
			if (GWT.isScript()) {
				MessageBox.alert("Error", "Cannot change configuration property after the component has been rendered");
				throw new IllegalStateException("Cannot change configuration property after the component has been rendered");
			}
		}
	}

	protected String getAttribute(String attribute) {
		if (isCreated()) {
			return JsoHelper.getAttribute(getJsObj(), attribute);
		} else {
			return JsoHelper.getAttribute(config, attribute);
		}
	}

	protected JavaScriptObject getAttributeAsJavaScriptObject(String attribute) {
		if (isCreated()) {
			return JsoHelper.getAttributeAsJavaScriptObject(getJsObj(), attribute);
		} else {
			return JsoHelper.getAttributeAsJavaScriptObject(config, attribute);
		}
	}

	protected int getAttributeAsInt(String attribute) {
		if (isCreated()) {
			return JsoHelper.getAttributeAsInt(getJsObj(), attribute);
		} else {
			return JsoHelper.getAttributeAsInt(config, attribute);
		}
	}

	protected double getAttributeAsDouble(String attribute) {
		if (isCreated()) {
			return JsoHelper.getAttributeAsDouble(getJsObj(), attribute);
		} else {
			return JsoHelper.getAttributeAsDouble(config, attribute);
		}
	}

	protected float getAttributeAsFloat(String attribute) {
		if (isCreated()) {
			return JsoHelper.getAttributeAsFloat(getJsObj(), attribute);
		} else {
			return JsoHelper.getAttributeAsFloat(config, attribute);
		}
	}

	protected boolean getAttributeAsBoolean(String attribute) {
		if (isRendered()) {
			return JsoHelper.getAttributeAsBoolean(getJsObj(), attribute);
		} else {
			return JsoHelper.getAttributeAsBoolean(config, attribute);
		}
	}

	protected void setAttribute(String attribute, String value, boolean allowPostCreate) {
		setAttribute(attribute, value, allowPostCreate, false);
	}

	protected void setAttribute(String attribute, String value, boolean allowPostCreate, boolean allowPostRendered) {
		if (!isCreated()) {
			JsoHelper.setAttribute(config, attribute, value);
		} else if (!isRendered() && allowPostCreate || allowPostRendered) {
			JsoHelper.setAttribute(getJsObj(), attribute, value);
		} else {
			error(attribute, value, allowPostCreate);
		}
	}

	@SuppressWarnings("rawtypes")
	protected void setAttribute(String attribute, Map value, boolean allowPostCreate) {
		setAttribute(attribute, value, allowPostCreate, false);
	}

	@SuppressWarnings("rawtypes")
	protected void setAttribute(String attribute, Map value, boolean allowPostCreate, boolean allowPostRendered) {
		if (!isCreated()) {
			JsoHelper.setAttribute(config, attribute, value);
		} else if (!isRendered() && allowPostCreate || allowPostRendered) {
			JsoHelper.setAttribute(getJsObj(), attribute, value);
		} else {
			error(attribute, value.toString(), allowPostCreate);
		}
	}

	protected void setAttribute(String attribute, int[] value, boolean allowPostCreate) {
		setAttribute(attribute, value, allowPostCreate, false);
	}

	protected void setAttribute(String attribute, int[] value, boolean allowPostCreate, boolean allowPostRender) {
		if (!isCreated()) {
			JsoHelper.setAttribute(config, attribute, value);
		} else if (!isRendered() && allowPostCreate || allowPostRender) {
			JsoHelper.setAttribute(getJsObj(), attribute, value);
		} else {
			error(attribute, value.toString(), allowPostCreate);
		}
	}

	protected void setAttribute(String attribute, long value, boolean allowPostCreate) {
		if (!isCreated()) {
			JsoHelper.setAttribute(config, attribute, value);
		} else if (!isRendered() && allowPostCreate) {
			JsoHelper.setAttribute(getJsObj(), attribute, value);
		} else {
			error(attribute, String.valueOf(value), allowPostCreate);
		}
	}

	protected void setAttribute(String attribute, double value, boolean allowPostCreate) {
		if (!isCreated()) {
			JsoHelper.setAttribute(config, attribute, value);
		} else if (!isRendered() && allowPostCreate) {
			JsoHelper.setAttribute(getJsObj(), attribute, value);
		} else {
			error(attribute, String.valueOf(value), allowPostCreate);
		}
	}

	protected void setAttribute(String attribute, int value, boolean allowPostCreate) {
		setAttribute(attribute, value, allowPostCreate, false);
	}

	protected void setAttribute(String attribute, int value, boolean allowPostCreate, boolean allowPostRender) {
		if (!isCreated()) {
			JsoHelper.setAttribute(config, attribute, value);
		} else if (!isRendered() && allowPostCreate || allowPostRender) {
			JsoHelper.setAttribute(getJsObj(), attribute, value);
		} else {
			error(attribute, String.valueOf(value), allowPostCreate);
		}
	}

	protected void setAttribute(String attribute, Date value, boolean allowPostCreate) {
		if (!isCreated()) {
			JsoHelper.setAttribute(config, attribute, value);
		} else if (!isRendered() && allowPostCreate) {
			JsoHelper.setAttribute(getJsObj(), attribute, value);
		} else {
			error(attribute, String.valueOf(value), allowPostCreate);
		}
	}

	protected void setAttribute(String attribute, JavaScriptObject value, boolean allowPostCreate) {
		setAttribute(attribute, value, allowPostCreate, false);
	}

	protected void setAttribute(String attribute, JavaScriptObject value, boolean allowPostCreate, boolean allowPostRender) {
		if (!isCreated()) {
			JsoHelper.setAttribute(config, attribute, value);
		} else if (!isRendered() && allowPostCreate || allowPostRender) {
			JsoHelper.setAttribute(getJsObj(), attribute, value);
		} else {
			error(attribute, String.valueOf(value), allowPostCreate);
		}
	}

	protected void setAttribute(String attribute, String[] value, boolean allowPostCreate) {
		setAttribute(attribute, value, allowPostCreate, false);
	}

	protected void setAttribute(String attribute, String[] value, boolean allowPostCreate, boolean allowPostRender) {
		if (!isCreated()) {
			JsoHelper.setAttribute(config, attribute, value);
		} else if (!isRendered() && allowPostCreate || allowPostRender) {
			JsoHelper.setAttribute(getJsObj(), attribute, value);
		} else {
			error(attribute, String.valueOf(value), allowPostCreate);
		}
	}

	protected void setAttribute(String attribute, boolean value, boolean allowPostCreate) {
		setAttribute(attribute, value, allowPostCreate, false);
	}

	protected void setAttribute(String attribute, boolean value, boolean allowPostCreate, boolean allowPostRendered) {
		if (!isCreated()) {
			JsoHelper.setAttribute(config, attribute, value);
		} else if (!isRendered() && allowPostCreate || allowPostRendered) {
			JsoHelper.setAttribute(getJsObj(), attribute, value);
		} else {
			error(attribute, String.valueOf(value), allowPostCreate);
		}
	}

	protected void setAttribute(String attribute, Element value, boolean allowPostCreate) {
		setAttribute(attribute, value, allowPostCreate, false);
	}

	protected void setAttribute(String attribute, Element value, boolean allowPostCreate, boolean allowPostRendered) {
		if (!isCreated()) {
			JsoHelper.setAttribute(config, attribute, value);
		} else if (!isRendered() && allowPostCreate || allowPostRendered) {
			JsoHelper.setAttribute(getJsObj(), attribute, value);
		} else {
			error(attribute, String.valueOf(value), allowPostCreate);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.EventDispatcher#addListener( java.lang .String, com.ait.toolkit.sencha.shared.client.core.handlers.AbstractHandler)
	 */
	@Override
	public CallbackRegistration addListener(String event, AbstractHandler handler) {
		return this.addListener(event, handler.getJsoPeer());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.EventDispatcher#addEvent(java .lang .String)
	 */
	@Override
	public void addEvent(String event) {
		delegate.addEvent(event);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.EventDispatcher#fireEvent(java .lang .String)
	 */
	@Override
	public void fireEvent(String event) {
		delegate.fireEvent(event);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.EventDispatcher#purgeListeners()
	 */
	@Override
	public void purgeListeners() {
		delegate.purgeListeners();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.EventDispatcher#resumeEvents()
	 */
	@Override
	public void resumeEvents() {
		delegate.resumeEvents();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.EventDispatcher#suspendEvents()
	 */
	@Override
	public void suspendEvents() {
		delegate.suspendEvents();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void addConfigListener(String event, JavaScriptObject fn) {
		List listeners = (List) configListeners.get(event);
		if (listeners == null)
			listeners = new ArrayList();
		listeners.add(fn);
		configListeners.put(event, listeners);
	}

	protected static native boolean doIsCreated(String id)/*-{
		var cmp = $wnd.Ext.ComponentMgr.get(id);
		return cmp == null || cmp === undefined ? false : true;
	}-*/;
}
