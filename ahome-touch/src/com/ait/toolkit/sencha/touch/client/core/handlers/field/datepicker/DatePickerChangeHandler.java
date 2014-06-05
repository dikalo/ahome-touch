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
package com.ait.toolkit.sencha.touch.client.core.handlers.field.datepicker;

import com.ait.toolkit.sencha.shared.client.core.handlers.AbstractHandler;
import com.ait.toolkit.sencha.touch.client.ui.DatePickerField;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsDate;

public abstract class DatePickerChangeHandler extends AbstractHandler {

	final JavaScriptObject jsoPeer = createPeer(this);

	private static native JavaScriptObject createPeer(
			DatePickerChangeHandler listener) /*-{
		return function(source, date, eOpts) {
			var datePicker = @com.ait.toolkit.sencha.touch.client.ui.DatePickerField::new(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
			listener.@com.ait.toolkit.sencha.touch.client.core.handlers.field.datepicker.DatePickerChangeHandler::fireOnEvent(Lcom/ait/toolkit/sencha/touch/client/ui/DatePickerField;Lcom/google/gwt/core/client/JsDate;Ljava/lang/Object;)(datePicker, date, eOpts);
		};
	}-*/;

	// Called from JSNI
	private final void fireOnEvent(DatePickerField datePicker, JsDate date,
			Object eOpts) {
		UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
		if (handler != null) {
			fireOnEventAndCatch(datePicker, date, eOpts, handler);
		} else {
			onChange(datePicker, date, eOpts);
		}
	}

	private void fireOnEventAndCatch(DatePickerField datePicker, JsDate date,
			Object eOpts, UncaughtExceptionHandler handler) {
		try {
			onChange(datePicker, date, eOpts);
		} catch (Throwable e) {
			handler.onUncaughtException(e);
		}
	}

	@Override
	public JavaScriptObject getJsoPeer() {
		return jsoPeer;
	}

	public abstract void onChange(DatePickerField datePicker, JsDate date,
			Object eOpts);

}
