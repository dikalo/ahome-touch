package com.ait.toolkit.sencha.touch.client.events.nestedlist;

import com.ait.toolkit.sencha.touch.client.ui.ListView;
import com.ait.toolkit.sencha.touch.client.ui.NestedList;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class SelectionChangeEvent {

	public static String EVENT_NAME = "selectionchange";

	private NestedList source;
	private ListView list;

	/**
	 * UiBinder implementations
	 */
	private static Type<SelectionChangeHandler> TYPE = new Type<SelectionChangeHandler>(EVENT_NAME, null);

	public static Type<SelectionChangeHandler> getType() {
		return TYPE;
	}

	public static Type<SelectionChangeHandler> getAssociatedType() {
		return TYPE;
	}

	/**
	 * @return the source
	 */
	public NestedList getSource() {
		return source;
	}

	public SelectionChangeEvent(NestedList source, ListView list) {
		this.source = source;
		this.list = list;
	}

	public ListView getNewList() {
		return list;
	}
}
