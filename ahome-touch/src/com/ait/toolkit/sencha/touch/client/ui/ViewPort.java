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
import java.util.List;

import com.ait.toolkit.sencha.shared.client.core.handlers.CallbackRegistration;
import com.ait.toolkit.sencha.touch.client.core.Component;
import com.ait.toolkit.sencha.touch.client.core.config.Event;
import com.ait.toolkit.sencha.touch.client.core.config.MenuConfig;
import com.ait.toolkit.sencha.touch.client.core.config.MenuSide;
import com.ait.toolkit.sencha.touch.client.core.handlers.component.OrientationChangeHandler;
import com.ait.toolkit.sencha.touch.client.layout.card.CardAnimation;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * Viewport is class instance created when Touch4j is loaded. Because Viewport
 * extends from com.ait.toolkit.sencha.touch.client.core.Container, it has as
 * layout (which defaults to CardLayout). This means you can add items to it at
 * any time, from anywhere in your code. The Viewport fullscreen atrribute is
 * true by default, so it will take up your whole screen.
 * 
 * Adding a AcceptsOneWidget interface with an empty setWidget overriden method
 * to fake the operation and allow for a pure GWT Activty And Place
 * implementation.
 * 
 */
public class ViewPort extends Container implements AcceptsOneWidget {

	private final static ViewPort viewPort = initViewPort();
	private Component widget;
	private CardAnimation animation;
	private List<Component> items = new ArrayList<Component>();

	private ViewPort() {

	}

	private ViewPort(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public static ViewPort get() {
		return viewPort;
	}

	public native void attach() /*-{
		@com.ait.toolkit.sencha.touch.client.ui.ViewPort::viewPort.@com.google.gwt.user.client.ui.Widget::onAttach()();
	}-*/;

	private native static ViewPort initViewPort() /*-{
		var viewPort = $wnd.Ext.Viewport;
		var container = @com.ait.toolkit.sencha.touch.client.ui.ViewPort::new(Lcom/google/gwt/core/client/JavaScriptObject;)(viewPort);
		return container;
	}-*/;

	@Override
	public void setWidget(IsWidget w) {
		setWidget(asWidgetOrNull(w));
	}

	public void setWidget(final Widget w) {

		// Validate
		if (w == widget || w == null) {
			return;
		}

		if (w != null) {
			if (animation == null) {
				if (widget != null) {
					widget.hide();
				}
			}

			if (items.indexOf((Component) w) < 0) {
				items.add((Component) w);
				// Physical attach.
				add(w);
			}
			((Component) w).show();
			if (animation != null) {
				animateActiveItem(((Component) w), animation);
				animation = null;
			} else {
				setActiveItem((Container) w);
			}
			// Logical add
			widget = (Component) w;
		}

	}

	/**
	 * @param animation
	 *            the animation to set
	 */
	public void setAnimation(CardAnimation animation) {
		this.animation = animation;
	}

	/**
	 * Whether or not to always automatically maximize the viewPort on first
	 * load and all subsequent orientation changes.
	 * 
	 * This is set to false by default for a number of reasons:
	 * 
	 * <ul>
	 * <li>Orientation change performance is drastically reduced when this is
	 * enabled, on all devices.</li>
	 * <li>On some devices (mostly Android) this can sometimes cause issues when
	 * the default browser zoom setting is changed.</li>
	 * <li>When wrapping your phone in a native shell, you may get a blank
	 * screen.</li>
	 * </ul>
	 * 
	 * @param value
	 */
	public native void setAutoMaximize(boolean value)/*-{
		var viewPort = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		viewPort.setAutoMaximize(value);
	}-*/;

	/**
	 * Returns the current orientation. portrait or landscape
	 * 
	 * @return
	 */
	public native String getOrientation()/*-{
		var viewPort = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return viewPort.getOrientation();
	}-*/;

	/**
	 * true if the viewPort prevents panning
	 * 
	 * @return
	 */
	public native boolean preventPanning()/*-{
		var viewPort = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return viewPort.getPreventPanning();
	}-*/;

	/**
	 * true if the viewPort prevents zooming
	 * 
	 * @return
	 */
	public native boolean preventZooming()/*-{
		var viewPort = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return viewPort.getPreventZooming();
	}-*/;

	/**
	 * Retrieves the document height.
	 * 
	 * @return
	 */
	public native double getWindowHeight()/*-{
		var viewPort = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return viewPort.getWindowHeight();
	}-*/;

	/**
	 * Retrieves the document height.
	 * 
	 * @return
	 */
	public native double getWindowWidth()/*-{
		var viewPort = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return viewPort.getWindowWidth();
	}-*/;

	/**
	 * true to prevent panning on the viewPort
	 * 
	 * @return
	 */
	public native void setPreventPanning(boolean value)/*-{
		var viewPort = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		viewPort.setPreventPanning(value);
	}-*/;

	/**
	 * true to prevent zooming on the viewPort
	 * 
	 * @return
	 */
	public native void setPreventZooming(boolean value)/*-{
		var viewPort = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		viewPort.setPreventZooming(value);
	}-*/;

	/**
	 * Sets a menu for a given side of the Viewport.
	 * <p>
	 * Adds functionality to show the menu by swiping from the side of the
	 * screen from the given side.
	 * <p>
	 * If a menu is already set for a given side, it will be removed.
	 * <p>
	 * Available sides are: left, right, top, and bottom.
	 * 
	 * @param menu
	 *            ,the menu to assign to the viewPort
	 * @param side
	 *            , the side to put the menu on.
	 */

	public void setMenu(Menu menu, MenuSide side) {
		_setMenu(menu, side.getValue(), true, false);
	}

	/**
	 * Sets a menu for a given side of the Viewport.
	 * <p>
	 * Adds functionality to show the menu by swiping from the side of the
	 * screen from the given side.
	 * 
	 * @param menu
	 * @param config
	 */
	public native void setMenu(Menu menu, MenuConfig config)/*-{
		var viewPort = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		viewPort
				.setMenu(
						menu.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()(),
						config.@com.ait.toolkit.core.client.JsObject::getJsObj()());
	}-*/;

	/**
	 * Sets a menu for a given side of the Viewport.
	 * <p>
	 * Adds functionality to show the menu by swiping from the side of the
	 * screen from the given side.
	 * <p>
	 * If a menu is already set for a given side, it will be removed.
	 * <p>
	 * Available sides are: left, right, top, and bottom.
	 * 
	 * @param menu
	 *            ,the menu to assign to the viewPort
	 * @param side
	 *            , the side to put the menu on.
	 * 
	 * @param cover
	 *            , true to cover the viewPort content. Defaults to true.
	 */

	public void setMenu(Menu menu, MenuSide side, boolean cover) {
		_setMenu(menu, side.getValue(), cover, true);
	}

	public void setMenu(Menu menu, MenuSide side, boolean cover, boolean reveal) {
		_setMenu(menu, side.getValue(), cover, reveal);
	}

	/**
	 * Hides all visible menus.
	 */
	public native void hideAllMenus()/*-{
		var viewPort = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		viewPort.hideAllMenus();
	}-*/;

	/**
	 * Hides a menu specified by the menu's side.
	 */
	public void hideMenu(MenuSide side) {
		_hideMenu(side.getValue());
	}

	/**
	 * Shows a menu specified by the menu's side.
	 * 
	 * @param side
	 *            , The side which the menu is placed.
	 */
	public void showMenu(MenuSide side) {
		_showMenu(side.getValue());
	}

	/**
	 * Toggles the menu specified by side
	 * 
	 * @param side
	 *            , The side which the menu is placed.
	 */
	public void toggleMenu(MenuSide side) {
		_toggleMenu(side.getValue());
	}

	/**
	 * Removes a menu from a specified side.
	 * 
	 * @param side
	 *            , The side to remove the menu from
	 */
	public void removeMenu(MenuSide side) {
		_removeMenu(side.getValue());
	}

	/**
	 * Hides all menus except for the side specified
	 */
	public void hideOtherMenus(MenuSide side, String animation) {
		_hideOtherMenus(side.getValue(), animation);
	}

	private native void _hideOtherMenus(String side, String animation)/*-{
		var viewPort = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		viewPort.hideOtherMenus(side, animation);
	}-*/;

	private native void _hideMenu(String side)/*-{
		var viewPort = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		viewPort.hideMenu(side);
	}-*/;

	private native void _removeMenu(String side)/*-{
		var viewPort = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		viewPort.removeMenu(side);
	}-*/;

	private native void _showMenu(String side)/*-{
		var viewPort = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		viewPort.showMenu(side);
	}-*/;

	private native void _toggleMenu(String side)/*-{
		var viewPort = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		viewPort.toggleMenu(side);
	}-*/;

	private native void _setMenu(Menu menu, String menuSide, boolean menuCover,
			boolean menuReveal)/*-{
		var viewPort = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		viewPort
				.setMenu(
						menu.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()(),
						{
							side : menuSide,
							cover : menuCover,
							reveal : menuReveal

						});
	}-*/;

	/**
	 * Fires when the Viewport orientation has changed
	 * 
	 * @param handler
	 */
	public CallbackRegistration addOrientationChangeHandler(
			OrientationChangeHandler handler) {
		return viewPort.addWidgetListener(Event.ORIENTATION_CHANGE.getValue(),
				handler.getJsoPeer());
	}

}
