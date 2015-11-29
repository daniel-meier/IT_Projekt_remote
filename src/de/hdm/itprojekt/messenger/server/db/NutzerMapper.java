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
	          .executeQuery("SELECT id, vorname, nachname FROM nutzer "
	              + "WHERE id=" + id + " ORDER BY nachname");

	      /*
	       * Da id Primärschlüssel ist, kann max. nur ein Tupel zurückgegeben
	       * werden. Prüfe, ob ein Ergebnis vorliegt.
	       */
	      if (rs.next()) {
	        // Ergebnis-Tupel in Objekt umwandeln
	        Nutzer c = new Nutzer();
	        c.setId(rs.getInt("id"));
	        c.setVorname(rs.getString("vorname"));
	        c.setNachname(rs.getString("nachname"));

	        return c;
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	      return null;
	    }

	    return null;
	  }

	/**
	   * Auslesen aller Kunden-Objekte mit gegebenem Nachnamen
	   * 
	   * @param name Nachname der Kunden, die ausgegeben werden sollen
	   * @return Ein Vektor mit Customer-Objekten, die sämtliche Kunden mit dem
	   *         gesuchten Nachnamen repräsentieren. Bei evtl. Exceptions wird ein
	   *         partiell gefüllter oder ggf. auch leerer Vetor zurückgeliefert.
	   */
	  public Vector<Nutzer> findByNachnme(String name) {
	    Connection con = DBConnection.connection();
	    Vector<Nutzer> result = new Vector<Nutzer>();

	    try {
	      Statement stmt = con.createStatement();

	      ResultSet rs = stmt.executeQuery("SELECT id, vorname, nachname "
	          + "FROM nutzer " + "WHERE nachname LIKE '" + name
	          + "' ORDER BY nachname");

	      // Für jeden Eintrag im Suchergebnis wird nun ein Customer-Objekt
	      // erstellt.
	      while (rs.next()) {
	        Nutzer c = new Nutzer();
	        c.setId(rs.getInt("id"));
	        c.setVorname(rs.getString("vorname"));
	        c.setNachname(rs.getString("nachname"));

	        // Hinzufügen des neuen Objekts zum Ergebnisvektor
	        result.addElement(c);
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    // Ergebnisvektor zurückgeben
	    return result;
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
