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
 * Provides useful information about the current browser.
 * 
 */
public class Browser {

    private static Browser instance = null;

    public static Browser get() {
        if (instance == null) {
            instance = new Browser();
        }
        return instance;
    }

    /**
     * The full name of the current browser's engine Possible values are:
     * WebKit, Gecko, Presto, Trident and Other
     * 
     * @return String
     */
    public native String getEngineName()/*-{
		return $wnd.Ext.env.Browser.engineName;
    }-*/;

    /**
     * True if page is running over SSL.
     * 
     * @return boolean
     */
    public native boolean isSecure()/*-{
		return $wnd.Ext.env.Browser.isSecure;
    }-*/;

    /**
     * True if browser is using strict mode.
     * 
     * @return boolean
     */
    public native boolean isStrict()/*-{
		return $wnd.Ext.env.Browser.isStrict;
    }-*/;

    /**
     * The full name of the current browser Possible values are: IE, Firefox,
     * Safari, Chrome, Opera and Other
     * 
     * @return String
     */
    public native String getName()/*-{
		return $wnd.Ext.env.Browser.name;
    }-*/;

    /**
     * Browser User Agent string.
     * 
     * @return String
     */
    public native String getUserAgent()/*-{
		return $wnd.Ext.env.Browser.userAgent;
    }-*/;

    /**
     * Check the browser agent
     * 
     * @return String
     */
    public native boolean is(String value)/*-{
		return $wnd.Ext.env.Browser.is(value);
    }-*/;

}
