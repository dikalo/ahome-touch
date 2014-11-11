package com.ait.toolkit.sencha.touch.client.data;

import java.util.List;

import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.data.client.TableItem;
import com.google.gwt.core.client.JavaScriptObject;

public class TreeModel extends TableItem {

	public TreeModel() {
		super(JavaScriptObject.createObject());
		setLeaf(false);
	}

	protected TreeModel(JavaScriptObject jso) {
		super(jso);
	}

	public TreeModel(String text) {
		this();
		setText(text);
	}

	public void setText(String text) {
		set("text", text);
	}

	public void setLeaf(boolean leaf) {
		JsoHelper.setAttribute(jsObj, "leaf", leaf);
	}

	public void setItems(List<? extends TreeModel> items) {

		JavaScriptObject[] data = new JavaScriptObject[items.size()];
		for (int i = 0; i < items.size(); i++) {
			data[i] = items.get(i).getJsObj();
		}

		JsoHelper.setAttribute(jsObj, "items", JsoHelper.arrayConvert(data));

	}

	public String getText() {
		return get("text");
	}

	public boolean isLeaf() {
		return JsoHelper.getAttributeAsBoolean(jsObj, "leaf");
	}

}
