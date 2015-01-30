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
package com.ait.toolkit.sencha.touch.client.util;

/**
 * A simple class to verify if a browser feature exists or not on the current
 * device.
 * 
 * @see http://docs.sencha.com/touch/2-0/#!/api/Ext.feature.has
 */
public class Has {

    private static Has instance = null;

    public static Has get() {
        if (instance == null) {
            instance = new Has();
        }
        return instance;
    }

    /**
     * Constructor
     */
    private Has() {
    }

    /**
     * True if the current device supports the <audio> tag.
     * 
     * @return boolean
     */
    public native boolean audio() /*-{
		return $wnd.Ext.feature.has.Audio;
    }-*/;

    /**
     * True if the current device supports Canvas.
     * 
     * @return boolean
     */
    public native boolean canvas() /*-{
		return $wnd.Ext.feature.has.Canvas;
    }-*/;

    /**
     * True if document environment supports the HTML5 classList API.
     * 
     * @return boolean
     */
    public native boolean classList() /*-{
		return $wnd.Ext.feature.has.ClassList;
    }-*/;

    /**
     * True if a contextual fragment can be created.
     * 
     * @return boolean
     */
    public native boolean createContextualFragment() /*-{
		return $wnd.Ext.feature.has.CreateContextualFragment;
    }-*/;

    /**
     * True if the current device supports CSS 3D Transform animations.
     * 
     * @return boolean
     */
    public native boolean css3dTransforms() /*-{
		return $wnd.Ext.feature.has.Css3dTransforms;
    }-*/;

    /**
     * True if the current device supports CSS Animations.
     * 
     * @return boolean
     */
    public native boolean cssAnimations() /*-{
		return $wnd.Ext.feature.has.CssAnimations;
    }-*/;

    /**
     * True if the current device supports CSS Transform animations.
     * 
     * @return boolean
     */
    public native boolean cssTransforms() /*-{
		return $wnd.Ext.feature.has.CssTransforms;
    }-*/;

    /**
     * True if the current device supports CSS Transitions.
     * 
     * @return boolean
     */
    public native boolean cssTransitions() /*-{
		return $wnd.Ext.feature.has.CssTransitions;
    }-*/;

    /**
     * True if the current device supports the devicemotion event.
     * 
     * @return boolean
     */
    public native boolean deviceMotion() /*-{
		return $wnd.Ext.feature.has.DeviceMotion;
    }-*/;

    /**
     * True if the current device supports Geolocation.
     * 
     * @return boolean
     */
    public native boolean geolocation() /*-{
		return $wnd.Ext.feature.has.Geolocation;
    }-*/;

    /**
     * True if the current device supports History.
     * 
     * @return boolean
     */
    public native boolean history() /*-{
		return $wnd.Ext.feature.has.History;
    }-*/;

    /**
     * True if the current device supports different orientations.
     * 
     * @return boolean
     */
    public native boolean orientation() /*-{
		return $wnd.Ext.feature.has.Orientation;
    }-*/;

    /**
     * True if the current device supports the orientationchange event.
     * 
     * @return boolean
     */
    public native boolean orientationChange() /*-{
		return $wnd.Ext.feature.has.OrientationChange;
    }-*/;

    /**
     * True if the Range property is available.
     * 
     * @return boolean
     */
    public native boolean range() /*-{
		return $wnd.Ext.feature.has.Range;
    }-*/;

    /**
     * True if the current device supports SQL Databases.
     * 
     * @return boolean
     */
    public native boolean sqlDatabase() /*-{
		return $wnd.Ext.feature.has.SqlDatabase;
    }-*/;

    /**
     * True if the current device supports SVG.
     * 
     * @return boolean
     */
    public native boolean svg() /*-{
		return $wnd.Ext.feature.has.Svg;
    }-*/;

    /**
     * True if the current device supports touch events (touchstart).
     * 
     * @return boolean
     */
    public native boolean touch() /*-{
		return $wnd.Ext.feature.has.Touch;
    }-*/;

    /**
     * True if the current device supports the <video> tag.
     * 
     * @return boolean
     */
    public native boolean video() /*-{
		return $wnd.Ext.feature.has.Video;
    }-*/;

    /**
     * True if the current device supports VML.
     * 
     * @return boolean
     */
    public native boolean vml() /*-{
		return $wnd.Ext.feature.has.Vml;
    }-*/;

    /**
     * True if the current device supports web sockets.
     * 
     * @return boolean
     */
    public native boolean webSockets() /*-{
		return $wnd.Ext.feature.has.WebSockets;
    }-*/;
}
