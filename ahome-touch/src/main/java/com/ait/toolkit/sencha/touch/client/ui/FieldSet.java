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

import com.ait.toolkit.sencha.touch.client.core.HasTitle;
import com.ait.toolkit.sencha.touch.client.core.config.FieldSetConfig;
import com.ait.toolkit.sencha.shared.client.core.XType;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A FieldSet is a great way to visually separate elements of a form. It's
 * normally used when you have a form with fields that can be divided into
 * groups - for example a customer's billing details in one fieldset and their
 * shipping address in another. A fieldset can be used inside a form or on its
 * own elsewhere in your app. Fieldsets can optionally have a title at the top
 * and instructions at the bottom.
 */
public class FieldSet extends Container implements HasTitle {

	public FieldSet() {
	}

	public FieldSet(String title) {
		setTitle(title);
	}

	public FieldSet(FieldSetConfig selectConfig) {
		super(selectConfig.getJsObj());
	}

	protected FieldSet(JavaScriptObject jso) {
		super(jso);
	}

	@Override
	protected native void init()/*-{
		var c = new $wnd.Ext.form.FieldSet();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
	}-*/;

	@Override
	public String getXType() {
		return XType.FIELDSET.getValue();
	}

	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.form.FieldSet(config);
	}-*/;

	/**
	 * Returns the value of instructions.
	 * 
	 * @return StringUtil
	 */
	public native String getInstructions() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.getInstructions();
		}
	}-*/;

	/**
	 * Sets the instructions
	 * 
	 * @param instructions
	 */
	public native void setInstructions(String instructions) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setInstructions(instructions);
		}
	}-*/;
	
	/**
	 * Sets the value of defaultType.
	 * 
	 * @param xtype
	 */
    public void setDefaultType(XType xtype) {
        setDefaultType(xtype.getValue());
    }
    
    /**
     * Sets the value of defaults.
     * 
     * @param jso
     */
    public void setDefaults(JavaScriptObject jso) {
        _setDefaults(jso);
    }

	/**
	 * Returns the value of title.
	 * 
	 * @return StringUtil
	 */
	public native String getTitle() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.getTitle();
		}
	}-*/;

	/**
	 * Sets the title
	 * 
	 * @param title
	 */
	public native void setTitle(String title) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setTitle(title);
		}
	}-*/;
	
    private native void setDefaultType(String xtype) /*-{
        var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
        if (field != null) {
            field.setDefaultType(xtype);
        }
    }-*/;
    
    private native void _setDefaults(JavaScriptObject jso) /*-{
        var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
        if (field != null) {
            field.setDefaults(jso);
        }
    }-*/;

}
