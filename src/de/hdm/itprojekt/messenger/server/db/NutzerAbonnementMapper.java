package de.hdm.itprojekt.messenger.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import de.hdm.itprojekt.messenger.shared.bo.Abonnement;
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

			ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid "
			          + "FROM nutzerAbonnement ");
			 // Wenn wir etwas zurueckerhalten, kann dies nur einzeilig sein
		      if (rs.next()) {
		        /*
		         * c erhaelt den bisher maximalen, nun um 1 inkrementierten
		         * Primaerschluessel.
		         */
		        a.setID(rs.getInt("maxid") + 1);

		        stmt = con.createStatement();

		        // Jetzt erst erfolgt die tatsaechliche Einfuegeoperation
		        stmt.executeUpdate("INSERT INTO nutzerAbonnement (id, abonnierterNutzerID, erstellungszeitpunkt) "
		            + "VALUES (" + a.getID() + ",'"
		            + a.getAbonnierterNutzerID() + "''" + a.getErstellungszeitpunkt() + "')");
		      }
		    }
		    catch (SQLException e) {
		      e.printStackTrace();
		    }
			return a;
	}
	
	/**
	 * Methode um ein NutzerAbonnement zu bearbeiten
	 * @return
	 */
	public NutzerAbonnement bearbeiten() {
		return null;
	}
	
	/**
	 * NutzerAbonnement loeschen
	 * @param Hashtag
	 */
	public void loeschen(Abonnement nutzerAbonnement) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM nutzerAbonnement " + "WHERE id=" + nutzerAbonnement.getID());
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
	public Vector<NutzerAbonnement> getNutzerAbonnementByNutzer(String nachname) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.connection();
	    Vector<NutzerAbonnement> result = new Vector<NutzerAbonnement>();

	    try {
	      Statement stmt = con.createStatement();

	      ResultSet rs = stmt.executeQuery("SELECT *" + "FROM nutzerAbonnement" 
	    		  + "WHERE name LIKE '" + nachname + "' ORDER BY nachname");

	      // Fuer jeden Eintrag im Suchergebnis wird nun ein NutzerAbonnement-Objekt erstellt.
	      while (rs.next()) {
	        NutzerAbonnement n = new NutzerAbonnement();
	        n.setID(rs.getInt("id"));
	        n.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));
	    //    n.setVorname(rs.getString("vorname"));
	    //    n.setNachname(rs.getString("nachname"));

	        // Hinzufuegen des neuen Objekts zum Ergebnisvektor
	        result.addElement(n);
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

	      ResultSet rs = stmt.executeQuery("SELECT *" + "FROM nutzerAbonnement" 
	          + "' ORDER BY name");

	      // Fuer jeden Eintrag im Suchergebnis wird nun ein NutzerAbonnement-Objekt erstellt.
	      while (rs.next()) {
	        NutzerAbonnement h = new NutzerAbonnement();
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
