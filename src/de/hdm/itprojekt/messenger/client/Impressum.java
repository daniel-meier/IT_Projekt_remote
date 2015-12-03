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
        
        Label Dani = new Label("Daniel Meier");
        this.add(Dani);
        
        Label Kim = new Label("Kim Ishola");
        this.add(Kim);
        
        Label Chris = new Label("Christian Reichardt");
        this.add(Chris);
        
        Label Sarah = new Label("Sarah Weimer");
        this.add(Sarah);
        
        Label Joey = new Label("Joel Siffermann");
        this.add(Joey);
        
        Label Tino = new Label("Tino Hauler");
        this.add(Tino);
         
        HorizontalPanel impressumPanel = new HorizontalPanel();
        RootPanel.get("editbuttons").add(impressumPanel);
        
	}

}
