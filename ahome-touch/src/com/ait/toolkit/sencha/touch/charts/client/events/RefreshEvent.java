package com.ait.toolkit.sencha.touch.charts.client.events;

import com.ait.toolkit.sencha.touch.charts.client.AbstractChart;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class RefreshEvent {

	public static String EVENT_NAME = "refresh";

	private AbstractChart source;

	public RefreshEvent(AbstractChart source) {
		this.source = source;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<RefreshHandler> TYPE = new Type<RefreshHandler>(EVENT_NAME, null);

	public static Type<RefreshHandler> getType() {
		return TYPE;
	}

	public static Type<RefreshHandler> getAssociatedType() {
		return TYPE;
	}

	public AbstractChart getSource() {
		return source;
	}

}
