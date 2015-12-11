package de.hdm.itprojekt.messenger.server.db;

import java.util.Vector;

import de.hdm.itprojekt.messenger.shared.bo.Hashtag;

public class HashtagMapper extends DBConnection{
	
private static HashtagMapper hashtagMapper = null;
	
	protected HashtagMapper () {
		
	}
	
	public static HashtagMapper getHashtagMapper() {
		return hashtagMapper;
	}
	
	/** Suche eines Hashtags nach seiner eindeutigen Nummer
	 * 
	 * @param id
	 * @return
	 */
	public Hashtag findbyID (int id) {
		return null;
		
	}
	
	/** Einfügen eines Hashtag Objekts in die Datenbank
	 * 
	 * @param Hashtag
	 * @return
	 */
	public Hashtag einfuegen (Hashtag hashtag) {
		return hashtag;
		
	}
	
	/** Bearbeiten eines Hashtag Objekts in der Datenbank
	 * 
	 * @param Hashtag
	 * @return
	 */
	public Hashtag bearbeiten (Hashtag hashtag) {
		return hashtag;
		
	}
	
	/** Löschen eines Hashtag Objekts aus der Datenbank
	 * 
	 * @param Hashtag
	 */
	public void loeschen (Hashtag hashtag) {
		
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
		return null;
		
	}

}
