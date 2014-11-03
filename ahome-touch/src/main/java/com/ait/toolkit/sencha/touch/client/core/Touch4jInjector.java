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

import com.ait.toolkit.application.client.JavaScriptLoadCallback;
import com.ait.toolkit.application.client.ResourceInjector;
import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.shared.client.core.ExtCore;

/**
 * Utility class to inject Touch4j resources. This class should be used while
 * developing for different devices and form factors. The class will help you
 * inject Touch4j on demand
 * 
 */
public class Touch4jInjector extends ResourceInjector {

	public Touch4jInjector(String touchCSSLink, String touchJsLink) {
		super(touchCSSLink, touchJsLink);
	}

	public void inject(final InitHandler handler) {
		this.setJsLoadCallback(new JavaScriptLoadCallback() {
			@Override
			public void onJsLoaded() {
				linkElement.setId(ExtCore.AIT_MAIN_EXT_THEME_ID);
				JsoHelper
						.setAttribute(scriptElement, "id", ExtCore.AIT_MAIN_EXT_JS_ID);
				Touch.init(handler);
			}
		}).inject();
	}

	public void inject(final TouchConfig config) {
		this.setJsLoadCallback(new JavaScriptLoadCallback() {
			@Override
			public void onJsLoaded() {
				Touch.init(config);
			}
		}).inject();
	}
}
