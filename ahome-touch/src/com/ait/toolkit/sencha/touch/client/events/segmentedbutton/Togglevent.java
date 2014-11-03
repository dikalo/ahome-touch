package com.ait.toolkit.sencha.touch.client.events.segmentedbutton;

import com.ait.toolkit.sencha.touch.client.ui.Button;
import com.ait.toolkit.sencha.touch.client.ui.SegmentedButton;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class Togglevent {

	public static String EVENT_NAME = "toggle";

	private SegmentedButton source;
	private Button pressedButton;
	private boolean pressed;

	public Togglevent(SegmentedButton source, Button pressedButton, boolean pressed) {
		super();
		this.source = source;
		this.pressedButton = pressedButton;
		this.pressed = pressed;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<ToggleHandler> TYPE = new Type<ToggleHandler>(EVENT_NAME, null);

	public static Type<ToggleHandler> getType() {
		return TYPE;
	}

	public static Type<ToggleHandler> getAssociatedType() {
		return TYPE;
	}

	/**
	 * @return the source
	 */
	public SegmentedButton getSource() {
		return source;
	}

	public boolean isPressed() {
		return pressed;
	}

	public Button getPressedButton() {
		return pressedButton;
	}

}
