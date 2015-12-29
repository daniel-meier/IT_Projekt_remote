package de.hdm.itprojekt.messenger.client.report;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.datepicker.client.DatePicker;

public class NachrichtenInfo extends ReportFormular{
	
	public void onLoad() {
		super.onLoad();
		
		/**
		 * Überschrift der Seite
		 */
		setHeadline("Information über Nachricht");
	
		/**
		 * Horizontales Panel für Eingaben (Button und SuggestBoxen 
		 */
		HorizontalPanel inputPanel = getInputPanel();
		
		/**
		 * Anlegen eines Labels mit dem Namen "Nutzer"
		 */
		 Label nutzer = new Label("Nutzer:");
			nutzer.setStylePrimaryName("labelReportLabel");
			inputPanel.add(nutzer);   
			
			/**
			 * Anlegen der Dialogboxen
			 */
					  
				/**
				* DialoxBox für einen Nutzer, nachdem gesucht werden soll
				*/
				final DialogBox nachNutzerSuchenDialogBox = new DialogBox();
				nachNutzerSuchenDialogBox.setGlassEnabled(true);
				nachNutzerSuchenDialogBox.setAnimationEnabled(true);
				nachNutzerSuchenDialogBox.setText("Geben Sie einen Namen, nachdem gesucht werden soll.");
					    
				
				/**
				 * Horizontales Panel dem die Dialogbox hinzugefügt wird
				 */
					   HorizontalPanel suchenDialogContents = new HorizontalPanel();
					    suchenDialogContents.setSpacing(40);
					    nachNutzerSuchenDialogBox.setWidget(suchenDialogContents);

				
				/**
			     * Oracle, dass die vorzuschlagenden Wörter der SuggestBox enthält 
			     */
			    MultiWordSuggestOracle nachNutzerSuchenOracle = new MultiWordSuggestOracle();
			    nachNutzerSuchenOracle.add("Klaus");
			    nachNutzerSuchenOracle.add("Meier");
			    nachNutzerSuchenOracle.add("Meler");
			    
			    /**
			     * SuggestBox, die anschließend dem Panel suchenDialogBox hinzugefügt wird
			     */
			    final SuggestBox nutzerSuchenSuggestBox = new SuggestBox(nachNutzerSuchenOracle);
			    suchenDialogContents.add(nutzerSuchenSuggestBox);
			    
				/**
				 * Button 
				 */	  
				  final Button suchenButton = new Button("Suchen", new ClickHandler(){
					  public void onClick(ClickEvent event) {
						  nachNutzerSuchenDialogBox.hide();
					  }
				  });
					
					
				/**
				* Button, zum abbrechen 
				*/
				    Button nichtSuchenButton = new Button("Abbrechen", new ClickHandler() {
				              public void onClick(ClickEvent event) {
				            	  nachNutzerSuchenDialogBox.hide();
				            	//Hier Applikationslogik für löschen des Unterhaltungsteilnehmers !!!
				              }
				            });
				    
				    /**
				     * Hinzufügen des Buttons zum hinzufuegenDialogContents Panel
				     */
				    suchenDialogContents.add(suchenButton);
				    suchenDialogContents.add(nichtSuchenButton);
				    
				    final Button nutzerSuchenButton = new Button("Suchen");
				    nutzerSuchenButton.setStylePrimaryName("reportEdit-Button");
					  inputPanel.add(nutzerSuchenButton);
					  
					  nutzerSuchenButton.addClickHandler(new ClickHandler() {
							public void onClick(ClickEvent event) {
								nachNutzerSuchenDialogBox.center();
								nachNutzerSuchenDialogBox.show();
							}
					  });
		
					  
					  /**
						 * Anlegen eines Labels mit dem Namen "Zeitraum von"
						 */
						 Label zeitraum = new Label("Zeitraum von:");
							zeitraum.setStylePrimaryName("labelReportLabel2");
							inputPanel.add(zeitraum);  
							
							/**
							 * Datepicker wird angelegt
							 */
							DatePicker datePicker = new DatePicker();
							datePicker.setStylePrimaryName("labelReportLabel3");
							inputPanel.add(datePicker);
							
							 	
								/**
								 * Anlegen eines Labels mit dem Namen "Zeitraum bis"
								 */
								 Label zeitraumBis = new Label("Zeitraum bis:");
									zeitraumBis.setStylePrimaryName("labelReportLabel2");
									inputPanel.add(zeitraumBis);  
								
								/**
								 * Datepicker wird angelegt
								 */
								DatePicker datePicker2 = new DatePicker();
								datePicker.setStylePrimaryName("labelReportLabel3");
								inputPanel.add(datePicker2);
					  
	/**
	 * Hier muss die FlexTable für die NachrichtenInfos rein!!!
	 */

}
}