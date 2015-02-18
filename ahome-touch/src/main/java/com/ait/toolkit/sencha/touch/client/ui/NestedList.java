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

import com.ait.toolkit.sencha.shared.client.core.XType;
import com.ait.toolkit.sencha.shared.client.data.TreeStore;
import com.ait.toolkit.sencha.touch.client.events.HandlerRegistration;
import com.ait.toolkit.sencha.touch.client.events.nestedlist.BackHandler;
import com.ait.toolkit.sencha.touch.client.events.nestedlist.BeforeLoadHandler;
import com.ait.toolkit.sencha.touch.client.events.nestedlist.ContainerTapHandler;
import com.ait.toolkit.sencha.touch.client.events.nestedlist.ItemDoubleTapHandler;
import com.ait.toolkit.sencha.touch.client.events.nestedlist.ItemTapHandler;
import com.ait.toolkit.sencha.touch.client.events.nestedlist.LeafItemTapHandler;
import com.ait.toolkit.sencha.touch.client.events.nestedlist.LoadHandler;
import com.ait.toolkit.sencha.touch.client.events.nestedlist.SelectionChangeHandler;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * NestedListDataView provides a miller column interface to navigate between nested sets and provide a clean interface with limited screen real-estate.
 * 
 */
public class NestedList extends Container {

	private TreeStore store;

	protected NestedList(JavaScriptObject config) {
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

	public NestedList() {

	}

	public NestedList(TreeStore store) {
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
	public native void setUpdateTitleText(boolean value) /*-{
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

	public native HandlerRegistration addBackHandler(BackHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(n, node, la, detailCardActive) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.NestedList::new(Lcom/google/gwt/core/client/JavaScriptObject;)(n);
			var list = @com.ait.toolkit.sencha.touch.client.ui.ListView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(la);
			var event = @com.ait.toolkit.sencha.touch.client.events.nestedlist.BackEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/NestedList;Lcom/google/gwt/dom/client/Element;Lcom/ait/toolkit/sencha/touch/client/ui/ListView;Z)(comp,node,list,detailCardActive);
			handler.@com.ait.toolkit.sencha.touch.client.events.nestedlist.BackHandler::onBack(Lcom/ait/toolkit/sencha/touch/client/events/nestedlist/BackEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.nestedlist.BackEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addBeforeLoadHandler(BeforeLoadHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(n, s, o) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.NestedList::new(Lcom/google/gwt/core/client/JavaScriptObject;)(n);
			var store = @com.ait.toolkit.sencha.shared.client.data.Store::new(Lcom/google/gwt/core/client/JavaScriptObject;)(s);
			var op = @com.ait.toolkit.sencha.shared.client.data.Operation::new(Lcom/google/gwt/core/client/JavaScriptObject;)(o);
			var event = @com.ait.toolkit.sencha.touch.client.events.nestedlist.BeforeLoadEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/NestedList;Lcom/ait/toolkit/sencha/shared/client/data/Store;Lcom/ait/toolkit/sencha/shared/client/data/Operation;)(comp,store,operation);
			handler.@com.ait.toolkit.sencha.touch.client.events.nestedlist.BeforeLoadHandler::onBeforeLoad(Lcom/ait/toolkit/sencha/touch/client/events/nestedlist/BeforeLoadEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.nestedlist.BeforeLoadEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addContainerTapHandler(ContainerTapHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(n, l, e) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.NestedList::new(Lcom/google/gwt/core/client/JavaScriptObject;)(n);
			var list = @com.ait.toolkit.sencha.touch.client.ui.ListView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(l);
			var event = @com.ait.toolkit.sencha.touch.client.events.nestedlist.ContainerTapEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/NestedList;Lcom/ait/toolkit/sencha/touch/client/ui/ListView;Lcom/google/gwt/core/client/JavaScriptObject;)(comp,list,e);
			handler.@com.ait.toolkit.sencha.touch.client.events.nestedlist.ContainerTapHandler::onContainerTap(Lcom/ait/toolkit/sencha/touch/client/events/nestedlist/ContainerTapEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.nestedlist.ContainerTapEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemDoubleTapHandler(ItemDoubleTapHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(n, l, index, t, r, e) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.NestedList::new(Lcom/google/gwt/core/client/JavaScriptObject;)(n);
			var list = @com.ait.toolkit.sencha.touch.client.ui.ListView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(l);
			var model = @com.ait.toolkit.data.client.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
			var event = @com.ait.toolkit.sencha.touch.client.events.nestedlist.ItemDoubleTapEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/ait/toolkit/sencha/touch/client/ui/NestedList;Lcom/ait/toolkit/sencha/touch/client/ui/ListView;ILcom/ait/toolkit/sencha/shared/client/dom/ExtElement;Lcom/ait/toolkit/data/client/BaseModel;)(e,comp,list,index,t,model);
			handler.@com.ait.toolkit.sencha.touch.client.events.nestedlist.ItemDoubleTapHandler::onItemDoubleTap(Lcom/ait/toolkit/sencha/touch/client/events/nestedlist/ItemDoubleTapEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.nestedlist.ItemDoubleTapEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemTapHandler(ItemTapHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(n, l, index, t, r, e) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.NestedList::new(Lcom/google/gwt/core/client/JavaScriptObject;)(n);
			var list = @com.ait.toolkit.sencha.touch.client.ui.ListView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(l);
			var model = @com.ait.toolkit.data.client.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
			var event = @com.ait.toolkit.sencha.touch.client.events.nestedlist.ItemTapEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/ait/toolkit/sencha/touch/client/ui/NestedList;Lcom/ait/toolkit/sencha/touch/client/ui/ListView;ILcom/ait/toolkit/sencha/shared/client/dom/ExtElement;Lcom/ait/toolkit/data/client/BaseModel;)(e,comp,list,index,t,model);
			handler.@com.ait.toolkit.sencha.touch.client.events.nestedlist.ItemTapHandler::onItemTap(Lcom/ait/toolkit/sencha/touch/client/events/nestedlist/ItemTapEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.nestedlist.ItemTapEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addLeafItemTapHandler(LeafItemTapHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(n, l, index, t, r, e) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.NestedList::new(Lcom/google/gwt/core/client/JavaScriptObject;)(n);
			var list = @com.ait.toolkit.sencha.touch.client.ui.ListView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(l);
			var model = @com.ait.toolkit.data.client.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
			var event = @com.ait.toolkit.sencha.touch.client.events.nestedlist.LeafItemTapEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/ait/toolkit/sencha/touch/client/ui/NestedList;Lcom/ait/toolkit/sencha/touch/client/ui/ListView;ILcom/ait/toolkit/sencha/shared/client/dom/ExtElement;Lcom/ait/toolkit/data/client/BaseModel;)(e,comp,list,index,t,model);
			handler.@com.ait.toolkit.sencha.touch.client.events.nestedlist.LeafItemTapHandler::onLeafItemTap(Lcom/ait/toolkit/sencha/touch/client/events/nestedlist/LeafItemTapEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.nestedlist.LeafItemTapEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addLoadHandler(LoadHandler handler)/*-{
		var fn = function(n, s, recs, sucessful, o) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.NestedList::new(Lcom/google/gwt/core/client/JavaScriptObject;)(n);
			var store = @com.ait.toolkit.sencha.shared.client.data.Store::new(Lcom/google/gwt/core/client/JavaScriptObject;)(s);
			var records = @com.ait.toolkit.data.client.BaseModel::fromJsArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recs);
			var op = @com.ait.toolkit.sencha.shared.client.data.Operation::new(Lcom/google/gwt/core/client/JavaScriptObject;)(o);
			var event = @com.ait.toolkit.sencha.touch.client.events.nestedlist.LoadEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/NestedList;Lcom/ait/toolkit/sencha/shared/client/data/Store;Ljava/util/List;Lcom/ait/toolkit/sencha/shared/client/data/Operation;Z)(comp,store,records, successful, operation);
			handler.@com.ait.toolkit.sencha.touch.client.events.nestedlist.LoadHandler::onLoad(Lcom/ait/toolkit/sencha/touch/client/events/nestedlist/LoadEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.nestedlist.LoadEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addSelectionChangeHandler(SelectionChangeHandler handler)/*-{
		var fn = function(n, l, recs) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.NestedList::new(Lcom/google/gwt/core/client/JavaScriptObject;)(n);
			var list = @com.ait.toolkit.sencha.touch.client.ui.ListView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(n);
			var records = @com.ait.toolkit.data.client.BaseModel::fromJsArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recs);
			var event = @com.ait.toolkit.sencha.touch.client.events.nestedlist.SelectionChangeEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/NestedList;Lcom/ait/toolkit/sencha/touch/client/ui/ListView;)(comp,list);
			handler.@com.ait.toolkit.sencha.touch.client.events.nestedlist.SelectionChangeHandler::onSelectionChange(Lcom/ait/toolkit/sencha/touch/client/events/nestedlist/SelectionChangeEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.nestedlist.SelectionChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	private native void setStore(JavaScriptObject value)/*-{
		var nestedlist = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		nestedlist.setStore(value);
	}-*/;

}
