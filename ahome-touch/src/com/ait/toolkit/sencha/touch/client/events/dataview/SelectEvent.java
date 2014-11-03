package com.ait.toolkit.sencha.touch.client.events.dataview;

import com.ait.toolkit.data.client.BaseModel;
import com.ait.toolkit.sencha.touch.client.ui.DataView;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class SelectEvent {

	public static String EVENT_NAME = "select";

	private DataView source;
	private BaseModel record;

	public SelectEvent(DataView source, BaseModel record) {
		super();
		this.source = source;
		this.record = record;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<SelectHandler> TYPE = new Type<SelectHandler>(EVENT_NAME, null);

	public static Type<SelectHandler> getType() {
		return TYPE;
	}

	public static Type<SelectHandler> getAssociatedType() {
		return TYPE;
	}

	/**
	 * @return the source
	 */
	public DataView getSource() {
		return source;
	}

	public BaseModel getRecord() {
		return record;
	}
}
