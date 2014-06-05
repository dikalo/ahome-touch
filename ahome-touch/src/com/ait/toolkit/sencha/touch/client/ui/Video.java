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

import com.ait.toolkit.sencha.touch.client.core.Media;
import com.ait.toolkit.sencha.shared.client.core.XType;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Provides a simple Container for HTML5 Video.
 * 
 * @see <a href=http://docs.sencha.com/touch/2-0/#!/api/Ext.Video>Ext.Video</a>
 */
public class Video extends Media {

    private Video(JavaScriptObject config) {
        super(config);
    }

    @Override
    protected native void init()/*-{
		var c = new $wnd.Ext.Video();
		this.@com.ait.toolkit.sencha.touch.client.core.Component::configPrototype = c.initialConfig;
    }-*/;

    @Override
    public String getXType() {
        return XType.VIDEO.getValue();
    }

    /**
     * Create a new Sheet.
     */
    public Video() {
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.Video(config);
    }-*/;

    /**
     * Set the value of posterurl
     * 
     * @param value
     */
    public native void setPosterUrl(String value) /*-{
		var video = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		video.setPosterUrl(value);
    }-*/;

    /**
     * Gets the value of posterurl
     * 
     */
    public native String getPosterUrl() /*-{
		var video = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return video.getPosterUrl();
    }-*/;

    /**
     * Set the value of url
     * 
     * @param value
     */
    @Override
    public native void setUrl(String value) /*-{
		var video = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		video.setUrl(value);
    }-*/;

    /**
     * Gets the value of url
     * 
     */
    @Override
    public native String getUrl() /*-{
		var video = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		return video.getUrl();
    }-*/;

    public native void updatePosterUrl(Object value) /*-{
		var video = this.@com.ait.toolkit.sencha.touch.client.core.Component::getOrCreateJsObj()();
		video.updatePosterUrl(value);
    }-*/;

    @Override
    public String getText() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setText(String text) {
        // TODO Auto-generated method stub

    }

}
