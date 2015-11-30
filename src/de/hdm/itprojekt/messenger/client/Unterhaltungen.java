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
		final Button nutzerhButton = new Button("Nutzer hinzuf�gen");
		nutzerhButton.setStylePrimaryName("edit-button");
		buttonPanel.add(nutzerhButton);
	
	
		/**
		 * Button
		 */
		final Button nutzerlButton = new Button("Nutzer l�schen");
		nutzerlButton.setStylePrimaryName("edit-button");
		buttonPanel.add(nutzerlButton);
	

		/**
		 * Button
	   	 */
		final Button l�schenButton = new Button("l�schen");
		l�schenButton.setStylePrimaryName("edit-button");
		buttonPanel.add(l�schenButton);
	
		/**
		 * Button
		 */
		final Button zur�ckButton = new Button("zur�ck");
		zur�ckButton.setStylePrimaryName("edit-button");
		buttonPanel.add(zur�ckButton);
		
	}
}