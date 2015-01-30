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

import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.shared.client.core.XType;
import com.ait.toolkit.sencha.shared.client.dom.DomConfig;
import com.ait.toolkit.sencha.shared.client.dom.DomHelper;
import com.ait.toolkit.sencha.shared.client.dom.ExtElement;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Adapter between GWT {@link com.google.gwt.user.client.ui.Widget}'s and {@link com.ait.toolkit.sencha.touch.client.core.Component}'s. This class enables the use of pure GWT
 * component inside Touch4j panels
 */
public class WidgetComponent extends Component {

	private static int widgetComponentId = 0;

	public static final String hiddenDivID = "__touch4j_hidden";
	private Widget widget;
	private HandlerRegistration detachHandler;
	private JavaScriptObject jsComponent;

	static {
		bootstrap();
	}

	public WidgetComponent() {
		id = new StringBuilder().append("ext-").append(this.getXType()).append("-").append(++widgetComponentId).toString();
		JsoHelper.setAttribute(config, "id", id);
	}

	@Override
	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.ux.WidgetComponent();
	}-*/;

	@Override
	public String getXType() {
		return XType.WIDGET_COMPONENT.getValue();
	}

	private static native void bootstrap()/*-{
		$wnd.Ext.define('Ext.ux.WidgetComponent', {
			extend : 'Ext.Component',
			xtype : 'widgetComponent',
			widget : null,
			constructor : function(config) {
				this.initConfig(config);
				this.callParent(config);
			}
		});
	}-*/;

	public WidgetComponent(final Widget widget) {
		this();
		createHiddenDiv();
		this.widget = widget;
		setWidget(widget);
	}

	public static void createHiddenDiv() {
		ExtElement hiddenDiv = Ext.get(hiddenDivID);
		if (hiddenDiv == null) {
			DomConfig domConfig = new DomConfig("div", hiddenDivID, null);
			domConfig.setStyle("display:none;");
			DomHelper.append(RootPanel.getBodyElement(), domConfig);
		}
	}

	protected WidgetComponent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	protected native void setWidget(Widget w)/*-{
		if (w) {
			var jso = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();

			jso.widget = w;
			//a GWT widget must be attached to a GWT Panel for its events to fire.
			var attached = w.@com.google.gwt.user.client.ui.Widget::isAttached()();
			if (!attached) {
				var rp = @com.google.gwt.user.client.ui.RootPanel::get(Ljava/lang/String;)('__touch4j_hidden');
				rp.@com.google.gwt.user.client.ui.HasWidgets::add(Lcom/google/gwt/user/client/ui/Widget;)(jso.widget);
			}
			this.@com.ait.toolkit.sencha.touch.client.core.WidgetComponent::addWidgetDetachHandler()();

			var widgetEl = jso.widget.@com.google.gwt.user.client.ui.UIObject::getElement()();
			widgetEl.width = "100%";
			widgetEl.height = "100%";
			jso.element.dom.insertBefore(widgetEl, null); // insert at end
			this.@com.ait.toolkit.sencha.touch.client.core.WidgetComponent::jsComponent = jso;
		}
	}-*/;

	protected native void cleanUpJsComponent() /*-{
		var jso = this.@com.ait.toolkit.sencha.touch.client.core.WidgetComponent::jsComponent;
		if (jso) {
			var element = jso.element;
			var parent = element.dom.parentNode;
			if (parent) {
				parent.removeChild(element.dom);
			}
		}
		this.@com.ait.toolkit.sencha.touch.client.core.WidgetComponent::jsComponent = null;
	}-*/;

	protected void addWidgetDetachHandler() {
		if (this.widget != null) {
			detachHandler = this.widget.addAttachHandler(new AttachEvent.Handler() {
				boolean detaching = false;

				@Override
				public void onAttachOrDetach(AttachEvent event) {
					if (!detaching) {
						detaching = true;
						if (!event.isAttached() && getParent() instanceof HasWidgets) {
							((HasWidgets) getParent()).remove((Widget) event.getSource());
						}
						widget = null;
						if (detachHandler != null) {
							detachHandler.removeHandler();
							detachHandler = null;
						}
						setParentWidget(null);
						removeFromParent();
					}
				}
			});
		}
	}

	public native void setParentWidget(final Widget parent) /*-{
		this.@com.google.gwt.user.client.ui.Widget::parent = parent;
	}-*/;

	@Override
	protected void init() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.gwt.user.client.ui.Widget#removeFromParent()
	 */
	@Override
	public void removeFromParent() {
		super.removeFromParent();
		cleanUpJsComponent();
	}

}
