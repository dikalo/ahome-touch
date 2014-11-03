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
import com.ait.toolkit.sencha.touch.client.ui.Field;
import com.ait.toolkit.sencha.touch.client.ui.InputField;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Class that can be used with {@link Field} to setup
 * at instantiation time property values.
 * 
 */
public class FieldConfig extends ContainerConfig {

    public FieldConfig() {
    }

    /**
     * True to use a clear icon in this field
     * 
     * @param value
     */
    public void clearIcon(boolean value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.CLEAR_ICON.getValue(), value);
    }

    /**
     * An instance of the inner input for this field, if one has been defined.
     * 
     * @param value
     */
    public void setInput(boolean value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.INPUT.getValue(), value);
    }

    /**
     * An instance of the inner input for this field, if one has been defined.
     * 
     * @param value
     */
    protected void setInput(JavaScriptObject value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.INPUT.getValue(), value);
    }

    /**
     * An instance of the inner input for this field, if one has been defined.
     * 
     * @param value
     */
    public void setInput(InputField value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.INPUT.getValue(), value);
    }

    /**
     * The label to associate with this field.
     * 
     * @param value
     */
    public void setLabel(String value) {
        JsoHelper.setAttribute(jsObj, "label", value);
    }

    /**
     * The position to render the label relative to the field input. Defaults to
     * 'left'. See Ext.form.Label for more information
     * 
     * @param value
     */
    public void setLabelAlign(String value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.LABEL_ALIGN.getValue(), value);
    }

    /**
     * Optional CSS class to add to the Label element.
     * 
     * @param value
     */
    public void setLabelCls(String value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.LABEL_CLS.getValue(), value);
    }

    /**
     * The width to make this field's label (defaults to 30%). See
     * Ext.form.Label for more information.
     * 
     * @param value
     */
    public void setLabelWidth(double value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.LABEL_WIDTH.getValue(), value);
    }

    /**
     * The field's HTML name attribute. Note: this property must be set if this
     * field is to be automatically included with form submit().
     * 
     * @param value
     */
    public void setName(String value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.NAME.getValue(), value);
    }

    /**
     * True to make this field required. Note: this only causes a visual
     * indication. Doesn't prevent user from submitting the form.
     * 
     * @param value
     */
    public void setRequired(boolean value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.REQUIRED.getValue(), value);
    }

    /**
     * The className to be applied to this Field when the required configuration
     * is set to true Defaults to: "x-field-required"
     * 
     * @param value
     */
    public void setRequiredCls(String value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.REQUIRED_CLS.getValue(), value);
    }

    /**
     * The tabIndex for this field. Note this only applies to fields that are
     * rendered, not those which are built via applyTo.
     * 
     * @param value
     */
    public void setTabIndex(double value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.TAB_INDEX.getValue(), value);
    }

    /**
     * True to use a clear icon in this field.
     * 
     * @param value
     */
    public void setUseClearIcon(boolean value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.CLEAR_ICON.getValue(), value);
    }

    /**
     * A value to initialize this field with.
     * 
     * @param value
     */
    protected void setValue(JavaScriptObject value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.VALUE.getValue(), value);
    }

}
