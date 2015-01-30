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
import com.ait.toolkit.sencha.touch.client.draw.Sprite;
import com.ait.toolkit.sencha.touch.client.draw.Surface;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;

/**
 * The Draw Component is a surface in which sprites can be rendered. The Draw
 * Component manages and holds a Surface instance: an interface that has an SVG
 * or VML implementation depending on the browser capabilities and where Sprites
 * can be appended.
 * 
 */
public class DrawComponent extends Container {

    private static JavaScriptObject configPrototype;

    protected native void init()/*-{
		var c = new $wnd.Ext.draw.Component({
			enginePriority : [ "Svg", "Vml" ]
		});
		@com.ait.toolkit.sencha.touch.client.ui.DrawComponent::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.DRAW.getValue();
    }

    /**
     * Create a new Panel.
     */
    public DrawComponent() {
        // init();
        // createSurface();
    }

    protected DrawComponent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Applys the Panel to an existing element.
     * 
     * @param element
     *            the element
     */
    public DrawComponent(Element element) {
        super(element);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		config.enginePriority = [ "Svg", "Vml" ];
		return new $wnd.Ext.draw.Component(config);
    }-*/;

    /**
     * create the component surface
     */
    public native void createSurface() /*-{
		var draw = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		draw.createSurface();
    }-*/;

    public native Surface getSurface()/*-{
		var draw = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var surface = draw.surface;
		return @com.ait.toolkit.sencha.touch.client.draw.Surface::new(Lcom/google/gwt/core/client/JavaScriptObject;)(surface);
    }-*/;

    public Sprite add(Sprite sprite) {
        return getSurface().add(sprite);
    }

    public void setViewBox(boolean value) {
        setAttribute("viewBox", value, true);
    }

    /**
     * A single item, or an array of child Components to be added to this
     * container
     */
    public void setItems(Sprite... items) {
        setAttribute("items", ComponentFactory.fromArrayOfSprite(items), true);
    }

}
