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

import com.ait.toolkit.sencha.shared.client.data.Store;
import com.ait.toolkit.sencha.touch.charts.client.AbstractChart;
import com.ait.toolkit.sencha.shared.client.core.XType;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Represents a chart that uses cartesian coordinates. A cartesian chart have
 * two directions, X direction and Y direction. The series and axes are
 * coordinated along these directions. By default the x direction is horizontal
 * and y direction is vertical, You can swap the by setting flipXY config to
 * true.
 * <p>
 * Cartesian series often treats x direction an y direction differently. In most
 * cases, data on x direction are assumed to be monotonically increasing. Based
 * on this property, cartesian series can be trimmed and summarized properly to
 * gain a better performance.
 */
public class CartesianChart extends AbstractChart {

	protected static JavaScriptObject configPrototype;

	protected native void init()/*-{
		var c = new $wnd.Ext.chart.CartesianChart();
		@com.ait.toolkit.sencha.touch.client.ui.CartesianChart::configPrototype = c.initialConfig;
	}-*/;

	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}

	public String getXType() {
		return XType.CHART.getValue();
	}

	/**
	 * Create a new AbstractChart Panel.
	 */
	public CartesianChart() {

	}

	public CartesianChart(Store store) {
		setStore(store);
		// setTheme(Theme.BASE);
	}

	/**
	 * Layout the axes and series.
	 */
	public native void performLayout()/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		component.performLayout();
	}-*/;

	/**
	 * Sets the value of flipXY.
	 */
	public native void setFlipXY(boolean value)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		component.setFlipXY(value);
	}-*/;

	/**
	 * Returns the value of flipXY.
	 */
	public native boolean getFlipXY()/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return component.getFlipXY();
	}-*/;

	// public CartesianChart(Store store, Theme theme) {
	// setStore(store);
	// setTheme(theme);
	// }

	protected CartesianChart(JavaScriptObject jsObj) {
		super(jsObj);
	}

	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.chart.CartesianChart(config);
	}-*/;

	public static CartesianChart cast(AbstractChart chart) {
		return new CartesianChart(chart.getOrCreateJsObj());
	}

}
