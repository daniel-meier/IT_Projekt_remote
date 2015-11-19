package de.hdm.itprojekt.messenger.shared.bo;

import java.util.ArrayList;

public class Nachricht {
	
	
	//Anlegen der Attribute
	private static final long serialVersionUID =1L;
	private String text;
	private Nutzer sender;
	private ArrayList<Nutzer> empfeanger;
	private Nutzer empfaenger;
	
	
	//Anlegen der Methoden 
	
	public Nachricht() {
	}
	
	public String getText(){
		return text;
	}
	
	public Nutzer getSender(){
		return sender;
	}
	
	public Nutzer getEmpfaenger(){
		return empfaenger;
	}
	
	public void setText(String text){
		
	}
	
	public void setEmpfaenger (ArrayList<Nutzer> enpfanger){
		
	}
	

}
