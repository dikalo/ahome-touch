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
package com.ait.toolkit.sencha.touch.client.dataview;

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.google.gwt.core.client.JavaScriptObject;

public class SimpleListItem extends Component {

    @Override
    public String getText() {
        // TODO Auto-generated method stub
        return null;
    }

    protected SimpleListItem() {

    }

    protected SimpleListItem(JavaScriptObject obj) {
        super(obj);
    }

    @Override
    public void setText(String text) {
        // TODO Auto-generated method stub

    }

    @Override
    protected void init() {
        // TODO Auto-generated method stub

    }

    public static SimpleListItem from(JavaScriptObject peer) {
        return new SimpleListItem(peer);
    }

    @Override
    protected JavaScriptObject create(JavaScriptObject config) {
        // TODO Auto-generated method stub
        return null;
    }

}
