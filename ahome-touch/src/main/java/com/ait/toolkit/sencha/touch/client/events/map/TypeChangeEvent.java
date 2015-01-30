package com.ait.toolkit.sencha.touch.client.events.map;

import com.ait.toolkit.sencha.touch.client.ui.GoogleMap;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class TypeChangeEvent {

	public static String EVENT_NAME = "typechange";

	private GoogleMap source;
	private JavaScriptObject nativeMap;
	private int mapType;

	/**
	 * UiBinder implementations
	 */
	private static Type<TypeChangeHandler> TYPE = new Type<TypeChangeHandler>(EVENT_NAME, null);

	public static Type<TypeChangeHandler> getType() {
		return TYPE;
	}

	public static Type<TypeChangeHandler> getAssociatedType() {
		return TYPE;
	}

	public TypeChangeEvent(GoogleMap source, JavaScriptObject nativeMap, int mapType) {
		super();
		this.source = source;
		this.nativeMap = nativeMap;
		this.mapType = mapType;
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

	public int getMapType() {
		return mapType;
	}

}
