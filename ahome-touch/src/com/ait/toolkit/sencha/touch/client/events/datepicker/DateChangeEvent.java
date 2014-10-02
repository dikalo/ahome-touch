package com.ait.toolkit.sencha.touch.client.events.datepicker;

import com.ait.toolkit.sencha.touch.client.ui.DatePicker;
import com.google.gwt.core.client.JsDate;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class DateChangeEvent {

	public static String EVENT_NAME = "change";

	private DatePicker source;
	private JsDate newDate;
	private JsDate oldDate;

	public DateChangeEvent(DatePicker source, JsDate newDate, JsDate oldDate) {
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

	public DatePicker getSource() {
		return source;
	}

	public JsDate getNewDate() {
		return newDate;
	}

	public JsDate getOldDate() {
		return oldDate;
	}

}
