package com.ait.toolkit.sencha.touch.charts.client.events;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ItemDoubleClickEvent extends EventObject {

	public static String EVENT_NAME = "itemdoubleclick";

	private AbstractSeries series;
	private JavaScriptObject item;

	public ItemDoubleClickEvent(AbstractSeries series, JavaScriptObject item, JavaScriptObject nativeEvent) {
		super(nativeEvent);
		this.series = series;
		this.item = item;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<ItemDoubleClickHandler> TYPE = new Type<ItemDoubleClickHandler>(EVENT_NAME, null);

	public static Type<ItemDoubleClickHandler> getType() {
		return TYPE;
	}

	public static Type<ItemDoubleClickHandler> getAssociatedType() {
		return TYPE;
	}

	protected ItemDoubleClickEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public AbstractSeries getSeries() {
		return series;
	}

	public JavaScriptObject getItem() {
		return item;
	}

}
