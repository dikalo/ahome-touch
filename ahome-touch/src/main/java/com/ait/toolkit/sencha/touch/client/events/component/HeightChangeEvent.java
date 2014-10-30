package com.ait.toolkit.sencha.touch.client.events.component;

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class HeightChangeEvent {

	public static String EVENT_NAME = "heightchange";

	private Component source;
	private Object value;
	private Object oldValue;

	protected HeightChangeEvent(Component source, Object value, Object oldValue) {
		super();
		this.source = source;
		this.value = value;
		this.oldValue = oldValue;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<HeightChangeHandler> TYPE = new Type<HeightChangeHandler>(EVENT_NAME, null);

	public static Type<HeightChangeHandler> getType() {
		return TYPE;
	}

	public static Type<HeightChangeHandler> getAssociatedType() {
		return TYPE;
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
