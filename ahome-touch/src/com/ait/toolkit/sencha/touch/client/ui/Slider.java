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
import com.ait.toolkit.sencha.touch.client.core.config.SliderConfig;
import com.ait.toolkit.sencha.shared.client.core.XType;
import com.ait.toolkit.sencha.shared.client.core.handlers.CallbackRegistration;
import com.ait.toolkit.sencha.touch.client.core.handlers.field.slider.SliderChangeHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.client.adapters.TakesValueEditor;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasValue;

/**
 * The slider is a way to allow the user to select a value from a given
 * numerical range. You might use it for choosing a percentage, combine two of
 * them to get min and max values, or use three of them to specify the hex
 * values for a color. Each slider contains a single 'thumb' that can be dragged
 * along the slider's length to change the value. Sliders are equally useful
 * inside forms and standalone.
 */
public class Slider extends Field implements HasValue<Integer>, IsEditor<LeafValueEditor<Integer>> {

    private LeafValueEditor<Integer> editor;

    @Override
    protected native void init()/*-{
		var c = new $wnd.Ext.field.Slider();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
    }-*/;

    @Override
    public String getXType() {
        return XType.SLIDER_FIELD.getValue();
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.field.Slider(config);
    }-*/;

    public Slider(SliderConfig sliderConfig) {
        super(sliderConfig.getJsObj());
    }

    public Slider() {
    }

    protected Slider(JavaScriptObject jso) {
        super(jso);
    }

    /**
     * Returns the value of increment.
     * 
     * @return
     */
    public native int getIncrement() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.getIncrement();
		}
    }-*/;

    /**
     * Returns the value of maxValue.
     * 
     * @return
     */
    public native int getMaxValue() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.getMaxValue();
		}
    }-*/;

    /**
     * Returns the value of minValue.
     * 
     * @return
     */
    public native int getMinValue() /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.getMinValue();
		}
    }-*/;

    /**
     * Returns the value of value.
     * 
     * @param <T>
     *            Number/String/Number[]/String[]
     * @return
     */
    public native int getSliderValue() /*-{

		var value = 0;
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();

		if (field != null) {

			value = field.getValue()
			var type = typeof value;

			switch (type) {
			case 'number': {
				return value;
			}
			}

			value = field.getValue()[0];
			if (value == undefined) {
				value = 0;
			}

			return value;

		}

    }-*/;

    /**
     * Sets the value of increment.
     * 
     * @param value
     */
    public native void setIncrement(int value) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setIncrement(value);
		}
    }-*/;

    /**
     * Sets the value of maxValue.
     * 
     * @param value
     */
    public native void setMaxValue(int value) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setMaxValue(value);
		}
    }-*/;

    /**
     * Sets the value of minValue.
     * 
     * @param value
     */
    public native void setMinValue(int value) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setMinValue(value);
		}
    }-*/;

    /**
     * Sets the value of value.
     * 
     * @param value
     */
    public native void setSliderValue(int value) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setValue(value);
		}
    }-*/;

    /**
     * Sets the value of value.
     * 
     * @param value
     */
    public void setSliderValues(String[] value) {
        JsArrayString values = JavaScriptObject.createArray().cast();
        for (int i = 0; i < value.length; i++) {
            values.set(i, value[i]);
        }
        setSliderValues(values);
    }

    /**
     * Sets the value of value.
     * 
     * @param value
     */
    public void setSliderValues(int[] value) {
        JsArrayInteger values = JavaScriptObject.createArray().cast();
        for (int i = 0; i < value.length; i++) {
            values.set(i, value[i]);
        }
        setSliderValues(values);
    }

    /**
     * Fires when an option selection has changed.
     * 
     * @param handler
     */
    public CallbackRegistration addChangeHandler(SliderChangeHandler handler) {
        return this.addWidgetListener(Event.CHANGE.getValue(), handler.getJsoPeer());
    }

    private native void setSliderValues(JsArrayInteger values) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setValue(values);
		}
    }-*/;

    private native void setSliderValues(JsArrayString values) /*-{
		var field = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setValue(values);
		}
    }-*/;

    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Integer> handler) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public LeafValueEditor<Integer> asEditor() {
        if (editor == null) {
            editor = TakesValueEditor.of(this);
        }
        return editor;
    }

    @Override
    public Integer getValue() {
        return getSliderValue();
    }

    @Override
    public void setValue(Integer value) {
        setSliderValue(value);
    }

    @Override
    public void setValue(Integer value, boolean fireEvents) {
        setSliderValue(value);
    }

}