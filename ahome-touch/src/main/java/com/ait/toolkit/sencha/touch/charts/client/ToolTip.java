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
package com.ait.toolkit.sencha.touch.charts.client;

import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.touch.charts.client.laf.ToolTipRenderer;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A tooltip to the visualization's markers for charts
 * 
 */
public class ToolTip extends JsObject {

	public ToolTip() {
		jsObj = JsoHelper.createObject();
	}

	ToolTip(JavaScriptObject obj) {
		jsObj = obj;
	}

	/**
	 * True to have the tooltip follow the mouse as it moves over the target
	 * element.
	 * 
	 * @param value
	 */
	public void setTrackMouse(boolean value) {
		JsoHelper.setAttribute(jsObj, "trackMouse", value);
	}

	public boolean trackMouse() {
		return JsoHelper.getAttributeAsBoolean(jsObj, "trackMouse");
	}

	public void setWidth(double value) {
		JsoHelper.setAttribute(jsObj, "width", value);
	}

	public double getWidth() {
		return JsoHelper.getAttributeAsDouble(jsObj, "width");
	}

	public void setHeight(double value) {
		JsoHelper.setAttribute(jsObj, "height", value);
	}

	public double getHeight() {
		return JsoHelper.getAttributeAsDouble(jsObj, "height");
	}

	public native void setRenderer(ToolTipRenderer renderer)/*-{
		var jso = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		jso.renderer = function(sroteItem, item) {
			var model = @com.ait.toolkit.data.client.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(storeItem);
			var chartItem = @com.ait.toolkit.sencha.touch.charts.client.interactions.ChartItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
			renderer.@com.ait.toolkit.sencha.touch.charts.client.laf.ToolTipRenderer::onRender(Lcom/ait/toolkit/data/client/BaseModel;Lcom/ait/toolkit/sencha/touch/charts/client/interactions/ChartItem;)(model, chartItem);
		};
	}-*/;

	public void setAnchor(String value) {
		JsoHelper.setAttribute(jsObj, "anchor", value);
	}

	public void setAnchorOffset(double value) {
		JsoHelper.setAttribute(jsObj, "anchorOffset", value);
	}

	public void setAnchorToTarget(boolean value) {
		JsoHelper.setAttribute(jsObj, "anchorToTarget", value);
	}

	public void setAntoHide(boolean value) {
		JsoHelper.setAttribute(jsObj, "autoHide", value);
	}

	public void setDismissDelay(int value) {
		JsoHelper.setAttribute(jsObj, "dissmissDelay", value);
	}

	public void hideDelay(int value) {
		JsoHelper.setAttribute(jsObj, "hideDelay", value);
	}

	public void setShowDelay(double value) {
		JsoHelper.setAttribute(jsObj, "showDelay", value);
	}

}
