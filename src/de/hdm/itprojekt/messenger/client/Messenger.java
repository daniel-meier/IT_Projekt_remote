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
		 * Roter Balken mit �berschrift
		 */
		HorizontalPanel messengerPanel = new HorizontalPanel();	
		RootPanel.get("header").add(messengerPanel);
		
		
		/**
		 * Navigationspanel links
		 */
		VerticalPanel navPanel = new VerticalPanel();
		RootPanel.get("navigation").add(navPanel);

		/**
		 * Button
		 */
		final Button nachrichtButton = new Button("Nachricht");
		nachrichtButton.setStylePrimaryName("messenger-menubutton");
		navPanel.add(nachrichtButton);
		
		nachrichtButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
		        HorizontalPanel nachricht = new UnterhaltungenDetails();
		        
		        RootPanel.get("window").clear();
			    RootPanel.get("editbuttons").clear();
			    RootPanel.get("headline").clear();
		        RootPanel.get("window").add(nachricht);
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
			    RootPanel.get("editbuttons").clear();
			    RootPanel.get("headline").clear();
		        RootPanel.get("window").add(aboverwaltung);
		      }
		    });
//		/**
//		 * Button
//		 */
//		final Button nachrichtSchreibenButton = new Button("Nachricht schreiben");
//		nachrichtSchreibenButton.setStylePrimaryName("messenger-menubutton");
//		navPanel.add(nachrichtSchreibenButton);
//		
//		
//		nachrichtSchreibenButton.addClickHandler(new ClickHandler() {
//			public void onClick(ClickEvent event) {
//				HorizontalPanel nachrichtSchreiben = new NachrichtSchreiben();
//
//				  RootPanel.get("window").clear();
//				    RootPanel.get("editbuttons").clear();
//				    RootPanel.get("headline").clear();
//			        RootPanel.get("window").add(nachrichtSchreiben);
//			}
//		
//		});
		
		
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
//			    RootPanel.get("editbuttons").clear();
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
			    RootPanel.get("editbuttons").clear();
			    RootPanel.get("headline").clear();
		        RootPanel.get("window").add(impressum);
		        
		      }
		    });	
		
		
//		/**
//		 * Button
//		 */
//		final Button logoutButton = new Button("Logout",
//				new ClickHandler() {
//			public void onClick(ClickEvent event) {
//				Window.alert("Logout");
//			}
//		}
//      );
//		logoutButton.setStylePrimaryName("messenger-menubutton");
//		navPanel.add(logoutButton);
		        
		
		
		/**
		 * Anzeigen der Unterhaltungsseite als Startseite
		 */
		HorizontalPanel unterhaltungen = new UnterhaltungenDetails();
        RootPanel.get("window").add(unterhaltungen);
	}
}


