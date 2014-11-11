package com.ait.toolkit.sencha.touch.client.events.container;

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.ait.toolkit.sencha.touch.client.ui.Container;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class AddEvent {

	public static String EVENT_NAME = "add";

	private Container source;
	private Component item;
	private int index;

	public AddEvent(Container source, Component item, int index) {
		super();
		this.source = source;
		this.item = item;
		this.index = index;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<ActivateHandler> TYPE = new Type<ActivateHandler>(EVENT_NAME, null);

	public static Type<ActivateHandler> getType() {
		return TYPE;
	}

	public static Type<ActivateHandler> getAssociatedType() {
		return TYPE;
	}

	public Component getItem() {
		return item;
	}

	public int getIndex() {
		return index;
	}

	public Container getSource() {
		return source;
	}

}
