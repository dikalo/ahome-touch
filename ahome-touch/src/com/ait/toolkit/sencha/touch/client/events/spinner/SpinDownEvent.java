package com.ait.toolkit.sencha.touch.client.events.spinner;

import com.ait.toolkit.sencha.touch.client.ui.Spinner;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class SpinDownEvent {

	public static String EVENT_NAME = "spindown";

	@SuppressWarnings("rawtypes")
	private Spinner source;
	private int value;

	public SpinDownEvent(@SuppressWarnings("rawtypes") Spinner source, int value) {
		this.source = source;
		this.value = value;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<SpinDownHandler> TYPE = new Type<SpinDownHandler>(EVENT_NAME, null);

	public static Type<SpinDownHandler> getType() {
		return TYPE;
	}

	public static Type<SpinDownHandler> getAssociatedType() {
		return TYPE;
	}

	@SuppressWarnings("rawtypes")
	public Spinner getSource() {
		return source;
	}

	public int getValue() {
		return value;
	}

}
