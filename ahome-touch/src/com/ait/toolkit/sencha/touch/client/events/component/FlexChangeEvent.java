package com.ait.toolkit.sencha.touch.client.events.component;

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class FlexChangeEvent {

	public static String EVENT_NAME = "flexchange";

	protected FlexChangeEvent(Component source, int value, int oldValue) {
		super();
		this.source = source;
		this.value = value;
		this.oldValue = oldValue;
	}

	private Component source;
	private int value;
	private int oldValue;

	/**
	 * UiBinder implementations
	 */
	private static Type<FlexChangeHandler> TYPE = new Type<FlexChangeHandler>(EVENT_NAME, null);

	public static Type<FlexChangeHandler> getType() {
		return TYPE;
	}

	public static Type<FlexChangeHandler> getAssociatedType() {
		return TYPE;
	}

	/**
	 * @return the source
	 */
	public Component getSource() {
		return source;
	}

	public int getValue() {
		return value;
	}

	public int getOldValue() {
		return oldValue;
	}

}
