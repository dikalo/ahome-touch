package com.ait.toolkit.sencha.touch.client.ui;

import com.ait.toolkit.sencha.shared.client.core.Template;
import com.ait.toolkit.sencha.shared.client.core.XType;
import com.ait.toolkit.sencha.shared.client.data.Store;
import com.ait.toolkit.sencha.touch.client.events.dataview.ListDataViewContainerAddEvent;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.uibinder.client.UiConstructor;

public class ItemDisclosureListView extends ListView {

	private final static EventBus eventBus = new SimpleEventBus();

	protected ItemDisclosureListView(JavaScriptObject config) {
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
	public ItemDisclosureListView() {
		eventBus.addHandler(ListDataViewContainerAddEvent.TYPE, this);
	}

	public ItemDisclosureListView(Store store) {
		super(store);
	}

	@UiConstructor
	public ItemDisclosureListView(String itemTpl, Store store) {
		super(itemTpl, store);
	}

	public ItemDisclosureListView(String itemTemplate) {
		super(itemTemplate);
	}

	public ItemDisclosureListView(Template itemTemplate, Store store) {
		super(itemTemplate, store);
	}

	public ItemDisclosureListView(Template itemTemplate) {
		super(itemTemplate);
	}

	@Override
	protected void onConfigCreated() {
		this.setItemDisclosure(true);
	}

}
