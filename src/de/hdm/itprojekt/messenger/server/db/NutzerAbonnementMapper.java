package de.hdm.itprojekt.messenger.server.db;

import de.hdm.itprojekt.messenger.shared.bo.Nutzer;
import de.hdm.itprojekt.messenger.shared.bo.NutzerAbonnement;

public class NutzerAbonnementMapper extends DBConnection {
	
	private static NutzerAbonnementMapper nutzerAbonnementMapper = null;
	
	protected NutzerAbonnementMapper () {
		
	}
	
	public static NutzerAbonnementMapper getNutzerAbonnementMapper() {
		return nutzerAbonnementMapper;
	}
	
	/**
	 * Methode um einen Nutzer zu abonnieren
	 * @return
	 */
	public NutzerAbonnement erstellen(Nutzer nutzer) {
		return null;
		
	}
	
	/**
	 * NutzerAbonnement loeschen
	 * @param Hashtag
	 */
	public void loeschen(NutzerAbonnement nutzerAbonnement) {
		
	}

}
