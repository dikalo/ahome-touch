package com.ait.toolkit.sencha.touch.client.events.spinner;

import com.ait.toolkit.sencha.touch.client.ui.Spinner;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class SpinEvent {

	public static String EVENT_NAME = "spin";

	@SuppressWarnings("rawtypes")
	private Spinner source;
	private int value;
	private String direction;

	public SpinEvent(@SuppressWarnings("rawtypes") Spinner source, int value, String direction) {
		this.source = source;
		this.value = value;
		this.direction = direction;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<SpinHandler> TYPE = new Type<SpinHandler>(EVENT_NAME, null);

	public static Type<SpinHandler> getType() {
		return TYPE;
	}

	public static Type<SpinHandler> getAssociatedType() {
		return TYPE;
	}

	@SuppressWarnings("rawtypes")
	public Spinner getSource() {
		return source;
	}

	public int getValue() {
		return value;
	}

	public String getDirection() {
		return direction;
	}

}
