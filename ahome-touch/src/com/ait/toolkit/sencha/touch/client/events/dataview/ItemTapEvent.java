package com.ait.toolkit.sencha.touch.client.events.dataview;

import com.ait.toolkit.data.client.BaseModel;
import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.client.ui.ListView;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ItemTapEvent extends EventObject {

	public static String EVENT_NAME = "itemtap";

	private ListView source;
	private BaseModel record;
	private Element target;
	private int index;

	/**
	 * UiBinder implementations
	 */
	private static Type<ItemTapHandler> TYPE = new Type<ItemTapHandler>(EVENT_NAME, null);

	public static Type<ItemTapHandler> getType() {
		return TYPE;
	}

	public static Type<ItemTapHandler> getAssociatedType() {
		return TYPE;
	}

	protected ItemTapEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public ItemTapEvent(JavaScriptObject jsObj, ListView source, BaseModel record, Element target, int index) {
		super(jsObj);
		this.source = source;
		this.record = record;
		this.target = target;
		this.index = index;
	}

	/**
	 * @return the source
	 */
	public ListView getSource() {
		return source;
	}

	public BaseModel getRecord() {
		return record;
	}

	public Element getTarget() {
		return target;
	}

	public int getIndex() {
		return index;
	}
}
