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
import com.ait.toolkit.sencha.touch.client.core.ImageElement;
import com.ait.toolkit.sencha.touch.client.core.config.Event;
import com.ait.toolkit.sencha.shared.client.core.XType;
import com.ait.toolkit.sencha.shared.client.core.handlers.CallbackRegistration;
import com.ait.toolkit.sencha.touch.client.core.handlers.image.ImageTapHandler;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * This is a simple way to add an image of any size to your application and have
 * it participate in the layout system like any other component. This component
 * typically takes between 1 and 3 configurations - a src, and optionally a
 * height and a width.
 * 
 * <a href=http://docs.sencha.com/touch/2-0/#!/api/Ext.Img>Ext.Img</a>
 */
public class Image extends Component implements ImageElement {

    private Image(JavaScriptObject config) {
        super(config);
    }

    protected native void init()/*-{
		var c = new $wnd.Ext.Img();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
    }-*/;

    public String getXType() {
        return XType.IMAGE.getValue();
    }

    /**
     * Create a new Image.
     */
    public Image() {
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.Img(config);
    }-*/;

    /**
     * Sets the value of src
     */
    @Override
    public native void setSrc(String value) /*-{
		var image = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		image.setSrc(value);
    }-*/;

    /**
     * Returns the value of src
     * 
     * @return
     */
    public native String getSrc() /*-{
		var image = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return image.getSrc();
    }-*/;

    /**
     * Fires whenever the component is tapped
     * 
     * @param handler
     */
    public CallbackRegistration addTapHandler(ImageTapHandler handler) {
        return this.addWidgetListener(Event.TAP.getValue(), handler.getJsoPeer());
    }

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
