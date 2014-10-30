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
package com.ait.toolkit.sencha.touch.client.layout.card;

/**
 * To be used with http://docs.sencha.com/touch/2-0/#!/api/Ext.Anim
 */
public enum Easing {

    EASE("ease"), LINEAR("linear"), EASE_IN("easeIn"), EASE_OUT("easeOut"), EASE_IN_OUT("easeInOut"), BOUNCE_OUT(
                    "bounceOut"), ELASTIC_IN("elasticIn"), BACK_IN_OUT("backInOut");

    private String value;

    private Easing(String easing) {
        this.value = easing;
    }

    public String getValue() {
        return value;
    }

    public static Easing fromValue(String value) {
        String upperCasedValue = value.replace("-", "_").toUpperCase();
        return Easing.valueOf(upperCasedValue);
    }

}
