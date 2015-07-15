package com.ait.toolkit.sencha.touch.client.events.toggle;

import com.ait.toolkit.sencha.touch.client.ui.Toggle;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ToggleChangeEvent {

    public static String EVENT_NAME = "change";

    private Toggle source;
    private int newValue;
    private int value;

    protected ToggleChangeEvent( Toggle source, int newValue, int value ) {
        super();
        this.source = source;
        this.newValue = newValue;
        this.value = value;
    }

    /**
     * UiBinder implementations
     */
    private static Type<ToggleChangeHandler> TYPE = new Type<ToggleChangeHandler>( EVENT_NAME, null );

    public static Type<ToggleChangeHandler> getType() {
        return TYPE;
    }

    public static Type<ToggleChangeHandler> getAssociatedType() {
        return TYPE;
    }

    /**
     * @return the source
     */
    public Toggle getSource() {
        return source;
    }

    public int getNewValue() {
        return newValue;
    }

    public int getOldValue() {
        return value;
    }
}
