package com.ait.toolkit.sencha.touch.charts.client.events;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ItemTouchMoveEvent extends EventObject {

	public static String EVENT_NAME = "itemtouchmove";

	private AbstractSeries series;
	private JavaScriptObject item;

	public ItemTouchMoveEvent(AbstractSeries series, JavaScriptObject item, JavaScriptObject nativeEvent) {
		super(nativeEvent);
		this.series = series;
		this.item = item;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<ItemTouchMoveHandler> TYPE = new Type<ItemTouchMoveHandler>(EVENT_NAME, null);

	public static Type<ItemTouchMoveHandler> getType() {
		return TYPE;
	}

	public static Type<ItemTouchMoveHandler> getAssociatedType() {
		return TYPE;
	}

	protected ItemTouchMoveEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public AbstractSeries getSeries() {
		return series;
	}

	public JavaScriptObject getItem() {
		return item;
	}

}
