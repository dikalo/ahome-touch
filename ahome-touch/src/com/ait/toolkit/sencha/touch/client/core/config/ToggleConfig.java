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
public class ToggleConfig extends SliderConfig {

    public ToggleConfig() {
    }

    /**
     * CSS class added to the field when toggled to its maxValue
     * 
     * Defaults to: "x-toggle-on"
     * 
     * @param value
     */
    public void setMaxValueCls(String value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.MAX_VALUE_CLS.getValue(), value);
    }

    /**
     * CSS class added to the field when toggled to its minValue
     * 
     * Defaults to: "x-toggle-off"
     * 
     * @param value
     */
    public void setMinValueCls(String value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.MIN_VALUE_CLS.getValue(), value);
    }

}
