package de.hdm.itprojekt.messenger.shared;

import java.util.Date;

import com.google.gwt.user.client.rpc.RemoteService;

import de.hdm.itprojekt.messenger.shared.bo.Hashtag;
import de.hdm.itprojekt.messenger.shared.bo.Nutzer;
import de.hdm.itprojekt.messenger.shared.report.AbonnementByHashtagReport;
import de.hdm.itprojekt.messenger.shared.report.AbonnementsByNutzerHashtagReport;
import de.hdm.itprojekt.messenger.shared.report.AbonnementsByNutzerReport;
import de.hdm.itprojekt.messenger.shared.report.AllHashtagAbonnementReport;
import de.hdm.itprojekt.messenger.shared.report.AllNutzerAbonnementsReport;
import de.hdm.itprojekt.messenger.shared.report.NachrichtByNutzerReport;
import de.hdm.itprojekt.messenger.shared.report.NachrichtByNutzerZeitraumReport;
import de.hdm.itprojekt.messenger.shared.report.NachrichtByZeitraumReport;


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
	public void setNutzer (Nutzer nutzer) throws IllegalArgumentException;
	

	/**
	 * Erstellen eines NachrichtByNutzerReport-Reports. 
	 * Dieser Report-Typ stellt sämtliche Nachrichten nach Nutzer dar.
	 * 
	 * @param nutzer
	 * @return
	 * @throws IllegalArgumentException
	 * NachrichtByNutzerReport
	 */
	public NachrichtByNutzerReport erstelleNachrichtByNutzerReport(Nutzer nutzer) throws IllegalArgumentException;
	

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
	public NachrichtByNutzerZeitraumReport erstelleNachrichtByNutzerZeitraumReport(Nutzer nutzer, Date date) throws IllegalArgumentException;
	
	
	/**
	 * Erstellen eines AbonnementByHashtagReport-Reports.
	 * Dieser Report-Typ stellt sämtliche Abonnements eines bestimmten Hashtags dar.
	 * 
	 * @param hashtag
	 * @return
	 * @throws IllegalArgumentException
	 * AbonnementByHashtagReport
	 */
	public AbonnementByHashtagReport erstelleAbonnementByHashtagReport(Hashtag hashtag) throws IllegalArgumentException;
	

	/**
	 * Erstellen eines AlleHashtagAbonemmentReport-Reports.
	 * Dieser Report-Typ stellt sämtliche Hashtag Abonnements aller Nutzer dar.
	 * 
	 * @return
	 * @throws IllegalArgumentException
	 * AllHashtagAbonnementReport
	 */
	public AllHashtagAbonnementReport erstelleAlleHashtagAbonemmentReport() throws IllegalArgumentException;
	
	
	/**
	 * Erstellen eines AbonnementByNutzerReport-Reports.
	 * Dieser Report-Typ stellt sämtliche Abonnements von Nutzern eines Nutzers dar.
	 * 
	 * @param nutzer
	 * @return
	 * @throws IllegalArgumentException
	 * AbonnementsByNutzerReport
	 */
	public AbonnementsByNutzerReport erstelleAbonnementByNutzerReport(Nutzer nutzer) throws IllegalArgumentException;
	
	
	/**
	 * Erstellen eines AbonnementsByNutzerHashtagReport-Reports.
	 * ???
	 * 
	 * @param nutzer
	 * @param hashtag
	 * @return
	 * @throws IllegalArgumentException
	 * AbonnementsByNutzerHashtagReport
	 */
	public AbonnementsByNutzerHashtagReport erstelleAbonnementsByNutzerHashtagReport(Nutzer nutzer, Hashtag hashtag) throws IllegalArgumentException;
	
	
	/**
	 * Erstellen eines NachrichtByZeitraumReport-Reports.
	 * Dieser Report-Typ stellt sämtliche Nachrichten in einem bestimmten Zeitraum dar.
	 * 
	 * @param date
	 * @return
	 * @throws IllegalArgumentException
	 * NachrichtByZeitraumReport
	 */
	public NachrichtByZeitraumReport erstelleNachrichtByZeitraumReport(Date date) throws IllegalArgumentException;
	
	
	/**
	 * Erstellen eines AlleNutzerAbonnementsReport-Reports.
	 * Dieser Report-Typ stellt sämtliche Nutzer Abonnements aller Nutzer dar.
	 * 
	 * @return
	 * @throws IllegalArgumentException
	 * AllNutzerAbonnementsReport
	 */
	public AllNutzerAbonnementsReport erstelleAlleNutzerAbonnementsReport() throws IllegalArgumentException;
	
}
