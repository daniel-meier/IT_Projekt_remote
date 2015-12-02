package de.hdm.itprojekt.messenger.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;



public class Unterhaltungen_Details extends VerticalPanel {

	public void onLoad(){
		
		super.onLoad();
		
		
		/**
		 * Horizontal Panel für Überschrift
		 */
	    HorizontalPanel headlinePanel = new HorizontalPanel();
		RootPanel.get("headline").add(headlinePanel);
		
		/**
		 * Horizontal Panel für Edit-Buttons
		 */
	    HorizontalPanel buttonPanel = new HorizontalPanel();
		RootPanel.get("editbuttons").add(buttonPanel);
	    
		
		
		/**
		 * Label für Beschriftung der folgenden Textbox. 
		 * Text des Labels: "Unterhaltung mit"
		 */
	    Label l = new Label("Unterhaltung mit ");
		l.setStylePrimaryName("label1");
		headlinePanel.add(l);
		
		/**
		 * Read-only Textbox für Ausgabe der Teilnehmernamen
		 */
		TextBox teilnehmerNamen = new TextBox();
		teilnehmerNamen.setText("platzhaltername");
		teilnehmerNamen.setEnabled(false);
		teilnehmerNamen.setStylePrimaryName("teilnehmerNamen");
	    headlinePanel.add(teilnehmerNamen);

	    
	    
	    /**
	     * DialoxBox für einen Nutzer, welcher zum Chat hinzugefügt werden soll 
	     */
		final DialogBox dialogBox = new DialogBox();
	    dialogBox.setGlassEnabled(true);
	    dialogBox.setAnimationEnabled(true);
	    dialogBox.setText("Geben sie einen Namen ein!");

		
	    /**
		 * Button
		 */
		final Button nutzerhButton = new Button("Nutzer hinzufügen", new ClickHandler() {
	          public void onClick(ClickEvent sender) {
		            dialogBox.center();
		            dialogBox.show();
		          }
		        });
		
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
		
		
		/**
		 * Ausgabe des Chats
		 */
		RichTextArea textAreaAusgabe = new RichTextArea();
		this.add(textAreaAusgabe);
		
		/**
		 * Eingabe der neuen zu sendenden Nachricht/Antwort
		 */
		RichTextArea textAreaEingabe = new RichTextArea();
		this.add(textAreaEingabe);
		
		/**
		 * Button zum Absenden der Nachricht/Antwort
		 */
		final Button antwortenButton = new Button("Antwort absenden");
		zurückButton.setStylePrimaryName("edit-button");
		this.add(antwortenButton);
		
	}
}