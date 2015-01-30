package com.ait.toolkit.sencha.touch.charts.client.events;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.charts.client.series.AbstractSeries;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ItemTouchEndEvent extends EventObject {

	public static String EVENT_NAME = "itemtouchend";

	private AbstractSeries series;
	private JavaScriptObject item;

	public ItemTouchEndEvent(AbstractSeries series, JavaScriptObject item, JavaScriptObject nativeEvent) {
		super(nativeEvent);
		this.series = series;
		this.item = item;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<ItemTouchEndHandler> TYPE = new Type<ItemTouchEndHandler>(EVENT_NAME, null);

	public static Type<ItemTouchEndHandler> getType() {
		return TYPE;
	}

	public static Type<ItemTouchEndHandler> getAssociatedType() {
		return TYPE;
	}

	protected ItemTouchEndEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public AbstractSeries getSeries() {
		return series;
	}

	public JavaScriptObject getItem() {
		return item;
	}

}
