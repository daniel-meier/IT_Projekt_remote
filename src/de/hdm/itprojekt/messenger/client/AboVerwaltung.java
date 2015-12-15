package de.hdm.itprojekt.messenger.client;


import java.util.Arrays;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardPagingPolicy.KeyboardPagingPolicy;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
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
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import de.hdm.itprojekt.messenger.shared.bo.Hashtag;
import de.hdm.itprojekt.messenger.shared.bo.Nutzer;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class AboVerwaltung extends Formular {

	
	private static final List<Nutzer> TESTNUTZER = Arrays.asList(
			new Nutzer ("Daniel", "Meier", "dm077@hdm-stuttgart.de"), 
			new Nutzer ("Chris", "Reichardt", "cr076@hdm-stuttgart.de"),
			new Nutzer ("Kim", "Ishola", "ki004@hdm-stuttgart.de")
		);
	
	private static final List<Hashtag> TESTHASHTAG = Arrays.asList(
			new Hashtag ("#Daniel"), 
			new Hashtag ("#Christian"),
			new Hashtag ("#Kim")
		);
	
	
	
	

	public void onLoad() {
		super.onLoad();
		setHeadline("Aboverwaltung");
		HorizontalPanel buttonPanel = getButtonPanel();
		

		
		
		/**
		   * Anlegen der Dialogboxen
		   */
			  
			  	/**
			     * DialoxBox für einen Nutzer, welcher abonniert werden soll 
			     */
				final DialogBox nutzerAboDialogBox = new DialogBox();
				nutzerAboDialogBox.setGlassEnabled(true);
			    nutzerAboDialogBox.setAnimationEnabled(true);
			    nutzerAboDialogBox.setText("Geben Sie einen Namen zum Abonnieren eines Nutzers ein!");

			    /**
			     * Horizontales Panel, das anschließend der Dialogbox hinzugefügt wird 
			     */
			    HorizontalPanel nutzerAboDialogContents = new HorizontalPanel();
			    nutzerAboDialogContents.setSpacing(40);
			    nutzerAboDialogBox.setWidget(nutzerAboDialogContents);
			    
			    /**
			     * Oracle, dass die vorzuschlagenden Wörter der SuggestBox enthält 
			     */
			    MultiWordSuggestOracle nutzerAboOracle = new MultiWordSuggestOracle();
			    nutzerAboOracle.add("Test");
			    nutzerAboOracle.add("Meier");
			    nutzerAboOracle.add("Meler");

			    
			    /**
			     * SuggestBox, die anschließend dem erstellten Panel hinzugefügt wird
			     */
			    final SuggestBox nutzerAboSuggestBox = new SuggestBox(nutzerAboOracle);
			    nutzerAboDialogContents.add(nutzerAboSuggestBox);
			    
			    /**
			     * Button, zum hinzufügen des gewählten Nutzers 
			     */
			    Button nutzerAbonnierenButton = new Button("Abonnieren", new ClickHandler() {
			              public void onClick(ClickEvent event) {
			            	  nutzerAboDialogBox.hide();
			                //Hier Applikationslogik für Abonnieren des Nutzers einfügen!!!
			              }
			            });
			    
			    /**
			     * Button, zum abbrechen 
			     */
			    Button keinNutzerAbonnierenButton = new Button("Abbrechen", new ClickHandler() {
			              public void onClick(ClickEvent event) {
			            	  nutzerAboDialogBox.hide();
			              }
			            });
			    
			    /**
			     * Hinzufügen des Buttons zum nutzerAboDialogContents Panel
			     */
			    nutzerAboDialogContents.add(nutzerAbonnierenButton);
			    nutzerAboDialogContents.add(keinNutzerAbonnierenButton);
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    /**
			     * DialoxBox für einen Hashtag, welcher abonniert werden soll 
			     */
				final DialogBox hashtagAboDialogBox = new DialogBox();
				hashtagAboDialogBox.setGlassEnabled(true);
			    hashtagAboDialogBox.setAnimationEnabled(true);
			    hashtagAboDialogBox.setText("Geben Sie einen Namen zum Abonnieren eines Hashtags ein!");

			    /**
			     * Horizontales Panel, das anschließend der Dialogbox hinzugefügt wird 
			     */
			    HorizontalPanel hashtagAboDialogContents = new HorizontalPanel();
			    hashtagAboDialogContents.setSpacing(40);
			    hashtagAboDialogBox.setWidget(hashtagAboDialogContents);
			    
			    /**
			     * Oracle, dass die vorzuschlagenden Wörter der SuggestBox enthält 
			     */
			    MultiWordSuggestOracle hashtagAboOracle = new MultiWordSuggestOracle();
			    hashtagAboOracle.add("#0711");
			    hashtagAboOracle.add("#Stuttgart");
			    hashtagAboOracle.add("#Hochschule der Medien");
			    hashtagAboOracle.add("#Ich Liebe das IT-Projekt");

			    
			    /**
			     * SuggestBox, die anschließend dem erstellten Panel hinzugefügt wird
			     */
			    final SuggestBox hashtagAboSuggestBox = new SuggestBox(hashtagAboOracle);
			    hashtagAboDialogContents.add(hashtagAboSuggestBox);
			    
			    /**
			     * Button, zum hinzufügen des gewählten Nutzers 
			     */
			    Button hashtagAbonnierenButton = new Button("Abonnieren", new ClickHandler() {
			              public void onClick(ClickEvent event) {
			            	  hashtagAboDialogBox.hide();
			                //Hier Applikationslogik für Abonnieren des Nutzers einfügen!!!
			              }
			            });
			    
			    /**
			     * Button, zum abbrechen 
			     */
			    Button keinHashtagAbonnierenButton = new Button("Abbrechen", new ClickHandler() {
			              public void onClick(ClickEvent event) {
			            	  hashtagAboDialogBox.hide();
			              }
			            });
			    
			    /**
			     * Hinzufügen des Buttons zum hashtagAboDialogContents Panel
			     */
			    hashtagAboDialogContents.add(hashtagAbonnierenButton);
			    hashtagAboDialogContents.add(keinHashtagAbonnierenButton);
			    
			    
			    
			    
			    
		
		
		
		
		
		
		
		
		
		
		
		
		/**
		 * Anlegen der Edit-Buttons
		 */
		
		final Button NutzerAboLoeschenButton = new Button("Gewähltes Nutzerabo löschen");
		NutzerAboLoeschenButton.setStylePrimaryName("edit-button");
		buttonPanel.add(NutzerAboLoeschenButton);
		
		NutzerAboLoeschenButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//Hier Applikationslogik zum Löschen eines Nutzerabos einfügen
			}
		});
		
		
		final Button HashtagAboLoeschenButton = new Button("Gewähltes Hashtagabo löschen");
		HashtagAboLoeschenButton.setStylePrimaryName("edit-button");
		buttonPanel.add(HashtagAboLoeschenButton);
		
		HashtagAboLoeschenButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//Hier Applikationslogik zum Löschen eines Hashtagabos einfügen
			}
		});
		
		
		final Button nutzerAboButton = new Button("Neuen Nutzer abonnieren");
		nutzerAboButton.setStylePrimaryName("edit-button");
		buttonPanel.add(nutzerAboButton);
		
		nutzerAboButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				nutzerAboDialogBox.center();
				nutzerAboDialogBox.show();
			}
		});
		
		
		final Button hashtagAboButton = new Button("Neues Hashtag abonnieren");
		hashtagAboButton.setStylePrimaryName("edit-button");
		buttonPanel.add(hashtagAboButton);
		
		hashtagAboButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				hashtagAboDialogBox.center();
				hashtagAboDialogBox.show();
			}
		});
		
		
		
		
		
		
		
		/**
		 * Anlegen der Cell Lists
		 */
		
		
		
		
		ProvidesKey<Nutzer> NutzerKeyProvider = new ProvidesKey<Nutzer>() {
			public Object getKey(Nutzer item) {
				return (item == null) ? null : item.getEmail();
			}
		};
		
	    // Create a cell to render each value.
	    NutzerCell nutzerCell = new NutzerCell();	    

	    // Use the cell in a CellList.
	    CellList<Nutzer> NutzerCellList = new CellList<Nutzer>(nutzerCell, NutzerKeyProvider);
	    
	    //Stylen der CellList
	    NutzerCellList.setStylePrimaryName("CellList1");

	    // Push the data into the widget.
	    NutzerCellList.setRowData(0, TESTNUTZER);

	    // Add it to the root panel.
	    this.add(NutzerCellList);	    
	    
	    // Set a key provider that provides a unique key for each contact. If key is
	    // used to identify contacts when fields (such as the name and address)
	    // change.
	    NutzerCellList.setPageSize(30);
	    NutzerCellList.setKeyboardPagingPolicy(KeyboardPagingPolicy.INCREASE_RANGE);
	    NutzerCellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.BOUND_TO_SELECTION);

	    // Add a selection model so we can select cells.
	    final SingleSelectionModel<Nutzer> NutzerSelectionModel = new SingleSelectionModel<Nutzer>(NutzerKeyProvider);
	    NutzerCellList.setSelectionModel(NutzerSelectionModel);
	    NutzerSelectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
	      public void onSelectionChange(SelectionChangeEvent event) {
//	        contactForm.setContact(selectionModel.getSelectedObject());
	    	Window.alert("Du hast gewählt: " + NutzerSelectionModel.getSelectedObject().getVorname());
	      }
	    });
	    
		
	    
	    
	    
	    
	    
	    
	    ProvidesKey<Hashtag> HashtagKeyProvider = new ProvidesKey<Hashtag>() {
			public Object getKey(Hashtag item) {
				return (item == null) ? null : item.getName();
			}
		};
		
	    // Create a cell to render each value.
	    HashtagCell HashtagCell = new HashtagCell();

	    // Use the cell in a CellList.
	    CellList<Hashtag> HashtagCellList = new CellList<Hashtag>(HashtagCell, HashtagKeyProvider);
	    
	    //Stylen der CellList
	    HashtagCellList.setStylePrimaryName("CellList1");

	    // Push the data into the widget.
	    HashtagCellList.setRowData(0, TESTHASHTAG);

	    // Add it to the root panel.
	    this.add(HashtagCellList);	    
	    
	    // Set a key provider that provides a unique key for each contact. If key is
	    // used to identify contacts when fields (such as the name and address)
	    // change.
	    HashtagCellList.setPageSize(30);
	    HashtagCellList.setKeyboardPagingPolicy(KeyboardPagingPolicy.INCREASE_RANGE);
	    HashtagCellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.BOUND_TO_SELECTION);

	    // Add a selection model so we can select cells.
	    final SingleSelectionModel<Hashtag> HashtagSelectionModel = new SingleSelectionModel<Hashtag>(HashtagKeyProvider);
	    HashtagCellList.setSelectionModel(HashtagSelectionModel);
	    HashtagSelectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
	      public void onSelectionChange(SelectionChangeEvent event) {
//	        contactForm.setContact(selectionModel.getSelectedObject());
	    	Window.alert("Du hast gewählt: " + HashtagSelectionModel.getSelectedObject().getName());
	      }
	    });
	    
	    
	    
	    
	}
}


