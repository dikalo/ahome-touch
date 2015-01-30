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

import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.shared.client.fx.Animation;
import com.ait.toolkit.sencha.touch.client.laf.Direction;
import com.google.gwt.core.client.JavaScriptObject;

public class Scroller extends JsObject {

	public Scroller() {
		jsObj = JsoHelper.createObject();
	}

	public Scroller(Direction direction) {
		this();
		setDirection(direction.getValue());
	}

	public final native String getDirection() /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return peer.direction;
	}-*/;

	public final native boolean getDirectionLock() /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return peer.directionLock;
	}-*/;

	public final native boolean getDisabled() /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return peer.disabled;
	}-*/;

	public final native <T> T getMomentumEasing() /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return peer.momentumEasing;
	}-*/;

	public final native <T> T getSlotSnapSize() /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return peer.slotSnapSize;
	}-*/;

	public final native boolean isAxisEnabled(String axis) /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return peer.isAxisEnabled(axis);
	}-*/;

	public final native void scrollBy(int x, int y) /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.scrollBy(x, y);
	}-*/;

	public final native void scrollBy(int x, int y, boolean animate) /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.scrollBy(x, y, animate);
	}-*/;

	public final native void scrollBy(int x, int y, Animation animation) /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.scrollBy(x, y,
				animation.@com.ait.toolkit.core.client.JsObject::getJsObj()());
	}-*/;

	public final native void scrollTo(int x, int y) /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.scrollTo(x, y);
	}-*/;

	public final native void scrollTo(int x, int y, boolean animate) /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.scrollTo(x, y, animate);
	}-*/;

	public final native void scrollTo(int x, int y, Animation animation) /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.scrollTo(x, y,
				animation.@com.ait.toolkit.core.client.JsObject::getJsObj()());
	}-*/;

	public final native void scrollToEnd(Animation animation) /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.scrollToEnd(animation.@com.ait.toolkit.core.client.JsObject::getJsObj()());
	}-*/;

	public final native void setDirection(String direction) /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.direction = direction;
	}-*/;

	public final void setDirection(Direction direction) {
		setDirection(direction.getValue());
	}

	public final native void setDirectionLock(boolean lock) /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.directionLock = lock;
	}-*/;

	public final native void setDisabled(boolean value) /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.setDisabled = value;
	}-*/;

	public final native void setOutOfBoundRestrictFactor(double value) /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.outOfBoundRestrictFactor = value;
	}-*/;

	public final native void setInitialOffset(double value) /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.setInitialOffset(value);
	}-*/;

	public final native void setInitialOffset(JavaScriptObject value) /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.setInitialOffset(value);
	}-*/;

	public final native void setMomentumEasing(JavaScriptObject value) /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.setMomentumEasing(value);
	}-*/;

	public final native void setSlotSnapEasing(JavaScriptObject value) /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.setSlotSnapEasing(value);
	}-*/;

	public final native void setSlotSnapSize(JavaScriptObject value) /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.setSlotSnapSize(value);
	}-*/;

	public final native void setSlotSnapSize(double value) /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.setSlotSnapSize(value);
	}-*/;

}