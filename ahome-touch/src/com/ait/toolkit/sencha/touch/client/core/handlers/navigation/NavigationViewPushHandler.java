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
package com.ait.toolkit.sencha.touch.client.core.handlers.navigation;

import com.ait.toolkit.sencha.shared.client.core.handlers.AbstractHandler;
import com.ait.toolkit.sencha.touch.client.ui.NavigationView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

@Deprecated
public abstract class NavigationViewPushHandler extends AbstractHandler {

    final JavaScriptObject jsoPeer = createPeer(this);

    private static native JavaScriptObject createPeer(NavigationViewPushHandler listener) /*-{
		return function(source, eOpts) {
			var navView = @com.ait.toolkit.sencha.touch.client.ui.NavigationView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
			listener.@com.ait.toolkit.sencha.touch.client.core.handlers.navigation.NavigationViewPushHandler::fireOnEvent(Lcom/ait/toolkit/sencha/touch/client/ui/NavigationView;Ljava/lang/Object;)(source,eOpts);
		};
    }-*/;

    // Called from JSNI
    private final void fireOnEvent(NavigationView view, Object eOpts) {
        UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
        if (handler != null) {
            fireOnEventAndCatch(view, eOpts, handler);
        } else {
            onPush(view, eOpts);
        }
    }

    private void fireOnEventAndCatch(NavigationView view, Object eOpts, UncaughtExceptionHandler handler) {
        try {
            onPush(view, eOpts);
        } catch (Throwable e) {
            handler.onUncaughtException(e);
        }
    }

    @Override
    public JavaScriptObject getJsoPeer() {
        return jsoPeer;
    }

    public abstract void onPush(NavigationView view, Object eOpts);

}
