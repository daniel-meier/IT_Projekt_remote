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
	
	private String hashtagText;
	
	/**
	 * leerer Konstruktor
	 */
	public Hashtag(){
		
	}
	
	/**
	 * Test Konstruktor für GUI Entwicklung
	 */
	public Hashtag(String name){
		this.name = name;
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
	public void setHashtagtext(String hashtagText) {
		// TODO Auto-generated method stub
		this.hashtagText = hashtagText;
	}
	public String getHashtagtext() {
		// TODO Auto-generated method stub
		return this.hashtagText;
	}

}
