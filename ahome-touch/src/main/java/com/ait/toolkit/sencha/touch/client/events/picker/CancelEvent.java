package com.ait.toolkit.sencha.touch.client.events.picker;

import com.ait.toolkit.sencha.touch.client.ui.Picker;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class CancelEvent {

	public static String EVENT_NAME = "cancel";

	private Picker source;

	/**
	 * UiBinder implementations
	 */
	private static Type<CancelHandler> TYPE = new Type<CancelHandler>(EVENT_NAME, null);

	public static Type<CancelHandler> getType() {
		return TYPE;
	}

	public static Type<CancelHandler> getAssociatedType() {
		return TYPE;
	}

	public CancelEvent(Picker source) {
		this.source = source;
	}

	/**
	 * @return the source
	 */
	public Picker getSource() {
		return source;
	}
}
