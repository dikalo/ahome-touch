package com.ait.toolkit.sencha.touch.client.events.map;

import com.ait.toolkit.sencha.touch.client.ui.GoogleMap;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ZoomChangeEvent {

	public static String EVENT_NAME = "zoomchange";

	private GoogleMap source;
	private JavaScriptObject nativeMap;
	private int zoomLevel;

	/**
	 * UiBinder implementations
	 */
	private static Type<ZoomChangeHandler> TYPE = new Type<ZoomChangeHandler>(EVENT_NAME, null);

	public static Type<ZoomChangeHandler> getType() {
		return TYPE;
	}

	public static Type<ZoomChangeHandler> getAssociatedType() {
		return TYPE;
	}

	public ZoomChangeEvent(GoogleMap source, JavaScriptObject nativeMap, int zoomLevel) {
		super();
		this.source = source;
		this.nativeMap = nativeMap;
		this.zoomLevel = zoomLevel;
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

	public int getZoomLevel() {
		return zoomLevel;
	}

}
