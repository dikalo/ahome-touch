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
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * Configuration class to be used by {@link Slider}
 */
public class SliderConfig extends FieldConfig {

    public SliderConfig() {
    }

    /**
     * The increment by which to snap each thumb when its value changes.
     * Defaults to 1. Any thumb movement will be snapped to the nearest value
     * that is a multiple of the increment (e.g. if increment is 10 and the user
     * tries to move the thumb to 67, it will be snapped to 70 instead)
     * 
     * Defaults to: 1
     * 
     * @param value
     */
    public void setIncrement(double value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.INCREMENT.getValue(), value);
    }

    /**
     * The highest value any thumb on this slider can be set to.
     * 
     * Defaults to: 100
     * 
     * @param value
     */
    public void setMaxValue(double value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.MAX_VALUE.getValue(), value);
    }

    /**
     * The lowest value any thumb on this slider can be set to.
     * 
     * Defaults to: 0
     * 
     * @param value
     */
    public void setMinValue(double value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.MIN_VALUE.getValue(), value);
    }

    /**
     * An array of Ext.slider.Thumb's to be used in this slider.
     * 
     * Defaults to: []
     * 
     * @param value
     */
    public void setThumbs(JsArray<JavaScriptObject> value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.THUMBS.getValue(), value);
    }

    /**
     * The value(s) of the sliders thumbs. If you pass a number or a string, it
     * will assume you have just 1 thumb.
     * 
     * Defaults to: 0
     * 
     * @param value
     */
    public void setValue(String value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.VALUE.getValue(), value);
    }

    /**
     * The value(s) of the sliders thumbs. If you pass a number or a string, it
     * will assume you have just 1 thumb.
     * 
     * Defaults to: 0
     * 
     * @param value
     */
    public void setValue(String[] value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.VALUE.getValue(), value);
    }

    /**
     * The value(s) of the sliders thumbs. If you pass a number or a string, it
     * will assume you have just 1 thumb.
     * 
     * Defaults to: 0
     * 
     * @param value
     */
    public void setValue(double value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.VALUE.getValue(), value);
    }

    /**
     * The value(s) of the sliders thumbs. If you pass a number or a string, it
     * will assume you have just 1 thumb.
     * 
     * Defaults to: 0
     * 
     * @param value
     */
    public void setValue(double[] value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.VALUE.getValue(), value);
    }

}
