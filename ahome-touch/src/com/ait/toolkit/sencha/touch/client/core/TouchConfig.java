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
package com.ait.toolkit.sencha.touch.client.core;

import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.core.client.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Configuration class for the TouchEntryPoint. This class should be used with
 * the ConfigurableTouchEntryPoint class.
 */
public class TouchConfig extends JsObject {

    private InitHandler handler;

    public TouchConfig() {
        jsObj = JsoHelper.createObject();
    }

    /**
     * Callbacks to be called as soon as touch4j detects that the browser is
     * ready.
     * 
     * @param handler
     */
    public void setOnReady(InitHandler handler) {
        assert handler != null;
        this.handler = handler;
        _setOnReady(this.handler.getJsoPeer());
    }

    /**
     * set this option to true to allow your application to execute in full
     * screen mode. Doing so instructs Touch4j to initialize the ViewPort.
     * 
     * @param value
     */
    public native void setFullScreen(boolean value)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.fullscreen = value;
    }-*/;

    /**
     * If you want a startup screen to dispay when your application bootstraps,
     * you will want to set this property to the URL of that image. You will
     * need to consult your hardware manufacturer for details o the screen size
     * for your target devices.
     * 
     * @param value
     */
    public native void setTabletStartupScreen(String value)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.tabletStartupScreen = value;
    }-*/;

    /**
     * Set this option to the URL of an image that you would like to use as
     * startup screen for your phone. Since device resolution vary, you should
     * consult the manufacturer documentation for details on the screen size.
     * 
     * @param value
     */
    public native void setPhoneStartupScreen(String value)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.phoneStartupScreen = value;
    }-*/;

    /**
     * This option should be set to the URL of your 72x72 pixel icon. It should
     * only be set if you play on using the same icon for the phones and
     * tablets.
     * 
     * @param value
     */
    public native void setIcon(String value)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.icon = value;
    }-*/;

    /**
     * If you plan on having a tablet-specific icon, you want to set this
     * property the the URL for that icon. Your icon should be sized to 72x72.
     * This propert will oerride the icon property.
     * 
     * @param value
     */
    public native void setTabletIcon(String value)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.tabletIcon = value;
    }-*/;

    /**
     * If you plan on having a phone-specific icon, you want to set this
     * property the the URL for that icon. Your icon should be sized to 72x72.
     * This propert will oerride the icon property.
     * 
     * @param value
     */
    public native void setPhoneIcon(String value)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.phoneIcon = value;
    }-*/;

    /**
     * Set this configuration to true to instruct iOS to add a glass effect to
     * the home screen icon for your app.
     * 
     * @param value
     */
    public native void setGlossIcon(boolean value)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.glossIcon = value;
    }-*/;

    /**
     * This option is used to configure iOS top-most status bar style. There
     * three available options to you : 'default', 'black', black-translucent'
     * 
     * @param value
     */
    public void setStatusBarStyle(StatusBarStyle style) {
        _setStatusBarStyle(style.getValue());
    }

    private native void _setStatusBarStyle(String value)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.statusBarStyle = value;
    }-*/;

    private native void _setOnReady(JavaScriptObject handler)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.onReady = handler;
    }-*/;

    public InitHandler getHandler() {
        return this.handler;
    }
}
