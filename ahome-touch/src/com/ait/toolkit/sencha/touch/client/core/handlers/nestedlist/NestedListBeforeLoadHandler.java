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

import com.ait.toolkit.sencha.shared.client.data.Store;
import com.ait.toolkit.sencha.shared.client.core.handlers.AbstractHandler;
import com.ait.toolkit.sencha.touch.client.ui.NestedListDataView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class NestedListBeforeLoadHandler extends AbstractHandler {

	final JavaScriptObject jsoPeer = createPeer(this);

	private static native JavaScriptObject createPeer(
			NestedListBeforeLoadHandler listener) /*-{
		return function(source, store, operation, eOpts, handler) {
			var nestedList = @com.ait.toolkit.sencha.touch.client.ui.NestedListDataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
			listener.@com.ait.toolkit.sencha.touch.client.core.handlers.nestedlist.NestedListBeforeLoadHandler::fireOnEvent(Lcom/ait/toolkit/sencha/touch/client/ui/NestedListDataView;Lcom/ait/toolkit/sencha/shared/client/data/Store;Ljava/lang/Object;Ljava/lang/Object;)(nestedList, store, operation, eOpts, handler);
		};
	}-*/;

	// Called from JSNI
	private final void fireOnEvent(NestedListDataView nestedList, Store store,
			Object operation, Object eOpts) {
		UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
		if (handler != null) {
			fireOnEventAndCatch(nestedList, store, operation, eOpts, handler);
		} else {
			onBeforeLoad(nestedList, store, operation, eOpts);
		}
	}

	private void fireOnEventAndCatch(NestedListDataView nestedList,
			Store store, Object operation, Object eOpts,
			UncaughtExceptionHandler handler) {
		try {
			onBeforeLoad(nestedList, store, operation, eOpts);
		} catch (Throwable e) {
			handler.onUncaughtException(e);
		}
	}

	@Override
	public JavaScriptObject getJsoPeer() {
		return jsoPeer;
	}

	public abstract void onBeforeLoad(NestedListDataView nestedList,
			Store store, Object operation, Object eOpts);

}
