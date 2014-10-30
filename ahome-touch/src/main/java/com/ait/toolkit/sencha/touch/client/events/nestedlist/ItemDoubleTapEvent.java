package com.ait.toolkit.sencha.touch.client.events.nestedlist;

import com.ait.toolkit.data.client.BaseModel;
import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.shared.client.dom.ExtElement;
import com.ait.toolkit.sencha.touch.client.ui.ListView;
import com.ait.toolkit.sencha.touch.client.ui.NestedList;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ItemDoubleTapEvent extends EventObject {

	public static String EVENT_NAME = "itemdoubletap";

	private NestedList source;
	private ListView list;
	private int index;
	private ExtElement target;
	private BaseModel record;

	/**
	 * UiBinder implementations
	 */
	private static Type<ItemDoubleTapHandler> TYPE = new Type<ItemDoubleTapHandler>(EVENT_NAME, null);

	public static Type<ItemDoubleTapHandler> getType() {
		return TYPE;
	}

	public static Type<ItemDoubleTapHandler> getAssociatedType() {
		return TYPE;
	}

	/**
	 * @return the source
	 */
	public NestedList getSource() {
		return source;
	}

	public ItemDoubleTapEvent(JavaScriptObject nativeEvent, NestedList source, ListView list, int index, ExtElement target, BaseModel record) {
		super(nativeEvent);
		this.source = source;
		this.list = list;
		this.index = index;
		this.target = target;
		this.record = record;
	}

	public ListView getList() {
		return list;
	}

	public int getIndex() {
		return index;
	}

	public ExtElement getTargetElement() {
		return target;
	}

	public BaseModel getRecord() {
		return record;
	}

}
