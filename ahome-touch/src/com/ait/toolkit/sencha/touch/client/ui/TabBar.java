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
import com.google.gwt.core.client.JavaScriptObject;

public class TabBar extends ToolBar {

    @Override
    protected native void init()/*-{
		var c = new $wnd.Ext.tab.Bar();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
    }-*/;

    @Override
    public String getXType() {
        return XType.TABAR.getValue();
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.tab.Bar(config);
    }-*/;
    
    protected TabBar(JavaScriptObject jsObj) {
        super(jsObj);
    }
    
    protected static TabBar instance(JavaScriptObject jsObj) {
        return new TabBar(jsObj);
    }

    public TabBar() {

    }

    public native void setActiveTab(int value) /*-{
		var tab = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		tab.setActiveTab(value);
    }-*/;

    public native void setActiveTab(String value) /*-{
		var tab = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		tab.setActiveTab(value);
    }-*/;

}
