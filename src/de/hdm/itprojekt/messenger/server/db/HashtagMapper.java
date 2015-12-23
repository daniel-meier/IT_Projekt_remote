package de.hdm.itprojekt.messenger.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import de.hdm.itprojekt.messenger.shared.bo.Hashtag;
import de.hdm.itprojekt.messenger.shared.bo.Nutzer;

public class HashtagMapper extends DBConnection{
	
private static HashtagMapper hashtagMapper = null;
	
	protected HashtagMapper () {
		
	}
	
	public static HashtagMapper getHashtagMapper() {
		return hashtagMapper;
	}
	
	/** Suche eines Hashtags nach seiner eindeutigen Nummer
	 * 
	 * @param id
	 * @return
	 */
	public Hashtag findbyID (int id) {
		 // DB-Verbindung holen
	    Connection con = DBConnection.connection();

	    try {
	      // Leeres SQL-Statement (JDBC) anlegen
	      Statement stmt = con.createStatement();

	      // Statement ausfüllen und als Query an die DB schicken
	      ResultSet rs = stmt
	          .executeQuery("SELECT id, erstellungszeitpunkt, hashtagtext FROM hashtag "
	              + "WHERE id=" + id + " ORDER BY id");

	      /*
	       * Da id Primärschlüssel ist, kann max. nur ein Tupel zurückgegeben
	       * werden. Prüfe, ob ein Ergebnis vorliegt.
	       */
	      if (rs.next()) {
	        // Ergebnis-Tupel in Objekt umwandeln
	        Hashtag h = new Hashtag();
	        h.setID(rs.getInt("id"));
	        h.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));
	        h.setHashtagtext(rs.getString("hashtagtext"));

	        return h;
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	      return null;
	    }

	    return null;
	  }
	
	/** Einf�gen eines Hashtag Objekts in die Datenbank
	 * 
	 * @param Hashtag
	 * @return
	 */
	public Hashtag einfuegen (Hashtag hashtag) {
		 Connection con = DBConnection.connection();

		    try {
		      Statement stmt = con.createStatement();

		      /*
		       * Zunächst schauen wir nach, welches der momentan höchste
		       * Primärschlüsselwert ist.
		       */
		      ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid "
		          + "FROM hashtag ");

		      // Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
		      if (rs.next()) {
		        /*
		         * c erhält den bisher maximalen, nun um 1 inkrementierten
		         * Primärschlüssel.
		         */
		        hashtag.setID(rs.getInt("maxid") + 1);

		        stmt = con.createStatement();

		        // Jetzt erst erfolgt die tatsächliche Einfügeoperation
		        stmt.executeUpdate("INSERT INTO hashtag (id, erstellungszeitpunkt, hashtagtext) "
		            + "VALUES (" + hashtag.getID() + ",'"+ hashtag.getErstellungszeitpunkt() + "'+ hashtag.getHashtagtext() + ");
		      }
		    }
		    catch (SQLException e) {
		      e.printStackTrace();
		    }
			return hashtag;
		  }
		
	
	/** Bearbeiten eines Hashtag Objekts in der Datenbank
	 * 
	 * @param Hashtag
	 * @return
	 */
	public Hashtag bearbeiten (Hashtag hashtag) {
		    Connection con = DBConnection.connection();

		    try {
		      Statement stmt = con.createStatement();

		      stmt.executeUpdate("UPDATE hashtag " + "SET hashtagtext=\""
		          + hashtag.getHashtagtext() + "\" "
		          + "WHERE id=" + hashtag.getID());

		    }
		    catch (SQLException e) {
		      e.printStackTrace();
		    }
		  
		    return hashtag;
		  }

	
	/** L�schen eines Hashtag Objekts aus der Datenbank
	 * 
	 * @param Hashtag
	 */
	public void loeschen (Hashtag hashtag) {
		
		 Connection con = DBConnection.connection();

		    try {
		      Statement stmt = con.createStatement();

		      stmt.executeUpdate("DELETE FROM hashtag " + "WHERE id=" + hashtag.getID());
		    }
		    catch (SQLException e) {
		      e.printStackTrace();
		    }
		  }
		
	
	/** Suchen eines Hashtag Objekts nach seinem Namen
	 * 
	 * @param name
	 * @return
	 */
	public Vector<Hashtag> findByName (String name) {
		Connection con = DBConnection.connection();
		Vector<Hashtag> result = new Vector<Hashtag>();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM hashtag"
					+ "ORDER BY name DESC");
			while (rs.next()){
				Hashtag h = new Hashtag();
				h.setID(rs.getInt("id"));
				h.setName(rs.getString("Name"));
				
				result.addElement(h);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	/** Auslesen aller Hashtags
	 * 
	 * @return
	 */
	public Vector<Hashtag> getAllHashtags () {
		
		Connection con = DBConnection.connection();
	    // Ergebnisvektor vorbereiten
	    Vector<Hashtag> result = new Vector<Hashtag>();

	    try {
	      Statement stmt = con.createStatement();

	      ResultSet rs = stmt.executeQuery("SELECT id, hashtagtext"
	          + "FROM hashtag " + "ORDER BY id");

	      // Für jeden Eintrag im Suchergebnis wird nun ein Customer-Objekt
	      // erstellt.
	      while (rs.next()) {
	        Hashtag h = new Hashtag();
	        h.setID(rs.getInt("id"));
	        h.setHashtagtext(rs.getString("hashtag"));
	    

	        // Hinzufügen des neuen Objekts zum Ergebnisvektor
	        result.addElement(h);
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    // Ergebnisvektor zurückgeben
	    return result;
}
}
