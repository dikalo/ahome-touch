package com.ait.toolkit.sencha.touch.client.events.formpanel;

import com.ait.toolkit.sencha.touch.client.ui.FormPanel;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ExceptionEvent {

	public static String EVENT_NAME = "exception";

	private FormPanel source;
	private JavaScriptObject result;

	/**
	 * UiBinder implementations
	 */
	private static Type<ExceptionHandler> TYPE = new Type<ExceptionHandler>(EVENT_NAME, null);

	public static Type<ExceptionHandler> getType() {
		return TYPE;
	}

	public static Type<ExceptionHandler> getAssociatedType() {
		return TYPE;
	}

	public FormPanel getSource() {
		return source;
	}

	public ExceptionEvent(FormPanel source, JavaScriptObject result) {
		this.source = source;
		this.result = result;
	}

	public JavaScriptObject getResult() {
		return result;
	}

}
