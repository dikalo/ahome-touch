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
package com.ait.toolkit.sencha.touch.client.ui;

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.shared.client.core.XType;
import com.ait.toolkit.sencha.touch.client.draw.Sprite;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Component factory class.
 */
public class ComponentFactory {

    /**
     * Return a Component from the passed native component object.
     * 
     * @param jsObj
     *            native object
     * @return the corresponding Component.
     * @see com.ait.toolkit.sencha.touch.client.core.Component
     */
    public static Component getComponent(JavaScriptObject jsObj) {
        Object componentJ = JsoHelper.getAttributeAsObject(jsObj, "__compJ");
        if (componentJ != null) {
            return (Component) componentJ;
        }

        String xtype = getXType(jsObj);

        if (xtype == null) {
            return null;
        }
        if (xtype.equalsIgnoreCase(XType.ACTONSHEET.getValue())) {
            return new ActionSheet(jsObj);
        } else if (xtype.equalsIgnoreCase(XType.AUDIO.getValue())) {
            return new Audio(jsObj);
        } else if (xtype.equalsIgnoreCase(XType.BUTTON.getValue())) {
            return new Button(jsObj);
        } else if (xtype.equalsIgnoreCase(XType.CAROUSEL.getValue())) {
            return new Carousel(jsObj);
        } else if (xtype.equalsIgnoreCase(XType.CHECKBOX_FIELD.getValue())) {
            return new CheckBox(jsObj);
        } else if (xtype.equalsIgnoreCase(XType.CHART.getValue())) {
            return new CartesianChart(jsObj);
        } else if (xtype.equalsIgnoreCase(XType.CONTAINER.getValue())) {
            return new Container(jsObj);
        }
        return null;
    }

    private static native String getXType(JavaScriptObject jsObj) /*-{
		var xtype = jsObj.xtype ? jsObj.xtype : null;
		return xtype === undefined ? null : xtype;
    }-*/;

    public static JavaScriptObject fromArray(Component[] components) {
        JavaScriptObject array = JsoHelper.createJavaScriptArray();
        for (int i = 0; i < components.length; i++) {
            JavaScriptObject c = components[i].getOrCreateJsObj();
            JsoHelper.setArrayValue(array, i, c);
        }
        return array;
    }

    public static JavaScriptObject fromArrayOfSprite(Sprite[] components) {
        JavaScriptObject array = JsoHelper.createJavaScriptArray();
        for (int i = 0; i < components.length; i++) {
            JavaScriptObject c = components[i].getJsObj();
            JsoHelper.setArrayValue(array, i, c);
        }
        return array;
    }

    public static Component cast(Component component) {
        return getComponent(component.getOrCreateJsObj());
    }

    // TODO Finish me
}
