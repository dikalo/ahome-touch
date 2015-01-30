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
package com.ait.toolkit.sencha.touch.client.laf;

public enum Direction {
    HORIZONTAL("horizontal"), VERTICAL("vertical"), BOTH("both");

    private String value;

    private Direction(String direction) {
        value = direction;
    }

    public String getValue() {
        return this.value;
    }

    public static Direction fromValue(String direction) {
        if (direction.equalsIgnoreCase(Direction.HORIZONTAL.value)) {
            return Direction.HORIZONTAL;
        } else if (direction.equalsIgnoreCase(Direction.VERTICAL.value)) {
            return Direction.VERTICAL;
        } else if (direction.equalsIgnoreCase(Direction.BOTH.value)) {
            return Direction.BOTH;
        }
        return null;
    }

}
