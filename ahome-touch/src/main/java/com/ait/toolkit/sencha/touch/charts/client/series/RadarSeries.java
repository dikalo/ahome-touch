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

import com.ait.toolkit.core.client.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

public class RadarSeries extends BaseSeries {

    public RadarSeries() {
        jsObj = JsoHelper.createObject();
        setType("radar");
    }

    public native void setMarkerConfig(JavaScriptObject value)/*-{
		var series = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		series.markerConfig = value;
    }-*/;

    public native void showMarkers(boolean value)/*-{
		var series = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		series.showMarkers = value;
    }-*/;

    public native void setDonut(double value)/*-{
		var series = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		series.donut = value;
    }-*/;

    public native void setNeedle(boolean value)/*-{
		var series = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		series.needle = value;
    }-*/;

    public native void setStyle(Object value)/*-{
		var series = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		series.style = value;
    }-*/;

    public native <T> T getLegendColor()/*-{
		var series = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return series.getLegendColor();
    }-*/;

    public native void setValue(Object value)/*-{
		var series = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		series.setValue(value);
    }-*/;

    public native void setXField(String value)/*-{
		var series = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		series.xField = value;
    }-*/;

    public native void setYField(String value)/*-{
		var series = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		series.yField = value;
    }-*/;

}
