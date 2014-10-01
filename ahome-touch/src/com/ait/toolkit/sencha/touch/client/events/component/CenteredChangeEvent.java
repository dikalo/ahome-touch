package com.ait.toolkit.sencha.touch.client.events.component;

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.google.gwt.event.dom.client.DomEvent.Type;

/**
 * Fires when the bottom configuration is changed by setBottom.
 */
public class CenteredChangeEvent {

	public static String EVENT_NAME = "centeredchange";

	private Component source;
	private boolean value;
	private boolean oldValue;

	/**
	 * UiBinder implementations
	 */
	private static Type<CenteredChangeHandler> TYPE = new Type<CenteredChangeHandler>(EVENT_NAME, null);

	public static Type<CenteredChangeHandler> getType() {
		return TYPE;
	}

	public static Type<CenteredChangeHandler> getAssociatedType() {
		return TYPE;
	}

	protected CenteredChangeEvent(Component source, boolean value, boolean oldValue) {
		super();
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

	public boolean isCentered() {
		return value;
	}

	public boolean wasCentered() {
		return oldValue;
	}

}
