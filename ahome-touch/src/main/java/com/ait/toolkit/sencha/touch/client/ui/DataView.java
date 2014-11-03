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
import com.ait.toolkit.sencha.shared.client.core.XType;
import com.ait.toolkit.sencha.shared.client.data.Store;
import com.ait.toolkit.sencha.touch.client.core.config.TouchAttribute;
import com.ait.toolkit.sencha.touch.client.dataview.SimpleListItem;
import com.ait.toolkit.sencha.touch.client.events.HandlerRegistration;
import com.ait.toolkit.sencha.touch.client.events.dataview.DeselectHandler;
import com.ait.toolkit.sencha.touch.client.events.dataview.ItemSingleTapHandler;
import com.ait.toolkit.sencha.touch.client.events.dataview.ItemSwipeHandler;
import com.ait.toolkit.sencha.touch.client.events.dataview.ItemTapHandler;
import com.ait.toolkit.sencha.touch.client.events.dataview.ItemTapHoldHandler;
import com.ait.toolkit.sencha.touch.client.events.dataview.ItemTouchEndHandler;
import com.ait.toolkit.sencha.touch.client.events.dataview.ItemTouchMoveHandler;
import com.ait.toolkit.sencha.touch.client.events.dataview.ItemTouchStartHandler;
import com.ait.toolkit.sencha.touch.client.events.dataview.RefreshHandler;
import com.ait.toolkit.sencha.touch.client.events.dataview.SelectHandler;
import com.ait.toolkit.sencha.touch.client.events.nestedlist.ItemDoubleTapHandler;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * DataView makes it easy to create lots of components dynamically, usually based off a Store. It's great for rendering lots of data from your server backend or any other data
 * source and is what powers components like {@link ListView}.
 */
public class DataView extends Container implements HasStore {

	protected Store store;
	protected boolean useCompoments;

	protected DataView(JavaScriptObject config) {
		super(config);
	}

	@Override
	protected native void init()/*-{
		var c = new $wnd.Ext.dataview.DataView();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
	}-*/;

	@Override
	public String getXType() {
		return XType.DATAVIEW.getValue();
	}

	/**
	 * Create a new Sheet.
	 */
	public DataView() {
	}

	@Override
	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.dataview.DataView(config);
	}-*/;

	/**
	 * Returns the value of deselectOnContainerClick.
	 * 
	 * @return
	 */
	public native Boolean getDeselectOnContainerClick() /*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return dataview.getDeselectOnContainerClick();
	}-*/;

	/**
	 * Deselects the given record
	 * 
	 * @param index
	 * @param suppressEvent
	 */
	public native void deselect(int index, boolean suppressEvent) /*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return dataview.deselect(index, suppressEvent);
	}-*/;

	/**
	 * Deselects all records
	 */
	public native void deselectAll() /*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return dataview.deselectAll();
	}-*/;

	/**
	 * Returns the value of itemCls.
	 * 
	 * @return
	 */
	public native String getItemCls() /*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return dataview.getItemCls();
	}-*/;

	/**
	 * Returns an item at the specified index.
	 * 
	 * @param index
	 *            , the index of the item
	 * @return, an ExtElement at thie given index
	 */
	public native SimpleListItem getItemAt(int index) /*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var obj = dataview.getItemAt(index);
		return @com.ait.toolkit.sencha.touch.client.dataview.SimpleListItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
	}-*/;

	/**
	 * Returns the value of maxItemCache.
	 * 
	 * @return
	 */
	public native int getMaxItemCache() /*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return dataview.getMaxItemCache();
	}-*/;

	public native String getPressedCls()/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return dataview.getPressedCls();
	}-*/;

	public native double getPressedDelay()/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return dataview.getPressedDelay();
	}-*/;

	/**
	 * Returns the value of scrollToTopOnRefresh.
	 * 
	 * @return
	 */
	public native int getScrollToTopOnRefresh() /*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return dataview.getScrollToTopOnRefresh();
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.dataview.ListView#getSelectedCls()
	 */
	public native String getSelectedCls()/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return dataview.getSelectedCls();
	}-*/;

	/**
	 * Returns the value of store.
	 */
	@Override
	public Store getStore() {
		return this.store;
	}

	private native Store _getStore()/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var store = dataview.getStore();
		return @com.ait.toolkit.sencha.shared.client.data.Store::new(Lcom/google/gwt/core/client/JavaScriptObject;)(store);
	}-*/;

	/**
	 * Returns the value of triggerCtEvent.
	 * 
	 * @return
	 */
	public native String getTriggerCtEvent()/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return dataview.getTriggerCtEvent();
	}-*/;

	/**
	 * Returns the value of triggerEvent.
	 * 
	 * @return
	 */
	public native String getTriggerEvent()/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return dataview.getTriggerEvent();
	}-*/;

	/**
	 * Returns the value of useComponents.
	 * 
	 * @return
	 */
	public native Boolean useComponents()/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return dataview.getUseComponents();
	}-*/;

	public native void refresh()/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataview.refresh();
	}-*/;

	/**
	 * The xtype used for the component based DataView. Defaults to dataitem. Note this is only used when useComponents is true.
	 * 
	 * Defaults to: "dataitem"
	 * 
	 * @param defaultType
	 */
	public native void setDefaultType(String defaultType)/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataview.setDefaultType(defaultType);
	}-*/;

	public native void setDeselectOnContainerClick(boolean value)/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataview.setDeselectOnContainerClick(value);
	}-*/;

	/**
	 * True to disable the selection on this list.
	 * 
	 * @param value
	 */
	public native void setDisableSelection(boolean value)/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataview.setDisableSelection(value);
	}-*/;

	/**
	 * Sets the value of itemCls.
	 * 
	 * @param value
	 */
	public native void setItemCls(String value)/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataview.setItemCls(value);
	}-*/;

	/**
	 * Sets the value of maxItemCache
	 * 
	 * @param value
	 */
	public native void setMaxItemCache(int value)/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataview.setMaxItemCache(value);
	}-*/;

	public native void setPressedCls(String value)/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataview.setPressedCls(value);
	}-*/;

	public native void setPressedDelay(double value)/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataview.setPressedDelay(value);
	}-*/;

	/**
	 * Sets the value of scrollToTopOnRefresh
	 * 
	 * @param value
	 */
	public native void setScrollToTopOnRefresh(String value)/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataview.setScrollToTopOnRefresh(value);
	}-*/;

	public native void setSelectedCls(String value)/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataview.setSelectedCls(value);
	}-*/;

	@Override
	public void setStore(Store store) {
		this.store = store;
		setStore(store.getJsObj());
	}

	/**
	 * Sets the value of triggerCtEvent.
	 * 
	 * @param value
	 */
	public native void setTriggerCtEvent(String value)/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataview.setTriggerCtEvent(value);
	}-*/;

	/**
	 * Sets the value of triggerEvent
	 * 
	 * @param value
	 */
	public native void setTriggerEvent(String value)/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataview.setTriggerEvent(value);
	}-*/;

	/**
	 * Sets the value of useComponents.
	 * 
	 * @param value
	 */
	public void setUseComponents(boolean value) {
		this.useCompoments = value;
		_setUseComponents(value);
	}

	public boolean isUseComponents() {
		return this.useCompoments;
	}

	private native void _setUseComponents(boolean value)/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataview.setUseComponents(value);
	}-*/;

	public void setDeferEmptyText(boolean value) {
		setAttribute(TouchAttribute.DEFER_EMPTY_TEXT.getValue(), value, true);
	}

	public boolean deferEmptyText() {
		return getAttributeAsBoolean(TouchAttribute.DEFER_EMPTY_TEXT.getValue());
	}

	public void setEmptyText(String value) {
		setAttribute(TouchAttribute.EMPTY_TEXT.getValue(), value, true);
	}

	public String getEmptyText() {
		return getAttribute(TouchAttribute.EMPTY_TEXT.getValue());
	}

	public void setItemTpl(String tpl) {
		this._setItemTpl(tpl);
		this.refresh();
	}

	public void setItemTpl(Template tpl) {
		this._setItemTpl(tpl.getJsObj());
		this.refresh();
	}

	public String getItemTpl() {
		return getAttribute(TouchAttribute.ITEM_TPL.getValue());
	}

	public void setLoadingText(String value) {
		setAttribute(TouchAttribute.LOADING_TEXT.getValue(), value, true);
	}

	public String getLoaddingText() {
		return getAttribute(TouchAttribute.LOADING_TEXT.getValue());
	}

	public native boolean deselectOnContainerClick()/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataview.getDeselectOnContainerClick();
	}-*/;

	private native void setStore(JavaScriptObject value)/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataview.setStore(value);
	}-*/;

	// Events
	public native HandlerRegistration addDeselectHandler(DeselectHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(l, r, supressed) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.ListView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(l);
			var record = @com.ait.toolkit.data.client.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
			var event = @com.ait.toolkit.sencha.touch.client.events.dataview.DeselectEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/DataView;Lcom/ait/toolkit/data/client/BaseModel;Z)(comp,record,supressed);
			handler.@com.ait.toolkit.sencha.touch.client.events.dataview.DeselectHandler::onDeselect(Lcom/ait/toolkit/sencha/touch/client/events/dataview/DeselectEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.dataview.DeselectEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemDoubleTapHandler(ItemDoubleTapHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, index, target, rec, e) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.ListView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var model = @com.ait.toolkit.data.client.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.ait.toolkit.sencha.touch.client.events.dataview.ItemDoubleTapEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/ait/toolkit/sencha/touch/client/ui/ListView;Lcom/ait/toolkit/data/client/BaseModel;Lcom/google/gwt/dom/client/Element;I)(e,comp,model,target, index);
			handler.@com.ait.toolkit.sencha.touch.client.events.dataview.ItemDoubleTapHandler::onItemDoubleTap(Lcom/ait/toolkit/sencha/touch/client/events/dataview/ItemDoubleTapEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.dataview.ItemDoubleTapEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemSingleTapHandler(ItemSingleTapHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, index, target, rec, e) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.ListView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var model = @com.ait.toolkit.data.client.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.ait.toolkit.sencha.touch.client.events.dataview.ItemSingleTapEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/ait/toolkit/sencha/touch/client/ui/ListView;Lcom/ait/toolkit/data/client/BaseModel;Lcom/google/gwt/dom/client/Element;I)(e,comp,model,target, index);
			handler.@com.ait.toolkit.sencha.touch.client.events.dataview.ItemSingleTapHandler::onItemSingleTap(Lcom/ait/toolkit/sencha/touch/client/events/dataview/ItemSingleTapEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.dataview.ItemSingleTapEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemSwipeHandler(ItemSwipeHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, index, target, rec, e) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.ListView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var model = @com.ait.toolkit.data.client.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.ait.toolkit.sencha.touch.client.events.dataview.ItemSwipeEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/ait/toolkit/sencha/touch/client/ui/ListView;Lcom/ait/toolkit/data/client/BaseModel;Lcom/google/gwt/dom/client/Element;I)(e,comp,model,target, index);
			handler.@com.ait.toolkit.sencha.touch.client.events.dataview.ItemSwipeHandler::onItemSwipe(Lcom/ait/toolkit/sencha/touch/client/events/dataview/ItemSwipeEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.dataview.ItemSwipeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemTapHandler(ItemTapHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, index, target, rec, e) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.ListView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var model = @com.ait.toolkit.data.client.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.ait.toolkit.sencha.touch.client.events.dataview.ItemTapEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/ait/toolkit/sencha/touch/client/ui/ListView;Lcom/ait/toolkit/data/client/BaseModel;Lcom/google/gwt/dom/client/Element;I)(e,comp,model,target, index);
			handler.@com.ait.toolkit.sencha.touch.client.events.dataview.ItemTapHandler::onItemTap(Lcom/ait/toolkit/sencha/touch/client/events/dataview/ItemTapEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.dataview.ItemTapEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemTapHoldHandler(ItemTapHoldHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, index, target, rec, e) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.ListView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var model = @com.ait.toolkit.data.client.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.ait.toolkit.sencha.touch.client.events.dataview.ItemTapHoldEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/ait/toolkit/sencha/touch/client/ui/ListView;Lcom/ait/toolkit/data/client/BaseModel;Lcom/google/gwt/dom/client/Element;I)(e,comp,model,target, index);
			handler.@com.ait.toolkit.sencha.touch.client.events.dataview.ItemTapHoldHandler::onItemTapHold(Lcom/ait/toolkit/sencha/touch/client/events/dataview/ItemTapHoldEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.dataview.ItemTapHoldEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemTouchEndHandler(ItemTouchEndHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, index, target, rec, e) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.ListView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var model = @com.ait.toolkit.data.client.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.ait.toolkit.sencha.touch.client.events.dataview.ItemTouchEndEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/ait/toolkit/sencha/touch/client/ui/ListView;Lcom/ait/toolkit/data/client/BaseModel;Lcom/google/gwt/dom/client/Element;I)(e,comp,model,target, index);
			handler.@com.ait.toolkit.sencha.touch.client.events.dataview.ItemTouchEndHandler::onItemTouchEnd(Lcom/ait/toolkit/sencha/touch/client/events/dataview/ItemTouchEndEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.dataview.ItemTouchEndEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemTouchMoveHandler(ItemTouchMoveHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, index, target, rec, e) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.ListView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var model = @com.ait.toolkit.data.client.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.ait.toolkit.sencha.touch.client.events.dataview.ItemTouchMoveEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/ait/toolkit/sencha/touch/client/ui/ListView;Lcom/ait/toolkit/data/client/BaseModel;Lcom/google/gwt/dom/client/Element;I)(e,comp,model,target, index);
			handler.@com.ait.toolkit.sencha.touch.client.events.dataview.ItemTouchMoveHandler::onItemTouchMove(Lcom/ait/toolkit/sencha/touch/client/events/dataview/ItemTouchMoveEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.dataview.ItemTouchMoveEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addItemTouchStartHandler(ItemTouchStartHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, index, target, rec, e) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.ListView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var model = @com.ait.toolkit.data.client.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.ait.toolkit.sencha.touch.client.events.dataview.ItemTouchStartEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/ait/toolkit/sencha/touch/client/ui/ListView;Lcom/ait/toolkit/data/client/BaseModel;Lcom/google/gwt/dom/client/Element;I)(e,comp,model,target, index);
			handler.@com.ait.toolkit.sencha.touch.client.events.dataview.ItemTouchStartHandler::onItemTouchStart(Lcom/ait/toolkit/sencha/touch/client/events/dataview/ItemTouchStartEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.dataview.ItemTouchStartEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addRefreshHandler(RefreshHandler handler)/*-{
	var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
	var fn = function(c) {
		var comp = @com.ait.toolkit.sencha.touch.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
		var event = @com.ait.toolkit.sencha.touch.client.events.dataview.RefreshEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/DataView;);
		handler.@com.ait.toolkit.sencha.touch.client.events.dataview.RefreshHandler::onRefresh(Lcom/ait/toolkit/sencha/touch/client/events/dataview/RefreshEvent;)(comp,event);
	};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.dataview.RefreshEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

	public native HandlerRegistration addSelectHandler(SelectHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, rec) {
			var comp = @com.ait.toolkit.sencha.touch.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var model = @com.ait.toolkit.data.client.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.ait.toolkit.sencha.touch.client.events.dataview.SelectEvent::new(Lcom/ait/toolkit/sencha/touch/client/ui/DataView;Lcom/ait/toolkit/data/client/BaseModel;)(comp, event);
			handler.@com.ait.toolkit.sencha.touch.client.events.dataview.SelectHandler::onSelect(Lcom/ait/toolkit/sencha/touch/client/events/dataview/SelectEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.dataview.SelectEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	private native void _setItemTpl(String value)/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataview.setItemTpl(value);
	}-*/;

	private native void _setItemTpl(JavaScriptObject value)/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataview.setItemTpl(value);
	}-*/;

}
