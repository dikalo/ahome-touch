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

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

/**
 * A TouchEntryPoint that allows some configuration. The user should override
 * the setter methods in the subclass to set the config properties
 */
public abstract class ConfigurableTouchEntryPoint implements EntryPoint {

    private final int TICK = 10;
    private final int MAX_TIME_TO_WAIT = 10000;
    private final String message = "We are sorry, the application could not be loaded. Cordova took too long to respond.";
    private boolean fullScreen = true;
    private String tabletStartupScreen = "";
    private String phoneStartupScreen = "";
    private String icon = "";
    private String tabletIcon = "";
    private String phoneIcon = "";
    private boolean glossIcon = false;
    private StatusBarStyle statusBarStyle = StatusBarStyle.DEFAUlT;

    public abstract void onLoad();

    @Override
    public void onModuleLoad() {
        initTouch();
    }

    protected void initTouch() {
        TouchConfig config = new TouchConfig();
        config.setFullScreen(fullScreen);
        config.setTabletStartupScreen(tabletStartupScreen);
        config.setPhoneStartupScreen(phoneStartupScreen);
        config.setIcon(icon);
        config.setTabletIcon(tabletIcon);
        config.setPhoneIcon(phoneIcon);
        config.setGlossIcon(glossIcon);
        config.setStatusBarStyle(statusBarStyle);
        config.setOnReady(new InitHandler() {
            @Override
            protected void onInit() {
                onLoad();
            }
        });
        Touch.init(config);
    }

    protected void initTouchNative() {
        final double endTime = System.currentTimeMillis() + MAX_TIME_TO_WAIT;
        new Timer() {
            @Override
            public void run() {
                if (isDeviceReady()) {
                    initTouch();
                    return;
                } else {
                    if (System.currentTimeMillis() - endTime > 0) {
                        Window.alert(message);
                        return;
                    } else {
                        schedule(TICK);
                    }
                }
            }
        }.schedule(TICK);
    }

    /**
     * This method checks if the application is running natively or not. It also
     * gives the user the ability to override any setting specified (or not) in
     * the .html file. The global JavaScript variable that determines if an app
     * is running natively or not is called NATIVE (all caps). Override this
     * method with care, as it will take precedence over the NATIVE variable
     * that may have been defined in the .html file.
     * 
     * @return boolean true if the application should wait for the device to
     *         load; false otherwise.
     */
    protected boolean isNative() {
        return isApplicationNative();
    }

    /**
     * This method provides the ability to change an app from native to web
     * without changing any code. By simply altering the variable at runtime,
     * the app can be determined in what modality we are running.
     * 
     * @return boolean
     */
    private native boolean isApplicationNative()/*-{
		if ($wnd.NATIVE_APP) {
			return true;
		}
		return false;
    }-*/;

    /**
     * Returns the status of Cordova.available or PhoneGap.available
     * 
     * @return boolean the value of PhoneGap.available
     */
    public static native boolean isDeviceReady()/*-{
		if ($wnd.PhoneGap) {
			return $wnd.PhoneGap;
		}
		return false;
    }-*/;

    public void setFullScreen(boolean fullScreen) {
        this.fullScreen = fullScreen;
    }

    public void setTabletStartupScreen(String tabletStartupSreen) {
        this.tabletStartupScreen = tabletStartupSreen;
    }

    public void setPhoneStartupScreen(String phoneStartupSreen) {
        this.phoneStartupScreen = phoneStartupSreen;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setTabletIcon(String tabletIcon) {
        this.tabletIcon = tabletIcon;
    }

    public void setPhoneIcon(String phoneIcon) {
        this.phoneIcon = phoneIcon;
    }

    public void setGlossIcon(boolean glossIcon) {
        this.glossIcon = glossIcon;
    }

    public void setStatusBarStyle(StatusBarStyle statusBarStyle) {
        this.statusBarStyle = statusBarStyle;
    }

}
