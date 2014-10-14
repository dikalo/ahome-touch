package com.ait.toolkit.sencha.touch.charts.client.events;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ItemDragEvent extends EventObject {

	public static String EVENT_NAME = "itemdragend";

	private AbstractSeries series;
	private JavaScriptObject item;

	public ItemDragEvent(AbstractSeries series, JavaScriptObject item, JavaScriptObject nativeEvent) {
		super(nativeEvent);
		this.series = series;
		this.item = item;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<ItemDragEndHandler> TYPE = new Type<ItemDragEndHandler>(EVENT_NAME, null);

	public static Type<ItemDragEndHandler> getType() {
		return TYPE;
	}

	public static Type<ItemDragEndHandler> getAssociatedType() {
		return TYPE;
	}

	protected ItemDragEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public AbstractSeries getSeries() {
		return series;
	}

	public JavaScriptObject getItem() {
		return item;
	}

}
