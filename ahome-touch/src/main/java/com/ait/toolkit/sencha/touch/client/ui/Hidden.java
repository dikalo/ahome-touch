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

/**
 * Hidden fields allow you to easily inject additional data into a form without
 * displaying additional fields on the screen. This is often useful for sending
 * dynamic or previously collected data back to the server in the same request
 * as the normal form submission.
 * 
 */
public class Hidden extends Field {
    
    @Override
    public native void init()/*-{
		var c = new $wnd.Ext.field.Hidden();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
    }-*/;

    @Override
    public String getXType() {
        return XType.HIDDEN_FIELD.getValue();
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.field.Hidden(config);
    }-*/;

    public Hidden() {
    }

    protected Hidden(JavaScriptObject jso) {
        super(jso);
    }
}
