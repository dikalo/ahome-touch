package com.ait.toolkit.sencha.touch.client.events.component;

import com.google.gwt.event.dom.client.DomEvent.Type;

public class ErasedEvent {

	public static String EVENT_NAME = "erased";

	/**
	 * UiBinder implementations
	 */
	private static Type<ErasedHandler> TYPE = new Type<ErasedHandler>(EVENT_NAME, null);

	public static Type<ErasedHandler> getType() {
		return TYPE;
	}

	public static Type<ErasedHandler> getAssociatedType() {
		return TYPE;
	}

	protected ErasedEvent() {

	}

}
