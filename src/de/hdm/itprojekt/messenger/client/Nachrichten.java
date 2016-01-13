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

import de.hdm.itprojekt.messenger.shared.bo.Hashtag;
import de.hdm.itprojekt.messenger.shared.bo.Nachricht;
import de.hdm.itprojekt.messenger.shared.bo.Nutzer;
import de.hdm.itprojekt.messenger.shared.bo.Unterhaltung;
import de.hdm.itprojekt.messenger.client.UnterhaltungCell;
import de.hdm.itprojekt.messenger.client.NachrichtCell;

public class Nachrichten extends Formular {

	
	
	private static final List<Unterhaltung> UNTERHALTUNGEN = Arrays.asList(
				new Unterhaltung (1),
				new Unterhaltung (2)
			);
		
	private static final List<Nachricht> NACHRICHTEN = Arrays.asList(
				new Nachricht (),
				new Nachricht ()
			);
	
	  
	  
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
						RootPanel.get("input").clear();
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
			  
			  
			
			  /**
				 * Anlegen der UnterhaltungCell Lists
				 */
				
				ProvidesKey<Unterhaltung> UnterhaltungKeyProvider = new ProvidesKey<Unterhaltung>() {
					public Object getKey(Unterhaltung item) {
						return (item == null) ? null : item.getID();
					}
				};
				
			    // Create a cell to render each value.
			    UnterhaltungCell unterhaltungCell = new UnterhaltungCell();	    

			    // Use the cell in a CellList.
			    CellList<Unterhaltung> UnterhaltungCellList = new CellList<Unterhaltung>(unterhaltungCell, UnterhaltungKeyProvider);
			    
			    // Set the width of the CellList.
			    UnterhaltungCellList.setWidth("230px");
			    	    	    
			    //Stylen der CellList
			    UnterhaltungCellList.setStylePrimaryName("CellList1");

			    // Push the data into the widget.
			    UnterhaltungCellList.setRowData(0, UNTERHALTUNGEN);

			    // Add it to the root panel.
			    this.add(UnterhaltungCellList);	    
			    
			    // Set a key provider that provides a unique key for each contact. If key is
			    // used to identify contacts when fields (such as the name and address)
			    // change.
			    UnterhaltungCellList.setPageSize(30);
			    UnterhaltungCellList.setKeyboardPagingPolicy(KeyboardPagingPolicy.INCREASE_RANGE);
			    UnterhaltungCellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.BOUND_TO_SELECTION);

			    // Add a selection model so we can select cells.
			    final SingleSelectionModel<Unterhaltung> UnterhaltungSelectionModel = new SingleSelectionModel<Unterhaltung>(UnterhaltungKeyProvider);
			    UnterhaltungCellList.setSelectionModel(UnterhaltungSelectionModel);
			    UnterhaltungSelectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			      public void onSelectionChange(SelectionChangeEvent event) {
//			        contactForm.setContact(selectionModel.getSelectedObject());
//			    	Window.alert("Du hast gewählt: " + NutzerSelectionModel.getSelectedObject().xxx);
//			        contactForm.setContact(selectionModel.getSelectedObject());

			      }
			    });
			    
			    
			   
			   VerticalPanel unterhaltung = new VerticalPanel();
			   this.add(unterhaltung);
			   
			   Label unterhaltungsTitel = new Label("Unterhaltung mit" + "");
			   unterhaltungsTitel.setStyleName("headline");
			   unterhaltung.add(unterhaltungsTitel);
			   unterhaltung.setStyleName("unterhaltungPanel");
			   
			   /**
				 * Anlegen der NachrichtCell Lists
				 */
			   
//				ProvidesKey<Nachricht> NachrichtKeyProvider = new ProvidesKey<Nachricht>() {
//					public Object getKey(Nachricht item) {
//						return (item == null) ? null : item.getID();
//					}
//				};
				
			    // Create a cell to render each value.
			    NachrichtCell nachrichtCell = new NachrichtCell();	    

			    // Use the cell in a CellList.
			    CellList<Nachricht> NachrichtCellList = new CellList<Nachricht>(nachrichtCell);
			    
			    // Set the width of the CellList.
			    NachrichtCellList.setWidth("363px");
			    	    	    
			    //Stylen der CellList
			    NachrichtCellList.setStylePrimaryName("CellList1");

			    // Push the data into the widget.
			    NachrichtCellList.setRowData(0, NACHRICHTEN);

			    // Add it to the root panel.
			    unterhaltung.add(NachrichtCellList);	    
			    
//			    // Set a key provider that provides a unique key for each contact. If key is
//			    // used to identify contacts when fields (such as the name and address)
//			    // change.
//			    NachrichtCellList.setPageSize(30);
//			    NachrichtCellList.setKeyboardPagingPolicy(KeyboardPagingPolicy.INCREASE_RANGE);
//			    NachrichtCellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.BOUND_TO_SELECTION);

//			    // Add a selection model so we can select cells.
//			    final SingleSelectionModel<Nachricht> NachrichtSelectionModel = new SingleSelectionModel<Nachricht>(NachrichtKeyProvider);
//			    NachrichtCellList.setSelectionModel(NachrichtSelectionModel);
//			    NachrichtSelectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
//			      public void onSelectionChange(SelectionChangeEvent event) {
//				        contactForm.setContact(selectionModel.getSelectedObject());
//				    	Window.alert("Du hast gewählt: " + NutzerSelectionModel.getSelectedObject().getVorname());
//			      }
//			    });

			   
			   
			   /**
			    * Anlegen eines horizontalen Panels in dem man Hashtags hinzufügen kann und
			    * in dem die Hashtags angezeigt werden, die hinzugefügt wurden
			    */
			    HorizontalPanel hashtagHinzufuegenPanel = new HorizontalPanel();
			    unterhaltung.add(hashtagHinzufuegenPanel);
			    
			    /**
			     * Anlegen einer Textbox in der die hinzugefügten Hashtags angezeigt werden
			     */
			    TextBox hashtagTextbox = new TextBox();
				hashtagTextbox.setEnabled(false);
				hashtagTextbox.setWidth("230px");
				hashtagTextbox.setText("Hinzugefügte Hashtags");
				hashtagHinzufuegenPanel.add(hashtagTextbox);
			    
			    /**
			     * Anlegen eines Buttons um Hashtags zu einer Nachricht hinzufügen zu können
			     */
			    Button hashtagHinzufuegenButton1 = new Button("Hashtag hinzufügen");
				hashtagHinzufuegenButton1.setStyleName("antwortButton");
				hashtagHinzufuegenPanel.add(hashtagHinzufuegenButton1);
				hashtagHinzufuegenButton1.setHeight("30px");
				
				
				
				
			    
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
			     * ClickHandler für den Button Hashtag hinzufügen
			     */
			    hashtagHinzufuegenButton1.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						hashtagHinzufuegenDialogBox.center();
						hashtagHinzufuegenDialogBox.show();
					}
				});
			   
			    
			   
				
				
				
				
				
			   /**
			    * Anlegen eines horizontalen Panels in dem eine Antwort geschrieben und 
			    * gesendet werden kann
			    */
			   HorizontalPanel antwortPanel = new HorizontalPanel();
			   unterhaltung.add(antwortPanel);
			   
			  
			   /**
			    * Anlegen eines Textfelds in der eine Nachricht geschrieben werden kann
			    */
			   TextArea antwortText = new TextArea();
			   antwortText.setCharacterWidth(36);
			   antwortText.setVisibleLines(4);
			   antwortText.setText("Antwort eingeben...");
			   antwortPanel.add(antwortText);
			   
			   /**
			    * Anlegen eines Buttons um die geschriebene Nachricht zu verschicken
			    */
			   Button antwortButton = new Button("Antwort senden");
			   antwortButton.setStyleName("antwortButton");
			   antwortButton.setHeight("84px");
			   antwortButton.setWidth("135px");
			   antwortPanel.add(antwortButton);

			   
			  
			  
			  
			 
	}
}
