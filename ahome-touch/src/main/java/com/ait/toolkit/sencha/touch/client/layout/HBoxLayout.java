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
 * The HBox (short for horizontal box) layout makes it easy to position items
 * horizontally in a Container. It can size items based on a fixed width or a
 * fraction of the total width available.
 * 
 * For example, an email client might have a list of messages pinned to the
 * left, taking say one third of the available width, and a message viewing
 * panel in the rest of the screen.
 * 
 */
public class HBoxLayout extends AbstractBox {

    public HBoxLayout() {
        setType(Type.HBOX);
    }

    public HBoxLayout(Pack pack) {
        this();
        setPack(pack);
    }

    public HBoxLayout(Pack pack, Align align) {
        this();
        setPack(pack);
        setAlign(align);
    }

}
