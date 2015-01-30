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
package com.ait.toolkit.sencha.touch.client.core.config;

import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.touch.client.ui.DatePickerField;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsDate;

/**
 * Configuration class for DatePicker.
 */
public class DatePickerConfig extends TextConfig {

	public DatePickerConfig() {
		super();
	}

	public void setDestroyPickerOnHide(boolean value) {
		JsoHelper.setAttribute(jsObj,
				TouchAttribute.DESTROY_PICKER_ON_HIDE.getValue(), value);
	}

	protected void setPicker(JavaScriptObject value) {
		JsoHelper.setAttribute(jsObj, TouchAttribute.PICKER.getValue(), value);
	}

	public void setPicker(DatePickerField value) {
		JsoHelper.setAttribute(jsObj, TouchAttribute.PICKER.getValue(), value);
	}

	protected void setValue(JavaScriptObject value) {
		JsoHelper.setAttribute(jsObj, TouchAttribute.VALUE.getValue(), value);
	}

	public void setValue(JsDate value) {
		JsoHelper.setAttribute(jsObj, TouchAttribute.VALUE.getValue(), value);
	}

}
