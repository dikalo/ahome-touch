package com.ait.toolkit.sencha.touch.client.events.slider;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.client.ui.Slider;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class DragEvent extends EventObject {

	public static String EVENT_NAME = "drag";

	private Slider source;

	public DragEvent(Slider source, JavaScriptObject jsObj) {
		super(jsObj);
		this.source = source;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<DragHandler> TYPE = new Type<DragHandler>(EVENT_NAME, null);

	public static Type<DragHandler> getType() {
		return TYPE;
	}

	public static Type<DragHandler> getAssociatedType() {
		return TYPE;
	}

	public DragEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public Slider getSource() {
		return source;
	}

}
