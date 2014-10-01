package com.ait.toolkit.sencha.touch.client.events.component;

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ShowEvent {

	public static String EVENT_NAME = "show";

	private Component source;

	/**
	 * UiBinder implementations
	 */
	private static Type<ShowHandler> TYPE = new Type<ShowHandler>(EVENT_NAME, null);

	public static Type<ShowHandler> getType() {
		return TYPE;
	}

	public static Type<ShowHandler> getAssociatedType() {
		return TYPE;
	}

	protected ShowEvent(Component source, JavaScriptObject nativeEvent) {
		this.source = source;
	}

	/**
	 * @return the source
	 */
	public Component getSource() {
		return source;
	}

}
