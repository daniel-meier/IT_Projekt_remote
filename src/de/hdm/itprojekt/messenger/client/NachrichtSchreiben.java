package de.hdm.itprojekt.messenger.client;

import java.util.Collection;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.event.dom.client.ClickHandler;

import de.hdm.itprojekt.messenger.shared.MessengerAdministrationAsync;

public class NachrichtSchreiben extends Formular{
	
	public void onLoad() {
		
			MessengerAdministrationAsync async = ClientsideSettings.getMessenger();
		
		
			super.onLoad();
			setHeadline("Neue Nachricht schreiben");
			HorizontalPanel buttonPanel = getButtonPanel();
		
		

			/**
			 * Anlegen eines Vertikalen Panels
			 */
					VerticalPanel nachrichtSchreiben = new VerticalPanel();
					this.add(nachrichtSchreiben);
					
			
			
			
			/**
			   * Anlegen der Dialogboxen
			   */
				  
				  	/**
				     * DialoxBox für einen Nutzer, welcher zum Chat hinzugefügt werden soll 
				     */
					final DialogBox empfaengerHinzufuegenDialogBox = new DialogBox();
					empfaengerHinzufuegenDialogBox.setGlassEnabled(true);
					empfaengerHinzufuegenDialogBox.setAnimationEnabled(true);
					empfaengerHinzufuegenDialogBox.setText("Geben Sie einen Namen zum Hinzufügen eines Empfängers ein!");

				    /**
				     * Horizontales Panel, das anschließend der Dialogbox hinzugefügt wird 
				     */
				    HorizontalPanel empfaengerHinzufuegenDialogContents = new HorizontalPanel();
				    empfaengerHinzufuegenDialogContents.setSpacing(40);
				    empfaengerHinzufuegenDialogBox.setWidget(empfaengerHinzufuegenDialogContents);
				    
				    /**
				     * Oracle, dass die vorzuschlagenden Wörter der SuggestBox enthält 
				     */
				    final MultiWordSuggestOracle empfaengerHinzufuegenOracle = new MultiWordSuggestOracle();
				    async.getNutzerCollection(new AsyncCallback<Collection<String>>(){

						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void onSuccess(Collection<String> result) {
							// TODO Auto-generated method stub
							empfaengerHinzufuegenOracle.addAll(result);
						}
				    	
				    });
				    
				    empfaengerHinzufuegenOracle.add("Test");
				    empfaengerHinzufuegenOracle.add("Meier");
				    empfaengerHinzufuegenOracle.add("Meler");
				    
				    /**
				     * SuggestBox, die anschließend dem erstellten Panel hinzugefügt wird
				     */
				    final SuggestBox empfaengerHinzufuegenSuggestBox = new SuggestBox(empfaengerHinzufuegenOracle);
				    empfaengerHinzufuegenDialogContents.add(empfaengerHinzufuegenSuggestBox);
				    
				    /**
				     * Button, zum hinzufügen des gewählten Nutzers 
				     */
				    Button empfaengerHinzufuegenButton = new Button("Hinzufügen", new ClickHandler() {
				              public void onClick(ClickEvent event) {
				            	  empfaengerHinzufuegenDialogBox.hide();
				                //Hier Applikationslogik für hinzufügen des Empfängers einfügen!!!
				              }
				            });
				    
				    /**
				     * Button, zum abbrechen 
				     */
				    Button empfaengerNichtHinzufuegenButton = new Button("Abbrechen", new ClickHandler() {
				              public void onClick(ClickEvent event) {
				            	  empfaengerHinzufuegenDialogBox.hide();
				              }
				            });
				    
				    /**
				     * Hinzufügen des Buttons zum hinzufuegenDialogContents Panel
				     */
				    empfaengerHinzufuegenDialogContents.add(empfaengerHinzufuegenButton);
				    empfaengerHinzufuegenDialogContents.add(empfaengerNichtHinzufuegenButton);
			
			
			
			
				    
				    
				    
				    
				    /**
				     * DialoxBox für einen Hashtag, welcher zum Chat hinzugefügt werden soll 
				     */
					final DialogBox hashtagHinzufuegenDialogBox = new DialogBox();
					hashtagHinzufuegenDialogBox.setGlassEnabled(true);
					hashtagHinzufuegenDialogBox.setAnimationEnabled(true);
					hashtagHinzufuegenDialogBox.setText("Geben Sie einen Namen zum Hinzufügen eines Hashtags ein!");

				    /**
				     * Horizontales Panel, das anschließend der Dialogbox hinzugefügt wird 
				     */
				    HorizontalPanel hashtagHinzufuegenDialogContents = new HorizontalPanel();
				    hashtagHinzufuegenDialogContents.setSpacing(40);
				    hashtagHinzufuegenDialogBox.setWidget(hashtagHinzufuegenDialogContents);
				    
				    /**
				     * Oracle, dass die vorzuschlagenden Wörter der SuggestBox enthält 
				     */
				    MultiWordSuggestOracle hashtagHinzufuegenOracle = new MultiWordSuggestOracle();
				    hashtagHinzufuegenOracle.add("#0711");
				    hashtagHinzufuegenOracle.add("#Stuttgart");
				    hashtagHinzufuegenOracle.add("#Hochschule der Medien");
				    hashtagHinzufuegenOracle.add("#Ich Liebe das IT-Projekt");
				    
				    /**
				     * SuggestBox, die anschließend dem erstellten Panel hinzugefügt wird
				     */
				    final SuggestBox hashtagHinzufuegenSuggestBox = new SuggestBox(hashtagHinzufuegenOracle);
				    hashtagHinzufuegenDialogContents.add(hashtagHinzufuegenSuggestBox);
				    
				    /**
				     * Button, zum hinzufügen des gewählten Hashtags 
				     */
				    Button hashtagHinzufuegenButton = new Button("Hinzufügen", new ClickHandler() {
				              public void onClick(ClickEvent event) {
				            	  hashtagHinzufuegenDialogBox.hide();
				                //Hier Applikationslogik für hinzufügen des Hashtags einfügen!!!
				              }
				            });
				    
				    /**
				     * Button, zum abbrechen 
				     */
				    Button hashtagNichtHinzufuegenButton = new Button("Abbrechen", new ClickHandler() {
				              public void onClick(ClickEvent event) {
				            	  hashtagHinzufuegenDialogBox.hide();
				              }
				            });
				    
				    /**
				     * Hinzufügen des Buttons zum hinzufuegenDialogContents Panel
				     */
				    hashtagHinzufuegenDialogContents.add(hashtagHinzufuegenButton);
				    hashtagHinzufuegenDialogContents.add(hashtagNichtHinzufuegenButton);
			
			
			
				    
				    
				    
				    
				    
		
		       
		    /**
			 * Anlegen der Edit-Buttons
			 */
			
			final Button empfaengerButton = new Button("Empfänger hinzufügen");
			empfaengerButton.setStylePrimaryName("edit-button");
			buttonPanel.add(empfaengerButton);
			  
			empfaengerButton.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					empfaengerHinzufuegenDialogBox.center();
					empfaengerHinzufuegenDialogBox.show();
				}
			});
			
			/**
			 * Anlegen des Buttons Hashtag hinzufügen 
			 */
			
			/**
			 * Button um Hashtags zu einer Nachricht hinzuzufügen 
			 */
			
			final Button hashtagButton = new Button("Hashtag hinzufügen");
			hashtagButton.setStylePrimaryName("edit-button");
			buttonPanel.add(hashtagButton);
			
			/**
			 * ClickHandler für den Button Hashtag hinzufügen
			 */
			
			hashtagButton.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					hashtagHinzufuegenDialogBox.center();
					hashtagHinzufuegenDialogBox.show();
				}
			});
		    
			
			/**
			 * Button um eine Nachricht zu versenden
			 */
			
			/**
			 * Anlegen des Buttons Nachricht senden
			 */
			final Button sendenButton = new Button("Nachricht senden");
			sendenButton.setStylePrimaryName("edit-button");
			buttonPanel.add(sendenButton);
			
			/**
			 * ClickHandler für den Button Nachricht senden  
			 */
			sendenButton.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					HorizontalPanel nachrichten = new Nachrichten();
					RootPanel.get("window").clear();
					RootPanel.get("editbuttons").clear();
					RootPanel.get("headline").clear();
				    RootPanel.get("window").add(nachrichten);
				}
			});
			
			
			/**
			 * Read-only Textbox für Anzeige der hinzugefügten Empfänger
			 */
			
			TextBox empfaengerTextbox = new TextBox();
			empfaengerTextbox.setEnabled(false);
			empfaengerTextbox.setWidth("399px");
			empfaengerTextbox.setText("Hinzugefügte Empfänger");
			nachrichtSchreiben.add(empfaengerTextbox);
			
			
			
			/**
			 * Read-only Textbox für Anzeige der hinzugefügten Hashtags
			 */
			
			TextBox hashtagsTextbox = new TextBox();
			hashtagsTextbox.setEnabled(false);
			hashtagsTextbox.setWidth("399px");
			hashtagsTextbox.setText("Hinzugefügte Hashtags");
			nachrichtSchreiben.add(hashtagsTextbox);
			
			
			
			/**
			 * TextArea, um eine Nachricht zu schreiben
			 */
			TextArea nachrichtText = new TextArea();
			nachrichtText.setCharacterWidth(65);
			nachrichtText.setVisibleLines(10);
			nachrichtSchreiben.add(nachrichtText);
			nachrichtText.setText("Hier Nachricht eingeben...");
		    
		    
		    		
		

}
}
