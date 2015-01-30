package com.ait.toolkit.sencha.touch.client.events.text;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.client.ui.Text;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class FocusEvent extends EventObject {

	public static String EVENT_NAME = "focus";

	@SuppressWarnings("rawtypes")
	private Text source;

	/**
	 * UiBinder implementations
	 */
	private static Type<FocusHandler> TYPE = new Type<FocusHandler>(EVENT_NAME, null);

	public static Type<FocusHandler> getType() {
		return TYPE;
	}

	public static Type<FocusHandler> getAssociatedType() {
		return TYPE;
	}

	public FocusEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	@SuppressWarnings("rawtypes")
	public FocusEvent(Text source, JavaScriptObject nativeEvent) {
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
