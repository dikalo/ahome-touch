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
package com.ait.toolkit.sencha.touch.client.core.config;

import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.touch.client.ui.Slider;

/**
 * Configuration class to be used by {@link Slider}
 */
public class SpinnerConfig extends FieldConfig {

    public SpinnerConfig() {
    }

    /**
     * True if autorepeating should start slowly and accelerate.
     * 
     * Defaults to: true
     * 
     * @param value
     */
    public void setAccelerateOnTapHold(boolean value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.ACCELERATE_ON_TAP_HOLD.getValue(), value);
    }

    /**
     * When set to true, it will loop the values of a minimum or maximum is
     * reached. If the maximum value is reached, the value will be set to the
     * minimum.
     * 
     * Defaults to: false
     * 
     * @param value
     */
    public void setCycle(boolean value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.CYCLE.getValue(), value);
    }

    /**
     * Value that is added or subtracted from the current value when a spinner
     * is used.
     * 
     * @param value
     */
    public void setIncrement(double value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.INCREMENT.getValue(), value);
    }

    /**
     * The maximum allowed value.
     * 
     * Defaults to: infinity
     * 
     * @param value
     */
    public void setMaxValue(double value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.MAX_VALUE.getValue(), value);
    }

    /**
     * The minimum allowed value.
     * 
     * Defaults to: -infinity
     * 
     * @param value
     */
    public void setMinValue(double value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.MIN_VALUE.getValue(), value);
    }

}
