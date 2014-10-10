package com.ait.toolkit.sencha.touch.client.events.nestedlist;

import java.util.List;

import com.ait.toolkit.data.client.BaseModel;
import com.ait.toolkit.sencha.shared.client.data.Operation;
import com.ait.toolkit.sencha.shared.client.data.Store;
import com.ait.toolkit.sencha.touch.client.ui.NestedList;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class LoadEvent {

	public static String EVENT_NAME = "load";

	private NestedList source;
	private Store store;
	private List<BaseModel> records;
	private Operation operation;
	private boolean successful;

	public LoadEvent(NestedList source, Store store, List<BaseModel> records, Operation operation, boolean successful) {
		super();
		this.source = source;
		this.store = store;
		this.records = records;
		this.operation = operation;
		this.successful = successful;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<LoadHandler> TYPE = new Type<LoadHandler>(EVENT_NAME, null);

	public static Type<LoadHandler> getType() {
		return TYPE;
	}

	public static Type<LoadHandler> getAssociatedType() {
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

	public List<BaseModel> getRecords() {
		return records;
	}

	public boolean isSuccessful() {
		return successful;
	}

}
