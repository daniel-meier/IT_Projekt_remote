package de.hdm.itprojekt.messenger.client;

import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Impressum extends VerticalPanel {
	
	public void onLoad() {
		super.onLoad();
		
		HorizontalPanel headlinePanel = new HorizontalPanel();
		RootPanel.get("headline").add(headlinePanel);
		
		
		Label headline = new Label("Impressum");
		headline.setStyleName("impressum-headline");
        headlinePanel.add(headline);
        
        Grid impressumGrid = new Grid(7, 3);
        
        Label name = new Label("Name");
        Label abteilung = new Label("Abteilung");
        Label kontakt = new Label("Kontakt");
        Label kim  = new Label("Kim Ishola");
        Label dani = new Label("Daniel Meier");
        Label chris = new Label("Christian Reichardt");
        Label joey = new Label("Joel Siffermann");
        Label tino = new Label("Tino Hauler");
        Label sarah = new Label("Sarah Weimer");
        Label abteilungGUI = new Label("GUI");
        Label abteilungDB = new Label("Datenbank");
        Label abteilungApplikation = new Label("Applikation");
        Label eMailKim = new Label("ki004@hdm-stuttgart.de");
        Label eMailDani = new Label("dm077@hdm-stuttgart.de");
        Label eMailChris = new Label("cr076@hdm-stuttgart.de");
        Label eMailJoey = new Label("js232@hdm-stuttgart.de");
        Label eMailTino = new Label("th098@hdm-stuttgart.de");
        Label eMailSarah = new Label("sw155@hdm-stuttgart.de");
        
        
        
        impressumGrid.setWidget(0, 1, name);
        impressumGrid.setWidget(0, 2, kontakt);
        impressumGrid.setWidget(0, 3, abteilung);
        impressumGrid.setWidget(1, 1, kim);
        impressumGrid.setWidget(1, 2, eMailKim);
        impressumGrid.setWidget(1, 3, abteilungGUI);
        impressumGrid.setWidget(2, 1, dani);
        impressumGrid.setWidget(2, 2, eMailDani);
        impressumGrid.setWidget(2, 3, abteilungGUI);
        impressumGrid.setWidget(3, 1, chris);
        impressumGrid.setWidget(3, 2, eMailChris);
        impressumGrid.setWidget(3, 3, abteilungGUI);
        impressumGrid.setWidget(4, 1, joey);
        impressumGrid.setWidget(4, 2, eMailJoey);
        impressumGrid.setWidget(4, 3, abteilungApplikation);
        impressumGrid.setWidget(5, 1, sarah);
        impressumGrid.setWidget(5, 2, eMailSarah);
        impressumGrid.setWidget(5, 3, abteilungApplikation);
        impressumGrid.setWidget(6, 1, tino);
        impressumGrid.setWidget(6, 2, eMailTino);
        impressumGrid.setWidget(6, 3, abteilungDB);
        
        
        
        
        this.add(impressumGrid);
        
	}

}
