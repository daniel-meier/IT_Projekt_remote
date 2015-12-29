package de.hdm.itprojekt.messenger.client.report;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;

public class AbonnementInfo extends ReportFormular{

	public void onLoad() {
		super.onLoad();
		
		/**
		 * Überschrift der Seite
		 */
		setHeadline("Informationen über Abonnements");
		
		/**
		 * Horizontales Panel für Eingaben (Button und SuggestBoxen 
		 */
		HorizontalPanel inputPanel = getInputPanel();
		
		/**
		 * Anlegen eines Labels mit dem Namen "Nutzer"
		 */
		 Label nutzer = new Label("Nutzer:");
			nutzer.setStylePrimaryName("report-menubutton");
			inputPanel.add(nutzer);      
		    
	 /**
	 * Anlegen der Dialogboxen
	 */
			  
		/**
		* DialoxBox für einen Nutzer, welcher zum Chat hinzugefügt werden soll 
		*/
		final DialogBox nutzerSuchenDialogBox = new DialogBox();
		nutzerSuchenDialogBox.setGlassEnabled(true);
		nutzerSuchenDialogBox.setAnimationEnabled(true);
		nutzerSuchenDialogBox.setText("Geben Sie einen Namen, welcher gesucht werden soll!!!");
			    
		
		/**
		 * Horizontales Panel dem die Dialogbox hinzugefügt wird
		 */
			   HorizontalPanel suchenDialogContents = new HorizontalPanel();
			    suchenDialogContents.setSpacing(40);
			    nutzerSuchenDialogBox.setWidget(suchenDialogContents);

		
		/**
	     * Oracle, dass die vorzuschlagenden Wörter der SuggestBox enthält 
	     */
	    MultiWordSuggestOracle nutzerSuchenOracle = new MultiWordSuggestOracle();
	    nutzerSuchenOracle.add("Klaus");
	    nutzerSuchenOracle.add("Meier");
	    nutzerSuchenOracle.add("Meler");
	    
	    /**
	     * SuggestBox, die anschließend dem Panel suchenDialogBox hinzugefügt wird
	     */
	    final SuggestBox nutzerSuchenSuggestBox = new SuggestBox(nutzerSuchenOracle);
	   suchenDialogContents.add(nutzerSuchenSuggestBox);
		
		
		/**
		 * Button 
		 */	  
		  final Button suchenButton = new Button("Suchen", new ClickHandler(){
			  public void onClick(ClickEvent event) {
				  nutzerSuchenDialogBox.hide();
			  }
		  });
			
			
		/**
		* Button, zum abbrechen 
		*/
		    Button nichtSuchenButton = new Button("Abbrechen", new ClickHandler() {
		              public void onClick(ClickEvent event) {
		            	  nutzerSuchenDialogBox.hide();
		            	//Hier Applikationslogik für löschen des Unterhaltungsteilnehmers !!!
		              }
		            });
		    
		    /**
		     * Hinzufügen des Buttons zum hinzufuegenDialogContents Panel
		     */
		    suchenDialogContents.add(suchenButton);
		    suchenDialogContents.add(nichtSuchenButton);
		    
		    final Button nutzerSuchenButton = new Button("Suchen");
		    nutzerSuchenButton.setStylePrimaryName("report-menubutton");
			  inputPanel.add(nutzerSuchenButton);
			  
			  nutzerSuchenButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						nutzerSuchenDialogBox.center();
						nutzerSuchenDialogBox.show();
					}
			  });
		
			  
			  
			  
			  
			  
			  /**
			   * Anlegen eines Labels mit dem Namen "Hashtag"
			   */
			  Label hashtag = new Label("Hashtag:");
				hashtag.setStylePrimaryName("report-menubutton");
				inputPanel.add(hashtag);      
			    
		 /**
		 * Anlegen der Dialogboxen
		 */
				  
			/**
			* DialoxBox für einen Nutzer, welcher zum Chat hinzugefügt werden soll 
			*/
			final DialogBox hashtagSuchenDialogBox = new DialogBox();
			hashtagSuchenDialogBox.setGlassEnabled(true);
			hashtagSuchenDialogBox.setAnimationEnabled(true);
			hashtagSuchenDialogBox.setText("Geben Sie einen Hashtag, welcher gesucht werden soll!!!");
				    
			
			/**
			 * Horizontales Panel dem die Dialogbox hinzugefügt wird
			 */
				   HorizontalPanel hastagSuchenDialogContents = new HorizontalPanel();
				   hastagSuchenDialogContents.setSpacing(40);
				    hashtagSuchenDialogBox.setWidget(hastagSuchenDialogContents);

			
			/**
		     * Oracle, dass die vorzuschlagenden Wörter der SuggestBox enthält 
		     */
		    MultiWordSuggestOracle hashtagSuchenOracle = new MultiWordSuggestOracle();
		    hashtagSuchenOracle.add("Klaus");
		    hashtagSuchenOracle.add("Meier");
		    hashtagSuchenOracle.add("Meler");
		    
		    /**
		     * SuggestBox, die anschließend dem Panel suchenDialogBox hinzugefügt wird
		     */
		    final SuggestBox hashtagSuchenSuggestBox = new SuggestBox(hashtagSuchenOracle);
		    hastagSuchenDialogContents.add(hashtagSuchenSuggestBox);
			
			
			/**
			 * Button 
			 */	  
			  final Button suchennButton = new Button("Suchen", new ClickHandler(){
				  public void onClick(ClickEvent event) {
					  hashtagSuchenDialogBox.hide();
				  }
			  });
				
				
			/**
			* Button, zum abbrechen 
			*/
			    Button hahstagNichtSuchenButton = new Button("Abbrechen", new ClickHandler() {
			              public void onClick(ClickEvent event) {
			            	  hashtagSuchenDialogBox.hide();
			            	//Hier Applikationslogik für löschen des Unterhaltungsteilnehmers !!!
			              }
			            });
			    
			    /**
			     * Hinzufügen des Buttons zum hinzufuegenDialogContents Panel
			     */
			    hastagSuchenDialogContents.add(suchenButton);
			    hastagSuchenDialogContents.add(nichtSuchenButton);
			    
			    final Button hashtagSuchenButton = new Button("Suchen");
			    hashtagSuchenButton.setStylePrimaryName("report-menubutton");
				  inputPanel.add(hashtagSuchenButton);
				  
				  hashtagSuchenButton.addClickHandler(new ClickHandler() {
						public void onClick(ClickEvent event) {
							hashtagSuchenDialogBox.center();
							hashtagSuchenDialogBox.show();
						}
				  });
			  
				  
	/**
	 * Hier muss die FlexTable für die beiden Abos rein!!!
	 */
	
				// Create a Flex Table
				    final FlexTable flexTable = new FlexTable();
				    FlexCellFormatter cellFormatter = flexTable.getFlexCellFormatter();
				    flexTable.addStyleName("FlexTable");
				    flexTable.setWidth("32em");
				    flexTable.setCellSpacing(5);
				    flexTable.setCellPadding(3);
				    
				 // Add two rows to start
				    addRow(flexTable);
				    addRow(flexTable);
				    addRow(flexTable);
				    addRow(flexTable);

				    
				    
				 // Add some text
				    cellFormatter.setHorizontalAlignment(
				        0, 1, HasHorizontalAlignment.ALIGN_LEFT);
				    flexTable.setHTML(0, 0, "Nutzer Abo ID");
				    flexTable.setHTML(0, 1, "Erstellungszeitraum");
				    flexTable.setHTML(0, 2, "Abonnierender Nutzer");
				    flexTable.setHTML(0, 3, "Abonnierter Nutzer");
				  
				    
				    this.add(flexTable);
				  
}
	
	
	/**
     * Add a row to the flex table.
     */
    private void addRow(FlexTable flexTable) {
      int numRows = flexTable.getRowCount() + 1;
      flexTable.setText(numRows, 0, "TEST1");
      flexTable.setText(numRows, 1, "TEST2");
      flexTable.setText(numRows, 2, "TEST3");
      flexTable.setText(numRows, 3, "TEST4");
//      flexTable.getFlexCellFormatter().setRowSpan(0, 1, numRows + 1);
    }


}
 