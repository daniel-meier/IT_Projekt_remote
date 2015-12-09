//package de.hdm.itprojekt.messenger.client;
//
//import com.google.gwt.cell.client.Cell.Context;
//import com.google.gwt.event.dom.client.ClickEvent;
//import com.google.gwt.event.dom.client.ClickHandler;
//import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
//import com.google.gwt.user.client.ui.*;
//
//
//import com.google.gwt.cell.client.TextCell;
//import com.google.gwt.core.client.EntryPoint;
//import com.google.gwt.user.cellview.client.CellList;
//import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
//import com.google.gwt.user.client.Window;
//import com.google.gwt.user.client.ui.RootPanel;
//import com.google.gwt.view.client.SelectionChangeEvent;
//import com.google.gwt.view.client.SingleSelectionModel;
//
//import java.util.Arrays;
//import java.util.List;
//
//public class Unterhaltungen extends Formular {
//
////		public void onLoad(){
////		super.onLoad();
////
////		setHeadline("Unterhaltungen");
////
////		
////		Label l = new Label("Hier wird später ein FlexTable, dass die Unterhaltungen enthält, angezeigt");
////        this.add(l);
////
////        }
//		
//		  /**
//		   * The list of data to display.
//		   */
//		  private static final List<String> DAYS = Arrays.asList("Sunday", "Monday",
//		      "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");
//
//		  public void onLoad() {
//			  
//			  
//		    // Create a cell to render each value.
//		    TextCell textCell = new TextCell();
//
//		    // Create a CellList that uses the cell.
//		    CellList<String> cellList = new CellList<String>(textCell);
//		    cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
//
//		    // Add a selection model to handle user selection.
//		    final SingleSelectionModel<String> selectionModel = new SingleSelectionModel<String>();
//		    cellList.setSelectionModel(selectionModel);
//		    selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
//		      public void onSelectionChange(SelectionChangeEvent event) {
//		        String selected = selectionModel.getSelectedObject();
//		        if (selected != null) {
//		          Window.alert("You selected: " + selected);
//		        }
//		      }
//		    });
//
//		    // Set the total row count. This isn't strictly necessary, but it affects
//		    // paging calculations, so its good habit to keep the row count up to date.
//		    cellList.setRowCount(DAYS.size(), true);
//
//		    // Push the data into the widget.
//		    cellList.setRowData(0, DAYS);
//
//		    // Add it to the root panel.
//		    this.add(cellList);
//		  }
//		
//}



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

  /**
   * A simple data type that represents a contact.
   */
//  private static class Contact {
//    private final String address;
//    private final Date birthday;
//    private final String name;
//
//    public Contact(String name, Date birthday, String address) {
//      this.name = name;
//      this.birthday = birthday;
//      this.address = address;
//    }
//  }
//
//  /**
//   * The list of data to display.
//   */
//  private static final List<Contact> CONTACTS = Arrays.asList(
//      new Contact("John", new Date(80, 4, 12), "123 Fourth Avenue"),
//      new Contact("Joe", new Date(85, 2, 22), "22 Lance Ln"),
//      new Contact("George", new Date(46, 6, 6), "1600 Pennsylvania Avenue"));

  public void onLoad() {
	  
	  super.onLoad();  
	  setHeadline("Unterhaltungen");

	  
    // Create a CellTable.
    CellTable<Unterhaltung> table = new CellTable<Unterhaltung>();
    table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

    // Add a date column to show the birthday.
    DateCell dateCell = new DateCell();
    Column<Unterhaltung, Date> dateColumn = new Column<Unterhaltung, Date>(dateCell) {
      @Override
      public Date getValue(Unterhaltung object) {
//        return object.getLastMessageTime;
      }
    };
    table.addColumn(dateColumn, "Zeitpunkt der letzten Nachricht");
    
    // Add a text column to show the name.
    TextColumn<Unterhaltung> nameColumn = new TextColumn<Unterhaltung>() {
      @Override
      public String getValue(Unterhaltung object) {
//        return object.getNamesAsString;
    	  return "Test";
      }
    };
    table.addColumn(nameColumn, "Teilnehmer");


    // Add a text column to show the address.
    TextColumn<Unterhaltung> messageColumn = new TextColumn<Unterhaltung>() {
      @Override
      public String getValue(Unterhaltung object) {
//        return object.getLastMessage;
      }
    };
    table.addColumn(messageColumn, "Letzte Nachricht");

    // Add a selection model to handle user selection.
    final SingleSelectionModel<Unterhaltung> selectionModel = new SingleSelectionModel<Unterhaltung>();
    table.setSelectionModel(selectionModel);
    selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
      public void onSelectionChange(SelectionChangeEvent event) {
    	Unterhaltung selected = selectionModel.getSelectedObject();
        if (selected != null) {
//          Window.alert("You selected: " + selected.name);
        }
      }
    });

//    // Set the total row count. This isn't strictly necessary, but it affects
//    // paging calculations, so its good habit to keep the row count up to date.
//    table.setRowCount(CONTACTS.size(), true);

    // Push the data into the widget.
    table.setRowData(0, CONTACTS);

    // Add it to the panel.
    this.add(table);
    
    
  }
}