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

import java.util.ArrayList;
import java.util.List;

import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.data.client.BaseModel;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayMixed;

public class ChartItem extends JsObject {

	ChartItem(JavaScriptObject obj) {
		jsObj = obj;
	}

	public native BaseModel getStoreItem()/*-{
		var jso = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		var item = jso.storeItem;
		var toReturn = @com.ait.toolkit.data.client.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
		return toReturn;
	}-*/;

	public native JsArrayMixed getValue()/*-{
		var jso = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return jso.value;
	}-*/;

	static List<ChartItem> fromJsArray(JsArray<JavaScriptObject> array) {
		List<ChartItem> items = new ArrayList<ChartItem>();
		for (int i = 0; i < array.length(); i++) {
			items.add(new ChartItem(array.get(i)));
		}
		return items;
	}
}
