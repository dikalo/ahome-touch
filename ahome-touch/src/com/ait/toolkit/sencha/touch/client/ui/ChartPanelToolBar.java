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
import com.ait.toolkit.sencha.touch.client.core.config.Dock;
import com.ait.toolkit.sencha.shared.client.core.XType;
import com.ait.toolkit.sencha.touch.client.laf.UI;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Special toolbar to use in the chartpanel. This class should not be used
 * directly.
 */
class ChartPanelToolBar extends Container implements HasUi, HasTitle {

    @Override
    protected native void init()/*-{
		var c = new $wnd.Ext.Toolbar();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
    }-*/;

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		if (!config.items) {
			config.items = @com.ait.toolkit.core.client.JsoHelper::createJavaScriptArray()();
		}
		return new $wnd.Ext.Toolbar(config);
    }-*/;

    /**
     * Create a new Toolbar.
     */
    ChartPanelToolBar() {
        setTitle("");
    }

    /**
     * Create a new Toolbar with the given title
     * 
     * @param title , the title of the toolbar.
     */
    ChartPanelToolBar(String title) {
        this();
        setTitle(title);
    }

    ChartPanelToolBar(Dock dockPosition) {
        this();
        setDocked(dockPosition);
    }

    /**
     * Create a new Toolbar with the given title and the given UI style
     * 
     * @param title , the title of the toolbar.
     * @param ui , the ui style of the toolbar.
     */
    public ChartPanelToolBar(String title, UI ui) {
        this(title);
        setUi(ui);
    }

    /**
     * Create a new Toolbar with the given UI style at the given dock position
     * 
     * @param title , the title of the toolbar.
     * @param ui , the ui style of the toolbar.
     * @param dockPosition , the dock position of the toolbar
     */
    ChartPanelToolBar(String title, UI ui, Dock dockPosition) {
        this(title, ui);
        setDocked(dockPosition);
    }

    public String getXType() {
        return XType.TOOLBAR.getValue();
    }

    /**
     * Sets the title text for the panel.
     * 
     * @param title the title
     */
    private native void setTitleRendered(String title) /*-{
		var panel = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		panel.setTitle(title);
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.ait.toolkit.sencha.touch.client.containers.HasTitle#getTitle()
     */
    @Override
    public native String getTitle() /*-{
		var panel = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return panel.getTitle();
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ait.toolkit.sencha.touch.client.containers.HasTitle#setTitle(java.lang.
     * String)
     */
    @Override
    public void setTitle(String title) {
        if (title == null || title.equals("")) {
            title = " ";
        }
        setTitleRendered(title);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ait.toolkit.sencha.touch.client.containers.HasUi#setUi(com.emitrom.gwt4
     * .touch.client.laf.UI)
     */
    @Override
    public void setUi(UI ui) {
        setUi(ui.getValue());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ait.toolkit.sencha.touch.client.containers.HasUi#getUi()
     */
    @Override
    public UI getUi() {
        return UI.fromValue(_getUi());
    }

    /**
     * Shows the title if it exists
     */
    public native void showTitle()/*-{
		var toolBar = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		toolBar.hideTitle();
    }-*/;

    /**
     * Hides the title if it exists.
     */
    public native void hideTitle()/*-{
		var toolBar = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		toolBar.showTitle();
    }-*/;

    private native void setUi(String ui)/*-{
		var toolBar = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		toolBar.setUi(ui);
    }-*/;

    private native String _getUi()/*-{
		var toolBar = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return toolBar.getUi();
    }-*/;
}
