package de.hdm.itprojekt.messenger.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import de.hdm.itprojekt.messenger.shared.bo.Abonnement;


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

	      ResultSet rs = stmt.executeQuery("SELECT *" + "FROM abonnement" 
	          + "' ORDER BY name");

	      // Fuer jeden Eintrag im Suchergebnis wird nun ein NutzerAbonnement-Objekt erstellt.
	      while (rs.next()) {
	        Abonnement a = new Abonnement();
	        a.setID(rs.getInt("id"));
	        a.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));

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
