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


/**
 * Constants to use for the showBy methods
 */
public enum ShowByAlignment {
    
	/* The center of the bottom edge */
    BOTTOM("b"),
    /* The bottom left corner */
    BOTTOM_LEFT("bl"),
    /* The bottom left corner */
    BOTTOM_RIGHT("br"), 
    /*In the center of the element*/
    CENTER("c"),
    /*In the center of the left edge*/
    CENTER_LEFT("l"),
    /*In the center of the top edge*/
    CENTER_TOP("t"),
    /* The center of the right edge */
    CENTER_RIGHT("r"),
    /* The top right corner */
    TOP_RIHGT("tr"),
    /* The top left corner */
    TOP_LEFT("tl");

    private String value;

    private ShowByAlignment(String alignment) {
        value = alignment;
    }

    public String getValue() {
        return this.value;
    }

}
