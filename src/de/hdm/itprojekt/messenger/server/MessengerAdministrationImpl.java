package de.hdm.itprojekt.messenger.server;

/**
 * Import der einzelnen Klassen 
 */

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hdm.itprojekt.messenger.shared.MessengerAdministration;
import de.hdm.itprojekt.messenger.shared.bo.Abonnement;
import de.hdm.itprojekt.messenger.shared.bo.Hashtag;
import de.hdm.itprojekt.messenger.shared.bo.Nachricht;
import de.hdm.itprojekt.messenger.shared.bo.Nutzer;
import de.hdm.itprojekt.messenger.shared.bo.Unterhaltung;

/**
 * Die Klasse MessengerAdministrationImpl erbt von der Klasse RemoteServiceServlet
 * und implementiert das Interface MessengerAdministration
 */
public class MessengerAdministrationImpl extends RemoteServiceServlet implements MessengerAdministration{

	
	/**
	 * Methode um sich in das System einloggen 
	 */
	@Override
	public void login() {
		
	}

	/**
	 * Methode um ein Hashtag zu abonnieren
	 * @param hashtag
	 * @return null
	 */
	@Override
	public Hashtag erstelleHashtagAbonnement(String hashtag) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Methode um den Text einer Nachricht zu editieren
	 * @param text
	 * @return null
	 */
	@Override
	public Nachricht bearbeiteNachricht(String text) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Methode um einen oder mehrere Nutzer als Empfänger einer Nachricht hinzuzufügen
	 * @param teilnehmer
	 * @return null
	 */
	@Override
	public Nachricht teilnehmerHinzufuegen(ArrayList<Nutzer> teilnehmer) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Methode um einen oder mehrere Nutzer aus einer Unterhaltung zu entferen
	 * @param teilnehmer
	 */
	@Override
	public void teilnehmerEntfernen(ArrayList<Nutzer> teilnehmer) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Methode um eine Unterhaltung zu löschen
	 * @param unterhaltung
	 */
	@Override
	public void loescheUnterhaltung(Unterhaltung unterhaltung) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Methode um ein Hashtag Abonnement zu löschen
	 * @param abonnement
	 */
	@Override
	public void loescheHashtagAbonnement(Abonnement abonnement) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Methode zum auslesen eines Nutzers nach seinem Namen
	 * @param name
	 * @return null
	 */
	@Override
	public Nutzer getNutzerByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Methode um sich aus dem System auszuloggen 
	 */
	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Methode zum auslesen eines Hashtags nach seinem Namen
	 * @param name
	 * @return null
	 */
	@Override
	public Hashtag getHashtagByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Methode zum auslesen eines Nutzers nach seiner ID
	 * @param id
	 * @return null
	 */
	@Override
	public Nutzer getNutzerByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**Eine Unterhaltung erstellen
	 * 
	 * @return Unterhaltung
	 */
	@Override
	public Unterhaltung erstelleUnterhaltung(ArrayList<Nutzer> teilnehmer){
		Unterhaltung u = new Unterhaltung();
		return u;
	}
	
	/**NutzerAbonnement loeschen
	 * 
	 * @param abonnement
	 */
	@Override
	public void loescheNutzerAbonnement(Abonnement abonnement){
		
	}
	
	/**Nutzer anlegen
	 * 
	 * @param email
	 * @param vorname
	 * @param nachname
	 * @return Nutzer
	 */
	@Override
	public Nutzer nutzerAnlegen(String email, String vorname, String nachname){
		Nutzer n = new Nutzer();
		return n;
	}
	
	/**Unterhaltung nach ID ausgeben
	 * 
	 * @param id
	 * @return Unterhaltung
	 */
	@Override
	public Unterhaltung getUnterhaltungByID(int id){
		
	}
	
	/**Nachricht erstellen
	 * 
	 * @param nachricht
	 * @return Nachricht
	 */
	@Override
	public Nachricht erstelleNachricht(String nachricht){
		
	}
	
	/**Nachricht loeschen
	 * 
	 * @param nachricht
	 */
	@Override
	public void loescheNachricht(Nachricht nachricht){
		
	}
	
	/**NutzerAbonnement erstellen
	 * 
	 * @param nutzer
	 * @return Abonnement
	 */
	@Override
	public Abonnement erstelleNutzerAbonnement(Nutzer nutzer){
		
	}
	
	/**Hashtag erstellen
	 * 
	 * @param hashtag
	 * @return Hashtag
	 */
	@Override
	public Hashtag erstelleHashtag(String hashtag){
		
	}
	
	/**Nutzer loeschen
	 * 
	 * @param nutzer
	 */
	@Override
	public void loescheNutzer(Nutzer nutzer){
		
	}
	
	/**Hashtag loeschen
	 * 
	 * @param hashtag
	 */
	@Override
	public void loescheHashtag(Hashtag hashtag){
		
	}
	
	/**Alle Nutzer ausgeben
	 * 
	 * @return Nutzer
	 */
	@Override
	public Nutzer getAllNutzer(){
		return Nutzer;
	}
	
	/**Hashtag nach ID ausgeben
	 * 
	 * @param id
	 * @return Hashtag
	 */
	@Override
	public Hashtag getHashtagByID(int id){
		
	}

}
