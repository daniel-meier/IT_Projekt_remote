package de.hdm.itprojekt.messenger.server.db;

import de.hdm.itprojekt.messenger.shared.bo.Nutzer;

public class NutzerMapper extends DBConnection{
	
	public NutzerMapper () {
		
	}
	
	public NutzerMapper nutzerMapper() {
		
	}
	
	/** Suche eines Nutzers nach seiner eindeutigen Nummer
	 * 
	 * @param id
	 * @return
	 */
	public NutzerMapper findByNutzerID (int id) {
		
	}
	
	/** Suche ein Nutzer Objekt nach seinem Nachnamen
	 * 
	 * @return
	 */
	public Vector<Nutzer> findByNachname () {
		
	}
	
	/** Einfügen eines Nutzer Objekts in die Datenbank
	 * 
	 * @param NutzerMapper
	 * @return
	 */
	public NutzerMapper einfuegen (nutzer Nutzer) {
		
	}
	
	/** Bearbeiten eines Nutzer Objekts in der Datenbank
	 * 
	 * @param NutzerMapper
	 * @return
	 */
	public NutzerMapper bearbeiten (nutzer Nutzer) {
		
	}
	
	/** Löschen eines Nutzer Objekts aus der Datenbank
	 * 
	 * @param NutzerMapper
	 */
	public void loeschen (nutzer Nutzer) {
		
	}
	
	/** Auslesen aller Nutzer
	 * 
	 * @return
	 */
	public Vector<Nutzer> getNutzer() {
		
	}

	public Nutzer findNutzerByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
