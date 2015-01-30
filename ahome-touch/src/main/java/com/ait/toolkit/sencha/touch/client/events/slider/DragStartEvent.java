package com.ait.toolkit.sencha.touch.client.events.slider;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.client.ui.Slider;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class DragStartEvent extends EventObject {

	public static String EVENT_NAME = "dragstart";

	private Slider source;
	private int value;

	public DragStartEvent(Slider source, int value, JavaScriptObject jsObj) {
		super(jsObj);
		this.source = source;
		this.value = value;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<DragStartHandler> TYPE = new Type<DragStartHandler>(EVENT_NAME, null);

	public static Type<DragStartHandler> getType() {
		return TYPE;
	}

	public static Type<DragStartHandler> getAssociatedType() {
		return TYPE;
	}

	public DragStartEvent(Slider source, JavaScriptObject jsObj, int value) {
		super(jsObj);
		this.source = source;
		this.value = value;
	}

	public Slider getSource() {
		return source;
	}

	public int getValue() {
		return value;
	}

}
