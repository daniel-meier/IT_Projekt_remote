package de.hdm.itprojekt.messenger.server.db;

import de.hdm.itprojekt.messenger.shared.bo.Nutzer;

public class NutzerMapper extends DBConnection{
	
	public NutzerMapper () {
		
	}
	
	public NutzerMapper getNutzerMapper() {
		return null;
	}
	
	/** Suche eines Nutzers nach seiner eindeutigen Nummer
	 * 
	 * @param id
	 * @return
	 */
	public NutzerMapper findNutzerByID (int id) {
		 // DB-Verbindung holen
	    Connection con = DBConnection.connection();

	    try {
	      // Leeres SQL-Statement (JDBC) anlegen
	      Statement stmt = con.createStatement();

	      // Statement ausfüllen und als Query an die DB schicken
	      ResultSet rs = stmt
	          .executeQuery("SELECT id, Vorname, Nachname FROM nutzer "
	              + "WHERE id=" + id + " ORDER BY Nachname");

	      /*
	       * Da id Primärschlüssel ist, kann max. nur ein Tupel zurückgegeben
	       * werden. Prüfe, ob ein Ergebnis vorliegt.
	       */
	      if (rs.next()) {
	        // Ergebnis-Tupel in Objekt umwandeln
	        Nutzer c = new Nutzer();
	        c.setId(rs.getInt("id"));
	        c.setVorname(rs.getString("Vorname"));
	        c.setNachname(rs.getString("Nachname"));

	        return c;
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	      return null;
	    }

	    return null;
	  }


	
	/** Suche ein Nutzer Objekt nach seinem Nachnamen
	 * 
	 * @return
	 */
	public Vector<Nutzer> findByNachname () {
		
	}
	
	/** Einf�gen eines Nutzer Objekts in die Datenbank
	 * 
	 * @param NutzerMapper
	 * @return
	 */
	public NutzerMapper einfuegen (nutzer Nutzer) {
		
	}
	
	/** Bearbeiten eines Nutzer Objekts in der Datenbank
	 * 
	 * @param NutzerMapper
	 * @return
	 */
	public NutzerMapper bearbeiten (nutzer Nutzer) {
		
	}
	
	/** L�schen eines Nutzer Objekts aus der Datenbank
	 * 
	 * @param NutzerMapper
	 */
	public void loeschen (nutzer Nutzer) {
		
	}
	
	/** Auslesen aller Nutzer
	 * 
	 * @return
	 */
	public ArrayList<Nutzer> getAllNutzer() {
		
	}


	public Nutzer findNutzerByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


}
