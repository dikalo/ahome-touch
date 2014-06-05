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
package com.ait.toolkit.sencha.touch.client.core.handlers.field.slider;

import com.ait.toolkit.sencha.shared.client.core.handlers.AbstractHandler;
import com.ait.toolkit.sencha.touch.client.ui.Slider;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class SliderChangeHandler extends AbstractHandler {

	final JavaScriptObject jsoPeer = createPeer(this);

	private static native JavaScriptObject createPeer(
			SliderChangeHandler listener) /*-{
		return function(source, slider, thumb, newValue, oldValue, eOpts) {
			var slider = @com.ait.toolkit.sencha.touch.client.ui.Slider::new(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
			listener.@com.ait.toolkit.sencha.touch.client.core.handlers.field.slider.SliderChangeHandler::fireOnEvent(Lcom/ait/toolkit/sencha/touch/client/ui/Slider;IILjava/lang/Object;)(slider,  newValue, oldValue, eOpts);

		};
	}-*/;

	// Called from JSNI
	private final void fireOnEvent(Slider slider, int newValue, int oldValue,
			Object eOpts) {
		UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
		if (handler != null) {
			fireOnEventAndCatch(slider, newValue, oldValue, eOpts, handler);
		} else {
			onChange(slider, newValue, oldValue, eOpts);
		}
	}

	private void fireOnEventAndCatch(Slider slider, int newValue, int oldValue,
			Object eOpts, UncaughtExceptionHandler handler) {
		try {
			onChange(slider, newValue, oldValue, eOpts);
		} catch (Throwable e) {
			handler.onUncaughtException(e);
		}
	}

	@Override
	public JavaScriptObject getJsoPeer() {
		return jsoPeer;
	}

	public abstract void onChange(Slider slider, int newValue, int oldValue,
			Object eOpts);

}
