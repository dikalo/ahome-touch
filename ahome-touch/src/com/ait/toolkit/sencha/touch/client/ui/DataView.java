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
import com.ait.toolkit.sencha.shared.client.core.handlers.CallbackRegistration;
import com.ait.toolkit.sencha.shared.client.data.Store;
import com.ait.toolkit.sencha.touch.client.core.config.Event;
import com.ait.toolkit.sencha.touch.client.core.config.TouchAttribute;
import com.ait.toolkit.sencha.shared.client.core.XType;
import com.ait.toolkit.sencha.touch.client.core.handlers.dataview.DataViewDoSelectHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.dataview.DataViewItemDoubleTapHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.dataview.DataViewItemSwipeHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.dataview.DataViewItemTapHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.dataview.DataViewItemTouchEndHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.dataview.DataViewItemTouchStartHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.dataview.DataViewRefreshHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.dataview.DataViewSelectHandler;
import com.ait.toolkit.sencha.touch.client.dataview.SimpleListItem;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * DataView makes it easy to create lots of components dynamically, usually
 * based off a Store. It's great for rendering lots of data from your server
 * backend or any other data source and is what powers components like
 * {@link ListDataView}.
 */
public class DataView extends Container implements HasStore, ListView {

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ait.toolkit.sencha.touch.client.dataview.ListView#getPressedCls()
	 */
	@Override
	public native String getPressedCls()/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return dataview.getPressedCls();
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ait.toolkit.sencha.touch.client.dataview.ListView#getPressedDelay()
	 */
	@Override
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
	 * @see
	 * com.ait.toolkit.sencha.touch.client.dataview.ListView#getSelectedCls()
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

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.ui.ListView#refresh()
	 */
	@Override
	public native void refresh()/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataview.refresh();
	}-*/;

	/**
	 * The xtype used for the component based DataView. Defaults to dataitem.
	 * Note this is only used when useComponents is true.
	 * 
	 * Defaults to: "dataitem"
	 * 
	 * @param defaultType
	 */
	public native void setDefaultType(String defaultType)/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataview.setDefaultType(defaultType);
	}-*/;

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.ui.ListView#setDeselectOnContainerClick
	 *      (boolean)
	 */
	@Override
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ait.toolkit.sencha.touch.client.dataview.ListView#setPressedCls(java
	 * .lang .String)
	 */
	@Override
	public native void setPressedCls(String value)/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataview.setPressedCls(value);
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ait.toolkit.sencha.touch.client.dataview.ListView#setPressedDelay
	 * (double)
	 */
	@Override
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ait.toolkit.sencha.touch.client.dataview.ListView#setSelectedCls(
	 * java.lang .String)
	 */
	@Override
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ait.toolkit.sencha.touch.client.dataview.ListView#setDeferEmptyText
	 * (boolean )
	 */
	@Override
	public void setDeferEmptyText(boolean value) {
		setAttribute(TouchAttribute.DEFER_EMPTY_TEXT.getValue(), value, true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ait.toolkit.sencha.touch.client.dataview.ListView#deferEmptyText()
	 */
	@Override
	public boolean deferEmptyText() {
		return getAttributeAsBoolean(TouchAttribute.DEFER_EMPTY_TEXT.getValue());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ait.toolkit.sencha.touch.client.dataview.ListView#setEmptyText(java
	 * .lang .String)
	 */
	@Override
	public void setEmptyText(String value) {
		setAttribute(TouchAttribute.EMPTY_TEXT.getValue(), value, true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.dataview.ListView#getEmptyText()
	 */
	@Override
	public String getEmptyText() {
		return getAttribute(TouchAttribute.EMPTY_TEXT.getValue());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ait.toolkit.sencha.touch.client.dataview.ListView#setItemTpl(java
	 * .lang. String)
	 */
	@Override
	public void setItemTpl(String tpl) {
		this._setItemTpl(tpl);
		this.refresh();
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	public void setItemTpl(Template tpl) {
		this._setItemTpl(tpl.getJsObj());
		this.refresh();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.dataview.ListView#getItemTpl()
	 */
	@Override
	public String getItemTpl() {
		return getAttribute(TouchAttribute.ITEM_TPL.getValue());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ait.toolkit.sencha.touch.client.dataview.ListView#setLoadingText(
	 * java.lang .String)
	 */
	@Override
	public void setLoadingText(String value) {
		setAttribute(TouchAttribute.LOADING_TEXT.getValue(), value, true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ait.toolkit.sencha.touch.client.dataview.ListView#getLoaddingText()
	 */
	@Override
	public String getLoaddingText() {
		return getAttribute(TouchAttribute.LOADING_TEXT.getValue());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.dataview.ListView#
	 * deselectOnContainerClick ()
	 */
	@Override
	public native boolean deselectOnContainerClick()/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataview.getDeselectOnContainerClick();
	}-*/;

	private native void setStore(JavaScriptObject value)/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataview.setStore(value);
	}-*/;

	/**
	 * Fires whenever an item is deselected. This action is preventable.
	 * 
	 * @param handler
	 */
	public CallbackRegistration addDoSelectHandler(
			DataViewDoSelectHandler handler) {
		return this.addWidgetListener(Event.DO_SELECT.getValue(),
				handler.getJsoPeer());
	}

	/**
	 * Fires whenever an item is doubletapped
	 * 
	 * @param handler
	 */
	public CallbackRegistration addItemDoubleTapHandler(
			DataViewItemDoubleTapHandler handler) {
		return this.addWidgetListener(Event.ITEM_DOUBLE_TAP.getValue(),
				handler.getJsoPeer());
	}

	/**
	 * Fires whenever an item is swiped
	 * 
	 * @param handler
	 */
	public CallbackRegistration addItemSwipeHandler(
			DataViewItemSwipeHandler handler) {
		return this.addWidgetListener(Event.ITEM_SWIPE.getValue(),
				handler.getJsoPeer());
	}

	/**
	 * Fires whenever an item is tapped
	 * 
	 * @param handler
	 */
	public CallbackRegistration addItemTapHandler(DataViewItemTapHandler handler) {
		return this.addWidgetListener(Event.ITEM_TAP.getValue(),
				handler.getJsoPeer());
	}

	/**
	 * Fires whenever an item is touched
	 * 
	 * @param handler
	 */
	public CallbackRegistration addItemTouchEndHandler(
			DataViewItemTouchEndHandler handler) {
		return this.addWidgetListener(Event.ITEM_TOUCH_END.getValue(),
				handler.getJsoPeer());
	}

	/**
	 * Fires whenever an item is touched
	 * 
	 * @param handler
	 */
	public CallbackRegistration addItemTouchStartHandler(
			DataViewItemTouchStartHandler handler) {
		return this.addWidgetListener(Event.ITEM_TOUCH_START.getValue(),
				handler.getJsoPeer());
	}

	/**
	 * Fires whenever the DataView is refreshed. The Event is preventable.
	 * 
	 * @param handler
	 */
	public CallbackRegistration addRefreshHandler(DataViewRefreshHandler handler) {
		return this.addWidgetListener(Event.REFRESH.getValue(),
				handler.getJsoPeer());
	}

	/**
	 * Fires whenever an item is selected
	 * 
	 * @param handler
	 */
	public CallbackRegistration addSelectHandler(DataViewSelectHandler handler) {
		return this.addWidgetListener(Event.SELECT.getValue(),
				handler.getJsoPeer());
	}

	private native void _setItemTpl(String value)/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataview.setItemTpl(value);
	}-*/;

	private native void _setItemTpl(JavaScriptObject value)/*-{
		var dataview = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		dataview.setItemTpl(value);
	}-*/;

}
