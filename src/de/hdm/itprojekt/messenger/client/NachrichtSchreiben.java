package de.hdm.itprojekt.messenger.client;

import com.google.gwt.user.client.ui.*;

public class NachrichtSchreiben extends VerticalPanel{
	
	public void onLoad() {
		super.onLoad();
		
		 HorizontalPanel buttonPanel = new HorizontalPanel();	
			RootPanel.get("editbuttons").add(buttonPanel);
		    
		    
			/**
			 * Button
			 */
			final Button findenButton = new Button("Finden");
			findenButton.setStylePrimaryName("edit-button");
			buttonPanel.add(findenButton);
	}

}
