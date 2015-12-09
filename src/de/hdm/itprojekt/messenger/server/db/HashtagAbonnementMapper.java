package de.hdm.itprojekt.messenger.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	 * Auslesen aller Hashtag Abonnements nach ihrem Namen
	 * @param name 
	 * @return
	 */
	public Vector<HashtagAbonnement> getHashtagAbonnementByName(String name) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.connection();
	    Vector<HashtagAbonnement> result = new Vector<HashtagAbonnement>();

	    try {
	      Statement stmt = con.createStatement();

	      ResultSet rs = stmt.executeQuery("SELECT *" + "FROM hashtagAbonnement" 
	    		  + "WHERE name LIKE '" + name + "' ORDER BY name");

	      // Fuer jeden Eintrag im Suchergebnis wird nun ein HashtagAbonnement-Objekt erstellt.
	      while (rs.next()) {
	        HashtagAbonnement h = new HashtagAbonnement();
	        h.setID(rs.getInt("id"));
	        h.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));

	        // Hinzufuegen des neuen Objekts zum Ergebnisvektor
	        result.addElement(h);
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    // Ergebnisvektor zurueckgeben
	    return result;
	}
	
	/**
	 * Auslesen aller Hashtag Abonnements
	 * @return
	 */
	public Vector<HashtagAbonnement> getAllHashtagAbonnement() {
		// TODO Auto-generated method stub
		Connection con = DBConnection.connection();
	    Vector<HashtagAbonnement> result = new Vector<HashtagAbonnement>();

	    try {
	      Statement stmt = con.createStatement();

	      ResultSet rs = stmt.executeQuery("SELECT *" + "FROM hashtagAbonnement" 
	          + "' ORDER BY name");

	      // Fuer jeden Eintrag im Suchergebnis wird nun ein HashtagAbonnement-Objekt erstellt.
	      while (rs.next()) {
	        HashtagAbonnement h = new HashtagAbonnement();
	        h.setID(rs.getInt("id"));
	        h.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));

	        // Hinzufuegen des neuen Objekts zum Ergebnisvektor
	        result.addElement(h);
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    // Ergebnisvektor zurueckgeben
	    return result;
	}

	

}
