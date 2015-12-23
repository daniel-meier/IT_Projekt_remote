package de.hdm.itprojekt.messenger.client;

import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Impressum extends Formular {
	
	
	public void onLoad() {
		super.onLoad();
/**
 * Überschrift der Seite		
 */
		setHeadline("Impressum");

       
/**
 * Vertikales Panel für die Inhalte des Impressums		
 */
		VerticalPanel impressumPanel = new VerticalPanel();
        this.add(impressumPanel);
		
		
/**
 * Nachfolgend werden die Labels für die Anschrift der Hochschule definiert. 
 * Durch die Verwendung der Labels ist er sehr einfach möglich die Zeilen untereinander
 * stehen zu haben.        
 */
        Label gesetz = new Label("Angaben gemäß § 5 Telemediengesetz (TMG)");
		gesetz.setStylePrimaryName("labelGesetz");
		impressumPanel.add(gesetz);      
		
		
        Label hdm = new Label("Hochschule der Medien");
        impressumPanel.add(hdm);
		
        Label strasse = new Label("Nobelstr. 10");
        impressumPanel.add(strasse);
        
        Label plz = new Label("70569 Stuttgart");
        impressumPanel.add(plz);
        
       
/**
 * Hier wird eine Tabelle als Grid definiert. Diese Art der Tabelle lässt sich nicht 
 * flexibel erweitern. Dies ist in diesem Fall jedoch auch nicht notwendig. Sie 
 * benötigt 7 Zeilen und 3 Spalten.        
 */
        Grid impressumGrid = new Grid(7, 3);
        impressumGrid.setStyleName("impressumGrid");
        
/**
 * Hier werden die Inhalte in Labels für den Tabellenkopf definiert. Außerdem werden 
 * zwei Labels für einen Namen und eine E-Mail definiert um diese in der CSS Datei
 * ansprechen zu können.         
 */
        Label name = new Label("NAME");
        name.setStyleName("labelName");
        impressumPanel.add(name);
        
        Label kontakt = new Label("KONTAKT");
        kontakt.setStyleName("labelKontakt");
        impressumPanel.add(kontakt);
        
        Label abteilung = new Label("ABTEILUNG");
        abteilung.setStyleName("labelAbteilung");
        impressumPanel.add(abteilung);
        
        Label chris = new Label("Christian Reichardt");
        chris.setStyleName("labelChris");
        impressumPanel.add(chris);
        
        Label eMailDani = new Label ("dm077@hdm-stuttgart.de");
        eMailDani.setStyleName("labelDani");
        impressumPanel.add(eMailDani);
        
/**
 * Hier werden der Tabelle die Inhalte per Labels direkt hinzugefügt.          
 */
        impressumGrid.setWidget(0, 0, name);
        impressumGrid.setWidget(0, 1, kontakt);
        impressumGrid.setWidget(0, 2, abteilung);
        impressumGrid.setWidget(1, 0, new Label("Kim Ishola"));
        impressumGrid.setWidget(1, 1, new Label("ki004@hdm-stuttgart.de"));
        impressumGrid.setWidget(1, 2, new Label("GUI"));
        impressumGrid.setWidget(2, 0, new Label("Daniel Meier"));
        impressumGrid.setWidget(2, 1, eMailDani);
        impressumGrid.setWidget(2, 2, new Label("GUI"));
        impressumGrid.setWidget(3, 0, chris);
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
        
/**
 * Hier wird dem Impressums Panel, welches am Anfang der Seite erstellt wurde, 
 * die Grid Tabelle hinzugefügt.        
 */
        impressumPanel.add(impressumGrid);
        
	}

}

