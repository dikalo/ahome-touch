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

/**
 * Configuration class to be used at instantiation time for a TextField. 
 */
public class TextConfig extends FieldConfig {

    public TextConfig() {
    }

    /**
     * True to set the field's DOM element autocapitalize attribute to "on",
     * false to set to "off".
     * 
     * @param value
     */
    public void setAutoCapitalize(boolean value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.AUTO_CAPITALIZATION.getValue(), value);
    }

    /**
     * True to set the field's DOM element autocomplete attribute to "on", false
     * to set to "off".
     * 
     * @param value
     */
    public void setAutoComplete(boolean value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.AUTO_COMPLETE.getValue(), value);
    }

    /**
     * True to set the field DOM element autocorrect attribute to "on", false to
     * set to "off".
     * 
     * @param value
     */
    public void setAutoCorrect(boolean value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.AUTO_CORRECT.getValue(), value);
    }

    /**
     * The maximum number of permitted input characters.
     * 
     * @param value
     */
    public void setMaxLength(double value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.MAX_LENGTH.getValue(), value);
    }

}
