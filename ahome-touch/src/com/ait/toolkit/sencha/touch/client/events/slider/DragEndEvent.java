package com.ait.toolkit.sencha.touch.client.events.slider;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.client.ui.Slider;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class DragEndEvent extends EventObject {

	public static String EVENT_NAME = "dragend";

	private Slider source;
	private int value;

	public DragEndEvent(Slider source, int value, JavaScriptObject jsObj) {
		super(jsObj);
		this.source = source;
		this.value = value;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<DragEndHandler> TYPE = new Type<DragEndHandler>(EVENT_NAME, null);

	public static Type<DragEndHandler> getType() {
		return TYPE;
	}

	public static Type<DragEndHandler> getAssociatedType() {
		return TYPE;
	}

	public DragEndEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public Slider getSource() {
		return source;
	}

	public int getValue() {
		return value;
	}

}
