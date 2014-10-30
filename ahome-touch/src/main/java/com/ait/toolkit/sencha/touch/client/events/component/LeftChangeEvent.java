package com.ait.toolkit.sencha.touch.client.events.component;

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class LeftChangeEvent {

	public static String EVENT_NAME = "leftchange";

	private Component source;
	private Object value;
	private Object oldValue;

	/**
	 * UiBinder implementations
	 */
	private static Type<LeftChangeHandler> TYPE = new Type<LeftChangeHandler>(EVENT_NAME, null);

	public static Type<LeftChangeHandler> getType() {
		return TYPE;
	}

	public static Type<LeftChangeHandler> getAssociatedType() {
		return TYPE;
	}

	protected LeftChangeEvent(Component source, Object value, Object oldValue) {
		super();
		this.source = source;
		this.value = value;
		this.oldValue = oldValue;
	}

	/**
	 * @return the source
	 */
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
