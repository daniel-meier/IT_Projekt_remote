package de.hdm.itprojekt.messenger.client;

import com.google.gwt.user.client.ui.*;



public class Unterhaltungen extends VerticalPanel {

	public void onLoad(){
		
		super.onLoad();
		RichTextArea textArea = new RichTextArea();
		this.add(textArea);
		
		
		
		
		/**
		 * Horizontal Panel fÃ¼r Edit-Buttons
		 */
	    HorizontalPanel buttonPanel = new HorizontalPanel();
		RootPanel.get("editbuttons").add(buttonPanel);
	    
	    
	    /**
		 * Button
		 */
		final Button nutzerhButton = new Button("Nutzer hinzufÃ¼gen");
		nutzerhButton.setStylePrimaryName("edit-button");
		buttonPanel.add(nutzerhButton);
	
	
		/**
		 * Button
		 */
		final Button nutzerlButton = new Button("Nutzer lÃ¶schen");
		nutzerlButton.setStylePrimaryName("edit-button");
		buttonPanel.add(nutzerlButton);
	

		/**
		 * Button
	   	 */
		final Button löschenButton = new Button("lÃ¶schen");
		löschenButton.setStylePrimaryName("edit-button");
		buttonPanel.add(löschenButton);
	
		/**
		 * Button
		 */
		final Button zurückButton = new Button("zurÃ¼ck");
		zurückButton.setStylePrimaryName("edit-button");
		buttonPanel.add(zurückButton);
		
	}
}