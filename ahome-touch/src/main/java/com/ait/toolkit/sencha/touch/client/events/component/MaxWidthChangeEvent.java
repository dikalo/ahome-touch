package com.ait.toolkit.sencha.touch.client.events.component;

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class MaxWidthChangeEvent {

	public static String EVENT_NAME = "maxwidthchange";

	private Component source;
	private Object value;
	private Object oldValue;

	/**
	 * UiBinder implementations
	 */
	private static Type<MaxWidthChangeHandler> TYPE = new Type<MaxWidthChangeHandler>(EVENT_NAME, null);

	public static Type<MaxWidthChangeHandler> getType() {
		return TYPE;
	}

	public static Type<MaxWidthChangeHandler> getAssociatedType() {
		return TYPE;
	}

	public Component getSource() {
		return source;
	}

	protected MaxWidthChangeEvent(Component source, Object value, Object oldValue) {
		super();
		this.source = source;
		this.value = value;
		this.oldValue = oldValue;
	}

	public Object getValue() {
		return value;
	}

	public Object getOldValue() {
		return oldValue;
	}
}
