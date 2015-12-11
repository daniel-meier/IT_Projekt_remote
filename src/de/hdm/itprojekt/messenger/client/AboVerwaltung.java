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
		
		
		
		
		
		
		
		final Button NutzerAboLoeschenButton = new Button("Gewähltes Nutzerabo löschen");
		NutzerAboLoeschenButton.setStylePrimaryName("edit-button");
		buttonPanel.add(NutzerAboLoeschenButton);
		
		final Button HashtagAboLoeschenButton = new Button("Gewähltes Hashtagabo löschen");
		HashtagAboLoeschenButton.setStylePrimaryName("edit-button");
		buttonPanel.add(HashtagAboLoeschenButton);
		
		final Button nutzerAboButton = new Button("Neuen Nutzer abonnieren");
		nutzerAboButton.setStylePrimaryName("edit-button");
		buttonPanel.add(nutzerAboButton);
		
		final Button hashtagAboButton = new Button("Neues Hashtag abonnieren");
		hashtagAboButton.setStylePrimaryName("edit-button");
		buttonPanel.add(hashtagAboButton);
		
		
		
		
		
		
		
		
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


