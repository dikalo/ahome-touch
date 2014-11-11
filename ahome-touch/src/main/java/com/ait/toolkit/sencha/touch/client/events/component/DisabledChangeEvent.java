package com.ait.toolkit.sencha.touch.client.events.component;

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.google.gwt.event.dom.client.DomEvent.Type;

/**
 * Fires when the bottom configuration is changed by setBottom.
 */
public class DisabledChangeEvent {

	public static String EVENT_NAME = "disabledchange";

	private Component source;
	private boolean value;
	private boolean oldValue;

	protected DisabledChangeEvent(Component source, boolean value, boolean oldValue) {
		super();
		this.source = source;
		this.value = value;
		this.oldValue = oldValue;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<DisabledChangeHandler> TYPE = new Type<DisabledChangeHandler>(EVENT_NAME, null);

	public static Type<DisabledChangeHandler> getType() {
		return TYPE;
	}

	public static Type<DisabledChangeHandler> getAssociatedType() {
		return TYPE;
	}

	/**
	 * @return the source
	 */
	public Component getSource() {
		return source;
	}

	public boolean isDisabled() {
		return value;
	}

	public boolean wasDisabled() {
		return oldValue;
	}

}
