package de.hdm.itprojekt.messenger.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

public class Formular extends HorizontalPanel {

	/**
	 * 
	 */
	public void onLoad() {

		super.onLoad();

	}

	/**
	 * 
	 */
	private HorizontalPanel headlinePanel = null;
	private HorizontalPanel buttonPanel = null;

	/**
	 * 
	 * @param headlineName
	 */
	public void setHeadline(String headlineName) {

		/**
		 * Horizontal Panel für Überschrift
		 */
		headlinePanel = new HorizontalPanel();
		RootPanel.get("headline").add(headlinePanel);

		/**
		 * 
		 */
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
	public HorizontalPanel getButtonPanel() {

		/**
		 * Horizontal Panel für Edit-Buttons
		 */
		buttonPanel = new HorizontalPanel();
		RootPanel.get("input").add(buttonPanel);

		return buttonPanel;
	}

}
