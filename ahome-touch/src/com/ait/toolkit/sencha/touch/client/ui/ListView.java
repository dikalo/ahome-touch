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

import com.ait.toolkit.sencha.shared.client.core.Template;

public interface ListView {

	/**
	 * True to defer emptyText being applied until the store's first load
	 * 
	 * @param value
	 */
	public void setDeferEmptyText(boolean value);

	public boolean deferEmptyText();

	/**
	 * The text to display in the view when there is no data to display
	 * 
	 * @param value
	 */
	public void setEmptyText(String value);

	public String getEmptyText();

	/**
	 * The tpl to use for each of the items displayed in this DataView.
	 * 
	 * @param value
	 */
	public void setItemTpl(String tpl);

	/**
	 * The tpl to use for each of the items displayed in this DataView.
	 * 
	 * @param value
	 */
	public void setItemTpl(Template tpl);

	public String getItemTpl();

	/**
	 * A string to display during data load operations (defaults to
	 * 'Loading...'). If specified, this text will be displayed in a loading div
	 * and the view's contents will be cleared while loading, otherwise the
	 * view's contents will continue to display normally until the new data is
	 * loaded and the contents are replaced.
	 * 
	 * @param value
	 */
	public void setLoadingText(String value);

	public String getLoaddingText();

	public boolean deselectOnContainerClick();

	/**
	 * When set to true, tapping on the DataView's background (i.e. not on an
	 * item in the DataView) will deselect any currently selected items.
	 * 
	 * @param value
	 * @return
	 */
	public void setDeselectOnContainerClick(boolean value);

	public String getPressedCls();

	public void setPressedCls(String value);

	public double getPressedDelay();

	public void setPressedDelay(double value);

	public String getSelectedCls();

	public void setSelectedCls(String value);

	public void refresh();

}