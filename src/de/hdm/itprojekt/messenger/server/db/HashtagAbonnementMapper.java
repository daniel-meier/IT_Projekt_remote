package de.hdm.itprojekt.messenger.server.db;

import java.util.Vector;

import de.hdm.itprojekt.messenger.shared.bo.Abonnement;
import de.hdm.itprojekt.messenger.shared.bo.Hashtag;
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
	public Hashtag erstellen(String hashtag) {
		return null;
		
	}
	
	/**
	 * HashtagAbonnement loeschen
	 * @param Hashtag
	 */
	public void loeschen(Abonnement abonnement) {
		
	}

	/**
	 * Auslesen aller Hashtag Abonnements
	 * @return
	 */
	public Vector<Abonnement> getHashtagAbonnement() {
		// TODO Auto-generated method stub
		return null;
	}

}
