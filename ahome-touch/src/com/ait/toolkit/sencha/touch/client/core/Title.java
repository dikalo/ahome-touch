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

import com.ait.toolkit.sencha.shared.client.core.XType;
import com.ait.toolkit.sencha.touch.client.core.config.TouchAttribute;
import com.ait.toolkit.sencha.touch.client.ui.TitleBar;
import com.ait.toolkit.sencha.touch.client.ui.ToolBar;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * 
 This classed is used for the {@link ToolBar} title configuration in the
 * {@link TitleBar} component.
 * 
 */
public class Title extends Component {

	@Override
	protected void init() {

	}

	public Title() {

	}

	public Title(JavaScriptObject obj) {
		super(obj);
	}

	@Override
	public String getXType() {
		return XType.TITLE.getValue();
	}

	@Override
	protected JavaScriptObject create(JavaScriptObject config) {
		return null;
	}

	/**
	 * sets the title
	 * 
	 * @param value
	 */
	public void setTitle(String value) {
		setAttribute(TouchAttribute.TITLE.getValue(), value, true);
	}

	/**
	 * gets the title
	 */
	public String getTitle() {
		return getAttribute(TouchAttribute.TITLE.getValue());
	}

	@Override
	public String getText() {
		return this.getTitle();
	}

	@Override
	public void setText(String text) {
		this.setTitle(text);
	}

}
