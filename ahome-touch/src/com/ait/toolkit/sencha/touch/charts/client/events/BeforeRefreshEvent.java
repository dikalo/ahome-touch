package com.ait.toolkit.sencha.touch.charts.client.events;

import com.ait.toolkit.sencha.touch.charts.client.AbstractChart;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class BeforeRefreshEvent {

	public static String EVENT_NAME = "beforerefresh";

	private AbstractChart source;

	public BeforeRefreshEvent(AbstractChart source) {
		this.source = source;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<BeforeRefreshHandler> TYPE = new Type<BeforeRefreshHandler>(EVENT_NAME, null);

	public static Type<BeforeRefreshHandler> getType() {
		return TYPE;
	}

	public static Type<BeforeRefreshHandler> getAssociatedType() {
		return TYPE;
	}

	public AbstractChart getSource() {
		return source;
	}

}
