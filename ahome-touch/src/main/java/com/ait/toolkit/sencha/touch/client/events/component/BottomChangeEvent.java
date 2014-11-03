package com.ait.toolkit.sencha.touch.client.events.component;

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.google.gwt.event.dom.client.DomEvent.Type;

/**
 * Fires when the bottom configuration is changed by setBottom.
 */
public class BottomChangeEvent {

	public static String EVENT_NAME = "bottomchange";

	private Component source;
	private Object value;
	private Object oldValue;

	/**
	 * UiBinder implementations
	 */
	private static Type<BottomChangeHandler> TYPE = new Type<BottomChangeHandler>(EVENT_NAME, null);

	public static Type<BottomChangeHandler> getType() {
		return TYPE;
	}

	public static Type<BottomChangeHandler> getAssociatedType() {
		return TYPE;
	}

	protected BottomChangeEvent(Component source, Object value, Object oldValue) {
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
