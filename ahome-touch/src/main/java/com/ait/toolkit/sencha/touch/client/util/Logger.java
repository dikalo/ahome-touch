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
 * Logs messages to help with debugging.
 */
public class Logger {

    private Logger() {

    }

    /**
     * Convenience method for log with priority 'deprecate'.
     */
    public static native void deprecate(String message)/*-{
		$wnd.Ext.Logger.deprecate(message);
    }-*/;

    /**
     * Convenience method for log with priority 'error'.
     */
    public static native void error(String message)/*-{
		$wnd.Ext.Logger.error(message);
    }-*/;

    /**
     * Convenience method for log with priority 'error'.
     */
    public static native void info(String message)/*-{
		$wnd.Ext.Logger.info(message);
    }-*/;

    /**
     * Logs a message to help with debugging.
     */
    public static native void log(String message, int priority)/*-{
		$wnd.Ext.Logger.log(message, priority);
    }-*/;

    /**
     * Convenience method for log with priority 'verbose'.
     */
    public static native void verbose(String message)/*-{
		$wnd.Ext.Logger.verbose(message);
    }-*/;

    /**
     * Convenience method for log with priority 'warn'.
     */
    public static native void warn(String message)/*-{
		$wnd.Ext.Logger.warn(message);
    }-*/;
}
