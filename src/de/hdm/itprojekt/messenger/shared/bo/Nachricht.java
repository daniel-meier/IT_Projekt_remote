package de.hdm.itprojekt.messenger.shared.bo;

import java.util.ArrayList;

public class Nachricht extends BusinessObject{
	
	
	//Anlegen der Attribute
	private static final long serialVersionUID =1L;
	private String text;
	private Nutzer sender;
	private Nutzer gempfaenger;
	private Nutzer sempfaenger;
	
	
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
		return gempfaenger;
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	public void setEmpfaenger (Nutzer empfaenger){
		this.sempfaenger = empfaenger;
	}
	

}
