package com.ait.toolkit.sencha.touch.client.events.datepickerfield;

import com.ait.toolkit.sencha.touch.client.ui.DatePickerField;
import com.google.gwt.core.client.JsDate;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class DateChangeEvent {

	public static String EVENT_NAME = "change";

	private DatePickerField source;
	private JsDate newDate;
	private JsDate oldDate;

	public DateChangeEvent(DatePickerField source, JsDate newDate, JsDate oldDate) {
		super();
		this.source = source;
		this.newDate = newDate;
		this.oldDate = oldDate;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<DateChangeHandler> TYPE = new Type<DateChangeHandler>(EVENT_NAME, null);

	public static Type<DateChangeHandler> getType() {
		return TYPE;
	}

	public static Type<DateChangeHandler> getAssociatedType() {
		return TYPE;
	}

	public DatePickerField getSource() {
		return source;
	}

	public JsDate getNewDate() {
		return newDate;
	}

	public JsDate getOldDate() {
		return oldDate;
	}

}
