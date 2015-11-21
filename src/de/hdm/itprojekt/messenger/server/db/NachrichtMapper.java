package de.hdm.itprojekt.messenger.server.db;

public class NachrichtMapper extends DBConnection {

	public NachrichtMapper () {
		
	}
	
	public NachrichtMapper nachrichtMapper () {
		
	}
	
	/** Suche einer Nachricht nach seiner eindeutigen Nummer
	 * 
	 * @param id
	 * @return
	 */
	public Nachricht findByID (int id) {
		
	}
	
	/** Suche ein Nachricht Objekt nach seinem Nutzer
	 * 
	 * @return
	 */
	public Vector<Nachricht> findByNutzer (nutzer Nutzer) {
		
	}
	
	/** Einfügen eines Nachricht Objekts in die Datenbank
	 * 
	 * @param Nachricht
	 * @return
	 */
	public Nachricht einfuegen (nachricht Nachricht) {
		
	}
	
	/** Bearbeiten eines Nachricht Objekts in der Datenbank
	 * 
	 * @param Nachricht
	 * @return
	 */
	public Nachricht bearbeiten (nachricht Nachricht) {
		
	}
	
	/** Löschen eines Nachrichten Objekts aus der Datenbank
	 * 
	 * @param Nachricht
	 */
	public void loeschen (nachricht Nachricht) {
		
	}
	
	/** Auslesen aller Nachrichten
	 * 
	 * @return
	 */
	public Vector<Nachricht> getNachricht () {
		
	}
	
}
