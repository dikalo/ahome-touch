package com.ait.toolkit.sencha.touch.client.events.image;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.client.ui.Image;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class LoadEvent extends EventObject {

	public static String EVENT_NAME = "load";

	private Image source;

	/**
	 * UiBinder implementations
	 */
	private static Type<LoadHandler> TYPE = new Type<LoadHandler>(EVENT_NAME, null);

	public static Type<LoadHandler> getType() {
		return TYPE;
	}

	public static Type<LoadHandler> getAssociatedType() {
		return TYPE;
	}

	public LoadEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public LoadEvent(Image source, JavaScriptObject nativeEvent) {
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
