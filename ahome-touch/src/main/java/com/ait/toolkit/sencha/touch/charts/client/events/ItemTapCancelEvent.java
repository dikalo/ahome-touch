package com.ait.toolkit.sencha.touch.charts.client.events;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ItemTapCancelEvent extends EventObject {

	public static String EVENT_NAME = "itemtapcancel";

	private AbstractSeries series;
	private JavaScriptObject item;

	public ItemTapCancelEvent(AbstractSeries series, JavaScriptObject item, JavaScriptObject nativeEvent) {
		super(nativeEvent);
		this.series = series;
		this.item = item;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<ItemTapCancelHandler> TYPE = new Type<ItemTapCancelHandler>(EVENT_NAME, null);

	public static Type<ItemTapCancelHandler> getType() {
		return TYPE;
	}

	public static Type<ItemTapCancelHandler> getAssociatedType() {
		return TYPE;
	}

	protected ItemTapCancelEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public AbstractSeries getSeries() {
		return series;
	}

	public JavaScriptObject getItem() {
		return item;
	}

}
