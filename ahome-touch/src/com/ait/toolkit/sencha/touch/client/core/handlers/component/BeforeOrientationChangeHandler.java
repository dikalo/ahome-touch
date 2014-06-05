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
package com.ait.toolkit.sencha.touch.client.core.handlers.component;

import com.ait.toolkit.sencha.shared.client.core.handlers.AbstractHandler;
import com.ait.toolkit.sencha.touch.client.ui.Panel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class BeforeOrientationChangeHandler extends AbstractHandler {

	final JavaScriptObject jsoPeer = createPeer(this);

	private static native JavaScriptObject createPeer(
			BeforeOrientationChangeHandler listener) /*-{
		return function(p, orientation, width, height) {
			var panel = @com.ait.toolkit.sencha.touch.client.ui.Panel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(p);
			listener.@com.ait.toolkit.sencha.touch.client.core.handlers.component.BeforeOrientationChangeHandler::fireOnEvent(Lcom/ait/toolkit/sencha/touch/client/ui/Panel;Ljava/lang/String;DD)(panel, orientation, width, height);
		};
	}-*/;

	// Called from JSNI
	private final void fireOnEvent(Panel panel, String orientation,
			double width, double height) {
		UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
		if (handler != null) {
			fireOnEventAndCatch(panel, orientation, width, height, handler);
		} else {
			onBeforeOrientationChange(panel, orientation, width, height);
		}
	}

	private void fireOnEventAndCatch(Panel panel, String orientation,
			double width, double height, UncaughtExceptionHandler handler) {
		try {
			onBeforeOrientationChange(panel, orientation, width, height);
		} catch (Throwable e) {
			handler.onUncaughtException(e);
		}
	}

	@Override
	public JavaScriptObject getJsoPeer() {
		return jsoPeer;
	}

	public abstract void onBeforeOrientationChange(Panel panel,
			String orientation, double width, double height);
}
