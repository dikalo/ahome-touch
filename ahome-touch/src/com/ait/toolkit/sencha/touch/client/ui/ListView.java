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

import java.util.ArrayList;
import java.util.List;

import com.ait.toolkit.core.client.Function;
import com.ait.toolkit.data.client.BaseModel;
import com.ait.toolkit.sencha.shared.client.core.EventObject;
import com.ait.toolkit.sencha.shared.client.core.Template;
import com.ait.toolkit.sencha.shared.client.core.XType;
import com.ait.toolkit.sencha.shared.client.core.handlers.ElementEventHandler;
import com.ait.toolkit.sencha.shared.client.data.Store;
import com.ait.toolkit.sencha.shared.client.dom.DomHelper;
import com.ait.toolkit.sencha.shared.client.dom.ExtElement;
import com.ait.toolkit.sencha.touch.client.core.Component;
import com.ait.toolkit.sencha.touch.client.core.Ext;
import com.ait.toolkit.sencha.touch.client.core.handlers.dataview.DataViewItemTapHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.dataview.DataViewItemTouchStartHandler;
import com.ait.toolkit.sencha.touch.client.core.handlers.list.ItemDisclosureHandler;
import com.ait.toolkit.sencha.touch.client.dataview.ListItemComponentRenderer;
import com.ait.toolkit.sencha.touch.client.dataview.SimpleListItem;
import com.ait.toolkit.sencha.touch.client.events.dataview.ListDataViewContainerAddEvent;
import com.ait.toolkit.sencha.touch.client.events.dataview.ListDataViewContainerAddedHandler;
import com.ait.toolkit.sencha.touch.client.layout.Layout;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.Element;

/**
 * ListDataView is a custom styled DataView which allows Grouping, Indexing, Icons, and a Disclosure.
 */
public class ListView extends DataView implements ListDataViewContainerAddedHandler {

	private String containerCls = "touch-list-comp-container";
	private final static EventBus eventBus = new SimpleEventBus();
	List<Container> containerList;
	List<List<Component>> componentList;
	private boolean componentContainersCreated = false;
	private boolean useComponents = false;
	private ListItemComponentRenderer itemComponentRender;

	protected ListView(JavaScriptObject config) {
		super(config);
	}

	@Override
	protected native void init()/*-{
		var c = new $wnd.Ext.dataview.List();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
	}-*/;

	@Override
	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		//config.grouped = true;
		return new $wnd.Ext.dataview.List(config);
	}-*/;

	@Override
	public String getXType() {
		return XType.LIST.getValue();
	}

	/**
	 * Create a new ListDataView.
	 */
	public ListView() {
		eventBus.addHandler(ListDataViewContainerAddEvent.TYPE, this);
	}

	public ListView(Store store) {
		this();
		setStore(store);
	}

	public ListView(String itemTemplate, Store store) {
		this();
		setStore(store);
		setItemTpl(itemTemplate);
	}

	public ListView(String itemTemplate) {
		setItemTpl(itemTemplate);
	}

	public ListView(Template itemTemplate, Store store) {
		setStore(store);
		setItemTpl(itemTemplate);
	}

	public ListView(Template itemTemplate) {
		setItemTpl(itemTemplate);
	}

	public native boolean isGrouped()/*-{
		var list = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return list.getGrouped();
	}-*/;

	/**
	 * Returns the value of pinHeaders
	 * 
	 * @return
	 */
	public native boolean getPinHeaders()/*-{
		var list = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return list.getPinHeaders();
	}-*/;

	/**
	 * Returns the value of preventSelectionOnDisclose
	 * 
	 * @return
	 */
	public native boolean getPreventSelectionOnDisclose()/*-{
		var list = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return list.getPreventSelectionOnDisclose();
	}-*/;

	private native void _setGrouped(boolean value)/*-{
		var list = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		list.setGrouped(value);
	}-*/;

	public void setGrouped(boolean value) {
		this.setAttribute("grouped", value, true);
	}

	public native boolean hasIndexBar()/*-{
		var list = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return list.getIndexBar();
	}-*/;

	public native void setIndexBar(boolean value)/*-{
		var list = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		list.setIndexBar(value);
	}-*/;

	public native void setInLine(boolean value)/*-{
		var list = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		list.setInline(value);
	}-*/;

	public native void setInLine(boolean value, boolean wrapped)/*-{
		var list = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		list.setInline({
			wrap : wrapped
		});
	}-*/;

	public native void setPinHeaders(boolean value)/*-{
		var list = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		list.setPinHeaders(value);
	}-*/;

	public native void setPreventSelectionOnDisclose(boolean value)/*-{
		var list = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		list.setPreventSelectionOnDisclose(value);
	}-*/;

	public native void setOnItemDisclosure(ItemDisclosureHandler handler)/*-{
		var list = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		list
				.setOnItemDisclosure(function(record, node, index) {
					var model = @com.ait.toolkit.data.client.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
					handler.@com.ait.toolkit.sencha.touch.client.core.handlers.list.ItemDisclosureHandler::onItemDisclosure(Lcom/ait/toolkit/data/client/BaseModel;Lcom/google/gwt/core/client/JavaScriptObject;I)(model,node,index);
				});
	}-*/;

	public void setItemDisclosure(boolean value) {
		this.setAttribute("onItemDisclosure", value, true);
	}

	public static enum ListStyle {

		NORMAL("normal"), ROUND("round");

		private String value;

		private ListStyle(String value) {
			this.value = value;
		}

		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}

	}

	public static enum ListSelectMode {

		SINGLE("SINGLE"), SIMPLE("SIMPLE"), MULTI("MULTI");

		private String value;

		private ListSelectMode(String value) {
			this.value = value;
		}

		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}

	}

	/**
	 * Modes of selection. Valid values are 'SINGLE', 'SIMPLE', and 'MULTI'.
	 * 
	 * Defaults to: 'SINGLE'
	 */
	public void setMode(ListSelectMode mode) {
		_setMode(mode.getValue());
	}

	private native void _setMode(String mode) /*-{
		var list = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		list.setMode(mode);
	}-*/;

	/**
	 * 
	 * The style of this list. Available options are normal and round.
	 * 
	 * Defaults to: "normal".
	 */
	public void setListStyle(ListStyle listStyle) {
		_setListStyle(listStyle.getValue());
	}

	private native void _setListStyle(String listStyle) /*-{
		var list = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		list.setUi(listStyle);
	}-*/;

	/**
	 * Returns an array of the currently selected records.
	 * 
	 * @return
	 */
	public List<BaseModel> getSelection() {
		return BaseModel.fromJsArray(_getSelection());
	}

	private native JavaScriptObject _getSelection() /*-{
		var list = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return list.getSelection();
	}-*/;

	public void addItemComponent(int itemIndex, Component component) {
		List<Component> list;
		int size = this.getStore().getCount();
		if (componentList == null) {
			componentList = new ArrayList<List<Component>>(this.getStore().getCount());
			for (int i = 0; i < size; i++) {
				componentList.add(new ArrayList<Component>());
			}
		}
		list = componentList.get(itemIndex);
		component.setListItemIndex(itemIndex);
		list.add(component);
	}

	@Override
	public void onContainerAdded(ListDataViewContainerAddEvent event) {
		if (this.itemComponentRender != null) {
			for (int i = 0; i < containerList.size(); i++) {
				Container c = containerList.get(i);
				List<Component> components = itemComponentRender.getComponents();
				if (components != null) {
					for (Component component : components) {
						component.setListItemIndex(i);
						component.setMargin(2);
						c.add(component);
					}

				}
			}
		}

	}

	public void setItemComponentRenderer(ListItemComponentRenderer itemCompomentRenderer) {
		this.itemComponentRender = itemCompomentRenderer;
	}

	public void setUseComponents(boolean value) {
		this.useCompoments = value;
		if (value == true) {
			this.addEventHandler("painted", new Function() {
				@Override
				public void execute() {
					if (componentContainersCreated == false) {
						SimpleListItem item;
						containerList = new ArrayList<Container>();
						int size = store.getCount();

						for (int i = 0; i < size; i++) {
							item = ListView.this.getItemAt(i);
							DomHelper.append(item.getEl(), "<div class='touch-list-comp-container'></div>");
							final Container container = new Container();
							container.setRenderTo(item.getEl().down("." + containerCls));
							container.setLayout(Layout.HBOX);
							container.addEventHandler("painted", new Function() {
								@Override
								public void execute() {
									container.getEl().on("tap", new ElementEventHandler() {
										@Override
										public void onEvent(EventObject event) {
											event.stopEvent();
										}
									});
								}

							});

							container.setRight(15);
							container.setTop(5);
							container.show();
							containerList.add(container);

						}
						componentContainersCreated = true;
						eventBus.fireEvent(new ListDataViewContainerAddEvent());
					}
				}
			});
			this.addItemTapHandler(new DataViewItemTapHandler() {
				@Override
				public void onItemTap(DataView dataView, int index, Element element, BaseModel record, EventObject eventObject, Object eOpts) {
					ExtElement item = Ext.get(eventObject.getTarget());
					if (!item.hasClass("x-innerhtml")) {
						eventObject.stopEvent();
					}

				}
			});
			this.addItemTouchStartHandler(new DataViewItemTouchStartHandler() {
				@Override
				public void onItemTouchStart(DataView dataView, int index, SimpleListItem element, BaseModel record, EventObject eventObject) {
					ExtElement item = Ext.get(eventObject.getTarget());
					if (!item.hasClass("x-innerhtml")) {
						eventObject.stopEvent();
					}

				}
			});

		}
	}

}
