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
package com.ait.toolkit.sencha.touch.client.core.handlers.nestedlist;

import com.ait.toolkit.data.client.BaseModel;
import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.shared.client.core.handlers.AbstractHandler;
import com.ait.toolkit.sencha.touch.client.ui.ListView;
import com.ait.toolkit.sencha.touch.client.ui.NestedListDataView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

public abstract class NestedListItemTapHandler extends AbstractHandler {

	final JavaScriptObject jsoPeer = createPeer(this);

	private static native JavaScriptObject createPeer(
			NestedListItemTapHandler listener) /*-{
		return function(source, list, index, target, record, event, eOpts) {
			var nestedList = @com.ait.toolkit.sencha.touch.client.ui.NestedListDataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
			var model = @com.ait.toolkit.data.client.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
			var listJso = @com.ait.toolkit.sencha.touch.client.ui.ListView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(list);
			var eventObject = @com.ait.toolkit.sencha.shared.client.core.EventObject::new(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
			listener.@com.ait.toolkit.sencha.touch.client.core.handlers.nestedlist.NestedListItemTapHandler::fireOnEvent(Lcom/ait/toolkit/sencha/touch/client/ui/NestedListDataView;Lcom/ait/toolkit/sencha/touch/client/ui/ListView;ILcom/google/gwt/dom/client/Element;Lcom/ait/toolkit/data/client/BaseModel;Lcom/ait/toolkit/sencha/shared/client/core/EventObject;Ljava/lang/Object;)(nestedList, listJso, index, target, model, eventObject, eOpts);
		};
	}-*/;

	// Called from JSNI
	private final void fireOnEvent(NestedListDataView nestedList,
			ListView list, int index, Element target, BaseModel record,
			EventObject event, Object eOpts) {
		UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
		if (handler != null) {
			fireOnEventAndCatch(nestedList, list, index, target, record, event,
					eOpts, handler);
		} else {
			onItemTap(nestedList, list, index, target, record, event, eOpts);
		}
	}

	private void fireOnEventAndCatch(NestedListDataView nestedList,
			ListView list, int index, Element target, BaseModel record,
			EventObject event, Object eOpts, UncaughtExceptionHandler handler) {
		try {
			onItemTap(nestedList, list, index, target, record, event, eOpts);
		} catch (Throwable e) {
			handler.onUncaughtException(e);
		}
	}

	@Override
	public JavaScriptObject getJsoPeer() {
		return jsoPeer;
	}

	public abstract void onItemTap(NestedListDataView nestedList,
			ListView list, int index, Element target, BaseModel record,
			EventObject event, Object eOpts);

}
