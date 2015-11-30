package de.hdm.itprojekt.messenger.client;

import com.google.gwt.user.client.ui.*;

public class NachrichtSchreiben extends VerticalPanel{
	
	public void onLoad() {
		super.onLoad();
		RichTextArea text = new RichTextArea();
		this.add(text);
		
	}

}
