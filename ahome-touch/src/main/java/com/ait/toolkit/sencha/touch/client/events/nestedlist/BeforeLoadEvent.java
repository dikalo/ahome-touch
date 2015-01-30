package com.ait.toolkit.sencha.touch.client.events.nestedlist;

import com.ait.toolkit.sencha.shared.client.data.Operation;
import com.ait.toolkit.sencha.shared.client.data.Store;
import com.ait.toolkit.sencha.touch.client.ui.NestedList;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class BeforeLoadEvent {

	public static String EVENT_NAME = "beforeload";

	private NestedList source;
	private Store store;
	private Operation operation;

	public BeforeLoadEvent(NestedList source, Store store, Operation operation) {
		super();
		this.source = source;
		this.store = store;
		this.operation = operation;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<BeforeLoadHandler> TYPE = new Type<BeforeLoadHandler>(EVENT_NAME, null);

	public static Type<BeforeLoadHandler> getType() {
		return TYPE;
	}

	public static Type<BeforeLoadHandler> getAssociatedType() {
		return TYPE;
	}

	/**
	 * @return the source
	 */
	public NestedList getSource() {
		return source;
	}

	public Store getStore() {
		return store;
	}

	public Operation getOperation() {
		return operation;
	}

}
