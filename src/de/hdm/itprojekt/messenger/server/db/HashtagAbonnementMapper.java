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
	public HashtagAbonnement erstellen(HashtagAbonnement a) {
		Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      /*
	       * Zunaechst schauen wir nach, welches der momentan hoechste
	       * Primaerschluesselwert ist.
	       */
	      ResultSet rs = stmt.executeQuery("SELECT MAX(HashtagAbonnementID) AS maxid "
	          + "FROM HashtagAbonnement ");

	      // Wenn wir etwas zurueckerhalten, kann dies nur einzeilig sein
	      if (rs.next()) {
	        /*
	         * a erhaelt den bisher maximalen, nun um 1 inkrementierten
	         * Primaerschluessel.
	         */
	        a.setID(rs.getInt("maxid") + 1);

	        stmt = con.createStatement();

	        // Jetzt erst erfolgt die tatsaechliche Einfuegeoperation
	        stmt.executeUpdate("INSERT INTO HashtagAbonnement (HashtagAbonnementID, AbonnierteHashtagID) "
	            + "VALUES (" + a.getID() + ",'"
	            + a.getAbonnierterHashtagID() + "')");
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
		return a;
	}
	
//	/**
//	 * Methode um ein Hashtag Abonnement zu bearbeiten
//	 * @return
//	 */
//	public HashtagAbonnement bearbeiten() {
//		//TODO Was muss die Methode k�nnen?
//		return null;
//	}
	
	/**
	 * HashtagAbonnement loeschen
	 * @param Hashtag
	 */
	public void loeschen(Abonnement hashtagAbonnement) {
		Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM HashtagAbonnement " 
	    		  + "WHERE HashtagAbonnementID=" + hashtagAbonnement.getID());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	}

	/**
	 * Auslesen aller Hashtag Abonnements nach ihrem Namen
	 * @param name 
	 * @return
	 */
	public Vector<HashtagAbonnement> getHashtagAbonnementByName(String hashtagText) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.connection();
	    Vector<HashtagAbonnement> result = new Vector<HashtagAbonnement>();

	    try {
	      Statement stmt = con.createStatement();
//TODO
	      ResultSet rs = stmt.executeQuery("SELECT Hashtag.HashtagID, Hashtag.HashtagText "
	      		+ "FROM HashtagAbonnement INNER JOIN Hashtag" 
	    		+ "WHERE HashtagText LIKE '" + hashtagText + "' ORDER BY Name");

	      // Fuer jeden Eintrag im Suchergebnis wird nun ein HashtagAbonnement-Objekt erstellt.
	      while (rs.next()) {
	        Hashtag h = new Hashtag();
	        h.setID(rs.getInt("HashtagID"));
	        h.setHashtagtext(rs.getString("HashtagText"));
	        //h.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));

	        // Hinzufuegen des neuen Objekts zum Ergebnisvektor
//	        result.addElement(h);
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

	      ResultSet rs = stmt.executeQuery("SELECT * FROM HashtagAbonnement" 
	          + "' ORDER BY Name");

	      // Fuer jeden Eintrag im Suchergebnis wird nun ein HashtagAbonnement-Objekt erstellt.
	      while (rs.next()) {
	        Hashtag h = new Hashtag();
	        h.setID(rs.getInt("HashtagAbonnementID"));
	        h.setHashtagtext(rs.getString("HashtagText"));
	        //h.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));

	        // Hinzufuegen des neuen Objekts zum Ergebnisvektor
//	        result.addElement(h);
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    // Ergebnisvektor zurueckgeben
	    return result;
	}

}
