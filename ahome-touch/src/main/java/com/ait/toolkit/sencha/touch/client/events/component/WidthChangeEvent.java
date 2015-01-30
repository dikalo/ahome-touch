package com.ait.toolkit.sencha.touch.client.events.component;

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class WidthChangeEvent {

	public static String EVENT_NAME = "widthchange";

	private Component source;
	private Object value;
	private Object oldValue;

	/**
	 * UiBinder implementations
	 */
	private static Type<WidthChangeHandler> TYPE = new Type<WidthChangeHandler>(EVENT_NAME, null);

	public static Type<WidthChangeHandler> getType() {
		return TYPE;
	}

	public static Type<WidthChangeHandler> getAssociatedType() {
		return TYPE;
	}

	public WidthChangeEvent(Component source, Object value, Object oldValue) {
		super();
		this.source = source;
		this.value = value;
		this.oldValue = oldValue;
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
