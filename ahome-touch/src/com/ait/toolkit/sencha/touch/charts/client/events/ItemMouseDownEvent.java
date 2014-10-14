package com.ait.toolkit.sencha.touch.charts.client.events;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ItemMouseDownEvent extends EventObject {

	public static String EVENT_NAME = "itemmousedown";

	private AbstractSeries series;
	private JavaScriptObject item;

	public ItemMouseDownEvent(AbstractSeries series, JavaScriptObject item, JavaScriptObject nativeEvent) {
		super(nativeEvent);
		this.series = series;
		this.item = item;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<ItemMouseDownHandler> TYPE = new Type<ItemMouseDownHandler>(EVENT_NAME, null);

	public static Type<ItemMouseDownHandler> getType() {
		return TYPE;
	}

	public static Type<ItemMouseDownHandler> getAssociatedType() {
		return TYPE;
	}

	protected ItemMouseDownEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public AbstractSeries getSeries() {
		return series;
	}

	public JavaScriptObject getItem() {
		return item;
	}

}
