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
package com.ait.toolkit.sencha.touch.client.core.handlers.dataview;

import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.shared.client.core.handlers.AbstractHandler;
import com.ait.toolkit.data.client.BaseModel;
import com.ait.toolkit.sencha.touch.client.ui.DataView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;

public abstract class DataViewItemTapHandler extends AbstractHandler {

    final JavaScriptObject jsoPeer = createPeer(this);

    private static native JavaScriptObject createPeer(DataViewItemTapHandler listener) /*-{
		return function(source, index, element, record, e, eOpts) {
			var dataView = @com.ait.toolkit.sencha.touch.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
			var model = @com.ait.toolkit.data.client.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
			var event = @com.ait.toolkit.sencha.shared.client.core.EventObject::new(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
			listener.@com.ait.toolkit.sencha.touch.client.core.handlers.dataview.DataViewItemTapHandler::fireOnEvent(Lcom/ait/toolkit/sencha/touch/client/ui/DataView;ILcom/google/gwt/user/client/Element;Lcom/ait/toolkit/data/client/BaseModel;Lcom/ait/toolkit/sencha/shared/client/core/EventObject;Ljava/lang/Object;)(dataView, index, element, model, event, eOpts);
		};
    }-*/;

    // Called from JSNI
    private final void fireOnEvent(DataView dataView, int index, Element element, BaseModel record,
                    EventObject eventObject, Object eOpts) {
        UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();

        if (handler != null) {
            fireOnEventAndCatch(dataView, index, element, record, eventObject, eOpts, handler);
        } else {
            onItemTap(dataView, index, element, record, eventObject, eOpts);
        }
    }

    private void fireOnEventAndCatch(DataView dataView, int index, Element element, BaseModel record,
                    EventObject eventObject, Object eOpts, UncaughtExceptionHandler handler) {
        try {
            onItemTap(dataView, index, element, record, eventObject, eOpts);
        } catch (Throwable e) {
            handler.onUncaughtException(e);
        }
    }

    @Override
    public JavaScriptObject getJsoPeer() {
        return jsoPeer;
    }

    public abstract void onItemTap(DataView dataView, int index, Element element, BaseModel record,
                    EventObject eventObject, Object eOpts);

}
