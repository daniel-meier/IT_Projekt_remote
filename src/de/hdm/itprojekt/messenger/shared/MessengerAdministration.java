package de.hdm.itprojekt.messenger.shared;

import java.util.ArrayList;

import de.hdm.itprojekt.messenger.shared.bo.Abonnement;
import de.hdm.itprojekt.messenger.shared.bo.Hashtag;
import de.hdm.itprojekt.messenger.shared.bo.Nachricht;
import de.hdm.itprojekt.messenger.shared.bo.Nutzer;
import de.hdm.itprojekt.messenger.shared.bo.Unterhaltung;

public class MessengerAdministration {
	
	/** Methode zum einloggen 
	 * 
	 */
	public void login (){
		
	}
	
	/** Erstelle ein HahstagAbonnement
	 * 
	 */
	public Hashtag erstelleHashtagAbonnement (String hashtag){
	 return Abonnement;
	}
	
	/** Eine Nachricht bearbeiten 
	 * 
	 */
	public Nachricht bearbeiteNachricht(String text){
		return Nachricht;
	}
	
	/** Einen Teilnehmer hinzufügen
	 * 
	 */
	public Nachricht teilnehmerHinzufügen (ArrayList<Nutzer> teilnehmer){
		return Nachricht;
	}

	/** Einen Teilnehmer entfernen
	 * 
	 */
	public void teilnehmerEntfernen (ArrayList<Nutzer> teilnehmer){
		
	}
	
	/** Eine Unterhaltung löschen 
	 * 
	 */
	public void loescheUnterhaltung(Unterhaltung unterhaltung){
		
	}
	
	/** Ein HashtagAbonnement löschen 
	 * 
	 */
	public void loescheHashtagAbonnement(Abonnement abonnement){
		
	}
	
	/** Ein init anlegen
	 * 
	 */
	public void init(){
		
	}
	
	/** Einen Nutzer beim Namen ausgeben lassen 
	 * 
	 */
	public Nutzer getNutzerByName (String name){
		return ArrayList<Nutzer>;
	}
	
	/** Ausloggen
	 * 
	 */
	public void logout(){
		
	}
	
	/** Einen Hashtag beim Namen ausgeben lassen 
	 * 
	 */
	public Hashtag getHashtagByName (String name){
		return Hashtag;
	}
	
	/** Einen Nutzer bei der ID ausgeben lassen
	 *  
	 */
	public Nutzer getNutzerByID (int id){
		return Nutzer;
	}
}


