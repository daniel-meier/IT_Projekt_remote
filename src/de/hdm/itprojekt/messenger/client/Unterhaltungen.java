package de.hdm.itprojekt.messenger.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;


public class Unterhaltungen extends Formular {

		public void onLoad(){
		super.onLoad();

		setHeadline("Unterhaltungen");

		
		Label l = new Label("Hier wird später ein FlexTable, dass die Unterhaltungen enthält, angezeigt");
        this.add(l);
		
		
		}
}
