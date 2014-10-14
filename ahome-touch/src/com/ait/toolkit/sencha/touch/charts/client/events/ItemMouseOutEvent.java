package com.ait.toolkit.sencha.touch.charts.client.events;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ItemMouseOutEvent extends EventObject {

	public static String EVENT_NAME = "itemmouseout";

	private AbstractSeries series;
	private JavaScriptObject item;

	public ItemMouseOutEvent(AbstractSeries series, JavaScriptObject item, JavaScriptObject nativeEvent) {
		super(nativeEvent);
		this.series = series;
		this.item = item;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<ItemMouseOutHandler> TYPE = new Type<ItemMouseOutHandler>(EVENT_NAME, null);

	public static Type<ItemMouseOutHandler> getType() {
		return TYPE;
	}

	public static Type<ItemMouseOutHandler> getAssociatedType() {
		return TYPE;
	}

	protected ItemMouseOutEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public AbstractSeries getSeries() {
		return series;
	}

	public JavaScriptObject getItem() {
		return item;
	}

}
