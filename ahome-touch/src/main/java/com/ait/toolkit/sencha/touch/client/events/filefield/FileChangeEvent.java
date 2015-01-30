package com.ait.toolkit.sencha.touch.client.events.filefield;

import com.ait.toolkit.sencha.touch.client.ui.FileField;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class FileChangeEvent {

	public static String EVENT_NAME = "change";

	private FileField source;
	private JavaScriptObject newNalue;
	private JavaScriptObject oldValue;

	protected FileChangeEvent(JavaScriptObject oldValue) {
		super();
		this.oldValue = oldValue;
	}

	public FileChangeEvent(FileField source, JavaScriptObject newNalue, JavaScriptObject oldValue) {
		super();
		this.source = source;
		this.newNalue = newNalue;
		this.oldValue = oldValue;
	}

	/**
	 * UiBinder implementations
	 */
	private static Type<FileChangeHandler> TYPE = new Type<FileChangeHandler>(EVENT_NAME, null);

	public static Type<FileChangeHandler> getType() {
		return TYPE;
	}

	public static Type<FileChangeHandler> getAssociatedType() {
		return TYPE;
	}

	public FileField getSource() {
		return source;
	}

	public JavaScriptObject getNewNalue() {
		return newNalue;
	}

	public JavaScriptObject getOldValue() {
		return oldValue;
	}

}
