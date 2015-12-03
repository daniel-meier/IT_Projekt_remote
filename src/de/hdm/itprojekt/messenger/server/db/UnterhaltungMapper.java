package de.hdm.itprojekt.messenger.server.db;

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
		return null;
		
		//DB-Verbindung holen
		Connection con = DBConnection.connection();
		
		try {
			//Leeeres SQL-Statement (JDBC) anlegen
			Statement stmt = con.createStatement();
			
			//Statement ausf¸llen und als Query an die B schicken
			ResultSet rs = stmt.executeQuery("SELECT ID,  erstellungsdatum FROM unterhaltung "
					+ "WHERE ID=" + id + " ORDER BY Datum");
			
			/*
			 * Da ID PRim‰rschl¸sse ist, kann max. nur ein Tupel zur¸ckgegeben werden. pr¸f, ob ein ergebnis vorliegt.
			 */
			if (rs.next()) {
				//Ergebnis-Tupel in Objekt umwandeln
				Unterhaltung u = new Unterhaltung();
				u.setID(rs.getInt("ID"));
				u.setErstellungdatum(rs.getDate("Erstellungsdatum"));
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
	public UnterhaltungMapper einfuegen (unterhaltung Unterhaltung) {
		
	}
	
	/** Bearbeiten eines Unterhaltungs Objekts in der Datenbank
	 * 
	 * @param UnterhaltungMapper
	 * @return
	 */
	public UnterhaltungMapper bearbeiten (unterhaltung Unterhaltung) {
		
	}
	
	/** L�schen eines Unterhaltungs Objekts aus der Datenbank
	 * 
	 * @param Unterhaltung
	 */
	public void loeschen (Unterhaltung Unterhaltung){
		
	}
	
	/** Auslesen aller Unterhaltungen
	 * 
	 * @return
	 */
	public Vector<Unterhaltung> getUnterhaltung() {
		
	}
	
	/** Auslesen aller Teilnehmer einer Unterhaltung
	 * 
	 * @return
	 */
	public Vector<Nutzer> getTeilnehmer() {
		
	}
	

}
