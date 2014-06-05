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
package com.ait.toolkit.sencha.touch.client.ui;

import java.util.List;

import com.ait.toolkit.core.client.Attribute;
import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.touch.client.laf.Alignment;
import com.google.gwt.core.client.JavaScriptObject;

public class PickerSlot extends JsObject {

	public PickerSlot() {
		jsObj = JavaScriptObject.createObject();
	}

	public void setName(String name) {
		JsoHelper.setAttribute(jsObj, Attribute.NAME.getValue(), name);
	}

	public final void setAlign(Alignment align) {
		this._setAlign(align.getValue());
	}

	public void _setAlign(String align) {
		JsoHelper.setAttribute(jsObj, Attribute.ALIGN.getValue(), align);
	}

	public void setTitle(String title) {
		JsoHelper.setAttribute(jsObj, Attribute.TITLE.getValue(), title);
	}

	public final void setData(List<PickerSlotData> values) {
		Object[] array = new Object[values.size()];
		for (int i = 0; i < values.size(); i++) {
			array[i] = values.get(i);
		}
		JsoHelper.setAttribute(jsObj, Attribute.DATA.getValue(),
				JsoHelper.convertToJavaScriptArray(array));
	}
}
