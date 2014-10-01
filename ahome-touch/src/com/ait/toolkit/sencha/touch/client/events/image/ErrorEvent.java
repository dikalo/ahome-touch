package com.ait.toolkit.sencha.touch.client.events.image;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.client.ui.Image;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ErrorEvent extends EventObject {

	public static String EVENT_NAME = "error";

	private Image source;

	/**
	 * UiBinder implementations
	 */
	private static Type<ErrorHandler> TYPE = new Type<ErrorHandler>(EVENT_NAME, null);

	public static Type<ErrorHandler> getType() {
		return TYPE;
	}

	public static Type<ErrorHandler> getAssociatedType() {
		return TYPE;
	}

	public ErrorEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public ErrorEvent(Image source, JavaScriptObject nativeEvent) {
		super(nativeEvent);
		this.source = source;

	}

	/**
	 * @return the source
	 */
	public Image getSource() {
		return source;
	}
}
