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
package com.ait.toolkit.sencha.touch.charts.client.series;

import com.ait.toolkit.sencha.touch.charts.client.marker.MarkerConfig;
import com.ait.toolkit.core.client.JsoHelper;

public class LineSeries extends CartesianSeries {

    public LineSeries() {
        jsObj = JsoHelper.createObject();
        this.setType("line");
    }

    public LineSeries(MarkerConfig markerConfig) {
        this();
        JsoHelper.setAttribute(jsObj, "markerConfig", markerConfig.getJsObj());

    }

    public native void showMarkers(boolean value) /*-{
		var series = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		series.showMarkers = value;
    }-*/;

    public native void setFill(boolean value) /*-{
		var series = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		series.fill = value;
    }-*/;

    public native void setSelectionTolerance(double value) /*-{
		var series = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		series.selectionTolerance = value;
    }-*/;

    public native void setSmooth(double value) /*-{
		var series = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		series.smooth = value;
    }-*/;

}
