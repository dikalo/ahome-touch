package com.ait.toolkit.sencha.touch.charts.client.events;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ItemMouseUpEvent extends EventObject {

	public static String EVENT_NAME = "itemmouseup";

	private AbstractSeries series;
	private JavaScriptObject item;

	public ItemMouseUpEvent(AbstractSeries series, JavaScriptObject item, JavaScriptObject nativeEvent) {
		super(nativeEvent);
		this.series = series;
		this.item = item;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<ItemMouseUpHandler> TYPE = new Type<ItemMouseUpHandler>(EVENT_NAME, null);

	public static Type<ItemMouseUpHandler> getType() {
		return TYPE;
	}

	public static Type<ItemMouseUpHandler> getAssociatedType() {
		return TYPE;
	}

	protected ItemMouseUpEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public AbstractSeries getSeries() {
		return series;
	}

	public JavaScriptObject getItem() {
		return item;
	}

}
