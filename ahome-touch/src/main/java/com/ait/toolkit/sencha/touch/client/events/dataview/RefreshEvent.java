package com.ait.toolkit.sencha.touch.client.events.dataview;

import com.ait.toolkit.sencha.touch.client.ui.DataView;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class RefreshEvent {

	public static String EVENT_NAME = "refresh";

	private DataView source;

	public RefreshEvent(DataView source) {
		super();
		this.source = source;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<RefreshHandler> TYPE = new Type<RefreshHandler>(EVENT_NAME, null);

	public static Type<RefreshHandler> getType() {
		return TYPE;
	}

	public static Type<RefreshHandler> getAssociatedType() {
		return TYPE;
	}

	/**
	 * @return the source
	 */
	public DataView getSource() {
		return source;
	}
}
