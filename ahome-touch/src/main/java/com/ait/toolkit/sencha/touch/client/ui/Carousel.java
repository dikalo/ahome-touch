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

import com.ait.toolkit.sencha.touch.client.core.HasUi;
import com.ait.toolkit.sencha.shared.client.core.XType;
import com.ait.toolkit.sencha.touch.client.laf.Direction;
import com.ait.toolkit.sencha.touch.client.laf.UI;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Carousels, like tabs, are a great way to allow the user to swipe through
 * multiple full-screen pages. A Carousel shows only one of its pages at a time
 * but allows you to swipe through with your finger. <br>
 * <br>
 * Carousels can be oriented either horizontally or vertically and are easy to
 * configure - they just work like any other Container.
 * 
 * @see <a
 *      href=http://docs.sencha.com/touch/2-0/#!/api/Ext.carousel.Carousel>Ext
 *      .carousel.Carousel</a>
 */
public class Carousel extends Container implements HasUi, HasDirection, Navigable {

    @Override
    protected native void init()/*-{
		var c = new $wnd.Ext.Carousel();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
    }-*/;

    /**
     * Create a new Carousel.
     */
    public Carousel() {

    }

    protected Carousel(JavaScriptObject obj) {
        super(obj);
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.Carousel(config);
    }-*/;

    @Override
    public String getXType() {
        return XType.CAROUSEL.getValue();
    }

    /**
     * Returns the index of the currently active card.
     * 
     * @return
     */
    public native int getActiveIndex() /*-{
		var carousel = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (carousel != null) {
			return carousel.getActiveIndex();
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.ait.toolkit.sencha.touch.client.containers.HasDirection#getDirection()
     */
    @Override
    public Direction getDirection() {
        return Direction.valueOf(_getDirection().toUpperCase());
    }

    /**
     * Returns the value of indicator.
     * 
     * @return
     */
    public native boolean getIndicator() /*-{
		var carousel = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (carousel != null) {
			return carousel.getIndicator();
		}
    }-*/;

    /**
     * Returns the value of ui.
     * 
     * @return
     */
    @Override
    public UI getUi() {
        return UI.fromValue(_getUI());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ait.toolkit.sencha.touch.client.containers.Navigable#next()
     */
    @Override
    public native Carousel next() /*-{
		var carousel = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (carousel != null) {
			return carousel.next();
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.ait.toolkit.sencha.touch.client.containers.Navigable#previous()
     */
    @Override
    public native Carousel previous() /*-{
		var carousel = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (carousel != null) {
			return carousel.previous();
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ait.toolkit.sencha.touch.client.containers.HasDirection#setDirection(com
     * .emitrom.gwt4.touch.client.laf.Direction)
     */
    @Override
    public void setDirection(Direction direction) {
        setDirection(direction.getValue());
    }

    /**
     * Sets the value of indicator.
     * 
     * @param indicator
     */
    public native void setIndicator(boolean indicator) /*-{
		var carousel = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (carousel != null) {
			carousel.setIndicator(indicator);
		}
    }-*/;

    /**
     * Sets the value of ui.
     */
    @Override
    public void setUi(UI ui) {
        setUI(ui.getValue());
    }

    public native void setUI(String ui) /*-{
		var carousel = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (carousel != null) {
			carousel.setUi(ui);
		}
    }-*/;

    public native void setDirection(String direction) /*-{
		var carousel = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (carousel != null) {
			carousel.setDirection(direction);
		}
    }-*/;

    private native String _getDirection() /*-{
		var carousel = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (carousel != null) {
			return carousel.getDirection();
		}
    }-*/;

    private native String _getUI() /*-{
		var carousel = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (carousel != null) {
			return carousel.getUi();
		}
    }-*/;

}