package de.hdm.itprojekt.messenger.client;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import de.hdm.itprojekt.messenger.shared.bo.Nachricht;
import de.hdm.itprojekt.messenger.shared.bo.Nutzer;
import de.hdm.itprojekt.messenger.shared.bo.Unterhaltung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Example of {@link CellTable}. This example shows a table containing contact
 * information.
 */
public class Unterhaltungen extends Formular {
	
	
    ArrayList<Nutzer> nu = new ArrayList<Nutzer>();
    ArrayList<Nachricht> na = new ArrayList<Nachricht>();
	
	private static final List<Unterhaltung> UNTERHALTUNGEN = Arrays.asList(
	      new Unterhaltung(new ArrayList<Nutzer>(), new ArrayList<Nachricht>()));


  public void onLoad() {
	  
	  super.onLoad();  
	  setHeadline("Unterhaltungen");

	  
    // Create a CellTable.
    CellTable<Unterhaltung> table = new CellTable<Unterhaltung>();
    table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
    
    
    // Add a text column to show the name.
    TextColumn<Unterhaltung> nameColumn = new TextColumn<Unterhaltung>() {
      @Override
      public String getValue(Unterhaltung object) {
        return object.getNamesAsString();
      }
    };
    table.addColumn(nameColumn, "Teilnehmer");


    // Add a text column to show the address.
    TextColumn<Unterhaltung> messageColumn = new TextColumn<Unterhaltung>() {
      @Override
      public String getValue(Unterhaltung object) {
        return object.getLastMessage();
      }
    };
    table.addColumn(messageColumn, "Letzte Nachricht");
    
    
 // Add a date column to show the birthday.
    DateCell dateCell = new DateCell();
    Column<Unterhaltung, Date> dateColumn = new Column<Unterhaltung, Date>(dateCell) {
      @Override
      public Date getValue(Unterhaltung object) {
        return object.getLastMessageTime();
      }
    };
    table.addColumn(dateColumn, "Zeitpunkt der letzten Nachricht");

    // Add a selection model to handle user selection.
    final SingleSelectionModel<Unterhaltung> selectionModel = new SingleSelectionModel<Unterhaltung>();
    table.setSelectionModel(selectionModel);
    selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
      public void onSelectionChange(SelectionChangeEvent event) {
    	Unterhaltung selected = selectionModel.getSelectedObject();
        if (selected != null) {
          Window.alert("You selected: " + "test");
        }
      }
    });

//    // Set the total row count. This isn't strictly necessary, but it affects
//    // paging calculations, so its good habit to keep the row count up to date.
//    table.setRowCount(CONTACTS.size(), true);

    
    // Push the data into the widget.
    table.setRowData(0, UNTERHALTUNGEN);

    // Add it to the panel.
    this.add(table);
    
      }
}