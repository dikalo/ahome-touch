package com.ait.toolkit.sencha.touch.charts.client.events;

import com.ait.toolkit.sencha.touch.charts.client.AbstractChart;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class RedrawEvent {

	public static String EVENT_NAME = "redraw";

	private AbstractChart source;

	public RedrawEvent(AbstractChart source) {
		this.source = source;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<RedrawHandler> TYPE = new Type<RedrawHandler>(EVENT_NAME, null);

	public static Type<RedrawHandler> getType() {
		return TYPE;
	}

	public static Type<RedrawHandler> getAssociatedType() {
		return TYPE;
	}

	public AbstractChart getSource() {
		return source;
	}

}
