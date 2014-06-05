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
package com.ait.toolkit.sencha.touch.client.core;

import com.ait.toolkit.sencha.touch.client.ui.Button.IconAlign;

public interface HasIcon {

    /**
     * A css class which sets a background image to be used as the icon for this
     * button (defaults to undefined).
     * 
     * @param value
     */
    public void setIconCls(Icons value);
    
    /**
     * Returns the value of icon.
     * 
     * @return
     */
    public String getIcon();

    /**
     * Returns the value of iconAlign.
     * 
     * @return
     */
    public String getIconAlign();

    /**
     * @return the icon CSS class for this Button
     */
    public String getIconCls();

    /**
     * @return the value of iconMask.
     */
    public String getIconMaskCls();

    /**
     * Sets the value of icon.
     * 
     * @param value
     */
    public void setIcon(String value);

    /**
     * Sets the value of iconAlign.
     * 
     * @param value
     */
    public void setIconAlign(String value);

    public void setIconAlign(IconAlign align);

    /**
     * Sets the value of iconMask.
     * 
     * @param value
     */
    public void setIconMask(boolean value);

    /**
     * Sets the value of iconMaskCls.
     * 
     * @param value
     */
    public void setIconMaskCls(String value);

}
