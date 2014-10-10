package com.ait.toolkit.sencha.touch.client.events.nestedlist;

import com.ait.toolkit.sencha.touch.client.ui.ListView;
import com.ait.toolkit.sencha.touch.client.ui.NestedList;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ListChangeEvent {

	public static String EVENT_NAME = "listchange";

	private NestedList source;
	private ListView list;

	/**
	 * UiBinder implementations
	 */
	private static Type<ListChangeHandler> TYPE = new Type<ListChangeHandler>(EVENT_NAME, null);

	public static Type<ListChangeHandler> getType() {
		return TYPE;
	}

	public static Type<ListChangeHandler> getAssociatedType() {
		return TYPE;
	}

	/**
	 * @return the source
	 */
	public NestedList getSource() {
		return source;
	}

	public ListChangeEvent(NestedList source, ListView list) {
		this.source = source;
		this.list = list;
	}

	public ListView getNewList() {
		return list;
	}
}
