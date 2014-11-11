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
package com.ait.toolkit.sencha.touch.client.events;

import com.ait.toolkit.sencha.touch.client.core.Component;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Registration class for event handlers.
 * <p>
 * This class is returned when adding an event handler to a {@link Component}.
 */
public class HandlerRegistration implements com.google.gwt.event.shared.HandlerRegistration {

	private final Component target;
	private final String eventName;
	private final JavaScriptObject callback;

	public HandlerRegistration(Component target, String eventName, JavaScriptObject callback) {
		this.target = target;
		this.eventName = eventName;
		this.callback = callback;
	}

	public Component getTarget() {
		return target;
	}

	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * @return the callback
	 */
	public JavaScriptObject getCallback() {
		return callback;
	}

	/**
	 * Unregisters the event handler from a {@link Component}.
	 */
	public native void unregister()/*-{
		var target = this.@com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::getTarget()();
		var targetJs = widget.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		var event = this.@com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::getEventName()();
		var fn = this.@com.ait.toolkit.sencha.touch.client.events.HandlerRegistration::getCallback()();
		targetJs.removeListener(event, fn);
	}-*/;

	@Override
	public void removeHandler() {
		unregister();
	}

}
