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
package com.ait.toolkit.sencha.touch.client.layout;

import com.ait.toolkit.core.client.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * The Base Layout is the layout that all other layouts inherit from. The main
 * capability it provides is docking, which means that every other layout can
 * also provide docking support. It's unusual to use Default layout directly,
 * instead it's much more common to use one of the sub classes:
 * 
 * {@link HBoxLayout} {@link VBoxLayout} {@link CardLayout} {@link FitLayout}
 */
public class DefaultLayout extends AbstractLayout {

    protected JavaScriptObject jso;

    public DefaultLayout() {
        create();
    }

    private void create() {
        jso = JsoHelper.createObject();
    }

    @Override
    public void setType(Type type) {
        setType(type.getValue());
    }

    private native void setType(String value) /*-{
		var jso = this.@com.ait.toolkit.sencha.touch.client.layout.AbstractLayout::getJSO()();
		jso.type = value;
    }-*/;

}