package com.ait.toolkit.sencha.touch.charts.client.events;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ItemClickEvent extends EventObject {

	public static String EVENT_NAME = "itemclick";

	private AbstractSeries series;
	private JavaScriptObject item;

	public ItemClickEvent(AbstractSeries series, JavaScriptObject item, JavaScriptObject nativeEvent) {
		super(nativeEvent);
		this.series = series;
		this.item = item;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<ItemClickHandler> TYPE = new Type<ItemClickHandler>(EVENT_NAME, null);

	public static Type<ItemClickHandler> getType() {
		return TYPE;
	}

	public static Type<ItemClickHandler> getAssociatedType() {
		return TYPE;
	}

	protected ItemClickEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public AbstractSeries getSeries() {
		return series;
	}

	public JavaScriptObject getItem() {
		return item;
	}

}
