package com.ait.toolkit.sencha.touch.client.events.checkbox;

import com.ait.toolkit.sencha.touch.client.ui.CheckBox;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class CheckChangeEvent {

	public static String EVENT_NAME = "change";

	private CheckBox source;
	private boolean newValue;
	private boolean value;

	protected CheckChangeEvent(CheckBox source, boolean newValue, boolean value) {
		super();
		this.source = source;
		this.newValue = newValue;
		this.value = value;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<CheckChangeHandler> TYPE = new Type<CheckChangeHandler>(EVENT_NAME, null);

	public static Type<CheckChangeHandler> getType() {
		return TYPE;
	}

	public static Type<CheckChangeHandler> getAssociatedType() {
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
