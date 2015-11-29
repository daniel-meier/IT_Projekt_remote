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
public class Suchen implements EntryPoint {

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
		
		/**
		 * Button
		 */
		final Button NHSButton = new Button("Nutzer und Hashtag suchen");
		NHSButton.setStylePrimaryName("messenger-menubutton");
		
		navPanel.add(NHSButton);
		
		
		/**
		 * Button
		 */
		final Button nachrichtSchreibenButton = new Button("Nachricht schreiben");
		nachrichtSchreibenButton.setStylePrimaryName("messenger-menubutton");
		navPanel.add(nachrichtSchreibenButton);
		
		nachrichtSchreibenButton.addClickHandler(new ClickHandler() {
			public void onClickHanler(ClickEvent event) {
				VerticalPanel nachrichtSchreiben = new NachrichtSchreiben();
				
				RootPanel.get("Empfänger auswählen").clear();
				RootPanel.get("Hinzufügen").clear();
				RootPanel.get("text").add(textPanel);
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
		
		/**
		 * Button
		 */
		final Button kontaktButton = new Button("Kontakt");
		kontaktButton.setStylePrimaryName("messenger-menubutton");
		navPanel.add(kontaktButton);
		
		/**
		 * Button
		 */
		final Button logoutButton = new Button("Logout");
		logoutButton.setStylePrimaryName("messenger-menubutton");
		navPanel.add(logoutButton);
		
		
	 
		/**
		 * Horizontales Panel für Nutzer- und Hashtagsuche
		 */
		HorizontalPanel suchPanel = new HorizontalPanel();	
		RootPanel.get("editbuttons").add(suchPanel);
		
		
		RichTextArea suchArea = new RichTextArea();
		suchPanel.add(suchArea);
		
		 /**
		 * Horizontal Panel für Edit-Buttons
		 */
		
	    HorizontalPanel buttonPanel = new HorizontalPanel();	
		RootPanel.get("editbuttons").add(buttonPanel);
	    
	    
	    /**
		 * Button
		 * 	final Button nutzerhButton = new Button("Nutzer und Hashtag");
		nutzerhButton.setStylePrimaryName("edit-button");
		buttonPanel.add(nutzerhButton);
		 */
	
	
		/**
		 * Button
		 */
		final Button findenButton = new Button("Finden");
		findenButton.setStylePrimaryName("edit-button");
		buttonPanel.add(findenButton);
	

		/**
		 * Button
	   	 */
		final Button abonnierenButton = new Button("abonnieren");
		abonnierenButton.setStylePrimaryName("edit-button");
		buttonPanel.add(abonnierenButton);
		
	
		/**
		 * Button
		 * 	final Button zurückButton = new Button("zurück");
		zurückButton.setStylePrimaryName("edit-button");
		buttonPanel.add(zurückButton);
		 */
	
	
	}
}


