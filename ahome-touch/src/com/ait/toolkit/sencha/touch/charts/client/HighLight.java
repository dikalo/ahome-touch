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
package com.ait.toolkit.sencha.touch.charts.client;

import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.core.client.JsoHelper;

public class HighLight extends JsObject {

    public HighLight() {
        jsObj = JsoHelper.createObject();
    }

    public HighLight(int size, int radius) {
        this();
        setSize(size);
        setRadius(radius);
    }

    public void setSize(int value) {
        JsoHelper.setAttribute(jsObj, "size", value);
    }

    public void setRadius(int value) {
        JsoHelper.setAttribute(jsObj, "radius", value);
    }

    public void setSegment(Segment segment) {
        JsoHelper.setAttribute(jsObj, "segment", segment.getJsObj());
    }

}
