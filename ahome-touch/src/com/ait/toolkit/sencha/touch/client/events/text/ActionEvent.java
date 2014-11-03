package com.ait.toolkit.sencha.touch.client.events.text;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.touch.client.ui.Text;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ActionEvent extends EventObject {

	public static String EVENT_NAME = "action";

	@SuppressWarnings("rawtypes")
	private Text source;

	/**
	 * UiBinder implementations
	 */
	private static Type<ActionHandler> TYPE = new Type<ActionHandler>(EVENT_NAME, null);

	public static Type<ActionHandler> getType() {
		return TYPE;
	}

	public static Type<ActionHandler> getAssociatedType() {
		return TYPE;
	}

	public ActionEvent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	@SuppressWarnings("rawtypes")
	public ActionEvent(Text source, JavaScriptObject nativeEvent) {
		super(nativeEvent);
		this.source = source;

	}

	/**
	 * @return the source
	 */
	@SuppressWarnings("rawtypes")
	public Text getSource() {
		return source;
	}
}
