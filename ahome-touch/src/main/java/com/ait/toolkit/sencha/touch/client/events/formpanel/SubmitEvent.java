package com.ait.toolkit.sencha.touch.client.events.formpanel;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.client.ui.FormPanel;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class SubmitEvent extends EventObject {

	public static String EVENT_NAME = "submit";

	private FormPanel source;
	private JavaScriptObject result;

	/**
	 * UiBinder implementations
	 */
	private static Type<SubmitHandler> TYPE = new Type<SubmitHandler>(EVENT_NAME, null);

	public static Type<SubmitHandler> getType() {
		return TYPE;
	}

	public static Type<SubmitHandler> getAssociatedType() {
		return TYPE;
	}

	public FormPanel getSource() {
		return source;
	}

	public JavaScriptObject getResult() {
		return result;
	}

	public SubmitEvent(JavaScriptObject nativeEvent, FormPanel source, JavaScriptObject result) {
		super(nativeEvent);
		this.source = source;
		this.result = result;
	}

}
