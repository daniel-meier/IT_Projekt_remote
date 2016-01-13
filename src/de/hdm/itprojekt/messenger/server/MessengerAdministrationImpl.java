package de.hdm.itprojekt.messenger.server;

/**
 * Import der einzelnen Klassen 
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.hdm.itprojekt.messenger.server.db.*;
import de.hdm.itprojekt.messenger.shared.MessengerAdministration;
import de.hdm.itprojekt.messenger.shared.bo.*;

/**
 * Die Klasse MessengerAdministrationImpl erbt von der Klasse RemoteServiceServlet
 * und implementiert das Interface MessengerAdministration
 */
public class MessengerAdministrationImpl extends RemoteServiceServlet implements MessengerAdministration{

	private static final long serialVersionUID = 1L;
	
	private NutzerMapper nutzerMapper = null;
	private UnterhaltungMapper unterhaltungMapper = null;
	private HashtagMapper hashtagMapper = null;
	private NutzerAbonnementMapper nutzerAbonnementMapper = null;
	private HashtagAbonnementMapper hashtagAbonnementMapper = null;
	private NachrichtMapper nachrichtMapper = null;
	

	/**
	 * no-argument Konstruktor.
	 * @throws IllegalArgumentException
	 */
	public MessengerAdministrationImpl () throws IllegalArgumentException {
		
	}
	
	/**Initialisierungsmethode.
	 * Diese Methode muss f�r jede Instanz von MessengerAdministrationImpl aufgerufen werden.
	 * @throws IllegalArgumentException
	 */
	public void init() throws IllegalArgumentException {
		 /*
	     * Ganz wesentlich ist, dass die MessengerAdministration einen vollst�ndigen Satz
	     * von Mappern besitzt, mit deren Hilfe sie dann mit der Datenbank
	     * kommunizieren kann.
	     */
		this.nutzerMapper = NutzerMapper.getNutzerMapper();
		this.unterhaltungMapper = UnterhaltungMapper.getUnterhaltungMapper();
		this.hashtagMapper = HashtagMapper.getHashtagMapper();
		this.nutzerAbonnementMapper = NutzerAbonnementMapper.getNutzerAbonnementMapper();
		this.hashtagAbonnementMapper = HashtagAbonnementMapper.getHashtagAbonnementMapper();
		this.nachrichtMapper = NachrichtMapper.getNachrichtMapper();
	}


	/*
	 * *********************************************************
	 * ABSCHNITT, Ende: Initialisierung
	 * *********************************************************
	 */
	
	/*
	 * *********************************************************
	 * ABSCHNITT, Beginn: Methoden f�r Customer-Objekte
	 * *********************************************************
	 */
	
	/**
	 * Methode um sich in das System einloggen 
	 */

	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}

	
	/**
	 * Methode um ein Hashtag zu abonnieren
	 * @param hashtag
	 * @param String 
	 * @return null
	 */
	@Override
	public HashtagAbonnement erstelleHashtagAbonnement(HashtagAbonnement String) 
			throws IllegalArgumentException{
		// TODO Auto-generated method stub
		return this.hashtagAbonnementMapper.erstellen(String);
	}
	
	/**
	 * Methode um einen Hashtag nach seinem Namen zu suchen
	 * @return
	 */
	public Vector<Hashtag> findHashtagByName(String name) throws IllegalArgumentException{
		return this.hashtagMapper.findByName(name);
	}

	/**
	 * Methode um den Text einer Nachricht zu editieren
	 * @param text
	 * @return null
	 */
	@Override
	public Nachricht bearbeiteNachricht(Nachricht nachricht) 
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return this.nachrichtMapper.bearbeiten(nachricht);
	}

	/**
	 * Methode um einen oder mehrere Nutzer als Empf�nger einer Nachricht hinzuzuf�gen
	 * @param teilnehmer
	 * @return null
	 */
	@Override
	public Nachricht teilnehmerHinzufuegen(Vector<Nutzer> teilnehmer) 
			throws IllegalArgumentException{
		// TODO Auto-generated method stub
		return this.nachrichtMapper.getTeilnehmer(teilnehmer);
	}
	
	/**
	 * Methode um die vorherigen Nachrichten einer Unterhaltung abzurufen
	 * @param unterhaltung
	 * @return
	 */
	public Unterhaltung getNachrichten (Unterhaltung unterhaltung) 
			throws IllegalArgumentException {
		return this.unterhaltungMapper.getNachrichten();
	}
	
	/**
	 * Methode um einen Teilnehmer in eine Unterhaltung hinzuzufuegen
	 * @param teilnehmer
	 * @return
	 */
	public Unterhaltung teilnehmerHinzufuegenUnterhaltung(int UnterhaltungsID, int NutzerID) 
			throws IllegalArgumentException{
		return this.unterhaltungMapper.teilnehmerHinzufuegen(UnterhaltungsID, NutzerID);
	}

	/**
	 * Methode um einen oder mehrere Nutzer aus einer Unterhaltung zu entfernen
	 * @param teilnehmer
	 */
	@Override
	public void teilnehmerEntfernen(Nutzer teilnehmer) 
			throws IllegalArgumentException{
		// TODO Pr�fung ob es ein Gruppenchat ist
		//this.unterhaltungMapper.teilnehmerLoeschen(teilnehmer);
	}



	/**
	 * Methode um eine Unterhaltung zu loeschen
	 * @param unterhaltung
	 */
	@Override
	public void loescheUnterhaltung(Unterhaltung unterhaltung) 
			throws IllegalArgumentException{
		this.unterhaltungMapper.loeschen(unterhaltung);
		
	}

	/**
	 * Methode um ein Hashtag Abonnement zu loeschen
	 * @param abonnement
	 */
	@Override
	public void loescheHashtagAbonnement(Abonnement abonnement) 
			throws IllegalArgumentException{
		// TODO Auto-generated method stub
		this.hashtagAbonnementMapper.loeschen(abonnement);
	}

	/**
	 * Methode zum auslesen eines Nutzers nach seinem Nachnamen
	 * @param name
	 * @return null
	 */
	@Override
	public Vector<Nutzer> getNutzerByName(String name) throws IllegalArgumentException{
		// TODO Auto-generated method stub
		return this.nutzerMapper.findByNachname(name);
	}
	
	/**
	 * Methode zum auslesen eines Nutzers nach seiner Email
	 * @param email
	 * @return
	 */
	public Vector<Nutzer> getNutzerByEmail(String email) throws IllegalArgumentException{
		return this.nutzerMapper.findByEmail(email);
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
	public Vector<Hashtag> getHashtagByName(String name) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return this.hashtagMapper.findByName(name);
	}

	/**
	 * Methode zum auslesen eines Nutzers nach seiner ID
	 * @param id
	 * @return null
	 */
	@Override
	public Nutzer getNutzerByID(int id) throws IllegalArgumentException{
		// TODO Auto-generated method stub
		return this.nutzerMapper.findNutzerByID(id);
	}
	
	/**
	 * Methode zum auslesen aller Nutzer nach ihrem Namen
	 * @param name
	 * @return
	 */
	public Nutzer findNutzerByName(String name) throws IllegalArgumentException{
		return this.nutzerMapper.findNutzerByName(name);
	}
	
	/**
	 * Eine Unterhaltung erstellen
	 * @return Unterhaltung
	 */
	@Override
	public Unterhaltung erstelleUnterhaltung(ArrayList<Nutzer> teilnehmer)
			throws IllegalArgumentException{
		// TODO Auto-generated method stub
		Unterhaltung u = new Unterhaltung();
		return u;
	}
	
	/**
	 * NutzerAbonnement loeschen
	 * @param abonnement
	 */
	@Override
	public void loescheNutzerAbonnement(Abonnement nutzerAbonnement) 
			throws IllegalArgumentException{
		// TODO Auto-generated method stub
		this.nutzerAbonnementMapper.loeschen(nutzerAbonnement);
	}
	
	/**
	 * Nutzer anlegen
	 * @param email
	 * @param vorname
	 * @param nachname
	 * @return Nutzer
	 */
	@Override
	public Nutzer nutzerAnlegen(String email, String vorname, String nachname)
			throws IllegalArgumentException{
		// TODO Auto-generated method stub
		Nutzer n = new Nutzer();
		this.nutzerMapper.nutzerAnlegen(n);
		n.setVorname(vorname);
		n.setNachname(nachname);
		n.setEmail(email);
		return n;
		
	}
	
	/**
	 * Unterhaltung nach ID ausgeben
	 * @param id
	 * @return Unterhaltung
	 */
	@Override
	public Unterhaltung getUnterhaltungByID(int id) throws IllegalArgumentException{
		return this.unterhaltungMapper.findByID(id);
	}
	
	/**
	 * Nachricht erstellen
	 * @param nachricht
	 * @return Nachricht
	 */
	@Override
	public Nachricht erstelleNachricht(Nachricht n) throws IllegalArgumentException{
		// TODO Auto-generated method stub
		return this.nachrichtMapper.einfuegen(n);
	}
	
	/**
	 * Nachricht senden
	 * @param text
	 * @return
	 */
	public Nachricht nachrichtSenden(Nachricht nachricht) throws IllegalArgumentException{
		return this.nachrichtMapper.senden(nachricht);	
	}
	
	/**
	 * Nachricht loeschen
	 * @param nachricht
	 */
	@Override
	public void loescheNachricht(Nachricht nachricht) throws IllegalArgumentException{
		this.nachrichtMapper.loeschen(nachricht);
	}
	
	/**
	 * NutzerAbonnement erstellen
	 * @param nutzer
	 * @return Abonnement
	 */
	@Override
	public Abonnement erstelleNutzerAbonnement(NutzerAbonnement String) 
			throws IllegalArgumentException{
		// TODO Auto-generated method stub
		return this.nutzerAbonnementMapper.erstellen(String);
	}
	
	/**
	 * Hashtag erstellen
	 * @param hashtag
	 * @return Hashtag
	 */
	@Override
	public Hashtag erstelleHashtag(Hashtag hashtag) throws IllegalArgumentException{
		// TODO Auto-generated method stub
		return this.hashtagMapper.einfuegen(hashtag);
	}
	
	/**
	 * Nutzer loeschen inkl. seiner Nachichten, Abonnements 
	 * @param nutzer
	 */
	@Override
	public void loescheNutzer(Nutzer n) throws IllegalArgumentException{
		
		Vector<Nachricht> nachricht = this.nachrichtMapper.getNachrichtByNutzer(n);
		if (nachricht != null) {
			for (Nachricht na : nachricht)
				this.nachrichtMapper.loeschen(na);
		}
		
		Vector<NutzerAbonnement> abonnement = this.nutzerAbonnementMapper.getAllNutzerAbonnement();
		if (abonnement != null) {
			for (Abonnement a: abonnement)
			this.loescheNutzerAbonnement(a);
		}
		
		Vector<HashtagAbonnement> hashtagAbonnement = this.hashtagAbonnementMapper.getAllHashtagAbonnement();
		if (hashtagAbonnement != null) {
			for (Abonnement h: hashtagAbonnement)
			this.loescheHashtagAbonnement(h);
		}
		
		
		this.nutzerMapper.loescheNutzer(n);
	}
	
	/**
	 * Hashtag loeschen
	 * @param hashtag
	 */
	@Override
	public void loescheHashtag(Hashtag hashtag) throws IllegalArgumentException{
		
		 this.hashtagMapper.loeschen(hashtag);
		
	}
	
	/**
	 * Alle Nutzer ausgeben
	 * @return Nutzer
	 */
	@Override
	public Vector<Nutzer> getAllNutzer() throws IllegalArgumentException{
		
		return this.nutzerMapper.getAllNutzer();

	}
	
	/**
	 * Hashtag nach ID ausgeben
	 * @param id
	 * @return Hashtag
	 */
	@Override
	public Hashtag getHashtagByID(int id) throws IllegalArgumentException{
		
		return this.hashtagMapper.findbyID(id);
		
	}
	
	public Unterhaltung teilnehmerHinzufuegen(int UnterhaltungsID, int NutzerID) throws IllegalArgumentException{
		return this.unterhaltungMapper.teilnehmerHinzufuegen( UnterhaltungsID, NutzerID);
	}
	
	/**
	 * NutzerCollection ausgeben
	 */
	@Override
	public Collection<String> getNutzerCollection() throws IllegalArgumentException{
		
		Vector<Nutzer> allNutzer = this.nutzerMapper.getAllNutzer();
		Collection<String> nutzerCollection = new ArrayList<String>();
		
		for(int i = 0; i > allNutzer.size(); i++){
			
			String vorname = allNutzer.elementAt(i).getVorname();
			String nachname = allNutzer.elementAt(i).getNachname();
			
			String name = vorname + " " + nachname;
			
			nutzerCollection.add(name);	
			
		}
		
		
		return nutzerCollection;
		
		
		
	}

}
