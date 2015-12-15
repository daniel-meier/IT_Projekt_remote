package de.hdm.itprojekt.messenger.shared;

import java.util.Date;
import java.util.Vector;

import com.google.gwt.user.client.rpc.RemoteService;

import de.hdm.itprojekt.messenger.shared.bo.Abonnement;
import de.hdm.itprojekt.messenger.shared.bo.Hashtag;
import de.hdm.itprojekt.messenger.shared.bo.HashtagAbonnement;
import de.hdm.itprojekt.messenger.shared.bo.Nachricht;
import de.hdm.itprojekt.messenger.shared.bo.Nutzer;
import de.hdm.itprojekt.messenger.shared.bo.NutzerAbonnement;
import de.hdm.itprojekt.messenger.shared.report.*;

public interface ReportGenerator extends RemoteService {
	
	/**
	 * Initialisierung des Objekts
	 * 
	 * @throws IllegalArgumentException
	 * void
	 */
	public void init() throws IllegalArgumentException;
	
	
	/**
	 * Setzen des zugeordneten Nutzer
	 * 
	 * @param nutzer
	 * @throws IllegalArgumentException
	 * void
	 */
	//public void setNutzer (Nutzer n) throws IllegalArgumentException;
	

	/**
	 * Erstellen eines NachrichtByNutzerReport-Reports. 
	 * Dieser Report-Typ stellt sämtliche Nachrichten nach Nutzer dar.
	 * 
	 * @param nutzer
	 * @return
	 * @throws IllegalArgumentException
	 * NachrichtByNutzerReport
	 */
	public Vector<Nachricht> erstelleNachrichtByNutzerReport(int id) 
			throws IllegalArgumentException;
	

	/**
	 * Erstellen eines NachrichtByNutzerZeitraumReport-Reports.
	 * Dieser Report-Typ stellt sämtliche Nachrichten nach Nutzer in einem bestimmten Zeitraum dar.
	 * 
	 * @param nutzer
	 * @param date
	 * @return
	 * @throws IllegalArgumentException
	 * NachrichtByNutzerZeitraumReport
	 */
	public Vector<Nachricht> erstelleNachrichtByNutzerZeitraumReport(String nutzer, 
			String von, String bis) throws IllegalArgumentException;
	
	
	/**
	 * Erstellen eines AbonnementByHashtagReport-Reports.
	 * Dieser Report-Typ stellt sämtliche Abonnements eines bestimmten Hashtags dar.
	 * 
	 * @param hashtag
	 * @return
	 * @throws IllegalArgumentException
	 * AbonnementByHashtagReport
	 */
	public Vector<HashtagAbonnement> erstelleAbonnementByHashtagReport(String name) 
			throws IllegalArgumentException;
	

	/**
	 * Erstellen eines AlleHashtagAbonemmentReport-Reports.
	 * Dieser Report-Typ stellt sämtliche Hashtag Abonnements aller Nutzer dar.
	 * 
	 * @return
	 * @throws IllegalArgumentException
	 * AllHashtagAbonnementReport
	 */
	public Vector<HashtagAbonnement> erstelleAlleHashtagAbonemmentReport() 
			throws IllegalArgumentException;
	
	
	/**
	 * Erstellen eines AbonnementByNutzerReport-Reports.
	 * Dieser Report-Typ stellt saemtliche Abonnements von Nutzern eines Nutzers dar.
	 * 
	 * @param nutzer
	 * @return
	 * @throws IllegalArgumentException
	 * AbonnementsByNutzerReport
	 */
	public Vector<NutzerAbonnement> erstelleAbonnementByNutzerReport(String nachname) 
			throws IllegalArgumentException;
	
	/**
	 * Erstellen eines AbonnementByNutzerHashtag-Reports.
	 * Dieser Report-Typ stellt saemtliche Abonnements eines Nutzers dar.
	 * @param abonnement
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Vector<Abonnement> erstelleAbonnementByNutzerHashtagReport(
			Abonnement abonnement) throws IllegalArgumentException;
	
	
	/**
	 * Erstellen eines NachrichtByZeitraumReport-Reports.
	 * Dieser Report-Typ stellt sämtliche Nachrichten in einem bestimmten Zeitraum dar.
	 * 
	 * @param date
	 * @return
	 * @throws IllegalArgumentException
	 * NachrichtByZeitraumReport
	 */
	public Vector<Nachricht> erstelleNachrichtByZeitraumReport(Date date) 
			throws IllegalArgumentException;
	
	
	/**
	 * Erstellen eines AlleNutzerAbonnementsReport-Reports.
	 * Dieser Report-Typ stellt sämtliche Nutzer Abonnements aller Nutzer dar.
	 * 
	 * @return
	 * @throws IllegalArgumentException
	 * AllNutzerAbonnementsReport
	 */
	public Vector<NutzerAbonnement> erstelleAlleNutzerAbonnementsReport() 
			throws IllegalArgumentException;

}
