package de.hdm.itprojekt.messenger.shared;

import java.util.ArrayList;

import de.hdm.itprojekt.messenger.shared.bo.Abonnement;
import de.hdm.itprojekt.messenger.shared.bo.Hashtag;
import de.hdm.itprojekt.messenger.shared.bo.Nachricht;
import de.hdm.itprojekt.messenger.shared.bo.Nutzer;
import de.hdm.itprojekt.messenger.shared.bo.Unterhaltung;

public interface MessengerAdministration {
	
	/** Methode zum einloggen 
	 * 
	 */
	public void login ();
	
	/** Erstelle ein HahstagAbonnement
	 * 
	 */
	public Hashtag erstelleHashtagAbonnement (String hashtag);
	
	/** Eine Nachricht bearbeiten 
	 * 
	 */
	public Nachricht bearbeiteNachricht(Nachricht nachricht);
	
	/** Einen Teilnehmer hinzufügen
	 * 
	 */
	public Nachricht teilnehmerHinzufuegen (ArrayList<Nutzer> teilnehmer);
	

	/** Einen Teilnehmer entfernen
	 * 
	 */
	public void teilnehmerEntfernen (ArrayList<Nutzer> teilnehmer);
	
	/** Eine Unterhaltung löschen 
	 * 
	 */
	public void loescheUnterhaltung(Unterhaltung unterhaltung);
	
	/** Ein HashtagAbonnement löschen 
	 * 
	 */
	public void loescheHashtagAbonnement(Abonnement abonnement);
	
	/** Ein init anlegen
	 * 
	 */
	public void init();
	
	/** Einen Nutzer beim Namen ausgeben lassen 
	 * 
	 */
	public Nutzer getNutzerByName (String name);
	
	/** Ausloggen
	 * 
	 */
	public void logout();
	
	/** Einen Hashtag beim Namen ausgeben lassen 
	 * 
	 */
	public Hashtag getHashtagByName (String name);
	
	/** Einen Nutzer bei der ID ausgeben lassen
	 *  
	 */
	public Nutzer getNutzerByID (int id);
	
	/**Eine Unterhaltung erstellen
	 * 
	 */
	public Unterhaltung erstelleUnterhaltung(ArrayList<Nutzer> teilnehmer);
	
	/**NutzerAbonnement loeschen
	 * 
	 */
	public void loescheNutzerAbonnement(Abonnement abonnement);
	
	/**Nutzer anlegen
	 *
	 */
	public Nutzer nutzerAnlegen(String email, String vorname, String nachname);
	
	
	/**Unterhaltung nach ID ausgeben
	 * 
	 */
	public Unterhaltung getUnterhaltungByID(int id);
	
	/**Nachricht erstellen
	 * 
	 */
	public Nachricht erstelleNachricht(String nachricht);
	
	/**Nachricht loeschen
	 * 
	 */
	public void loescheNachricht(Nachricht nachricht);
	
	/**NutzerAbonnement erstellen
	 * 
	 */
	public Abonnement erstelleNutzerAbonnement(Nutzer nutzer);
	
	/**Hashtag erstellen
	 * 
	 */
	public Hashtag erstelleHashtag(String hashtag);
	
	/**Nutzer loeschen
	 * 
	 */
	public void loescheNutzer(Nutzer nutzer);
	
	/**Hashtag loeschen
	 * 
	 */
	public void loescheHashtag(Hashtag hashtag);
	
	/**Alle Nutzer ausgeben
	 * 
	 */
	public ArrayList<Nutzer> getAllNutzer();
	
	/**Hashtag nach ID ausgeben
	 * 
	 */
	public Hashtag getHashtagByID(int id);
}


