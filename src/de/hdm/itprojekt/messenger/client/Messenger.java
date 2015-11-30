package de.hdm.itprojekt.messenger.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
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
		 * Roter Balken mit Überschrift
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
		final Button unterhaltungenButton = new Button("Unterhaltungen");
		unterhaltungenButton.setStylePrimaryName("messenger-menubutton");
		navPanel.add(unterhaltungenButton);
		
		unterhaltungenButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
		        VerticalPanel unterhaltungen = new Unterhaltungen();
		        
		        RootPanel.get("window").clear();
			    RootPanel.get("editbuttons").clear();
		        RootPanel.get("window").add(unterhaltungen);
		      }
		    });
		
		
		/**
		 * Button
		 */
		final Button suchenButton = new Button("Nutzer und Hashtag suchen");
		suchenButton.setStylePrimaryName("messenger-menubutton");
		navPanel.add(suchenButton);
		
		suchenButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

		        VerticalPanel suchen = new Suchen();
		        
		        RootPanel.get("window").clear();
			    RootPanel.get("editbuttons").clear();
		        RootPanel.get("window").add(suchen);
		      }
		    });
		/**
		 * Button
		 */
		final Button nachrichtSchreibenButton = new Button("Nachricht schreiben");
		nachrichtSchreibenButton.setStylePrimaryName("messenger-menubutton");
		navPanel.add(nachrichtSchreibenButton);
		
		
		nachrichtSchreibenButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				VerticalPanel nachrichtSchreiben = new NachrichtSchreiben();



				RootPanel.get("window").clear();
				RootPanel.get("editbuttons").clear();
				RootPanel.get("window").add(nachrichtSchreiben);

			}
		
		});
		
		
		/**
		 * Button
		 */
		final Button reportGeneratorButton = new Button("Report Generator");
		reportGeneratorButton.setStylePrimaryName("messenger-menubutton");
		navPanel.add(reportGeneratorButton);
		
		/**
		 * Button
		 */
		final Button impressumButton = new Button("Impressum");
		impressumButton.setStylePrimaryName("messenger-menubutton");
		navPanel.add(impressumButton);
		
		impressumButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
		        VerticalPanel impressum = new Impressum();
		        
		        RootPanel.get("window").clear();
			    RootPanel.get("editbuttons").clear();
		        RootPanel.get("window").add(impressum);
		      }
		    });	
		/**
		 * Button
		 */
		final Button kontaktButton = new Button("Kontakt");
		kontaktButton.setStylePrimaryName("messenger-menubutton");
		navPanel.add(kontaktButton);
		
		kontaktButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
		        VerticalPanel kontakt = new Kontakt();
		        
		        RootPanel.get("window").clear();
			    RootPanel.get("editbuttons").clear();
		        RootPanel.get("window").add(kontakt);
		      }
		    });	
		
		/**
		 * Button
		 */
		final Button logoutButton = new Button("Logout",
				new ClickHandler() {
			public void onClick(ClickEvent event) {
				Window.alert("Logout");
			}
		}
      );
		logoutButton.setStylePrimaryName("messenger-menubutton");
		navPanel.add(logoutButton);
		        
		
		
		/**
		 * Anzeigen der Unterhaltungsseite als Startseite
		 */
		VerticalPanel unterhaltungen = new Unterhaltungen();
        RootPanel.get("window").add(unterhaltungen);
	}
}


