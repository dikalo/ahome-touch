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

import com.ait.toolkit.sencha.shared.client.core.XType;
import com.ait.toolkit.sencha.touch.client.core.config.TextConfig;
import com.ait.toolkit.sencha.touch.client.events.text.ActionHandler;
import com.ait.toolkit.sencha.touch.client.events.text.BlurHandler;
import com.ait.toolkit.sencha.touch.client.events.text.ChangeHandler;
import com.ait.toolkit.sencha.touch.client.events.text.ClearIconTapHandler;
import com.ait.toolkit.sencha.touch.client.events.text.FocusHandler;
import com.ait.toolkit.sencha.touch.client.events.text.KeyUpHandler;
import com.ait.toolkit.sencha.touch.client.events.text.MouseDownHandler;
import com.ait.toolkit.sencha.touch.client.events.text.PasteHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.client.adapters.TakesValueEditor;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasValue;

/**
 * The text field is the basis for most of the input fields in Sencha Touch. It provides a baseline of shared functionality such as input validation, standard events, state
 * management and look and feel.
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

	public native HandlerRegistration addActionHandler(ActionHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(t, e) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.Text::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
			var event = @com.ait.toolkit.sencha.touch.client.events.text.ActionEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/Text;Lcom/google/gwt/core/client/JavaScriptObject;)(comp,e);
			handler.@com.ait.toolkit.sencha.touch.client.events.text.ActionHandler::onAction(Lcom/ait/toolkit/sencha/touch/client/events/text/ActionEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.text.ActionEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addBlurHandler(BlurHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(t, e) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.Text::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
			var event = @com.ait.toolkit.sencha.touch.client.events.text.BlurEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/Text;Lcom/google/gwt/core/client/JavaScriptObject;)(comp,e);
			handler.@com.ait.toolkit.sencha.touch.client.events.text.BlurHandler::onBlur(Lcom/ait/toolkit/sencha/touch/client/events/text/BlurEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.text.BlurEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration AddChangeHandler(ChangeHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(t, o, n) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.Text::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
			var event = @com.ait.toolkit.sencha.touch.client.events.text.ChangeEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/Text;Ljava/lang/Object;Ljava/lang/Object;)(comp,o,n);
			handler.@com.ait.toolkit.sencha.touch.client.events.text.ChangeHandler::onChange(Lcom/ait/toolkit/sencha/touch/client/events/text/ChangeEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.text.ChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addClearIconTapHandler(ClearIconTapHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(t, e) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.Text::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
			var event = @com.ait.toolkit.sencha.touch.client.events.text.ClearIconTapEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/Text;Lcom/google/gwt/core/client/JavaScriptObject;)(comp,e);
			handler.@com.ait.toolkit.sencha.touch.client.events.text.ClearIconTapHandler::onClearIconTap(Lcom/ait/toolkit/sencha/touch/client/events/text/ClearIconTapEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.text.ClearIconTapEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addFocusHandler(FocusHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(t, e) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.Text::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
			var event = @com.ait.toolkit.sencha.touch.client.events.text.FocusEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/Text;Lcom/google/gwt/core/client/JavaScriptObject;)(comp,e);
			handler.@com.ait.toolkit.sencha.touch.client.events.text.FocusHandler::onFocus(Lcom/ait/toolkit/sencha/touch/client/events/text/FocusEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.text.FocusEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addKeyUpHandler(KeyUpHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(t, e) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.Text::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
			var event = @com.ait.toolkit.sencha.touch.client.events.text.KeyUpEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/Text;Lcom/google/gwt/core/client/JavaScriptObject;)(comp,e);
			handler.@com.ait.toolkit.sencha.touch.client.events.text.KeyUpHandler::onKeyUp(Lcom/ait/toolkit/sencha/touch/client/events/text/KeyUpEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.text.KeyUpEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addMouseDownHandler(MouseDownHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(t, e) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.Text::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
			var event = @com.ait.toolkit.sencha.touch.client.events.text.MouseDownEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/Text;Lcom/google/gwt/core/client/JavaScriptObject;)(comp,e);
			handler.@com.ait.toolkit.sencha.touch.client.events.text.MouseDownHandler::onMouseDown(Lcom/ait/toolkit/sencha/touch/client/events/text/MouseDownEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.text.MouseDownEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addPasteHandler(PasteHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(t, e) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.Text::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
			var event = @com.ait.toolkit.sencha.touch.client.events.text.PasteEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/Text;Lcom/google/gwt/core/client/JavaScriptObject;)(comp,e);
			handler.@com.ait.toolkit.sencha.touch.client.events.text.PasteHandler::onPaste(Lcom/ait/toolkit/sencha/touch/client/events/text/PasteEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.text.PasteEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

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