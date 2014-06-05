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

import com.ait.toolkit.sencha.touch.client.core.config.Dock;
import com.ait.toolkit.sencha.touch.client.ui.Container;
import com.google.gwt.dom.client.Element;

public interface FocusWidget {

    /**
     * Destroys this component by purging any event listeners, removing the
     * component's element from the DOM, removing the component from its
     * {@link Container} (if applicable) and unregistering it from
     * {@link ComponentMgr}. Destruction is generally handled automatically by
     * the framework and this method should usually not need to be called
     * directly.
     */
    public void destroy();

    /**
     * Disable this component.
     */
    public void disable();

    /**
     * Enable this component.
     */
    public void enable();

    /**
     * Returns the value of docked.
     * 
     * @return
     */
    public Dock getDocked();

    /**
     * Returns the value of draggable.
     * 
     * @return
     */
    public <T> T getDraggable();

    /**
     * Returns the value of droppable.
     * 
     * @return
     */
    public <T> T getDroppable();

    /**
     * Returns the value of masked.
     * 
     * @return
     */
    public boolean isMasked();

    /**
     * Returns the value of modal.
     * 
     * @return
     */
    public boolean isModal();

    /**
     * @return the element the Component is rendered to
     */
    public Element getRenderTo();

    /**
     * Returns the value of renderTpl.
     * 
     * @return Mixed
     */
    public <T> T getRenderTpl();

    /**
     * Returns the value of zIndex.
     * 
     * @return
     */
    public double getZIndex();

    /**
     * Hide this component.
     */
    public void hide();

    /**
     * True if this component is disabled.
     * 
     * @return true if disabled
     */
    public boolean isDisabled();

    /**
     * @return true if the component is hidden
     */
    public boolean isHidden();

    /**
     * Removes the given CSS class(es) from this Component's rendered element
     * 
     * @param cls
     * @param prefix
     * @param suffix
     */
    public void removeCls(String cls, String prefix, String suffix);

    /**
     * Sets the value of baseCls.
     * 
     * @param baseCls
     */
    public void setBaseCls(String baseCls);

    /**
     * Sets the value of disabledCls.
     * 
     * @param value
     */
    public void setDisabled(boolean value);

    /**
     * Sets the value of disabledCls.
     * 
     * @param value
     */
    public void setDisabledCls(String value);

    /**
     * Sets the value of draggable.
     * 
     * @param value
     */
    public void setDraggable(Object value);

    /**
     * Sets the value of droppable.
     * 
     * @param value
     */
    public void setDroppable(Object value);

    /**
     * Sets the value of hidden.
     * 
     * @param value
     */
    public void setHidden(boolean value);

    /**
     * Sets the value of modal.
     * 
     * @param value
     */
    public void setModal(boolean value);

    /**
     * Sets the value of renderTo.
     * 
     * @param value
     */
    public void setRenderTo(Element value);

    /**
     * Sets the value of renderTpl.
     * 
     * @param value
     */
    public void setRenderTpl(Object value);

    /**
     * Sets the value of style.
     * 
     * @param value
     */
    public void setStyle(String value);

    /**
     * Sets the value of style.
     * 
     * @param value
     */
    public void setStyle(Object value);

    /**
     * Sets the value of zIndex.
     * 
     * @param value
     */
    public void setZIndex(int value);

    /**
     * Shows this component
     */
    public void show();

    /**
     * Updates the HTML content of the Component. Deprecated, please use setHtml
     * instead
     */
    @Deprecated
    public void update();

    /**
     * Convenience function to hide or show this component by boolean.
     * 
     * @param visible
     *            True to show, false to hide
     */
    public void setVisible(boolean visible);

    /**
     * The id of the node, a DOM node or an existing Element that will be the
     * container to render this component into. Using this config, a call to
     * render() is not required.
     * 
     * @param elemID
     *            the container element
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setRenderToID(String elemID) throws IllegalStateException;

}
