package de.hdm.itprojekt.messenger.client;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

import de.hdm.itprojekt.messenger.shared.bo.Unterhaltung;

public class UnterhaltungCell extends AbstractCell<Unterhaltung>{

	@Override
	public void render(Context context,
			Unterhaltung value, SafeHtmlBuilder sb) {
		
		if (value == null) {
	      return;
	    }
		
		sb.appendHtmlConstant("<table><tr><td>");
	    sb.appendEscaped("Teilnehmername");
	    sb.appendEscaped("</br>");
		sb.appendEscaped("Anfang der letzten Nachricht");
		sb.appendHtmlConstant("</br>");
		sb.appendEscaped("Datum/Uhrzeit");
	    sb.appendHtmlConstant("</td></tr></table>");

	    }		

}
