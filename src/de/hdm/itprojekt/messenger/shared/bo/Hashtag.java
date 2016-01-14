package de.hdm.itprojekt.messenger.shared.bo;

/**
 * BusinessObject, ist die Superklasse von Hashtag
 * @author tinohauler
 *
 */

public class Hashtag extends BusinessObject {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Anlegen des Attributs
	 */
	private String hashtagText;
	
	/**
	 * leerer Konstruktor
	 */
	public Hashtag(){
		
	}
	
	/**
	 * Test Konstruktor fuer GUI Entwicklung
	 */
	public Hashtag(String hashtagText){
		this.hashtagText = hashtagText;
	}
	
	/**
	 * Auslesen des Namens
	 */
	public String getHashtagText(){
		return this.hashtagText;
	}
	
	/**
	 * setzen des Namens
	 * @param name
	 */
	public void setHashtagText (String hashtagText){
		this.hashtagText = hashtagText;
	}

}
