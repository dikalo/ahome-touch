package com.ait.toolkit.sencha.touch.client.events.text;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.client.ui.Text;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class KeyUpEvent extends EventObject {

	public static String EVENT_NAME = "keyup";

	@SuppressWarnings("rawtypes")
	private Text source;

	/**
	 * UiBinder implementations
	 */
	private static Type<KeyUpHandler> TYPE = new Type<KeyUpHandler>(EVENT_NAME, null);

	public static Type<KeyUpHandler> getType() {
		return TYPE;
	}

	public static Type<KeyUpHandler> getAssociatedType() {
		return TYPE;
	}

	public KeyUpEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	@SuppressWarnings("rawtypes")
	public KeyUpEvent(Text source, JavaScriptObject nativeEvent) {
		super(nativeEvent);
		this.source = source;

	}

	/**
	 * @return the source
	 */
	@SuppressWarnings("rawtypes")
	public Text getSource() {
		return source;
	}
}
