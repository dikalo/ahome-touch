package com.ait.toolkit.sencha.touch.client.events.checkbox;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.client.ui.CheckBox;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class UnCheckEvent extends EventObject {

	public static String EVENT_NAME = "uncheck";

	private CheckBox source;

	/**
	 * UiBinder implementations
	 */
	private static Type<UnCheckHandler> TYPE = new Type<UnCheckHandler>(EVENT_NAME, null);

	public static Type<UnCheckHandler> getType() {
		return TYPE;
	}

	public static Type<UnCheckHandler> getAssociatedType() {
		return TYPE;
	}

	public UnCheckEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public UnCheckEvent(CheckBox source, JavaScriptObject nativeEvent) {
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
