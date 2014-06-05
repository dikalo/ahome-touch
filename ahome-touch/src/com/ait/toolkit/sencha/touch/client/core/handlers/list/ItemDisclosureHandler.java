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
package com.ait.toolkit.sencha.touch.client.core.handlers.list;

import com.ait.toolkit.sencha.shared.client.core.handlers.AbstractHandler;
import com.ait.toolkit.data.client.BaseModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class ItemDisclosureHandler extends AbstractHandler {

    final JavaScriptObject jsoPeer = createPeer(this);

    private static native JavaScriptObject createPeer(ItemDisclosureHandler listener) /*-{
		return function(record, node, index) {
			var model = @com.ait.toolkit.data.client.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
			listener.@com.ait.toolkit.sencha.touch.client.core.handlers.list.ItemDisclosureHandler::fireOnEvent(Lcom/ait/toolkit/data/client/BaseModel;Lcom/google/gwt/core/client/JavaScriptObject;I)(model, node, index);
		};
    }-*/;

    // Called from JSNI
    private final void fireOnEvent(BaseModel record, JavaScriptObject node, int index) {
        UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
        if (handler != null) {
            fireOnEventAndCatch(record, node, index, handler);
        } else {
            onItemDisclosure(record, node, index);
        }
    }

    private void fireOnEventAndCatch(BaseModel record, JavaScriptObject node, int index,
                    UncaughtExceptionHandler handler) {
        try {
            onItemDisclosure(record, node, index);
        } catch (Throwable e) {
            handler.onUncaughtException(e);
        }
    }

    @Override
    public JavaScriptObject getJsoPeer() {
        return jsoPeer;
    }

    public abstract void onItemDisclosure(BaseModel record, JavaScriptObject node, int index);
}
