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
package com.ait.toolkit.sencha.touch.client.core;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public interface HasItems {

    /**
     * Add a Component to the Container.
     * 
     * @param component
     *            the component to add
     */
//    public void add(Component component);

    /**
     * Gets a direct child Component by id.
     * 
     * @param id
     *            the component ID
     * @return the component
     */
    public Component getComponent(String id);

    /**
     * Gets a direct child Component by by index.
     * 
     * @param index
     *            the component index
     * @return the component
     */
    public Component getComponent(int index);

    /**
     * The collection of components in this container.
     * 
     * @return child components
     */
    public Component[] getComponents();

    /**
     * Removes all child components without destroying them.
     */
    public void removeAll();

    /**
     * A string component id or the numeric index of the component that should
     * be initially activated within the container's layout on render. For
     * example, activeItem: 'item-1' or activeItem: 0 (index 0 = the first item
     * in the container's collection). activeItem only applies to layout styles
     * that can display items one at a time (like
     * {@link com.ait.toolkit.sencha.touch.client.core.layout.AccordionLayout} ,
     * {@link com.ait.toolkit.sencha.touch.client.core.layout.CardLayout} and
     * {@link com.ait.toolkit.sencha.touch.client.layout.FitLayout} ).
     * 
     * 
     * @param activeItem
     *            the active Item ID
     */
    public void setActiveItem(int activeItem);

    /**
     * Return the Active Item index.
     * 
     * @return the active item index
     */
    public <T> T getActiveItem();

    /**
     * Sets the value of items.
     * 
     * @param items
     */
    public void setItems(JsArray<JavaScriptObject> items);

    /**
     * Returns the value of items.
     * 
     * @param <T>
     * @return
     */
    public <T> T getItems();

}
