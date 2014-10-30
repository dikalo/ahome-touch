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
import com.ait.toolkit.sencha.touch.client.core.Media;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A simple label component which allows you to insert content using html configuration.
 * 
 * @see <a href=http://docs.sencha.com/touch/2-0/#!/api/Ext.Audio>Ext.Audio</a>
 */
public class Audio extends Media {

	protected Audio(JavaScriptObject config) {
		super(config);
	}

	protected native void init()/*-{
		var c = new $wnd.Ext.Audio();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
	}-*/;

	public String getXType() {
		return XType.AUDIO.getValue();
	}

	/**
	 * Create a new Audio.
	 */
	public Audio() {
	}

	@Override
	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.Audio(config);
	}-*/;

	/**
	 * returns the value of url.
	 * 
	 * @return
	 */
	public native String getUrl() /*-{
		var audio = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return audio.getUrl();
	}-*/;

	/**
	 * sets the value of url.
	 * 
	 */
	public native void setUrl(String value) /*-{
		var audio = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		audio.setUrl(value);
	}-*/;

}
