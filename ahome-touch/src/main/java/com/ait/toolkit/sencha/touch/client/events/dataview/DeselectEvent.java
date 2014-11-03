package com.ait.toolkit.sencha.touch.client.events.dataview;

import com.ait.toolkit.data.client.BaseModel;
import com.ait.toolkit.sencha.touch.client.ui.DataView;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class DeselectEvent {

	public static String EVENT_NAME = "deselect";

	private DataView source;
	private BaseModel record;
	private boolean supressed;

	public DeselectEvent(DataView source, BaseModel record, boolean supressed) {
		super();
		this.source = source;
		this.record = record;
		this.supressed = supressed;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<DeselectHandler> TYPE = new Type<DeselectHandler>(EVENT_NAME, null);

	public static Type<DeselectHandler> getType() {
		return TYPE;
	}

	public static Type<DeselectHandler> getAssociatedType() {
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

	public boolean isSupressed() {
		return supressed;
	}
}
