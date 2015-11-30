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


	public void onLoad() {
		super.onLoad();
		 
		
		 /**
		 * Horizontal Panel für Edit-Buttons
		 */
	    HorizontalPanel buttonPanel = new HorizontalPanel();	
		RootPanel.get("editbuttons").add(buttonPanel);
	    
		/**
		 * Textbox für die Eingabe des Suchbegriffs
		 */
		TextBox suchEingabe = new TextBox();
		suchEingabe.setStylePrimaryName("suchEingabe-textbox");
		buttonPanel.add(suchEingabe);
		
	    
		/**
		 * Button
		 */
		final Button findenButton = new Button("Finden");
		findenButton.setStylePrimaryName("edit-button");
		buttonPanel.add(findenButton);

		
		RichTextArea suchAusgabe = new RichTextArea();
		this.add(suchAusgabe);
		
		
		/**
		 * Button
	   	 */
		final Button abonnierenButton = new Button("abonnieren");
		abonnierenButton.setStylePrimaryName("edit-button");
		this.add(abonnierenButton);
	
	}
}


