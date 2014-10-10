package com.ait.toolkit.sencha.touch.client.events.nestedlist;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.client.ui.ListView;
import com.ait.toolkit.sencha.touch.client.ui.NestedList;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ContainerTapEvent extends EventObject {

	public static String EVENT_NAME = "containertap";

	private NestedList source;
	private ListView list;

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

	public ListView getList() {
		return list;
	}

	public ContainerTapEvent(NestedList source, ListView list, JavaScriptObject nativeEvent) {
		super(nativeEvent);
		this.source = source;
		this.list = list;
	}

}
