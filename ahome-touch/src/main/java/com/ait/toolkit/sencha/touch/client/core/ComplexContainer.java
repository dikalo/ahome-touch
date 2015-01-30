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

import java.util.Iterator;
import java.util.List;

import com.ait.toolkit.sencha.shared.client.dom.DomUtil;
import com.ait.toolkit.sencha.touch.client.ui.Container;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.AttachDetachException;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.WidgetCollection;

/**
 * A class used to handle the logical and physical basic operations on
 * containers as well as to provide a basic iterator implementation. The class
 * attempts to mimic the behavior from GWT @See {@link ComplexPanel}. In fact,
 * many of the methods here are borrowed from it. It would have been better to
 * simply have @See {@link Container} extend it, however due to the current
 * hierarchy's restrictions we've decided to go this route.
 */
public abstract class ComplexContainer extends Component implements HasWidgets,
		HasItems {

	private WidgetCollection children = new WidgetCollection(this);
	private AttachDetachException.Command orphanCommand;

	static class RemoveFromParentHelperCommand implements ScheduledCommand {
		private Widget widget;
		private Object parent;

		public RemoveFromParentHelperCommand(Widget widget, Object parent) {
			this.widget = widget;
			this.parent = parent;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.google.gwt.core.client.Scheduler.ScheduledCommand#execute()
		 */
		@Override
		public void execute() {
			if (widget.isAttached() && widget.getParent() == parent) {
				widget.removeFromParent();
			}
		}

	}

	public ComplexContainer() {
	}

	public ComplexContainer(JavaScriptObject config) {
		super(config);
	}

	public Widget getWidget(int index) {
		return getChildren().get(index);
	}

	public int getWidgetCount() {
		return getChildren().size();
	}

	public int getWidgetIndex(Widget child) {
		return getChildren().indexOf(child);
	}

	public int getWidgetIndex(IsWidget child) {
		return getWidgetIndex(asWidgetOrNull(child));
	}

	@Override
	public Iterator<Widget> iterator() {
		return getChildren().iterator();
	}

	/**
	 * Gets the list of children contained in this panel.
	 * 
	 * @return a collection of child widgets
	 */
	public WidgetCollection getChildren() {
		return children;
	}

	/**
	 * Add a widget to the Container.
	 * 
	 * @param widget
	 *            the widget to add
	 */
	public void add(IsComponent widget) {
		add(widget.asComponent());
	}

	/**
	 * Add a widget to the Container.
	 * 
	 * @param widget
	 *            the widget to add
	 */
	@Override
	public void add(Widget widget) {

		// Physical Dettach
		widget.removeFromParent();

		if (widget instanceof Component) {

			// Logical attach.
			getChildren().add(widget);

			// Physical Attach
			add((Component) widget);

			// Adopt widget
			// adopt(widget);

		} else {

			// We must be in the presence of GWT Widgets.

			String id = DomUtil.getID(widget);
			if (id == null) {
				id = Ext.generateId();
				DomUtil.setID(widget, id);
			}
			JavaScriptObject compJS = getComponentJS(id);
			WidgetComponent component = null;
			if (compJS != null) {

				component = new WidgetComponent(compJS);
				component.setVisible(true);
			} else {
				component = new WidgetComponent(widget);
			}
			component.setParentWidget(this);
			// Logical attach.
			getChildren().add(widget);

			// Physical Attach
			add(component);

			// Adopt widget
			// adopt(widget);

		}

	}

	public void add(IsWidget widget) {
		add(widget.asWidget());
	}

	public boolean remove(int index) {
		return remove(getWidget(index));
	}

	public void remove(IsWidget widget) {
		remove(widget.asWidget());
	}

	@Override
	public boolean remove(final Widget w) {
		if (getChildren().contains(w)) {
			try {
				if (w instanceof Component) {
					try {
						// Orphan.
						orphan(w);
					} finally {
						// Physical detach.
						remove((Component) w, true);
						// Logical detach.
					}
				} else if (w.getParent() != this && w.getParent() != null) {
					// In presence of a GWT component that has been added using
					// a WidgetComponent,
					// use a finally scheduled command to cleanup removal.
					Scheduler.get()
							.scheduleFinally(
									new RemoveFromParentHelperCommand(w, w
											.getParent()));
				}
			} finally {
				getChildren().remove(w);
			}
			return true;

		}
		return false;

	}

	@Override
	public void removeAll() {
		Iterator<Widget> iterator = getChildren().iterator();
		while (iterator.hasNext()) {
			remove(iterator.next());
		}
	}

	@Override
	public void clear() {
		removeAll();
	}

	void doLogicalClear() {
		if (orphanCommand == null) {
			orphanCommand = new AttachDetachException.Command() {
				public void execute(Widget w) {
					orphan(w);
				}
			};
		}
		try {
			AttachDetachException.tryCommand(this, orphanCommand);
		} finally {
			children = new WidgetCollection(this);
		}
	}

	/**
	 * Examines this container's items property and gets a direct child
	 * component of this container.
	 * 
	 * String : representing the itemId or id of the child component
	 */
	@Override
	public native Component getComponent(String id) /*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return container.getComponent(id);
	}-*/;

	/**
	 * Examines this container's items property and gets a direct child
	 * component of this container.
	 * 
	 * index : representing the position of the child component within the items
	 * property
	 */
	@Override
	public native Component getComponent(int index) /*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return container.getComponent(index);
	}-*/;

	@Override
	public native Component[] getComponents()/*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var items = container.items;
		if (items === undefined || items == null) {
			items = null;
		} else {
			//FormPanel doesn't use MixedCollection
			items = container.items.items || container.items;
		}
		return @com.ait.toolkit.sencha.touch.client.core.TouchJsoHelper::convertToJavaComponentArray(Lcom/google/gwt/core/client/JavaScriptObject;)(items);
	}-*/;

	@Override
	public void setActiveItem(int activeItem) {
		setActiveItemRendered(activeItem);
	}

	public void setActiveItem(Container container) {
		setActiveItemRendered(container.getOrCreateJsObj());
	}

	public native <T> T getActiveItem() /*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return container.getActiveItem();
	}-*/;

	public void setItems(List<Component> components) {
		JsArray<JavaScriptObject> values = JsArray.createArray().cast();
		for (Component c : components) {
			values.push(c.getJsObj());
		}
		setItems(values);
	}

	public void setItems(Component... components) {
		JsArray<JavaScriptObject> values = JsArray.createArray().cast();
		for (Component c : components) {
			values.push(c.getJsObj());
		}
		setItems(values);
	}

	@Override
	public native void setItems(JsArray<JavaScriptObject> items) /*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		container.setItems(items);
	}-*/;

	/**
	 * Returns the value of items.
	 */
	@Override
	public native <T> T getItems() /*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return container.getItems();
	}-*/;

	/**
	 * Finalize the attachment of a Widget to this Panel. This method is the
	 * <b>last</b> step in adding or inserting a Widget into a Panel, and should
	 * be called after physical attachment in the DOM is complete. This Panel
	 * becomes the parent of the child Widget, and the child will now fire its
	 * {@link Widget#onAttach()} event if this Panel is currently attached.
	 * 
	 * @param child
	 *            the widget to be adopted
	 * @see #add(Widget)
	 */
	protected final void adopt(Widget child) {
		assert (child.getParent() == null);
		adopt(child, this);
	}

	/**
	 * <p>
	 * This method must be called as part of the remove method of any Panel. It
	 * ensures that the Widget's parent is cleared. This method should be called
	 * after verifying that the child Widget is an existing child of the Panel,
	 * but before physically removing the child Widget from the DOM. The child
	 * will now fire its {@link Widget#onDetach()} event if this Panel is
	 * currently attached.
	 * </p>
	 * <p>
	 * Calls to {@link #orphan(Widget)} should be wrapped in a try/finally block
	 * to ensure that the widget is physically detached even if orphan throws an
	 * exception.
	 * </p>
	 * 
	 * @param child
	 *            the widget to be disowned
	 * @see #add(Widget)
	 */
	protected final void orphan(Widget child) {
		assert (child.getParent() == this);
		setParent(child, null);
	}

	/**
	 * Adjusts beforeIndex to account for the possibility that the given widget
	 * is already a child of this panel.
	 * 
	 * @param child
	 *            the widget that might be an existing child
	 * @param beforeIndex
	 *            the index at which it will be added to this panel
	 * @return the modified index
	 */
	protected int adjustIndex(Widget child, int beforeIndex) {
		checkIndexBoundsForInsertion(beforeIndex);

		// Check to see if this widget is already a direct child.
		if (child.getParent() == this) {
			// If the Widget's previous position was left of the desired new
			// position
			// shift the desired position left to reflect the removal
			int idx = getWidgetIndex(child);
			if (idx < beforeIndex) {
				beforeIndex--;
			}
		}

		return beforeIndex;
	}

	/**
	 * Checks that <code>index</code> is in the range [0, getWidgetCount()),
	 * which is the valid range on accessible indexes.
	 * 
	 * @param index
	 *            the index being accessed
	 */
	protected void checkIndexBoundsForAccess(int index) {
		if (index < 0 || index >= getWidgetCount()) {
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * Checks that <code>index</code> is in the range [0, getWidgetCount()],
	 * which is the valid range for indexes on an insertion.
	 * 
	 * @param index
	 *            the index where insertion will occur
	 */
	protected void checkIndexBoundsForInsertion(int index) {
		if (index < 0 || index > getWidgetCount()) {
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * Insert a new child Widget into this Panel at a specified index, attaching
	 * its Element to the specified container Element. The child Element will
	 * either be attached to the container at the same index, or simply appended
	 * to the container, depending on the value of <code>domInsert</code>.
	 * 
	 * @param child
	 *            the child Widget to be added
	 * @param container
	 *            the Element within which <code>child</code> will be contained
	 * @param beforeIndex
	 *            the index before which <code>child</code> will be inserted
	 * @param domInsert
	 *            if <code>true</code>, insert <code>child</code> into
	 *            <code>container</code> at <code>beforeIndex</code>; otherwise
	 *            append <code>child</code> to the end of <code>container</code>
	 *            .
	 */
	protected void insert(Widget child, Element container, int beforeIndex,
			boolean domInsert) {
		// Validate index; adjust if the widget is already a child of this
		// panel.
		beforeIndex = adjustIndex(child, beforeIndex);

		// Detach new child.
		child.removeFromParent();

		// Logical attach.
		getChildren().insert(child, beforeIndex);

		// Physical attach.
		if (domInsert) {
			DOM.insertChild(container, child.getElement(), beforeIndex);
		} else {
			DOM.appendChild(container, child.getElement());
		}

		// Adopt.
		adopt(child);
	}

	private native void addPostCreate(JavaScriptObject componentJS) /*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		container.add(componentJS);
	}-*/;

	private native void addPreCreate(JavaScriptObject componentJS) /*-{
		var config = this.@com.ait.toolkit.sencha.touch.client.core.TouchWidget::config;
		if (!config.items) {
			config.items = @com.ait.toolkit.core.client.JsoHelper::createJavaScriptArray()();
		}
		config.items.push(componentJS);
	}-*/;

	private native void remove(String id) /*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		container.remove(id);
	}-*/;

	private native void remove(String id, boolean autoDestroy) /*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		container.remove(id, autoDestroy);
	}-*/;

	private native void remove(Component component, boolean autoDestroy) /*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var componentJS = component.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		container.remove(componentJS, autoDestroy);
	}-*/;

	private native void _removeAll() /*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (container.items) {
			var cs = container.items.items;
			var len = cs.length;
			for (var i = 0; i < len; i++) {
				cs[0].hide();
				container.remove(cs[0], false);
			}
		}
	}-*/;

	private native void _removeAll(boolean autoDestroy) /*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		if (container.items) {
			var cs = container.items.items;
			var len = cs.length
			for (var i = 0; i < len; i++) {
				if (!autoDestroy)
					cs[0].hide();
				container.remove(cs[0], autoDestroy);
			}
		}
	}-*/;

	private native void adopt(Widget widget, ComplexContainer parent) /*-{
		widget.@com.google.gwt.user.client.ui.Widget::setParent(Lcom/google/gwt/user/client/ui/Widget;)(parent);
	}-*/;

	private native void setParent(Widget child, Widget parent) /*-{
		child.@com.google.gwt.user.client.ui.Widget::setParent(Lcom/google/gwt/user/client/ui/Widget;)(parent);
	}-*/;

	private native void setActiveItemRendered(int item) /*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		container.setActiveItem(item);
	}-*/;

	private native void setActiveItemRendered(JavaScriptObject item) /*-{
		var container = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		container.setActiveItem(item);
	}-*/;

	/**
	 * Add a component.
	 */
	private void add(Component component) {
		JavaScriptObject componentJS = component.isCreated() ? component
				.getOrCreateJsObj() : component.getConfig();
		if (isCreated()) {
			addPostCreate(componentJS);
		} else {
			addPreCreate(componentJS);
		}
	}

}
