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

/**
 * Creates a Gauge AbstractChart. Gauge Charts are used to show progress in a
 * certain variable. There are two ways of using the Gauge chart. One is setting
 * a store element into the Gauge and selecting the field to be used from that
 * store. Another one is instantiating the visualization and using the setValue
 * method to adjust the value you want.
 * 
 */
public class Pie3DSeries extends PolarSeries {

    public Pie3DSeries() {
        jsObj = JsoHelper.createObject();
        setType("pie3d");

    }

    public native void setDonut(boolean value)/*-{
		var series = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		series.donut = value;
    }-*/;

    public native void setDonut(double value)/*-{
		var series = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		series.donut = value;
    }-*/;

    public native void setRotation(double value)/*-{
		var series = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		series.rotation = value;
    }-*/;

    public native void setDistortion(double value)/*-{
		var series = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		series.distortion = value;
    }-*/;

    public void setField(String value) {
        JsoHelper.setAttribute(jsObj, "field", value);
    }

}
