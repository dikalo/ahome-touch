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
import com.ait.toolkit.sencha.touch.client.core.HasUi;
import com.ait.toolkit.sencha.touch.client.events.tabitem.TabItemAddEvent;
import com.ait.toolkit.sencha.touch.client.events.tabitem.TabItemRemoveEvent;
import com.ait.toolkit.sencha.touch.client.laf.Alignment;
import com.ait.toolkit.sencha.touch.client.laf.UI;
import com.ait.toolkit.sencha.touch.client.layout.CardLayout;
import com.ait.toolkit.sencha.touch.client.layout.HBoxLayout;
import com.ait.toolkit.sencha.touch.client.layout.Pack;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.Widget;

/**
 * Tab Panels are a great way to allow the user to switch between several pages that are all full screen. Each Component in the Tab Panel gets its own Tab, which shows the
 * Component when tapped on. Tabs can be positioned at the top or the bottom of the Tab Panel, and can optionally accept title and icon configurations.
 * 
 * @see <a href=http://docs.sencha.com/touch/2-0/#!/api/Ext.tab.Panel>Ext.tab.Panel </a>
 */

public class TabPanel extends Container implements HasUi {

	private final static EventBus eventBus = new SimpleEventBus();
	private JavaScriptObject layoutPeer;
	private String tabBarPosition;
	private int childIndex = 0;

	@Override
	protected native void init()/*-{
		var c = new $wnd.Ext.tab.Panel();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
	}-*/;

	protected TabPanel(JavaScriptObject jso) {
		super(jso);
	}

	@Override
	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		var layoutPeer = this.@com.ait.toolkit.sencha.touch.client.ui.TabPanel::layoutPeer;
		config.tabBarPosition = this.@com.ait.toolkit.sencha.touch.client.ui.TabPanel::tabBarPosition;
		if (layoutPeer != null) {
			config.layout = layoutPeer;
		}
		return new $wnd.Ext.tab.Panel(config);
	}-*/;

	@Override
	public String getXType() {
		return XType.TAB_PANEL.getValue();
	}

	public TabPanel() {
		this.setTabBarPosition(Alignment.TOP);
	}

	public TabPanel(CardLayout layout) {
		this.layoutPeer = layout.getJSO();
	}

	public TabPanel(Alignment tabBarPosition) {
		this();
		setTabBarPosition(tabBarPosition);
		this.getTabBar().setLayout(new HBoxLayout(Pack.CENTER));
	}

	public void add(TabItem tab) {
		tab.setParent(this);
		_add(tab);
		getChildren().add(tab);
		eventBus.fireEvent(new TabItemAddEvent(tab));
	}

	public void add(ToolBar toolBar) {
		this.setToolBar(toolBar);
	}

	public void remove(TabItem tab) {
		_remove(tab);
		getChildren().remove(tab);
		eventBus.fireEvent(new TabItemRemoveEvent(tab));
	}

	public void setTabBarPosition(Alignment position) {
		this.tabBarPosition = position.getValue();
		setTabBarPosition(position.getValue());
	}

	public native TabBar getTabBar()/*-{
		var tabPanel = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var tabBar = tabPanel.getTabBar();
		return @com.ait.toolkit.sencha.touch.client.ui.TabBar::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tabBar);
	}-*/;

	public Alignment getTabBarPosition() {
		return Alignment.valueOf(_getTabBarPosition().toUpperCase());
	}

	@Override
	public void setUi(UI ui) {
		setUi(ui.getValue());
	}

	@Override
	public UI getUi() {
		return UI.fromValue(_getUi());
	}

	@Override
	public void add(Widget w) {
		if (!(w instanceof TabItem)) {
			throw new IllegalStateException("TabPanel can only contain a child of type com.ait.toolkit.sencha.touch.client.ui.TabItem ");
		}
		add((TabItem) w);
	}

	public void setToolBar(ToolBar toolbar) {
		super.add(toolbar);
	}

	public native void setUi(String ui)/*-{
		var tabPanel = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		tabPanel.setUi(ui);
	}-*/;

	public native void updateBadget(int tabIndex, String text)/*-{
		var tabPanel = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		tabPanel.getTabBar().getComponent(tabIndex).setBadgeText(text);
	}-*/;

	public int getNextChildIndex() {
		int toReturn = childIndex;
		childIndex++;
		return toReturn;
	}

	private native String _getUi()/*-{
		var tabPanel = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return tabPanel.getUi();
	}-*/;

	public native void setTabBarPosition(String position)/*-{
		this.@com.ait.toolkit.sencha.touch.client.ui.TabPanel::tabBarPosition = position;
		var tabPanel = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		tabPanel.setTabBarPosition(position);
	}-*/;

	private native String _getTabBarPosition()/*-{
		var tabPanel = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		tabPanel.getTabBarPosition();
	}-*/;

	private native void _add(TabItem tab)/*-{
		var jso = tab.@com.ait.toolkit.sencha.touch.client.ui.TabItem::getJsObj()();
		var tabPanel = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		tabPanel.add(jso);
	}-*/;

	private native void _remove(TabItem tab)/*-{
		var jso = tab.@com.ait.toolkit.sencha.touch.client.ui.TabItem::getJsObj()();
		var tabPanel = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		tabPanel.remove(jso);
	}-*/;

}
