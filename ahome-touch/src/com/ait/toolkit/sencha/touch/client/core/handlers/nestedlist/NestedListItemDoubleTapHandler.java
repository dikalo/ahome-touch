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

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.shared.client.core.handlers.AbstractHandler;
import com.ait.toolkit.sencha.touch.client.ui.ListDataView;
import com.ait.toolkit.sencha.touch.client.ui.NestedListDataView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class NestedListItemDoubleTapHandler extends AbstractHandler {

	final JavaScriptObject jsoPeer = createPeer(this);

	private static native JavaScriptObject createPeer(
			NestedListItemDoubleTapHandler listener) /*-{
		return function(source, listView, index, item, event, eOpts) {
			var nestedList = @com.ait.toolkit.sencha.touch.client.ui.NestedListDataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
			var listViewObject = @com.ait.toolkit.sencha.touch.client.ui.ListDataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(listView);
			var e = @com.ait.toolkit.sencha.shared.client.core.EventObject::new(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
			listener.@com.ait.toolkit.sencha.touch.client.core.handlers.nestedlist.NestedListItemDoubleTapHandler::fireOnEvent(Lcom/ait/toolkit/sencha/touch/client/ui/NestedListDataView;Lcom/ait/toolkit/sencha/touch/client/ui/ListDataView;ILjava/lang/Object;Lcom/ait/toolkit/sencha/shared/client/core/EventObject;Ljava/lang/Object;)(nestedList, listViewObject, index, item, e, eOpts);
		};
	}-*/;

	// Called from JSNI
	private final void fireOnEvent(NestedListDataView nestedListView,
			ListDataView listView, int index, Object item, EventObject event,
			Object eOpts) {
		UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
		if (handler != null) {
			fireOnEventAndCatch(nestedListView, listView, index, item, event,
					eOpts, handler);
		} else {
			onItemDoubleTap(nestedListView, listView, index, item, event, eOpts);
		}
	}

	private void fireOnEventAndCatch(NestedListDataView nestedListView,
			ListDataView listView, int index, Object item, EventObject event,
			Object eOpts, UncaughtExceptionHandler handler) {
		try {
			onItemDoubleTap(nestedListView, listView, index, item, event, eOpts);
		} catch (Throwable e) {
			handler.onUncaughtException(e);
		}
	}

	@Override
	public JavaScriptObject getJsoPeer() {
		return jsoPeer;
	}

	public abstract void onItemDoubleTap(NestedListDataView nestedListView,
			ListDataView listView, int index, Object item, EventObject event,
			Object eOpts);

}
