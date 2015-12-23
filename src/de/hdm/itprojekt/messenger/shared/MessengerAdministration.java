package de.hdm.itprojekt.messenger.shared;

import java.util.ArrayList;
import java.util.Vector;

import de.hdm.itprojekt.messenger.shared.bo.Abonnement;
import de.hdm.itprojekt.messenger.shared.bo.Hashtag;
import de.hdm.itprojekt.messenger.shared.bo.HashtagAbonnement;
import de.hdm.itprojekt.messenger.shared.bo.Nachricht;
import de.hdm.itprojekt.messenger.shared.bo.Nutzer;
import de.hdm.itprojekt.messenger.shared.bo.NutzerAbonnement;
import de.hdm.itprojekt.messenger.shared.bo.Unterhaltung;

public interface MessengerAdministration {
	
	/**  
	 * Methode zum einloggen
	 */
	public void login ();
	
	/** 
	 * Erstelle ein HahstagAbonnement
	 */
	public HashtagAbonnement erstelleHashtagAbonnement (HashtagAbonnement String);
	
	/** 
	 * Eine Nachricht bearbeiten 
	 */
	public Nachricht bearbeiteNachricht(Nachricht nachricht);
	
	/** 
	 * Einen Teilnehmer hinzufuegen
	 */
	public Nachricht teilnehmerHinzufuegen (Vector<Nutzer> teilnehmer);
	

	/** 
	 * Einen Teilnehmer entfernen
	 */
	public void teilnehmerEntfernen (Vector<Nutzer> teilnehmer);
	
	/**  
	 * Eine Unterhaltung loeschen
	 */
	public void loescheUnterhaltung(Unterhaltung unterhaltung);
	
	/** 
	 * Ein HashtagAbonnement loeschen 
	 */
	public void loescheHashtagAbonnement(Abonnement abonnement);
	
	/** 
	 * Ein init anlegen
	 */
	public void init();
	
	/**  
	 * Einen Nutzer beim Namen ausgeben lassen
	 */
	public Vector<Nutzer> getNutzerByName (String name);
	
	/** 
	 * Ausloggen
	 */
	public void logout();
	
	/**  
	 * Einen Hashtag beim Namen ausgeben lassen
	 */
	public Vector<Hashtag> getHashtagByName (String name);
	
	/** 
	 *  Einen Nutzer bei der ID ausgeben lassen
	 */
	public Nutzer getNutzerByID (int id);
	
	/**
	 * Eine Unterhaltung erstellen
	 */
	public Unterhaltung erstelleUnterhaltung(ArrayList<Nutzer> teilnehmer);
	
	/**
	 * NutzerAbonnement loeschen
	 */
	public void loescheNutzerAbonnement(Abonnement abonnement);
	
	/**
	 * Nutzer anlegen
	 */
	public Nutzer nutzerAnlegen(String email, String vorname, String nachname);
	
	
	/**
	 * Unterhaltung nach ID ausgeben
	 */
	public Unterhaltung getUnterhaltungByID(int id);
	
	/**
	 * Nachricht senden
	 */
	public Nachricht nachrichtSenden(String text);
	
	/**
	 * Nachricht erstellen
	 */
	public Nachricht erstelleNachricht(Nachricht nachricht);
	
	/**
	 * Nachricht loeschen
	 */
	public void loescheNachricht(Nachricht nachricht);
	
	/**
	 * NutzerAbonnement erstellen
	 */
	public Abonnement erstelleNutzerAbonnement(NutzerAbonnement String);
	
	/**
	 * Hashtag erstellen
	 */
	public Hashtag erstelleHashtag(Hashtag hashtag);
	
	/**
	 * Nutzer loeschen
	 */
	public void loescheNutzer(Nutzer nutzer);
	
	/**
	 * Hashtag loeschen
	 */
	public void loescheHashtag(Hashtag hashtag);
	
	/**
	 * Alle Nutzer ausgeben
	 */
	public Vector<Nutzer> getAllNutzer();
	
	/**
	 * Hashtag nach ID ausgeben
	 */
	public Hashtag getHashtagByID(int id);

}


