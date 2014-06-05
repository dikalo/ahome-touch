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

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.ait.toolkit.sencha.shared.client.core.XType;
import com.ait.toolkit.sencha.shared.client.core.handlers.CallbackRegistration;
import com.ait.toolkit.sencha.touch.client.core.handlers.map.MapCenterChangeHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.map.MapTypeChangeHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.map.MapZoomChangeHandler;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Wraps a Google Map in a Component <br/>
 * http://code.google.com/apis/maps/documentation/v3/introduction.html <br/>
 * To use this component you must include an additional JavaScript file from
 * Google:<br/>
 * {@code
 * <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true"></script>
 * }
 * 
 * @see <a href=http://docs.sencha.com/touch/2-0/#!/api/Ext.Map>Ext.Map</a>
 */
public class GoogleMap extends Component implements MapElement {

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

    /*
     * (non-Javadoc)
     * 
     * @see com.ait.toolkit.sencha.touch.client.widgets.MapElement#isUseCurrentLocation()
     */
    @Override
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
    @Override
    public native void setUseCurrentLocation(boolean value) /*-{
		var map = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		map.setUseCurrentLocation(value);
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.ait.toolkit.sencha.touch.client.widgets.MapElement#addCenterChangeHandler
     * (com.ait.toolkit.sencha.touch.client.core.handlers.map.MapCenterChangeHandler)
     */
    @Override
    public CallbackRegistration addCenterChangeHandler(MapCenterChangeHandler handler) {
        return addWidgetListener(CENTER_CHANGE, handler.getJsoPeer());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ait.toolkit.sencha.touch.client.ui.MapElement#addTypeChangeHandler
     * (com.ait.toolkit.sencha.touch.client.core.handlers.map.MapTypeChangeHandler)
     */
    @Override
    public CallbackRegistration addTypeChangeHandler(MapTypeChangeHandler handler) {
        return addWidgetListener(TYPE_CHANGE, handler.getJsoPeer());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ait.toolkit.sencha.touch.client.widgets.MapElement#addZoomChangeHandler
     * (com.ait.toolkit.sencha.touch.client.core.handlers.map.MapZoomChangeHandler)
     */
    @Override
    public CallbackRegistration addZoomChangeHandler(MapZoomChangeHandler handler) {
        return addWidgetListener(ZOOM_CHANGE, handler.getJsoPeer());
    }

    @Override
    public String getText() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setText(String text) {
        // TODO Auto-generated method stub

    }
}
