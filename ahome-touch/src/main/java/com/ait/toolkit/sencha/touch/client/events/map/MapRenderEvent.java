package com.ait.toolkit.sencha.touch.client.events.map;

import com.ait.toolkit.sencha.touch.client.ui.GoogleMap;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class MapRenderEvent {

	public static String EVENT_NAME = "maprender";

	private GoogleMap source;
	private JavaScriptObject nativeMap;

	/**
	 * UiBinder implementations
	 */
	private static Type<MapRenderHandler> TYPE = new Type<MapRenderHandler>(EVENT_NAME, null);

	public static Type<MapRenderHandler> getType() {
		return TYPE;
	}

	public static Type<MapRenderHandler> getAssociatedType() {
		return TYPE;
	}

	public MapRenderEvent(GoogleMap source, JavaScriptObject nativeMap) {
		super();
		this.source = source;
		this.nativeMap = nativeMap;
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

}
