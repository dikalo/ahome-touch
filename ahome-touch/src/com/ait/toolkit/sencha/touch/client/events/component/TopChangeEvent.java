package com.ait.toolkit.sencha.touch.client.events.component;

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class TopChangeEvent {

	public static String EVENT_NAME = "topchange";

	private Component source;
	private Object value;
	private Object oldValue;

	/**
	 * UiBinder implementations
	 */
	private static Type<TopChangeHandler> TYPE = new Type<TopChangeHandler>(EVENT_NAME, null);

	public static Type<TopChangeHandler> getType() {
		return TYPE;
	}

	public static Type<TopChangeHandler> getAssociatedType() {
		return TYPE;
	}

	public TopChangeEvent(Component source, Object value, Object oldValue) {
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
