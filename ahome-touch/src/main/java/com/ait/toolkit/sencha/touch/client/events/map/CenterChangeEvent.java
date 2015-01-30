package com.ait.toolkit.sencha.touch.client.events.map;

import com.ait.toolkit.sencha.touch.client.ui.GoogleMap;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class CenterChangeEvent {

	public static String EVENT_NAME = "centerchange";

	private GoogleMap source;
	private JavaScriptObject nativeMap;
	private JavaScriptObject latLgn;

	/**
	 * UiBinder implementations
	 */
	private static Type<CenterChangeHandler> TYPE = new Type<CenterChangeHandler>(EVENT_NAME, null);

	public static Type<CenterChangeHandler> getType() {
		return TYPE;
	}

	public static Type<CenterChangeHandler> getAssociatedType() {
		return TYPE;
	}

	public CenterChangeEvent(GoogleMap source, JavaScriptObject nativeMap, JavaScriptObject latLgn) {
		super();
		this.source = source;
		this.nativeMap = nativeMap;
		this.latLgn = latLgn;
	}

	/**
	 * @return the source
	 */
	public GoogleMap getSource() {
		return source;
	}

	public JavaScriptObject getNativeMap() {
		return nativeMap;
	}

	public JavaScriptObject getLatLgn() {
		return latLgn;
	}
}
