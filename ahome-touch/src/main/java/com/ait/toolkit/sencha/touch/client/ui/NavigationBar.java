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
import com.ait.toolkit.sencha.touch.client.core.HasUi;
import com.ait.toolkit.sencha.touch.client.laf.UI;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * This component is used in NavigationView to control animations in the
 * toolbar. You should never need to interact with the component directly,
 * unless you are subclassing it.
 * 
 * @see <a href=http://docs.sencha.com/touch/2-0/#!/api/Ext.navigation.Bar>Ext.
 *      navigation.Bar</a>
 */
public class NavigationBar extends TitleBar implements HasUi, HasTitle {

    @Override
    protected native void init()/*-{
		var c = new $wnd.Ext.NavigationBar();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
    }-*/;

    /**
     * Create a new NavigationBar.
     */
    public NavigationBar() {
    }

    public NavigationBar(JavaScriptObject obj) {
        super(obj);
    }

    public NavigationBar(String title) {
        setTitle(title);
    }

    public NavigationBar(UI ui) {
        setUi(ui);
    }

    public NavigationBar(String title, UI ui) {
        setTitle(title);
        setUi(ui);
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.NavigationBar(config);
    }-*/;

    /**
     * 
     * @return the value of defaulType
     */
    public native String getDefaultType() /*-{
		var nav = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return nav.getDefaultType();
    }-*/;

    /**
     * Sets the value of defaultype.
     * 
     * @param value
     */
    public native void setDefaultType(String value) /*-{
		var nav = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		nav.setDefaultType(value);
    }-*/;

    /**
     * 
     * @return the value of title
     */
    @Override
    public native String getTitle() /*-{
		var nav = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return nav.getTitle();
    }-*/;

    /**
     * Sets the value of title.
     * 
     * @param value
     */
    @Override
    public native void setTitle(String value) /*-{
		var nav = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		nav.setTitle(value);
    }-*/;

    /**
     * 
     * @return the value of ui
     */
    @Override
    public UI getUi() {
        return UI.fromValue(_getUi());
    }

    private native String _getUi() /*-{
		var nav = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return nav.getUi();
    }-*/;

    /**
     * Sets the value of ui.
     * 
     * @param value
     */
    @Override
    public void setUi(UI ui) {
        setUi(ui.getValue());
    }

    private native void setUi(String value) /*-{
		var nav = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		nav.setUi(value);
    }-*/;

}
