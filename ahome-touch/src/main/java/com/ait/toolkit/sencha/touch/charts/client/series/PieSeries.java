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
package com.ait.toolkit.sencha.touch.charts.client.series;

import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.touch.client.laf.Color;
import com.google.gwt.core.client.JsArrayString;

public class PieSeries extends PolarSeries {

	public PieSeries() {
		jsObj = JsoHelper.createObject();
		this.setType("pie");
	}

	/**
	 * The store record field name to be used for the pie angles. The values
	 * bound to this field name must be positive real numbers.
	 * 
	 * @param value
	 */
	public void setAngleField(String value) {
		JsoHelper.setAttribute(jsObj, "angleField", value);
	}

	public void setField(String value) {
		JsoHelper.setAttribute(jsObj, "field", value);
	}

	/**
	 * An array of color values which will be used, in order, as the pie slice
	 * fill colors.
	 * 
	 * @param colors
	 */
	public void setColorSet(Color... colors) {
		JsArrayString strings = JsArrayString.createArray().cast();
		for (Color color : colors) {
			strings.push(color.getValue());
		}
		setColorSet(strings);
	}

	private void setColorSet(JsArrayString values) {
		JsoHelper.setAttribute(jsObj, "colorSet", values);
	}

	/**
	 * Whether to set the pie chart as donut chart. Default's false. Can be set
	 * to a particular percentage to set the radius of the donut chart.
	 * 
	 * @param value
	 */
	public void setDonut(int value) {
		JsoHelper.setAttribute(jsObj, "donut", value);
	}

	/**
	 * Whether to set the pie chart as donut chart. Default's false. Can be set
	 * to a particular percentage to set the radius of the donut chart.
	 * 
	 * @param value
	 */
	public void setDonut(boolean value) {
		JsoHelper.setAttribute(jsObj, "donut", value);
	}

	/**
	 * Extra distance value for which the labelOverflow listener is triggered.
	 * Default to 20.
	 * 
	 * @param value
	 */
	public void setLabelOverflowPadding(int value) {
		JsoHelper.setAttribute(jsObj, "labelOverflowPadding", value);
	}

	/**
	 * The store record field name to be used for the pie slice lengths. The
	 * values bound to this field name must be positive real numbers. This
	 * parameter is optional.
	 * 
	 * @param value
	 */
	public void setLengthField(String value) {
		JsoHelper.setAttribute(jsObj, "LengthField", value);
	}

	/**
	 * The angle in degrees at which the first pie slice should start.
	 * 
	 * @param value
	 */
	public void setRotation(double value) {
		JsoHelper.setAttribute(jsObj, "rotation", value);
	}

	/**
	 * The store record field name to be used for the pie slice labels.
	 * 
	 * @param value
	 */
	public void setLabelField(String value) {
		JsoHelper.setAttribute(jsObj, "labelField", value);
	}

}
