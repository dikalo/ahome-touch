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
 * RadialAxis Axis is the axis to be used with a Radar Series. The RadialAxis
 * axis is a circular display of numerical data by steps, with the number of
 * circles equivalent to the defined number of steps. Given the maximum data
 * value, the axis will compute step values depending on the number of defined
 * steps.
 * 
 */
public class RadialAxis extends AbstractAxis {

    public RadialAxis() {
        jsObj = JsoHelper.createObject();
        this.setType("radial");

    }

    /**
     * The number of steps to add to the radial axis.
     * 
     * @param value
     */
    public void setSteps(int value) {
        JsoHelper.setAttribute(jsObj, "steps", value);
    }

    /**
     * The angle in degrees at which the first pie slice should start.
     * 
     * @param value
     */
    public void setRotation(int value) {
        JsoHelper.setAttribute(jsObj, "rotation", value);
    }

    public void setMaximum(int value) {
        JsoHelper.setAttribute(jsObj, "maximum", value);
    }

}
