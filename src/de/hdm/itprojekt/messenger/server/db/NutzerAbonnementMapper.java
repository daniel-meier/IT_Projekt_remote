package de.hdm.itprojekt.messenger.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import de.hdm.itprojekt.messenger.shared.bo.Abonnement;
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
	public NutzerAbonnement erstellen(NutzerAbonnement a) {
		//Aufbau der DBVerbindung
		Connection con = DBConnection.connection();

		try{
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT MAX(NutzerAbonnementID) AS maxid "
			          + "FROM NutzerAbonnement ");
			 // Wenn wir etwas zurueckerhalten, kann dies nur einzeilig sein
		      if (rs.next()) {
		        /*
		         * a erhaelt den bisher maximalen, nun um 1 inkrementierten
		         * Primaerschluessel.
		         */
		        a.setID(rs.getInt("maxid") + 1);

		        stmt = con.createStatement();

		        // Jetzt erst erfolgt die tatsaechliche Einfuegeoperation
		        stmt.executeUpdate("INSERT INTO NutzerAbonnement (NutzerAbonnement, AbonnierterNutzerID) "
		            + "VALUES (" + a.getID() + ",'"
		            + a.getAbonnierterNutzerID() + "')");
		      }
		    }
		    catch (SQLException e) {
		      e.printStackTrace();
		    }
			return a;
	}
	
//	/**
//	 * Methode um ein NutzerAbonnement zu bearbeiten
//	 * @return
//	 */
//	public NutzerAbonnement bearbeiten() {
//		//TODO Was muss die Methode können?
//		return null;
//	}
	
	/**
	 * NutzerAbonnement loeschen
	 * @param Hashtag
	 */
	public void loeschen(Abonnement nutzerAbonnement) {
		Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM NutzerAbonnement " 
	    		  + "WHERE NutzerAbonnementID=" + nutzerAbonnement.getID());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	}

	/**
	 * Auslesen der Nutzer Abonnements nach Nutzer (nachname) angabe
	 * @param nachname 
	 * @return
	 */
	public Vector<NutzerAbonnement> getNutzerAbonnementByNutzer(Nutzer vorname, Nutzer nachname) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.connection();
	    Vector<NutzerAbonnement> result = new Vector<NutzerAbonnement>();

	    try {
	      Statement stmt = con.createStatement();

	      ResultSet rs = stmt.executeQuery("SELECT NutzerAbonnement.NutzerAbonnementID,"
	      		+ " Nutzer.Vorname, Nutzer.Nachname FROM NutzerAbonnement INNER JOIN Nutzer" 
	    		+ "WHERE Vorname LIKE '" + vorname + "' AND Nachname LIKE '" 
	      		+ nachname + "' ORDER BY Nutzer.Nachname");

	      // Fuer jeden Eintrag im Suchergebnis wird nun ein NutzerAbonnement-Objekt erstellt.
	      while (rs.next()) {
	        Nutzer n = new Nutzer();
	        n.setID(rs.getInt("Nutzer.NutzerID"));
	        n.setErstellungszeitpunkt(rs.getDate("Nutzer.Erstellungszeitpunkt"));
	        n.setVorname(rs.getString("Nutzer.Vorname"));
	        n.setNachname(rs.getString("Nutzer.Nachname"));

	        // Hinzufuegen des neuen Objekts zum Ergebnisvektor
	      //  result.add(n);
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    // Ergebnisvektor zurueckgeben
	    return result;
	}
	
	/**
	 * Auslesen aller Nutzer Abonnements
	 * @return
	 */
	public Vector<NutzerAbonnement> getAllNutzerAbonnement() {
		// TODO Auto-generated method stub
		Connection con = DBConnection.connection();
	    Vector<NutzerAbonnement> result = new Vector<NutzerAbonnement>();

	    try {
	      Statement stmt = con.createStatement();

	      ResultSet rs = stmt.executeQuery("SELECT NutzerAbonnement.NutzerAbonnementID"
	    		  + " Nutzer.Vorname Nutzer.Nachname FROM NutzerAbonnement INNER JOIN Nutzer" 
	    		  + "' ORDER BY Nutzer.Nachname");

	      // Fuer jeden Eintrag im Suchergebnis wird nun ein NutzerAbonnement-Objekt erstellt.
	      while (rs.next()) {
	        NutzerAbonnement h = new NutzerAbonnement();
	        h.setID(rs.getInt("NutzerAbonnementID"));
	        //h.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));

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
