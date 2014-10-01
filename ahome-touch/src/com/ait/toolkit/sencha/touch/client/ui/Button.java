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

import com.ait.toolkit.core.client.Function;
import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.shared.client.core.XType;
import com.ait.toolkit.sencha.touch.client.core.Component;
import com.ait.toolkit.sencha.touch.client.core.Icons;
import com.ait.toolkit.sencha.touch.client.core.config.TouchAttribute;
import com.ait.toolkit.sencha.touch.client.events.HandlerRegistration;
import com.ait.toolkit.sencha.touch.client.events.button.TapHandler;
import com.ait.toolkit.sencha.touch.client.laf.UI;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

/**
 * A simple class to display different styles of buttons.
 * 
 * <h2>Usefull methods</h2>
 * <ul>
 * <li>setUi(UI ui). Defines the styles of the buttons</li>
 * <li>addTapHanlder(TapHandler handler). Defines the method to be called when the button is tapped</li>
 * </ul>
 */
public class Button extends Component {

	private static int buttonId = 1000;

	@Override
	protected native void init()/*-{
		var c = new $wnd.Ext.Button();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
	}-*/;

	protected Button(JavaScriptObject jsObj) {
		super(jsObj);
	}

	protected static Button instance(JavaScriptObject jsObj) {
		return new Button(jsObj);
	}

	@Override
	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.Button(config);
	}-*/;

	/**
	 * Create a new Button.
	 */
	public Button() {
		generateButtonId();
	}

	/**
	 * Create a new Button
	 * 
	 * @param text
	 *            , the button label
	 */
	public Button(String text) {
		this();
		if (text != null) {
			setText(text);
		}
	}

	public Button(String text, TapHandler handler) {
		this(text);
		addTapHandler(handler);
	}

	/**
	 * Create a new Button with the given text and the given ui.
	 * 
	 * @param text
	 *            , the button label
	 * @param ui
	 *            , the ui of the button
	 * 
	 * 
	 */
	public Button(String text, UI ui) {
		this(text);
		setUi(ui);
	}

	/**
	 * Create a new button with a given text and ui. Also add the given tapHandler to the button.
	 * 
	 * @param text
	 *            , the button label
	 * @param ui
	 *            , the ui of the button
	 * @param handler
	 */
	public Button(String text, UI ui, TapHandler handler) {
		this(text, ui);
		addTapHandler(handler);
	}

	/**
	 * Used to align buttons.
	 */
	public enum IconAlign {

		BOTTOM(TouchAttribute.BOTTOM.getValue()), CENTER(TouchAttribute.CENTER.getValue()), LEFT(TouchAttribute.LEFT.getValue()), RIGHT(TouchAttribute.RIGHT.getValue()), TOP(
				TouchAttribute.TOP.getValue());

		private String value;

		private IconAlign(String alignment) {
			value = alignment;
		}

		public String getValue() {
			return this.value;
		}

	}

	/**
	 * returns the value of autoEvent.
	 * 
	 * @return
	 */
	public native String getAutoEvent() /*-{
		var button = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return button.getAutoEvent();
	}-*/;

	/**
	 * Returns the value of badgeCls.
	 * 
	 * @return
	 */
	public native String getBadgeCls() /*-{
		var button = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return button.getBadgeCls();
	}-*/;

	/**
	 * Returns the value of badgeText.
	 */
	public native String getBadgeText() /*-{
		var button = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return button.getBadgeText();
	}-*/;

	/**
	 * Returns the value of icon.
	 */
	public native String getIcon() /*-{
		var button = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return button.getIcon();
	}-*/;

	/**
	 * Returns the value of iconAlign.
	 */
	public native String getIconAlign() /*-{
		var button = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return button.getIconAlign();
	}-*/;

	/**
	 * Returns the value of iconCls.
	 */
	public native String getIconCls() /*-{
		var button = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return button.getIconCls();
	}-*/;

	/**
	 * Returns the value of iconMask.
	 * 
	 * @return
	 */
	public native boolean getIconMask() /*-{
		var button = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return button.getIconMask();
	}-*/;

	/**
	 * Returns the value of iconMask.
	 */
	public native String getIconMaskCls() /*-{
		var button = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return button.getIconMaskCls();
	}-*/;

	/**
	 * Returns the value of labelCls.
	 * 
	 * @return
	 */
	public native String getLabelCls() /*-{
		var button = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return button.getLabelCls();
	}-*/;

	/**
	 * Returns the value of pressedCls
	 * 
	 * @return
	 */
	public native String getPressedCls() /*-{
		var button = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return button.getPressedCls();
	}-*/;

	/**
	 * Returns the value of text.
	 */
	public String getText() {
		if (isRendered()) {
			return getRenderedText();
		} else {
			return getAttribute(TouchAttribute.TEXT.getValue());
		}
	}

	/**
	 * @return the value of ui.
	 */
	@Override
	public UI getUi() {
		return UI.fromValue(_getUi());
	}

	/**
	 * Sets the value of autoEvent
	 * 
	 * @param value
	 */
	public native void setAutoEvent(String value) /*-{
		var button = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		button.setAutoEvent(value);
	}-*/;

	/**
	 * Sets the value of badgeCls.
	 * 
	 * @param value
	 */
	public native void setBadgeCls(String value) /*-{
		var button = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		button.setBadgeCls(value);
	}-*/;

	/**
	 * Sets the value of badgeCls.
	 */
	public native void setBadgeText(String value) /*-{
		var button = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		button.setBadgeText(value);
	}-*/;

	/**
	 * Returns true if button is disabled.
	 * 
	 * @return true if disabled
	 */
	@Override
	public boolean isDisabled() {
		return super.isDisabled();
	}

	@Override
	public String getXType() {
		return XType.BUTTON.getValue();
	}

	/**
	 * @return true if toggle enabled
	 */
	public boolean isEnableToggle() {
		return getAttributeAsBoolean(TouchAttribute.ENABLE_TOGGLE.getValue());
	}

	/**
	 * True to start hidden or hide rendered button (defaults to false).
	 * 
	 * @param hidden
	 *            true for hidden
	 */
	@Override
	public void setHidden(boolean hidden) {
		if (!isRendered()) {
			setAttribute(TouchAttribute.HIDDEN.getValue(), hidden, true);
		} else {
			hide();
		}
	}

	/**
	 * Sets the value of iconCls
	 */
	public void setIconCls(Icons icon) {
		setIconCls(icon.getValue());
	}

	public native void setIconCls(String value) /*-{
		var button = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		button.setIconCls(value);
	}-*/;

	/**
	 * @return the icon CSS class for this Button
	 */
	public native boolean hasIconMask() /*-{
		var button = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return button.getIconMask();
	}-*/;

	/**
	 * @deprecated Updates the badge text.This method has been DEPRECATED since 2.0.0
	 * 
	 *             Please use setBadgeText instead.
	 * @param value
	 */
	public native void setBadge(String value) /*-{
		var button = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		button.setBadge(value);
	}-*/;

	/**
	 * Sets the value of handler.
	 * 
	 * @param value
	 */
	public native void setHandler(Function handler) /*-{
		var button = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		button.setHandler(function() {
			handler.@com.ait.toolkit.core.client.Function::execute()();
		});
	}-*/;

	/**
	 * Sets the value of icon
	 */
	public native void setIcon(String value) /*-{
		var button = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		button.setIcon(value);
	}-*/;

	/**
	 * Sets the value of iconAlign.
	 */
	public native void setIconAlign(String value) /*-{
		var button = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		button.setIconAlign(value);
	}-*/;

	/**
	 * Sets the value of iconAlign.
	 */
	public void setIconAlign(IconAlign align) {
		setIconAlign(align.getValue());
	}

	/**
	 * Sets the value of iconMask.
	 */
	public native void setIconMask(boolean value) /*-{
		var button = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		//button.setIconMask(value);
	}-*/;

	/**
	 * Sets the value of iconMaskCls.
	 */
	public native void setIconMaskCls(String value) /*-{
		var button = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		//button.setIconMaksCls(value);
	}-*/;

	/**
	 * Sets the value of labelCls.
	 * 
	 * @param value
	 */
	public native void setLabelCls(String value) /*-{
		var button = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		button.setLabelCls(value);
	}-*/;

	/**
	 * Sets the value of pressedCls.
	 * 
	 * @param value
	 */
	public native void setPressedCls(String value) /*-{
		var button = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		button.setPressedCls(value);
	}-*/;

	/**
	 * Sets the value of text.
	 */
	public void setText(String text) {
		setRenderedText(text);
	}

	/**
	 * Sets the value of ui
	 */
	@Override
	public void setUi(UI ui) {
		setUi(ui.getValue());
	}

	public void setUi(String value) {
		setRenderedUi(value);
	}

	public static Button cast(Component component) {
		return new Button(component.getOrCreateJsObj());
	}

	// Events

	public native HandlerRegistration addTapHandler(TapHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(b, e) {
			var button = @com.ait.toolkit.sencha.touch.client.ui.Button::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var TapEvent = @com.ait.toolkit.sencha.touch.client.events.button.TapEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/Button;Lcom/google/gwt/core/client/JavaScriptObject;)(button,e);
			handler.@com.ait.toolkit.sencha.touch.client.events.button.TapHandler::onTap(Lcom/ait/toolkit/sencha/touch/client/events/button/TapEvent;)(TapEvent);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.button.TapEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;

	}-*/;

	/**
	 * Gets the text of this button.
	 * 
	 * @return the button text, null if not set
	 */
	private native String getRenderedText() /*-{
		var button = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var text = button.getText();
		return text === undefined ? null : text;
	}-*/;

	/**
	 * Sets this button's text.
	 * 
	 * @param text
	 *            the text
	 */
	private native void setRenderedText(String text) /*-{
		var button = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		button.setText(text);
	}-*/;

	private native void setRenderedUi(String ui) /*-{
		var button = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		button.setUi(ui);
	}-*/;

	private native void setIconClsCreated(String iconCls) /*-{
		var button = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return button.setIconClass(iconCls);
	}-*/;

	private native String _getUi() /*-{
		var button = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return button.getUi();
	}-*/;

	private void generateButtonId() {
		id = new StringBuilder().append("ext-").append(this.getXType()).append("-").append(++buttonId).toString();
		Element elementId = Document.get().getElementById(id);
		if (elementId == null) {
			JsoHelper.setAttribute(config, "id", id);
		} else {
			generateButtonId();
		}
	}

}
