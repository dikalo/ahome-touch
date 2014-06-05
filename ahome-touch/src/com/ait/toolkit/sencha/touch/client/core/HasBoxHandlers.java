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
import com.ait.toolkit.sencha.touch.client.core.handlers.component.BottomChangeHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.component.CenteredChangeHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.component.DockedChangeHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.component.HeightChangeHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.component.LeftChangeHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.component.ResizeHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.component.RightChangeHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.component.TopChangeHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.component.WidthChangeHandler;

public interface HasBoxHandlers {

	public CallbackRegistration addBottomChangeHandler(
			BottomChangeHandler handler);

	public CallbackRegistration addCenteredChangeHandler(
			CenteredChangeHandler handler);

	public CallbackRegistration addDockChangeHandler(DockedChangeHandler handler);

	public CallbackRegistration addHeightChangeHandler(
			HeightChangeHandler handler);

	public CallbackRegistration addLeftChangeHandler(LeftChangeHandler handler);

	public CallbackRegistration addRightChangeHandler(RightChangeHandler handler);

	public CallbackRegistration addTopChangeHandler(TopChangeHandler handler);

	public CallbackRegistration addWidthHandler(WidthChangeHandler handler);

	public CallbackRegistration addResizeHandler(ResizeHandler handler);

}
