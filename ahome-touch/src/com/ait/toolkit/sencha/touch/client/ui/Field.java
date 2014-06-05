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
package com.ait.toolkit.sencha.touch.client.ui;

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.ait.toolkit.sencha.touch.client.core.config.FieldConfig;
import com.ait.toolkit.sencha.shared.client.core.XType;
import com.ait.toolkit.sencha.touch.client.laf.Alignment;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Field is the base class for all form fields used in Sencha Touch. It provides
 * a lot of shared functionality to all field subclasses (for example labels,
 * simple validation, clearing and tab index management), but is rarely used
 * directly. Instead, it is much more common to use one of the field subclasses:
 * 
 * xtype Class --------------------------------------- textfield Ext.field.Text
 * numberfield Ext.field.Number textareafield Ext.field.TextArea hiddenfield
 * Ext.field.Hidden radiofield Ext.field.Radio checkboxfield Ext.field.Checkbox
 * selectfield Ext.field.Select togglefield Ext.field.Toggle fieldset
 * Ext.field.FieldSet Fields are normally used within the context of a form
 * and/or fieldset. See the FormPanel and FieldSet docs for examples on how to
 * put those together, or the list of links above for usage of individual field
 * types. If you wish to create your own Field subclasses you can extend this
 * class, though it is sometimes more useful to extend Ext.field.Text as this
 * provides additional text entry functionality.
 * 
 */
public class Field extends Component {

    @Override
    protected native void init() /*-{
		var c = new $wnd.Ext.field.Field();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
    }-*/;

    @Override
    public String getXType() {
        return XType.FIELD.getValue();
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.field.Field(config);
    }-*/;

    public Field() {
    }

    public Field(FieldConfig fieldConfig) {
        super(fieldConfig.getJsObj());
    }

    protected Field(JavaScriptObject config) {
        super(config);
    }

    /**
     * Returns the value of clearIcon.
     * 
     * @return
     */
    public native boolean getClearIcon() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.getClearIcon();
		}
    }-*/;

    /**
     * Returns the value of label.
     * 
     * @return
     */
    public native String getLabel() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.getLabel();
		}
    }-*/;

    /**
     * Returns the value of labelAlign.
     * 
     * @return
     */
    public native String getLabelAlign() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.getLabelAlign();
		}
    }-*/;

    /**
     * Returns the value of labelCls.
     * 
     * @return
     */
    public native String getLabelCls() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.getLabelCls();
		}
    }-*/;

    /**
     * Returns the value of labelWidth.
     * 
     * @return
     */
    public native int getLabelWidth() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.getLabelWidth();
		}
    }-*/;

    /**
     * Returns the value of name.
     * 
     * @return
     */
    public native String getName() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.getName();
		}
    }-*/;

    /**
     * Returns the value of required.
     * 
     * @return
     */
    public native boolean getRequired() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.getRequired();
		}
    }-*/;

    /**
     * Returns the value of requiredCls.
     * 
     * @return
     */
    public native boolean getRequiredCls() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.getRequiredCls();
		}
    }-*/;

    /**
     * Returns the value of tabIndex.
     * 
     * @return
     */
    public native int getTabIndex() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.getTabIndex();
		}
    }-*/;

    /**
     * Returns the field data value
     * 
     * @return
     */
    // TODO
    // public native <T> T getValue() /*-{
    // var field =
    // this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
    // if (field != null) {
    // return field.getValue();
    // }
    // }-*/;

    /**
     * Returns true if the value of this Field has been changed from its
     * originalValue. Will return false if the field is disabled or has not been
     * rendered yet.
     * 
     * @return True if this field has been changed from its original value (and
     *         is not disabled), false otherwise.
     */
    public native boolean isDirty() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.isDirty();
		}
    }-*/;

    /**
     * True if this field has been changed from its original value (and is not
     * disabled), false otherwise.
     * 
     * @return
     */
    public native boolean reset() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.reset();
		}
    }-*/;

    /**
     * Sets the value of clearIcon.
     * 
     * @param value
     */
    public native void setClearIcon(boolean value) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setClearIcon(value);
		}
    }-*/;

    /**
     * Sets the value of label.
     * 
     * @param value
     */
    public native void setLabel(String value) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setLabel(value);
		}
    }-*/;

    /**
     * Sets the value of labelAlign.
     * 
     * @param value
     */
    private native void setLabelAlign(String value) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setLabelAlign(value);
		}
    }-*/;

    public void setLabelAlign(Alignment alignment) {
        setLabelAlign(alignment.getValue());
    }

    /**
     * Sets the value of labelCls.
     * 
     * @param value
     */
    public native void setLabelCls(String value) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setLabelCls(value);
		}
    }-*/;

    /**
     * Sets the value of labelWidth.
     * 
     * @param value
     */
    public native void setLabelWidth(int value) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setLabelWidth(value);
		}
    }-*/;

    public native void setLabelWidth(String value) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setLabelWidth(value);
		}
    }-*/;

    /**
     * Sets the value of name.
     * 
     * @param value
     */
    public native void setName(String value) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setName(value);
		}
    }-*/;

    /**
     * Sets the value of required.
     * 
     * @param value
     */
    public native void setRequired(boolean value) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setRequired(value);
		}
    }-*/;

    /**
     * Sets the value of requiredCls.
     * 
     * @param value
     */
    public native void setRequiredCls(String value) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setRequiredCls(value);
		}
    }-*/;

    /**
     * Sets the value of tabIndex.
     * 
     * @param value
     */
    public native void setTabIndex(int value) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setTabIndex(value);
		}
    }-*/;

    public native void setPlaceHolder(String value) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setPlaceHolder(value);
		}
    }-*/;

    @Override
    public String getText() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setText(String text) {
        // TODO Auto-generated method stub

    }

}
