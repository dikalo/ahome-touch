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
package com.ait.toolkit.sencha.touch.charts.client.interactions;

import com.ait.toolkit.core.client.Function;
import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.sencha.touch.charts.client.AbstractChart;
import com.google.gwt.core.client.JavaScriptObject;

public class AbstractInteraction extends JsObject {

	protected AbstractInteraction() {

	}

	AbstractInteraction(JavaScriptObject obj) {
		jsObj = obj;
	}

	public native void setGesture(String value)/*-{
		var jso = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		jso.gesture = value;
	}-*/;

	public native void addChartListener(String name, Function fn)/*-{
		var jso = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		jso.addChartListener(name, $entry(function() {
			fn.@com.ait.toolkit.core.client.Function::execute()();
		}));
	}-*/;

	public native void initEvents()/*-{
		var jso = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		jso.initEvents();
	}-*/;

	private native void _setType(String value)/*-{
		var jso = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		jso.type = value;
	}-*/;

	public void setType(InteractionType type) {
		_setType(type.getValue());
	}

	public native void setChart(AbstractChart value)/*-{
		var jso = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		jso.chart = value.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
	}-*/;

	public native void setEnabled(boolean value)/*-{
		var jso = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		jso.enabled = value;
	}-*/;

	public static AbstractInteraction create(JavaScriptObject obj) {
		return new AbstractInteraction(obj) {
		};
	}

}
