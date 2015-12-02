package de.hdm.itprojekt.messenger.client;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Impressum extends VerticalPanel {
	
	public void onLoad() {
		super.onLoad();
		
        HorizontalPanel headlinePanel = new HorizontalPanel();
        RootPanel.get("headline").add(headlinePanel);
        
		Label l = new Label("Impressum");
        headlinePanel.add(l);
        
        Label lbl = new Label("Name1");
        this.add(lbl);
        
        
        
        
	}

}
