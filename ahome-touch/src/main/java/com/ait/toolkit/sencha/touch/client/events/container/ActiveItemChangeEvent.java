package com.ait.toolkit.sencha.touch.client.events.container;

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.ait.toolkit.sencha.touch.client.ui.Container;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ActiveItemChangeEvent {

	public static String EVENT_NAME = "activeitemchange";

	private Container source;
	private Component newActiveItem;
	private Component oldActiveItem;

	public ActiveItemChangeEvent(Container source, Component newActiveItem, Component oldActiveItem) {
		super();
		this.source = source;
		this.newActiveItem = newActiveItem;
		this.oldActiveItem = oldActiveItem;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<ActiveItemChangeHandler> TYPE = new Type<ActiveItemChangeHandler>(EVENT_NAME, null);

	public static Type<ActiveItemChangeHandler> getType() {
		return TYPE;
	}

	public static Type<ActiveItemChangeHandler> getAssociatedType() {
		return TYPE;
	}

	/**
	 * @return the source
	 */
	public Container getSource() {
		return source;
	}

	public Component getNewActiveItem() {
		return newActiveItem;
	}

	public Component getOldActiveItem() {
		return oldActiveItem;
	}
}
