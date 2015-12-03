package de.hdm.itprojekt.messenger.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import de.hdm.itprojekt.messenger.shared.bo.Nachricht;
import de.hdm.itprojekt.messenger.shared.bo.Nutzer;



public class NachrichtMapper extends DBConnection {

	private static NachrichtMapper nachrichtMapper = null;
	
	protected NachrichtMapper () {
		
	}
	
	public static NachrichtMapper getNachrichtMapper(){
		return nachrichtMapper;
	}
	
	/** Suchen einer Nachricht mit seiner eindeutigen Nummer
	 * 
	 * @param id
	 * @return
	 */
	public Nachricht findByID (int id) {
	    // DB-Verbindung holen
	    Connection con = DBConnection.connection();

	    try {
	      // Leeres SQL-Statement (JDBC) anlegen
	      Statement stmt = con.createStatement();

	      // Statement ausfüllen und als Query an die DB schicken
	      ResultSet rs = stmt
	          .executeQuery("SELECT id, text, erstellungsdatum, hashtagID, unterhaltungsID. NutzerID "
	              + "WHERE id=" + id + " ORDER BY erstellungsdatum");

	      /*
	       * Da id Primärschlüssel ist, kann max. nur ein Tupel zurückgegeben
	       * werden. Prüfe, ob ein Ergebnis vorliegt.
	       */
	      if (rs.next()) {
	        // Ergebnis-Tupel in Objekt umwandeln
	        Nachricht n = new Nachricht();
	        n.setID(rs.getInt("id"));
	        n.setText(rs.getText("text"));
	        n.setErstellungsdatum(rs.getDate("erstellungsdatum"));
	        n.setHashtagID(rs.getInt("hashtagID"));
	        n.setUnterhaltungsID(rs.getInt("unterhaltungsID"));
	        n.setNutzerID(rs.getInt("NutzerID"));
	        return n;
	      }
	    }
	    catch (SQLException e2) {
	      e2.printStackTrace();
	      return null;
	    }

	    return null;
		
	}
	
	/** Suche ein Nachricht Objekt nach seinem Nutzer
	 * 
	 * @return
	 */
	public Vector<Nachricht> findByNutzer (Nutzer nutzer) {

		public Nachricht findeDurchID(int id) {
			//DB-Verbindung holen
			Connection con = DBConnection.connection();
			
			try {
				//Leeeres SQL-Statement (JDBC) anlegen
				Statement stmt = con.createStatement();
				
				//Statement ausf¸llen und als Query an die B schicken
				ResultSet rs = stmt.executeQuery("SELECT ID, text, erstellungsdatum, nutzerID FROM nachricht "
						+ "WHERE ID=" + id + " ORDER BY Datum");
				
				/*
				 * Da ID PRim‰rschl¸sse ist, kann max. nur ein Tupel zur¸ckgegeben werden. pr¸f, ob ein ergebnis vorliegt.
				 */
				if (rs.next()) {
					//Ergebnis-Tupel in Objekt umwandeln
					Nachricht n = new Nachricht();
					n.setID(rs.getInt("ID"));
					n.setText(rs.getString ("Text"));
					n.setErstellungsdatum(rs.getDate("erstellungsdatum"));
					n.setNutzerID(rs.getInt("NutzerID"));
					return n;
				}
			}
			catch (SQLException e2) {
				e2.printStackTrace();
				return null;
				
			}
			return null;

	
	/** Einf�gen eines Nachricht Objekts in die Datenbank
	 * 
	 * @param Nachricht
	 * @return
	 */
	public Nachricht einfuegen (Nachricht n) {
	Connection con = DBConnection.connection();
		
		try {
			Statement stmt = con.createStatement();
			
			/*
			 * Zun‰chst schauen wir nach, welches der mmentan hˆchste 
			 * Prim‰rsch¸sselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT MAX(id AS maxid"
					+ "FROM nachricht ");
			
			// Wenn wir etwas zur¸ckerhalten, kann dies nur einzeilig sein
			if (rs.next()) {
				/*
				 * t erh‰lt den bisher maximalen, un um 1 inkremetierten
				 * Prim‰rschl¸ssel.
				 */
				n.setID(rs.getInt("maxid")+1);
				
			stmt = con.createStatement();
			
			//Jetzt erst erfolgt die tats‰chliche Einf¸geoperation
			stmt.executeUpdate("INSERT INTO nachricht (ID, Text, Erstellungsdatum, NutzerID" + "VALUES ("
			+ n.getID() + "," + n.getText() + "," + n.getErstellungsdatum() + "," + n.getNutzerID()+"')");
				
				}
			}
			catch (SQLException e2) {
				e2.printStackTrace();
			}
		
		
	}
		return null;
	}
	
	/** Bearbeiten eines Nachricht Objekts in der Datenbank
	 * 
	 * @param Nachricht
	 * @return
	 */
	public Nachricht bearbeiten (Nachricht nachricht) {
		return null;
	}
	
	/** L�schen eines Nachrichten Objekts aus der Datenbank
	 * 
	 * @param nachricht auf der DB zu löschende "objekt"
	 */
	public void loeschen (Nachricht nachricht) {
			Connection con =DBConnection.connection();
			
			try {
				Statement stmt = con.createStatement();
				
				stmt.executeUpdate("DELETE FROM nachricht " + "WHERE id=" + nachricht.getID());
				
			}
			catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		
	}
	
	/** Auslesen aller Nachrichten
	 * 
	 * @return
	 */
	public Vector<Nachricht> getNachricht () {
		return null;
		
	}
	
	//Wichtig!! getNachrichtByNutzer Methode
	public Vector<Nachricht> getNachrichtByNutzer(Nutzer n){
		return null;
		
	}
	
}
