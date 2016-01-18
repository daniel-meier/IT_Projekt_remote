package de.hdm.itprojekt.messenger.client.report;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DatePicker;

/**
 * 
 * @author kimbo
 *
 */
public class NachrichtenInfo extends ReportFormular {

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
		 * Button
		 */
		final Button suchen = new Button("Suchen");
		suchen.setStylePrimaryName("report-suchen1-button");
		inputPanel.add(suchen);

		/**
		 * Anlegen eines Labels mit dem Namen "Nutzer"
		 */
		Label nutzer = new Label("Nutzer:");
		nutzer.setStylePrimaryName("labelReportLabel");
		this.add(nutzer);

		/**
		 * Anlegen der Suggestbox
		 */
		MultiWordSuggestOracle nachNutzerSuchenOracle = new MultiWordSuggestOracle();

		final SuggestBox suggestBox = new SuggestBox(nachNutzerSuchenOracle);
		suggestBox.setWidth("190px");
		this.add(suggestBox);

		/**
		 * Anlegen eines Labels mit dem Namen "Zeitraum von"
		 */
		Label zeitraum = new Label("Zeitraum von:");
		zeitraum.setStylePrimaryName("labelZeitraumVon");
		this.add(zeitraum);

		/**
		 * Datepicker wird angelegt
		 */
		DatePicker datePicker = new DatePicker();
		// datePicker.setStylePrimaryName("labelReportLabel3");
		this.add(datePicker);

		/**
		 * Anlegen eines Labels mit dem Namen "Zeitraum bis"
		 */
		Label zeitraumBis = new Label("Zeitraum bis:");
		zeitraumBis.setStylePrimaryName("labelZeitraumBis");
		this.add(zeitraumBis);

		/**
		 * Datepicker wird angelegt
		 */
		DatePicker datePicker2 = new DatePicker();
		// datePicker.setStylePrimaryName("labelReportLabel3");
		this.add(datePicker2);

		/**
		 * Hier muss die FlexTable für die NachrichtenInfos rein!!!
		 */
	}
}