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
package com.ait.toolkit.sencha.touch.charts.client.axis;

import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.touch.client.laf.Position;

/**
 * Gauge Axis is the axis to be used with a Gauge series. The Gauge axis
 * displays numeric data from an interval defined by the minimum, maximum and
 * step configuration properties. The placement of the numeric data can be
 * changed by altering the margin option that is set to 10 by default.
 * 
 */
public class GaugeAxis extends AbstractAxis {

	public GaugeAxis() {
		jsObj = JsoHelper.createObject();
		this.setType("gauge");
		this.setPosition(Position.GAUGE);
	}

	/**
	 * the maximum value of the interval to be displayed in the axis.
	 * 
	 * @param value
	 */
	public void setMinimum(int value) {
		JsoHelper.setAttribute(jsObj, "minimum", value);
	}

	/**
	 * the offset positioning of the tick marks and labels in pixels. Default's
	 * 10.
	 * 
	 * @param value
	 */
	public void setMargin(int value) {
		JsoHelper.setAttribute(jsObj, "margin", value);
	}

	/**
	 * the maximum value of the interval to be displayed in the axis.
	 * 
	 * @param value
	 */
	public void setMaximum(int value) {
		JsoHelper.setAttribute(jsObj, "maximum", value);
	}

	/**
	 * the number of steps and tick marks to add to the interval. Default's 10.
	 * 
	 * @param value
	 */
	public void setSteps(int value) {
		JsoHelper.setAttribute(jsObj, "steps", value);
	}

}
