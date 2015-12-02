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
		final DialogBox hinzufuegenDialogBox = new DialogBox();
		hinzufuegenDialogBox.setGlassEnabled(true);
	    hinzufuegenDialogBox.setAnimationEnabled(true);
	    hinzufuegenDialogBox.setText("Geben Sie einen Namen zum Hinzufügen eines Teilnehmers ein!");

	    /**
	     * Horizontales Panel, dem anschließend die Dialogbox hinzugefügt wird 
	     */
	    HorizontalPanel hinzufuegenDialogContents = new HorizontalPanel();
	    hinzufuegenDialogContents.setSpacing(40);
	    hinzufuegenDialogBox.setWidget(hinzufuegenDialogContents);
	    
	    /**
	     * Oracle, dass die vorzuschlagenden Wörter der SuggestBox enthält 
	     */
	    MultiWordSuggestOracle hinzufuegenOracle = new MultiWordSuggestOracle();
	    hinzufuegenOracle.add("Test");
	    
	    /**
	     * SuggestBox, die anschließend dem Panel hinzufuegenDialogBox hinzugefügt wird
	     */
	    final SuggestBox hinzufuegenSuggestBox = new SuggestBox(hinzufuegenOracle);
	    hinzufuegenDialogContents.add(hinzufuegenSuggestBox);
	    
	    /**
	     * Button, zum hinzufügen des gewählten Nutzers 
	     */
	    Button hinzufuegenButton = new Button("Hinzufügen", new ClickHandler() {
	              public void onClick(ClickEvent event) {
	            	  hinzufuegenDialogBox.hide();
	                //Hier Applikationslogik für hinzufügen des Unterhaltungsteilnehmers einfügen!!!
	              }
	            });
	    
	    /**
	     * Hinzufügen des Buttons zum hinzufuegenDialogContents Panel
	     */
	    hinzufuegenDialogContents.add(hinzufuegenButton);
	    
	    
	    
	    /**
		 * Button zum hinzufügen eines Nutzers
		 */
		final Button nutzerhButton = new Button("Nutzer hinzufügen", new ClickHandler() {
	          public void onClick(ClickEvent sender) {
	        	  hinzufuegenDialogBox.center();
	        	  hinzufuegenDialogBox.show();
		          }
		        });
		
		/**
		 * Stylen und hinzufügen des Buttons zum buttonPanel
		 */
		nutzerhButton.setStylePrimaryName("edit-button");
		buttonPanel.add(nutzerhButton);
		        		
		
		
		
		/**
	     * DialoxBox für einen Nutzer, welcher vom Chat gelöscht werden soll 
	     */
		final DialogBox loeschenDialogBox = new DialogBox();
		loeschenDialogBox.setGlassEnabled(true);
		loeschenDialogBox.setAnimationEnabled(true);
		loeschenDialogBox.setText("Geben Sie einen Namen zum Löschen eines Teilnehmers ein!");
		
		/**
	     * Horizontales Panel, dem anschließend die Dialogbox hinzugefügt wird 
	     */
	    HorizontalPanel loeschenDialogContents = new HorizontalPanel();
	    loeschenDialogContents.setSpacing(40);
	    loeschenDialogBox.setWidget(loeschenDialogContents);
		
	    /**
	     * Oracle, dass die vorzuschlagenden Wörter der SuggestBox enthält 
	     */
	    MultiWordSuggestOracle loeschenOracle = new MultiWordSuggestOracle();
	    loeschenOracle.add("Test");
	    
	    /**
	     * SuggestBox, die anschließend dem Panel loeschenDialogBox hinzugefügt wird
	     */
	    final SuggestBox loeschenSuggestBox = new SuggestBox(loeschenOracle);
	    loeschenDialogContents.add(loeschenSuggestBox);
	    
	    /**
	     * Hinzufügen des Buttons zum loeschenDialogContents Panel
	     */
	    Button loeschenButton = new Button("Löschen", new ClickHandler() {
	              public void onClick(ClickEvent event) {
	            	  loeschenDialogBox.hide();
	                //Hier Applikationslogik für löschen des Unterhaltungsteilnehmers !!!
	              }
	            });
	    
	    /**
	     * Hinzufügen des Buttons zum loeschenDialogContents Panel
	     */
	    loeschenDialogContents.add(loeschenButton);
	    
	
		/**
		 * Button zum Löschen eines Nutzers
		 */
		final Button nutzerlButton = new Button("Nutzer löschen",new ClickHandler() {
	          public void onClick(ClickEvent sender) {
	        	  loeschenDialogBox.center();
	        	  loeschenDialogBox.show();
		          }
		});
		
		/**
		 * Stylen und hinzufügen des Nutzer löschen Buttons zum buttonPanel
		 */
		nutzerlButton.setStylePrimaryName("edit-button");
		buttonPanel.add(nutzerlButton);
	

		/**
		 * Erstellen, Stylen und hinzufügen des Unterhaltung löschen Buttons zum buttonPanel
		 */
		final Button löschenButton = new Button("löschen");
		löschenButton.setStylePrimaryName("edit-button");
		buttonPanel.add(löschenButton);
	
		/**
		 * Erstellen, Stylen und hinzufügen des Zurück-Buttons zum buttonPanel
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