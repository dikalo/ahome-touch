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
package com.ait.toolkit.sencha.touch.charts.client.interactions;

import com.ait.toolkit.core.client.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

public class Rotate extends AbstractInteraction {

    public Rotate() {
        jsObj = JsoHelper.createObject();
        setType(InteractionType.ROTATE);
    }

    Rotate(JavaScriptObject obj) {
        jsObj = obj;
    }

    public native void setGesture(String value)/*-{
		var jso = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		if (jso.setGesture) {
			jso.setGesture(value);
		} else {
			jso.gesture = value;
		}
    }-*/;

    public static Rotate cast(AbstractInteraction peer) {
        return new Rotate(peer.getJsObj());
    }

}
