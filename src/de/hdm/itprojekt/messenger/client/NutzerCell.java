package de.hdm.itprojekt.messenger.client;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

import de.hdm.itprojekt.messenger.shared.bo.Nutzer;

public class NutzerCell extends AbstractCell<Nutzer>{

	@Override
	public void render(Context context,
			Nutzer value, SafeHtmlBuilder sb) {
		
		if (value == null) {
	      return;
	    }

	    sb.appendEscaped(value.getVorname());
	    sb.appendEscaped(" ");
	    sb.appendEscaped(value.getNachname());
	    sb.appendHtmlConstant("</br>");
	    sb.appendEscaped(value.getEmail());
	    }		

}
