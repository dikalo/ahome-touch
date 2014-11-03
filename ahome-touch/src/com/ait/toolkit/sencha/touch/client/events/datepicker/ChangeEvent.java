package com.ait.toolkit.sencha.touch.client.events.datepicker;

import com.ait.toolkit.sencha.touch.client.ui.DatePicker;
import com.google.gwt.core.client.JsDate;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ChangeEvent {

	public static String EVENT_NAME = "change";

	private DatePicker source;
	private JsDate value;

	public ChangeEvent(DatePicker source, JsDate value) {
		super();
		this.source = source;
		this.value = value;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<ChangeHandler> TYPE = new Type<ChangeHandler>(EVENT_NAME, null);

	public static Type<ChangeHandler> getType() {
		return TYPE;
	}

	public static Type<ChangeHandler> getAssociatedType() {
		return TYPE;
	}

	public DatePicker getSource() {
		return source;
	}

	public JsDate getValue() {
		return value;
	}

}
