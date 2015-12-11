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
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

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
	

	public void onLoad() {
		super.onLoad();
		setHeadline("Aboverwaltung");
		HorizontalPanel buttonPanel = getButtonPanel();
		
		final Button aboLoeschenButton = new Button("Gewähltes Abo löschen");
		aboLoeschenButton.setStylePrimaryName("edit-button");
		buttonPanel.add(aboLoeschenButton);
		
		final Button nutzerAboButton = new Button("Neuen Nutzer abonnieren");
		nutzerAboButton.setStylePrimaryName("edit-button");
		buttonPanel.add(nutzerAboButton);
		
		final Button hashtagAboButton = new Button("Neues Hashtag abonnieren");
		hashtagAboButton.setStylePrimaryName("edit-button");
		buttonPanel.add(hashtagAboButton);
		
		
		
		
		
	    // Create a cell to render each value.
	    NutzerCell nutzerCell = new NutzerCell();

	    // Use the cell in a CellList.
	    CellList<Nutzer> cellList = new CellList<Nutzer>(nutzerCell);

	    // Push the data into the widget.
	    cellList.setRowData(0, TESTNUTZER);

	    // Add it to the root panel.
	    this.add(cellList);
	    
	    
	    
	    // Set a key provider that provides a unique key for each contact. If key is
	    // used to identify contacts when fields (such as the name and address)
	    // change.
	    cellList.setPageSize(30);
	    cellList.setKeyboardPagingPolicy(KeyboardPagingPolicy.INCREASE_RANGE);
	    cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.BOUND_TO_SELECTION);

	    // Add a selection model so we can select cells.
	    final SingleSelectionModel<Nutzer> selectionModel = new SingleSelectionModel<Nutzer>();
	    cellList.setSelectionModel(selectionModel);
//	    selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
//	      public void onSelectionChange(SelectionChangeEvent event) {
////	        contactForm.setContact(selectionModel.getSelectedObject());
////	    	Window.alert("Da hast gewählt: " + selectionModel.getSelectedObject().getVorname());
//	      }
//	    });
	    
		
	}
}


