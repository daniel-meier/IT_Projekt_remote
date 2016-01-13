package de.hdm.itprojekt.messenger.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import de.hdm.itprojekt.messenger.shared.bo.Nachricht;
import de.hdm.itprojekt.messenger.shared.bo.Nutzer;
import de.hdm.itprojekt.messenger.shared.bo.Unterhaltung;


public class UnterhaltungMapper extends DBConnection{
	
	private static UnterhaltungMapper unterhaltungMapper = null;
	
	protected UnterhaltungMapper () {
		
	}
	
	public static UnterhaltungMapper getUnterhaltungMapper() {
		return unterhaltungMapper;
	}
	
	/** 
	 *  Suche einer Unterhaltung nach seiner eindeutigen Nummer
	 * @param id Primaerschluesselattribut
	 * @return
	 */
	public Unterhaltung findByID (int id) {
		
		//DB-Verbindung holen
		Connection con = DBConnection.connection();
		
		try {
			//Leeeres SQL-Statement (JDBC) anlegen
			Statement stmt = con.createStatement();
			
			//Statement ausf¸llen und als Query an die B schicken
			ResultSet rs = stmt.executeQuery("SELECT Unterhaltungs,  Erstellungszeitpunkt FROM Unterhaltung "
					+ "WHERE UnterhaltungsID=" + id + " ORDER BY Erstellungszeitpunkt");
			
			/*
			 * Da ID PRim‰rschl¸sse ist, kann max. nur ein Tupel zur¸ckgegeben werden. pr¸f, ob ein ergebnis vorliegt.
			 */
			if (rs.next()) {
				//Ergebnis-Tupel in Objekt umwandeln
				Unterhaltung u = new Unterhaltung();
				u.setID(rs.getInt("UnterhaltungsID"));
				u.setErstellungszeitpunkt(rs.getDate("Erstellungszeitpunkt"));
				return u;
			}
		}
		catch (SQLException e2) {
			e2.printStackTrace();
			return null;
			
		}
		return null;
	}

		
	/** 
	 * Einfuegen eines Unterhaltungs Objekts in die Datenbank
	 * @param UnterhaltungMapper
	 * @return
	 */
	public Unterhaltung einfuegen (Unterhaltung unterhaltung) {
	Connection con = DBConnection.connection();
		
		try {
			Statement stmt = con.createStatement();
			
			/*
			 * Zun‰chst schauen wir nach, welches der mmentan hˆchste 
			 * Prim‰rsch¸sselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT MAX(UnterhaltungsID) AS maxid"
					+ "FROM Unterhaltung ");
			
			// Wenn wir etwas zur¸ckerhalten, kann dies nur einzeilig sein
			if (rs.next()) {
				/*
				 * t erh‰lt den bisher maximalen, un um 1 inkremetierten
				 * Prim‰rschl¸ssel.
				 */
				unterhaltung.setID(rs.getInt("maxid")+1);
				
			stmt = con.createStatement();
			
			//Jetzt erst erfolgt die tats‰chliche Einf¸geoperation
			stmt.executeUpdate("INSERT INTO Unterhaltung (UnterhaltungsID, Erstellzeitpunkt" + "VALUES ("
			+ unterhaltung.getID() + "," + unterhaltung.getErstellungszeitpunkt() +"')");
				
				}
			}
			catch (SQLException e2) {
				e2.printStackTrace();
			}
			/*
			 * R¸ckgabe, des vtl. korrigierten Leistungsbringung.
			 * 
			 * HINWEIS: Da in Java nur Referenzen auf Objekte und keine physischen
			 * Objekte ¸ergeben werden, w‰re die Anpassung des Textbeitrag-Objekts auch 
			 * ohne diese esplizite R¸ckgabe auﬂerhalb dieser Methode sichtbar. Die
			 * explizite R¸ckgabe von t ist eher ein Stilmittel, um zu signalisieren, 
			 * dass sich das Objekt evtl. im Laufer der Methode ver‰ndert hat.
			 */
			return unterhaltung;
	}
		
	
	/** 
	 * Bearbeiten eines Unterhaltungs Objekts in der Datenbank
	 * @param UnterhaltungMapper
	 * @return
	 */
	public Unterhaltung bearbeiten (Unterhaltung unterhaltung) {
		Connection con = DBConnection.connection();
		
		try {
			//Leeeres SQL-Statement (JDBC) anlegen
			Statement stmt = con.createStatement();
			//TODO getText?
			stmt.executeUpdate("UPDATE Unterhaltung " + "SET Text= '" //Haben kein Text
					+ unterhaltung.getText() + "' " + "WHERE UnterhaltungsID=" + unterhaltung.getID());
								
		}
		catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		// um Analoge zu insert(Textbeitrag t) zu wahren, geben wir t zur¸ck
		return unterhaltung;
	}
		
		
	
	/** 
	 * Loeschen eines Unterhaltungs Objekts aus der Datenbank
	 * @param Unterhaltung
	 * */
	 
	public void loeschen (Unterhaltung unterhaltung){
		
	Connection con = DBConnection.connection();
		
		try {
			Statement stmt = con.createStatement();
			
			stmt.executeUpdate("DELETE FROM Unterhaltung " + "WHERE UnterhaltungsID=" + unterhaltung.getID());
			
		}
		catch (SQLException e2) {
			e2.printStackTrace();
		}
	}
	
	

	/**
	 * Loeschen eines oder mehrerer Teilnehmer aus einer Unterhaltung
	 * @return
	
	public void teilnehmerLoeschen(Nutzer teilnehmer) {
		Connection con = DBConnection.connection();
		try{
			Statement stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM unterhaltung " + "WHERE id=" + nutzer.getID());
		}
		catch (SQLException e2){
			e2.printStackTrace();
		}
	}
	
	
		*/
	/**
	 * Einen Teilnehmer zu einer Unterhaltung hinzuf�gen
	 * @param nutzername
	 */
	public Unterhaltung teilnehmerHinzufuegen(int UnterhaltungsID, int NutzerID){
		Connection con = DBConnection.connection();
		try{
			Statement stmt = con.createStatement();
			//TODO Nutzer pr�fen ob der in der Unterhaltung ist
			ResultSet rs = stmt.executeQuery("SELECT FROM Unterhaltungsteilnehmer "+ "WHERE NutzerID=" + getNutzerID());
		
			if(rs.next()){
				stmt = con.createStatement();
				//TODO Insert Statement
				stmt.executeUpdate("INSERT INTO Unterhaltungsteilnehmer (NutzerID, UnterhaltungsID) VALUES(" + getUnterhaltungsID() + "," + getNutzerID() +"')");
			}
		}
		catch (SQLException e2){
			e2.printStackTrace();
		}
		return null;
	}
	
	

	private String getUnterhaltungsID() {
		// TODO Auto-generated method stub
		return null;
	}

	public Unterhaltung NachrichtenIdZuUnterhaltungId (int unterhaltungsId) {
		Unterhaltung u = new Unterhaltung();
		Vector<Nachricht> Nachricht = new Vector<Nachricht>();
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			//TODO Nutzer pr�fen ob der in der Unterhaltung ist
			ResultSet rs = stmt.executeQuery("SELECT Unterhaltungsnachricht.UnterhaltungsID, Nachricht.NachrichtID, Nachricht.SenderID, Nachricht.Text, Nachricht.Erstellungszeitpunkt FROM Unterhaltungsnachricht INNER JOIN Nachricht ON Unterhaltungsnachricht.NachrichtID = Nachricht.NachrichtID WHERE Unterhaltungsnachricht.UnterhaltungId = '" +u.getID());
		
			if(rs.next()){
				u.setID(rs.getInt("Unterhaltungsnachricht.UnterhaltungsID"));
				
				Nachricht nA = new Nachricht();
				nA.setID(rs.getInt("Nachricht.NachrichtID"));
				nA.setSenderID(rs.getInt("Nachricht.SenderID"));
				nA.setErstellungszeitpunkt(rs.getDate("Nachricht.Erstellungszeitpunkt"));
				nA.setText(rs.getString("Nachricht.Text"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	
	
	
	private String getNutzerID() {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * Auslesen aller Unterhaltungen
	 * @return
	 */
	public Vector<Unterhaltung> getUnterhaltung() {
		Connection con = DBConnection.connection();
		Vector<Unterhaltung> result = new Vector<Unterhaltung>();

		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Unterhaltung");
			while (rs.next()){
				Unterhaltung u = new Unterhaltung();
				u.setID(rs.getInt("UnterhaltungsID"));
				u.setErstellungszeitpunkt(rs.getDate("Erstellungszeitpunkt"));
				
				result.addElement(u);
			}
		}
		catch (SQLException e2){
			e2.printStackTrace();
		}
		return result;
	}
	
	/** 
	 * Auslesen aller Teilnehmer einer Unterhaltung
	 * @return
	 */
	public Unterhaltung getTeilnehmer(ArrayList<Nutzer> teilnehmer) {
		Connection con = DBConnection.connection();
		Unterhaltung result = new Unterhaltung();
		try{
			Statement stmt = con.createStatement();
			//TODO Query die UnterhaltungsTeilnehmer ausliest
			ResultSet rs = stmt.executeQuery("SELECT Unterhaltungsteilnehmer.UnterhaltungsID, Nutzer.NutzerID, Nutzer.Vorname, Nutzer.Nachname FROM Unterhaltungsteilnehmer INNERJOIN Nutzer ON Unterhaltungsteilnehmer.NutzerID = Nutzer.NutzerID");
			while (rs.next()){
				Nutzer n = new Nutzer();
		        n.setID(rs.getInt("Nutzer.NutzerID"));
		        n.setVorname(rs.getString("Nutzer.Vorname"));
		        n.setNachname(rs.getString("Nutzer.Nachname"));
		        
		        result.addTeilnehmer(n);
			}
		}
		catch (SQLException e2){
			e2.printStackTrace();
		}
		return result;
	}

	
	/**
	 * Methode um vorangegangene Nachrichten aus der Datenbank auszulesen
	 * @return
	 */
	public Unterhaltung getNachrichten() {
		// TODO Was soll die Methode tun?
		Connection con = DBConnection.connection();
		Unterhaltung nachricht = new Unterhaltung();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Nachricht");
			while (rs.next()){
		        Nachricht na = new Nachricht();
		        na.setText(rs.getString("text"));
		        na.setEmpfaenger((Nutzer) rs.getArray("empfaenger"));
		        na.setSender((Nutzer) rs.getArray("sender"));
		        na.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));
		        
		        nachricht.addNachricht();
			}
		}
		catch(SQLException e2){
			e2.printStackTrace();
		}
		return nachricht;
	}
	

}
