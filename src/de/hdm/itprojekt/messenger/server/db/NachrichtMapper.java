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
	          .executeQuery("SELECT id, text, erstellungszeitpunkt, hashtagID, unterhaltungsID. NutzerID "
	              + "WHERE id=" + id + " ORDER BY erstellungszeitpunkt");

	      /*
	       * Da id Primärschlüssel ist, kann max. nur ein Tupel zurückgegeben
	       * werden. Prüfe, ob ein Ergebnis vorliegt.
	       */
	      if (rs.next()) {
	        // Ergebnis-Tupel in Objekt umwandeln
	        Nachricht n = new Nachricht();
	        n.setID(rs.getInt("id"));
	        n.setText(rs.getText("text"));
	        n.setErstellungszeitpunkt(rs.getDatetime("erstellungszeitpunkt"));
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
		return null;
	}
	
	/** Einf�gen eines Nachricht Objekts in die Datenbank
	 * 
	 * @param Nachricht
	 * @return
	 */
	public Nachricht einfuegen (Nachricht nachricht) {
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
