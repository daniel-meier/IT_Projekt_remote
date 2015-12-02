package de.hdm.itprojekt.messenger.client;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

import com.google.gwt.user.client.ui.VerticalPanel;

public class Impressum extends VerticalPanel {
	
	public void onLoad() {
		super.onLoad();
		Label l = new Label("Impressum");
		l.setStyleName("label1");
        this.add(l);
         
        HorizontalPanel impressumPanel = new HorizontalPanel();
        RootPanel.get("editbuttons").add(impressumPanel);
        
	}

}
