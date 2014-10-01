package com.ait.toolkit.sencha.touch.client.events.button;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.client.ui.Button;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ReleaseEvent extends EventObject {

	public static String EVENT_NAME = "tap";

	private Button source;

	/**
	 * UiBinder implementations
	 */
	private static Type<TapHandler> TYPE = new Type<TapHandler>(EVENT_NAME, null);

	public static Type<TapHandler> getType() {
		return TYPE;
	}

	public static Type<TapHandler> getAssociatedType() {
		return TYPE;
	}

	public ReleaseEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public ReleaseEvent(Button source, JavaScriptObject nativeEvent) {
		super(nativeEvent);
		this.source = source;

	}

	/**
	 * @return the source
	 */
	public Button getSource() {
		return source;
	}
}
