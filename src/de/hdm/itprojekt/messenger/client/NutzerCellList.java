package de.hdm.itprojekt.messenger.client;

import java.util.List;
import java.util.Vector;

import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardPagingPolicy.KeyboardPagingPolicy;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import de.hdm.itprojekt.messenger.shared.bo.Nutzer;

public class NutzerCellList {
	
	public NutzerCellList(){
		
	}
	
	public Widget erstelleNutzerCellList(List<Nutzer> NUTZER){
		
		ProvidesKey<Nutzer> NutzerKeyProvider = new ProvidesKey<Nutzer>() {
			public Object getKey(Nutzer item) {
				return (item == null) ? null : item.getEmail();
			}
		};
		
	    // Create a cell to render each value.
	    NutzerCell nutzerCell = new NutzerCell();	    

	    // Use the cell in a CellList.
	    CellList<Nutzer> NutzerCellList = new CellList<Nutzer>(nutzerCell, NutzerKeyProvider);
	    
	    // Set the width of the CellList.
	    NutzerCellList.setWidth("230px");
	    	    	    
	    //Stylen der CellList
	    NutzerCellList.setStylePrimaryName("CellList1");

	    // Push the data into the widget.
	    NutzerCellList.setRowData(0, NUTZER);

	    // Add it to the root panel.
	    // this.add(NutzerCellList);	    
	    
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
//	    	Window.alert("Du hast gewählt: " + NutzerSelectionModel.getSelectedObject().getVorname());
	      }
	    });
		
		
		
		return NutzerCellList;
		
	}
	

}
