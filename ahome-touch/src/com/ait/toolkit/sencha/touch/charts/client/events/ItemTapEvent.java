package com.ait.toolkit.sencha.touch.charts.client.events;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ItemTapEvent extends EventObject {

	public static String EVENT_NAME = "itemtap";

	private AbstractSeries series;
	private JavaScriptObject item;

	public ItemTapEvent(AbstractSeries series, JavaScriptObject item, JavaScriptObject nativeEvent) {
		super(nativeEvent);
		this.series = series;
		this.item = item;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<ItemTapHandler> TYPE = new Type<ItemTapHandler>(EVENT_NAME, null);

	public static Type<ItemTapHandler> getType() {
		return TYPE;
	}

	public static Type<ItemTapHandler> getAssociatedType() {
		return TYPE;
	}

	protected ItemTapEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public AbstractSeries getSeries() {
		return series;
	}

	public JavaScriptObject getItem() {
		return item;
	}

}
