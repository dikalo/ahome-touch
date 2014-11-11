package com.ait.toolkit.sencha.touch.client.ui;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * A 'Toast' is a simple modal message that is displayed on the screen and then automatically closed by a timeout or by a user tapping outside of the toast itself.
 * <p>
 * Think about it like a text only alert box that will self destruct. A Toast should not be instantiated manually but creating by calling 'Ext.toast(message, timeout)'.
 * <p>
 * This will create one reusable toast container and content will be swapped out as toast messages are queued or displayed.
 * 
 */
public class Toast extends Sheet {

	private Toast() {

	}

	private Toast(JavaScriptObject peer) {
		super(peer);
	}

	public static native Toast toast(String message)/*-{
		var o = $wnd.Ext.toast(message);
		return @com.ait.toolkit.sencha.touch.client.ui.Toast::new(Lcom/google/gwt/core/client/JavaScriptObject;)(o);
	}-*/;

	public static native Toast toast(String message, int timeout)/*-{
		var o = $wnd.Ext.toast(message, timeout);
		return @com.ait.toolkit.sencha.touch.client.ui.Toast::new(Lcom/google/gwt/core/client/JavaScriptObject;)(o);
	}-*/;

}
