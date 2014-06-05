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
package com.ait.toolkit.sencha.touch.client.core.handlers.component;

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.ait.toolkit.sencha.shared.client.core.handlers.AbstractHandler;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class ResizeHandler extends AbstractHandler {

    final JavaScriptObject jsoPeer = createPeer(this);

    private static native JavaScriptObject createPeer(ResizeHandler listener) /*-{
		return function(c, eOpts) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.Container::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			listener.@com.ait.toolkit.sencha.touch.client.core.handlers.component.ResizeHandler::fireOnEvent(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/Object;)(comp, eOpts);
		};
    }-*/;

    // Called from JSNI
    private final void fireOnEvent(Component component, Object eOpts) {
        UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
        if (handler != null) {
            fireOnEventAndCatch(component, eOpts, handler);
        } else {
            onResize(component, eOpts);
        }
    }

    private void fireOnEventAndCatch(Component component, Object eOpts, UncaughtExceptionHandler handler) {
        try {
            onResize(component, eOpts);
        } catch (Throwable e) {
            handler.onUncaughtException(e);
        }
    }

    @Override
    public JavaScriptObject getJsoPeer() {
        return jsoPeer;
    }

    public abstract void onResize(Component component, Object eOpts);

}
