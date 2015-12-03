package de.hdm.itprojekt.messenger.server.db;

public class NutzerAbonnementMapper extends DBConnection {
	
	private static NutzerAbonnementMapper nutzerAbonnementMapper = null;
	
	protected NutzerAbonnementMapper () {
		
	}
	
	public static NutzerAbonnementMapper getNutzerAbonnementMapper() {
		return nutzerAbonnementMapper;
	}

}
