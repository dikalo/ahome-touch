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

public interface HasHtml {

    /**
     * Returns the value of html.
     * 
     * @return
     */
    public String getHtml();

    /**
     * Returns the value of styleHtmlCls.
     * 
     * @return
     */
    public String getStyleHtmlCls();

    /**
     * Returns the value of styleHtmlContent.
     * 
     * @return
     */
    public boolean hasStyleHtmlContent();

    /**
     * Returns the value of tpl.
     * 
     * @return
     */
    public <T> T getTpl();

    /**
     * Returns the value of tplWriteMode.
     * 
     * @return
     */
    public String getTplWriteMode();

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ait.toolkit.sencha.touch.client.core.FocusWidget#removeCls(java.lang.String
     * , java.lang.String, java.lang.String)
     */
    public void removeCls(String cls, String prefix, String suffix);

    /**
     * Sets the value of html.
     * 
     * @param value
     */
    public void setHtml(String value);

    /**
     * Sets the value of styleHtmlCls.
     * 
     * @param value
     */
    public void setStyleHtmlCls(String value);

    /**
     * Sets the value of styleHtmlContent.
     * 
     * @param value
     */
    public void setStyleHtmlContent(boolean value);

    /**
     * Sets the value of tplWriteMode.
     * 
     * @param value
     */
    public void setTplWriteMode(String value);

    /**
     * Updates the styleHtmlCls configuration
     * 
     * @param newHtmlCls
     * @param oldHtmlCls
     */
    public void updateStyleHtmlCls(Object newHtmlCls, Object oldHtmlCls);

}
