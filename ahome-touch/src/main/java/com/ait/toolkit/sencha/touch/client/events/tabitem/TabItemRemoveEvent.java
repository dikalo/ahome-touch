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
package com.ait.toolkit.sencha.touch.client.events.tabitem;

import com.ait.toolkit.sencha.touch.client.ui.TabItem;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class TabItemRemoveEvent extends GwtEvent<TabItemRemoveEvent.Handler> {

    public static final Type<Handler> TYPE = new Type<Handler>();
    private TabItem tabItem;
    
    public TabItemRemoveEvent(TabItem tabItem) {
        this.tabItem = tabItem;
    }
    
    public interface Handler extends EventHandler {
        public void onTabItemRemove(TabItemRemoveEvent event);
    }

    @Override
    protected void dispatch(Handler handler) {
        handler.onTabItemRemove(this);
    }

    @Override
    public Type<Handler> getAssociatedType() {
        return TYPE;
    }

    public TabItem getTabItem() {
        return tabItem;
    }
    
}
