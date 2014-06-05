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
import com.ait.toolkit.sencha.touch.client.ui.ViewPort;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class OrientationChangeHandler extends AbstractHandler {

	final JavaScriptObject jsoPeer = createPeer(this);

	private static native JavaScriptObject createPeer(
			OrientationChangeHandler listener) /*-{
		return function(p, orientation, width, height, eOpts) {
			var viewPort = @com.ait.toolkit.sencha.touch.client.ui.ViewPort::get()();
			listener.@com.ait.toolkit.sencha.touch.client.core.handlers.component.OrientationChangeHandler::fireOnEvent(Lcom/ait/toolkit/sencha/touch/client/ui/ViewPort;Ljava/lang/String;IILjava/lang/Object;)(viewPort, orientation, width, height, eOpts);
		};
	}-*/;

	// Called from JSNI
	private final void fireOnEvent(ViewPort viewPort, String orientation,
			int width, int height, Object eOpts) {
		UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
		if (handler != null) {
			fireOnEventAndCatch(viewPort, orientation, width, height, eOpts,
					handler);
		} else {
			onOrientationChange(viewPort, orientation, width, height, eOpts);
		}
	}

	private void fireOnEventAndCatch(ViewPort viewPort, String orientation,
			int width, int height, Object eOpts,
			UncaughtExceptionHandler handler) {
		try {
			onOrientationChange(viewPort, orientation, width, height, eOpts);
		} catch (Throwable e) {
			handler.onUncaughtException(e);
		}
	}

	@Override
	public JavaScriptObject getJsoPeer() {
		return jsoPeer;
	}

	public abstract void onOrientationChange(ViewPort viewPort,
			String orientation, int width, int height, Object eOpts);

}
