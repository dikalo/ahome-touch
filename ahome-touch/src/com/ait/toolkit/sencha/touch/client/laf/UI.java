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

public enum UI {

    NEUTRAL("neutral"), NORMAL("normal"), NORMAL_SMALL("normal-small"), NORMAL_ROUND("normal-round"), BACK("back"), BACK_SMALL(
                    "back-small"), FORWARD("forward"), FORWARD_SMALL("forward-small"), ROUND("round"), ROUND_SMALL(
                    "round-small"), DECLINE("decline"), DECLINE_SMALL("decline-small"), DECLINE_ROUND("decline-round"), CONFIRM(
                    "confirm"), CONFIRM_SMALL("confirm-small"), CONFIRM_ROUND("confirm-round"), ACTION("action"), ACTION_SMALL(
                    "action-small"), ACTION_ROUND("action-round"), DARK("dark"), LIGHT("light"), GREEN("green"), PLAIN(
                    "plain"), SMALL("small");

    private String ui;

    private UI(String value) {
        ui = value;
    }

    public String getValue() {
        return ui;
    }

    public static UI fromValue(String value) {
        String upperCasedValue = value.replace("-", "_").toUpperCase();
        return UI.valueOf(upperCasedValue);
    }

}
