package com.ait.toolkit.sencha.touch.client.events.component;

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class RightChangeEvent {

	public static String EVENT_NAME = "rightchange";

	private Component source;
	private Object value;
	private Object oldValue;

	protected RightChangeEvent(Component source, Object value, Object oldValue) {
		super();
		this.source = source;
		this.value = value;
		this.oldValue = oldValue;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<RightChangeHandler> TYPE = new Type<RightChangeHandler>(EVENT_NAME, null);

	public static Type<RightChangeHandler> getType() {
		return TYPE;
	}

	public static Type<RightChangeHandler> getAssociatedType() {
		return TYPE;
	}

	public Component getSource() {
		return source;
	}

	public Object getValue() {
		return value;
	}

	public Object getOldValue() {
		return oldValue;
	}

}
