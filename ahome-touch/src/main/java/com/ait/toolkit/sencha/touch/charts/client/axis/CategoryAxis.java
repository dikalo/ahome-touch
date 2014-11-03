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
package com.ait.toolkit.sencha.touch.charts.client.axis;

import com.ait.toolkit.core.client.JsoHelper;

/**
 * A type of axis that displays items in categories. This axis is generally used
 * to display categorical information like names of items, month names,
 * quarters, etc. but no quantitative values. For that other type of information
 * Number axis are more suitable.
 * 
 */
public class CategoryAxis extends AbstractAxis {

	public CategoryAxis() {
		jsObj = JsoHelper.createObject();
		this.setType("category");
	}

}
