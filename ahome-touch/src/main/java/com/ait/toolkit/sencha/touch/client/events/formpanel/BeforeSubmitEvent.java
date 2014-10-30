package com.ait.toolkit.sencha.touch.client.events.formpanel;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.client.ui.FormPanel;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class BeforeSubmitEvent extends EventObject {

	public static String EVENT_NAME = "beforesubmit";

	private FormPanel source;
	private JavaScriptObject values;
	private JavaScriptObject options;

	/**
	 * UiBinder implementations
	 */
	private static Type<BeforeSumbitHandler> TYPE = new Type<BeforeSumbitHandler>(EVENT_NAME, null);

	public static Type<BeforeSumbitHandler> getType() {
		return TYPE;
	}

	public static Type<BeforeSumbitHandler> getAssociatedType() {
		return TYPE;
	}

	public FormPanel getSource() {
		return source;
	}

	public BeforeSubmitEvent(JavaScriptObject nativeEvent, FormPanel source, JavaScriptObject values, JavaScriptObject options) {
		super(nativeEvent);
		this.source = source;
		this.values = values;
		this.options = options;
	}

	public JavaScriptObject getValues() {
		return values;
	}

	public JavaScriptObject getOptions() {
		return options;
	}

}
