package com.ait.toolkit.sencha.touch.charts.client.events;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ItemTapStartEvent extends EventObject {

	public static String EVENT_NAME = "itemtapstart";

	private AbstractSeries series;
	private JavaScriptObject item;

	public ItemTapStartEvent(AbstractSeries series, JavaScriptObject item, JavaScriptObject nativeEvent) {
		super(nativeEvent);
		this.series = series;
		this.item = item;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<ItemTapStartHandler> TYPE = new Type<ItemTapStartHandler>(EVENT_NAME, null);

	public static Type<ItemTapStartHandler> getType() {
		return TYPE;
	}

	public static Type<ItemTapStartHandler> getAssociatedType() {
		return TYPE;
	}

	protected ItemTapStartEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public AbstractSeries getSeries() {
		return series;
	}

	public JavaScriptObject getItem() {
		return item;
	}

}
