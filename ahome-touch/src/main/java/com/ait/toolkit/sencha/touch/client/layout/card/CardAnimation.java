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
package com.ait.toolkit.sencha.touch.client.layout.card;

import com.ait.toolkit.core.client.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

public class CardAnimation {
	protected JavaScriptObject jso;

	public CardAnimation() {
		create();
	}

	public CardAnimation(AnimationType type) {
		this();
		setType(type);
	}

	public CardAnimation(AnimationType type, Direction direction) {
		this(type);
		setDirection(direction);
	}

	public CardAnimation(AnimationType type, Direction direction, int duration) {
		this(type, direction);
		setDuration(duration);
	}

	public CardAnimation(AnimationType type, int duration) {
		this(type);
		setDuration(duration);
	}

	CardAnimation(JavaScriptObject obj) {
		jso = obj;
	}

	/**
	 * @return the jso
	 */
	public JavaScriptObject getJSO() {
		return jso;
	}

	public void setType(AnimationType animationType) {
		setType(animationType.getValue());
	}

	public void setDirection(Direction direction) {
		setDirection(direction.getValue());
	}

	private void create() {
		jso = JsoHelper.createObject();
	}

	public native void setType(String value) /*-{
		var jso = this.@com.ait.toolkit.sencha.touch.client.layout.card.CardAnimation::getJSO()();
		jso.type = value;
	}-*/;

	public native void setDirection(String value) /*-{
		var jso = this.@com.ait.toolkit.sencha.touch.client.layout.card.CardAnimation::getJSO()();
		jso.direction = value;
	}-*/;

	public native void setDuration(int value) /*-{
		var jso = this.@com.ait.toolkit.sencha.touch.client.layout.card.CardAnimation::getJSO()();
		jso.duration = value;
	}-*/;

	public native void setReverse(boolean value) /*-{
		var jso = this.@com.ait.toolkit.sencha.touch.client.layout.card.CardAnimation::getJSO()();
		if (jso.setReverse) {
			jso.setReverse(value);
		}
	}-*/;
}
