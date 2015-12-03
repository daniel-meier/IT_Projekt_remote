package de.hdm.itprojekt.messenger.server.report;

import java.util.Date;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hdm.itprojekt.messenger.shared.ReportGenerator;
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

/**
 * Implementierungsklasse des ReportGenerators Interface
 *
 */
public class ReportGeneratorImpl extends RemoteServiceServlet implements ReportGenerator {

	private static final long serialVersionUID = 1L;
	
	public ReportGeneratorImpl() throws IllegalArgumentException{
		
	}
	
	/**
	 * Initialisierung des Objekts
	 * 
	 * @throws IllegalArgumentException
	 * void
	 */
	public void init() throws IllegalArgumentException{
		
	}
	
	/**
	 * Erstellen eines NachrichtByNutzerReport-Reports. 
	 * Dieser Report-Typ stellt sämtliche Nachrichten nach Nutzer dar.
	 * 
	 * @param nutzer
	 * @return
	 * @throws IllegalArgumentException
	 * NachrichtByNutzerReport
	 */
	@Override
	public NachrichtByNutzerReport erstelleNachrichtByNutzerReport(Nutzer nutzer) 
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

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
	@Override
	public NachrichtByNutzerZeitraumReport erstelleNachrichtByNutzerZeitraumReport(
			Nutzer nutzer, Date date) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Erstellen eines AbonnementByHashtagReport-Reports.
	 * Dieser Report-Typ stellt sämtliche Abonnements eines bestimmten Hashtags dar.
	 * 
	 * @param hashtag
	 * @return
	 * @throws IllegalArgumentException
	 * AbonnementByHashtagReport
	 */
	@Override
	public AbonnementByHashtagReport erstelleAbonnementByHashtagReport(
			Hashtag hashtag) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Erstellen eines AlleHashtagAbonemmentReport-Reports.
	 * Dieser Report-Typ stellt sämtliche Hashtag Abonnements aller Nutzer dar.
	 * 
	 * @return
	 * @throws IllegalArgumentException
	 * AllHashtagAbonnementReport
	 */
	@Override
	public AllHashtagAbonnementReport erstelleAlleHashtagAbonemmentReport() 
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Erstellen eines AbonnementByNutzerReport-Reports.
	 * Dieser Report-Typ stellt sämtliche Abonnements von Nutzern eines Nutzers dar.
	 * 
	 * @param nutzer
	 * @return
	 * @throws IllegalArgumentException
	 * AbonnementsByNutzerReport
	 */
	@Override
	public AbonnementsByNutzerReport erstelleAbonnementByNutzerReport(
			Nutzer nutzer) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

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
	@Override
	public AbonnementsByNutzerHashtagReport erstelleAbonnementsByNutzerHashtagReport(
			Nutzer nutzer, Hashtag hashtag) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Erstellen eines NachrichtByZeitraumReport-Reports.
	 * Dieser Report-Typ stellt sämtliche Nachrichten in einem bestimmten Zeitraum dar.
	 * 
	 * @param date
	 * @return
	 * @throws IllegalArgumentException
	 * NachrichtByZeitraumReport
	 */
	@Override
	public NachrichtByZeitraumReport erstelleNachrichtByZeitraumReport(Date date) 
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Erstellen eines AlleNutzerAbonnementsReport-Reports.
	 * Dieser Report-Typ stellt sämtliche Nutzer Abonnements aller Nutzer dar.
	 * 
	 * @return
	 * @throws IllegalArgumentException
	 * AllNutzerAbonnementsReport
	 */
	@Override
	public AllNutzerAbonnementsReport erstelleAlleNutzerAbonnementsReport()  
			throws IllegalArgumentException{
		// TODO Auto-generated method stub
		return null;
	}

}
