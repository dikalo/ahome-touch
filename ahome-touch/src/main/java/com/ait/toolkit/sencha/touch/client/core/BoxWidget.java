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

import com.ait.toolkit.sencha.shared.client.core.Size;
import com.ait.toolkit.sencha.shared.client.dom.ExtElement;

public interface BoxWidget {

	/**
	 * Retrieves the top level element representing this component.
	 * 
	 * @return
	 */
	public ExtElement getEl();

	/**
	 * Returns the value of height.
	 * 
	 * @return
	 */
	public int getHeight();

	/**
	 * Returns the value of left.
	 * 
	 * @param <T>
	 * @return Number/Boolean
	 */
	public <T> T getLeft();

	/**
	 * Returns the value of margin.
	 * 
	 * @param <T>
	 * @return Number/String
	 */
	public <T> T getMargin();

	/**
	 * Returns the value of padding.
	 * 
	 * @param <T>
	 * @return Number/String
	 */
	public <T> T getPadding();

	/**
	 * Returns the value of right.
	 * 
	 * @param <T>
	 * @return Number/Boolean
	 */
	public <T> T getRight();

	/**
	 * Returns the height and width of the Component
	 * 
	 * @return The current height and width of the Component
	 */
	public Size getSize();

	/**
	 * Returns the value of top.
	 * 
	 * @param <T>
	 * @return Number/Boolean
	 */
	public <T> T getTop();

	/**
	 * Returns the value of width.
	 * 
	 * @return
	 */
	public int getWidth();

	/**
	 * Sets the value of border.
	 * 
	 * @param value
	 */
	public void setBorder(double value);

	/**
	 * Sets the value of border.
	 * 
	 * @param value
	 */
	public void setBorder(String value);

	/**
	 * Sets the value of bottom.
	 * 
	 * @param value
	 */
	public void setBottom(double value);

	/**
	 * Sets the value of bottom.
	 * 
	 * @param value
	 */
	public void setBottom(boolean value);

	/**
	 * Sets the value of centered.
	 * 
	 * @param value
	 */
	public void setCentered(boolean value);

	/**
	 * Sets the value of height.
	 * 
	 * @param value
	 */
	public void setHeight(int value);

	/**
	 * Sets the value of left.
	 * 
	 * @param value
	 */
	public void setLeft(int value);

	/**
	 * Sets the value of left.
	 * 
	 * @param value
	 */
	public void setLeft(boolean value);

	/**
	 * Sets the value of margin.
	 * 
	 * @param value
	 */
	public void setMargin(int value);

	/**
	 * Sets the value of padding.
	 * 
	 * @param value
	 */
	public void setPadding(int value);

	/**
	 * Sets the value of padding.
	 * 
	 * @param value
	 */
	public void setPadding(String value);

	/**
	 * Sets the value of right.
	 * 
	 * @param value
	 */
	public void setRight(int value);

	/**
	 * Sets the value of right.
	 * 
	 * @param value
	 */
	public void setRight(boolean value);

	/**
	 * Sets the size of the Component
	 * 
	 * @param width
	 * @param height
	 */
	public void setSize(double width, double height);

	public void setSize(Size size);

	/**
	 * Sets the value of top.
	 * 
	 * @param value
	 */
	public void setTop(int value);

	/**
	 * Sets the value of top.
	 * 
	 * @param value
	 */
	public void setTop(boolean value);

	/**
	 * Sets the value of width.
	 * 
	 * @param value
	 */
	public void setWidth(int value);

}