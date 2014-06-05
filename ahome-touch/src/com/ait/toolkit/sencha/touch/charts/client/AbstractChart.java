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
package com.ait.toolkit.sencha.touch.charts.client;

import java.util.ArrayList;
import java.util.List;

import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.shared.client.core.handlers.CallbackRegistration;
import com.ait.toolkit.sencha.shared.client.data.Store;
import com.ait.toolkit.sencha.touch.charts.client.axis.AbstractAxis;
import com.ait.toolkit.sencha.touch.charts.client.handlers.BeforeRefreshHandler;
import com.ait.toolkit.sencha.touch.charts.client.handlers.ChartChangeHandler;
import com.ait.toolkit.sencha.touch.charts.client.handlers.ChartEventHandler;
import com.ait.toolkit.sencha.touch.charts.client.interactions.AbstractInteraction;
import com.ait.toolkit.sencha.touch.charts.client.interactions.InteractionType;
import com.ait.toolkit.sencha.touch.charts.client.interactions.SavingType;
import com.ait.toolkit.sencha.touch.charts.client.laf.Gradient;
import com.ait.toolkit.sencha.touch.charts.client.laf.Shadow;
import com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries;
import com.ait.toolkit.sencha.touch.charts.client.theme.Theme;
import com.ait.toolkit.sencha.touch.client.laf.Color;
import com.ait.toolkit.sencha.touch.client.laf.Position;
import com.ait.toolkit.sencha.touch.client.ui.DrawComponent;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;

/**
 * The AbstractChart component provides the capability to visualize data. Each
 * chart binds directly to a Store enabling automatic updates of the chart.
 */
public abstract class AbstractChart extends DrawComponent {

	private static final String BEFORE_REFRESH = "beforerefresh";
	private static final String ITEM_CLICK = "itemclick";
	private static final String ITEM_DOUBLE_CLICK = "itemdoubleclick";
	private static final String ITEM_DOUBLE_TAP = "itemdoubletap";
	private static final String ITEM_DRAG = "itemdrag";
	private static final String ITEM_DRAG_END = "itemdragend";
	private static final String ITEM_DRAG_START = "itemdragstart";
	private static final String ITEM_MOUSE_DOWN = "itemmousedown";
	private static final String ITEM_MOUSE_MOVE = "itemmousemove";
	private static final String ITEM_MOUSE_OUT = "itemmouseout";
	private static final String ITEM_MOUSE_OVER = "itemmouseover";
	private static final String ITEM_MOUSE_UP = "itemmouseup";
	private static final String ITEM_PINCH = "itempinch";
	private static final String ITEM_PINCH_END = "itempinchend";
	private static final String ITEM_PINCH_START = "itempinchstart";
	private static final String ITEM_SINGLE_TAP = "itemsingletap";
	private static final String ITEM_SWIPE = "itemswipe";
	private static final String ITEM_TAP = "itemtap";
	private static final String ITEM_TAP_CANCEL = "itemtapcancel";
	private static final String ITEM_TAP_END = "itemtapend";
	private static final String ITEM_TAP_HOLD = "itemtaphold";
	private static final String ITEM_TAP_START = "itemtapstart";
	private static final String ITEM_TOUCH_END = "itemtouchend";
	private static final String ITEM_TOUCH_MOVE = "itemtouchmove";
	private static final String ITEM_TOUCH_START = "itemtouchstart";
	private static final String REDRAW = "redraw";
	private static final String REFRESH = "refresh";

	protected static JavaScriptObject configPrototype;
	protected Store store;
	protected List<AbstractSeries> series = new ArrayList<AbstractSeries>();
	protected List<AbstractAxis> axis = new ArrayList<AbstractAxis>();
	protected List<AbstractInteraction> interactions = new ArrayList<AbstractInteraction>();
	protected List<Gradient> gradients = new ArrayList<Gradient>();

	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}

	/**
	 * Create a new AbstractChart Panel.
	 */
	protected AbstractChart() {

	}

	protected AbstractChart(JavaScriptObject obj) {
		super(obj);
	}

	/**
	 * The name of the theme to be used. A theme defines the colors and other
	 * visual displays of tick marks on axis, text, title text, line colors,
	 * marker colors and styles, etc. Possible theme values are 'Base', 'Green',
	 * 'Sky', 'Red', 'Purple', 'Blue', 'Yellow' and also six category themes
	 * 'Category1' to 'Category6'. Default value is 'Base'.
	 * 
	 * @param theme
	 */
	public void setTheme(Theme theme) {
		setTheme(theme.getValue());
	}

	/**
	 * Adds a given Axis to this chart
	 * 
	 * @param axis
	 */
	public void addAxis(AbstractAxis axis) {
		this.axis.add(axis);
	}

	/**
	 * draw the axis of this chart
	 */
	public void drawAxis() {
		if (this.axis.size() <= 0) {
			throw new RuntimeException(
					"You must add add atleast one axis to the chart before calling drawAxis");
		}
		this.setAxes(this.axis);
	}

	/**
	 * Get the axis of this chart
	 * 
	 * @return
	 */
	public List<AbstractAxis> getAxis() {
		return _getAxisPeers();
	}

	private List<AbstractAxis> _getAxisPeers() {
		List<AbstractAxis> toReturn = new ArrayList<AbstractAxis>();
		JavaScriptObject nativePeers = _getAxis();
		if (nativePeers != null) {
			int size = JsoHelper.getArrayLength(nativePeers);
			for (int i = 0; i < size; i++) {
				AbstractAxis serie = AbstractAxis.create(JsoHelper
						.getValueFromJavaScriptObjectArray(nativePeers, i));
				toReturn.add(serie);
			}
		}
		return toReturn;
	}

	private native JavaScriptObject _getAxis()/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component) {
			return $wnd.Ext.ComponentQuery.query('axis', component);
		}
		return null;
	}-*/;

	/**
	 * set a list of AbstractAxis instances.
	 * 
	 * @param axes
	 */
	public void setAxes(List<AbstractAxis> axes) {
		JsArray<JavaScriptObject> jsos = JsArray.createArray().cast();
		for (AbstractAxis axe : axes) {
			jsos.push(axe.getJsObj());
		}
		setAttribute("axes", jsos, true);

	}

	public void setAxes(AbstractAxis... axes) {
		JsArray<JavaScriptObject> jsos = JsArray.createArray().cast();
		for (AbstractAxis axe : axes) {
			jsos.push(axe.getJsObj());
		}
		setAttribute("axes", jsos, true);
	}

	/**
	 * Add a given series to this chart
	 * 
	 * @param series
	 */
	public void addSeries(AbstractSeries series) {
		this.series.add(series);
	}

	/**
	 * draw the series of this chart
	 */
	public void drawSeries() {
		if (this.series.size() <= 0) {
			throw new RuntimeException(
					"You must add add atleast one series to the chart before calling drawSeries");
		}
		this.setSeries(this.series);
	}

	/**
	 * Get the series of this chart
	 * 
	 * @return
	 */
	public List<AbstractSeries> getSeries() {
		return _getSeriesNativePeers();
	}

	private List<AbstractSeries> _getSeriesNativePeers() {
		List<AbstractSeries> toReturn = new ArrayList<AbstractSeries>();
		JavaScriptObject nativePeers = _getSeries();
		if (nativePeers != null) {
			int size = JsoHelper.getArrayLength(nativePeers);
			for (int i = 0; i < size; i++) {
				AbstractSeries serie = AbstractSeries.create(JsoHelper
						.getValueFromJavaScriptObjectArray(nativePeers, i));
				toReturn.add(serie);
			}
		}
		return toReturn;
	}

	private native JavaScriptObject _getSeries()/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component) {
			return $wnd.Ext.ComponentQuery.query('series', component);
		}
		return null;
	}-*/;

	/**
	 * set a list of Series instances or config objects
	 * 
	 * @param series
	 */
	public void setSeries(List<AbstractSeries> series) {
		JsArray<JavaScriptObject> jsos = JsArray.createArray().cast();
		for (AbstractSeries serie : series) {
			jsos.push(serie.getJsObj());
		}
		setAttribute("series", jsos, true);
	}

	public void setSeries(AbstractSeries... series) {
		JsArray<JavaScriptObject> jsos = JsArray.createArray().cast();
		for (AbstractSeries serie : series) {
			jsos.push(serie.getJsObj());
		}
		setAttribute("series", jsos, true);
	}

	/**
	 * The store that supplies data to this chart.
	 * 
	 * @param store
	 */
	public void setStore(Store store) {
		this.store = store;
		setAttribute("store", store.getJsObj(), true);
	}

	/**
	 * set a legend config
	 * 
	 * @param legend
	 */
	public void setLegend(Legend legend) {
		setAttribute("legend", legend.getJsObj(), true);
	}

	/**
	 * true for the default legend display.
	 * 
	 * @param legend
	 */
	public void setLegend(boolean legend) {
		setAttribute("legend", legend, true);
	}

	/**
	 * 
	 * true for the default shadow configuration
	 * 
	 * @param value
	 */
	public void setShadow(boolean value) {
		setAttribute("shadow", value, true);
	}

	/**
	 * shadow config object to be used for default chart shadows.
	 * 
	 * @param value
	 */
	public void setShadow(Shadow value) {
		setAttribute("shadow", value.getJsObj(), true);
	}

	/**
	 * Turn on autoSize support which will set the bounding div's size to the
	 * natural size of the contents.
	 * 
	 * @param value
	 */
	public void setAutoSize(boolean value) {
		setAttribute("autosize", value, true);
	}

	/**
	 * (optional) true for the default animation (easing: 'ease' and duration:
	 * 500) or a standard animation config object to be used for default chart
	 * animations.
	 * 
	 * Defaults to: false
	 * 
	 * @param value
	 */
	public void setAnimate(boolean value) {
		setAttribute("animate", value, true, true);
	}

	/**
	 * (optional) true for the default animation (easing: 'ease' and duration:
	 * 500) or a standard animation config object to be used for default chart
	 * animations.
	 * 
	 * Defaults to: false
	 * 
	 * @param value
	 */
	public void setAnimate(Animation value) {
		setAttribute("animate", value.getJsObj(), true, true);
	}

	public void setInsetPadding(int value) {
		setAttribute("insetPadding", value, true, true);
	}

	public void setInnerPadding(int value) {
		setAttribute("innerPadding", value, true, true);
	}

	/**
	 * Set the chart background
	 * 
	 * @param value
	 */
	public void setBackGround(Color value) {
		setAttribute("background", createFill(value.getValue()), true);
	}

	/**
	 * Set the chart background
	 * 
	 * @param value
	 */
	public void setBackGround(String image) {
		setAttribute("background", createImage(image), true);
	}

	/**
	 * Set the chart background
	 * 
	 * @param value
	 */
	public void setBackGround(Gradient value) {
		setAttribute("background", createGradient(value.getJsObj()), true);
	}

	/**
	 * Array of gradients to override the color of items and legends.
	 * 
	 * @param values
	 */
	public void setColors(Gradient... values) {
		JsArray<JavaScriptObject> gradients = JsArray.createArray().cast();
		for (Gradient g : values) {
			gradients.push(g.getJsObj());
		}
		setAttribute("colors", gradients, true, true);
	}

	/**
	 * Array of gradients to override the color of items and legends.
	 * 
	 * @param values
	 */
	public void setColors(List<Gradient> values) {
		JsArray<JavaScriptObject> gradients = JsArray.createArray().cast();
		for (Gradient g : values) {
			gradients.push(g.getJsObj());
		}
		setAttribute("colors", gradients, true, true);
	}

	/**
	 * Array of colors to override the color of items and legends.
	 * 
	 * @param values
	 */
	public void setColors(Color... values) {
		JsArrayString colors = JsArray.createArray().cast();
		for (Color c : values) {
			colors.push(c.getValue());
		}
		setAttribute("colors", colors, true, true);
	}

	public void setColors(String... values) {
		JsArrayString colors = JsArray.createArray().cast();
		for (String c : values) {
			colors.push(c);
		}
		setAttribute("colors", colors, true, true);
	}

	/**
	 * Define a set of gradients that can be used as fill property in sprites.
	 * ...
	 * 
	 * @param values
	 */
	public void setGradients(Gradient... values) {
		JsArray<JavaScriptObject> gradients = JsArray.createArray().cast();
		for (Gradient g : values) {
			gradients.push(g.getJsObj());
		}
		setAttribute("gradients", gradients, true, true);
	}

	/**
	 * Add a gradient to this chart
	 */
	public void addGradient(Gradient gradient) {
		this.gradients.add(gradient);
	}

	/**
	 * draw the axis of this chart
	 */
	public void drawGradients() {
		if (this.gradients.size() <= 0) {
			throw new RuntimeException(
					"You must add add atleast one gradient to the chart before calling drawGradients");
		}
		this.setColors(this.gradients);
	}

	/**
	 * Set the chart background
	 * 
	 * @param value
	 */
	public void setInsetPadding(double value) {
		setAttribute("insetPadding", value, true);
	}

	/**
	 * The class name used only in theming system.
	 * 
	 * @param value
	 */
	public void setThemeCls(String value) {
		setAttribute("themeCls", value, true);
	}

	/**
	 * The position at which the toolbar should be docked in relation to the
	 * chart.
	 * 
	 * @param position
	 */
	public void setToolbar(Position position) {
		setAttribute("toolbar", createToolbarPosition(position.getValue()),
				true);
	}

	public native Toolbar getToolbar()/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var tb = component.getToolbar();
		var toReturn = @com.ait.toolkit.sencha.touch.charts.client.Toolbar::new(Lcom/google/gwt/core/client/JavaScriptObject;)(tb);
		return toReturn;
	}-*/;

	/**
	 * Turn on view box support which will scale and position items in the draw
	 * component to fit to the component while maintaining aspect ratio. Note
	 * that this scaling can override other sizing settings on yor items.
	 * 
	 * @param position
	 */
	public void setViewBox(boolean value) {
		setAttribute("viewBox", value, true);
	}

	/**
	 * return the Store bound to this chart
	 * 
	 * @return
	 */
	public Store getStore() {
		return this.store;
	}

	private native JavaScriptObject createToolbarPosition(String value)/*-{
		return {
			position : value
		}
	}-*/;

	/**
	 * Add a given interaction to this chart
	 * 
	 * @param interaction
	 */
	public void addInteraction(AbstractInteraction interaction) {
		this.interactions.add(interaction);
		this.setInteractions(this.interactions);
	}

	/**
	 * Interactions are optional modules that can be plugged in to a chart to
	 * allow the user to interact with the chart and its data in special ways
	 * 
	 * @param interactions
	 */
	public void setInteractions(List<AbstractInteraction> interactions) {
		JsArray<JavaScriptObject> values = JsArray.createArray().cast();
		for (AbstractInteraction interaction : interactions) {
			values.push(interaction.getJsObj());
		}
		_setInteractions(values);
	}

	/**
	 * Interactions are optional modules that can be plugged in to a chart to
	 * allow the user to interact with the chart and its data in special ways
	 * 
	 * @param interactions
	 */
	public void setInteractions(AbstractInteraction... interactions) {
		JsArray<JavaScriptObject> values = JsArray.createArray().cast();
		for (AbstractInteraction interaction : interactions) {
			values.push(interaction.getJsObj());
		}
		_setInteractions(values);
	}

	public void setInteractions(InteractionType... interactions) {
		JsArrayString values = JsArrayString.createArray().cast();
		for (InteractionType type : interactions) {
			values.push(type.getValue());
		}
		_setInteractions(values);
	}

	public void setInteractions(String... interactions) {
		JsArrayString values = JsArrayString.createArray().cast();
		for (String s : interactions) {
			values.push(s);
		}
		_setInteractions(values);
	}

	public List<AbstractInteraction> getInteractions() {
		return _getInteraction();
	}

	private List<AbstractInteraction> _getInteraction() {
		List<AbstractInteraction> toReturn = new ArrayList<AbstractInteraction>();
		JavaScriptObject nativePeers = _getAxis();
		if (nativePeers != null) {
			int size = JsoHelper.getArrayLength(nativePeers);
			for (int i = 0; i < size; i++) {
				AbstractInteraction serie = AbstractInteraction
						.create(JsoHelper.getValueFromJavaScriptObjectArray(
								nativePeers, i));
				toReturn.add(serie);
			}
		}
		return toReturn;
	}

	private native JavaScriptObject _getInteractions()/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component) {
			return component.getInteraction();
		}
		return null;
	}-*/;

	/**
	 * Changes the data store bound to this chart and refreshes it.
	 * 
	 * @param store
	 */
	public native void bindStore(Store store)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		component
				.bindStore(store.@com.ait.toolkit.core.client.JsObject::getJsObj()());
	}-*/;

	/**
	 * Cancel the last queued timeout
	 */
	public native void cancel()/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		component.cancel();
	}-*/;

	/**
	 * Cancels any pending timeout and queues a new one
	 */
	public native void delay(double delay)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		component.delay(delay);
	}-*/;

	/**
	 * Clean up the Surface instance on component destruction
	 */
	public native void destroy()/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		component.destroy();
	}-*/;

	/**
	 * Redraw the chart. If animations are set this will animate the chart too.
	 */
	public native void redraw(boolean resize)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		component.redraw(resize);
	}-*/;

	/**
	 * Redraw the chart. If animations are set this will animate the chart too.
	 */
	public native void redraw()/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		component.redraw();
	}-*/;

	/**
	 * Reset the chart back to its initial state, before any user interaction.
	 */
	public native void reset(boolean skipRedraw)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		component.reset(skipRedraw);
	}-*/;

	public native void resetLegendStore()/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		component.resetLegendStore();
	}-*/;

	public native void refreshLegendStore()/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		component.refreshLegendStore();
	}-*/;

	/**
	 * Used to save a chart.
	 */
	public void save(SavingType type) {
		_save(createSaveType(type.getValue()));
	}

	protected void setTheme(String value) {
		setAttribute("theme", value, true);
	}

	/**
	 * Fires before a refresh to the chart data is called. If the beforerefresh
	 * handler returns false the refresh action will be cancelled.
	 * 
	 * @param handler
	 */
	public native void addBeforeRefreshHandler(BeforeRefreshHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		component
				.addEventListener(
						@com.ait.toolkit.sencha.touch.charts.client.AbstractChart::BEFORE_REFRESH,
						$entry(function(chart) {
							chartObject = @com.ait.toolkit.sencha.touch.charts.client.AbstractChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(chart);
							handler.@com.ait.toolkit.sencha.touch.charts.client.handlers.BeforeRefreshHandler::onBeforeRefresh(Lcom/ait/toolkit/sencha/touch/charts/client/AbstractChart;)(chartObject);
						}));
	}-*/;

	/**
	 * Fires when a click event occurs on a series item.
	 * 
	 * @param handler
	 */
	public CallbackRegistration addItemClickHandler(ChartEventHandler handler) {
		return addHandler(ITEM_CLICK, handler);
	}

	/**
	 * Fires when a doubleclick event occurs on a series item.
	 * 
	 * @param handler
	 */
	public CallbackRegistration addItemDoubleClickHandler(
			ChartEventHandler handler) {
		return addHandler(ITEM_DOUBLE_CLICK, handler);
	}

	/**
	 * Fires when a doubletap event occurs on a series item.
	 * 
	 * @param handler
	 */
	public CallbackRegistration addItemDoubleTapHandler(
			ChartEventHandler handler) {
		return addHandler(ITEM_DOUBLE_TAP, handler);
	}

	/**
	 * Fires when a drag event occurs on a series item.
	 * 
	 * @param handler
	 */
	public CallbackRegistration addItemDraHandler(ChartEventHandler handler) {
		return addHandler(ITEM_DRAG, handler);
	}

	/**
	 * Fires when a dragend event occurs on a series item.
	 * 
	 * @param handler
	 */
	public CallbackRegistration addItemDragEndHandler(ChartEventHandler handler) {
		return addHandler(ITEM_DRAG_END, handler);
	}

	/**
	 * Fires when a dragstart event occurs on a series item.
	 * 
	 * @param handler
	 */
	public CallbackRegistration addItemDragStartHandler(
			ChartEventHandler handler) {
		return addHandler(ITEM_DRAG_START, handler);
	}

	/**
	 * Fires when a mousedown event occurs on a series item.
	 * 
	 * @param handler
	 */
	public CallbackRegistration addItemMouseDownHandler(
			ChartEventHandler handler) {
		return addHandler(ITEM_MOUSE_DOWN, handler);
	}

	/**
	 * Fires when a mousemove event occurs on a series item.
	 * 
	 * @param handler
	 */
	public CallbackRegistration addItemMouseMoveHandler(
			ChartEventHandler handler) {
		return addHandler(ITEM_MOUSE_MOVE, handler);
	}

	/**
	 * Fires when a mouseout event occurs on a series item.
	 * 
	 * @param handler
	 */
	public CallbackRegistration addItemMouseOutHandler(ChartEventHandler handler) {
		return addHandler(ITEM_MOUSE_OUT, handler);
	}

	/**
	 * Fires when a mouseover event occurs on a series item.
	 * 
	 * @param handler
	 */
	public CallbackRegistration addItemMouseOverHandler(
			ChartEventHandler handler) {
		return addHandler(ITEM_MOUSE_OVER, handler);
	}

	/**
	 * Fires when a mouseup event occurs on a series item.
	 * 
	 * @param handler
	 */
	public CallbackRegistration addItemMouseUpHandler(ChartEventHandler handler) {
		return addHandler(ITEM_MOUSE_UP, handler);
	}

	/**
	 * Fires when a pinch event occurs on a series item.
	 * 
	 * @param handler
	 */
	public CallbackRegistration addItemPinchHandler(ChartEventHandler handler) {
		return addHandler(ITEM_PINCH, handler);
	}

	/**
	 * Fires when a pinchend event occurs on a series item.
	 * 
	 * @param handler
	 */
	public CallbackRegistration addItemPinchEndHandler(ChartEventHandler handler) {
		return addHandler(ITEM_PINCH_END, handler);
	}

	/**
	 * Fires when a pinchstart event occurs on a series item.
	 * 
	 * @param handler
	 */
	public CallbackRegistration addItemPinchStartHandler(
			ChartEventHandler handler) {
		return addHandler(ITEM_PINCH_START, handler);
	}

	/**
	 * Fires when a singletap event occurs on a series item.
	 * 
	 * @param handler
	 */
	public CallbackRegistration addItemSingleTapHandler(
			ChartEventHandler handler) {
		return addHandler(ITEM_SINGLE_TAP, handler);
	}

	/**
	 * Fires when a swipe event occurs on a series item.
	 * 
	 * @param handler
	 */
	public CallbackRegistration addItemSwipeHandler(ChartEventHandler handler) {
		return addHandler(ITEM_SWIPE, handler);
	}

	/**
	 * Fires when a tap event occurs on a series item.
	 * 
	 * @param handler
	 */
	public CallbackRegistration addItemTapHandler(ChartEventHandler handler) {
		return addHandler(ITEM_TAP, handler);
	}

	/**
	 * Fires when a tapcancel event occurs on a series item.
	 * 
	 * @param handler
	 */
	public CallbackRegistration addItemTapCancelHandler(
			ChartEventHandler handler) {
		return addHandler(ITEM_TAP_CANCEL, handler);
	}

	/**
	 * Fires when a tapend event occurs on a series item.
	 * 
	 * @param handler
	 */
	public CallbackRegistration addItemTapEndHandler(ChartEventHandler handler) {
		return addHandler(ITEM_TAP_END, handler);
	}

	/**
	 * Fires when a taphold event occurs on a series item.
	 * 
	 * @param handler
	 */
	public CallbackRegistration addItemTapHoldHandler(ChartEventHandler handler) {
		return addHandler(ITEM_TAP_HOLD, handler);
	}

	/**
	 * Fires when a tapstart event occurs on a series item.
	 * 
	 * @param handler
	 */
	public CallbackRegistration addItemTapStartHandler(ChartEventHandler handler) {
		return addHandler(ITEM_TAP_START, handler);
	}

	/**
	 * Fires when a touchend event occurs on a series item.
	 * 
	 * @param handler
	 */
	public CallbackRegistration addItemTouchEndHandler(ChartEventHandler handler) {
		return addHandler(ITEM_TOUCH_END, handler);
	}

	/**
	 * Fires when a touchmove event occurs on a series item.
	 * 
	 * @param handler
	 */
	public CallbackRegistration addItemTouchMoveHandler(
			ChartEventHandler handler) {
		return addHandler(ITEM_TOUCH_MOVE, handler);
	}

	/**
	 * Fires when a touchstart event occurs on a series item.
	 * 
	 * @param handler
	 */
	public CallbackRegistration addItemTouchStartHandler(
			ChartEventHandler handler) {
		return addHandler(ITEM_TOUCH_START, handler);
	}

	/**
	 * Fires after the chart is redrawn.
	 * 
	 * @param handler
	 */
	public CallbackRegistration addRedrawHandler(ChartChangeHandler handler) {
		return addChangeHandler(REDRAW, handler);
	}

	/**
	 * Fires after the chart data has been refreshed.
	 * 
	 * @param handler
	 */
	public CallbackRegistration addRefreshHandler(ChartChangeHandler handler) {
		return addChangeHandler(REFRESH, handler);
	}

	private native void _save(JavaScriptObject type)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		component.save(type);
	}-*/;

	private void _setInteractions(JavaScriptObject value) {
		setAttribute("interactions", value, true);
	}

	private native JavaScriptObject createFill(String value)/*-{
		return {
			fill : value
		};
	}-*/;

	private native JavaScriptObject createSaveType(String value)/*-{
		return {
			type : value
		};
	}-*/;

	private native JavaScriptObject createImage(String value)/*-{
		return {
			image : value
		};
	}-*/;

	private native JavaScriptObject createGradient(JavaScriptObject obj)/*-{
		return {
			gradient : obj
		};
	}-*/;

	private native CallbackRegistration addHandler(String event,
			ChartEventHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var widget = this.@com.ait.toolkit.sencha.touch.client.core.AbstractBaseWidget::widget;
		var peer = widget.getOrCreateJsObj();
		var fn = $entry(function(series, item, e) {
			var seriesObject = @com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries::new(Lcom/google/gwt/core/client/JavaScriptObject;)(series);
			var chartItem = @com.ait.toolkit.sencha.touch.charts.client.interactions.ChartItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
			var eventObject = @com.ait.toolkit.sencha.shared.client.core.EventObject::new(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
			chartObject = @com.ait.toolkit.sencha.touch.charts.client.AbstractChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(chart);

			handler.@com.ait.toolkit.sencha.touch.charts.client.handlers.ChartEventHandler::onEvent(Lcom/ait/toolkit/sencha/touch/charts/client/series/BaseSeries;Lcom/ait/toolkit/sencha/touch/charts/client/interactions/ChartItem;Lcom/ait/toolkit/sencha/shared/client/core/EventObject;)(seriesObject, chartItem, eventObject);
		});
		component.addListener(event, fn);
		var toReturn = @com.ait.toolkit.sencha.shared.client.core.handlers.CallbackRegistration::new(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(peer,event,fn);
		return toReturn;
	}-*/;

	private native CallbackRegistration addChangeHandler(String event,
			ChartChangeHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var widget = this.@com.ait.toolkit.sencha.touch.client.core.AbstractBaseWidget::widget;
		var peer = widget.getOrCreateJsObj();
		var fn = $entry(function(chart) {
			chartObject = @com.ait.toolkit.sencha.touch.charts.client.AbstractChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(chart);
			handler.@com.ait.toolkit.sencha.touch.charts.client.handlers.ChartChangeHandler::onEvent(Lcom/ait/toolkit/sencha/touch/charts/client/AbstractChart;)(chartObject);
		});
		component.addListener(event, fn);
		var toReturn = @com.ait.toolkit.sencha.shared.client.core.handlers.CallbackRegistration::new(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(peer,event,fn);
		return toReturn;
	}-*/;

}
