package com.ait.toolkit.sencha.touch.client.events.spinner;

import com.ait.toolkit.sencha.touch.client.ui.Spinner;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class SpinUpEvent {

	public static String EVENT_NAME = "spindup";

	@SuppressWarnings("rawtypes")
	private Spinner source;
	private int value;

	public SpinUpEvent(@SuppressWarnings("rawtypes") Spinner source, int value) {
		this.source = source;
		this.value = value;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<SpinUpHandler> TYPE = new Type<SpinUpHandler>(EVENT_NAME, null);

	public static Type<SpinUpHandler> getType() {
		return TYPE;
	}

	public static Type<SpinUpHandler> getAssociatedType() {
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
