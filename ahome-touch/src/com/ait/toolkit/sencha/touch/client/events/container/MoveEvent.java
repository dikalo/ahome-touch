package com.ait.toolkit.sencha.touch.client.events.container;

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.ait.toolkit.sencha.touch.client.ui.Container;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class MoveEvent {

	public static String EVENT_NAME = "move";

	private Container source;
	private Component item;
	private int toIndex;
	private int fromIndex;

	public MoveEvent(Container source, Component item, int toIndex, int fromIndex) {
		super();
		this.source = source;
		this.item = item;
		this.toIndex = toIndex;
		this.fromIndex = fromIndex;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<MoveHandler> TYPE = new Type<MoveHandler>(EVENT_NAME, null);

	public static Type<MoveHandler> getType() {
		return TYPE;
	}

	public static Type<MoveHandler> getAssociatedType() {
		return TYPE;
	}

	public Container getSource() {
		return source;
	}

	public Component getItem() {
		return item;
	}

	public int getToIndex() {
		return toIndex;
	}

	public int getFromIndex() {
		return fromIndex;
	}

}
