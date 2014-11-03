package com.ait.toolkit.sencha.touch.client.events.component;

import com.google.gwt.event.dom.client.DomEvent.Type;

public class DesktroyEvent {

	public static String EVENT_NAME = "destroy";

	/**
	 * UiBinder implementations
	 */
	private static Type<DestroyHandler> TYPE = new Type<DestroyHandler>(EVENT_NAME, null);

	public static Type<DestroyHandler> getType() {
		return TYPE;
	}

	public static Type<DestroyHandler> getAssociatedType() {
		return TYPE;
	}

	protected DesktroyEvent() {

	}

}
