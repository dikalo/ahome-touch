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
package com.ait.toolkit.sencha.touch.client.core.handlers.dataview;

import com.ait.toolkit.data.client.BaseModel;
import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.shared.client.core.handlers.AbstractHandler;
import com.ait.toolkit.sencha.touch.client.dataview.SimpleListItem;
import com.ait.toolkit.sencha.touch.client.ui.DataView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class DataViewItemTouchStartHandler extends AbstractHandler {

	final JavaScriptObject jsoPeer = createPeer(this);

	private static native JavaScriptObject createPeer(
			DataViewItemTouchStartHandler listener) /*-{
		return function(source, index, element, record, eventObject) {
			var dataView = @com.ait.toolkit.sencha.touch.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
			var event = @com.ait.toolkit.sencha.shared.client.core.EventObject::new(Lcom/google/gwt/core/client/JavaScriptObject;)(eventObject);
			var item = @com.ait.toolkit.sencha.touch.client.dataview.SimpleListItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(element);
			var rec = @com.ait.toolkit.data.client.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
			listener.@com.ait.toolkit.sencha.touch.client.core.handlers.dataview.DataViewItemTouchStartHandler::fireOnEvent(Lcom/ait/toolkit/sencha/touch/client/ui/DataView;ILcom/ait/toolkit/sencha/touch/client/dataview/SimpleListItem;Lcom/ait/toolkit/data/client/BaseModel;Lcom/ait/toolkit/sencha/shared/client/core/EventObject;)(dataView,index,item,rec,event);
		}
	}-*/;

	// Called from JSNI
	private final void fireOnEvent(DataView dataView, int index,
			SimpleListItem element, BaseModel record, EventObject eventObject) {
		UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
		if (handler != null) {
			fireOnEventAndCatch(dataView, index, element, record, eventObject,
					handler);
		} else {
			onItemTouchStart(dataView, index, element, record, eventObject);
		}
	}

	private void fireOnEventAndCatch(DataView dataView, int index,
			SimpleListItem element, BaseModel record, EventObject eventObject,
			UncaughtExceptionHandler handler) {
		try {
			onItemTouchStart(dataView, index, element, record, eventObject);
		} catch (Throwable e) {
			handler.onUncaughtException(e);
		}
	}

	@Override
	public JavaScriptObject getJsoPeer() {
		return jsoPeer;
	}

	public abstract void onItemTouchStart(DataView dataView, int index,
			SimpleListItem element, BaseModel record, EventObject eventObject);

}
