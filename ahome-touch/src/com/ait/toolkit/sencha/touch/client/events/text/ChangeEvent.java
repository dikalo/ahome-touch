package com.ait.toolkit.sencha.touch.client.events.text;

import com.ait.toolkit.sencha.touch.client.ui.Text;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ChangeEvent {

	public static String EVENT_NAME = "change";

	@SuppressWarnings("rawtypes")
	private Text source;
	private Object newValue;
	private Object oldValue;

	@SuppressWarnings("rawtypes")
	public ChangeEvent(Text source, Object newValue, Object oldValue) {
		super();
		this.source = source;
		this.newValue = newValue;
		this.oldValue = oldValue;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<ChangeHandler> TYPE = new Type<ChangeHandler>(EVENT_NAME, null);

	public static Type<ChangeHandler> getType() {
		return TYPE;
	}

	public static Type<ChangeHandler> getAssociatedType() {
		return TYPE;
	}

	public Object getNewValue() {
		return newValue;
	}

	public Object getOldValue() {
		return oldValue;
	}

	@SuppressWarnings("rawtypes")
	public Text getSource() {
		return source;
	}

}
