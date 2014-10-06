package com.ait.toolkit.sencha.touch.client.events.picker;

import com.ait.toolkit.sencha.touch.client.ui.Picker;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ChangeEvent {

	public static String EVENT_NAME = "change";

	private Picker source;
	private JavaScriptObject value;

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

	public ChangeEvent(Picker source, JavaScriptObject value) {
		this.source = source;
		this.value = value;
	}

	/**
	 * @return the source
	 */
	public Picker getSource() {
		return source;
	}

	public JavaScriptObject getValue() {
		return value;
	}
}
