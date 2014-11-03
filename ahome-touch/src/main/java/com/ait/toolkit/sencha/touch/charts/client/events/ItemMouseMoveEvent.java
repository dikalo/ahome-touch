package com.ait.toolkit.sencha.touch.charts.client.events;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ItemMouseMoveEvent extends EventObject {

	public static String EVENT_NAME = "itemmousemove";

	private AbstractSeries series;
	private JavaScriptObject item;

	public ItemMouseMoveEvent(AbstractSeries series, JavaScriptObject item, JavaScriptObject nativeEvent) {
		super(nativeEvent);
		this.series = series;
		this.item = item;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<ItemMouseMoveHandler> TYPE = new Type<ItemMouseMoveHandler>(EVENT_NAME, null);

	public static Type<ItemMouseMoveHandler> getType() {
		return TYPE;
	}

	public static Type<ItemMouseMoveHandler> getAssociatedType() {
		return TYPE;
	}

	protected ItemMouseMoveEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public AbstractSeries getSeries() {
		return series;
	}

	public JavaScriptObject getItem() {
		return item;
	}

}
