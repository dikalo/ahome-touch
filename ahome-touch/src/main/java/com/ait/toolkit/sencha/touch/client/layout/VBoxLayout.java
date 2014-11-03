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
 * The VBox (short for vertical box) layout makes it easy to position items
 * horizontally in a Container. It can size items based on a fixed height or a
 * fraction of the total height available.
 * 
 * For example, let's say we want a banner to take one third of the available
 * height, and an information panel in the rest of the screen.
 * 
 */
public class VBoxLayout extends AbstractBox {

    public VBoxLayout() {
        setType(Type.VBOX);
    }

    public VBoxLayout(Pack pack) {
        this();
        setPack(pack);
    }

    public VBoxLayout(Pack pack, Align align) {
        this();
        setPack(pack);
        setAlign(align);
    }

}
