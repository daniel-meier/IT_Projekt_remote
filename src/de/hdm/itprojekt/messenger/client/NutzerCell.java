package de.hdm.itprojekt.messenger.client;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.itprojekt.messenger.shared.bo.Nutzer;

public class NutzerCell extends AbstractCell<Nutzer>{

	@Override
	public void render(Context context,
			Nutzer value, SafeHtmlBuilder sb) {
		
		if (value == null) {
	      return;
	    }
	


		  sb.appendHtmlConstant("<table><tr><td>");
	      sb.appendEscaped(value.getVorname());
	      sb.appendEscaped(" ");
		  sb.appendEscaped(value.getNachname());
		  sb.appendHtmlConstant("</br>");
		  sb.appendHtmlConstant("<email style='font-size:90%; margin-left: 20px;'>");
		  sb.appendEscaped(value.getEmail());
		  sb.appendHtmlConstant("</email>");
	      sb.appendHtmlConstant("</td></tr></table>");
		

//	      sb.appendHtmlConstant("<table>");
//	      sb.appendEscaped(value.getVorname());
//	      sb.appendEscaped(" ");
//		  sb.appendEscaped(value.getNachname());
//	      sb.appendHtmlConstant("</td></tr><tr><td style='font-size:90%; border-bottom: thin solid grey;'>");
//	      sb.appendEscaped(value.getEmail());
//	      sb.appendHtmlConstant("</td></tr></table>");
		
		
//	    sb.appendEscaped(value.getVorname());
//	    sb.appendEscaped(" ");
//	    sb.appendEscaped(value.getNachname());
//	    sb.appendHtmlConstant("</br>");
//	    sb.appendHtmlConstant("<email style='font-size:90%; margin-left: 20px;'>");
//	    sb.appendEscaped(value.getEmail());
//	    sb.appendHtmlConstant("</email>");
	    }		


	
}
