package de.hdm.itprojekt.messenger.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.event.dom.client.ClickHandler;

public class NachrichtSchreiben extends VerticalPanel{
	
	public void onLoad() {
		super.onLoad();
		
		  HorizontalPanel buttonPanel = new HorizontalPanel();
			RootPanel.get("editbuttons").add(buttonPanel);
		
			
			/**
			 * TextArea, um eine Nachricht zu schreiben
			 */
			TextArea nachrichtSchreiben = new TextArea();
		    nachrichtSchreiben.setCharacterWidth(80);
		    nachrichtSchreiben.setVisibleLines(10);
		    this.add(nachrichtSchreiben);
		
		        
			/**
			 * Oracle, dass die vorzuschlagenden Wörter der suggestBox enthält
			 */
			MultiWordSuggestOracle hinzufuegenOracle = new MultiWordSuggestOracle ();
			hinzufuegenOracle.add("Meier");
			hinzufuegenOracle.add("Meler");
			
			/**
			 * SuggestBox, die anschließend dem Panel hingefügt wird
			 */
			final SuggestBox hinzufuegenSuggestBox = new SuggestBox(hinzufuegenOracle);
			buttonPanel.add(hinzufuegenSuggestBox);
			
			/**
			 * Button
			 */
			Button hinzufuegenButton = new Button("Hinzufügen" , new ClickHandler() {
				public void onClick(ClickEvent event) {
				//Hier Applikationslogik für hinzufügen eines Empfängers eingüfen!!!
					
					
				}
			});
	
			buttonPanel.add(hinzufuegenButton);
		
			
			/**
			 * Oracle, dass die vorzuschlagenden Hashtags der suggestBox enthält
			 */
			MultiWordSuggestOracle hinzufuegenHashtagOracle = new MultiWordSuggestOracle ();
			hinzufuegenOracle.add("#0711");
			hinzufuegenOracle.add("#Stuttgart");
			hinzufuegenOracle.add("#Hochschule der Medien");
			hinzufuegenOracle.add("#Ich Liebe das IT-Projekt");
			
			/**
			 * SuggestBox, die anschließend dem Panel hingefügt wird
			 */
			final SuggestBox hinzufuegenHashtagSuggestBox = new SuggestBox(hinzufuegenHashtagOracle);
			buttonPanel.add(hinzufuegenHashtagSuggestBox);
			
			/**
			 * Button
			 */
			Button hinzufuegenHashtagButton = new Button("Hinzufügen" , new ClickHandler() {
				public void onClick(ClickEvent event) {
				//Hier Applikationslogik für hinzufügen eines Hashtags eingüfen!!!
					
					
				}
			});		
			buttonPanel.add(hinzufuegenHashtagButton);
			
			 /**
			 * Button
			 */
			final Button sendenButton = new Button("Senden");
			sendenButton.setStylePrimaryName("edit-button");
			this.add(sendenButton);
		

}
}
