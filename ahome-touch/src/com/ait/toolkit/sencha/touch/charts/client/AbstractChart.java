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
import com.ait.toolkit.sencha.shared.client.data.Store;
import com.ait.toolkit.sencha.touch.charts.client.axis.AbstractAxis;
import com.ait.toolkit.sencha.touch.charts.client.events.BeforeRefreshHandler;
import com.ait.toolkit.sencha.touch.charts.client.events.ItemClickHandler;
import com.ait.toolkit.sencha.touch.charts.client.events.ItemDoubleClickHandler;
import com.ait.toolkit.sencha.touch.charts.client.events.ItemDoubleTapHandler;
import com.ait.toolkit.sencha.touch.charts.client.events.ItemDragEndHandler;
import com.ait.toolkit.sencha.touch.charts.client.events.ItemDragHandler;
import com.ait.toolkit.sencha.touch.charts.client.events.ItemDragStartHandler;
import com.ait.toolkit.sencha.touch.charts.client.events.ItemMouseDownHandler;
import com.ait.toolkit.sencha.touch.charts.client.events.ItemMouseMoveHandler;
import com.ait.toolkit.sencha.touch.charts.client.events.ItemMouseOutHandler;
import com.ait.toolkit.sencha.touch.charts.client.events.ItemMouseOverHandler;
import com.ait.toolkit.sencha.touch.charts.client.events.ItemMouseUpHandler;
import com.ait.toolkit.sencha.touch.charts.client.events.ItemPinchEndHandler;
import com.ait.toolkit.sencha.touch.charts.client.events.ItemPinchHandler;
import com.ait.toolkit.sencha.touch.charts.client.events.ItemPinchStartHandler;
import com.ait.toolkit.sencha.touch.charts.client.events.ItemSingleTapHandler;
import com.ait.toolkit.sencha.touch.charts.client.events.ItemSwipeHandler;
import com.ait.toolkit.sencha.touch.charts.client.events.ItemTapCancelHandler;
import com.ait.toolkit.sencha.touch.charts.client.events.ItemTapEndHandler;
import com.ait.toolkit.sencha.touch.charts.client.events.ItemTapHandler;
import com.ait.toolkit.sencha.touch.charts.client.events.ItemTapStartHandler;
import com.ait.toolkit.sencha.touch.charts.client.events.RedrawHandler;
import com.ait.toolkit.sencha.touch.charts.client.events.RefreshHandler;
import com.ait.toolkit.sencha.touch.charts.client.handlers.ChartBeforeRefreshHandler;
import com.ait.toolkit.sencha.touch.charts.client.interactions.AbstractInteraction;
import com.ait.toolkit.sencha.touch.charts.client.interactions.InteractionType;
import com.ait.toolkit.sencha.touch.charts.client.interactions.SavingType;
import com.ait.toolkit.sencha.touch.charts.client.laf.Gradient;
import com.ait.toolkit.sencha.touch.charts.client.laf.Shadow;
import com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries;
import com.ait.toolkit.sencha.touch.charts.client.theme.Theme;
import com.ait.toolkit.sencha.touch.client.events.HandlerRegistration;
import com.ait.toolkit.sencha.touch.client.events.dataview.ItemTapHoldHandler;
import com.ait.toolkit.sencha.touch.client.events.dataview.ItemTouchEndHandler;
import com.ait.toolkit.sencha.touch.client.events.dataview.ItemTouchMoveHandler;
import com.ait.toolkit.sencha.touch.client.events.dataview.ItemTouchStartHandler;
import com.ait.toolkit.sencha.touch.client.laf.Color;
import com.ait.toolkit.sencha.touch.client.laf.Position;
import com.ait.toolkit.sencha.touch.client.ui.DrawComponent;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;

/**
 * The AbstractChart component provides the capability to visualize data. Each chart binds directly to a Store enabling automatic updates of the chart.
 */
public abstract class AbstractChart extends DrawComponent {

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
	 * The name of the theme to be used. A theme defines the colors and other visual displays of tick marks on axis, text, title text, line colors, marker colors and styles, etc.
	 * Possible theme values are 'Base', 'Green', 'Sky', 'Red', 'Purple', 'Blue', 'Yellow' and also six category themes 'Category1' to 'Category6'. Default value is 'Base'.
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
			throw new RuntimeException("You must add add atleast one axis to the chart before calling drawAxis");
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
				AbstractAxis serie = AbstractAxis.create(JsoHelper.getValueFromJavaScriptObjectArray(nativePeers, i));
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
			throw new RuntimeException("You must add add atleast one series to the chart before calling drawSeries");
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
				AbstractSeries serie = AbstractSeries.create(JsoHelper.getValueFromJavaScriptObjectArray(nativePeers, i));
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
	 * Turn on autoSize support which will set the bounding div's size to the natural size of the contents.
	 * 
	 * @param value
	 */
	public void setAutoSize(boolean value) {
		setAttribute("autosize", value, true);
	}

	/**
	 * (optional) true for the default animation (easing: 'ease' and duration: 500) or a standard animation config object to be used for default chart animations.
	 * 
	 * Defaults to: false
	 * 
	 * @param value
	 */
	public void setAnimate(boolean value) {
		setAttribute("animate", value, true, true);
	}

	/**
	 * (optional) true for the default animation (easing: 'ease' and duration: 500) or a standard animation config object to be used for default chart animations.
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
	 * Define a set of gradients that can be used as fill property in sprites. ...
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
			throw new RuntimeException("You must add add atleast one gradient to the chart before calling drawGradients");
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
	 * The position at which the toolbar should be docked in relation to the chart.
	 * 
	 * @param position
	 */
	public void setToolbar(Position position) {
		setAttribute("toolbar", createToolbarPosition(position.getValue()), true);
	}

	public native Toolbar getToolbar()/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var tb = component.getToolbar();
		var toReturn = @com.ait.toolkit.sencha.touch.charts.client.Toolbar::new(Lcom/google/gwt/core/client/JavaScriptObject;)(tb);
		return toReturn;
	}-*/;

	/**
	 * Turn on view box support which will scale and position items in the draw component to fit to the component while maintaining aspect ratio. Note that this scaling can
	 * override other sizing settings on yor items.
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
	 * Interactions are optional modules that can be plugged in to a chart to allow the user to interact with the chart and its data in special ways
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
	 * Interactions are optional modules that can be plugged in to a chart to allow the user to interact with the chart and its data in special ways
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
				AbstractInteraction serie = AbstractInteraction.create(JsoHelper.getValueFromJavaScriptObjectArray(nativePeers, i));
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
	 * Fires before a refresh to the chart data is called. If the beforerefresh handler returns false the refresh action will be cancelled.
	 * 
	 * @param handler
	 */
	public native void addChartBeforeRefreshHandler(ChartBeforeRefreshHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		component
				.addEventListener(
						@com.ait.toolkit.sencha.touch.charts.client.events.BeforeRefreshEvent::EVENT_NAME,
						$entry(function(chart) {
							chartObject = @com.ait.toolkit.sencha.touch.charts.client.AbstractChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(chart);
							return handler.@com.ait.toolkit.sencha.touch.charts.client.handlers.ChartBeforeRefreshHandler::onBeforeRefresh(Lcom/ait/toolkit/sencha/touch/charts/client/AbstractChart;)(chartObject);
						}));
	}-*/;

	public native HandlerRegistration addBeforeRefreshHandler(BeforeRefreshHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c) {
			var comp = @com.ait.toolkit.sencha.touch.charts.client.AbstractChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var event = @com.ait.toolkit.sencha.touch.charts.client.events.BeforeRefreshEvent::new(Lcom/ait/toolkit/sencha/touch/charts/client/AbstractChart;)(comp);
			handler.@com.ait.toolkit.sencha.touch.charts.client.events.BeforeRefreshHandler::onBeforeRefresh(Lcom/ait/toolkit/sencha/touch/charts/client/events/BeforeRefreshEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.charts.client.events.BeforeRefreshEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemClickHandler(ItemClickHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, s, e) {
			var comp = @com.ait.toolkit.sencha.touch.charts.client.AbstractChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var series = @com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries::new(Lcom/google/gwt/core/client/JavaScriptObject;)(s);
			var event = @com.ait.toolkit.sencha.touch.charts.client.events.ItemClickEvent::new(Lcom/ait/toolkit/sencha/touch/charts/client/series/AbstractSeries;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(series,item,e);
			handler.@com.ait.toolkit.sencha.touch.charts.client.events.ItemClickHandler::onItemClick(Lcom/ait/toolkit/sencha/touch/charts/client/events/ItemClickEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.charts.client.events.ItemClickEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemDoubleClickHandler(ItemDoubleClickHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, s, e) {
			var comp = @com.ait.toolkit.sencha.touch.charts.client.AbstractChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var series = @com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries::new(Lcom/google/gwt/core/client/JavaScriptObject;)(s);
			var event = @com.ait.toolkit.sencha.touch.charts.client.events.ItemDoubleClickEvent::new(Lcom/ait/toolkit/sencha/touch/charts/client/series/AbstractSeries;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(series,item,e);
			handler.@com.ait.toolkit.sencha.touch.charts.client.events.ItemDoubleClickHandler::onItemDoubleClick(Lcom/ait/toolkit/sencha/touch/charts/client/events/ItemDoubleClickEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.charts.client.events.ItemDoubleClickEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemDoubleTapHandler(ItemDoubleTapHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, s, e) {
			var comp = @com.ait.toolkit.sencha.touch.charts.client.AbstractChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var series = @com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries::new(Lcom/google/gwt/core/client/JavaScriptObject;)(s);
			var event = @com.ait.toolkit.sencha.touch.charts.client.events.ItemDoubleTapEvent::new(Lcom/ait/toolkit/sencha/touch/charts/client/series/AbstractSeries;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(series,item,e);
			handler.@com.ait.toolkit.sencha.touch.charts.client.events.ItemDoubleTapHandler::onItemDoubleTap(Lcom/ait/toolkit/sencha/touch/charts/client/events/ItemDoubleTapEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.charts.client.events.ItemDoubleTapEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemDragHandler(ItemDragHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, s, e) {
			var comp = @com.ait.toolkit.sencha.touch.charts.client.AbstractChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var series = @com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries::new(Lcom/google/gwt/core/client/JavaScriptObject;)(s);
			var event = @com.ait.toolkit.sencha.touch.charts.client.events.ItemDragEvent::new(Lcom/ait/toolkit/sencha/touch/charts/client/series/AbstractSeries;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(series,item,e);
			handler.@com.ait.toolkit.sencha.touch.charts.client.events.ItemDragHandler::onItemDrag(Lcom/ait/toolkit/sencha/touch/charts/client/events/ItemDragEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.charts.client.events.ItemDragEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemDragEndHandler(ItemDragEndHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, s, e) {
			var comp = @com.ait.toolkit.sencha.touch.charts.client.AbstractChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var series = @com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries::new(Lcom/google/gwt/core/client/JavaScriptObject;)(s);
			var event = @com.ait.toolkit.sencha.touch.charts.client.events.ItemDragEndEvent::new(Lcom/ait/toolkit/sencha/touch/charts/client/series/AbstractSeries;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(series,item,e);
			handler.@com.ait.toolkit.sencha.touch.charts.client.events.ItemDragEndHandler::onItemDragEnd(Lcom/ait/toolkit/sencha/touch/charts/client/events/ItemDragEndEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.charts.client.events.ItemDragEndEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemDragStartHandler(ItemDragStartHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, s, e) {
			var comp = @com.ait.toolkit.sencha.touch.charts.client.AbstractChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var series = @com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries::new(Lcom/google/gwt/core/client/JavaScriptObject;)(s);
			var event = @com.ait.toolkit.sencha.touch.charts.client.events.ItemDragStartEvent::new(Lcom/ait/toolkit/sencha/touch/charts/client/series/AbstractSeries;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(series,item,e);
			handler.@com.ait.toolkit.sencha.touch.charts.client.events.ItemDragStartHandler::onItemDragStart(Lcom/ait/toolkit/sencha/touch/charts/client/events/ItemDragStartEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.charts.client.events.ItemDragStartEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemMouseDownHandler(ItemMouseDownHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, s, e) {
			var comp = @com.ait.toolkit.sencha.touch.charts.client.AbstractChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var series = @com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries::new(Lcom/google/gwt/core/client/JavaScriptObject;)(s);
			var event = @com.ait.toolkit.sencha.touch.charts.client.events.ItemMouseDownEvent::new(Lcom/ait/toolkit/sencha/touch/charts/client/series/AbstractSeries;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(series,item,e);
			handler.@com.ait.toolkit.sencha.touch.charts.client.events.ItemMouseDownHandler::onItemMouseDown(Lcom/ait/toolkit/sencha/touch/charts/client/events/ItemMouseDownEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.charts.client.events.ItemMouseDownEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemMouseMoveHandler(ItemMouseMoveHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, s, e) {
			var comp = @com.ait.toolkit.sencha.touch.charts.client.AbstractChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var series = @com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries::new(Lcom/google/gwt/core/client/JavaScriptObject;)(s);
			var event = @com.ait.toolkit.sencha.touch.charts.client.events.ItemMouseMoveEvent::new(Lcom/ait/toolkit/sencha/touch/charts/client/series/AbstractSeries;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(series,item,e);
			handler.@com.ait.toolkit.sencha.touch.charts.client.events.ItemMouseMoveHandler::onItemMouseMove(Lcom/ait/toolkit/sencha/touch/charts/client/events/ItemMouseMoveEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.charts.client.events.ItemMouseMoveEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemMouseUpHandler(ItemMouseUpHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, s, e) {
			var comp = @com.ait.toolkit.sencha.touch.charts.client.AbstractChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var series = @com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries::new(Lcom/google/gwt/core/client/JavaScriptObject;)(s);
			var event = @com.ait.toolkit.sencha.touch.charts.client.events.ItemMouseUpEvent::new(Lcom/ait/toolkit/sencha/touch/charts/client/series/AbstractSeries;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(series,item,e);
			handler.@com.ait.toolkit.sencha.touch.charts.client.events.ItemMouseUpHandler::onItemMouseUp(Lcom/ait/toolkit/sencha/touch/charts/client/events/ItemMouseUpEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.charts.client.events.ItemMouseUpEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemMouseOverHandler(ItemMouseOverHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, s, e) {
			var comp = @com.ait.toolkit.sencha.touch.charts.client.AbstractChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var series = @com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries::new(Lcom/google/gwt/core/client/JavaScriptObject;)(s);
			var event = @com.ait.toolkit.sencha.touch.charts.client.events.ItemMouseOverEvent::new(Lcom/ait/toolkit/sencha/touch/charts/client/series/AbstractSeries;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(series,item,e);
			handler.@com.ait.toolkit.sencha.touch.charts.client.events.ItemMouseOverHandler::onItemMouseOver(Lcom/ait/toolkit/sencha/touch/charts/client/events/ItemMouseOverEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.charts.client.events.ItemMouseOverEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemMouseOutHandler(ItemMouseOutHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, s, e) {
			var comp = @com.ait.toolkit.sencha.touch.charts.client.AbstractChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var series = @com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries::new(Lcom/google/gwt/core/client/JavaScriptObject;)(s);
			var event = @com.ait.toolkit.sencha.touch.charts.client.events.ItemMouseOutEvent::new(Lcom/ait/toolkit/sencha/touch/charts/client/series/AbstractSeries;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(series,item,e);
			handler.@com.ait.toolkit.sencha.touch.charts.client.events.ItemMouseOutHandler::onItemMouseOut(Lcom/ait/toolkit/sencha/touch/charts/client/events/ItemMouseOutEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.charts.client.events.ItemMouseOutEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemPinchHandler(ItemPinchHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, s, e) {
			var comp = @com.ait.toolkit.sencha.touch.charts.client.AbstractChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var series = @com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries::new(Lcom/google/gwt/core/client/JavaScriptObject;)(s);
			var event = @com.ait.toolkit.sencha.touch.charts.client.events.ItemPinchEvent::new(Lcom/ait/toolkit/sencha/touch/charts/client/series/AbstractSeries;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(series,item,e);
			handler.@com.ait.toolkit.sencha.touch.charts.client.events.ItemPinchHandler::onItemPinch(Lcom/ait/toolkit/sencha/touch/charts/client/events/ItemPinchEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.charts.client.events.ItemPinchEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemPinchEndHandler(ItemPinchEndHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, s, e) {
			var comp = @com.ait.toolkit.sencha.touch.charts.client.AbstractChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var series = @com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries::new(Lcom/google/gwt/core/client/JavaScriptObject;)(s);
			var event = @com.ait.toolkit.sencha.touch.charts.client.events.ItemPinchEndEvent::new(Lcom/ait/toolkit/sencha/touch/charts/client/series/AbstractSeries;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(series,item,e);
			handler.@com.ait.toolkit.sencha.touch.charts.client.events.ItemPinchEndHandler::onItemPinchEnd(Lcom/ait/toolkit/sencha/touch/charts/client/events/ItemPinchEndEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.charts.client.events.ItemPinchEndEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemPinchStartHandler(ItemPinchStartHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, s, e) {
			var comp = @com.ait.toolkit.sencha.touch.charts.client.AbstractChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var series = @com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries::new(Lcom/google/gwt/core/client/JavaScriptObject;)(s);
			var event = @com.ait.toolkit.sencha.touch.charts.client.events.ItemPinchStartEvent::new(Lcom/ait/toolkit/sencha/touch/charts/client/series/AbstractSeries;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(series,item,e);
			handler.@com.ait.toolkit.sencha.touch.charts.client.events.ItemPinchStartHandler::onItemPinchStart(Lcom/ait/toolkit/sencha/touch/charts/client/events/ItemPinchStartEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.charts.client.events.ItemPinchStartEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemSingleTapHandler(ItemSingleTapHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, s, e) {
			var comp = @com.ait.toolkit.sencha.touch.charts.client.AbstractChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var series = @com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries::new(Lcom/google/gwt/core/client/JavaScriptObject;)(s);
			var event = @com.ait.toolkit.sencha.touch.charts.client.events.ItemSingleTapEvent::new(Lcom/ait/toolkit/sencha/touch/charts/client/series/AbstractSeries;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(series,item,e);
			handler.@com.ait.toolkit.sencha.touch.charts.client.events.ItemSingleTapHandler::onItemSingleTap(Lcom/ait/toolkit/sencha/touch/charts/client/events/ItemSingleTapEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.charts.client.events.ItemSingleTapEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemSwipeHandler(ItemSwipeHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, s, e) {
			var comp = @com.ait.toolkit.sencha.touch.charts.client.AbstractChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var series = @com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries::new(Lcom/google/gwt/core/client/JavaScriptObject;)(s);
			var event = @com.ait.toolkit.sencha.touch.charts.client.events.ItemSwipeEvent::new(Lcom/ait/toolkit/sencha/touch/charts/client/series/AbstractSeries;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(series,item,e);
			handler.@com.ait.toolkit.sencha.touch.charts.client.events.ItemSwipeHandler::onItemSwipe(Lcom/ait/toolkit/sencha/touch/charts/client/events/ItemSwipeEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.charts.client.events.ItemSwipeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemTapHandler(ItemTapHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, s, e) {
			var comp = @com.ait.toolkit.sencha.touch.charts.client.AbstractChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var series = @com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries::new(Lcom/google/gwt/core/client/JavaScriptObject;)(s);
			var event = @com.ait.toolkit.sencha.touch.charts.client.events.ItemTapEvent::new(Lcom/ait/toolkit/sencha/touch/charts/client/series/AbstractSeries;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(series,item,e);
			handler.@com.ait.toolkit.sencha.touch.charts.client.events.ItemTapHandler::onItemTap(Lcom/ait/toolkit/sencha/touch/charts/client/events/ItemTapEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.charts.client.events.ItemTapEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemTapCancelHandler(ItemTapCancelHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, s, e) {
			var comp = @com.ait.toolkit.sencha.touch.charts.client.AbstractChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var series = @com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries::new(Lcom/google/gwt/core/client/JavaScriptObject;)(s);
			var event = @com.ait.toolkit.sencha.touch.charts.client.events.ItemTapCancelEvent::new(Lcom/ait/toolkit/sencha/touch/charts/client/series/AbstractSeries;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(series,item,e);
			handler.@com.ait.toolkit.sencha.touch.charts.client.events.ItemTapCancelHandler::onItemTapCancel(Lcom/ait/toolkit/sencha/touch/charts/client/events/ItemTapCancelEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.charts.client.events.ItemTapCancelEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemTapEndHandler(ItemTapEndHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, s, e) {
			var comp = @com.ait.toolkit.sencha.touch.charts.client.AbstractChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var series = @com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries::new(Lcom/google/gwt/core/client/JavaScriptObject;)(s);
			var event = @com.ait.toolkit.sencha.touch.charts.client.events.ItemTapEndEvent::new(Lcom/ait/toolkit/sencha/touch/charts/client/series/AbstractSeries;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(series,item,e);
			handler.@com.ait.toolkit.sencha.touch.charts.client.events.ItemTapEndHandler::onItemTapEnd(Lcom/ait/toolkit/sencha/touch/charts/client/events/ItemTapEndEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.charts.client.events.ItemTapEndEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemTapHoldHandler(ItemTapHoldHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, s, e) {
			var comp = @com.ait.toolkit.sencha.touch.charts.client.AbstractChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var series = @com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries::new(Lcom/google/gwt/core/client/JavaScriptObject;)(s);
			var event = @com.ait.toolkit.sencha.touch.charts.client.events.ItemTapHoldEvent::new(Lcom/ait/toolkit/sencha/touch/charts/client/series/AbstractSeries;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(series,item,e);
			handler.@com.ait.toolkit.sencha.touch.charts.client.events.ItemTapHoldHandler::onItemTapHold(Lcom/ait/toolkit/sencha/touch/charts/client/events/ItemTapHoldEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.charts.client.events.ItemTapHoldEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemTapStartHandler(ItemTapStartHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, s, e) {
			var comp = @com.ait.toolkit.sencha.touch.charts.client.AbstractChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var series = @com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries::new(Lcom/google/gwt/core/client/JavaScriptObject;)(s);
			var event = @com.ait.toolkit.sencha.touch.charts.client.events.ItemTapStartEvent::new(Lcom/ait/toolkit/sencha/touch/charts/client/series/AbstractSeries;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(series,item,e);
			handler.@com.ait.toolkit.sencha.touch.charts.client.events.ItemTapStartHandler::onItemTapStart(Lcom/ait/toolkit/sencha/touch/charts/client/events/ItemTapStartEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.charts.client.events.ItemTapStartEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemTouchEndHandler(ItemTouchEndHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, s, e) {
			var comp = @com.ait.toolkit.sencha.touch.charts.client.AbstractChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var series = @com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries::new(Lcom/google/gwt/core/client/JavaScriptObject;)(s);
			var event = @com.ait.toolkit.sencha.touch.charts.client.events.ItemTouchEndEvent::new(Lcom/ait/toolkit/sencha/touch/charts/client/series/AbstractSeries;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(series,item,e);
			handler.@com.ait.toolkit.sencha.touch.charts.client.events.ItemTouchEndHandler::onItemTouchEnd(Lcom/ait/toolkit/sencha/touch/charts/client/events/ItemTouchEndEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.charts.client.events.ItemTouchEndEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemTouchMoveHandler(ItemTouchMoveHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, s, e) {
			var comp = @com.ait.toolkit.sencha.touch.charts.client.AbstractChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var series = @com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries::new(Lcom/google/gwt/core/client/JavaScriptObject;)(s);
			var event = @com.ait.toolkit.sencha.touch.charts.client.events.ItemTouchMoveEvent::new(Lcom/ait/toolkit/sencha/touch/charts/client/series/AbstractSeries;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(series,item,e);
			handler.@com.ait.toolkit.sencha.touch.charts.client.events.ItemTouchMoveHandler::onItemTouchMove(Lcom/ait/toolkit/sencha/touch/charts/client/events/ItemTouchMoveEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.charts.client.events.ItemTouchMoveEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemTouchStartHandler(ItemTouchStartHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, s, e) {
			var comp = @com.ait.toolkit.sencha.touch.charts.client.AbstractChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var series = @com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries::new(Lcom/google/gwt/core/client/JavaScriptObject;)(s);
			var event = @com.ait.toolkit.sencha.touch.charts.client.events.ItemTouchStartEvent::new(Lcom/ait/toolkit/sencha/touch/charts/client/series/AbstractSeries;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(series,item,e);
			handler.@com.ait.toolkit.sencha.touch.charts.client.events.ItemTouchStartHandler::onItemTouchStart(Lcom/ait/toolkit/sencha/touch/charts/client/events/ItemTouchStartEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.charts.client.events.ItemTouchStartEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addRefreshHandler(RefreshHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c) {
			var comp = @com.ait.toolkit.sencha.touch.charts.client.AbstractChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var event = @com.ait.toolkit.sencha.touch.charts.client.events.RefreshEvent::new(Lcom/ait/toolkit/sencha/touch/charts/client/AbstractChart;)(comp);
			handler.@com.ait.toolkit.sencha.touch.charts.client.events.RefreshHandler::onRefresh(Lcom/ait/toolkit/sencha/touch/charts/client/events/RefreshEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.charts.client.events.RefreshEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addRedrawHandler(RedrawHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c) {
			var comp = @com.ait.toolkit.sencha.touch.charts.client.AbstractChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var event = @com.ait.toolkit.sencha.touch.charts.client.events.RedrawEvent::new(Lcom/ait/toolkit/sencha/touch/charts/client/AbstractChart;)(comp);
			handler.@com.ait.toolkit.sencha.touch.charts.client.events.RedrawHandler::onRedraw(Lcom/ait/toolkit/sencha/touch/charts/client/events/RedrawEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.charts.client.events.RedrawEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

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

}
