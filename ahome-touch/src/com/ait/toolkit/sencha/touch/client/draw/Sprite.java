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
package com.ait.toolkit.sencha.touch.client.draw;

import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.core.client.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A Surface is an interface to render methods inside a draw Ext.draw.Component.
 * A Surface contains methods to render sprites, get bounding boxes of sprites,
 * add sprites to the canvas, initialize other graphic components, etc. One of
 * the most used methods for this class is the add method, to add Sprites to the
 * surface.
 * <p>
 * Most of the Surface methods are abstract and they have a concrete
 * implementation in VML or SVG engines.
 * <p>
 * A Surface instance can be accessed as a property of a draw component
 */
public class Sprite extends JsObject {

    public Sprite() {
        jsObj = JsoHelper.createObject();
    }

    public Sprite(JavaScriptObject object) {
        super(object);
    }

    public void setType(String type) {
        JsoHelper.setAttribute(jsObj, "type", type);
    }

    public String getType() {
        return JsoHelper.getAttribute(jsObj, "type");
    }

    public void setFill(String fill) {
        JsoHelper.setAttribute(jsObj, "fill", fill);
    }

    public String getFill() {
        return JsoHelper.getAttribute(jsObj, "fill");
    }

    public void setX(double x) {
        JsoHelper.setAttribute(jsObj, "x", x);
    }

    public double getX() {
        return JsoHelper.getAttributeAsFloat(jsObj, "x");
    }

    public void setY(double y) {
        JsoHelper.setAttribute(jsObj, "x", y);
    }

    public double getY() {
        return JsoHelper.getAttributeAsFloat(jsObj, "y");
    }

    public void setRadius(double value) {
        JsoHelper.setAttribute(jsObj, "radius", value);
    }

    public double getRadius() {
        return JsoHelper.getAttributeAsFloat(jsObj, "radius");
    }

    public void setAttributes(SpriteConfig config) {
        setAttributes(config.getJsObj());
    }

    public void setAttributes(SpriteConfig config, boolean update) {
        setAttributes(config.getJsObj(), update);
    }

    private native void setAttributes(JavaScriptObject value)/*-{
		var jso = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		jso.setAttributes(value);
    }-*/;

    private native void setAttributes(JavaScriptObject value, boolean update)/*-{
		var jso = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		jso.setAttributes(value, update);
    }-*/;

}
