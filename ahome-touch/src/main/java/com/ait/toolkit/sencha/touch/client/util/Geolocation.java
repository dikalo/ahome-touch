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

import com.ait.toolkit.sencha.shared.client.core.Observable;
import com.ait.toolkit.sencha.shared.client.core.handlers.AbstractHandler;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Provides a cross browser class for retrieving location information.
 * 
 * Based on the Geolocation API Specification
 * 
 * When instantiated, by default this class immediately begins tracking location
 * information, firing a locationupdate event when new location information is
 * available. To disable this location tracking (which may be battery intensive
 * on mobile devices), set autoUpdate to false.
 * 
 * When this is done, only calls to updateLocation will trigger a location
 * retrieval.
 * 
 * A locationerror event is raised when an error occurs retrieving the location,
 * either due to a user denying the application access to it, or the browser not
 * supporting it.
 * 
 * The below code shows a GeoLocation making a single retrieval of location
 * information.
 * 
 * 
 * According to the Sencha Documentation this feature does not work at this
 * point.
 */
public class Geolocation implements Observable {

	private JavaScriptObject jso;

	public Geolocation() {
		create();
	}

	@Override
	public void addEvents(String... events) {

	}

	public void addListener(String event, AbstractHandler handler) {

	}

	private native void create()/*-{
		this.@com.ait.toolkit.sencha.touch.client.util.Geolocation::jso = new $wnd.Ext.util.Geolocation();
	}-*/;

}
