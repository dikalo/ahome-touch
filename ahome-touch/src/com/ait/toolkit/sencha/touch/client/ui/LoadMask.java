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
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A simple utility class for generically masking elements while loading data.
 * 
 * @see <a
 *      href=http://docs.sencha.com/touch/2-0/#!/api/Ext.LoadMask>Ext.LoadMask
 *      </a>
 */
public class LoadMask extends Mask {

	private LoadMask(JavaScriptObject config) {
		super(config);
	}

	protected native void init()/*-{
		var c = new $wnd.Ext.LoadMask();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
	}-*/;

	@Override
	public String getXType() {
		return XType.LOADMASK.getValue();
	}

	@Override
	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.LoadMask(config);
	}-*/;

	/**
	 * Create a new LoadMask.
	 */
	public LoadMask() {
	}

	/**
	 * Create a new LoadMask with the given message.
	 */
	public LoadMask(String message) {
		setMessage(message);
	}

	/**
	 * Returns the value of indicator.
	 */
	public native boolean getIndicator() /*-{
		var loadMask = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return loadMask.getIndicator();
	}-*/;

	/**
	 * 
	 * @return the value of msg
	 */
	public native String getMessage() /*-{
		var loadMask = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return loadMask.getMessage();
	}-*/;

	/**
	 * 
	 * @return the value of msg cls
	 */
	public native String getMessageCls() /*-{
		var loadMask = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return loadMask.getMessageCls();
	}-*/;

	/**
	 * Sets the value of indicator.
	 * 
	 * @param indicator
	 */
	public native void setIndicator(boolean indicator) /*-{
		var loadMask = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		loadMask.setIndicator(indicator);
	}-*/;

	/**
	 * sets the value of msg
	 */
	public native void setMessage(String value) /*-{
		var loadMask = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		loadMask.setMessage(value);
	}-*/;

	/**
	 * sets the value of msgCls
	 */
	public native void setMessageCls(String value) /*-{
		var loadMask = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		loadMask.setMessageCls(value);
	}-*/;

}
