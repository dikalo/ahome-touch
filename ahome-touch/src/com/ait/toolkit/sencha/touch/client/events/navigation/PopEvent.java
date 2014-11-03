package com.ait.toolkit.sencha.touch.client.events.navigation;

import com.ait.toolkit.sencha.touch.client.ui.Container;
import com.ait.toolkit.sencha.touch.client.ui.NavigationView;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class PopEvent {

	public static String EVENT_NAME = "pop";

	private NavigationView source;
	private Container view;

	/**
	 * UiBinder implementations
	 */
	private static Type<PopHandler> TYPE = new Type<PopHandler>(EVENT_NAME, null);

	public static Type<PopHandler> getType() {
		return TYPE;
	}

	public static Type<PopHandler> getAssociatedType() {
		return TYPE;
	}

	public PopEvent(NavigationView source, Container view) {
		this.source = source;
		this.view = view;
	}

	/**
	 * @return the source
	 */
	public NavigationView getSource() {
		return source;
	}

	public Container getView() {
		return view;
	}
}
