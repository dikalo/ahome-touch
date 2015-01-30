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

import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.touch.charts.client.handlers.ItemShowHandler;
import com.ait.toolkit.sencha.touch.client.core.config.PanelConfig;
import com.google.gwt.core.client.JavaScriptObject;

public class ItemInfo extends AbstractInteraction {

	public ItemInfo() {
		jsObj = JsoHelper.createObject();
		setType(InteractionType.ITEM_INFO);

	}

	ItemInfo(JavaScriptObject obj) {
		jsObj = obj;
	}

	public native void setPanelConfiguration(PanelConfig config)/*-{
		var jso = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		jso.panel = config.@com.ait.toolkit.core.client.JsObject::getJsObj()();
	}-*/;

	public native void addItemShowHandler(ItemShowHandler handler)/*-{
		var jso = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		jso.listeners = {
			show : function(itemInfo, item, panel) {
				var info = @com.ait.toolkit.sencha.touch.charts.client.interactions.ItemInfo::new(Lcom/google/gwt/core/client/JavaScriptObject;)(itemInfo);
				var chartItem = @com.ait.toolkit.sencha.touch.charts.client.interactions.ChartItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
				var p = @com.ait.toolkit.sencha.touch.client.ui.Panel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(panel);
				handler.@com.ait.toolkit.sencha.touch.charts.client.handlers.ItemShowHandler::onItemShow(Lcom/ait/toolkit/sencha/touch/charts/client/interactions/ItemInfo;Lcom/ait/toolkit/sencha/touch/charts/client/interactions/ChartItem;Lcom/ait/toolkit/sencha/touch/client/ui/Panel;)(info, chartItem,p);
			}
		};
	}-*/;

	public native void setGesture(String value)/*-{
		var jso = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		if (jso.setGesture) {
			jso.setGesture(value);
		} else {
			jso.gesture = value;
		}
	}-*/;

	public ItemInfo cast(AbstractInteraction peer) {
		return new ItemInfo(peer.getJsObj());
	}

}
