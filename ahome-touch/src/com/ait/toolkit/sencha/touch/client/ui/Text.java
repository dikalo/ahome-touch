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

import com.ait.toolkit.sencha.touch.client.core.config.Event;
import com.ait.toolkit.sencha.touch.client.core.config.TextConfig;
import com.ait.toolkit.sencha.shared.client.core.XType;
import com.ait.toolkit.sencha.touch.client.core.handlers.field.text.TextActionHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.field.text.TextBlurHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.field.text.TextChangeHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.field.text.TextClearIconTapHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.field.text.TextFocusHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.field.text.TextKeyUpHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.client.adapters.TakesValueEditor;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasValue;

/**
 * The text field is the basis for most of the input fields in Sencha Touch. It
 * provides a baseline of shared functionality such as input validation,
 * standard events, state management and look and feel.
 * 
 */
public class Text<T> extends Field implements HasValue<T>, IsEditor<LeafValueEditor<T>> {

    private LeafValueEditor<T> editor;

    @Override
    protected native void init()/*-{
		var c = new $wnd.Ext.field.Text();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
    }-*/;

    @Override
    public String getXType() {
        return XType.TEXT_FIELD.getValue();
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.field.Text(config);
    }-*/;

    public Text() {
    }

    public Text(TextConfig textConfig) {
        super(textConfig.getJsObj());
    }

    protected Text(JavaScriptObject jso) {
        super(jso);
    }

    /**
     * Attempts to forcefully blur input focus for the field.
     */
    public native void blur() /*-{
		var text = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (text != null) {
			text.blur();
		}
    }-*/;

    /**
     * Attempts to set the field as the active input focus.
     */
    public native void focus() /*-{
		var text = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (text != null) {
			text.focus();
		}
    }-*/;

    /**
     * Returns the value of autoCapitalize.
     * 
     * @return
     */
    public native boolean getAutoCapitalize() /*-{
		var text = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (text != null) {
			return text.getAutoCapitalize();
		}
    }-*/;

    /**
     * Returns the value of autoComplete.
     * 
     * @return
     */
    public native boolean getAutoComplete() /*-{
		var text = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (text != null) {
			return text.getAutoComplete();
		}
    }-*/;

    /**
     * Returns the value of autoCorrect.
     * 
     * @return
     */
    public native boolean getAutoCorrect() /*-{
		var text = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (text != null) {
			return text.getAutoCorrect();
		}
    }-*/;

    /**
     * Returns the value of maxLength.
     * 
     * @return
     */
    public native double getMaxLength() /*-{
		var text = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (text != null) {
			return text.getMaxLength();
		}
    }-*/;

    /**
     * Returns the value of placeHolder
     * 
     * @return
     */
    public native String getPlaceHolder() /*-{
		var text = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (text != null) {
			return text.getPlaceHolder();
		}
    }-*/;

    /**
     * Returns the value of readOnly
     * 
     * @return
     */
    public native boolean getReadOnly() /*-{
		var text = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (text != null) {
			return text.getReadOnly();
		}
    }-*/;

    /**
     * Attempts to forcefully select all the contents of the input field.
     */
    public native void select() /*-{
		var text = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (text != null) {
			text.select();
		}
    }-*/;

    /**
     * Sets the value of autoCapitalize.
     * 
     * @param value
     */
    public native void setAutoCapitalize(boolean value) /*-{
		var text = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (text != null) {
			text.setAutoCapitalize(value);
		}
    }-*/;

    /**
     * Sets the value of autoComplete.
     * 
     * @param value
     */
    public native void setAutoComplete(boolean value) /*-{
		var text = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (text != null) {
			text.setAutoComplete(value);
		}
    }-*/;

    /**
     * Sets the value of autoCorrect.
     * 
     * @param value
     */
    public native void setAutoCorrect(boolean value) /*-{
		var text = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (text != null) {
			text.setAutoCorrect(value);
		}
    }-*/;

    /**
     * Sets the value of maxLength.
     * 
     * @param value
     */
    public native void setMaxLength(double value) /*-{
		var text = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (text != null) {
			text.setMaxLength(value);
		}
    }-*/;

    /**
     * Sets the value of readOnly
     */
    public native void setReadOnly(boolean value) /*-{
		var text = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (text != null) {
			text.setReadOnly(value);
		}
    }-*/;

    /**
     * Fires whenever the return key or go is pressed. FormPanel listeners for
     * this event, and submits itself whenever it fires. Also note that this
     * event bubbles up to parent containers.
     * 
     * @param handler
     */
    public void addOnActionHandler(TextActionHandler handler) {
        this.addWidgetListener(Event.ACTION.getValue(), handler.getJsoPeer());
    }

    /**
     * Fires when this field loses input focus.
     * 
     * @param handler
     */
    public void addOnBlurHandler(TextBlurHandler handler) {
        this.addWidgetListener(Event.BLUR.getValue(), handler.getJsoPeer());
    }

    /**
     * Fires just before the field blurs if the field value has changed.
     * 
     * @param handler
     */
    public void addOnChangeHandler(TextChangeHandler handler) {
        this.addWidgetListener(Event.CHANGE.getValue(), handler.getJsoPeer());
    }

    /**
     * Fires when this field receives input focus.
     * 
     * @param handler
     */
    public void addOnFocusHandler(TextFocusHandler handler) {
        this.addWidgetListener(Event.FOCUS.getValue(), handler.getJsoPeer());
    }

    /**
     * Fires when a key is released on the input element.
     * 
     * @param handler
     */
    public void addOnKeyUpHandler(TextKeyUpHandler handler) {
        this.addWidgetListener(Event.KEY_UP.getValue(), handler.getJsoPeer());
    }

    /**
     * Fires when the clear icon is tapped
     * 
     * @param handler
     */
    public void addOnClearIconTapHandler(TextClearIconTapHandler handler) {
        this.addWidgetListener(Event.CLEAR_ICON_TAP.getValue(), handler.getJsoPeer());
    }

    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<T> handler) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public LeafValueEditor<T> asEditor() {
        if (editor == null) {
            editor = TakesValueEditor.of(this);
        }
        return editor;
    }

    @Override
    public T getValue() {
        return _getValue();
    }

    @Override
    public void setValue(T value) {
        _setValue(value);
    }

    @Override
    public void setValue(T value, boolean fireEvents) {
        _setValue(value);
    }

    private native void _setValue(T value) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setValue(value);
		}
    }-*/;

    private native T _getValue() /*-{

		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();

		if (field != null) {

			var value = field.getValue();
			var type = typeof value;

			switch (type) {
			case 'number': {
				return @com.ait.toolkit.sencha.touch.client.ui.Text::getDouble(D)(value);
			}
			}

			return value;
		}

    }-*/;

    private static native Double getDouble(double value) /*-{
		return value ? @java.lang.Double::valueOf(D)(value) : null;
    }-*/;

}