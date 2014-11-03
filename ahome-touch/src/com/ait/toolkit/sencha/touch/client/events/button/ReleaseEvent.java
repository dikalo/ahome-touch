package com.ait.toolkit.sencha.touch.client.events.button;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.client.ui.Button;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ReleaseEvent extends EventObject {

	public static String EVENT_NAME = "release";

	private Button source;

	/**
	 * UiBinder implementations
	 */
	private static Type<ReleaseHandler> TYPE = new Type<ReleaseHandler>(EVENT_NAME, null);

	public static Type<ReleaseHandler> getType() {
		return TYPE;
	}

	public static Type<ReleaseHandler> getAssociatedType() {
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
