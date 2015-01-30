package com.ait.toolkit.sencha.touch.client.events.component;

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.google.gwt.event.dom.client.DomEvent.Type;

/**
 * Fires when the bottom configuration is changed by setBottom.
 */
public class DockedChangeEvent {

	public static String EVENT_NAME = "dockedchange";

	private Component source;
	private String value;
	private String oldValue;

	protected DockedChangeEvent(Component source, String value, String oldValue) {
		super();
		this.source = source;
		this.value = value;
		this.oldValue = oldValue;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<DockedChangeHandler> TYPE = new Type<DockedChangeHandler>(EVENT_NAME, null);

	public static Type<DockedChangeHandler> getType() {
		return TYPE;
	}

	public static Type<DockedChangeHandler> getAssociatedType() {
		return TYPE;
	}

	/**
	 * @return the source
	 */
	public Component getSource() {
		return source;
	}

	public String getValue() {
		return value;
	}

	public String getOldValue() {
		return oldValue;
	}

}
