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
package com.ait.toolkit.sencha.touch.client.core.handlers.layout.card;

import com.ait.toolkit.sencha.shared.client.core.handlers.AbstractHandler;
import com.ait.toolkit.sencha.touch.client.ui.Container;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class ActiveItemChangeHandler extends AbstractHandler {

	final JavaScriptObject jsoPeer = createPeer(this);

	private static native JavaScriptObject createPeer(
			ActiveItemChangeHandler listener) /*-{
		return function(source, value, oldValue, eOpts) {
			var container = @com.ait.toolkit.sencha.touch.client.ui.Container::new(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
			var newTab = newTab ? @com.ait.toolkit.sencha.touch.client.ui.Container::new(Lcom/google/gwt/core/client/JavaScriptObject;)(value)
					: null;
			var oldTab = oldTab ? @com.ait.toolkit.sencha.touch.client.ui.Container::new(Lcom/google/gwt/core/client/JavaScriptObject;)(oldValue)
					: null;
			listener.@com.ait.toolkit.sencha.touch.client.core.handlers.layout.card.ActiveItemChangeHandler::fireOnEvent(Lcom/ait/toolkit/sencha/touch/client/ui/Container;Lcom/ait/toolkit/sencha/touch/client/ui/Container;Lcom/ait/toolkit/sencha/touch/client/ui/Container;Ljava/lang/Object;)(container, newTab, oldTab, eOpts);
		};
	}-*/;

	// Called from JSNI
	private final void fireOnEvent(Container container, Container value,
			Container oldValue, Object eOpts) {
		UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
		if (handler != null) {
			fireOnEventAndCatch(container, value, oldValue, eOpts, handler);
		} else {
			onActiveItemChange(container, value, oldValue, eOpts);
		}
	}

	private void fireOnEventAndCatch(Container container, Container value,
			Container oldValue, Object eOpts, UncaughtExceptionHandler handler) {
		try {
			onActiveItemChange(container, value, oldValue, eOpts);
		} catch (Throwable e) {
			handler.onUncaughtException(e);
		}
	}

	@Override
	public JavaScriptObject getJsoPeer() {
		return jsoPeer;
	}

	public abstract void onActiveItemChange(Container container,
			Container newTab, Container oldTab, Object eOpts);

}
