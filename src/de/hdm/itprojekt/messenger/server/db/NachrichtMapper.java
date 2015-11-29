package de.hdm.itprojekt.messenger.server.db;

import de.hdm.itprojekt.messenger.shared.bo.Nachricht;



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
	public Vector<Nachricht> findByNutzer (nutzer Nutzer) {
		
	}
	
	/** Einf�gen eines Nachricht Objekts in die Datenbank
	 * 
	 * @param Nachricht
	 * @return
	 */
	public Nachricht einfuegen (nachricht Nachricht) {
		
	}
	
	/** Bearbeiten eines Nachricht Objekts in der Datenbank
	 * 
	 * @param Nachricht
	 * @return
	 */
	public Nachricht bearbeiten (Nachricht nachricht) {
		
	}
	
	/** L�schen eines Nachrichten Objekts aus der Datenbank
	 * 
	 * @param Nachricht
	 */
	public void loeschen (nachricht Nachricht) {
		
	}
	
	/** Auslesen aller Nachrichten
	 * 
	 * @return
	 */
	public Vector<Nachricht> getNachricht () {
		
	}
	
}
