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
package com.ait.toolkit.sencha.touch.client.ui;

import com.ait.toolkit.sencha.shared.client.core.handlers.CallbackRegistration;
import com.ait.toolkit.sencha.touch.client.core.handlers.map.MapCenterChangeHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.map.MapTypeChangeHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.map.MapZoomChangeHandler;

public interface MapElement {

    /**
     * Returns the value of useCurrentLocation.
     * 
     * @return boolean
     */
    public boolean isUseCurrentLocation();

    /**
     * Sets the value of useCurrentLocation.
     * 
     * @param value
     */
    public void setUseCurrentLocation(boolean value);

    public CallbackRegistration addCenterChangeHandler(MapCenterChangeHandler handler);

    public CallbackRegistration addTypeChangeHandler(MapTypeChangeHandler handler);

    public CallbackRegistration addZoomChangeHandler(MapZoomChangeHandler handler);

}