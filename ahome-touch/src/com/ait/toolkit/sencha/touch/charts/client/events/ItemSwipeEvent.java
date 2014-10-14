package com.ait.toolkit.sencha.touch.charts.client.events;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ItemSwipeEvent extends EventObject {

	public static String EVENT_NAME = "itemswipe";

	private AbstractSeries series;
	private JavaScriptObject item;

	public ItemSwipeEvent(AbstractSeries series, JavaScriptObject item, JavaScriptObject nativeEvent) {
		super(nativeEvent);
		this.series = series;
		this.item = item;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<ItemSwipeHandler> TYPE = new Type<ItemSwipeHandler>(EVENT_NAME, null);

	public static Type<ItemSwipeHandler> getType() {
		return TYPE;
	}

	public static Type<ItemSwipeHandler> getAssociatedType() {
		return TYPE;
	}

	protected ItemSwipeEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public AbstractSeries getSeries() {
		return series;
	}

	public JavaScriptObject getItem() {
		return item;
	}

}
