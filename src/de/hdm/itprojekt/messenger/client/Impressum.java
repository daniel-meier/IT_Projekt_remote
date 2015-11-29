package de.hdm.itprojekt.messenger.client;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Impressum extends VerticalPanel {
	
	public void onLoad() {
		super.onLoad();
		Label l = new Label("Impressum");
        this.add(l);
	}

}
