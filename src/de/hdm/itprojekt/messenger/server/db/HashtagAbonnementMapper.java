package de.hdm.itprojekt.messenger.server.db;

public class HashtagAbonnementMapper extends DBConnection {
	
	private static HashtagAbonnementMapper hashtagAbonnementMapper = null;
	
	protected HashtagAbonnementMapper () {
		
	}
	
	public static HashtagAbonnementMapper getHashtagAbonnementMapper() {
		return hashtagAbonnementMapper;
	}

}
