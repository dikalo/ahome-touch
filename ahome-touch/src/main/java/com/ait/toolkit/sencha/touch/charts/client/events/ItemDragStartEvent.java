package com.ait.toolkit.sencha.touch.charts.client.events;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ItemDragStartEvent extends EventObject {

	public static String EVENT_NAME = "itemdragstart";

	private AbstractSeries series;
	private JavaScriptObject item;

	public ItemDragStartEvent(AbstractSeries series, JavaScriptObject item, JavaScriptObject nativeEvent) {
		super(nativeEvent);
		this.series = series;
		this.item = item;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<ItemDragStartHandler> TYPE = new Type<ItemDragStartHandler>(EVENT_NAME, null);

	public static Type<ItemDragStartHandler> getType() {
		return TYPE;
	}

	public static Type<ItemDragStartHandler> getAssociatedType() {
		return TYPE;
	}

	protected ItemDragStartEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public AbstractSeries getSeries() {
		return series;
	}

	public JavaScriptObject getItem() {
		return item;
	}

}
