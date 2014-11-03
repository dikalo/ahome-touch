package com.ait.toolkit.sencha.touch.client.events.checkbox;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.client.ui.CheckBox;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class CheckEvent extends EventObject {

	public static String EVENT_NAME = "check";

	private CheckBox source;

	/**
	 * UiBinder implementations
	 */
	private static Type<CheckHandler> TYPE = new Type<CheckHandler>(EVENT_NAME, null);

	public static Type<CheckHandler> getType() {
		return TYPE;
	}

	public static Type<CheckHandler> getAssociatedType() {
		return TYPE;
	}

	public CheckEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public CheckEvent(CheckBox source, JavaScriptObject nativeEvent) {
		super(nativeEvent);
		this.source = source;
	}

	/**
	 * @return the source
	 */
	public CheckBox getSource() {
		return source;
	}
}
