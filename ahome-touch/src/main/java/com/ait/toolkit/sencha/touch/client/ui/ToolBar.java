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
import com.ait.toolkit.sencha.touch.client.core.Title;
import com.ait.toolkit.sencha.touch.client.core.config.Dock;
import com.ait.toolkit.sencha.shared.client.core.XType;
import com.ait.toolkit.sencha.touch.client.laf.UI;
import com.ait.toolkit.sencha.touch.client.layout.AbstractLayout;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Toolbars are most commonly used as dockedItems within an Panel. They can be
 * docked at the 'top' or 'bottom' of a Panel by specifying the dock property. <br/>
 * <br/>
 * The defaultType of ToolBar is 'button'.
 * 
 * @see <a
 *      href=http://docs.sencha.com/touch/2-0/#!/api/Ext.Toolbar>Ext.Toolbar</a>
 */
public class ToolBar extends Container implements HasUi, HasTitle {

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

    protected ToolBar(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Create a new Toolbar.
     */
    public ToolBar() {
        setTitle("");
        setDocked(Dock.TOP);
    }

    /**
     * Create a new Toolbar with the given title
     * 
     * @param title
     *            , the title of the toolbar.
     */
    public ToolBar(String title) {
        this();
        setTitle(title);
    }

    public ToolBar(Dock dockPosition) {
        this();
        setDocked(dockPosition);
    }

    public ToolBar(String title, Dock dockPosition) {
        this(title);
        setDocked(dockPosition);
    }

    /**
     * Create a new Toolbar with the given title and the given UI style
     * 
     * @param title
     *            , the title of the toolbar.
     * @param ui
     *            , the ui style of the toolbar.
     */
    public ToolBar(String title, UI ui) {
        this(title);
        setUi(ui);
    }

    /**
     * Create a new Toolbar with the given UI style at the given dock position
     * 
     * @param title
     *            , the title of the toolbar.
     * @param ui
     *            , the ui style of the toolbar.
     * @param dockPosition
     *            , the dock position of the toolbar
     */
    public ToolBar(String title, UI ui, Dock dockPosition) {
        this(title, ui);
        setDocked(dockPosition);
    }

    public String getXType() {
        return XType.TOOLBAR.getValue();
    }

    /**
     * Sets the title text for the panel.
     * 
     * @param title
     *            the title
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
    public String getTitle() {
        return getTitleComponent().getTitle();
    }

    public native Title getTitleComponent() /*-{
		var panel = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var obj = panel.getTitle();
		return @com.ait.toolkit.sencha.touch.client.core.Title::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.ait.toolkit.sencha.touch.client.containers.HasTitle#setTitle(java.lang.
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
     * @see com.ait.toolkit.sencha.touch.client.containers.HasUi#setUi(com.emitrom.gwt4
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
     * The layout of the toolBar can not be changed. Instead of throwing an
     * exception here, we just do nothing
     */
    @Override
    public void setLayout(AbstractLayout layout) throws IllegalStateException {

    }

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
