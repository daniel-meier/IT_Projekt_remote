package de.hdm.itprojekt.messenger.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import de.hdm.itprojekt.messenger.server.db.DBConnection;
import de.hdm.itprojekt.messenger.shared.bo.Nutzer;

public class NutzerMapper extends DBConnection{
	
	private static NutzerMapper nutzerMapper = null;
	
	public NutzerMapper () {
		
	}
	
	public static NutzerMapper getNutzerMapper() {
		return nutzerMapper;
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
	        stmt.executeUpdate("INSERT INTO nutzer (id, vorname, nachname, email, erstellungszeitpunkt, googleid) "
	            + "VALUES (" + n.getID() + ",'" + n.getVorname() + "','"
	            + n.getNachname() + "''" + n.getEmail() + "','" + n.getErstellungszeitpunkt() +"')");
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
		return n;
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

	      stmt.executeUpdate("DELETE FROM nutzer " + "WHERE id=" + Nutzer.getID());
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
	public Vector<Nutzer> getAllNutzer() {
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
	/**
	 * Suchen eines Nutzers mit vorgegebenem Namen. Da dieser nicht eindeutig ist,
	 * werden mehrere Objekte zurueckgegeben.
	 * 
	 *  @param ID Prim‰rschl¸sselattribut (->DB)
	 *  @return Nutzer-Objekt, das dem ¸bergebenen Schl¸ssel entspricht, null bei 
	 *  nicht vohandenem DB-Tupel.
	 */



	 public Nutzer findNutzerByName(String name) {
		 	//DB-Verbindung holen
			Connection con = DBConnection.connection();
				
			try {
				//Leeeres SQL-Statement (JDBC) anlegen
				Statement stmt = con.createStatement();
					
				//Statement ausfuellen und als Query an die DB schicken
				ResultSet rs = stmt.executeQuery("SELECT * FROM nutzer "
						+ "WHERE Vorname, Nachname='" + name + "'");
					
				// Da ID Primaerschluesse ist, kann max. nur ein Tupel zurueckgegeben werden. 
				// pruef, ob ein ergebnis vorliegt.
					 
				if (rs.next()) {
					//Ergebnis-Tupel in Objekt umwandeln
					Nutzer n = new Nutzer();
					n.setID(rs.getInt("ID"));
					n.setVorname(rs.getString ("Vorname"));
					n.setNachname(rs.getString ("Nachname"));
					n.setEmail(rs.getString ("Email"));
					n.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));
						
					return n;
				}
			}
				catch (SQLException e2) {
					e2.printStackTrace();					
				}
			return null;
	} 
	
	 /**
	public Nutzer findNutzerByName(String searchWord, int maxResults,
				boolean onlyModules, boolean onlyProducts)
				throws IllegalArgumentException, SQLException {
		
	}
			// DB-Verbindung holen
	
			Connection con = DBConnection.connection();
			Nutzer result = new Nutzer();
			String whereQuery = "";
			
			if (!searchWord.isEmpty()) {
				String[] words = searchWord.split(" ");
				for (String word : words) {
					if (word.length() > 3) {
						Vector<String> fuzzySearchWords = getLevenshtein1(word);
						for (String fuzzyWord : fuzzySearchWords) {
							whereQuery += "name LIKE '%" + fuzzyWord + "%' OR ";
							
						}
					} else {
						
						// Fuzzy Suche nur bei Wörtern die mehr als 3 Buchstaben
						// haben
						whereQuery += "name LIKE '%" + word + "%' OR ";
						
					}
				}
				if (whereQuery.length() > 5) {
					// Letztes OR aus Query entfernen
					whereQuery = whereQuery.substring(0, whereQuery.length() - 4);
				}
				try {
					// Leeres SQL-Statement (JDBC) anlegen
					Statement stmt = con.createStatement();
					// Statement ausfuellen
					String sqlQuery = "SELECT * FROM nutzer WHERE " + whereQuery
							+ " ORDER BY name LIMIT " + maxResults;
					 // Query an die DB schicken
					ResultSet rs = stmt.executeQuery(sqlQuery);

					// Für jeden Eintrag im Suchergebnis wird nun ein Nutzer-Objekt
					// erstellt.
					
					while (rs.next()) {
						int nutzerId = rs.getInt("nutzerid");
						Nutzer elementFromCache = cachePartlist.getElementById(elementId);
						if (elementFromCache != null) {
							result.add(elementFromCache, 1);
							continue;
						}

						Nutzer p = NutzerMapper.getNutzerMapper().findByElement(
								elementId);

						if (p != null) {
							result.add(p, 1);
						} else if (!onlyProducts) {



							// Wenn es sich um ein Modul handelt, dieses hinzufügen
							// ansonsten, das Element als
							// Bauteil hinzufügen.
							if (m != null) {
								result.add(m, 1);
							} else {
								if (!onlyModules && !onlyProducts) {

									Element e = new Element();
									e.setId(elementId);

									e.setName(rs.getString("name"));
									e.setDescription(rs.getString("description"));
									e.setMaterialDescription(rs
											.getString("material_description"));

									Timestamp timestamp = rs
											.getTimestamp("creation_date");
									if (timestamp != null) {
										Date creationDate = new java.util.Date(
												timestamp.getTime());
										e.setCreationDate(creationDate);
									}

									Timestamp timestamp2 = rs
											.getTimestamp("last_update");
									if (timestamp2 != null) {
										Date lastUpdateDate = new java.util.Date(
												timestamp2.getTime());
										e.setLastUpdate(lastUpdateDate);
									}

									e.setLastUser(UserMapper.getUserMapper()
											.getLastUpdateUserNameByElementId(
													e.getId()));

									// Hinzufuegen des neuen Objekts zum
									// Ergebnisvektor
									result.add(e, 1);
								}
							}
						}
					}

					rs.close();
					stmt.close();
				} catch (SQLException ex) {
					throw new IllegalArgumentException(ex.getMessage());
				}
			}

			return result;
		} */
	}

