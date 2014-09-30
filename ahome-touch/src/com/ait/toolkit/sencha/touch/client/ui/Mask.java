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
import com.ait.toolkit.sencha.shared.client.core.handlers.CallbackRegistration;
import com.ait.toolkit.sencha.touch.client.core.Component;
import com.ait.toolkit.sencha.touch.client.core.config.Event;
import com.ait.toolkit.sencha.touch.client.core.config.TouchAttribute;
import com.ait.toolkit.sencha.touch.client.core.handlers.mask.MaskTapHandler;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A simple class used to mask any Container. This should rarely be used directly, instead look at the Container.mask configuration.
 * 
 * @see <a href=http://docs.sencha.com/touch/2-0/#!/api/Ext.Mask>Ext.Mask</a>
 */
public class Mask extends Component {

	@Override
	protected native void init()/*-{
		var c = new $wnd.Ext.Mask();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
	}-*/;

	@Override
	public String getXType() {
		return XType.MASK.getValue();
	}

	@Override
	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.Mask(config);
	}-*/;

	public Mask() {
	}

	protected Mask(JavaScriptObject jso) {
		super(jso);
	}

	/**
	 * True to make this mask transparent.
	 * 
	 * Defaults to: false
	 * 
	 * @param value
	 */
	public void setTransparent(String value) {
		setAttribute(TouchAttribute.TRANSPARENT.getValue(), value, true);
	}

	/**
	 * A tap event fired when a user taps on this mask
	 * 
	 * @param handler
	 */
	public CallbackRegistration addTapHandler(MaskTapHandler handler) {
		return this.addWidgetListener(Event.TAP.getValue(), handler.getJsoPeer());
	}

}
