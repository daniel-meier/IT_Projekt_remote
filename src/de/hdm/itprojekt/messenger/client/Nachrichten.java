package de.hdm.itprojekt.messenger.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;

public class Nachrichten extends Formular {

	public void onLoad() {
		  
		  super.onLoad();  
		  setHeadline("Unterhaltungen/Nachrichten");
		  HorizontalPanel buttonPanel = getButtonPanel();
		  
		  
		  /**
		   * Defintion der Buttons und Clickhandler im buttonPanel
		   */
		  
		  final Button neueNachrichtButton = new Button("Neue Nachricht verfassen");
		  neueNachrichtButton.setStylePrimaryName("edit-button");
		  buttonPanel.add(neueNachrichtButton);
		  
		  neueNachrichtButton.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					HorizontalPanel nachrichtSchreiben = new NachrichtSchreiben();
	
					RootPanel.get("window").clear();
					RootPanel.get("editbuttons").clear();
					RootPanel.get("headline").clear();
				    RootPanel.get("window").add(nachrichtSchreiben);
				}
		  });
		  
		  

		  final Button teilnehmerAddButton = new Button("Teilnehmer hinzufügen");
		  teilnehmerAddButton.setStylePrimaryName("edit-button");
		  buttonPanel.add(teilnehmerAddButton);
		  
		  final Button teilnehmerDeleteButton = new Button("Teilnehmer entfernen");
		  teilnehmerDeleteButton.setStylePrimaryName("edit-button");
		  buttonPanel.add(teilnehmerDeleteButton);
		  
		  final Button unterhaltungDeleteButton = new Button("Unterhaltung löschen");
		  unterhaltungDeleteButton.setStylePrimaryName("edit-button");
		  buttonPanel.add(unterhaltungDeleteButton);
	
		  
		  
		  /**
		   * ...
		   */
		  
		  
		  
	}
}
