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

import com.ait.toolkit.sencha.shared.client.core.handlers.CallbackRegistration;
import com.ait.toolkit.sencha.touch.client.core.handlers.button.BeforeTapHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.button.TapHandler;

public interface HasTapHandlers {

    /**
     * Add a TextActionHandler to this button
     * 
     * @param handler
     *            , the callback to be executed when the button is taped on.
     */
    public CallbackRegistration addTapHandler(final TapHandler handler);

    /**
     * Add a BeforeTapHandler to this button
     * 
     * @param handler
     *            , the callback to be executed before the button is taped on.
     */
    public CallbackRegistration addBeforeTapHandler(final BeforeTapHandler handler);

}
