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
package com.ait.toolkit.sencha.touch.client.core.config;

/**
 * Controls on which side to display the menu component on the viewport
 */
public enum MenuSide {

    LEFT("left"), TOP("top"), RIGHT("right"), BOTTOM("bottom");

    private String side;

    private MenuSide(String side) {
        this.side = side;
    }

    public String getValue() {
        return this.side;
    }
}
