package de.hdm.itprojekt.messenger.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import de.hdm.itprojekt.messenger.shared.bo.Nachricht;
import de.hdm.itprojekt.messenger.shared.bo.Nutzer;
import de.hdm.itprojekt.messenger.shared.report.NachrichtByNutzerZeitraumReport;



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
	          .executeQuery("SELECT id, text, erstellungszeitpunkt, hashtagID, unterhaltungsID. nutzerID "
	              + "WHERE id=" + id + " ORDER BY erstellungszeitpunkt");

	      /*
	       * Da id Primärschlüssel ist, kann max. nur ein Tupel zurückgegeben
	       * werden. Prüfe, ob ein Ergebnis vorliegt.
	       */
	      if (rs.next()) {
	        // Ergebnis-Tupel in Objekt umwandeln
	        Nachricht n = new Nachricht();
	        n.setID(rs.getInt("id"));
	        n.setText(rs.getString("text"));
	        n.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));
	        n.setHashtagID(rs.getInt("hashtagID"));
	        n.setUnterhaltungsID(rs.getInt("unterhaltungsID"));
	        n.setNutzerID(rs.getInt("nutzerID"));
	        return n;
	      }
	    }
	    catch (SQLException e2) {
	      e2.printStackTrace();
	      return null;
	    }
	
    return null;
  }
	
	/** 
	 * Suche ein Nachricht Objekt nach seinem Nutzer
	 * @return
	 */
	public Vector<Nachricht> findByNutzer (int id) {

	//	public Nachricht findeDurchID(int id) {
			//DB-Verbindung holen
			Connection con = DBConnection.connection();
		    Vector<Nachricht> result = new Vector<Nachricht>();
			try {
				//Leeeres SQL-Statement (JDBC) anlegen
				Statement stmt = con.createStatement();
				
				//Statement ausfuellen und als Query an die DB schicken
				ResultSet rs = stmt.executeQuery("SELECT id, text, erstellungszeitpunkt, nutzerID FROM nachricht "
						+ "WHERE ID=" + id + " ORDER BY Datum");
				
				/*
				 * Da ID Primaerschluesse ist, kann max. nur ein Tupel zurueckgegeben werden. pruef, ob ein ergebnis vorliegt.
				 */
				if (rs.next()) {
					//Ergebnis-Tupel in Objekt umwandeln
					Nachricht n = new Nachricht();
					n.setID(rs.getInt("id"));
					n.setText(rs.getString ("text"));
					n.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));
					n.setNutzerID(rs.getInt("nutzerID"));
				      
					// Hinzufuegen des neuen Objekts zum Ergebnisvektor
			        result.addElement(n);
			      }
			    }
			    catch (SQLException e) {
			      e.printStackTrace();
			    }

			    // Ergebnisvektor zurueckgeben
			    return result;
			  }
	
	/** 
	 * Einfuegen eines Nachricht Objekts in die Datenbank
	 * Mittels dieser Methode wird die Nachricht erstellt.
	 * @param Nachrichten
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
			stmt.executeUpdate("INSERT INTO nachricht (ID, text, erstellungszeitpunkt, nutzerID" + "VALUES ("
			+ n.getID() + "," + n.getText() + "," + n.getErstellungszeitpunkt() + "," + n.getNutzerID()+"')");
				
				}
			}
			catch (SQLException e2) {
				e2.printStackTrace();
			}
		return n;
		
		
	}

	/** 
	 * Bearbeiten eines Nachricht Objekts in der Datenbank
	 * @param Nachricht
	 * @return
	 */
	public Nachricht bearbeiten (Nachricht n) {
		
		Connection con = DBConnection.connection();
		
		try {
			Statement stmt = con.createStatement();
			
			stmt.executeUpdate("UPDATE nachricht " + "SET text= '" + n.getText() + "' " + "WHERE id=" + n.getID());
								
		}
		catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		// um Analoge zu insert(Textbeitrag n) zu wahren, geben wir n zur¸ck
		return n;
	}
	
	/** Loeschen eines Nachrichten Objekts aus der Datenbank
	 * 
	 * @param nachricht auf der DB zu loeschende "objekt"
	 */
	public void loeschen (Nachricht n) {
			Connection con =DBConnection.connection();
			
			try {
				Statement stmt = con.createStatement();
				
				stmt.executeUpdate("DELETE FROM nachricht " + "WHERE id=" + n.getID());
				
			}
			catch (SQLException e2) {
				e2.printStackTrace();
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
	/**
	 * einen oder mehrere Teilnehmer in Nachricht einf�gen
	 * @param teilnehmer
	 * @return
	 */
	public Nachricht getTeilnehmer(Vector<Nutzer> teilnehmer) {
		return null;
		
	}

	/**
	 * Suche eine Nachricht Objekt nach Nutzer und Zeitraum
	 * @param nutzer 
	 * @param von 
	 * @param bis 
	 * @return
	 */
	public Vector<Nachricht> findByNutzerZeitraum(String nutzer, String von, String bis) {
		// TODO Auto-generated method stub
		//DB-Verbindung holen
		Connection con = DBConnection.connection();
	    Vector<Nachricht> result = new Vector<Nachricht>();
		try {
			//Leeeres SQL-Statement (JDBC) anlegen
			Statement stmt = con.createStatement();
			
			//Statement ausfuellen und als Query an die DB schicken
			ResultSet rs = stmt.executeQuery ("SELECT * FROM nachricht WHERE erstellungszeitpunkt BETWEEN '" + von + "' AND '" + bis + "'" +
					"AND nutzer =" + nutzer + " ORDER BY Datum");
			
			/*
			 * Da ID Primaerschluesse ist, kann max. nur ein Tupel zurueckgegeben werden. pruef, ob ein ergebnis vorliegt.
			 */
			if (rs.next()) {
				//Ergebnis-Tupel in Objekt umwandeln
				Nachricht n = new Nachricht();
				n.setID(rs.getInt("id"));
				n.setText(rs.getString ("text"));
				n.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));
				n.setNutzerID(rs.getInt("nutzerID"));
			      
				// Hinzufuegen des neuen Objekts zum Ergebnisvektor
		        result.addElement(n);
		      }
		    }
		    catch (SQLException e) {
		      e.printStackTrace();
		    }

		    // Ergebnisvektor zurueckgeben
		    return result;
		    
		    
	}

	/**
	 * Auslesen aller Nachrichten nach Angabe eines Zeitraumes
	 * @return
	 */
	public Vector<Nachricht> getNachrichtByZeitraum() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
