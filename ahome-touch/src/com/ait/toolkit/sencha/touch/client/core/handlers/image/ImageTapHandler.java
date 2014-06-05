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
package com.ait.toolkit.sencha.touch.client.core.handlers.image;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.shared.client.core.handlers.AbstractHandler;
import com.ait.toolkit.sencha.touch.client.ui.Image;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class ImageTapHandler extends AbstractHandler {

	final JavaScriptObject jsoPeer = createPeer(this);

	private static native JavaScriptObject createPeer(ImageTapHandler listener) /*-{
		return function(source, eventObject, eOpts) {
			var image = @com.ait.toolkit.sencha.touch.client.ui.Image::new(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
			var e = @com.ait.toolkit.sencha.shared.client.core.EventObject::new(Lcom/google/gwt/core/client/JavaScriptObject;)(eventObject);
			listener.@com.ait.toolkit.sencha.touch.client.core.handlers.image.ImageTapHandler::fireOnEvent(Lcom/ait/toolkit/sencha/touch/client/ui/Image;Lcom/ait/toolkit/sencha/shared/client/core/EventObject;Ljava/lang/Object;)(image, e, eOpts);
		};
	}-*/;

	// Called from JSNI
	private final void fireOnEvent(Image image, EventObject eventObject,
			Object eOpts) {
		UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
		if (handler != null) {
			fireOnEventAndCatch(image, eventObject, eOpts, handler);
		} else {
			onTap(image, eventObject, eOpts);
		}
	}

	private void fireOnEventAndCatch(Image image, EventObject eventObject,
			Object eOpts, UncaughtExceptionHandler handler) {
		try {
			onTap(image, eventObject, eOpts);
		} catch (Throwable e) {
			handler.onUncaughtException(e);
		}
	}

	@Override
	public JavaScriptObject getJsoPeer() {
		return jsoPeer;
	}

	public abstract void onTap(Image image, EventObject eventObject,
			Object eOpts);

}
