package com.ait.toolkit.sencha.touch.client.events.component;

import com.ait.toolkit.sencha.shared.client.dom.ExtElement;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class PaintedEvent {

	public static String EVENT_NAME = "painted";

	private ExtElement source;

	/**
	 * UiBinder implementations
	 */
	private static Type<PaintedHandler> TYPE = new Type<PaintedHandler>(EVENT_NAME, null);

	public static Type<PaintedHandler> getType() {
		return TYPE;
	}

	public static Type<PaintedHandler> getAssociatedType() {
		return TYPE;
	}

	protected PaintedEvent(ExtElement source) {
		this.source = source;
	}

	/**
	 * @return the source
	 */
	public ExtElement getSource() {
		return source;
	}

}
