package de.hdm.itprojekt.messenger.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
	
	/** Suche einer Unterhaltung nach seiner eindeutigen Nummer
	 *  
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
			ResultSet rs = stmt.executeQuery("SELECT ID,  Erstellungszeitpunkt FROM unterhaltung "
					+ "WHERE ID=" + id + " ORDER BY Datum");
			
			/*
			 * Da ID PRim‰rschl¸sse ist, kann max. nur ein Tupel zur¸ckgegeben werden. pr¸f, ob ein ergebnis vorliegt.
			 */
			if (rs.next()) {
				//Ergebnis-Tupel in Objekt umwandeln
				Unterhaltung u = new Unterhaltung();
				u.setID(rs.getInt("ID"));
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

		
	/** Einf�gen eines Unterhaltungs Objekts in die Datenbank
	 * 
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
			ResultSet rs = stmt.executeQuery("SELECT MAX(id AS maxid"
					+ "FROM unterhaltung ");
			
			// Wenn wir etwas zur¸ckerhalten, kann dies nur einzeilig sein
			if (rs.next()) {
				/*
				 * t erh‰lt den bisher maximalen, un um 1 inkremetierten
				 * Prim‰rschl¸ssel.
				 */
				unterhaltung.setID(rs.getInt("maxid")+1);
				
			stmt = con.createStatement();
			
			//Jetzt erst erfolgt die tats‰chliche Einf¸geoperation
			stmt.executeUpdate("INSERT INTO unterhaltung (unterhaltungsID, Erstellzeitpunkt" + "VALUES ("
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
		
	
	/** Bearbeiten eines Unterhaltungs Objekts in der Datenbank
	 * 
	 * @param UnterhaltungMapper
	 * @return
	 */
	public Unterhaltung bearbeiten (Unterhaltung unterhaltung) {
		Connection con = DBConnection.connection();
		
		try {
			//Leeeres SQL-Statement (JDBC) anlegen
			Statement stmt = con.createStatement();
			//TODO getText?
			stmt.executeUpdate("UPDATE unterhaltung " + "SET Text= '" + unterhaltung.getText() + "' " + "WHERE id=" + unterhaltung.getID());
								
		}
		catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		// um Analoge zu insert(Textbeitrag t) zu wahren, geben wir t zur¸ck
		return unterhaltung;
	}
		
		
	
	/** L�schen eines Unterhaltungs Objekts aus der Datenbank
	 * 
	 * @param Unterhaltung
	 */
	public void loeschen (Unterhaltung Unterhaltung){
		
	Connection con =DBConnection.connection();
		
		try {
			Statement stmt = con.createStatement();
			
			stmt.executeUpdate("DELETE FROM unterhaltung " + "WHERE id=" + Unterhaltung.getID());
			
		}
		catch (SQLException e2) {
			e2.printStackTrace();
		}
	}
	
	/**
	 * Loeschen eines oder mehrerer Teilnehmer aus einer Unterhaltung
	 * @return
	 */
	public void teilnehmerLoeschen(Nutzer teilnehmer) {
		Connection con = DBConnection.connection();
		try{
			Statement stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM unterhaltung " + "WHERE id=" + teilnehmer.getID());
		}
		catch (SQLException e2){
			e2.printStackTrace();
		}
	}
		
	/**
	 * Einen Teilnehmer zu einer Unterhaltung hinzuf�gen
	 * @param nutzername
	 */
	public Unterhaltung teilnehmerHinzufuegen(String nutzername){
		Connection con = DBConnection.connection();
		try{
			Statement stmt = con.createStatement();
			//TODO Nutzer pr�fen ob der in der Unterhaltung ist
			ResultSet rs = stmt.executeQuery("SELECT ");
			if(rs.next()){
				stmt = con.createStatement();
				//TODO Insert Statement
				stmt.executeUpdate("INSERT INTO");
			}
		}
		catch (SQLException e2){
			e2.printStackTrace();
		}
		return null;
	}
	
	/** Auslesen aller Unterhaltungen
	 * 
	 * @return
	 */
	public Vector<Unterhaltung> getUnterhaltung() {
		Connection con = DBConnection.connection();
		Vector<Unterhaltung> result = new Vector<Unterhaltung>();
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM unterhaltung");
			while (rs.next()){
				Unterhaltung u = new Unterhaltung();
				u.setID(rs.getInt("ID"));
				u.setErstellungszeitpunkt(rs.getDate("Erstellungszeitpunkt"));
				result.addElement(u);
			}
		}
		catch (SQLException e2){
			e2.printStackTrace();
		}
		return result;
	}
	
	/** Auslesen aller Teilnehmer einer Unterhaltung
	 * 
	 * @return
	 */
	public Unterhaltung getTeilnehmer(ArrayList<Nutzer> teilnehmer) {
		Connection con = DBConnection.connection();
		Unterhaltung result = new Unterhaltung();
		try{
			Statement stmt = con.createStatement();
			//TODO Query die UnterhaltungsTeilnehmer ausliest
			ResultSet rs = stmt.executeQuery("");
			while (rs.next()){
				Nutzer n = new Nutzer();
		        n.setID(rs.getInt("id"));
		        n.setVorname(rs.getString("vorname"));
		        n.setNachname(rs.getString("nachname"));
		        result.addTeilnehmer(n);
			}
		}
		catch (SQLException e2){
			e2.printStackTrace();
		}
		return result;
	}
	
	


}
