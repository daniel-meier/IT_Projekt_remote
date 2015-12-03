package de.hdm.itprojekt.messenger.client;

import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Impressum extends Formular {
	
	public void onLoad() {
		super.onLoad();
		
		setHeadline("Impressum");
        
        Grid impressumGrid = new Grid(7, 3);
          
        impressumGrid.setWidget(0, 0, new Label("Name"));
        impressumGrid.setWidget(0, 1, new Label("Kontakt"));
        impressumGrid.setWidget(0, 2, new Label("Abteilung"));
        impressumGrid.setWidget(1, 0, new Label("Kim Ishola"));
        impressumGrid.setWidget(1, 1, new Label("ki004@hdm-stuttgart.de"));
        impressumGrid.setWidget(1, 2, new Label("GUI"));
        impressumGrid.setWidget(2, 0, new Label("Daniel Meier"));
        impressumGrid.setWidget(2, 1, new Label("dm077@hdm-stuttgart.de"));
        impressumGrid.setWidget(2, 2, new Label("GUI"));
        impressumGrid.setWidget(3, 0, new Label("Christian Reichardt"));
        impressumGrid.setWidget(3, 1, new Label("cr076@hdm-stuttgart.de"));
        impressumGrid.setWidget(3, 2, new Label("GUI"));
        impressumGrid.setWidget(4, 0, new Label("Joel Siffermann"));
        impressumGrid.setWidget(4, 1, new Label("js232@hdm-stuttgart.de"));
        impressumGrid.setWidget(4, 2, new Label("Applikation"));
        impressumGrid.setWidget(5, 0, new Label("Sarah Weimer"));
        impressumGrid.setWidget(5, 1, new Label("sw155@hdm-stuttgart.de"));
        impressumGrid.setWidget(5, 2, new Label("Applikation"));
        impressumGrid.setWidget(6, 0, new Label("Tino Hauler"));
        impressumGrid.setWidget(6, 1, new Label("th098@hdm-stuttgart.de"));
        impressumGrid.setWidget(6, 2, new Label("Datenbank"));
        
        this.add(impressumGrid);
        
	}

}

