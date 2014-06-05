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

import com.ait.toolkit.sencha.shared.client.core.handlers.CallbackRegistration;
import com.ait.toolkit.sencha.shared.client.data.TreeStore;
import com.ait.toolkit.sencha.touch.client.core.config.Event;
import com.ait.toolkit.sencha.shared.client.core.XType;
import com.ait.toolkit.sencha.touch.client.core.handlers.nestedlist.NestedListBeforeLoadHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.nestedlist.NestedListBeforeSelectHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.nestedlist.NestedListChangeHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.nestedlist.NestedListItemDoubleTapHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.nestedlist.NestedListItemTapHandler;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * NestedListDataView provides a miller column interface to navigate between
 * nested sets and provide a clean interface with limited screen real-estate.
 * 
 */
public class NestedListDataView extends Container {

	private TreeStore store;

	protected NestedListDataView(JavaScriptObject config) {
		super(config);
	}

	@Override
	protected native void init()/*-{
		var c = new $wnd.Ext.dataview.NestedList();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
	}-*/;

	@Override
	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.dataview.NestedList(config);
	}-*/;

	public NestedListDataView() {

	}

	public NestedListDataView(TreeStore store) {
		this.store = store;
		setStore(store.getJsObj());
	}

	public void setStore(TreeStore store) {
		setStore(store.getJsObj());
	}

	@Override
	public String getXType() {
		return XType.NESTEDLIST.getValue();
	}

	/**
	 * Returns the value of allowDeselect.
	 * 
	 * @return
	 */
	public native boolean getAllowDeselect() /*-{
		var nestedlist = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return nestedlist.getAllowDeselect();
	}-*/;

	/**
	 * Returns the value of backText
	 * 
	 * @return
	 */
	public native String getBackText() /*-{
		var nestedlist = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return nestedlist.getBackText();
	}-*/;

	/**
	 * Returns the value of displayField.
	 * 
	 * @return
	 */
	public native String getDisplayField() /*-{
		var nestedlist = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return nestedlist.getDisplayField();
	}-*/;

	/**
	 * Returns the value of emptyText
	 * 
	 * @return
	 */
	public native String getEmptyText() /*-{
		var nestedlist = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return nestedlist.getEmptyText();
	}-*/;

	/**
	 * Returns the value of loadingText.
	 * 
	 * @return
	 */
	public native String getLoadingText() /*-{
		var nestedlist = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return nestedlist.getLoadingText();
	}-*/;

	/**
	 * Returns the value of title
	 */
	public native String getTitle() /*-{
		var nestedlist = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return nestedlist.getTitle();
	}-*/;

	/**
	 * Returns the value of updateTitleText
	 * 
	 * @return
	 */
	public native boolean getUpdateTitleText() /*-{
		var nestedlist = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return nestedlist.getUpdateTitleText();
	}-*/;

	/**
	 * Returns the value of useTitleAsBackText
	 * 
	 * @return
	 */
	public native boolean getUseTitleAsBackText() /*-{
		var nestedlist = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return nestedlist.getUseTitleAsBackText();
	}-*/;

	/**
	 * Sets the value of allowDeselect.
	 * 
	 * @param allowDeselect
	 */
	public native void setAllowDeselect(boolean allowDeselect) /*-{
		var nestedlist = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		nestedlist.setAllowDeselect(allowDeselect);
	}-*/;

	/**
	 * Sets the value of backText
	 * 
	 * @param backText
	 */
	public native void setBackText(String backText) /*-{
		var nestedlist = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		nestedlist.setBackText(backText);
	}-*/;

	/**
	 * Sets the value of displayField
	 * 
	 * @param displayField
	 */
	public native void setDisplayField(String displayField) /*-{
		var nestedlist = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		nestedlist.setDisplayField(displayField);
	}-*/;

	/**
	 * Sets the value of emptyText
	 * 
	 * @param value
	 */
	public native void setEmptyText(String value) /*-{
		var nestedlist = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		nestedlist.setEmptyText(value);
	}-*/;

	/**
	 * Sets the value of loadingText
	 * 
	 * @param value
	 */
	public native void setLoadingText(String value) /*-{
		var nestedlist = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		nestedlist.setLoadingText(value);
	}-*/;

	/**
	 * Sets the value of title
	 */
	public native void setTitle(String value) /*-{
		var nestedlist = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		nestedlist.setTitle(value);
	}-*/;

	/**
	 * Sets the value of toolbar
	 * 
	 * @param toolbar
	 */
	public native void setToolBar(ToolBar toolbar) /*-{
		var nestedlist = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		nestedlist
				.setToolBar(toolbar.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()());
	}-*/;

	/**
	 * Sets the value of toolbar
	 * 
	 * @param toolbar
	 */
	public native void setToolBar(boolean toolbar) /*-{
		var nestedlist = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		nestedlist.setToolBar(toolbar);
	}-*/;

	/**
	 * Sets the value of updateTitleText
	 * 
	 * @param value
	 */
	public native void setUpdateTitleText(String value) /*-{
		var nestedlist = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		nestedlist.setUpdateTitleText(value);
	}-*/;

	/**
	 * Sets the value of useTitleAsBackText.
	 * 
	 * @param value
	 */
	public native void setUseTitleAsBackText(boolean value) /*-{
		var nestedlist = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		nestedlist.setUseTitleAsBackText(value);
	}-*/;

	/**
	 * return the store bounds to this nested list
	 * 
	 * @return
	 */
	public TreeStore getStore() {
		return this.store;
	}

	/**
	 * Fires before a request is made for a new data object
	 * 
	 * @param handler
	 */
	public CallbackRegistration addBeforeLoadHandler(
			NestedListBeforeLoadHandler handler) {
		return this.addWidgetListener(Event.BEFORE_LOAD.getValue(),
				handler.getJsoPeer());
	}

	/**
	 * Fires before a selection is made
	 * 
	 * @param handler
	 */
	public CallbackRegistration addBeforeSelectHandler(
			NestedListBeforeSelectHandler handler) {
		return this.addWidgetListener(Event.BEFORE_SELECT.getValue(),
				handler.getJsoPeer());
	}

	/**
	 * Fires when the user taps a list item
	 * 
	 * @param handler
	 */
	public CallbackRegistration addListChangeHandler(
			NestedListChangeHandler handler) {
		return this.addWidgetListener(Event.LIST_CHANGE.getValue(),
				handler.getJsoPeer());
	}

	/**
	 * Fires when a node is double tapped on
	 * 
	 * @param handler
	 */
	public CallbackRegistration addListItemDoubleTapHandler(
			NestedListItemDoubleTapHandler handler) {
		return this.addWidgetListener(Event.ITEM_DOUBLE_TAP.getValue(),
				handler.getJsoPeer());
	}

	/**
	 * Fires when a node is tapped on
	 * 
	 * @param handler
	 */
	public CallbackRegistration addListItemTapHandler(
			NestedListItemTapHandler handler) {
		return this.addWidgetListener(Event.ITEM_TAP.getValue(),
				handler.getJsoPeer());
	}

	private native void setStore(JavaScriptObject value)/*-{
		var nestedlist = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		nestedlist.setStore(value);
	}-*/;

}
