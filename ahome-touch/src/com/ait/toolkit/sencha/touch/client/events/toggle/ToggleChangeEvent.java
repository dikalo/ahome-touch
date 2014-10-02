package com.ait.toolkit.sencha.touch.client.events.toggle;

import com.ait.toolkit.sencha.touch.client.ui.CheckBox;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ToggleChangeEvent {

	public static String EVENT_NAME = "change";

	private CheckBox source;
	private boolean newValue;
	private boolean value;

	protected ToggleChangeEvent(CheckBox source, boolean newValue, boolean value) {
		super();
		this.source = source;
		this.newValue = newValue;
		this.value = value;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<ToggleChangeHandler> TYPE = new Type<ToggleChangeHandler>(EVENT_NAME, null);

	public static Type<ToggleChangeHandler> getType() {
		return TYPE;
	}

	public static Type<ToggleChangeHandler> getAssociatedType() {
		return TYPE;
	}

	/**
	 * @return the source
	 */
	public CheckBox getSource() {
		return source;
	}

	public boolean isChecked() {
		return newValue;
	}

	public boolean wasChecked() {
		return value;
	}
}
