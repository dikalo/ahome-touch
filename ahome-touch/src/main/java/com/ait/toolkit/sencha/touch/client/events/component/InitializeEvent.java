package com.ait.toolkit.sencha.touch.client.events.component;

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class InitializeEvent {

	public static String EVENT_NAME = "initialize";

	private Component source;

	/**
	 * UiBinder implementations
	 */
	private static Type<HideHandler> TYPE = new Type<HideHandler>(EVENT_NAME, null);

	public static Type<HideHandler> getType() {
		return TYPE;
	}

	public static Type<HideHandler> getAssociatedType() {
		return TYPE;
	}

	protected InitializeEvent(Component source) {
		this.source = source;
	}

	/**
	 * @return the source
	 */
	public Component getSource() {
		return source;
	}
}
