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
 * Creates a candlestick or OHLC Chart.
 * 
 */
public class CandleStrickSeries extends CartesianSeries {

    public CandleStrickSeries() {
        jsObj = JsoHelper.createObject();
        setType("candlestick");
    }

    public native void setCloseField(String value)/*-{
		var series = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		series.closeField = value;
    }-*/;

    public native void setHighField(String value)/*-{
		var series = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		series.highField = value;
    }-*/;

    public native void lowField(String value)/*-{
		var series = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		series.lowField = value;
    }-*/;

    public native void setOpenField(double value)/*-{
		var series = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		series.openField = value;
    }-*/;

}
