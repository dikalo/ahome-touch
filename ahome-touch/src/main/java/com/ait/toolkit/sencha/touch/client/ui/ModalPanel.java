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
import com.ait.toolkit.sencha.touch.client.layout.Layout;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;

/**
 * ModalPanel is particularly useful when creating float
 * panels that need to receive hideOnTapMask events. In these cases,
 * modal needs to be set prior to the construction of the actual object via configuration.
 * This is the only way as of today to get the hideOnTapMask event to work properly.
 */
public class ModalPanel extends Panel {

    @Override
    public String getXType() {
        return XType.PANEL.getValue();
    }

    @Override
    protected native void init()/*-{
		var c = new $wnd.Ext.Panel();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
    }-*/;
    
    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        config.modal = true;
        config.hidden = true;
        return new $wnd.Ext.Panel(config);
    }-*/;

    protected static ModalPanel instance(JavaScriptObject jsObj) {
        return new ModalPanel(jsObj);
    }
    
    protected ModalPanel(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Create a new Panel.
     */
    public ModalPanel() {
    	
    }

    public ModalPanel(boolean fullScreen) {
        setFullScreen(fullScreen);
    }

    public ModalPanel(Layout layout) {
        setLayout(layout);
    }

    /**
     * Applys the Panel to an existing element.
     * 
     * @param element the element
     */
    public ModalPanel(Element element) {
        super(element);
    }

}
