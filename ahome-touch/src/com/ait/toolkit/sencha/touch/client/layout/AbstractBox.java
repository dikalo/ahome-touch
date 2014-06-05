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
package com.ait.toolkit.sencha.touch.client.layout;

public class AbstractBox extends AbstractLayout {

    public AbstractBox() {
    }

    public AbstractBox(Align align, Pack pack) {
        this();
        setAlign(align);
        setPack(pack);
    }

    @Override
    public void setType(Type type) {
        setType(type.getValue());
    }

    private native void setType(String value) /*-{
		var jso = this.@com.ait.toolkit.sencha.touch.client.layout.AbstractLayout::getJSO()();
		jso.type = value;
    }-*/;

}
