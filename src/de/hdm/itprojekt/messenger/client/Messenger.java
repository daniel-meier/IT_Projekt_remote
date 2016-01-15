package de.hdm.itprojekt.messenger.client;



import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DatePicker;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Messenger implements EntryPoint {

	
	public void onModuleLoad() {
		
		/**
		 * Aufruf der Methode "ladeMessenger" 
		 */
		ladeMessenger();
		
	}
	
	public void ladeMessenger() {
		
		/**
		 * Roter Balken mit Überschrift
		 */
		HorizontalPanel messengerPanel = new HorizontalPanel();	
		RootPanel.get("header").add(messengerPanel);
		
		
		/**
		 * Navigationspanel links
		 */
		VerticalPanel navPanel = new VerticalPanel();
		navPanel.setWidth("150px");
		RootPanel.get("navigation").add(navPanel);

		/**
		 * Button
		 */
		final Button nachrichtenButton = new Button("Nachrichten");
		nachrichtenButton.setStylePrimaryName("messenger-menubutton");
		navPanel.add(nachrichtenButton);
		
		nachrichtenButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
		        HorizontalPanel nachrichten = new Nachrichten();
		        
		        RootPanel.get("window").clear();
			    RootPanel.get("input").clear();
			    RootPanel.get("headline").clear();
		        RootPanel.get("window").add(nachrichten);
		      }
		    });
		
		
		/**
		 * Button
		 */
		final Button aboverwaltungButton = new Button("Aboverwaltung");
		aboverwaltungButton.setStylePrimaryName("messenger-menubutton");
		navPanel.add(aboverwaltungButton);
		
		aboverwaltungButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				HorizontalPanel aboverwaltung = new AboVerwaltung();
		        
		        RootPanel.get("window").clear();
			    RootPanel.get("input").clear();
			    RootPanel.get("headline").clear();
		        RootPanel.get("window").add(aboverwaltung);
		      }
		    });
		
		/**
		 * Button
		 */
		final Button reportGeneratorButton = new Button("Report Generator");
		reportGeneratorButton.setStylePrimaryName("messenger-menubutton");
		navPanel.add(reportGeneratorButton);
		
//		reportGeneratorButton.addClickHandler(new ClickHandler() {
//			public void onClick(ClickEvent event) {
//		        VerticalPanel report = new Report();
//		        
//		        RootPanel.get("window").clear();
//			    RootPanel.get("input").clear();
//			    RootPanel.get("headline").clear();
//		        RootPanel.get("window").add(report);
//		        
//		      }
//		    });	
		
		/**
		 * Button
		 */
		final Button impressumButton = new Button("Impressum");
		impressumButton.setStylePrimaryName("messenger-menubutton");
		navPanel.add(impressumButton);
		
		impressumButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				HorizontalPanel impressum = new Impressum();
		        
		        RootPanel.get("window").clear();
			    RootPanel.get("input").clear();
			    RootPanel.get("headline").clear();
		        RootPanel.get("window").add(impressum);
		        
		      }
		    });	
		
		
		final Button logoutButton = new Button ("Logout");
		logoutButton.setStylePrimaryName("messenger-menubutton");
		navPanel.add(logoutButton);
		
		logoutButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				//Hier Applikationslogik für Logout einfügen
				
				Window.alert("Sie haben sich ausgeloggt.");
		      }
		    });	
		
		
		/**
		 * Anzeigen der Unterhaltungsseite als Startseite
		 */
		HorizontalPanel nachrichten = new Nachrichten();
        RootPanel.get("window").add(nachrichten);
	}
}


