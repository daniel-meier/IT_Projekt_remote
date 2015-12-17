package de.hdm.itprojekt.messenger.client;

import java.util.Arrays;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardPagingPolicy.KeyboardPagingPolicy;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import de.hdm.itprojekt.messenger.shared.bo.Nutzer;
import de.hdm.itprojekt.messenger.shared.bo.Unterhaltung;

public class Nachrichten extends Formular {

	
	
	public void onLoad() {
		  
		  super.onLoad();  
		  setHeadline("Unterhaltungen/Nachrichten");
		  HorizontalPanel buttonPanel = getButtonPanel();
		  
		  
		  
	
		  
		  
	  /**
	   * Anlegen der Dialogboxen
	   */
		  
		  	/**
		     * DialoxBox für einen Nutzer, welcher zum Chat hinzugefügt werden soll 
		     */
			final DialogBox hinzufuegenDialogBox = new DialogBox();
			hinzufuegenDialogBox.setGlassEnabled(true);
		    hinzufuegenDialogBox.setAnimationEnabled(true);
		    hinzufuegenDialogBox.setText("Geben Sie einen Namen zum Hinzufügen eines Teilnehmers ein!");

		    /**
		     * Horizontales Panel, das anschließend der Dialogbox hinzugefügt wird 
		     */
		    HorizontalPanel hinzufuegenDialogContents = new HorizontalPanel();
		    hinzufuegenDialogContents.setSpacing(40);
		    hinzufuegenDialogBox.setWidget(hinzufuegenDialogContents);
		    
		    /**
		     * Oracle, dass die vorzuschlagenden Wörter der SuggestBox enthält 
		     */
		    MultiWordSuggestOracle hinzufuegenOracle = new MultiWordSuggestOracle();
		    hinzufuegenOracle.add("Test");
		    hinzufuegenOracle.add("Meier");
		    hinzufuegenOracle.add("Meler");
		    
		    /**
		     * SuggestBox, die anschließend dem erstellten Panel hinzugefügt wird
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
		     * Button, zum abbrechen 
		     */
		    Button nichtHinzufuegenButton = new Button("Abbrechen", new ClickHandler() {
		              public void onClick(ClickEvent event) {
		            	  hinzufuegenDialogBox.hide();
		              }
		            });
		    
		    /**
		     * Hinzufügen des Buttons zum hinzufuegenDialogContents Panel
		     */
		    hinzufuegenDialogContents.add(hinzufuegenButton);
		    hinzufuegenDialogContents.add(nichtHinzufuegenButton);
		    
		    
		    
		    
		    
		    
		    
		       
		    
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
		    loeschenOracle.add("Meier");
		    loeschenOracle.add("Meler");
		    
		    /**
		     * SuggestBox, die anschließend dem Panel loeschenDialogBox hinzugefügt wird
		     */
		    final SuggestBox loeschenSuggestBox = new SuggestBox(loeschenOracle);
		    loeschenDialogContents.add(loeschenSuggestBox);
		    
		    /**
		     * Button, zum löschen des gewählten Nutzers 
		     */
		    Button loeschenButton = new Button("Löschen", new ClickHandler() {
		              public void onClick(ClickEvent event) {
		            	  
		            	  loeschenDialogBox.hide();
		                //Hier Applikationslogik für löschen des Unterhaltungsteilnehmers !!!
		              }
		            });
		    
		    /**
		     * Button, zum abbrechen 
		     */
		    Button nichtLoeschenButton = new Button("Abbrechen", new ClickHandler() {
		              public void onClick(ClickEvent event) {
		            	  loeschenDialogBox.hide();
		              }
		            });
		    
		    /**
		     * Hinzufügen des Buttons zum loeschenDialogContents Panel
		     */
		    loeschenDialogContents.add(loeschenButton);
		    loeschenDialogContents.add(nichtLoeschenButton);
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    /**
		     * DialoxBox für eine Bestätigung zum löschen einer Unterhaltung
		     */
			final DialogBox unterhaltungLoeschenDialogBox = new DialogBox();
			unterhaltungLoeschenDialogBox.setGlassEnabled(true);
			unterhaltungLoeschenDialogBox.setAnimationEnabled(true);
			unterhaltungLoeschenDialogBox.setText("Wirkich, wirklich, wirklich?");
			
			/**
		     * Horizontales Panel, dem anschließend die Dialogbox hinzugefügt wird 
		     */
		    HorizontalPanel unterhaltungLoeschenDialogContents = new HorizontalPanel();
		    unterhaltungLoeschenDialogContents.setSpacing(40);
		    unterhaltungLoeschenDialogBox.setWidget(unterhaltungLoeschenDialogContents);
			
		    
		    /**
		     * Button, zum bestätigen des löschens der aktiven Unterhaltung 
		     */
		    Button unterhaltungLoeschenButton = new Button("Ja, löschen", new ClickHandler() {
		              public void onClick(ClickEvent event) {
		            	  
		            	  unterhaltungLoeschenDialogBox.hide();		  
		            	  
		                //Hier Applikationslogik für löschen der aktiven Unterhaltung !!!
		              }
		            });
		    
		    /**
		     * Button, zum abbrechen des läschens der aktiven Unterhaltung 
		     */
		    Button unterhaltungNichtLoeschenButton = new Button("Nein, nicht löschen", new ClickHandler() {
		              public void onClick(ClickEvent event) {
		            	  unterhaltungLoeschenDialogBox.hide();
		              }
		            });
		    
		    /**
		     * Hinzufügen der Buttons zum unterhaltungLoeschenDialogContents Panel
		     */
		    unterhaltungLoeschenDialogContents.add(unterhaltungLoeschenButton);
		    unterhaltungLoeschenDialogContents.add(unterhaltungNichtLoeschenButton);
		  
		    
		    
		    
		    
		    
		    
		    
		    
		  /**
		   * Defintion der Buttons und Clickhandler im buttonPanel
		   */
			  
			  final Button neueNachrichtButton = new Button("Neue Nachricht verfassen");
			  neueNachrichtButton.setStylePrimaryName("edit-button");
			  buttonPanel.add(neueNachrichtButton);
			  
			  neueNachrichtButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						HorizontalPanel nachrichtSchreiben = new NachrichtSchreiben();
		
						RootPanel.get("window").clear();
						RootPanel.get("editbuttons").clear();
						RootPanel.get("headline").clear();
					    RootPanel.get("window").add(nachrichtSchreiben);
					}
			  });
			  
			  

			  final Button teilnehmerAddButton = new Button("Teilnehmer hinzufügen");
			  teilnehmerAddButton.setStylePrimaryName("edit-button");
			  buttonPanel.add(teilnehmerAddButton);
			  
			  teilnehmerAddButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						hinzufuegenDialogBox.center();
						hinzufuegenDialogBox.show();
					}
			  });
			  
			  
			  
			  final Button teilnehmerDeleteButton = new Button("Teilnehmer entfernen");
			  teilnehmerDeleteButton.setStylePrimaryName("edit-button");
			  buttonPanel.add(teilnehmerDeleteButton);
			  
			  teilnehmerDeleteButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						loeschenDialogBox.center();
						loeschenDialogBox.show();
					}
			  });
			  
			  
			  
			  final Button unterhaltungDeleteButton = new Button("Unterhaltung löschen");
			  unterhaltungDeleteButton.setStylePrimaryName("edit-button");
			  buttonPanel.add(unterhaltungDeleteButton);
			  
			  unterhaltungDeleteButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						unterhaltungLoeschenDialogBox.center();
						unterhaltungLoeschenDialogBox.show();
					}
			  });
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			   Label platzhalter1 = new Label("Hier wird später CellList mit Unterhalltungen sein");
			   this.add(platzhalter1);
			   
			   
			   
			   VerticalPanel unterhaltung = new VerticalPanel();
			   this.add(unterhaltung);
			   
			   Label unterhaltungsTitel = new Label("Unterhaltung mit" + "");
			   unterhaltungsTitel.setStyleName("headline");
			   unterhaltung.add(unterhaltungsTitel);
			   unterhaltung.setStyleName("unterhaltungPanel");
			   
			   Label platzhalter2 = new Label("An dieser Stelle ist später eine CellList mit dem Nachrichtenverlauf");
			   unterhaltung.add(platzhalter2);
			   
			   HorizontalPanel antwortPanel = new HorizontalPanel();
			   unterhaltung.add(antwortPanel);
			   
			   TextArea antwortText = new TextArea();
			   antwortText.setCharacterWidth(40);
			   antwortText.setVisibleLines(3);
			   antwortText.setText("Antwort eingeben...");
			   antwortPanel.add(antwortText);
			   
			   Button antwortButton = new Button("Antwort senden");
			   antwortButton.setStyleName("antwortButton");
			   antwortButton.setHeight("65px");
			   antwortPanel.add(antwortButton);

			   
			  
			  
			  
			 
	}
}
