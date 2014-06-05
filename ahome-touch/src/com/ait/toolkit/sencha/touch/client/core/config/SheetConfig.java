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
package com.ait.toolkit.sencha.touch.client.core.config;

import com.ait.toolkit.sencha.touch.client.laf.Alignment;
import com.google.gwt.core.client.JavaScriptObject;

public class SheetConfig extends PanelConfig {

	protected SheetConfig() {

	}

	public static native SheetConfig newInstance()/*-{
		return {};
	}-*/;

	public final void setEnter(Alignment align) {
		_setEnter(align.getValue());
	}

	private final native void _setEnter(String value)/*-{
		this.enter = value;
	}-*/;

	public final native void setEnterAnimation(String value)/*-{
		this.enterAnimation = value;
	}-*/;

	protected final native void setEnterAnimation(JavaScriptObject value)/*-{
		this.enterAnimation = value;
	}-*/;

	public final void setExit(Alignment align) {
		_setExit(align.getValue());
	}

	private final native void _setExit(String value)/*-{
		this.exit = value;
	}-*/;

	public final native void setExitAnimation(String value)/*-{
		this.exitAnimation = value;
	}-*/;

	protected final native void setExitAnimation(JavaScriptObject value)/*-{
		this.exitAnimation = value;
	}-*/;

	public final native void setStretchX(boolean value)/*-{
		this.stretchX = value;
	}-*/;

	public final native void setStretchY(boolean value)/*-{
		this.stretchY = value;
	}-*/;

}
