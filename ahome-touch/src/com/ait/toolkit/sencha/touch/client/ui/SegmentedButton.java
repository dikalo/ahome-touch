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

import java.util.ArrayList;
import java.util.List;

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.touch.client.core.TouchJsoHelper;
import com.ait.toolkit.sencha.touch.client.core.config.Event;
import com.ait.toolkit.sencha.shared.client.core.XType;
import com.ait.toolkit.sencha.shared.client.core.handlers.CallbackRegistration;
import com.ait.toolkit.sencha.touch.client.core.handlers.segmentedbutton.ToggleHandler;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * SegmentedButton is a container for a group of Buttons. Generally a
 * SegmentedButton would be a child of a ToolBar and would be used to switch
 * between different views.
 * 
 * @see <a href=http://docs.sencha.com/touch/2-0/#!/api/Ext.SegmentedButton>Ext.
 *      SegmentedButton</a>
 */
public class SegmentedButton extends Container implements HasToggleHandler {

    private static int buttonId = 0;

    @Override
    protected native void init()/*-{
		var c = new $wnd.Ext.SegmentedButton();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
    }-*/;

    /**
     * Create a new SegmentedButton.
     */
    protected SegmentedButton(JavaScriptObject options) {
        super(options);
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.SegmentedButton(config);
    }-*/;

    @Override
    public String getXType() {
        return XType.SEGMENTED_BUTTON.getValue();
    }

    /**
     * Create a new SegmentedButton.
     */
    public SegmentedButton() {
        // id = new
        // StringBuilder().append("ext-").append(this.getXType()).append("-").append(++buttonId).toString();
        // JsoHelper.setAttribute(config, "id", id);
    }

    /**
     * We override initItems so we can check for the pressed config.
     */
    public native void applyItems() /*-{
		var segmentedButton = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		segmentedButton.applyItems();
    }-*/;

    public native void doSetDisabled() /*-{
		var segmentedButton = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		segmentedButton.doSetDisabled();
    }-*/;

    /**
     * 
     * @return the value of allowDepress.
     */
    public native boolean allowDepress() /*-{
		var segmentedButton = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return segmentedButton.getAllowDepress();
    }-*/;

    /**
     * 
     * @return the value of allowDepress.
     */
    public native boolean allowMultiple() /*-{
		var segmentedButton = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return segmentedButton.getAllowMultiple();
    }-*/;

    /**
     * 
     * @return the value of pressedButtons.
     */
    public ArrayList<Button> getPressedButtons() {
        Component[] buttons = TouchJsoHelper.convertToJavaComponentArray(_getPressedButtons());
        ArrayList<Button> toReturn = new ArrayList<Button>();
        for (Component c : buttons) {
            toReturn.add((Button) c);
        }
        return toReturn;
    }

    /**
     * 
     * @return the value of pressedCls.
     */
    public native String getPressedCls() /*-{
		var segmentedButton = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return segmentedButton.getPressedCls();
    }-*/;

    /**
     * 
     * @return the value of pressedCls.
     */
    public boolean isPressed(Button button) {
        return _isPressed(button.getJsObj());
    }

    /**
     * Set the value of allowDepress
     * 
     * @param value
     * @return
     */
    public native void setAllowDepress(boolean value) /*-{
		var segmentedButton = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		segmentedButton.setAllowDepress(value);
    }-*/;

    /**
     * Set the value of allowMultiple
     * 
     * @param value
     * @return
     */
    public native void setAllowMultiple(boolean value) /*-{
		var segmentedButton = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		segmentedButton.setAllowMultiple(value);
    }-*/;

    /**
     * Set the value of allowDepress
     * 
     * @param value
     * @return
     */
    public void setPressedButtons(List<Button> buttons) {
        JavaScriptObject[] toSet = new JavaScriptObject[buttons.size()];
        for (int i = 0; i < buttons.size(); i++) {
            toSet[i] = buttons.get(i).getJsObj();
        }
        setPressedButtons(JsoHelper.arrayConvert(toSet));
    }

    /**
     * Sets the value of pressedCls
     * 
     * @param value
     */
    public native void setPressedCls(String value) /*-{
		var segmentedButton = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		segmentedButton.setPressedCls(value);
    }-*/;

    private native boolean _isPressed(JavaScriptObject obj) /*-{
		var segmentedButton = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return segmentedButton.isPressed(obj);
    }-*/;

    private native JavaScriptObject _getPressedButtons() /*-{
		var segmentedButton = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return segmentedButton.getPressedButtons();
    }-*/;

    private native void setPressedButtons(JavaScriptObject value) /*-{
		var segmentedButton = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		segmentedButton.setPressedButtons(value);
    }-*/;

    /**
     * Fires when any child button's pressed state has changed
     */
    @Override
    public CallbackRegistration addToggleHandler(ToggleHandler handler) {
        return this.addWidgetListener(Event.TOGGLE.getValue(), handler.getJsoPeer());
    }

}
