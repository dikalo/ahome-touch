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

import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.sencha.touch.client.core.config.MessageBoxConfig;
import com.ait.toolkit.sencha.touch.client.laf.UI;
import com.ait.toolkit.sencha.touch.client.layout.card.CardAnimation;

/**
 * Utility class for generating different styles of message boxes. <br/>
 * <br/>
 * Note that the MessageBox is asynchronous. Unlike a regular JavaScript alert
 * (which will halt browser execution), showing a MessageBox will not cause the
 * code to stop. For this reason, if you have code that should only run after
 * some user feedback from the MessageBox, you must use a callback function.
 * 
 * @see <a
 *      href=http://docs.sencha.com/touch/2-0/#!/api/Ext.MessageBox>Ext.MessageBox
 *      </a>
 */
public class MessageBox extends Sheet {

	public static final String INFO = INFO();
	public static final String WARNING = WARNING();
	public static final String QUESTION = QUESTION();
	public static final String ERROR = ERROR();

	public static class Button extends JsObject {

		public Button() {
			jsObj = JsoHelper.createObject();
		}

		public Button(String text) {
			this();
			setText(text);
			setItemId(text.toLowerCase());
		}

		public Button(String text, UI ui) {
			this(text);
			setUI(ui);
		}

		public Button(String text, String id) {
			this(text);
			setItemId(id);
		}

		public Button(String text, String id, UI ui) {
			this(text, id);
			setUI(ui);
		}

		public void setItemId(String value) {
			JsoHelper.setAttribute(jsObj, "itemId", value);
		}

		public void setUI(UI ui) {
			_setUI(ui.getValue());
		}

		private void _setUI(String value) {
			JsoHelper.setAttribute(jsObj, "ui", value);
		}

		public String getItemId() {
			return JsoHelper.getAttribute(jsObj, "itemId");
		}

		public void setText(String value) {
			JsoHelper.setAttribute(jsObj, "text", value);
		}

		public String getText() {
			return JsoHelper.getAttribute(jsObj, "text");
		}

		protected void init() {

		}
	}

	public static enum ButtonLabels {

		CANCEL("CANCEL"), OK("OK"), OKCANCEL("OKCANCEL"), YESNO("YESNO"), YESNOCANCEL(
				"YESNOCANCEL");

		private String label;

		private ButtonLabels(String label) {
			this.label = label;
		}

		public String getLabel() {
			return label;
		}

	}

	public static Button CANCEL = new Button(ButtonLabels.CANCEL.getLabel()) {
		protected native void init() /*-{
			this.@com.ait.toolkit.core.client.JsObject::jsObj = $wnd.Ext.Msg.CANCEL;
		}-*/;
	};

	public static Button OK = new Button(ButtonLabels.OK.getLabel()) {
		protected native void init() /*-{
			this.@com.ait.toolkit.core.client.JsObject::jsObj = $wnd.Ext.Msg.OK;
		}-*/;
	};

	public static Button OKCANCEL = new Button(ButtonLabels.OKCANCEL.getLabel()) {
		protected native void init() /*-{
			this.@com.ait.toolkit.core.client.JsObject::jsObj = $wnd.Ext.Msg.OKCANCEL;
		}-*/;
	};

	public static Button YESNO = new Button(ButtonLabels.YESNO.getLabel()) {
		protected native void init() /*-{
			this.@com.ait.toolkit.core.client.JsObject::jsObj = $wnd.Ext.Msg.YESNO;
		}-*/;
	};

	public static Button YESNOCANCEL = new Button(
			ButtonLabels.YESNOCANCEL.getLabel()) {
		protected native void init() /*-{
			this.@com.ait.toolkit.core.client.JsObject::jsObj = $wnd.Ext.Msg.YESNOCANCEL;
		}-*/;
	};

	public static interface AlertCallback {
		void execute();
	}

	public static interface ConfirmCallback {
		void execute(String btnID);
	}

	public static interface PromptCallback {
		void execute(String btnID, String text);
	}

	/**
	 * Displays a standard read-only message box with an OK button (comparable
	 * to the basic JavaScript Window.alert).
	 * 
	 * @param message
	 *            the message
	 */
	public static void alert(String message) {
		alert("", message);
	}

	/**
	 * Displays a standard read-only message box with an OK button (comparable
	 * to the basic JavaScript Window.alert).
	 * 
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 */
	public static native void alert(String title, String message) /*-{
		$wnd.Ext.Msg.alert(title, message, $wnd.Ext.emptyFn);
	}-*/;

	/**
	 * Displays a standard read-only message box with an OK button (comparable
	 * to the basic JavaScript Window.alert). If a callback function is passed
	 * it will be called after the user clicks the button, and the id of the
	 * button that was clicked will be passed as the only parameter to the
	 * callback (could also be the top-right close button).
	 * 
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 * @param cb
	 *            the callback function
	 */
	public static native void alert(String title, String message,
			AlertCallback cb) /*-{
		$wnd.Ext.Msg
				.alert(
						title,
						message,
						function() {
							cb.@com.ait.toolkit.sencha.touch.client.ui.MessageBox.AlertCallback::execute()();
						});
	}-*/;

	/**
	 * Displays a confirmation message box with Yes and No buttons (comparable
	 * to JavaScript's Window.confirm).
	 * 
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 */
	public static native void confirm(String title, String message) /*-{
		$wnd.Ext.Msg.confirm(title, message);
	}-*/;

	/**
	 * Displays a confirmation message box with Yes and No buttons (comparable
	 * to JavaScript's Window.confirm). If a callback function is passed it will
	 * be called after the user clicks either button, and the id of the button
	 * that was clicked will be passed as the only parameter to the callback
	 * (could also be the top-right close button).
	 * 
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 * @param cb
	 *            the callback function
	 */
	public static native void confirm(String title, String message,
			ConfirmCallback cb) /*-{
		$wnd.Ext.Msg
				.confirm(
						title,
						message,
						function(btnID) {
							cb.@com.ait.toolkit.sencha.touch.client.ui.MessageBox.ConfirmCallback::execute(Ljava/lang/String;)(btnID);
						});
	}-*/;

	/**
	 * Displays a message box with OK and Cancel buttons prompting the user to
	 * enter some text (comparable to JavaScript's Window.prompt). The prompt
	 * can be a single-line or multi-line textbox. If a callback function is
	 * passed it will be called after the user clicks either button, and the id
	 * of the button that was clicked (could also be the top-right close button)
	 * and the text that was entered will be passed as the two parameters to the
	 * callback.
	 * 
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 */
	public static native void prompt(String title, String message) /*-{
		$wnd.Ext.Msg.prompt(title, message);
	}-*/;

	/**
	 * Displays a message box with OK and Cancel buttons prompting the user to
	 * enter some text (comparable to JavaScript's Window.prompt). The prompt
	 * can be a single-line or multi-line textbox. If a callback function is
	 * passed it will be called after the user clicks either button, and the id
	 * of the button that was clicked (could also be the top-right close button)
	 * and the text that was entered will be passed as the two parameters to the
	 * callback.
	 * 
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 * @param cb
	 *            the prompt callback
	 */
	public static native void prompt(String title, String message,
			PromptCallback cb) /*-{
		$wnd.Ext.Msg
				.prompt(
						title,
						message,
						function(btnID, text) {
							//if no text is entered text is undedined in web mode but raises error in hosted mode typing to
							//coerce to string. Add harmless check for empty string too to keep host mode happy
							if (text === undefined || text == '')
								text = null;
							cb.@com.ait.toolkit.sencha.touch.client.ui.MessageBox.PromptCallback::execute(Ljava/lang/String;Ljava/lang/String;)(btnID, text);
						});
	}-*/;

	/**
	 * Displays a message box with OK and Cancel buttons prompting the user to
	 * enter some text (comparable to JavaScript's Window.prompt). The prompt
	 * can be a single-line or multi-line textbox. If a callback function is
	 * passed it will be called after the user clicks either button, and the id
	 * of the button that was clicked (could also be the top-right close button)
	 * and the text that was entered will be passed as the two parameters to the
	 * callback.
	 * 
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 * @param multiline
	 *            true for multiline
	 * @param cb
	 *            the prompt callback
	 */
	public static native void prompt(String title, String message,
			PromptCallback cb, boolean multiline) /*-{
		$wnd.Ext.Msg
				.prompt(
						title,
						message,
						function(btnID, text) {
							//if no text is entered text is undedined in web mode but raises error in hosted mode typing to
							//coerce to string. Add harmless check for empty string too to keep host mode happy
							if (text === undefined || text == '')
								text = null;
							cb.@com.ait.toolkit.sencha.touch.client.ui.MessageBox.PromptCallback::execute(Ljava/lang/String;Ljava/lang/String;)(btnID, text);
						}, null, multiline, null, {});
	}-*/;

	/**
	 * Adds the specified icon to the dialog. By default, the class
	 * 'ext-mb-icon' is applied for default styling, and the class passed in is
	 * expected to supply the background image url. Pass in empty string ('') to
	 * clear any existing icon. The following built-in icon classes are
	 * supported, but you can also pass in a custom class name:
	 * 
	 * <pre>
	 * 
	 * MessageBox.INFO
	 * MessageBox.WARNING
	 * MessageBox.QUESTION
	 * MessageBox.ERROR
	 * </pre>
	 * 
	 * @param iconCls
	 *            a CSS classname specifying the icon's background image url, or
	 *            empty string to clear the icon
	 */
	public static native void setIcon(String iconCls) /*-{
		$wnd.Ext.Msg.setIconCls(iconCls);
	}-*/;

	/**
	 * Displays a new message box, or reinitializes an existing message box,
	 * based on the config options passed in.
	 * 
	 * @param config
	 *            the message box config
	 */
	public static native void show(MessageBoxConfig config) /*-{
		$wnd.Ext.Msg
				.show(config.@com.ait.toolkit.core.client.JsObject::getJsObj()());
	}-*/;

	/**
	 * Hides this MessageBox
	 * 
	 * @param animation
	 *            the animation to use while closing this messagebox
	 */
	public static native void close(CardAnimation animation) /*-{
		$wnd.Ext.Msg
				.hide(animation.@com.ait.toolkit.core.client.JsObject::getJsObj()());
	}-*/;

	/**
	 * Hides this MessageBox
	 * 
	 * @param animation
	 *            the animation to use while closing this messagebox
	 */
	public static native void close() /*-{
		$wnd.Ext.Msg.hide();
	}-*/;

	/**
	 * Sets the value of iconCls.
	 * 
	 * @param value
	 */
	public static native void setIconCls(String value)/*-{
		$wnd.Ext.Msg.setIconCls(value);
	}-*/;

	/**
	 * Return the underlying MessageBox Widget
	 * 
	 * @return
	 */
	public static native Sheet getWidget()/*-{
		return $wnd.Ext.Msg;
	}-*/;

	private static native String INFO()/*-{
		return $wnd.Ext.MessageBox.INFO;
	}-*/;

	private static native String WARNING()/*-{
		return $wnd.Ext.MessageBox.WARNING;
	}-*/;

	private static native String QUESTION()/*-{
		return $wnd.Ext.MessageBox.QUESTION;
	}-*/;

	private static native String ERROR()/*-{
		return $wnd.Ext.MessageBox.ERROR;
	}-*/;

}
