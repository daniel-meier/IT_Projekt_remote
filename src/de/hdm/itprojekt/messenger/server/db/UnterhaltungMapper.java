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
	 * @param id
	 * @return
	 */
	public Unterhaltung findByID (int id) {
		return null;
		
	}
	
	/** Einfügen eines Unterhaltungs Objekts in die Datenbank
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
	
	/** Löschen eines Unterhaltungs Objekts aus der Datenbank
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
