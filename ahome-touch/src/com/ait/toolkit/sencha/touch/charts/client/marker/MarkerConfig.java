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
package com.ait.toolkit.sencha.touch.charts.client.marker;

import com.ait.toolkit.sencha.touch.charts.client.Animation;
import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.core.client.JsoHelper;

public abstract class MarkerConfig extends JsObject {

    protected MarkerConfig() {

    }

    public void setSize(int value) {
        JsoHelper.setAttribute(jsObj, "size", value);
    }

    public void setX(int value) {
        JsoHelper.setAttribute(jsObj, "x", value);
    }

    public void setXY(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public void setY(int value) {
        JsoHelper.setAttribute(jsObj, "y", value);
    }

    public void setHeight(int value) {
        JsoHelper.setAttribute(jsObj, "height", value);
    }

    public void setWidth(int value) {
        JsoHelper.setAttribute(jsObj, "width", value);
    }

    public void setScale(double value) {
        JsoHelper.setAttribute(jsObj, "scale", value);
    }

    public void setFx(Animation value) {
        JsoHelper.setAttribute(jsObj, "fx", value.getJsObj());
    }

    public void setAnimationDuration(int duration) {
        Animation animation = new Animation();
        animation.setDuration(duration);
        this.setFx(animation);
    }

    public void setRadius(int value) {
        JsoHelper.setAttribute(jsObj, "radius", value);
    }

    public void setStrokeWidth(int value) {
        JsoHelper.setAttribute(jsObj, "stroke-width", value);
    }

    public void setType(String value) {
        JsoHelper.setAttribute(jsObj, "type", value);
    }

    public void setSrc(String value) {
        JsoHelper.setAttribute(jsObj, "src", value);
    }

}
