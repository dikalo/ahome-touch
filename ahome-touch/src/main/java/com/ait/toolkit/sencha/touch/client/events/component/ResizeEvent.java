package com.ait.toolkit.sencha.touch.client.events.component;

import com.ait.toolkit.sencha.shared.client.dom.ExtElement;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ResizeEvent {

	public static String EVENT_NAME = "resize";

	private ExtElement source;

	/**
	 * UiBinder implementations
	 */
	private static Type<ResizeHandler> TYPE = new Type<ResizeHandler>(EVENT_NAME, null);

	public static Type<ResizeHandler> getType() {
		return TYPE;
	}

	public static Type<ResizeHandler> getAssociatedType() {
		return TYPE;
	}

	public ResizeEvent(ExtElement source) {
		this.source = source;
	}

	/**
	 * @return the source
	 */
	public ExtElement getSource() {
		return source;
	}

}
