package com.ait.toolkit.sencha.touch.client.events.mask;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.client.ui.Mask;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class TapEvent extends EventObject {

	public static String EVENT_NAME = "tap";

	private Mask source;

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

	public TapEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public TapEvent(Mask source, JavaScriptObject nativeEvent) {
		super(nativeEvent);
		this.source = source;

	}

	/**
	 * @return the source
	 */
	public Mask getSource() {
		return source;
	}
}
