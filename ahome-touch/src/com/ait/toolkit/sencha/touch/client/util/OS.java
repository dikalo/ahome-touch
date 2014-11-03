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
public class OS {

    /**
     * Operating system types.
     * 
     * @see http://docs.sencha.com/touch/2-0/#!/api/Ext.env.OS
     */
    public enum type {
        iOS, iPad, iPhone, iPod, Android, WebOS, BlackBerry, RIMTablet, Bada, MacOSX, Windows, Linux, Other;
    }

    private static OS instance = null;

    public static OS get() {
        if (instance == null) {
            instance = new OS();
        }
        return instance;
    }

    /**
     * The full name of the current browser Possible values are: IE, Firefox,
     * Safari, Chrome, Opera and Other
     * 
     * @return String
     */
    public native String getName()/*-{
		return $wnd.Ext.env.OS.name;
    }-*/;

    /**
     * The device type.
     * 
     * @return
     */
    public native String getDeviceType() /*-{
		return $wnd.Ext.os.deviceType;
    }-*/;

    /**
     * Check the browser agent
     * 
     * @return String
     */
    public native boolean is(String value)/*-{
		return $wnd.Ext.os.is(value);
    }-*/;

    /**
     * Returns true if the OS is a mobile OS
     */
    public boolean isDesktopOS() {
        String deviceType = getDeviceType();
        return deviceType != null && deviceType.equalsIgnoreCase("desktop");
    }

    /**
     * Returns true if iOS
     * 
     * @return boolean
     */
    public boolean isIos() {
        return is(type.iOS.toString());
    }

    /**
     * Returns true if iPad
     * 
     * @return boolean
     */
    public boolean isIpad() {
        return is(type.iPad.toString());
    }

    /**
     * Returns true if iPhone
     * 
     * @return boolean
     */
    public boolean isIphone() {
        return is(type.iPhone.toString());
    }

    /**
     * Returns true if iPod
     * 
     * @return boolean
     */
    public boolean isIpod() {
        return is(type.iPod.toString());
    }

    /**
     * Returns true if Android.
     * 
     * @return boolean
     */
    public boolean isAndroid() {
        return is(type.Android.toString());
    }

    /**
     * Returns true if WebOS.
     * 
     * @return boolean
     */
    public boolean isWebOs() {
        return is(type.WebOS.toString());
    }

    /**
     * Returns true if BlackBerry.
     * 
     * @return boolean
     */
    public boolean isBlackBerry() {
        return is(type.BlackBerry.toString());
    }

    /**
     * Returns true if this is a RIM Tablet OS
     * 
     * @return boolean
     */
    public boolean isRimTablet() {
        return is(type.RIMTablet.toString());
    }

    /**
     * Returns true if Bada.
     * 
     * @return boolean
     */
    public boolean isBada() {
        return is(type.Bada.toString());
    }

    /**
     * Returns true if MacOSX
     * 
     * @return boolean
     */
    public boolean isMacOsX() {
        return is(type.MacOSX.toString());
    }

    /**
     * Returns true if Windows.
     * 
     * @return boolean
     */
    public boolean isWindows() {
        return is(type.Windows.toString());
    }

    /**
     * Returns true if Linux.
     * 
     * @return boolean
     */
    public boolean isLinux() {
        return is(type.Linux.toString());
    }

    /**
     * Returns true if Other
     * 
     * @return boolean
     */
    public boolean isOther() {
        return is(type.Other.toString());
    }

    /**
     * Returns true if the application is running on a mobile phone
     * 
     * @return
     */
    public boolean isPhone() {
        return is("phone");
    }

    /**
     * Returns true if the application is running on a tablet
     * 
     * @return
     */
    public boolean isTablet() {
        return is("tablet");
    }

    /**
     * Returns true if the application is running on a desktop pc
     * 
     * @return
     */
    public boolean isDesktop() {
        return is("desktop");
    }
}
