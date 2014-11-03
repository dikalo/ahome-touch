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
 * ListDataView is a custom styled DataView which allows Grouping, Indexing,
 * Icons, and a Disclosure.
 * 
 */
public class DataItem extends Container {

    private String defaultType;

    protected DataItem(JavaScriptObject config) {
        super(config);
    }

    @Override
    protected native void init()/*-{
		var c = new $wnd.Ext.dataview.component.DataItem();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
    }-*/;

    @Override
    public String getXType() {
        return XType.DATAITEM.getValue();
    }

    /**
     * Create a new Disclosurelist.
     */
    public DataItem() {
    }

    public DataItem(DataItemConfig c) {
        create(c.getJsObj());
    }

    public DataItem(String xType) {
        defaultType = xType;
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.dataview.component.DataItem(config);
    }-*/;

    public void setConfig(DataItemConfig config) {
        setAttribute("config", config.getJsObj(), false);
    }

    public String getDefaultType() {
        return getAttribute("xtype");
    }

    public void setDefaultType(String defaultType) {
        this.defaultType = defaultType;
    }

    public void setXType(String value) {
        setAttribute("xtype", value, true);
    }

}
