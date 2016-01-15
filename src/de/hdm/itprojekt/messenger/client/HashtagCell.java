package de.hdm.itprojekt.messenger.client;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

import de.hdm.itprojekt.messenger.shared.bo.Hashtag;

public class HashtagCell extends AbstractCell<Hashtag>{

	@Override
	public void render(Context context,
			Hashtag value, SafeHtmlBuilder sb) {
		
		if (value == null) {
	      return;
	    }
		
	    sb.appendHtmlConstant("<table><tr><td>");
	    sb.appendEscaped(value.getHashtagText());
	    sb.appendHtmlConstant("</td></tr></table>");

	    }		

}
