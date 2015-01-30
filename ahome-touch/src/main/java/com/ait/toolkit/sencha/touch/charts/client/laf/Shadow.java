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
package com.ait.toolkit.sencha.touch.charts.client.laf;

import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.touch.client.core.config.BaseConfig;
import com.ait.toolkit.sencha.touch.client.laf.Color;

/**
 * User for shadow configuration
 * 
 */
public class Shadow extends BaseConfig {

	public Shadow() {
		jsObj = JsoHelper.createObject();
	}

	public Shadow(double offsetX, double offsetY) {
		this();
		setShadowOffsetX(offsetX);
		setShadowOffsetX(offsetY);

	}

	public Shadow(double offsetX, double offsetY, Color color) {
		this(offsetX, offsetX);
		setShadowColor(color);
	}

	public void setShadowOffsetY(double value) {
		JsoHelper.setAttribute(jsObj, "shadowOffsetY", value);
	}

	public void setShadowOffsetX(double value) {
		JsoHelper.setAttribute(jsObj, "shadowOffsetX", value);
	}

	public void setShadowBlur(double value) {
		JsoHelper.setAttribute(jsObj, "shadowBlur", value);
	}

	public void setShadowColor(Color color) {
		JsoHelper.setAttribute(jsObj, "shadowColor", color.getValue());
	}
}
