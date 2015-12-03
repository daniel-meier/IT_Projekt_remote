package de.hdm.itprojekt.messenger.server;

/**
 * Import der einzelnen Klassen 
 */

import java.util.ArrayList;
import java.util.Vector;

import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;




import de.hdm.itprojekt.messenger.server.db.AbonnementMapper;
import de.hdm.itprojekt.messenger.server.db.HashtagMapper;
import de.hdm.itprojekt.messenger.server.db.NachrichtMapper;
import de.hdm.itprojekt.messenger.server.db.NutzerMapper;
import de.hdm.itprojekt.messenger.server.db.UnterhaltungMapper;
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

	private static final long serialVersionUID = 1L;
	
	private NutzerMapper nutzerMapper = null;
	private UnterhaltungMapper unterhaltungMapper = null;
	private HashtagMapper hashtagMapper = null;
	private AbonnementMapper abonnementMapper = null;
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
		this.unterhaltungMapper = UnterhaltungMapper.getUnterhaltungMapper ();
		this.hashtagMapper = HashtagMapper.getHashtagMapper ();
		this.abonnementMapper = AbonnementMapper.getAbonnementMapper ();
		this.nachrichtMapper = NachrichtMapper.getNachrichtMapper ();
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
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        UserService userService = UserServiceFactory.getUserService();

        String thisURL = req.getRequestURI();

        resp.setContentType("text/html");
        if (req.getUserPrincipal() != null) {
            resp.getWriter().println("<p>Hallo, " +
                                     req.getUserPrincipal().getName() +
                                     "!  Du kannst <a href=\"" +
                                     userService.createLogoutURL(thisURL) +
                                     "\">ausloggen</a>.</p>");
        } else {
            resp.getWriter().println("<p>Bitte <a href=\"" +
                                     userService.createLoginURL(thisURL) +
                                     "\">einloggen</a>.</p>");
        }
    }
	
	/**
	 * Methode um ein Hashtag zu abonnieren
	 * @param hashtag
	 * @return null
	 */
	@Override
	public Hashtag erstelleHashtagAbonnement(String hashtag) 
			throws IllegalArgumentException{
		// TODO Auto-generated method stub
		return null;
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
	 * Methode um einen oder mehrere Nutzer aus einer Unterhaltung zu entferen
	 * @param teilnehmer
	 */
	@Override
	public void teilnehmerEntfernen(ArrayList<Nutzer> teilnehmer) 
			throws IllegalArgumentException{
		// TODO Auto-generated method stub
		
	}

	/**
	 * Methode um eine Unterhaltung zu l�schen
	 * @param unterhaltung
	 */
	@Override
	public void loescheUnterhaltung(Unterhaltung unterhaltung) 
			throws IllegalArgumentException{
		this.unterhaltungMapper.loeschen(unterhaltung);
		
	}

	/**
	 * Methode um ein Hashtag Abonnement zu l�schen
	 * @param abonnement
	 */
	@Override
	public void loescheHashtagAbonnement(Abonnement abonnement) 
			throws IllegalArgumentException{
		// TODO Auto-generated method stub
		
	}

	/**
	 * Methode zum auslesen eines Nutzers nach seinem Namen
	 * @param name
	 * @return null
	 */
	@Override
	public Nutzer getNutzerByName(String name) throws IllegalArgumentException{
		// TODO Auto-generated method stub
		return this.nutzerMapper.findNutzerByName(name);
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
	
	/**Eine Unterhaltung erstellen
	 * 
	 * @return Unterhaltung
	 */
	@Override
	public Unterhaltung erstelleUnterhaltung(ArrayList<Nutzer> teilnehmer)
			throws IllegalArgumentException{
		// TODO Auto-generated method stub
		Unterhaltung u = new Unterhaltung();
		return u;
	}
	
	/**NutzerAbonnement loeschen
	 * 
	 * @param abonnement
	 */
	@Override
	public void loescheNutzerAbonnement(Abonnement abonnement){
		// TODO Auto-generated method stub
		
	}
	
	/**Nutzer anlegen
	 * 
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
	
	/**Nachricht erstellen
	 * 
	 * @param nachricht
	 * @return Nachricht
	 */
	@Override
	public Nachricht erstelleNachricht(Nachricht nachricht) throws IllegalArgumentException{
		// TODO Auto-generated method stub
		return this.nachrichtMapper.einfuegen(nachricht);
	}
	
	/**Nachricht loeschen
	 * 
	 * @param nachricht
	 */
	@Override
	public void loescheNachricht(Nachricht nachricht) throws IllegalArgumentException{
		this.nachrichtMapper.loeschen(nachricht);
	}
	
	/**NutzerAbonnement erstellen
	 * 
	 * @param nutzer
	 * @return Abonnement
	 */
	@Override
	public Abonnement erstelleNutzerAbonnement(Nutzer nutzer) throws IllegalArgumentException{
		// TODO Auto-generated method stub
		return null;
	}
	
	/**Hashtag erstellen
	 * 
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
		
		/**
		Vector<Abonnement> abonnement = this.getNutzerAbonnement(n);
		if (abonnement != null) {
			for (Abonnement a: abonnement)
			this.loescheNutzerAbonnement(a);
		}
		
		Vector<Abonnement> hashtagAbonnement = this.getHashtagAbonnement();
		if (hashtagAbonnement != null) {
			for (Abonnement h: hashtagAbonnement)
			this.loescheHashtagAbonnement(h);
		}
		*/
		
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
	public ArrayList<Nutzer> getAllNutzer() throws IllegalArgumentException{
		
		return this.nutzerMapper.getAllNutzer();

	}
	
	/**Hashtag nach ID ausgeben
	 * 
	 * @param id
	 * @return Hashtag
	 */
	@Override
	public Hashtag getHashtagByID(int id) throws IllegalArgumentException{
		
		return this.hashtagMapper.findbyID(id);
		
	}


}
