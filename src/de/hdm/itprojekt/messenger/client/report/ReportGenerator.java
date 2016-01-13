package de.hdm.itprojekt.messenger.client.report;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.messenger.client.Nachrichten;

public class ReportGenerator implements EntryPoint{
	
	public void onModuleLoad() {
		
        VerticalPanel startseite = new Startseite();
        RootPanel.get("window").add(startseite);

		
		/**
		 * Roter Balken mit Überschrift
		 */
		HorizontalPanel reportPanel = new HorizontalPanel();	
		RootPanel.get("header").add(reportPanel);
		
		/**
		 * Navigationspanel links
		 */
		VerticalPanel navPanel = new VerticalPanel();
		navPanel.setWidth("150px");
		RootPanel.get("navigation").add(navPanel);
		
		/**
		 * Button
		 */
		final Button startseiteButton = new Button("Startseite");
		startseiteButton.setStylePrimaryName("report-menubutton");
		navPanel.add(startseiteButton);
		
		startseiteButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
		        VerticalPanel startseite = new Startseite();
		        
		        RootPanel.get("window").clear();
			    RootPanel.get("input").clear();
			    RootPanel.get("headline").clear();
		        RootPanel.get("window").add(startseite);
		      }
		    });
		
		/**
		 * Button
		 */
		final Button editorButton = new Button("Editor");
		editorButton.setStylePrimaryName("report-menubutton");
		navPanel.add(editorButton);
		
		editorButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

		      }
		    });
		
		/**
		 * Button
		 */
		final Button impressumButton = new Button("Impressum");
		impressumButton.setStylePrimaryName("report-menubutton");
		navPanel.add(impressumButton);
		
		impressumButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
		        VerticalPanel impressum = new Impressum();
		        
		        RootPanel.get("window").clear();
			    RootPanel.get("input").clear();
			    RootPanel.get("headline").clear();
		        RootPanel.get("window").add(impressum);
		      }
		    });
		
		/**
		 * Button zum Ausloggen 
		 */
		final Button logoutButton = new Button ("Logout");
		logoutButton.setStylePrimaryName("report-menubutton");
		navPanel.add(logoutButton);
		
		logoutButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				//Hier Applikationslogik für Logout einfügen
				
				Window.alert("Sie haben sich ausgeloggt.");
		      }
		    });	
		
		

	}
		
}

