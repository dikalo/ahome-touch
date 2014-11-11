package com.ait.toolkit.sencha.touch.charts.client.events;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ItemTapHoldEvent extends EventObject {

	public static String EVENT_NAME = "itemtaphold";

	private AbstractSeries series;
	private JavaScriptObject item;

	public ItemTapHoldEvent(AbstractSeries series, JavaScriptObject item, JavaScriptObject nativeEvent) {
		super(nativeEvent);
		this.series = series;
		this.item = item;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<ItemTapHoldHandler> TYPE = new Type<ItemTapHoldHandler>(EVENT_NAME, null);

	public static Type<ItemTapHoldHandler> getType() {
		return TYPE;
	}

	public static Type<ItemTapHoldHandler> getAssociatedType() {
		return TYPE;
	}

	protected ItemTapHoldEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public AbstractSeries getSeries() {
		return series;
	}

	public JavaScriptObject getItem() {
		return item;
	}

}
