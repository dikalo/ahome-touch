package com.ait.toolkit.sencha.touch.charts.client.events;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ItemPinchStartEvent extends EventObject {

	public static String EVENT_NAME = "itempinchstart";

	private AbstractSeries series;
	private JavaScriptObject item;

	public ItemPinchStartEvent(AbstractSeries series, JavaScriptObject item, JavaScriptObject nativeEvent) {
		super(nativeEvent);
		this.series = series;
		this.item = item;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<ItemPinchStartHandler> TYPE = new Type<ItemPinchStartHandler>(EVENT_NAME, null);

	public static Type<ItemPinchStartHandler> getType() {
		return TYPE;
	}

	public static Type<ItemPinchStartHandler> getAssociatedType() {
		return TYPE;
	}

	protected ItemPinchStartEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public AbstractSeries getSeries() {
		return series;
	}

	public JavaScriptObject getItem() {
		return item;
	}

}
