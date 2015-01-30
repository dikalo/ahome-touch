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
import com.ait.toolkit.sencha.touch.client.events.filefield.FileChangeHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * The Email field creates an HTML5 email input and is usually created inside a form. Because it creates an HTML email input field, most browsers will show a specialized virtual
 * keyboard for email address input. Aside from that, the email field is just a normal text field
 * 
 */
public class FileField extends Field {

	@Override
	protected native void init()/*-{
		var c = new $wnd.Ext.field.File();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
	}-*/;

	@Override
	public String getXType() {
		return XType.FILE_FIELD.getValue();
	}

	@Override
	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.field.File(config);
	}-*/;

	public FileField() {

	}

	protected FileField(JavaScriptObject jso) {
		super(jso);
	}

	public native String getAccept() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.getAccept();
		}
		return null
	}-*/;

	public native String getCapture() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.getCapture();
		}
		return null
	}-*/;

	public native boolean isMultiple() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.getMultiple();
		}
		return null
	}-*/;

	public native void setAccept(String value) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.setAccept(value);
		}
	}-*/;

	public native void setCapture(String value) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.setCapture(value);
		}
	}-*/;

	public native void setMultiple(boolean value) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.setMultiple(value);
		}
	}-*/;

	public native HandlerRegistration addFileChangeHandler(FileChangeHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, n, o) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.FileField::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.filefield.FileChangeEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/FileField;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(comp,o,n);
			handler.@com.ait.toolkit.sencha.touch.client.events.filefield.FileChangeHandler::onFileChange(Lcom/ait/toolkit/sencha/touch/client/events/filefield/FileChangeEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.filefield.FileChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

}
