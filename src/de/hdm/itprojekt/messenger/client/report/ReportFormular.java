package de.hdm.itprojekt.messenger.client.report;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * @author kimbo
 *
 */
public class ReportFormular extends VerticalPanel {

	public void onLoad() {

		super.onLoad();

	}
	
	/**
	 * 
	 */
	private HorizontalPanel headlinePanel = null;
	private HorizontalPanel inputPanel = null;

	public void setHeadline(String headlineName) {

		/**
		 * Horizontal Panel für Überschrift
		 */
		headlinePanel = new HorizontalPanel();
		RootPanel.get("headline").add(headlinePanel);

		Label headline = new Label(headlineName);
		headline.setStyleName("headline");
		headlinePanel.add(headline);
	}

	/**
	 * 
	 * @return
	 */
	public HorizontalPanel getHeadline() {
		return headlinePanel;
	}
	
	/**
	 * 
	 * @return
	 */
	public HorizontalPanel getInputPanel() {

		/**
		 * Horizontal Panel für Edit-Buttons
		 */
		inputPanel = new HorizontalPanel();
		RootPanel.get("input").add(inputPanel);

		return inputPanel;
	}
}
