package com.ait.toolkit.sencha.touch.client.events.container;

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.ait.toolkit.sencha.touch.client.ui.Container;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class RemoveEvent {

	public static String EVENT_NAME = "remove";

	private Container source;
	private Component item;
	private int index;

	public RemoveEvent(Container source, Component item, int index) {
		super();
		this.source = source;
		this.item = item;
		this.index = index;
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

	public Component getItem() {
		return item;
	}

	public int getIndex() {
		return index;
	}

}
