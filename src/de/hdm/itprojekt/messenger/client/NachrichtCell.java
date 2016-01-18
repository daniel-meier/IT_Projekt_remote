package de.hdm.itprojekt.messenger.client;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.messenger.shared.bo.Nachricht;
import de.hdm.itprojekt.messenger.shared.bo.Unterhaltung;

/**
 * NachrichtCell ist eine Subklasse, welche von der Superklasse AbstractCell<Nachrichten> erbt
 * @author kimbo
 *
 */
public class NachrichtCell extends AbstractCell<Nachricht> {

	@Override
	public void render(Context context, Nachricht value, SafeHtmlBuilder sb) {

		if (value == null) {
			return;
		}

		sb.appendHtmlConstant("<div style='margin-bottom: 5px; '>");
		sb.appendEscaped("Name des Nachrichtensenders: ");
		sb.appendEscaped("Nachrichtentext");
		sb.appendHtmlConstant("</div>");
	}
}