package com.ait.toolkit.sencha.touch.client.events.navigation;

import com.ait.toolkit.sencha.touch.client.ui.NavigationView;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class BackEvent {

	public static String EVENT_NAME = "back";

	private NavigationView source;

	/**
	 * UiBinder implementations
	 */
	private static Type<BackHandler> TYPE = new Type<BackHandler>(EVENT_NAME, null);

	public static Type<BackHandler> getType() {
		return TYPE;
	}

	public static Type<BackHandler> getAssociatedType() {
		return TYPE;
	}

	public BackEvent(NavigationView source) {
		this.source = source;
	}

	/**
	 * @return the source
	 */
	public NavigationView getSource() {
		return source;
	}
}
