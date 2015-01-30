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
package com.ait.toolkit.sencha.touch.charts.client.axis;

import com.ait.toolkit.core.client.JsoHelper;

/**
 * An axis to handle numeric values. This axis is used for quantitative data as
 * opposed to the category axis. You can set mininum and maximum values to the
 * axis so that the values are bound to that. If no values are set, then the
 * scale will auto-adjust to the values.
 * 
 */
public class NumericAxis extends AbstractAxis {

    public NumericAxis() {
        jsObj = JsoHelper.createObject();
        this.setType("numeric");

    }

    /**
     * Indicates whether to extend maximum beyond data's maximum to the nearest
     * majorUnit.
     * 
     * @param value
     */
    public void setAdjustMaximumByMajorUnit(boolean value) {
        JsoHelper.setAttribute(jsObj, "adjustMaximumByMajorUnit", value);
    }

    /**
     * Indicates whether to extend minimum beyond data's maximum to the nearest
     * majorUnit.
     * 
     * @param value
     */
    public void setAdjustMinimumByMajorUnit(boolean value) {
        JsoHelper.setAttribute(jsObj, "adjustMinimumByMajorUnit", value);
    }

    /**
     * Indicates whether to extend minimum beyond data's maximum to the nearest
     * majorUnit.
     * 
     * @param value
     */
    public void setDecimals(int value) {
        JsoHelper.setAttribute(jsObj, "decimals", value);
    }

    /**
     * Whether to round the result to the given decimals. Defualt's false. If
     * true then the decimals config will determine the number of decimals to
     * round the number.
     * 
     * @param value
     */
    public void setRoundToDecimal(boolean value) {
        JsoHelper.setAttribute(jsObj, "roundToDecimal", value);
    }

    /**
     * The scaling algorithm to use on this axis. May be "linear" or
     * "logarithmic".
     * 
     * @param value
     */
    public void setScale(boolean value) {
        JsoHelper.setAttribute(jsObj, "scale", value);
    }

}
