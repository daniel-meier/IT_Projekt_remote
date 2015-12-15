package de.hdm.itprojekt.messenger.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.event.dom.client.ClickHandler;

public class NachrichtSchreiben extends Formular{
	
	public void onLoad() {
		
			super.onLoad();
			setHeadline("Neue Nachricht schreiben");
			HorizontalPanel buttonPanel = getButtonPanel();
		
		
			
			
		
		       
		    /**
			 * ...
			 */
			
			final Button empfaengerButton = new Button("Empfänger hinzufügen");
			empfaengerButton.setStylePrimaryName("edit-button");
			buttonPanel.add(empfaengerButton);
			  
			empfaengerButton.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					
				}
			});
			
			
			final Button hashtagButton = new Button("Hashtag hinzufügen");
			hashtagButton.setStylePrimaryName("edit-button");
			buttonPanel.add(hashtagButton);
			  
			hashtagButton.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					
				}
			});
		    
			
			final Button sendenButton = new Button("Nachicht senden");
			sendenButton.setStylePrimaryName("edit-button");
			buttonPanel.add(sendenButton);
			  
			sendenButton.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					
				}
			});
			
			
			
			
			
			/**
			 * TextArea, um eine Nachricht zu schreiben
			 */
			TextArea nachrichtSchreiben = new TextArea();
		    nachrichtSchreiben.setCharacterWidth(65);
		    nachrichtSchreiben.setVisibleLines(10);
		    this.add(nachrichtSchreiben);
		    
		    
		    
		    
		    
//			/**
//			 * Oracle, dass die vorzuschlagenden Wörter der suggestBox enthält
//			 */
//			MultiWordSuggestOracle hinzufuegenOracle = new MultiWordSuggestOracle ();
//			hinzufuegenOracle.add("Meier");
//			hinzufuegenOracle.add("Meler");
//			
//			/**
//			 * SuggestBox, die anschließend dem Panel hingefügt wird
//			 */
//			final SuggestBox hinzufuegenSuggestBox = new SuggestBox(hinzufuegenOracle);
//			buttonPanel.add(hinzufuegenSuggestBox);
			

		    
//			/**
//			 * Oracle, dass die vorzuschlagenden Hashtags der suggestBox enthält
//			 */
//			MultiWordSuggestOracle hinzufuegenHashtagOracle = new MultiWordSuggestOracle ();
//			hinzufuegenHashtagOracle.add("#0711");
//			hinzufuegenHashtagOracle.add("#Stuttgart");
//			hinzufuegenHashtagOracle.add("#Hochschule der Medien");
//			hinzufuegenHashtagOracle.add("#Ich Liebe das IT-Projekt");
//			
//			/**
//			 * SuggestBox, die anschließend dem Panel hingefügt wird
//			 */
//			final SuggestBox hinzufuegenHashtagSuggestBox = new SuggestBox(hinzufuegenHashtagOracle);
//			buttonPanel.add(hinzufuegenHashtagSuggestBox);
			
			
		

}
}
