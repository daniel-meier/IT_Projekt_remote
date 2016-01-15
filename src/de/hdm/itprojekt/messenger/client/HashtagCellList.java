package de.hdm.itprojekt.messenger.client;

import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardPagingPolicy.KeyboardPagingPolicy;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import de.hdm.itprojekt.messenger.shared.bo.Hashtag;
import de.hdm.itprojekt.messenger.shared.bo.Nutzer;

public class HashtagCellList extends Widget{
	
	public HashtagCellList(){
		
	}
	
	CellList<Hashtag> hashtagCellList = null;
	
	
	
	public CellList<Hashtag> erstelleHashtagCellList(){
		
		ProvidesKey<Hashtag> HashtagKeyProvider = new ProvidesKey<Hashtag>() {
			public Object getKey(Hashtag item) {
				return (item == null) ? null : item.getName();
			}
		};
		
	    // Create a cell to render each value.
	    HashtagCell HashtagCell = new HashtagCell();

	    // Use the cell in a CellList.
	    CellList<Hashtag> hashtagCellList = new CellList<Hashtag>(HashtagCell, HashtagKeyProvider);
	    
	    // Set the width of the CellList.
	    hashtagCellList.setWidth("230px");
	    
	    //Stylen der CellList
	    hashtagCellList.setStylePrimaryName("CellList1");
	    
	    
	    // Set a key provider that provides a unique key for each contact. If key is
	    // used to identify contacts when fields (such as the name and address)
	    // change.
	    hashtagCellList.setPageSize(30);
	    hashtagCellList.setKeyboardPagingPolicy(KeyboardPagingPolicy.INCREASE_RANGE);
	    hashtagCellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.BOUND_TO_SELECTION);

	    // Add a selection model so we can select cells.
	    final SingleSelectionModel<Hashtag> HashtagSelectionModel = new SingleSelectionModel<Hashtag>(HashtagKeyProvider);
	    hashtagCellList.setSelectionModel(HashtagSelectionModel);
	    HashtagSelectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
	      public void onSelectionChange(SelectionChangeEvent event) {
//	        contactForm.setContact(selectionModel.getSelectedObject());
//	    	Window.alert("Du hast gewählt: " + HashtagSelectionModel.getSelectedObject().getName());
	      }
	    });
	    
	    return hashtagCellList;
		
	}
	
	
//	public void pushData(List<Hashtag> NUTZER){
//    hashtagCellList.setRowData(0, NUTZER);
//}

	
	
}
