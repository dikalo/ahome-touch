package com.ait.toolkit.sencha.touch.client.events.container;

import com.ait.toolkit.sencha.touch.client.ui.Container;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ScrollableChangeEvent {

	public static String EVENT_NAME = "scrollablechange";

	private Container source;
	private Object value;
	private Object newValue;

	public ScrollableChangeEvent(Container source, Object value, Object newValue) {
		super();
		this.source = source;
		this.value = value;
		this.newValue = newValue;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<RemoveHandler> TYPE = new Type<RemoveHandler>(EVENT_NAME, null);

	public static Type<RemoveHandler> getType() {
		return TYPE;
	}

	public static Type<RemoveHandler> getAssociatedType() {
		return TYPE;
	}

	public Container getSource() {
		return source;
	}

	public Object getValue() {
		return value;
	}

	public Object getNewValue() {
		return newValue;
	}

}
