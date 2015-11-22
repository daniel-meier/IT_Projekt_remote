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
	private String name;
	
	/**
	 * leerer Konstruktor
	 */
	public Hashtag(){
		
	}
	/**
	 * Auslesen des Namens
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * setzen des Namens
	 * @param name
	 */
	public void setName (String name){
		this.name = name;
	}

}
