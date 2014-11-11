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
 * Event types.
 */
public enum Event {

    ACTION("action"), BACK("back"), BEFORE_DESTROY("beforedestroy"), BEFORE_LOAD("beforeload"), BEFORE_SELECT(
                    "beforeselect"), BEFORE_SUBMIT("beforesubmit"), BEFORE_TAP("beforetap"), BLUR("blur"), BOTTOM_CHANGE(
                    "bottomchange"), CANCEL("cancel"), CENTERED_CHANGED("centeredchange"), CHANGE("change"), CHECK(
                    "check"), CLEAR_ICON_TAP("clearicontap"), UNCHECK("uncheck"), DO_SELECT("doselect"), DISABLED_CHANGE(
                    "disabledchange"), DOCKED_CHANGE("dockedchange"), FOCUS("focus"), HEIGHT_CHANGE("heightchange"), HIDE(
                    "hide"), ITEM_DOUBLE_TAP("itemdoubletap"), ITEM_TOUCH_START("itemtouchstart"), ITEM_SWIPE(
                    "itemswipe"), ITEM_TAP("itemtap"), ITEM_TOUCH_END("itemtouchend"), KEY_UP("keyup"), LEFT_CHANGE(
                    "leftchange"), LIST_CHANGE("listchange"), ORIENTATION_CHANGE("orientationchange"), POP("pop"), PICK(
                    "pick"), PUSH("push"), REFRESH("refresh"), RESIZE("resize"), RIGHT_CHANGE("rightchange"), SELECT(
                    "select"), SHOW("show"), SPIN("spin"), SPIN_DOWN("spindown"), SPIN_UP("spinup"), SUBMIT("submit"), TAP(
                    "tap"), TOP_CHANGE("topchange"), TOGGLE("toggle"), WIDTH_CHANGE("widthchange");

    private String value;

    private Event(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
