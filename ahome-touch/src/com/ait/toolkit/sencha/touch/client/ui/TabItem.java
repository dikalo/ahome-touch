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

import java.util.Iterator;

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.ait.toolkit.sencha.touch.client.core.Ext;
import com.ait.toolkit.sencha.touch.client.core.Icons;
import com.ait.toolkit.sencha.touch.client.core.IsComponent;
import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.touch.client.core.config.TouchAttribute;
import com.ait.toolkit.sencha.touch.client.layout.AbstractLayout;
import com.ait.toolkit.sencha.touch.client.layout.FitLayout;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

/**
 * A basic implemetation for a TabItem to be used with {@link TabPanel}
 */
public class TabItem extends Composite implements HasWidgets {

    private Widget widget;
    private final JavaScriptObject jsObj;
    private String id;
    private TabPanel parent;
    private int index;

    protected TabItem(JavaScriptObject jso) {
        jsObj = jso;
    }

    public JavaScriptObject getJsObj() {
        return jsObj;
    }

    public TabItem() {
        jsObj = JavaScriptObject.createObject();
        id = Ext.generateId("ext-container-");
        JsoHelper.setAttribute(jsObj, TouchAttribute.ID.getValue(), id);
        initWidget(new Container());
        setLayout(new FitLayout());
    }

    public TabItem(String title) {
        this();
        setTitle(title);
    }

    public void setTitle(String title) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.TITLE.getValue(), title);
    }

    public void setIconCls(Icons iconCls) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.ICON_CLS.getValue(), iconCls.getValue());
    }

    public void setIconCls(String iconCls) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.ICON_CLS.getValue(), iconCls);
    }

    public void setHtml(String html) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.HTML.getValue(), html);
    }

    public void setCls(String cls) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.CLS.getValue(), cls);
    }

    public void setStyle(String cls) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.STYLE.getValue(), cls);
    }

    public String getTitle() {
        return JsoHelper.getAttribute(jsObj, TouchAttribute.TITLE.getValue());
    }

    public String getIconCls() {
        return JsoHelper.getAttribute(jsObj, TouchAttribute.ICON_CLS.getValue());
    }

    public String getHtml() {
        return JsoHelper.getAttribute(jsObj, TouchAttribute.HTML.getValue());
    }

    public void setLayout(AbstractLayout layout) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.LAYOUT.getValue(), layout.getJSO());
    }

    public void setBadgeText(String badgeText) {
        if (this.parent == null) {
            JsoHelper.setAttribute(jsObj, TouchAttribute.BADGE_TEXT.getValue(), badgeText);
        } else {
            this.parent.updateBadget(this.index, badgeText);
        }
    }

    public void add(Component component) {
        if (getWidget() != null) {
            throw new IllegalStateException("TabItem can only contain one child widget");
        }
        JavaScriptObject componentJS = component.isCreated() ? component.getOrCreateJsObj() : component.getConfig();
        _setItems(componentJS);
        widget = component;
    }

    public void add(IsComponent isComponent) {
        this.add(isComponent.asComponent());
    }

    /**
     * @return the widget
     */
    public Widget getWidget() {
        return widget;
    }

    /**
     * @param widget
     *            the widget to set
     */
    public void setWidget(Widget widget) {
        this.widget = widget;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    private void _setItems(JavaScriptObject component) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.ITEMS.getValue(), component);
    }

    @Override
    public void add(Widget w) {
        if (!(w instanceof Component)) {
            throw new IllegalStateException(
                            "TabItem can only contain a child of typecom.emitrom.gwt4.touch.client.core.Component ");
        }
        add((Component) w);
    }

    @Override
    public void clear() {
    }

    @Override
    public Iterator<Widget> iterator() {
        return null;
    }

    @Override
    public boolean remove(Widget w) {
        return false;
    }

    public void setParent(TabPanel parent) {
        if (this.parent != null) {
            throw new IllegalStateException(
                            "TabItem can only be added to one parent. Have you already added this TabItem to a container ?");
        }
        this.parent = parent;
        this.index = parent.getNextChildIndex();
    }

    /**
     * Returns the position at which this TabItem was added to his parent
     * 
     * @return
     */
    public int getIndex() {
        return this.index;
    }

}
