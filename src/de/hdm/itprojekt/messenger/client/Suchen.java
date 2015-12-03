package de.hdm.itprojekt.messenger.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SuggestBox;
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
		 
		HorizontalPanel headlinePanel = new HorizontalPanel();
		RootPanel.get("headline").add(headlinePanel);
		
		Label headline = new Label("Nutzer und Hashtag suchen");
		headline.setStyleName("headline");
        headlinePanel.add(headline);
		
		
		 /**
		 * Horizontal Panel für Edit-Buttons
		 */
	    HorizontalPanel buttonPanel = new HorizontalPanel();	
		RootPanel.get("editbuttons").add(buttonPanel);
	    
	
		
		/**
		 * Oracle, dass die vorzuschlagenden Wörter der suggestBox enthält
		 */
		MultiWordSuggestOracle suchenOracle = new MultiWordSuggestOracle ();
		suchenOracle.add("Meier");
		suchenOracle.add("Meler");
		suchenOracle.add("#0711");
		suchenOracle.add("#Stuttgart");
		suchenOracle.add("#Hochschule der Medien");
		suchenOracle.add("#Ich Liebe das IT-Projekt");
		
		/**
		 * SuggestBox, die anschließend dem Panel hingefügt wird
		 */
		final SuggestBox suchenSuggestBox = new SuggestBox(suchenOracle);
		buttonPanel.add(suchenSuggestBox);
		
		
		/**
		 * Button
		 */
		final Button findenButton = new Button("Finden");
		findenButton.setStylePrimaryName("edit-button");
		buttonPanel.add(findenButton);
		

		/**
		 * ...
		 */
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


