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
package com.ait.toolkit.sencha.touch.client.layout.card;

import com.ait.toolkit.sencha.touch.client.core.config.TouchAttribute;

/**
 * Enum to be used with Card Layout Animations.
 */
public enum Direction {

	LEFT(TouchAttribute.LEFT.getValue()), RIGHT(TouchAttribute.RIGHT.getValue()), UP(
			TouchAttribute.UP.getValue()), DOWN(TouchAttribute.DOWN.getValue()), ;

	private String value;

	private Direction(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
