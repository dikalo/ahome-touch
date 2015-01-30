package com.ait.toolkit.sencha.touch.client.events.text;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.client.ui.Text;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ClearIconTapEvent extends EventObject {

	public static String EVENT_NAME = "clearicontap";

	@SuppressWarnings("rawtypes")
	private Text source;

	/**
	 * UiBinder implementations
	 */
	private static Type<ClearIconTapHandler> TYPE = new Type<ClearIconTapHandler>(EVENT_NAME, null);

	public static Type<ClearIconTapHandler> getType() {
		return TYPE;
	}

	public static Type<ClearIconTapHandler> getAssociatedType() {
		return TYPE;
	}

	public ClearIconTapEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	@SuppressWarnings("rawtypes")
	public ClearIconTapEvent(Text source, JavaScriptObject nativeEvent) {
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
