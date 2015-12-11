package de.hdm.itprojekt.messenger.client;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class Nachrichten extends Formular {

	public void onLoad() {
		  
		  super.onLoad();  
		  setHeadline("Unterhaltungen/Nachrichten");
		  HorizontalPanel buttonPanel = getButtonPanel();
		  
		  final Button neueNachrichtButton = new Button("Neue Nachricht verfassen");
		  neueNachrichtButton.setStylePrimaryName("edit-button");
		  buttonPanel.add(neueNachrichtButton);

		  final Button teilnehmerAddButton = new Button("Teilnehmer hinzufügen");
		  teilnehmerAddButton.setStylePrimaryName("edit-button");
		  buttonPanel.add(teilnehmerAddButton);
		  
		  final Button teilnehmerDeleteButton = new Button("Teilnehmer entfernen");
		  teilnehmerDeleteButton.setStylePrimaryName("edit-button");
		  buttonPanel.add(teilnehmerDeleteButton);
		  
		  final Button unterhaltungDeleteButton = new Button("Unterhaltung löschen");
		  unterhaltungDeleteButton.setStylePrimaryName("edit-button");
		  buttonPanel.add(unterhaltungDeleteButton);
	
	}
}
