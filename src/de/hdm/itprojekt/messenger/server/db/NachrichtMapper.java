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
	          .executeQuery("SELECT id, text, erstellungszeitpunkt, hashtagID, senderId,  "
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
	        n.setSenderID(rs.getInt("senderID"));
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
	 * Suche ein Nachricht Objekt nach seinem Sender
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
				ResultSet rs = stmt.executeQuery("SELECT id, text, erstellungszeitpunkt, senderID FROM nachricht "
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
					n.setSenderID(rs.getInt("senderID"));
				      
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
			stmt.executeUpdate("INSERT INTO nachricht (ID, text, erstellungszeitpunkt, senderId, empfagerId" + "VALUES ("
			+ n.getID() + "," + n.getText() + "," + n.getErstellungszeitpunkt() + "," + n.getSenderID()+"," + n.getEmpfaegerID() +"')");
				
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
			Connection con = DBConnection.connection();
			
			try {
				Statement stmt = con.createStatement();
				
				stmt.executeUpdate("DELETE FROM nachricht " + "WHERE id=" + n.getID());
				
			}
			catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		
	
	/** 
	 * Auslesen aller Nachrichten
	 * @return
	 */
	public Vector<Nachricht> getNachricht () {
		return null;
		
	}
	
	/**
	 * Auslesen aller Nachrichten nach Nutzer
	 * @param n
	 * @return nachrichtListe
	 */
	public Vector<Nachricht> getNachrichtByNutzer(Nutzer n){
		Connection con = DBConnection.connection();
		Vector<Nachricht> nachrichtListe = new Vector<Nachricht>();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Nachricht WHERE NutzerID =" 
					+ n.getID() + "ORDER BY Erstellungszeitpunkt DESC");
			while (rs.next()) {
				Nachricht na = new Nachricht();
				na.setID(rs.getInt("id"));
				na.setText(rs.getString ("text"));
				na.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));
				na.setNutzerID(rs.getInt("nutzerID"));
				
				nachrichtListe.addElement(na);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
			
		return nachrichtListe;
		
	}
	/**
	 * einen oder mehrere Teilnehmer in Nachricht einf�gen
	 * @param teilnehmer
	 * @return
	 */
	public Nachricht getTeilnehmer(Vector<Nutzer> teilnehmer) {
		//TODO
		Connection con = DBConnection.connection();
		Vector<Nutzer> result = new Vector<Nutzer>();
		
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("");
			while (rs.next()){
				Nutzer t = new Nutzer();
				t.setID(rs.getInt("id"));
				t.setVorname(rs.getString("vorname"));
				t.setNachname(rs.getString("nachname"));
				t.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));
				
				result.add(t);
			}
		}
			catch (SQLException e){
				e.printStackTrace();
			}
		
		return null;
		
	}
	
	
	public Nachricht hashtagEinerNachrichtZuordnen(int HashtagID, int NachrichtID) {
	
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT HashtagID , NachrichtID FROM nachricht");
			if (rs.next()) {
			stmt = con.createStatement();
			
			//Jetzt erst erfolgt die tats‰chliche Einf¸geoperation
			stmt.executeUpdate("INSERT INTO NachrichtHashtag (`NachrichtId`, `HashtagId`) VALUES ('" + NachrichtID + "', '" + HashtagID + "')");
			}	
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	return null;
	}
	
	
	
	
	
	public Nachricht nachrichtEinerUnterhaltungZuordnen(int NachrichtID, int UnterhaltungsID) {
		
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate( "INSERT INTO Unterhaltungsnachricht (`nachrichtid`, `unterhaltungsid`) VALUES ('" + NachrichtID + "', '" + UnterhaltungsID
					+ "')");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
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
	public Vector<Nachricht> getNachrichtByZeitraum(String von, String bis) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.connection();
		Vector<Nachricht> result = new Vector<Nachricht>();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM nachricht WHERE erstellungszeitpunkt BETWEEN'"
					+ von + "' AND '" + bis + "'" + "ORDER BY Datum");
			
			if (rs.next()) {
				Nachricht n = new Nachricht();
				n.setID(rs.getInt("id"));
				n.setText(rs.getString("text"));
				n.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));
				n.setNutzerID(rs.getInt("nutzerID"));
				
				result.addElement(n);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Senden einer Nachricht
	 * @param text
	 * @return
	 */
	public Nachricht senden(Nachricht n) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.connection();
		
		try {
			Statement stmt = con.createStatement();
			stmt.executeQuery("SELECT * FROM nachricht" + "WHERE id=" + n.getID());
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
}
