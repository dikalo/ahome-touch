package com.ait.toolkit.sencha.touch.client.events.picker;

import com.ait.toolkit.sencha.touch.client.ui.Picker;
import com.ait.toolkit.sencha.touch.client.ui.PickerSlot;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class PickEvent {

	public static String EVENT_NAME = "pick";

	private Picker source;
	private JavaScriptObject value;
	private PickerSlot slot;

	/**
	 * UiBinder implementations
	 */
	private static Type<PickHandler> TYPE = new Type<PickHandler>(EVENT_NAME, null);

	public static Type<PickHandler> getType() {
		return TYPE;
	}

	public static Type<PickHandler> getAssociatedType() {
		return TYPE;
	}

	public PickEvent(Picker source, JavaScriptObject value, PickerSlot slot) {
		this.source = source;
		this.value = value;
		this.slot = slot;
	}

	/**
	 * @return the source
	 */
	public Picker getSource() {
		return source;
	}

	public JavaScriptObject getValue() {
		return value;
	}

	public PickerSlot getSlot() {
		return slot;
	}
}
