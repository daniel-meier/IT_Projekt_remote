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

	      // Statement ausfuellen und als Query an die DB schicken
	      ResultSet rs = stmt.executeQuery("SELECT NachrichtID, Text, Erstellungszeitpunkt, HashtagID, "
	          		+ "SenderID, EmpfaengerID WHERE NachrichtID=" + id + " ORDER BY Erstellungszeitpunkt");

	      /*
	       * Da id Primaerschluessel ist, kann max. nur ein Tupel zurueckgegeben
	       * werden. Pruefe, ob ein Ergebnis vorliegt.
	       */
	      if (rs.next()) {
	        // Ergebnis-Tupel in Objekt umwandeln
	        Nachricht n = new Nachricht();
	        n.setID(rs.getInt("NachrichtID"));
	        n.setText(rs.getString("Text"));
	        n.setErstellungszeitpunkt(rs.getDate("Erstellungszeitpunkt"));
	        n.setHashtagID(rs.getInt("HashtagID"));
	        n.setSenderID(rs.getInt("SenderID"));
	        n.setEmpfaengerID(rs.getInt("EmpfaengerID"));
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
				ResultSet rs = stmt.executeQuery("SELECT NachrichtID, Text, Erstellungszeitpunkt, "
						+ "SenderID FROM nachricht WHERE NachrichtID=" + id
						+ " ORDER BY Erstellungszeitpunkt");
				
				/*
				 * Da ID Primaerschluesse ist, kann max. nur ein Tupel zurueckgegeben werden. pruef, ob ein ergebnis vorliegt.
				 */
				if (rs.next()) {
					//Ergebnis-Tupel in Objekt umwandeln
					Nachricht n = new Nachricht();
					n.setID(rs.getInt("NachrichtID"));
					n.setText(rs.getString ("Text"));
					n.setErstellungszeitpunkt(rs.getDate("Erstellungszeitpunkt"));
					n.setSenderID(rs.getInt("SenderID"));
				      
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
	 * @return n
	 */		
	public Nachricht einfuegen (Nachricht n) {
		Connection con = DBConnection.connection();
		
		try {
			Statement stmt = con.createStatement();
			
			/*
			 * Zunaechst schauen wir nach, welches der momentan hoechste 
			 * Primaerschuesselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT MAX(NachrichtID) AS maxid"
					+ "FROM Nachricht ");
			
			// Wenn wir etwas zurueckerhalten, kann dies nur einzeilig sein
			if (rs.next()) {
				/*
				 * n erhaelt den bisher maximalen, un um 1 inkremetierten
				 * Primaerschluessel.
				 */
				n.setID(rs.getInt("maxid")+1);
				
			stmt = con.createStatement();
			
			//Jetzt erst erfolgt die tatsaechliche Einfuegeoperation
			stmt.executeUpdate("INSERT INTO Nachricht (NachrichtID, Text, Erstellungszeitpunkt, "
					+ "HashtagID, SenderID, EmpfaengerID" + "VALUES ("
					+ n.getID() + "," + n.getText() + "," + n.getErstellungszeitpunkt() + "," 
					+ n.getSenderID()+"," + n.getEmpfaegerID() +"," + n.getHashtagID()+ ")");
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
	 * @return n
	 */
	public Nachricht bearbeiten (Nachricht n) {
		
		Connection con = DBConnection.connection();
		
		try {
			Statement stmt = con.createStatement();
			
			stmt.executeUpdate("UPDATE Nachricht " + "SET Text= '" + n.getText() + "' " 
					+ "WHERE NachrichtID=" + n.getID());				
		}
		catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		// um Analoge zu insert(Textbeitrag n) zu wahren, geben wir n zurueck
		return n;
	}
	
	/** 
	 * Loeschen eines Nachrichten Objekts aus der Datenbank
	 * @param nachricht auf der DB zu loeschende "objekt"
	 */
	public void loeschen (Nachricht n) {
			Connection con = DBConnection.connection();
			
			try {
				Statement stmt = con.createStatement();
				
				stmt.executeUpdate("DELETE FROM Nachricht " + "WHERE Nachricht=" + n.getID());
				
			}
			catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		
	
	/** 
	 * Auslesen aller Nachrichten
	 * @return
	 */
	public Vector<Nachricht> getNachrichten () {
		return null;
		
	}
	
	/**
	 * Auslesen aller Nachrichten nach Nutzer
	 * (Diese Methode gibt alle Beitr�ge eines Nutzers anhand der ID in einer Liste aus)
	 * @param n
	 * @return nachrichtListe
	 */
	public Vector<Nachricht> getNachrichtByNutzer(Nutzer n){
		Connection con = DBConnection.connection();
		Vector<Nachricht> nachrichtListe = new Vector<Nachricht>();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Nachricht WHERE SenderID =" 
					+ n.getID() + "ORDER BY Erstellungszeitpunkt DESC");
			while (rs.next()) {
				Nachricht na = new Nachricht();
				na.setID(rs.getInt("NachrichtID"));
				na.setText(rs.getString ("Text"));
				na.setErstellungszeitpunkt(rs.getDate("Erstellungszeitpunkt"));
				na.setNutzerID(rs.getInt("SenderID"));
				
				nachrichtListe.addElement(na);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
			
		return nachrichtListe;
		
	}
	/**
	 * einen oder mehrere Teilnehmer in Nachricht einfuegen
	 * @param teilnehmer
	 * @return result
	 */
	public Vector<Nutzer> getTeilnehmer(Nachricht nachricht) {
		//TODO Sinnvoll? Oder Nachricht getSender?
		Connection con = DBConnection.connection();
		Vector<Nutzer> result = new Vector<Nutzer>();
		
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Nachricht.NachrichtID, Nutzer.NutzerID, "
					+ "Nutzer.Vorname, Nutzer.Nachname, Nutzer.Erstellungszeitpunkt "
					+ "FROM Nachricht INNERJOIN Nutzer ON Nachricht.SenderID=Nutzer.NutzerID");
			while (rs.next()){
				Nutzer t = new Nutzer();
				t.setID(rs.getInt("Nutzer.NutzerID"));
				t.setVorname(rs.getString("Nutzer.Vorname"));
				t.setNachname(rs.getString("Nutzer.Nachname"));
				t.setErstellungszeitpunkt(rs.getDate("Nutzer.Erstellungszeitpunkt"));
				
				result.add(t);
			}
		}
			catch (SQLException e){
				e.printStackTrace();
			}
		
		return result;
		
	}
	
	/**
	 * Methode um einen Hashtag einer Nachricht zuzuordnen 
	 * @param HashtagID
	 * @param NachrichtID
	 * @return
	 */
	public Nachricht hashtagEinerNachrichtZuordnen(int HashtagID, int NachrichtID) {
	
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT HashtagID , NachrichtID FROM Nachricht");
			if (rs.next()) {
			stmt = con.createStatement();
			
			//Jetzt erst erfolgt die tats‰chliche Einf¸geoperation
			stmt.executeUpdate("INSERT INTO Nachricht (`NachrichtID`, `HashtagID`) VALUES ('" 
					+ NachrichtID + "', '" + HashtagID + "')");
			}	
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	return null;
	}
	
	
	
	
	/**
	 * Methode um eine Nachricht einer Unterhaltung zuzuordnen
	 * @param NachrichtID
	 * @param UnterhaltungsID
	 * @return
	 */
	public Nachricht nachrichtEinerUnterhaltungZuordnen(int NachrichtID, int UnterhaltungsID) {
		
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate( "INSERT INTO Unterhaltungsnachricht (`NachrichtID`, `UnterhaltungsID`) "
					+ "VALUES ('" + NachrichtID + "', '" + UnterhaltungsID + "')");
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
	public Vector<Nachricht> findByNutzerZeitraum(Nutzer nutzer, String von, String bis) {
		// TODO Auto-generated method stub
		//DB-Verbindung holen
		Connection con = DBConnection.connection();
	    Vector<Nachricht> result = new Vector<Nachricht>();
		try {
			//Leeeres SQL-Statement (JDBC) anlegen
			Statement stmt = con.createStatement();
			
			//Statement ausfuellen und als Query an die DB schicken
			ResultSet rs = stmt.executeQuery ("SELECT * FROM Nachricht WHERE Erstellungszeitpunkt "
					+ "BETWEEN '" + von + "' AND '" + bis + "'" 
					+ "AND SenderID =" + nutzer.getID() + " ORDER BY Erstellungszeitpunkt");
			
			/*
			 * Da ID Primaerschluesse ist, kann max. nur ein Tupel zurueckgegeben werden. pruef, ob ein ergebnis vorliegt.
			 */
			if (rs.next()) {
				//Ergebnis-Tupel in Objekt umwandeln
				Nachricht n = new Nachricht();
				n.setID(rs.getInt("NachrichtID"));
				n.setText(rs.getString ("Text"));
				n.setErstellungszeitpunkt(rs.getDate("Erstellungszeitpunkt"));
				n.setNutzerID(rs.getInt("SenderID"));
			      
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
			ResultSet rs = stmt.executeQuery("SELECT * FROM Nachricht WHERE Erstellungszeitpunkt BETWEEN'"
					+ von + "' AND '" + bis + "'" + "ORDER BY Erstellungszeitpunkt");
			
			if (rs.next()) {
				Nachricht n = new Nachricht();
				n.setID(rs.getInt("NachrichtID"));
				n.setText(rs.getString("Text"));
				n.setErstellungszeitpunkt(rs.getDate("Erstellungszeitpunkt"));
				n.setNutzerID(rs.getInt("SenderID"));
				
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
	 * (diese Methode speichert eine neue Nachricht in der Datenbank)
	 * @param text
	 * @return
	 */
	public void senden(Nachricht n) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.connection();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT MAX(NachrichtID) AS maxid FROM Nachricht");
			if (rs.next()) {
				n.setID(rs.getInt("maxid") + 1);
				stmt = con.createStatement();
				stmt.executeUpdate("INSERT INTO Nachricht (NachrichtID, NutzerID, HashtagID, Text, UnterhaltungsID, Erstellungszeitpunkt"
						+ "VALES (" + n.getID() + ",'" + n.getNutzerID() + "','" + n.getHashtagID() + "','" + n.getText() + "','" + n.getUnterhaltungsID()
						+ "','" + n.getErstellungszeitpunkt());
			}
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
