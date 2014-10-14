package com.ait.toolkit.sencha.touch.charts.client.events;

import com.google.gwt.event.shared.EventHandler;

public interface BeforeRefreshHandler extends EventHandler {
	public void onBeforeRefresh(BeforeRefreshEvent event);
}
