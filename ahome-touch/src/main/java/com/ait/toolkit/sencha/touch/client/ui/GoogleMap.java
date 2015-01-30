/*
 Copyright (c) 2014 Ahomé Innovation Technologies. All rights reserved.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package com.ait.toolkit.sencha.touch.client.ui;

import com.ait.toolkit.sencha.shared.client.core.XType;
import com.ait.toolkit.sencha.touch.client.core.Component;
import com.ait.toolkit.sencha.touch.client.events.HandlerRegistration;
import com.ait.toolkit.sencha.touch.client.events.map.CenterChangeHandler;
import com.ait.toolkit.sencha.touch.client.events.map.MapRenderHandler;
import com.ait.toolkit.sencha.touch.client.events.map.TypeChangeHandler;
import com.ait.toolkit.sencha.touch.client.events.map.ZoomChangeHandler;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Wraps a Google Map in a Component <br/>
 * http://code.google.com/apis/maps/documentation/v3/introduction.html <br/>
 * To use this component you must include an additional JavaScript file from Google:<br/>
 * {@code
 * <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true"></script>
 * }
 */
public class GoogleMap extends Component {

	private static final String CENTER_CHANGE = "centerchange";
	private static final String MAP_RENDER = "maprender";
	private static final String TYPE_CHANGE = "typechange";
	private static final String ZOOM_CHANGE = "zoomchange";

	private GoogleMap(JavaScriptObject config) {
		super(config);
	}

	@Override
	protected native void init()/*-{
		var c = new $wnd.Ext.Map();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
	}-*/;

	@Override
	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.Map(config);
	}-*/;

	public String getXType() {
		return XType.MAP.getValue();
	}

	/**
	 * Constructor.
	 */
	public GoogleMap() {
	}

	/**
	 * Constructor.
	 * 
	 * @param useCurrentLocation
	 */
	public GoogleMap(boolean useCurrentLocation) {
		setUseCurrentLocation(useCurrentLocation);
	}

	/**
	 * Returns the value of baseCls.
	 * 
	 * @return String
	 */
	@Override
	public native String getBaseCls() /*-{
		var map = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return map.getBaseCls();
	}-*/;

	/**
	 * Returns the value of map.
	 * 
	 * @return Map
	 */
	public native JavaScriptObject getMap() /*-{
		var map = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return map.getMap();
	}-*/;

	/**
	 * Returns the value of mapOptions.
	 * 
	 * @return T
	 */
	public native <T> T getMapOptions() /*-{
		var map = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return map.getMapOptions();
	}-*/;

	public native boolean isUseCurrentLocation() /*-{
		var map = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return map.getUseCurrentLocation();
	}-*/;

	/**
	 * Sets the value of baseCls.
	 * 
	 * @param value
	 */
	@Override
	public native void setBaseCls(String value) /*-{
		var map = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		map.setBaseCls(value);
	}-*/;

	/**
	 * Sets the value of mapOptions.
	 * 
	 * @param value
	 */
	public native void setMapOptions(Object value) /*-{
		var map = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		map.setMapOptions(value);
	}-*/;

	/**
	 * Sets the value of useCurrentLocation
	 */

	public native void setUseCurrentLocation(boolean value) /*-{
		var map = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		map.setUseCurrentLocation(value);
	}-*/;

	public native HandlerRegistration addCenterChangeHandler(CenterChangeHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(m, g, l) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.GoogleMap::new(Lcom/google/gwt/core/client/JavaScriptObject;)(f);
			var event = @com.ait.toolkit.sencha.touch.client.events.map.CenterChangeEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/GoogleMap;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(comp,g,l);
			handler.@com.ait.toolkit.sencha.touch.client.events.map.CenterChangeHandler::onCenterChange(Lcom/ait/toolkit/sencha/touch/client/events/map/CenterChangeEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.map.CenterChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addMapRenderHandler(MapRenderHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(m, g) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.GoogleMap::new(Lcom/google/gwt/core/client/JavaScriptObject;)(f);
			var event = @com.ait.toolkit.sencha.touch.client.events.map.MapRenderEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/GoogleMap;Lcom/google/gwt/core/client/JavaScriptObject;)(comp,g);
			handler.@com.ait.toolkit.sencha.touch.client.events.map.MapRenderHandler::onMapRender(Lcom/ait/toolkit/sencha/touch/client/events/map/MapRenderEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.map.MapRenderEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addTypeChangeHandler(TypeChangeHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(m, g, t) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.GoogleMap::new(Lcom/google/gwt/core/client/JavaScriptObject;)(f);
			var event = @com.ait.toolkit.sencha.touch.client.events.map.TypeChangeEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/GoogleMap;Lcom/google/gwt/core/client/JavaScriptObject;I)(c,g,t);
			handler.@com.ait.toolkit.sencha.touch.client.events.map.TypeChangeHandler::onTypeChange(Lcom/ait/toolkit/sencha/touch/client/events/map/TypeChangeEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.map.TypeChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addZoomChangeHandler(ZoomChangeHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(m, g, z) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.GoogleMap::new(Lcom/google/gwt/core/client/JavaScriptObject;)(f);
			var event = @com.ait.toolkit.sencha.touch.client.events.map.ZoomChangeEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/GoogleMap;Lcom/google/gwt/core/client/JavaScriptObject;I)(comp,g,z);
			handler.@com.ait.toolkit.sencha.touch.client.events.map.ZoomChangeHandler::onZoomChange(Lcom/ait/toolkit/sencha/touch/client/events/map/ZoomChangeEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.map.ZoomChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

}
