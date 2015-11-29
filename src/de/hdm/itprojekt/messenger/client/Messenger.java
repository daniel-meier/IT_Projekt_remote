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

	/* (non-Javadoc)
	 * @see com.google.gwt.core.client.EntryPoint#onModuleLoad()
	 */
	public void onModuleLoad() {
		/**
		 * Roter Balken mit Überschrift
		 */
		HorizontalPanel messengerPanel = new HorizontalPanel();	
		RootPanel.get("header").add(messengerPanel);
		
	//	/**
	//	 * Horizontales Panel, dass die vertikalen Panels Navigation und Text nebeneinander enthält
	//	 */
	//	HorizontalPanel mainPanel = new HorizontalPanel();	
	//	RootPanel.get("main").add(mainPanel);
		
		
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
		        
		        RootPanel.get("text").clear();
			    RootPanel.get("editbuttons").clear();
		        RootPanel.get("text").add(unterhaltungen);
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
		        VerticalPanel suche = new Suche();
		        
		        RootPanel.get("text").clear();
			    RootPanel.get("editbuttons").clear();
		        RootPanel.get("text").add(suche);
		      }
		    });
		/**
		 * Button
		 */
		final Button nachrichtSchreibenButton = new Button("Nachricht schreiben");
		nachrichtSchreibenButton.setStylePrimaryName("messenger-menubutton");
		navPanel.add(nachrichtSchreibenButton);
		
		
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
		        
		        RootPanel.get("text").clear();
			    RootPanel.get("editbuttons").clear();
		        RootPanel.get("text").add(impressum);
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
		        
		        RootPanel.get("text").clear();
			    RootPanel.get("editbuttons").clear();
		        RootPanel.get("text").add(kontakt);
		      }
		    });	
		
		/**
		 * Button
		 */
		final Button logoutButton = new Button("Logout",
				new ClickHandler() {
			public void onClick(ClickEvent event) {
				Window.alert("Test");
			}
		}
      );
		logoutButton.setStylePrimaryName("messenger-menubutton");
		navPanel.add(logoutButton);
		
		/**
		 * Label mit Willkommenstext
		 */
		Label willkommen = new Label("Herzlich Willkommen. Bitte links wählen!");
		RootPanel.get("text").add(willkommen);        
		
		
		/**
		 * Vertial Panel für Text
		 */
//		VerticalPanel textPanel = new VerticalPanel();
//		RootPanel.get("text").add(textPanel);
//		
//		RichTextArea textArea = new RichTextArea();
//		textPanel.add(textArea);
//	    textArea.setVisibleLines(20);

	    
//	    /**
//		 * Horizontal Panel für Edit-Buttons
//		 */
//	    HorizontalPanel buttonPanel = new HorizontalPanel();	
//		RootPanel.get("editbuttons").add(buttonPanel);
//	    
//	    
//	    /**
//		 * Button
//		 */
//		final Button nutzerhButton = new Button("Nutzer hinzufügen");
//		nutzerhButton.setStylePrimaryName("edit-button");
//		buttonPanel.add(nutzerhButton);
//	
//	
//		/**
//		 * Button
//		 */
//		final Button nutzerlButton = new Button("Nutzer löschen");
//		nutzerlButton.setStylePrimaryName("edit-button");
//		buttonPanel.add(nutzerlButton);
//	
//
//		/**
//		 * Button
//	   	 */
//		final Button löschenButton = new Button("löschen");
//		löschenButton.setStylePrimaryName("edit-button");
//		buttonPanel.add(löschenButton);
//	
//		/**
//		 * Button
//		 */
//		final Button zurückButton = new Button("zurück");
//		zurückButton.setStylePrimaryName("edit-button");
//		buttonPanel.add(zurückButton);
	
	}
}


