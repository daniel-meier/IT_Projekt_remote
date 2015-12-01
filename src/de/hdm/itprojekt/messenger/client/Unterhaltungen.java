package de.hdm.itprojekt.messenger.client;

import com.google.gwt.user.client.ui.*;



public class Unterhaltungen extends VerticalPanel {

	public void onLoad(){
		
		super.onLoad();
		RichTextArea textArea = new RichTextArea();
		this.add(textArea);
		
		
		
		
		/**
		 * Horizontal Panel für Edit-Buttons
		 */
	    HorizontalPanel buttonPanel = new HorizontalPanel();
		RootPanel.get("editbuttons").add(buttonPanel);
	    
	    
	    /**
		 * Button
		 */
		final Button nutzerhButton = new Button("Nutzer hinzufügen");
		nutzerhButton.setStylePrimaryName("edit-button");
		buttonPanel.add(nutzerhButton);
	
	
		/**
		 * Button
		 */
		final Button nutzerlButton = new Button("Nutzer löschen");
		nutzerlButton.setStylePrimaryName("edit-button");
		buttonPanel.add(nutzerlButton);
	

		/**
		 * Button
	   	 */
		final Button löschenButton = new Button("löschen");
		löschenButton.setStylePrimaryName("edit-button");
		buttonPanel.add(löschenButton);
	
		/**
		 * Button
		 */
		final Button zurückButton = new Button("zurück");
		zurückButton.setStylePrimaryName("edit-button");
		buttonPanel.add(zurückButton);
		
	}
}