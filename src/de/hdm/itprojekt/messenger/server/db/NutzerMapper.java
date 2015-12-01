package de.hdm.itprojekt.messenger.server.db;

import de.hdm.itprojekt.messenger.shared.bo.Nutzer;

public class NutzerMapper extends DBConnection{
	
	public NutzerMapper () {
		
	}
	
	public static NutzerMapper getNutzerMapper() {
		return null;
	}
	
	/** Suche eines Nutzers nach seiner eindeutigen Nummer
	 * 
	 * @param id
	 * @return
	 */
	public Nutzer findNutzerByID (int id) {
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
	        Nutzer n = new Nutzer();
	        n.setID(rs.getInt("id"));
	        n.setVorname(rs.getString("vorname"));
	        n.setNachname(rs.getString("nachname"));

	        return n;
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
	   * @return Ein Vektor mit Nutzer-Objekten, die sämtliche Nutzer mit dem
	   *         gesuchten Nachnamen repräsentieren. Bei evtl. Exceptions wird ein
	   *         partiell gefüllter oder ggf. auch leerer Vetor zurückgeliefert.
	   */
	  public Vector<Nutzer> findByNachname(String name) {
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
	        Nutzer n = new Nutzer();
	        n.setID(rs.getInt("id"));
	        n.setVorname(rs.getString("vorname"));
	        n.setNachname(rs.getString("nachname"));

	        // Hinzufügen des neuen Objekts zum Ergebnisvektor
	        result.addElement(n);
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    // Ergebnisvektor zurückgeben
	    return result;
	  }
	
	
	/**
	   * Einfügen eines <code>Nutzer</code>-Objekts in die Datenbank. Dabei wird
	   * auch der Primärschlüssel des übergebenen Objekts geprüft und ggf.
	   * berichtigt.
	   * 
	   * @param c das zu speichernde Objekt
	   * @return das bereits übergebene Objekt, jedoch mit ggf. korrigierter
	   *         <code>id</code>.
	   */
	  public Nutzer nutzerAnlegen(Nutzer n) {
	    Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      /*
	       * Zunächst schauen wir nach, welches der momentan höchste
	       * Primärschlüsselwert ist.
	       */
	      ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid "
	          + "FROM nutzer ");

	      // Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
	      if (rs.next()) {
	        /*
	         * c erhält den bisher maximalen, nun um 1 inkrementierten
	         * Primärschlüssel.
	         */
	        n.setID(rs.getInt("maxid") + 1);

	        stmt = con.createStatement();

	        // Jetzt erst erfolgt die tatsächliche Einfügeoperation
	        stmt.executeUpdate("INSERT INTO nutzer (id, vorname, nachname, email, erstellungszeitpunkt) "
	            + "VALUES (" + n.getID() + ",'" + n.getVorname() + "','"
	            + n.getNachname() + "''" + n.getEmail() + "','" + n.getErstellungszeitpunkt() + "')");
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	
	
	/** Bearbeiten eines Nutzer Objekts in der Datenbank
	 * 
	 @param n das Objekt, das in die DB geschrieben werden soll
   * @return das als Parameter übergebene Objekt
   */

	public Nutzer bearbeiteNutzer(Nutzer n) {
	    Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("UPDATE nutzer " + "SET vorname=\""
	          + n.getVorname() + "\", " + "nachname=\"" + n.getNachname() + "\" "
	          + "WHERE id=" + n.getID());

	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    // Um Analogie zu insert(Customer c) zu wahren, geben wir c zurück
	    return n;
	  }
	
	
	/**
	   * Löschen der Daten eines <code>Nutzer</code>-Objekts aus der Datenbank.
	   * 
	   * @param n das aus der DB zu löschende "Objekt"
	   */
	  public void loescheNutzer(Nutzer nutzer) {
	    Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM nutzer " + "WHERE id=" + n.getID());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	/** Auslesen aller Nutzer
	 * 
	 * @return Ein Vektor mit Customer-Objekten, die sämtliche Kunden
   *         repräsentieren. Bei evtl. Exceptions wird ein partiell gef�llter
   *         oder ggf. auch leerer Vetor zurückgeliefert.
	 */
	public ArrayList<Nutzer> getAllNutzer() {
		  Connection con = DBConnection.connection();
		    // Ergebnisvektor vorbereiten
		    Vector<Nutzer> result = new Vector<Nutzer>();

		    try {
		      Statement stmt = con.createStatement();

		      ResultSet rs = stmt.executeQuery("SELECT id, vorname, nachname "
		          + "FROM nutzer " + "ORDER BY nachname");

		      // Für jeden Eintrag im Suchergebnis wird nun ein Customer-Objekt
		      // erstellt.
		      while (rs.next()) {
		        Nutzer n = new Nutzer();
		        n.setID(rs.getInt("id"));
		        n.setVorname(rs.getString("vorname"));
		        n.setNachname(rs.getString("nachname"));

		        // Hinzufügen des neuen Objekts zum Ergebnisvektor
		        result.addElement(n);
		      }
		    }
		    catch (SQLException e) {
		      e.printStackTrace();
		    }

		    // Ergebnisvektor zurückgeben
		    return result;
	}
		
	}


	public Nutzer findNutzerByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


}
