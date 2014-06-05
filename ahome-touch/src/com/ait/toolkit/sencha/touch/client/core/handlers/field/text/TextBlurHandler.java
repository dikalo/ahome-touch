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
package com.ait.toolkit.sencha.touch.client.core.handlers.field.text;

import com.ait.toolkit.sencha.shared.client.core.handlers.AbstractHandler;
import com.ait.toolkit.sencha.touch.client.ui.Text;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class TextBlurHandler extends AbstractHandler {

    final JavaScriptObject jsoPeer = createPeer(this);

    private static native JavaScriptObject createPeer(TextBlurHandler listener) /*-{
		return function(source, event, eOpts) {
			var textField = @com.ait.toolkit.sencha.touch.client.ui.Text::new(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
			listener.@com.ait.toolkit.sencha.touch.client.core.handlers.field.text.TextBlurHandler::fireOnEvent(Lcom/ait/toolkit/sencha/touch/client/ui/Text;Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/Object;)(textField, event, eOpts);
		};
    }-*/;

    // Called from JSNI
    private final void fireOnEvent(Text<String> text, JavaScriptObject event, Object eOpts) {
        UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
        if (handler != null) {
            fireOnEventAndCatch(text, event, eOpts, handler);
        } else {
            onBlur(text, event, eOpts);
        }
    }

    private void fireOnEventAndCatch(Text<String> text, JavaScriptObject event, Object eOpts,
                    UncaughtExceptionHandler handler) {
        try {
            onBlur(text, event, eOpts);
        } catch (Throwable e) {
            handler.onUncaughtException(e);
        }
    }

    @Override
    public JavaScriptObject getJsoPeer() {
        return jsoPeer;
    }

    public abstract void onBlur(Text<String> text, JavaScriptObject event, Object eOpts);

}
