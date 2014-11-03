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
package com.ait.toolkit.sencha.touch.client.layout;

import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.touch.client.layout.card.AnimationType;
import com.ait.toolkit.sencha.touch.client.layout.card.CardAnimation;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * The Default Layout is the layout that all other layouts inherit from. The
 * main capability it provides is docking, which means that every other layout
 * can also provide docking support. It's unusual to use Default layout
 * directly, instead it's much more common to use one of the sub classes:
 * 
 * {@link HBoxLayout} {@link VBoxLayout} {@link CardLayout} {@link FitLayout}
 */
public class AbstractLayout {

	protected JavaScriptObject jso;
	private CardAnimation animation;

	public AbstractLayout() {
		create();
	}

	AbstractLayout(JavaScriptObject obj) {
		jso = obj;
	}

	protected void setType(Type type) {

	}

	/**
	 * @return the JSO
	 */
	public JavaScriptObject getJSO() {
		return jso;
	}

	private void create() {
		jso = JsoHelper.createObject();
	}

	public native CardAnimation getAnimation() /*-{
		var jso = this.@com.ait.toolkit.sencha.touch.client.layout.AbstractLayout::getJSO()();
		var obj = jso.getAnimation();
		var toReturn = @com.ait.toolkit.sencha.touch.client.layout.card.CardAnimation::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
	}-*/;

	public void setAnimation(CardAnimation animation) {
		this.animation = animation;
		setAnimation(animation.getJSO());
	}

	public void setAnimation(AnimationType type) {
		_setAnimation(type.getValue());
	}

	private native void _setAnimation(String value) /*-{
		var jso = this.@com.ait.toolkit.sencha.touch.client.layout.AbstractLayout::getJSO()();
		if (jso.setAnimation) {
			jso.setAnimation(value);
		} else {
			jso.animation = value;
		}
	}-*/;

	private native void setAnimation(JavaScriptObject value) /*-{
		var jso = this.@com.ait.toolkit.sencha.touch.client.layout.AbstractLayout::getJSO()();
		if (jso.setAnimation) {
			jso.setAnimation(value);
		} else {
			jso.animation = value;
		}
	}-*/;

	public void update(JavaScriptObject obj) {
		jso = obj;
	}

	public void setAlign(Align align) {
		setAlign(align.getValue());
	}

	private native void setAlign(String value) /*-{
		var jso = this.@com.ait.toolkit.sencha.touch.client.layout.AbstractLayout::getJSO()();
		if (jso.setAlign) {
			jso.setAlign(value);
		} else {
			jso.align = value;
		}
	}-*/;

	public void setPack(Pack pack) {
		setPack(pack.getValue());
	}

	private native void setPack(String value) /*-{
		var jso = this.@com.ait.toolkit.sencha.touch.client.layout.AbstractLayout::getJSO()();
		if (jso.setPack) {
			jso.setPack(value);
		} else {
			jso.pack = value;
		}
	}-*/;

}