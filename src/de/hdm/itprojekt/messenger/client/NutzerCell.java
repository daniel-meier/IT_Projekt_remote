package de.hdm.itprojekt.messenger.client;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.messenger.shared.bo.Nutzer;

/**
 * NutzerCell ist eine Subklasse, welche von der Superklasse AbstractCell<Nutzer> erbt
 * @author kimbo
 *
 */
public class NutzerCell extends AbstractCell<Nutzer> {

	@Override
	public void render(Context context, Nutzer value, SafeHtmlBuilder sb) {

		if (value == null) {
			return;
		}

		sb.appendHtmlConstant("<div>");
		sb.appendEscaped(value.getVorname() + " " + value.getNachname());
		sb.appendHtmlConstant("</div>");
		sb.appendHtmlConstant("<div style=\"border-bottom: 1px solid #dddddd;\">");
		sb.appendHtmlConstant("<email style='font-size:90%; padding-left: 20px;'>");
		sb.appendEscaped(value.getEmail());
		sb.appendHtmlConstant("</email>");
		sb.appendHtmlConstant("</div>");

	}

}
