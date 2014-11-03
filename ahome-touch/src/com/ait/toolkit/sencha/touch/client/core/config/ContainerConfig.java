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
package com.ait.toolkit.sencha.touch.client.core.config;

import com.ait.toolkit.core.client.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class ContainerConfig extends ComponentConfig {

    public ContainerConfig() {
        super();
    }

    /**
     * The item from the items collection that will be active first. This is
     * usually only meaningful in a card layout, where only one item can be
     * active at a time.
     * 
     * Defaults to: 0
     * 
     * @param value
     */
    public void setActiveItem(JavaScriptObject value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.ACTIVE_ITEM.getValue(), value);
    }

    /**
     * If true, child items will be destroyed as soon as they are removed from
     * this container.
     * 
     * Defaults to: true
     * 
     * @param value
     */
    public void setAutoDestroy(Boolean value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.AUTO_DESTROY.getValue(), value);
    }

    /**
     * The default xtype of child Components to create in this Container when a
     * child item is specified as a raw configuration object, rather than as an
     * instantiated Component.
     * 
     * Defaults to: null
     * 
     * @param value
     */
    public void setDefaultType(String value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.DEFAULT_TYPE.getValue(), value);
    }

    /**
     * A set of default configurations to apply to all child Components in this
     * Container. It's often useful to specify defaults when creating more than
     * one items with similar configurations. For example here we can specify
     * that each child is a panel and avoid repeating the xtype declaration for
     * each one:
     * 
     * <pre>
     * Ext.create('Ext.Container', {
     * defaults: {
     *   xtype: 'panel'
     * },
     * items: [
     *   {
     *       html: 'Panel 1'
     *   },
     *   {
     *       html: 'Panel 2'
     *   }
     * ]
     * });
     * </pre>
     * 
     * Defaults to: null
     * 
     * @param value
     */
    protected void setDefaults(JavaScriptObject value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.DEFAULTS.getValue(), value);
    }

    /**
     * The child items to add to this Container. This is usually an array of
     * Component configurations or instances, for example:
     * 
     * <pre>
     * Ext.create('Ext.Container', {
     * 
     * items: [
     *  {
     *      xtype: 'panel',
     *      html: 'This is an item'
     *  }
     * ]
     * });
     * </pre>
     * 
     * Defaults to: null
     * 
     * @param value
     */
    protected void setItems(JavaScriptObject value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.ITEMS.getValue(), value);
    }

    /**
     * The child items to add to this Container. This is usually an array of
     * Component configurations or instances, for example:
     * 
     * <pre>
     * Ext.create('Ext.Container', {
     * 
     * items: [
     *  {
     *      xtype: 'panel',
     *      html: 'This is an item'
     *  }
     * ]
     * });
     * </pre>
     * 
     * Defaults to: null
     * 
     * @param value
     */
    public void setItems(JsArray<JavaScriptObject> value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.ITEMS.getValue(), value);
    }

    /**
     * Configuration for this Container's layout. Example:
     * 
     * <pre>
     * Ext.create('Ext.Container', {
     * layout: {
     *  type: 'hbox',
     *  align: 'middle'
     * },
     * items: [
     *   {
     *       xtype: 'panel',
     *       flex: 1,
     *       style: 'background-color: red;'
     *   },
     *   {
     *       xtype: 'panel',
     *       flex: 2,
     *       style: 'background-color: green'
     *   }
     * ]
     * });
     * </pre>
     * 
     * @param value
     */
    public void setLayout(JavaScriptObject value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.LAYOUT.getValue(), value);
    }

    /**
     * Configuration for this Container's layout. Example:
     * 
     * <pre>
     * Ext.create('Ext.Container', {
     * layout: {
     *  type: 'hbox',
     *  align: 'middle'
     * },
     * items: [
     *   {
     *       xtype: 'panel',
     *       flex: 1,
     *       style: 'background-color: red;'
     *   },
     *   {
     *       xtype: 'panel',
     *       flex: 2,
     *       style: 'background-color: green'
     *   }
     * ]
     * });
     * </pre>
     * 
     * @param value
     */
    public void setLayout(String value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.LAYOUT.getValue(), value);
    }

    /**
     * Configuration options to make this Container scrollable
     * 
     * Defaults to: null
     * 
     * @param value
     */
    public void setScrollable(JavaScriptObject value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.SCROLLABLE.getValue(), value);
    }

    /**
     * Configuration options to make this Container scrollable
     * 
     * Defaults to: null
     * 
     * @param value
     */
    public void setScrollable(Boolean value) {
        JsoHelper.setAttribute(jsObj, TouchAttribute.SCROLLABLE.getValue(), value);
    }

}
