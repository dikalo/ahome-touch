package com.ait.toolkit.sencha.touch.client.events.component;

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class MinWidthChangeEvent {

	public static String EVENT_NAME = "minwidthchange";

	private Component source;
	private Object value;
	private Object oldValue;

	/**
	 * UiBinder implementations
	 */
	private static Type<MinWidthChangeHandler> TYPE = new Type<MinWidthChangeHandler>(EVENT_NAME, null);

	public static Type<MinWidthChangeHandler> getType() {
		return TYPE;
	}

	public static Type<MinWidthChangeHandler> getAssociatedType() {
		return TYPE;
	}

	protected MinWidthChangeEvent(Component source, Object value, Object oldValue) {
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
