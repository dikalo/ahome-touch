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

import com.ait.toolkit.core.client.Function;
import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.shared.client.core.Size;
import com.ait.toolkit.sencha.shared.client.core.XType;
import com.ait.toolkit.sencha.shared.client.dom.DomUtil;
import com.ait.toolkit.sencha.shared.client.dom.ExtElement;
import com.ait.toolkit.sencha.touch.client.core.config.ComponentConfig;
import com.ait.toolkit.sencha.touch.client.core.config.Dock;
import com.ait.toolkit.sencha.touch.client.core.config.TouchAttribute;
import com.ait.toolkit.sencha.touch.client.events.HandlerRegistration;
import com.ait.toolkit.sencha.touch.client.events.component.BottomChangeHandler;
import com.ait.toolkit.sencha.touch.client.events.component.CenteredChangeHandler;
import com.ait.toolkit.sencha.touch.client.events.component.DestroyHandler;
import com.ait.toolkit.sencha.touch.client.events.component.DisabledChangeHandler;
import com.ait.toolkit.sencha.touch.client.events.component.DockedChangeHandler;
import com.ait.toolkit.sencha.touch.client.events.component.ErasedHandler;
import com.ait.toolkit.sencha.touch.client.events.component.FlexChangeHandler;
import com.ait.toolkit.sencha.touch.client.events.component.FloatingChangeHandler;
import com.ait.toolkit.sencha.touch.client.events.component.HeightChangeHandler;
import com.ait.toolkit.sencha.touch.client.events.component.HiddenChangeHandler;
import com.ait.toolkit.sencha.touch.client.events.component.HideHandler;
import com.ait.toolkit.sencha.touch.client.events.component.InitializeHandler;
import com.ait.toolkit.sencha.touch.client.events.component.LeftChangeHandler;
import com.ait.toolkit.sencha.touch.client.events.component.MaxHeightChangeHandler;
import com.ait.toolkit.sencha.touch.client.events.component.MaxWidthChangeHandler;
import com.ait.toolkit.sencha.touch.client.events.component.MinHeightChangeHandler;
import com.ait.toolkit.sencha.touch.client.events.component.MinWidthChangeHandler;
import com.ait.toolkit.sencha.touch.client.events.component.PaintedHandler;
import com.ait.toolkit.sencha.touch.client.events.component.ResizeHandler;
import com.ait.toolkit.sencha.touch.client.events.component.RightChangeHandler;
import com.ait.toolkit.sencha.touch.client.events.component.ShowHandler;
import com.ait.toolkit.sencha.touch.client.events.component.TopChangeHandler;
import com.ait.toolkit.sencha.touch.client.events.component.UpdateDataHandler;
import com.ait.toolkit.sencha.touch.client.events.component.WidthChangeHandler;
import com.ait.toolkit.sencha.touch.client.laf.UI;
import com.ait.toolkit.sencha.touch.client.layout.card.AnimationType;
import com.ait.toolkit.sencha.touch.client.layout.card.CardAnimation;
import com.ait.toolkit.sencha.touch.client.ui.Container;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Element;

/**
 * <p>
 * Base class for all Ext components. All subclasses of Component may participate in the automated Ext component lifecycle of creation, rendering and destruction which is provided
 * by the Container class. Components may be added to a Container through the items config option at the time the Container is created, or they may be added dynamically via the add
 * method.
 * </p>
 * 
 * <p>
 * The Component base class has built-in support for basic hide/show and enable/disable behavior.
 * </p>
 * 
 * <p>
 * All Components are registered with the Ext.ComponentMgr on construction so that they can be referenced at any time via Ext.getCmp, passing the id.
 * </p>
 * 
 * <p>
 * All user-developed visual widgets that are required to participate in automated lifecycle and size management should subclass Component (or Ext.BoxComponent if managed box model
 * handling is required, ie height and width management).
 * </p>
 * <p>
 * Every component has a specific xtype. This is the list of all valid xtypes:
 * </p>
 * 
 * <pre>
 * <p/>
 * xtype            Class
 * -------------    ------------------
 * button           Button
 * component        Component
 * container        Container
 * dataview         DataView
 * panel            Panel
 * toolbar          Toolbar
 * spacer           Spacer
 * tabpanel         TabPanel
 * <p/>
 * 
 * Form components
 * ---------------------------------------
 * formpanel        FormPanel
 * checkboxField    Checkbox
 * selectfield      Select
 * field            Field
 * fieldset         FieldSet
 * hiddenField      Hidden
 * numberfield      Number
 * radiofield       Radio
 * textareafield    TextArea
 * textfield        Text
 * togglefield      Toggle
 * </pre>
 */
public abstract class Component extends TouchWidget {

	protected JavaScriptObject configPrototype;
	private boolean initHidden = false;
	private boolean initDisabled = false;
	private static final String POST_RENDER = "post-render";

	protected abstract void init();

	protected native JavaScriptObject cloneConfig(JavaScriptObject config)/*-{
		var clone = {};
		var id = $wnd.Ext.id();
		var cfg = $wnd.Ext.applyIf(clone, config);
		cfg.id = id; // prevent dup id
		return clone;
	}-*/;

	protected static native String getConfigAsString(JavaScriptObject jsObj) /*-{
		var props = '{';
		for ( var k in jsObj) {
			props += '\n[' + k + '=>' + jsObj[k] + ']';
		}
		return props + '}';
	}-*/;

	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}

	protected Component(JavaScriptObject jsObj) {
		id = JsoHelper.getAttribute(jsObj, TouchAttribute.ID.getValue());
		config = jsObj;
		setElement(getElement(jsObj));
		init();
	}

	/**
	 * Create a new Component.
	 */
	public Component() {
		id = Ext.generateId("ext-ait-");

		initConfig();
		if (config == null) {
			config = JsoHelper.createObject();
		}

		JsoHelper.setAttribute(config, TouchAttribute.COMP_J.getValue(), this);
		JsoHelper.setAttribute(config, TouchAttribute.ID.getValue(), id);
		JsoHelper.setAttribute(config, TouchAttribute.XTYPE.getValue(), getXType());
		onConfigCreated();
		init();
	}

	/**
	 * Component Constructor. Applies the Component to an existing element.
	 * 
	 * @param element
	 *            the Element to apply the Component to
	 */
	public Component(Element element) {
		id = DomUtil.getID(element);
		if (id == null) {
			id = Ext.generateId();
			DomUtil.setID(element, id);
		}
		config = JsoHelper.createObject();
		setId(id);
		getOrCreateJsObj();
		init();
	}

	/**
	 * Component with config options
	 * 
	 * @param configOptions
	 */
	public Component(ComponentConfig configOptions) {
		this(configOptions.getJsObj());
	}

	/**
	 * Creates a Component object reference for an already rendered Component.
	 * 
	 * @param id
	 *            the Component ID
	 */
	public Component(String id) {
		setElement(getElement(getComponentJS(id)));
		init();
	}

	/**
	 * Adds a CSS class (or classes) to this Component's rendered element
	 * 
	 * @param cls
	 * @param prefix
	 * @param suffix
	 */
	public native void addCls(String cls, String prefix, String suffix) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		component.addCls(cls, prefix, suffix);
	}-*/;

	public native void destroy() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null)
			component.destroy();
	}-*/;

	public void disable() {
		if (!isRendered()) {
			initDisabled = true;
			setAttribute(TouchAttribute.DISABLED.getValue(), true, true);
			addEventHandler("painted", new Function() {
				public void execute() {
					disableRendered();
				}
			});
		} else {
			disableRendered();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.FocusWidget#enable()
	 */

	public void enable() {
		if (!isRendered()) {
			setAttribute(TouchAttribute.DISABLED.getValue(), false, true);
			addEventHandler(TouchAttribute.RENDER.getValue(), new Function() {
				public void execute() {
					enableRendered();
				}
			});
		} else {
			enableRendered();
		}
	}

	public String getHTML() {
		return this.getHtml();
	}

	public void setHTML(String html) {
		this.setHtml(html);
	}

	/**
	 * Returns the value of baseCls.
	 * 
	 * @return baseCls
	 */
	public native String getBaseCls() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getBaseCls();
		}
	}-*/;

	/**
	 * Returns the value of border.
	 * 
	 * @param <T>
	 * 
	 *            Returns Number/String
	 */
	public native <T> T getBorder() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getBorder();
		}
	}-*/;

	/**
	 * Returns the value of bottom.
	 * 
	 * @param <T>
	 * @return Number/Boolean
	 */
	public native <T> T getBottom() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getBottom();
		}
	}-*/;

	/**
	 * Returns the value of centered.
	 * 
	 * @return Boolean
	 */
	public native boolean isCentered() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getCentered();
		}
	}-*/;

	/**
	 * Returns the value of cls.
	 * 
	 * @return String
	 */
	public native String getCls() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getCls();
		}
	}-*/;

	/**
	 * Returns the value of data.
	 * 
	 * @return Object
	 */
	public native <T> T getData() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getData();
		}
	}-*/;

	/**
	 * Returns the value of disabledCls.
	 * 
	 * @return String
	 */
	public native String getDisabledCls() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getDisabledCls();
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.FocusWidget#getDraggable()
	 */

	public native <T> T getDraggable() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getDraggable();
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.FocusWidget#getDroppable()
	 */

	public native <T> T getDroppable() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getDroppable();
		}
	}-*/;

	public native ExtElement getEl() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var el = component.element;
		if (el == null || el === undefined) {
			return null;
		} else {
			return @com.ait.toolkit.sencha.shared.client.dom.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.BoxWidget#getHeight()
	 */

	public native int getHeight() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getHeight();
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.HasHtml#getHtml()
	 */

	public native String getHtml() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getHtml();
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.BoxWidget#getLeft()
	 */

	public native <T> T getLeft() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getLeft();
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.BoxWidget#getMargin()
	 */

	public native <T> T getMargin() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getMargin();
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.FocusWidget#isMasked()
	 */

	public native boolean isMasked() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getMasked();
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.FocusWidget#isModal()
	 */

	public native boolean isModal() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getModal();
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.BoxWidget#getPadding()
	 */

	public native <T> T getPadding() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getPadding();
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.FocusWidget#getRenderTo()
	 */

	public Element getRenderTo() {
		return JsoHelper.getAttributeAsElement(config, TouchAttribute.RENDER_TO.getValue());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.FocusWidget#getRenderTpl()
	 */

	public native <T> T getRenderTpl() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getRenderTpl();
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.BoxWidget#getRight()
	 */

	public native <T> T getRight() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getRight();
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.BoxWidget#getSize()
	 */

	public native Size getSize() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return @com.ait.toolkit.sencha.shared.client.core.Size::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(component
					.getSize());
		}
	}-*/;

	/**
	 * Returns the value of style.
	 * 
	 * @param <T>
	 * @return String/Object
	 */
	public native <T> T getStyle() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getStyle();
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.HasHtml#getStyleHtmlCls()
	 */

	public native String getStyleHtmlCls() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getStyleHtmlCls();
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.HasHtml#hasStyleHtmlContent()
	 */

	public native boolean hasStyleHtmlContent() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getStyleHtmlContent();
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.BoxWidget#getTop()
	 */

	public native <T> T getTop() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getTop();
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.HasHtml#getTpl()
	 */

	public native <T> T getTpl() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getTpl();
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.HasHtml#getTplWriteMode()
	 */

	public native String getTplWriteMode() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getTplWriteMode();
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.BoxWidget#getWidth()
	 */

	public native int getWidth() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getWidth();
		}
	}-*/;

	/**
	 * Returns this component's xtype hierarchy as a slash-delimited string. For a list of all available xtypes, see the Component class javadocs.
	 * <p/>
	 * 
	 * <pre>
	 * <code>
	 * <p/>
	 * Text field = new Text();
	 * field.getXTypes() returns "component/box/field/textfield"
	 * </code>
	 * </pre>
	 * 
	 * @return the xtype hierarchy string
	 */
	public native String getXTypes() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getXTypes();
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.FocusWidget#getZIndex()
	 */

	public native double getZIndex() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getZIndex();
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.FocusWidget#hide()
	 */

	public void hide() {

		hideRendered();
		if (!isRendered()) {
			initHidden = true;
			this.addEventHandler(TouchAttribute.RENDERED_CHANGE.getValue(), new Function() {

				public void execute() {
					Scheduler.get().scheduleDeferred(new ScheduledCommand() {

						public void execute() {
							hideRendered();
						}
					});
				}
			});
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.FocusWidget#isDisabled()
	 */

	public boolean isDisabled() {
		if (!isRendered()) {
			return initDisabled;
		} else {
			return isDisabledRendered();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.FocusWidget#isHidden()
	 */

	public boolean isHidden() {
		if (!isRendered()) {
			return initHidden;
		} else {
			return isHiddenRendered();
		}
	}

	/**
	 * Tests whether or not this component is of a specific xtype. This can test whether this component is descended from the xtype (default) or whether it is directly of the xtype
	 * specified (shallow = true). For a list of all available xtypes, see the {@link Component} header. Example usage:
	 * <p/>
	 * 
	 * <pre>
	 * <code>
	 * <p/>
	 * <p/>
	 * Text t = new Text();
	 * boolean isText = t.isXType('textfield');        // true
	 * boolean isBoxSubclass = t.isXType('box');       // true, descended from BoxComponent
	 * boolean  isBoxInstance = t.isXType('box', true); // false, not a direct BoxComponent instance
	 * <p/>
	 * </code>
	 * </pre>
	 * 
	 * @param xtype
	 *            the xtype to check for this component
	 * @return true if is style
	 */
	public native boolean isXType(String xtype) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return component.isXType(xtype);
	}-*/;

	/**
	 * Tests whether or not this component is of a specific xtype. This can test whether this component is descended from the xtype (default) or whether it is directly of the xtype
	 * specified (shallow = true). For a list of all available xtypes, see the {@link Component} header. Example usage:
	 * <p/>
	 * 
	 * <pre>
	 * <code>
	 * <p/>
	 * <p/>
	 * Text t = new Text();
	 * boolean isText = t.isXType('textfield');        // true
	 * boolean isBoxSubclass = t.isXType('box');       // true, descended from BoxComponent
	 * boolean  isBoxInstance = t.isXType('box', true); // false, not a direct BoxComponent instance
	 * <p/>
	 * </code>
	 * </pre>
	 * 
	 * @param xtype
	 *            the xtype to check for this component
	 * @param shallow
	 *            false to check whether this component is descended from the xtype (this is the default), or true to check whether this component is directly of the specified
	 *            xtype.
	 * @return true if is style
	 */
	public native boolean isXType(String xtype, boolean shallow) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return component.isXType(xtype, shallow);
	}-*/;

	public native void removeCls(String cls, String prefix, String suffix) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.removeCls(cls, prefix, suffix);
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.FocusWidget#setBaseCls(java. lang.String )
	 */

	public native void setBaseCls(String baseCls) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setBaseCls(baseCls);
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.BoxWidget#setBorder(double)
	 */

	public native void setBorder(double value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setBorder(value);
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.BoxWidget#setBorder(java.lang .String)
	 */

	public native void setBorder(String value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setBorder(value);
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.BoxWidget#setBottom(double)
	 */

	public native void setBottom(double value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setBottom(value);
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.BoxWidget#setBottom(boolean)
	 */

	public native void setBottom(boolean value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setBottom(value);
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.BoxWidget#setCentered(boolean)
	 */

	public native void setCentered(boolean value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setCentered(value);
		}
	}-*/;

	public native void setCls(String cls) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setCls(cls);
		}
	}-*/;

	/**
	 * Sets the value of data.
	 * 
	 * @param value
	 *            , Object
	 * 
	 */
	public void setFullScreen(boolean value) {
		JsoHelper.setAttribute(config, TouchAttribute.FULL_SCREEN.getValue(), value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.FocusWidget#setDisabled(boolean)
	 */

	public native void setDisabled(boolean value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setDisabled(value);
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.FocusWidget#setDisabledCls(java .lang .String)
	 */

	public native void setDisabledCls(String value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setDisabledCls(value);
		}
	}-*/;

	/**
	 * Sets the value of docked.
	 * 
	 * @param dock
	 */
	public void setDocked(Dock dock) {
		setDocked(dock.getValue());
		/**
		 * TODO This is a work around for a Sencha Bug. Documented as issue #1 in github.
		 */
		if (dock == Dock.BOTTOM) {
			Scheduler.get().scheduleDeferred(new ScheduledCommand() {

				public void execute() {
					com.google.gwt.dom.client.Element parent = getElement().getParentElement();
					Element child = getElement();
					getElement().removeFromParent();
					parent.appendChild(child);
				}
			});
		}
	}

	public Dock getDocked() {
		return Dock.valueOf(_getDocked());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.FocusWidget#setDraggable(java .lang .Object)
	 */

	public native void setDraggable(Object value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setDraggable(value);
		}
	}-*/;

	public native void setDroppable(Object value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setDroppable(value);
		}
	}-*/;

	public native void setHeight(int value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setHeight(value);
		}
	}-*/;

	public native void setHeight(String value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setHeight(value);
		}
	}-*/;

	public native void setHidden(boolean value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setHidden(value);
		}
	}-*/;

	public native void setHtml(String value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setHtml(value);
		}
	}-*/;

	public native void setLeft(int value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setLeft(value);
		}
	}-*/;

	public native void setLeft(boolean value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setLeft(value);
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.BoxWidget#setMargin(int)
	 */

	public native void setMargin(int value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setMargin(value);
		}
	}-*/;

	/**
	 * Sets the value of margin.
	 * 
	 * @param value
	 */
	public native void setMargin(String value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setMargin(value);
		}
	}-*/;

	/**
	 * Sets the value of masked.
	 * 
	 * @param value
	 */
	public native void setMasked(boolean value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setMasked(value);
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.FocusWidget#setModal(boolean)
	 */

	public native void setModal(boolean value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setModal(value);
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.BoxWidget#setPadding(int)
	 */

	public native void setPadding(int value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setPadding(value);
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.BoxWidget#setPadding(java.lang .String)
	 */

	public native void setPadding(String value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setPadding(value);
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.FocusWidget#setRenderTo(com. google .gwt.user.client.Element)
	 */

	public native void setRenderTo(Element value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setRenderTo(value);
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.FocusWidget#setRenderTpl(java .lang .Object)
	 */

	public native void setRenderTpl(Object value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setRenderTpl(value);
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.BoxWidget#setRight(int)
	 */

	public native void setRight(int value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setRight(value);
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.BoxWidget#setRight(boolean)
	 */

	public native void setRight(boolean value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setRight(value);
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.BoxWidget#setSize(double, double)
	 */

	public native void setSize(double width, double height) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setSize(width, height);
		}
	}-*/;

	public void setSize(String width, String height) {
		setWidth(width);
		setHeight(height);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.BoxWidget#setSize(com.emitrom .gwt4 .touch.client.core.Size)
	 */

	public void setSize(Size size) {
		this.setSize(size.getWidth(), size.getHeight());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.FocusWidget#setStyle(java.lang .String)
	 */

	public native void setStyle(String value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setStyle(value);
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.FocusWidget#setStyle(java.lang .Object)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.HasHtml#setStyle(java.lang.Object )
	 */

	public native void setStyle(Object value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setStyle(value);
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.HasHtml#setStyleHtmlCls(java .lang. String)
	 */

	public native void setStyleHtmlCls(String value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setStyleHtmlCls(value);
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.HasHtml#setStyleHtmlContent( boolean)
	 */

	public native void setStyleHtmlContent(boolean value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setStyleHtmlContent(value);
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.BoxWidget#setTop(int)
	 */

	public native void setTop(int value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setTop(value);
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.BoxWidget#setTop(boolean)
	 */

	public native void setTop(boolean value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setTop(value);
		}
	}-*/;

	/**
	 * Sets the value of tpl.
	 * 
	 * @param value
	 */
	public native void setTpl(Object value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setTpl(value);
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.HasHtml#setTplWriteMode(java .lang. String)
	 */

	public native void setTplWriteMode(String value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setTplWriteMode(value);
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.BoxWidget#setWidth(int)
	 */

	public native void setWidth(int value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setWidth(value);
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.FocusWidget#setZIndex(int)
	 */

	public native void setZIndex(int value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setZIndex(value);
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.FocusWidget#show()
	 */

	public native void show() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.show();
		}
	}-*/;

	public native void showBy(Component target) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component
					.showBy(target.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()());
		}
	}-*/;

	// public void showBy(Component component, ShowByAlignment alignment) {
	// _showBy(component, alignment.getValue());
	// }

	public native void showBy(Component target, String alignment) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component
					.showBy(
							target.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()(),
							alignment);
		}
	}-*/;

	/**
	 * Walks up the ownerCt axis looking for an ancestor Container which matches the passed simple selector.
	 * 
	 * Example: var owningTabPanel = grid.up('tabpanel');
	 * 
	 * @param value
	 */
	public native Container up(String value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			var o = component.up(value);
			if (o) {
				return @com.ait.toolkit.sencha.touch.client.ui.Container::new(Lcom/google/gwt/core/client/JavaScriptObject;)(o);
			}
			return null;
		}
		return null;
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.FocusWidget#update()
	 */

	@Deprecated
	public native void update() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.update();
		}
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.HasHtml#updateStyleHtmlCls(java .lang .Object, java.lang.Object)
	 */

	public native void updateStyleHtmlCls(Object newHtmlCls, Object oldHtmlCls) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.updateStyleHtmlCls(newHtmlCls, oldHtmlCls);
		}
	}-*/;

	public native void setListItemIndex(int index)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		component.listItemIndex = index;
	}-*/;

	public native int getListItemIndex()/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component.listItemIndex) {
			return component.listItemIndex;
		}
		return 0;

	}-*/;

	/**
	 * Allow the component to fire these events.
	 * 
	 * @param events
	 *            the events
	 */
	public void addEvents(String[] events) {
		for (int i = 0; i < events.length; i++) {
			String event = events[i];
			addEvent(event);
		}
	}

	public String getXType() {
		return XType.COMPONENT.getValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.FocusWidget#setVisible(boolean)
	 */

	public void setVisible(boolean visible) {
		if (visible) {
			show();
		} else {
			hide();
		}
	}

	/**
	 * Add a raw event listener.
	 * 
	 * @param event
	 *            the event name
	 * @param fn
	 *            the function to execute
	 */
	public native void addEventHandler(String event, Function fn)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		component.addListener(event, function() {
			return fn.@com.ait.toolkit.core.client.Function::execute()();
		});
	}-*/;

	/**
	 * The unique id of this component (defaults to an auto-assigned id).
	 * <p/>
	 * <br>
	 * <b>Note:</b> ID's cannot be changed after the component has been rendered.
	 * 
	 * @param id
	 *            the components ID
	 * @throws IllegalStateException
	 *             this property cannot be changed after the Component has been rendered
	 */
	public final void setId(String id) throws IllegalStateException {
		setAttribute(TouchAttribute.ID.getValue(), id, false);
		this.id = id;
	}

	/**
	 * @return the ID of the Component
	 */
	public String getId() {
		return id;
	}

	/**
	 * sets the title attribute of this component. This title will only be displayed when the containing parent of this element support titled children
	 */
	public void setTitle(String title) {
		setAttribute(TouchAttribute.TITLE.getValue(), title, true, true);
	}

	/**
	 * sets the align attribute of this component.
	 */
	public void setAlign(String title) {
		setAttribute(TouchAttribute.ALIGN.getValue(), title, true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ait.toolkit.sencha.touch.client.core.FocusWidget#setRenderToID(java .lang .String)
	 */

	public void setRenderToID(String elemID) throws IllegalStateException {
		setAttribute(TouchAttribute.RENDER_TO.getValue(), elemID, false);
	}

	public void setFlex(int value) {
		getElement().getStyle().setProperty("webkitBoxFlex", String.valueOf(value));
	}

	public String toString() {
		if (!isRendered()) {
			return "<<Lazy Component>>::" + getXType() + ", ID:" + getId();
		} else {
			return super.toString();
		}
	}

	public boolean equals(Object obj) {
		if (obj instanceof Component) {
			if (obj == this) {
				return true;
			} else {
				Component other = (Component) obj;
				if (other.getId().equals(getId())) {
					return true;
				}
			}
			return false;
		} else {
			return false;
		}
	}

	public int hashCode() {
		return getId().hashCode();
	}

	/**
	 * set the list of components as plugin for this component
	 * 
	 * @param components
	 *            , array of plugins
	 */
	public void setPlugins(Component... components) {
		JsArray<JavaScriptObject> peers = JsArray.createArray().cast();
		for (Component c : components) {
			peers.push(c.getOrCreateJsObj());
		}
		_setPlugins(peers);
	}

	/**
	 * Add the given component as pluging
	 * 
	 * @param component
	 *            , the component to add as plugin
	 */
	public void addPlugin(Component component) {
		_setPlugins(component.getOrCreateJsObj());
	}

	/**
	 * sets the show animation
	 */
	public void setShowAnimation(CardAnimation animation) {
		_setShowAnimation(animation.getJSO());
	}

	/**
	 * sets the show animation
	 */
	public native void setShowAnimation(String value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setShowAnimation(value);
		}
	}-*/;

	public void setShowAnimation(AnimationType animationType) {
		setShowAnimation(animationType.getValue());
	}

	/**
	 * sets the hide animation
	 */
	public void setHideAnimation(CardAnimation animation) {
		_setHideAnimation(animation.getJSO());
	}

	public void setHideAnimation(AnimationType animationType) {
		setHideAnimation(animationType.getValue());
	}

	/**
	 * sets the hide animation
	 */
	public native void setHideAnimation(String value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setHideAnimation(value);
		}
	}-*/;

	public void setUi(UI ui) {
		setUi(ui.getValue());
	}

	public UI getUi() {
		return UI.fromValue(_getUi());
	}

	/**
	 * show this component
	 */
	public void show(CardAnimation animation) {
		_show(animation.getJSO());
	}

	/**
	 * hide this component
	 */
	public void hide(CardAnimation animation) {
		_hide(animation.getJSO());
	}

	/**
	 * Certain properties can only be set right after the config has been created Override this method to set set those type of properties
	 */
	protected void onConfigCreated() {

	}

	/**
	 * hide this component
	 */
	public native void hide(boolean value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.hide(value);
		}
	}-*/;

	private native void _hide(JavaScriptObject value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.hide(value);
		}
	}-*/;

	/**
	 * show this component
	 */
	public native void show(boolean value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.show(value);
		}
	}-*/;

	private native void _show(JavaScriptObject value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.show(value);
		}
	}-*/;

	private native void _setShowAnimation(JavaScriptObject value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setShowAnimation(value);
		}
	}-*/;

	private native void _setHideAnimation(JavaScriptObject value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setHideAnimation(value);
		}
	}-*/;

	private native void _setPlugins(JavaScriptObject values)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		component.setPlugins(values);
	}-*/;

	private native void disableRendered() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		component.disable();
	}-*/;

	private native void enableRendered() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		component.enable();
	}-*/;

	private native void hideRendered() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		component.hide();
	}-*/;

	private native void showRendered() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		component.show();
	}-*/;

	// --------------------- config properties --------------------------

	public native void setDocked(String value) /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setDocked(value);
		}
	}-*/;

	// Events
	public native HandlerRegistration addBottomChangeHandler(BottomChangeHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, v, oldV) {
			var comp = @com.ait.toolkit.sencha.touch.client.core.Component::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.component.BottomChangeEvent::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/Object;Ljava/lang/Object;)(comp,v,oldV);
			handler.@com.ait.toolkit.sencha.touch.client.events.component.BottomChangeHandler::onBottomChange(Lcom/ait/toolkit/sencha/touch/client/events/component/BottomChangeEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.component.BottomChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addCenteredChangeHandler(CenteredChangeHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, v, oldV) {
			var comp = @com.ait.toolkit.sencha.touch.client.core.Component::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.component.CenteredChangeEvent::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;ZZ)(comp,v,oldV);
			handler.@com.ait.toolkit.sencha.touch.client.events.component.CenteredChangeHandler::onCenterdChange(Lcom/ait/toolkit/sencha/touch/client/events/component/CenteredChangeEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.component.CenteredChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addDestroyHandler(DestroyHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c) {
			var comp = @com.ait.toolkit.sencha.touch.client.core.Component::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.component.DesktroyEvent::new()();
			handler.@com.ait.toolkit.sencha.touch.client.events.component.DestroyHandler::onDestroy(Lcom/ait/toolkit/sencha/touch/client/events/component/DesktroyEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.component.DesktroyEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addDisabledChangeHandler(DisabledChangeHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, v, oldV) {
			var comp = @com.ait.toolkit.sencha.touch.client.core.Component::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.component.DisabledChangeEvent::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;ZZ)(comp,v,oldV);
			handler.@com.ait.toolkit.sencha.touch.client.events.component.DisabledChangeHandler::onDisabledChange(Lcom/ait/toolkit/sencha/touch/client/events/component/DisabledChangeEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.component.DisabledChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addDockedChangeHandler(DockedChangeHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, v, oldV) {
			var comp = @com.ait.toolkit.sencha.touch.client.core.Component::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.component.DockedChangeEvent::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Ljava/lang/String;)(comp,v,oldV);
			handler.@com.ait.toolkit.sencha.touch.client.events.component.DockedChangeHandler::onDockedChange(Lcom/ait/toolkit/sencha/touch/client/events/component/DockedChangeEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.component.DockedChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addErasedHandler(ErasedHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c) {
			var comp = @com.ait.toolkit.sencha.touch.client.core.Component::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.component.ErasedEvent::new()();
			handler.@com.ait.toolkit.sencha.touch.client.events.component.ErasedHandler::onErased(Lcom/ait/toolkit/sencha/touch/client/events/component/ErasedEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.component.ErasedEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addFlexChangeHandler(FlexChangeHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, v, oldV) {
			var comp = @com.ait.toolkit.sencha.touch.client.core.Component::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.component.FlexChangeEvent::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;II)(comp,v,oldV);
			handler.@com.ait.toolkit.sencha.touch.client.events.component.FlexChangeHandler::onFlexChange(Lcom/ait/toolkit/sencha/touch/client/events/component/FlexChangeEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.component.FlexChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addFloatingChangeHandler(FloatingChangeHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, v) {
			var comp = @com.ait.toolkit.sencha.touch.client.core.Component::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.component.FloatingChangeEvent::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Z)(comp,v);
			handler.@com.ait.toolkit.sencha.touch.client.events.component.FloatingChangeHandler::onFloatingChange(Lcom/ait/toolkit/sencha/touch/client/events/component/FloatingChangeEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.component.FloatingChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addFullScreenHandler(DestroyHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c) {
			var comp = @com.ait.toolkit.sencha.touch.client.core.Component::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.component.DesktroyEvent::new()();
			handler.@com.ait.toolkit.sencha.touch.client.events.component.DestroyHandler::onDestroy(Lcom/ait/toolkit/sencha/touch/client/events/component/DesktroyEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.component.FullScreenEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addHeightChangeHandler(HeightChangeHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, v, oldV) {
			var comp = @com.ait.toolkit.sencha.touch.client.core.Component::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.component.HeightChangeEvent::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/Object;Ljava/lang/Object;)(comp,v,oldV);
			handler.@com.ait.toolkit.sencha.touch.client.events.component.HeightChangeHandler::onHeightChange(Lcom/ait/toolkit/sencha/touch/client/events/component/HeightChangeEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.component.HeightChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addHiddenChangeHandler(HiddenChangeHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, v, oldV) {
			var comp = @com.ait.toolkit.sencha.touch.client.core.Component::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.component.HiddenChangeEvent::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;ZZ)(comp,v,oldV);
			handler.@com.ait.toolkit.sencha.touch.client.events.component.HiddenChangeHandler::onHiddenChange(Lcom/ait/toolkit/sencha/touch/client/events/component/HiddenChangeEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.component.HiddenChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addHideHandler(HideHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c) {
			var comp = @com.ait.toolkit.sencha.touch.client.core.Component::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.component.HideEvent::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;)(comp);
			handler.@com.ait.toolkit.sencha.touch.client.events.component.HideHandler::onHide(Lcom/ait/toolkit/sencha/touch/client/events/component/HideEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.component.HideEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addInitializeHandler(InitializeHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c) {
			var comp = @com.ait.toolkit.sencha.touch.client.core.Component::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.component.InitializeEvent::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;)(comp);
			handler.@com.ait.toolkit.sencha.touch.client.events.component.InitializeHandler::onInitialize(Lcom/ait/toolkit/sencha/touch/client/events/component/InitializeEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.component.InitializeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addLeftChangeHandler(LeftChangeHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, v, oldV) {
			var comp = @com.ait.toolkit.sencha.touch.client.core.Component::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.component.LeftChangeEvent::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/Object;Ljava/lang/Object;)(comp,v,oldV);
			handler.@com.ait.toolkit.sencha.touch.client.events.component.LeftChangeHandler::onLeftChange(Lcom/ait/toolkit/sencha/touch/client/events/component/LeftChangeEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.component.LeftChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addMaxHeightChangeHandler(MaxHeightChangeHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, v, oldV) {
			var comp = @com.ait.toolkit.sencha.touch.client.core.Component::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.component.MaxHeightChangeEvent::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/Object;Ljava/lang/Object;)(comp,v,oldV);
			handler.@com.ait.toolkit.sencha.touch.client.events.component.MaxHeightChangeHandler::onMaxHeightChange(Lcom/ait/toolkit/sencha/touch/client/events/component/MaxHeightChangeEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.component.MaxHeightChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addMaxWidthChangeHandler(MaxWidthChangeHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, v, oldV) {
			var comp = @com.ait.toolkit.sencha.touch.client.core.Component::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.component.MaxWidthChangeEvent::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/Object;Ljava/lang/Object;)(comp,v,oldV);
			handler.@com.ait.toolkit.sencha.touch.client.events.component.MaxWidthChangeHandler::onMaxWidthChange(Lcom/ait/toolkit/sencha/touch/client/events/component/MaxWidthChangeEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.component.MaxWidthChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addMinHeightChangeHandler(MinHeightChangeHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, v, oldV) {
			var comp = @com.ait.toolkit.sencha.touch.client.core.Component::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.component.MinHeightChangeEvent::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/Object;Ljava/lang/Object;)(comp,v,oldV);
			handler.@com.ait.toolkit.sencha.touch.client.events.component.MinHeightChangeHandler::onMinHeightChange(Lcom/ait/toolkit/sencha/touch/client/events/component/MinHeightChangeEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.component.MinHeightChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addMinWidthChangeHandler(MinWidthChangeHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, v, oldV) {
			var comp = @com.ait.toolkit.sencha.touch.client.core.Component::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.component.MinWidthChangeEvent::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/Object;Ljava/lang/Object;)(comp,v,oldV);
			handler.@com.ait.toolkit.sencha.touch.client.events.component.MinWidthChangeHandler::onMinWidthChange(Lcom/ait/toolkit/sencha/touch/client/events/component/MinWidthChangeEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.component.MinWidthChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addPaintedHandler(PaintedHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(e) {
			var el = @com.ait.toolkit.sencha.shared.client.dom.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
			var event = @com.ait.toolkit.sencha.touch.client.events.component.PaintedEvent::new(Lcom/ait/toolkit/sencha/shared/client/dom/ExtElement;)(el);
			handler.@com.ait.toolkit.sencha.touch.client.events.component.PaintedHandler::onPainted(Lcom/ait/toolkit/sencha/touch/client/events/component/PaintedEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.component.PaintedEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addResizeHandler(ResizeHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(e) {
			var el = @com.ait.toolkit.sencha.shared.client.dom.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
			var event = @com.ait.toolkit.sencha.touch.client.events.component.ResizeEvent::new(Lcom/ait/toolkit/sencha/shared/client/dom/ExtElement;)(el);
			handler.@com.ait.toolkit.sencha.touch.client.events.component.ResizeHandler::onResize(Lcom/ait/toolkit/sencha/touch/client/events/component/ResizeEvent;)(event);
		};
		var eventName = @com.ait.toolkit.sencha.touch.client.events.component.ResizeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addRightChangeHandler(RightChangeHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, v, oldV) {
			var comp = @com.ait.toolkit.sencha.touch.client.core.Component::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.component.RightChangeEvent::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/Object;Ljava/lang/Object;)(comp,v,oldV);
			handler.@com.ait.toolkit.sencha.touch.client.events.component.RightChangeHandler::onRightChange(Lcom/ait/toolkit/sencha/touch/client/events/component/RightChangeEvent;)(event);
		}
		var eventName = @com.ait.toolkit.sencha.touch.client.events.component.RightChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addShowHandler(ShowHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c) {
			var comp = @com.ait.toolkit.sencha.touch.client.core.Component::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.component.ShowEvent::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;)
			handler.@com.ait.toolkit.sencha.touch.client.events.component.ShowHandler::onShow(Lcom/ait/toolkit/sencha/touch/client/events/component/ShowEvent;)(event);
		}
		var eventName = @com.ait.toolkit.sencha.touch.client.events.component.ShowEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addTopChangeHandler(TopChangeHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, v, oldV) {
			var comp = @com.ait.toolkit.sencha.touch.client.core.Component::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.component.TopChangeEvent::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/Object;Ljava/lang/Object;)(comp,v,oldV);
			handler.@com.ait.toolkit.sencha.touch.client.events.component.TopChangeHandler::onTopChange(Lcom/ait/toolkit/sencha/touch/client/events/component/TopChangeEvent;)(event);
		}
		var eventName = @com.ait.toolkit.sencha.touch.client.events.component.TopChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addwidthChangeHandler(WidthChangeHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, v, oldV) {
			var comp = @com.ait.toolkit.sencha.touch.client.core.Component::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.component.WidthChangeEvent::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/Object;Ljava/lang/Object;)(comp,v,oldV);
			handler.@com.ait.toolkit.sencha.touch.client.events.component.WidthChangeHandler::onWidthChange(Lcom/ait/toolkit/sencha/touch/client/events/component/WidthChangeEvent;)(event)
		}
		var eventName = @com.ait.toolkit.sencha.touch.client.events.component.WidthChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	public native HandlerRegistration addUpdateDataHandler(UpdateDataHandler handler)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, d) {
			var comp = @com.ait.toolkit.sencha.touch.client.core.Component::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ait.toolkit.sencha.touch.client.events.component.UpdateDataEvent::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Lcom/google/gwt/core/client/JavaScriptObject;)(comp,d);
			handler.@com.ait.toolkit.sencha.touch.client.events.component.UpdateDataHandler::onUpdateData(Lcom/ait/toolkit/sencha/touch/client/events/component/UpdateDataEvent;)(event);
		}
		var eventName = @com.ait.toolkit.sencha.touch.client.events.component.UpdateDataEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::new(Lcom/ait/toolkit/sencha/touch/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	private native boolean isDisabledRendered() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return component == null ? false : component.disabled;
	}-*/;

	private native boolean isHiddenRendered() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return component == null ? false : component._hidden;
	}-*/;

	private native void doClear() /*-{
		var config = this.@com.ait.toolkit.sencha.touch.client.core.TouchWidget::config;
		config['__compJ'] = null;
	}-*/;

	private native void makeObservable(JavaScriptObject config) /*-{
		if (config.listeners == null || config.listeners === undefined) {
			config.listeners = new Object();
		}
	}-*/;

	private void initConfig() {
		config = cloneConfig(getConfigPrototype());
		JsoHelper.setAttribute(config, TouchAttribute.XTYPE.getValue(), getXType());
	}

	private native String _getDocked() /*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getDocked();
		}
	}-*/;

	private native void setUi(String ui)/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		component.setUi(ui);
	}-*/;

	private native String _getUi()/*-{
		var component = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		component.getUi();
	}-*/;

}
