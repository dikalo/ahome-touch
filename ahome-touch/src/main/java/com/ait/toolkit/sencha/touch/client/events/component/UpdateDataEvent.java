package com.ait.toolkit.sencha.touch.client.events.component;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.client.core.Component;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class UpdateDataEvent extends EventObject {

	public static String EVENT_NAME = "updatedata";

	private Component source;
	private JavaScriptObject newData;

	/**
	 * UiBinder implementations
	 */
	private static Type<UpdateDataHandler> TYPE = new Type<UpdateDataHandler>(EVENT_NAME, null);

	public static Type<UpdateDataHandler> getType() {
		return TYPE;
	}

	public static Type<UpdateDataHandler> getAssociatedType() {
		return TYPE;
	}

	public UpdateDataEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	protected UpdateDataEvent(Component source, JavaScriptObject newData) {
		this.source = source;
		this.newData = newData;
	}

	/**
	 * @return the source
	 */
	public Component getSource() {
		return source;
	}

	public JavaScriptObject getNewData() {
		return newData;
	}

}
