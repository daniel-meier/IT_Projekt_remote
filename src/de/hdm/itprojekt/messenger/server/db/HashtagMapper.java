package de.hdm.itprojekt.messenger.server.db;

import java.util.Vector;

import de.hdm.itprojekt.messenger.shared.bo.Hashtag;

public class HashtagMapper extends DBConnection{
	
	public HashtagMapper () {
		
	}
	
	public HashtagMapper hashtagMapper () {
		
	}
	
	/** Suche eines Hashtags nach seiner eindeutigen Nummer
	 * 
	 * @param id
	 * @return
	 */
	public Hashtag findbyID (int id) {
		
	}
	
	/** Einfügen eines Hashtag Objekts in die Datenbank
	 * 
	 * @param Hashtag
	 * @return
	 */
	public Hashtag einfuegen (hashtag Hashtag) {
		
	}
	
	/** Bearbeiten eines Hashtag Objekts in der Datenbank
	 * 
	 * @param Hashtag
	 * @return
	 */
	public Hashtag bearbeiten (hashtag Hashtag) {
		
	}
	
	/** Löschen eines Hashtag Objekts aus der Datenbank
	 * 
	 * @param Hashtag
	 */
	public void loeschen (hashtag Hashtag) {
		
	}
	
	/** Suchen eines Hashtag Objekts nach seinem Namen
	 * 
	 * @param name
	 * @return
	 */
	public Vector<Hashtag> findByName (String name) {
		return null;
		
	}
	
	/** Auslesen aller Hashtags
	 * 
	 * @return
	 */
	public Vector<Hashtag> getAllHashtags () {
		
	}

}
