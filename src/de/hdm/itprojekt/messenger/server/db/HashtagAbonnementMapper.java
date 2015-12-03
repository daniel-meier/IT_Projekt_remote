package de.hdm.itprojekt.messenger.server.db;

import de.hdm.itprojekt.messenger.shared.bo.HashtagAbonnement;

public class HashtagAbonnementMapper extends DBConnection {
	
	private static HashtagAbonnementMapper hashtagAbonnementMapper = null;
	
	protected HashtagAbonnementMapper () {
		
	}
	
	public static HashtagAbonnementMapper getHashtagAbonnementMapper() {
		return hashtagAbonnementMapper;
	}
	
	/**
	 * Methode um ein Hashtag zu abonnieren
	 * @return
	 */
	public HashtagAbonnement erstellen(String hashtag) {
		return null;
		
	}
	
	/**
	 * HashtagAbonnement loeschen
	 * @param Hashtag
	 */
	public void loeschen(HashtagAbonnement hashtagAbonnement) {
		
	}

}
