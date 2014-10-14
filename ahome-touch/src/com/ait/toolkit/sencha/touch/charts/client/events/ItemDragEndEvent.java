package com.ait.toolkit.sencha.touch.charts.client.events;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ItemDragEndEvent extends EventObject {

	public static String EVENT_NAME = "itemdoubletap";

	private AbstractSeries series;
	private JavaScriptObject item;

	public ItemDragEndEvent(AbstractSeries series, JavaScriptObject item, JavaScriptObject nativeEvent) {
		super(nativeEvent);
		this.series = series;
		this.item = item;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<ItemDoubleTapHandler> TYPE = new Type<ItemDoubleTapHandler>(EVENT_NAME, null);

	public static Type<ItemDoubleTapHandler> getType() {
		return TYPE;
	}

	public static Type<ItemDoubleTapHandler> getAssociatedType() {
		return TYPE;
	}

	protected ItemDragEndEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public AbstractSeries getSeries() {
		return series;
	}

	public JavaScriptObject getItem() {
		return item;
	}

}
