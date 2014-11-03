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

/**
 * Sometimes you want to show several screens worth of information but you've
 * only got a small screen to work with. TabPanels and Carousels both enable you
 * to see one screen of many at a time, and underneath they both use a Card
 * Layout.
 * 
 * Card Layout takes the size of the Container it is applied to and sizes the
 * currently active item to fill the Container completely. It then hides the
 * rest of the items, allowing you to change which one is currently visible but
 * only showing one at once
 * 
 */
public class CardLayout extends FitLayout {

    public CardLayout() {
        super();
        setType(Type.CARD);
    }

    public void setAlign(Align align) {
        setAlign(align.getValue());
    }

    private native void setAlign(String value) /*-{
		var jso = this.@com.ait.toolkit.sencha.touch.client.layout.AbstractLayout::getJSO()();
		jso.align = value;
    }-*/;

    public void setPack(Pack pack) {
        setPack(pack.getValue());
    }

    private native void setPack(String value) /*-{
		var jso = this.@com.ait.toolkit.sencha.touch.client.layout.AbstractLayout::getJSO()();
		jso.pack = value;
    }-*/;

}