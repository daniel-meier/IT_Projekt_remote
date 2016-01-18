package de.hdm.itprojekt.messenger.client.report;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * @author kimbo
 *
 */
public class Startseite extends ReportFormular {

	public void onLoad() {
		super.onLoad();

		/**
		 * Überschrift der Seite
		 */
		setHeadline("Startseite");

		/**
		 * HorizontalPanel
		 */
		HorizontalPanel inputPanel = getInputPanel();

		/**
		 * Button
		 */
		final Button nachrichtenInfoButton = new Button(
				"Informationen über Nachrichten");
		nachrichtenInfoButton.setStylePrimaryName("report-mainbutton");
		inputPanel.add(nachrichtenInfoButton);

		nachrichtenInfoButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				VerticalPanel nachrichtenInfo = new NachrichtenInfo();

				RootPanel.get("window").clear();
				RootPanel.get("input").clear();
				RootPanel.get("headline").clear();
				RootPanel.get("window").add(nachrichtenInfo);
			}
		});

		/**
		 * Button
		 */
		final Button abonnementInfoButton = new Button(
				"Informationen über Abonnements");
		abonnementInfoButton.setStylePrimaryName("report-mainbutton");
		inputPanel.add(abonnementInfoButton);

		abonnementInfoButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				VerticalPanel abonnementInfo = new AbonnementInfo();

				RootPanel.get("window").clear();
				RootPanel.get("input").clear();
				RootPanel.get("headline").clear();
				RootPanel.get("window").add(abonnementInfo);
			}
		});
	}
}
