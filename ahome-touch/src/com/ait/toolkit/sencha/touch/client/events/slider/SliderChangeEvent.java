package com.ait.toolkit.sencha.touch.client.events.slider;

import com.ait.toolkit.sencha.touch.client.ui.Slider;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class SliderChangeEvent {

	public static String EVENT_NAME = "change";

	private Slider source;
	private int newValue;
	private int oldValue;

	public SliderChangeEvent(Slider source, int newValue, int oldValue) {
		this.source = source;
		this.newValue = newValue;
		this.oldValue = oldValue;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<SliderChangeHandler> TYPE = new Type<SliderChangeHandler>(EVENT_NAME, null);

	public static Type<SliderChangeHandler> getType() {
		return TYPE;
	}

	public static Type<SliderChangeHandler> getAssociatedType() {
		return TYPE;
	}

	public Slider getSource() {
		return source;
	}

	public int getNewValue() {
		return newValue;
	}

	public int getOldValue() {
		return oldValue;
	}

}
