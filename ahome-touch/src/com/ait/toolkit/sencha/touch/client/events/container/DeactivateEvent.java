package com.ait.toolkit.sencha.touch.client.events.container;

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.ait.toolkit.sencha.touch.client.ui.Container;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class DeactivateEvent {

	public static String EVENT_NAME = "deactivate";

	private Container source;
	private Component newActiveItem;
	private Component oldActiveItem;

	public DeactivateEvent(Container source, Component newActiveItem, Component oldActiveItem) {
		super();
		this.source = source;
		this.newActiveItem = newActiveItem;
		this.oldActiveItem = oldActiveItem;
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
