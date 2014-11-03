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

import com.ait.toolkit.sencha.shared.client.dom.ExtElement;

public interface Playable {

	public boolean isAutoResume();

	public boolean isAutoPause();

	public boolean isEnableControls();

	public boolean isLoop();

	public ExtElement getMedia();

	public boolean isPreload();

	public boolean isPlaying();

	public void pause();

	public void play();

	public void setAutoPause(boolean value);

	public void setAutoResume(boolean value);

	public void setEnableControls(boolean value);

	public void setLoop(boolean value);

	public void setMedia(ExtElement value);

	public void setPreload(boolean value);

	public void toggle();

	public void updateEnableControls(Object value);

	public void updateLoop(Object value);

}