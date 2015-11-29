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
import com.google.gwt.user.client.ui.*;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Suchen extends VerticalPanel {

	/* (non-Javadoc)
	 * @see com.google.gwt.core.client.EntryPoint#onModuleLoad()
	 */
	public void onLoad() {
		super.onLoad();
		
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
		
	
	
	
	}
}


