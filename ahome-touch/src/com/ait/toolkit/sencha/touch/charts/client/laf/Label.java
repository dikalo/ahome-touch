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
package com.ait.toolkit.sencha.touch.charts.client.laf;

import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.touch.client.laf.Color;
import com.google.gwt.core.client.JavaScriptObject;

public class Label extends JsObject {

	public Label() {
		jsObj = JsoHelper.createObject();
	}

	public void setField(String field) {
		JsoHelper.setAttribute(jsObj, "field", field);
	}

	public void setTextAnchor(String field) {
		JsoHelper.setAttribute(jsObj, "text-anchor", field);
	}

	public void setOrientation(String field) {
		JsoHelper.setAttribute(jsObj, "orientation", field);
	}

	public void setFill(String field) {
		JsoHelper.setAttribute(jsObj, "fill", field);
	}

	public void setDisplay(String value) {
		JsoHelper.setAttribute(jsObj, "display", value);
	}

	public void setDisplay(boolean value) {
		JsoHelper.setAttribute(jsObj, "display", value);
	}

	public void setContrast(boolean value) {
		JsoHelper.setAttribute(jsObj, "contrast", value);
	}

	public void setFont(String value) {
		JsoHelper.setAttribute(jsObj, "font", value);
	}

	public void setColor(String value) {
		JsoHelper.setAttribute(jsObj, "color", value);
	}

	public void setColor(Color color) {
		setColor(color.getValue());
	}

	public void setRenderer(JavaScriptObject renderer) {
		JsoHelper.setAttribute(jsObj, "renderer", renderer);
	}
}
