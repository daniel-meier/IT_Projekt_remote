package de.hdm.itprojekt.messenger.client;



import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
//import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.InsertPanel.ForIsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DatePicker;

import de.hdm.itprojekt.messenger.shared.LoginInfo;
import de.hdm.itprojekt.messenger.shared.LoginService;
import de.hdm.itprojekt.messenger.shared.LoginServiceAsync;



/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Messenger implements EntryPoint {

	/**
	 * Panel,Label und Anchor für die Anmeldung
	 */
	private LoginInfo loginInfo = null;
	private VerticalPanel loginPanel = new VerticalPanel ();
	private Label loginLabel = new Label ("Please sign in to your Google account to access the Messenger application.");
	private Anchor signInLink = new Anchor ("Sign In"); 
	private Anchor signOutLink = new Anchor ("Sign Out");
	
	
	public void onModuleLoad() {

		/**
		 * Check login status using login service
		 */
		LoginServiceAsync loginService = GWT.create(LoginService.class);
		loginService.login(GWT.getHostPageBaseURL(), new AsyncCallback<LoginInfo>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onSuccess(LoginInfo result) {
				// TODO Auto-generated method stub
				loginInfo = result; 
				if (loginInfo.isLoggedIn()) {
					ladeMessenger();
				} else {
					ladeLogin ();
			}
				
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
				
				Window.Location.assign(loginInfo.getLogoutUrl());
								
				Window.alert("Sie haben sich ausgeloggt.");
		      }
		    });	
		
		final Button aktualisierungsButton = new Button ("Aktualisieren");
		aktualisierungsButton.setStylePrimaryName("messenger-menubutton");
		navPanel.add(aktualisierungsButton);
		
		aktualisierungsButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				
			}
		});
		
		
		
		
//		/**
//		 * Set up sign out hyperlink
//		 */
//		signOutLink.setHref(loginInfo.getLogoutUrl());
//		navPanel.add(signOutLink);
		
		
		
		/**
		 * Anzeigen der Unterhaltungsseite als Startseite
		 */
		HorizontalPanel nachrichten = new Nachrichten();
        RootPanel.get("window").add(nachrichten);
	}
	
		});
		
	}
	
	/**
	 * ladeLogin Methode 
	 */
	private void ladeLogin() {
		// Assemble login panel. 
		signInLink.setHref(loginInfo.getLoginUrl()); 
		loginPanel.add(loginLabel); 
		loginPanel.add(signInLink);
		RootPanel.get("window").clear();
	    RootPanel.get("input").clear();
	    RootPanel.get("navigation").clear();
		RootPanel.get("window").add(loginPanel);
	}
}



