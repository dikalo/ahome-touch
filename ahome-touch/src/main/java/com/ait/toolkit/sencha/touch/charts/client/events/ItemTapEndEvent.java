package com.ait.toolkit.sencha.touch.charts.client.events;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ItemTapEndEvent extends EventObject {

	public static String EVENT_NAME = "itemtapend";

	private AbstractSeries series;
	private JavaScriptObject item;

	public ItemTapEndEvent(AbstractSeries series, JavaScriptObject item, JavaScriptObject nativeEvent) {
		super(nativeEvent);
		this.series = series;
		this.item = item;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<ItemTapEndHandler> TYPE = new Type<ItemTapEndHandler>(EVENT_NAME, null);

	public static Type<ItemTapEndHandler> getType() {
		return TYPE;
	}

	public static Type<ItemTapEndHandler> getAssociatedType() {
		return TYPE;
	}

	protected ItemTapEndEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public AbstractSeries getSeries() {
		return series;
	}

	public JavaScriptObject getItem() {
		return item;
	}

}
