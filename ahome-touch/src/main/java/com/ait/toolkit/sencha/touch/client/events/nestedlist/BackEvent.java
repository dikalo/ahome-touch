package com.ait.toolkit.sencha.touch.client.events.nestedlist;

import com.ait.toolkit.sencha.touch.client.ui.ListView;
import com.ait.toolkit.sencha.touch.client.ui.NestedList;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class BackEvent {

	public static String EVENT_NAME = "back";

	private NestedList source;
	private Element node;
	private ListView lastActiveList;
	private boolean detailCardActive;

	public BackEvent(NestedList source, Element node, ListView lastActiveList, boolean detailCardActive) {
		super();
		this.source = source;
		this.node = node;
		this.lastActiveList = lastActiveList;
		this.detailCardActive = detailCardActive;
	}

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

	/**
	 * @return the source
	 */
	public NestedList getSource() {
		return source;
	}

	public Element getNode() {
		return node;
	}

	public ListView getLastActiveList() {
		return lastActiveList;
	}

	public boolean isDetailCardActive() {
		return detailCardActive;
	}
}
