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

import com.ait.toolkit.sencha.shared.client.core.ExtCore;
import com.ait.toolkit.sencha.shared.client.dom.ExtElement;
import com.google.gwt.dom.client.Element;

public class Ext extends ExtCore {

	private Ext() {

	}

	/**
	 * Attempts to destroy the component passed to it by removing all event
	 * listeners, removing them from the DOM (if applicable) and calling their
	 * destroy functions (if available).
	 * 
	 * @param component
	 *            the component to destroy
	 */
	public static native void destroy(Component component) /*-{
		var comp = component.@com.ait.toolkit.sencha.touch.client.core.Component::getJsObj()();
		$wnd.Ext.destroy(comp);
	}-*/;

	/**
	 * Returns a component by id. Shorthand for
	 * {@link ComponentMgr#getComponent(String)}.
	 * 
	 * @param id
	 *            the component ID
	 * @return the Component
	 */
	public static Component getCmp(String id) {
		return ComponentMgr.getComponent(id);
	}

	/**
	 * Returns a component that the passed element represents. Shorthand for
	 * {@link ComponentMgr#getComponent(Element)}.
	 * 
	 * @param element
	 *            the component's element
	 * @return the Component
	 */
	public static Component getCmp(Element element) {
		return ComponentMgr.getComponent(element);
	}

	/**
	 * Returns a component that the passed element represents. Shorthand for
	 * {@link ComponentMgr#getComponent(ExtElement)}.
	 * 
	 * @param element
	 *            the component's element
	 * @return the Component
	 */
	public static Component getCmp(ExtElement element) {
		return ComponentMgr.getComponent(element);
	}

}
