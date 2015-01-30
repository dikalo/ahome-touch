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

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.ait.toolkit.sencha.touch.client.laf.Alignment;

public class PanelConfig extends ContainerConfig {

	protected PanelConfig() {

	}

	public static native PanelConfig newInstance()/*-{
		return {};
	}-*/;

	public final native void setDockItems(Component items)/*-{
		this.dockedItems = items;
	}-*/;

	public final native void setBodyBorder(String value)/*-{
		this.bodyBorder = value;
	}-*/;

	public final native void setBodyBorder(boolean value)/*-{
		this.bodyBorder = value;
	}-*/;

	public final native void setBodyMargin(String value)/*-{
		this.bodyMargin = value;
	}-*/;

	public final native void setBodyMargin(boolean value)/*-{
		this.bodyMargin = value;
	}-*/;

	public final native void setBodyPadding(String value)/*-{
		this.bodyPadding = value;
	}-*/;

	public final native void setBodyPadding(boolean value)/*-{
		this.bodyPadding = value;
	}-*/;

	public final void setDock(Alignment align) {
		_setDock(align.getValue());
	}

	private final native void _setDock(String value)/*-{
		this.dock = value;
	}-*/;

	public final native void setIconCls(String value)/*-{
		this.iconCls = value;
	}-*/;

}
