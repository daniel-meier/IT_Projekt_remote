package de.hdm.itprojekt.messenger.client;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

import com.google.gwt.user.client.ui.VerticalPanel;

public class Impressum extends VerticalPanel {
	
	public void onLoad() {
		super.onLoad();
		
		HorizontalPanel impressumPanel = new HorizontalPanel();
		RootPanel.get("impressum").add(impressumPanel);
		
		HorizontalPanel inhaltPanel = new HorizontalPanel();
		RootPanel.get("inhalt").add(inhaltPanel);
		
		Label l = new Label("Impressum");
		l.setStyleName("label1");
        impressumPanel.add(l);
        
        Label Dani = new Label("Daniel Meier");
        inhaltPanel.add(Dani);
        
        Label Kim = new Label("Name: Kim Ishola	 Kürzel:ki004	Email:ki004@hdm-stuttgart.de");
        this.add(Kim);
        
        Label Chris = new Label("Christian Reichardt");
        this.add(Chris);
        
        Label Sarah = new Label("Sarah Weimer");
        this.add(Sarah);
        
        Label Joey = new Label("Joel Siffermann");
        this.add(Joey);
        
        Label Tino = new Label("Tino Hauler");
        this.add(Tino);
        
	}

}
