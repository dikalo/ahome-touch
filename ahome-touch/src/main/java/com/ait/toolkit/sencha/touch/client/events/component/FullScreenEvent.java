package com.ait.toolkit.sencha.touch.client.events.component;

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class FullScreenEvent {

	public static String EVENT_NAME = "fullscreen";

	private Component source;

	/**
	 * UiBinder implementations
	 */
	private static Type<FullScreenHandler> TYPE = new Type<FullScreenHandler>(EVENT_NAME, null);

	public static Type<FullScreenHandler> getType() {
		return TYPE;
	}

	public static Type<FullScreenHandler> getAssociatedType() {
		return TYPE;
	}

	protected FullScreenEvent(Component source) {
		this.source = source;

	}

	/**
	 * @return the source
	 */
	public Component getSource() {
		return source;
	}

}
