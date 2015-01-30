package com.ait.toolkit.sencha.touch.client.events.component;

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.google.gwt.event.dom.client.DomEvent.Type;

/**
 * Fires when the bottom configuration is changed by setBottom.
 */
public class HiddenChangeEvent {

	public static String EVENT_NAME = "hiddenchange";

	private Component source;
	private boolean isHidden;
	private boolean wasHidden;

	protected HiddenChangeEvent(Component source, boolean isHidden, boolean wasHidden) {
		super();
		this.source = source;
		this.isHidden = isHidden;
		this.wasHidden = wasHidden;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<HiddenChangeHandler> TYPE = new Type<HiddenChangeHandler>(EVENT_NAME, null);

	public static Type<HiddenChangeHandler> getType() {
		return TYPE;
	}

	public static Type<HiddenChangeHandler> getAssociatedType() {
		return TYPE;
	}

	/**
	 * @return the source
	 */
	public Component getSource() {
		return source;
	}

	public boolean isHidden() {
		return isHidden;
	}

	public boolean wasHidden() {
		return wasHidden;
	}

}
