package com.ait.toolkit.sencha.touch.client.events.text;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.client.ui.Text;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class PasteEvent extends EventObject {

	public static String EVENT_NAME = "paste";

	@SuppressWarnings("rawtypes")
	private Text source;

	/**
	 * UiBinder implementations
	 */
	private static Type<PasteHandler> TYPE = new Type<PasteHandler>(EVENT_NAME, null);

	public static Type<PasteHandler> getType() {
		return TYPE;
	}

	public static Type<PasteHandler> getAssociatedType() {
		return TYPE;
	}

	public PasteEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	@SuppressWarnings("rawtypes")
	public PasteEvent(Text source, JavaScriptObject nativeEvent) {
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
