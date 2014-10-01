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
import com.ait.toolkit.sencha.touch.client.core.Component;
import com.ait.toolkit.sencha.touch.client.core.ImageElement;
import com.ait.toolkit.sencha.touch.client.events.HandlerRegistration;
import com.ait.toolkit.sencha.touch.client.events.image.ErrorHandler;
import com.ait.toolkit.sencha.touch.client.events.image.LoadHandler;
import com.ait.toolkit.sencha.touch.client.events.image.TapHandler;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * This is a simple way to add an image of any size to your application and have it participate in the layout system like any other component. This component typically takes
 * between 1 and 3 configurations - a src, and optionally a height and a width.
 * 
 * <a href=http://docs.sencha.com/touch/2-0/#!/api/Ext.Img>Ext.Img</a>
 */
public class Image extends Component implements ImageElement {

	private Image(JavaScriptObject config) {
		super(config);
	}

	protected native void init()/*-{
		var c = new $wnd.Ext.Img();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
	}-*/;

	public String getXType() {
		return XType.IMAGE.getValue();
	}

	/**
	 * Create a new Image.
	 */
	public Image() {
	}

	@Override
	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.Img(config);
	}-*/;

	/**
	 * Sets the value of src
	 */
	@Override
	public native void setSrc(String value) /*-{
		var image = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		image.setSrc(value);
	}-*/;

	/**
	 * Returns the value of src
	 * 
	 * @return
	 */
	public native String getSrc() /*-{
		var image = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return image.getSrc();
	}-*/;

	public native HandlerRegistration AddTapHandler(TapHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(i, e) {
			var img = @com.ait.toolkit.sencha.touch.client.ui.Image::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.image.TapEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/Image;Lcom/google/gwt/core/client/JavaScriptObject;)(img,e);
			handler.@com.ait.toolkit.sencha.touch.client.events.image.TapHandler::onTap(Lcom/ait/toolkit/sencha/touch/client/events/image/TapEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.image.TapEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addLoadHander(LoadHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(i, e) {
			var img = @com.ait.toolkit.sencha.touch.client.ui.Image::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.image.LoadEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/Image;Lcom/google/gwt/core/client/JavaScriptObject;)(img,e);
			handler.@com.ait.toolkit.sencha.touch.client.events.image.LoadHandler::onLoad(Lcom/ait/toolkit/sencha/touch/client/events/image/LoadEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.image.LoadEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addErrorHndler(ErrorHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(i, e) {
			var img = @com.ait.toolkit.sencha.touch.client.ui.Image::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.image.ErrorEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/Image;Lcom/google/gwt/core/client/JavaScriptObject;)(img,e);
			handler.@com.ait.toolkit.sencha.touch.client.events.image.ErrorHandler::onError(Lcom/ait/toolkit/sencha/touch/client/events/image/ErrorHandler;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.image.ErrorEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

}
