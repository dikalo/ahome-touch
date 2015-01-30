package com.ait.toolkit.sencha.touch.client.events.component;

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class FloatingChangeEvent {

	public static String EVENT_NAME = "floatingchange";

	private Component source;
	private boolean floating;

	protected FloatingChangeEvent(Component source, boolean floating) {
		super();
		this.source = source;
		this.floating = floating;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<FloatingChangeHandler> TYPE = new Type<FloatingChangeHandler>(EVENT_NAME, null);

	public static Type<FloatingChangeHandler> getType() {
		return TYPE;
	}

	public static Type<FloatingChangeHandler> getAssociatedType() {
		return TYPE;
	}

	/**
	 * @return the source
	 */
	public Component getSource() {
		return source;
	}

	public boolean isFloating() {
		return floating;
	}

}
