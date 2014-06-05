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
package com.ait.toolkit.sencha.touch.client.core.handlers.map;

import com.ait.toolkit.sencha.shared.client.core.handlers.AbstractHandler;
import com.ait.toolkit.sencha.touch.client.ui.GoogleMap;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class MapZoomChangeHandler extends AbstractHandler {

	  final JavaScriptObject jsoPeer = createPeer(this);

	  private static native JavaScriptObject createPeer(MapZoomChangeHandler listener) /*-{
			return function(source, googlemap, mapZom) {
				var map = @com.ait.toolkit.sencha.touch.client.ui.GoogleMap::new(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
				listener.@com.ait.toolkit.sencha.touch.client.core.handlers.map.MapZoomChangeHandler::fireOnEvent(Lcom/ait/toolkit/sencha/touch/client/ui/GoogleMap;Lcom/google/gwt/core/client/JavaScriptObject;D)(map,googlemap,mapzoom);
			};
	  }-*/;

	  // Called from JSNI
	  private final void fireOnEvent(GoogleMap map, JavaScriptObject googleMap, double mapZoom) {
	    UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
	    if (handler != null) {
	      fireOnEventAndCatch(map,googleMap,mapZoom, handler);
	    } else {
	      onMapTypeChange(map, googleMap, mapZoom);
	    }
	  }

	  private void fireOnEventAndCatch(GoogleMap map, JavaScriptObject googleMap, double mapZoom, UncaughtExceptionHandler handler) {
	    try {
	      onMapTypeChange(map, googleMap, mapZoom);
	    } catch (Throwable e) {
	      handler.onUncaughtException(e);
	    }
	  }

	  @Override
	  public JavaScriptObject getJsoPeer() {
	    return jsoPeer;
	  }

	  public abstract void onMapTypeChange(GoogleMap map, JavaScriptObject googleMap, double mapZoom);
	}

