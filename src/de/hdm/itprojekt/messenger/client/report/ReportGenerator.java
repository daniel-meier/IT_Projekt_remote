package de.hdm.itprojekt.messenger.client.report;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.messenger.client.Nachrichten;

public class ReportGenerator implements EntryPoint{
	
	public void onModuleLoad() {
		
		/**
		 * Roter Balken mit Überschrift
		 */
		HorizontalPanel reportPanel = new HorizontalPanel();	
		RootPanel.get("header").add(reportPanel);
		
		/**
		 * Navigationspanel links
		 */
		VerticalPanel navPanel = new VerticalPanel();
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

	}
		
}

