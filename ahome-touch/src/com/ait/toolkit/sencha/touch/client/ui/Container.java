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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ait.toolkit.sencha.shared.client.core.XType;
import com.ait.toolkit.sencha.shared.client.core.handlers.CallbackRegistration;
import com.ait.toolkit.sencha.touch.client.core.ComplexContainer;
import com.ait.toolkit.sencha.touch.client.core.Component;
import com.ait.toolkit.sencha.touch.client.core.DefaultsHandler;
import com.ait.toolkit.sencha.touch.client.core.HasLayout;
import com.ait.toolkit.sencha.touch.client.core.Resizable;
import com.ait.toolkit.sencha.touch.client.core.Scroller;
import com.ait.toolkit.sencha.touch.client.core.config.ContainerConfig;
import com.ait.toolkit.sencha.touch.client.core.config.TouchAttribute;
import com.ait.toolkit.sencha.touch.client.core.handlers.component.RenderChangeHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.layout.card.ActiveItemChangeHandler;
import com.ait.toolkit.sencha.touch.client.layout.AbstractLayout;
import com.ait.toolkit.sencha.touch.client.layout.CardLayout;
import com.ait.toolkit.sencha.touch.client.layout.FitLayout;
import com.ait.toolkit.sencha.touch.client.layout.HBoxLayout;
import com.ait.toolkit.sencha.touch.client.layout.Layout;
import com.ait.toolkit.sencha.touch.client.layout.VBoxLayout;
import com.ait.toolkit.sencha.touch.client.layout.card.CardAnimation;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

/**
 * A Container has all of the abilities of Component, but lets you nest other Components inside it. Applications are made up of lots of components, usually nested inside one
 * another. Containers allow you to render and arrange child Components inside them. Most apps have a single top-level Container called a Viewport, which takes up the entire
 * screen. Inside of this are child components, for example in a mail app the Viewport Container's two children might be a message ListDataView and an email preview pane.
 * 
 * Containers give the following extra functionality:
 * 
 * Adding child Components at instantiation and run time Removing child Components Specifying a Layout Layouts determine how the child Components should be laid out on the screen.
 * In our mail app example we'd use an HBox layout so that we can pin the email list to the left hand edge of the screen and allow the preview pane to occupy the rest. There are
 * several layouts in Sencha Touch 2, each of which help you achieve your desired application structure, further explained in the Layout guide.
 * 
 * @see <a href=http://docs.sencha.com/touch/2-0/#!/api/Ext.Container>Ext.Container </a>
 */
public class Container extends ComplexContainer implements HasLayout, Resizable {

	private String activeItemID;
	private AbstractLayout layout;
	private DefaultsHandler defaultsHandler;

	@Override
	protected native void init()/*-{
		var c = new $wnd.Ext.Container();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
	}-*/;

	@Override
	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.Container(config);
	}-*/;

	protected static Container instance(JavaScriptObject jsObj) {
		return new Container(jsObj);
	}

	protected Container(JavaScriptObject jsObj) {
		super(jsObj);
	}

	@Override
	public String getXType() {
		return XType.CONTAINER.getValue();
	}

	public Container() {
	}

	public Container(ContainerConfig containerConfig) {
		this(containerConfig.getJsObj());
	}

	public Container(Element element) {
		super(element);
	}

	public void setDefaults(DefaultsHandler defaultsHandler) {
		this.defaultsHandler = defaultsHandler;
	}

	/**
	 * Animates to the supplied activeItem with a specified animation. Currently this only works with a Card layout. This passed animation will override any default animations on
	 * the container, for a single card switch. The animation will be destroyed when complete.
	 * 
	 * @param activeItem
	 * @param animation
	 */
	public void animateActiveItem(int activeItem, CardAnimation animation) {
		animateActiveItem(activeItem, animation.getJSO());
	}

	public void animateActiveItem(Component activeItem, CardAnimation animation) {
		animateActiveItem(activeItem.getJsObj(), animation.getJSO());
	}

	/**
	 * @return true if Component is configured to auto destroy contained components on destruction
	 */
	public native boolean getAutoDestroy() /*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return container.getAutoDestroy();
	}-*/;

	public native boolean isHideOnMaskTap() /*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.ui.Container::getOrCreateJsObj()();
		if (container != null) {
			return container.getHideOnMaskTap();
		}
	}-*/;

	/**
	 * Returns the value of layout.
	 */
	@Override
	public AbstractLayout getLayout() {
		if (layout == null) {
			layout = new AbstractLayout();
		}
		layout.update(_getLayoutNative());
		return layout;
	}

	private native JavaScriptObject _getLayoutNative()/*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.ui.Container::getOrCreateJsObj()();
		if (container != null) {
			return container.getLayout();
		}
	}-*/;

	/**
	 * Inserts a Component into this Container at a specified index. Fires the beforeadd event before inserting, then fires the add event after the Component has been inserted.
	 * 
	 * @param index
	 *            the index to insert the component at
	 * @param component
	 *            the component to insert
	 */
	public void insert(int index, Component component) {
		JavaScriptObject componentJS = component.isCreated() ? component.getOrCreateJsObj() : component.getConfig();
		doInsert(index, componentJS);
	}

	/**
	 * If true the container will automatically destroy any contained component that is removed from it, else destruction must be handled manually (defaults to true).
	 * 
	 * @param autoDestroy
	 *            true to autodestroy
	 */
	public native void setAutoDestroy(boolean autoDestroy) /*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		container.setAutoDestroy(autoDestroy);
	}-*/;

	/**
	 * Sets the value of hideOnMaskTap
	 * 
	 * @param value
	 */
	public native void setHideOnMaskTap(boolean value) /*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.ui.Container::getOrCreateJsObj()();
		if (container != null) {
			container.setHideOnMaskTap(value);
		}
	}-*/;

	/**
	 * Sets the value of items.
	 */

	/**
	 * Sets the value of layout
	 */
	@Override
	public void setLayout(AbstractLayout layout) throws IllegalStateException {
		this.layout = layout;
		setLayout(layout.getJSO());
	}

	/**
	 * Sets the value of layout
	 */
	public void setLayout(Layout layout) {
		if (layout == Layout.CARD) {
			this.setLayout(new CardLayout());
		} else if (layout == Layout.FIT) {
			this.setLayout(new FitLayout());
		} else if (layout == Layout.HBOX) {
			this.setLayout(new HBoxLayout());
		} else if (layout == Layout.VBOX) {
			this.setLayout(new VBoxLayout());
		} else {
			this.setLayout(new FitLayout());
		}
	}

	/**
	 * Sets the value of layout
	 */
	public void setLayout(String layout) {
		if (layout.equalsIgnoreCase(Layout.CARD.getValue())) {
			this.setLayout(new CardLayout());
		} else if (layout.equalsIgnoreCase(Layout.FIT.getValue())) {
			this.setLayout(new FitLayout());
		} else if (layout.equalsIgnoreCase(Layout.HBOX.getValue())) {
			this.setLayout(new HBoxLayout());
		} else if (layout.equalsIgnoreCase(Layout.VBOX.getValue())) {
			this.setLayout(new VBoxLayout());
		} else {
			this.setLayout(new FitLayout());
		}
	}

	/**
	 * Configuration options to make this Container scrollable
	 * 
	 * @param scrollable
	 */
	public native void setScrollable(boolean scrollable) /*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		container.setScrollable(scrollable);
	}-*/;

	public native void setScrollable(String scrollable) /*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		container.setScrollable(scrollable);
	}-*/;

	/**
	 * Sets the value of the scroller
	 * 
	 * @param scroller
	 */
	public void setScroller(Scroller scroller) {
		setScrollable(scroller.getJsObj());
	}

	@Override
	public void removeAll() {
		super.removeAll();
		removeAllNative();
	}

	/**
	 * Removes all items currently in the Container, optionally destroying them all.
	 * 
	 * @param destroy
	 *            ,If true, destroys each removed Component.
	 */
	public void removeAll(boolean destroy) {
		super.removeAll();
		removeAllNative(destroy);
	}

	/**
	 * Removes all items currently in the Container, optionally destroying them all.
	 * 
	 * @param destroy
	 *            ,If true, destroys each removed Component.
	 * @param evertything
	 *            , If true, completely remove all items including docked / centered and floating items.
	 */
	public void removeAll(boolean destroy, boolean evertything) {
		super.removeAll();
		removeAllNative(destroy, evertything);
	}

	/**
	 * Removes the Component at the specified index:
	 * 
	 * @param index
	 *            ,The index of the Component to remove.
	 * @return
	 */
	public native Container removeAt(int index) /*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		container.removeAt(index);
		return this;
	}-*/;

	/**
	 * Removes an inner Component at the specified index
	 * 
	 * @param index
	 *            ,The index of the Component to remove.
	 * @return
	 */
	public native Container removeInnerAt(int index) /*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		container.removeInnerAt(index);
		return this;
	}-*/;

	/**
	 * Convience method which calls setMasked with a value of false (to hide the mask)
	 */
	public native void unmask() /*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		container.unmask(scrollable);
	}-*/;

	@Override
	public Iterator<Widget> iterator() {
		List<Widget> list = new ArrayList<Widget>();
		Component[] items = getComponents();
		for (int i = 0; i < items.length; i++) {
			Component item = items[i];
			list.add(item);
		}
		return list.iterator();
	}

	protected native void removeAllNative() /*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		container.removeAll();
	}-*/;

	protected native void removeAllNative(boolean destroy) /*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		container.removeAll(destroy);
	}-*/;

	protected native void removeAllNative(boolean destroy, boolean everything) /*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		container.removeAll(destroy, everything);
	}-*/;

	/**
	 * Fires whenever an item is rendered into a container or derendered from a Container
	 * 
	 * @param handler
	 */
	public CallbackRegistration addRenderChangeHandler(RenderChangeHandler handler) {
		return this.addWidgetListener(TouchAttribute.RENDERED_CHANGE.getValue(), handler.getJsoPeer());
	}

	public CallbackRegistration addActiveItemChangeHandler(ActiveItemChangeHandler handler) {
		return this.addWidgetListener("activeitemchange", handler.getJsoPeer());
	}

	private native void setScrollable(JavaScriptObject scrollable) /*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		container.setScrollable(scrollable);
	}-*/;

	private native void animateActiveItem(int activeItem, JavaScriptObject animation) /*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.ui.Container::getOrCreateJsObj()();
		if (container != null) {
			container.animateActiveItem(activeItem, animation);
		}
	}-*/;

	private native void animateActiveItem(JavaScriptObject activeItem, JavaScriptObject animation) /*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.ui.Container::getOrCreateJsObj()();
		if (container != null) {
			container.animateActiveItem(activeItem, animation);
		}
	}-*/;

	private native void setLayout(JavaScriptObject layout) /*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		container.setLayout(layout);
	}-*/;

	private native void doInsert(int index, JavaScriptObject component) /*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		container.insert(index, component);
	}-*/;

}
