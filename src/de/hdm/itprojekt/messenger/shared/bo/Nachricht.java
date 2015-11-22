package de.hdm.itprojekt.messenger.shared.bo;

import java.util.ArrayList;

/**
 * BusinessObject, ist die Superklasse von Nachricht
 * @author tinohauler
 *
 */



public class Nachricht extends BusinessObject{
	
	
	
	/**
	 * Anlegen der Attribute
	 */
	private static final long serialVersionUID =1L;
	private String text;
	private Nutzer sender;
	private Nutzer empfaenger;
	
	/**
	 * leerer Kontrusktor
	 */
	public Nachricht() {
	}
	
	
	/**Auslesen des Textes
	 * @return text
	 */
	public String getText() {
		return text;
	}

	
	/**
	 * Setzen des Textes
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Auslesen des Senders
	 * @return sender
	 */
	public Nutzer getSender() {
		return sender;
	}

	/**
	 * Setzen des Senders
	 * @param sender
	 */
	public void setSender(Nutzer sender) {
		this.sender = sender;
	}

	/**
	 * Auslesen des Empfängers
	 * @return emfaenger
	 */
	public Nutzer getEmpfaenger() {
		return empfaenger;
	}

	/**
	 * Setzen des Emfängers
	 * @param empfaenger
	 */
	public void setEmpfaenger(Nutzer empfaenger) {
		this.empfaenger = empfaenger;
	}
}
