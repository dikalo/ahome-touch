package com.ait.toolkit.sencha.touch.client.events.navigation;

import com.ait.toolkit.sencha.touch.client.ui.Container;
import com.ait.toolkit.sencha.touch.client.ui.NavigationView;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class PushEvent {

	public static String EVENT_NAME = "push";

	private NavigationView source;
	private Container view;

	/**
	 * UiBinder implementations
	 */
	private static Type<PushHandler> TYPE = new Type<PushHandler>(EVENT_NAME, null);

	public static Type<PushHandler> getType() {
		return TYPE;
	}

	public static Type<PushHandler> getAssociatedType() {
		return TYPE;
	}

	public PushEvent(NavigationView source, Container view) {
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
