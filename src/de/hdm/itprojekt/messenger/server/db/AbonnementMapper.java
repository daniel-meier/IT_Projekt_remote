package de.hdm.itprojekt.messenger.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import de.hdm.itprojekt.messenger.shared.bo.Abonnement;
import de.hdm.itprojekt.messenger.shared.bo.Hashtag;


public class AbonnementMapper extends DBConnection {

private static AbonnementMapper abonnementMapper = null;
	
	protected AbonnementMapper () {
		
	}
	
	public static AbonnementMapper getAbonnementMapper() {
		return abonnementMapper;
	}
	
	/** Suche eines Abonnements nach seiner eindeutigen Nummer
	 * 
	 * @param id
	 * @return
	 */
	public Abonnement findbyID (int id) {
		
		 // DB-Verbindung holen
	    Connection con = DBConnection.connection();

	    try {
	      // Leeres SQL-Statement (JDBC) anlegen
	      Statement stmt = con.createStatement();

	      // Statement ausfüllen und als Query an die DB schicken
	      ResultSet rs = stmt
	          .executeQuery("SELECT AbonnementID, Erstellungszeitpunkt, AbonnentNutzerID FROM Abonnement "
	              + "WHERE AbonnementID=" + id + " ORDER BY AbonnementID");

	      /*
	       * Da id Primärschlüssel ist, kann max. nur ein Tupel zurückgegeben
	       * werden. Prüfe, ob ein Ergebnis vorliegt.
	       */
	      if (rs.next()) {
	        // Ergebnis-Tupel in Objekt umwandeln
	        Abonnement a = new Abonnement();
	        a.setID(rs.getInt("AbonnementID"));
	        a.setErstellungszeitpunkt(rs.getDate("Erstellungszeitpunkt"));
	     //TODO Abonnent
	        return a;
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	      return null;
	    }
		return null;
	}
	
	
	/** 
	 * Auslesen aller Abonnements
	 * @return
	 */
	public Vector<Abonnement> getAllAbonnement() {
		// TODO Auto-generated method stub
		Connection con = DBConnection.connection();
	    Vector<Abonnement> result = new Vector<Abonnement>();

	    try {
	      Statement stmt = con.createStatement();

	      ResultSet rs = stmt.executeQuery("SELECT *" + "FROM Abonnement" 
	          + "' ORDER BY AbonnementID");

	      // Fuer jeden Eintrag im Suchergebnis wird nun ein NutzerAbonnement-Objekt erstellt.
	      while (rs.next()) {
	        Abonnement a = new Abonnement();
	        a.setID(rs.getInt("AbonnementID"));
	        a.setErstellungszeitpunkt(rs.getDate("Erstellungszeitpunkt"));
//TODO Abonnent
	        // Hinzufuegen des neuen Objekts zum Ergebnisvektor
	        result.addElement(a);
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    // Ergebnisvektor zurueckgeben
	    return result;
	}
	
}
