package com.ait.toolkit.sencha.touch.client.events.component;

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class MinHeightChangeEvent {

	public static String EVENT_NAME = "minheightchange";

	private Component source;
	private Object value;
	private Object oldValue;

	/**
	 * UiBinder implementations
	 */
	private static Type<MinHeightChangeHandler> TYPE = new Type<MinHeightChangeHandler>(EVENT_NAME, null);

	public static Type<MinHeightChangeHandler> getType() {
		return TYPE;
	}

	public static Type<MinHeightChangeHandler> getAssociatedType() {
		return TYPE;
	}

	public MinHeightChangeEvent(Component source, Object value, Object oldValue) {
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
