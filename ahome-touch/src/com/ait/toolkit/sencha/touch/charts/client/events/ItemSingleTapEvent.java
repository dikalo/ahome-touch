package com.ait.toolkit.sencha.touch.charts.client.events;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ItemSingleTapEvent extends EventObject {

	public static String EVENT_NAME = "itemsingletap";

	private AbstractSeries series;
	private JavaScriptObject item;

	public ItemSingleTapEvent(AbstractSeries series, JavaScriptObject item, JavaScriptObject nativeEvent) {
		super(nativeEvent);
		this.series = series;
		this.item = item;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<ItemSingleTapHandler> TYPE = new Type<ItemSingleTapHandler>(EVENT_NAME, null);

	public static Type<ItemSingleTapHandler> getType() {
		return TYPE;
	}

	public static Type<ItemSingleTapHandler> getAssociatedType() {
		return TYPE;
	}

	protected ItemSingleTapEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public AbstractSeries getSeries() {
		return series;
	}

	public JavaScriptObject getItem() {
		return item;
	}

}
