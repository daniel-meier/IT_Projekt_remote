package de.hdm.itprojekt.messenger.server.report;

import java.util.Date;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hdm.itprojekt.messenger.shared.ReportGenerator;
import de.hdm.itprojekt.messenger.shared.bo.Hashtag;
import de.hdm.itprojekt.messenger.shared.bo.Nutzer;
import de.hdm.itprojekt.messenger.shared.report.AbonnementByHashtagReport;
import de.hdm.itprojekt.messenger.shared.report.AbonnementsByNutzerReport;
import de.hdm.itprojekt.messenger.shared.report.AllHashtagAbonnementReport;
import de.hdm.itprojekt.messenger.shared.report.AllNutzerAbonnementsReport;
import de.hdm.itprojekt.messenger.shared.report.NachrichtByNutzerReport;
import de.hdm.itprojekt.messenger.shared.report.NachrichtByNutzerZeitraumReport;
import de.hdm.itprojekt.messenger.shared.report.NachrichtByZeitraumReport;

/**
 * Diese Klasse ist die Implementierungsklasse von ReportGenerator
 * Enthalten sind alle Methoden die von der GUI benoetigt werden.
 * @author Sarah Weimer
 *
 */
public class ReportGeneratorImpl extends RemoteServiceServlet implements ReportGenerator{

	private static final long serialVersionUID = 1L;
	
	public ReportGeneratorImpl() throws IllegalArgumentException {
		
	}
	
	public void init() throws IllegalArgumentException {

	}
	
	/**
	 * Erstellen eines NachrichtByNutzerReport-Reports. 
	 * Darstellen saemtlicher Nachrichten nach der Angabe eines Nutzers.
	 */
	@Override
	public NachrichtByNutzerReport erstelleNachrichtByNutzerReport(Nutzer nutzer)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Erstellen eines NachrichtByNutzerZeitraum-Reports.
	 * Darstellen saemtlicher Nachrichten nach der Angabe eines Nutzers und eines Zeitraums.
	 */
	@Override
	public NachrichtByNutzerZeitraumReport erstelleNachrichtByNutzerZeitraumReport(
			Nutzer nutzer, Date date) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Erstellen eines AbonnementByHashtag-Reports.
	 * Darstellen saemtlicher Abonnements nach der Angabe eines Hashtags.
	 */
	@Override
	public AbonnementByHashtagReport erstelleAbonnementByHashtagReport(
			Hashtag hashtag) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Erstellen eines HashtagAbonnement-Reports.
	 * Darstellen saemtlicher Hashtag-Abonnements.
	 */
	@Override
	public AllHashtagAbonnementReport erstelleAlleHashtagAbonemmentReport()
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Erstellen eines AbonnementByNutzer-Reports.
	 * Darstellen saemtlicher Abonnements nach Angabe eines Nutzers.
	 */
	@Override
	public AbonnementsByNutzerReport erstelleAbonnementByNutzerReport(
			Nutzer nutzer) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

/**	public AbonnementsByNutzerHashtagReport erstelleAbonnementsByNutzerHashtagReport(
			Nutzer nutzer, Hashtag hashtag) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	} */

	/**
	 * Erstellen eines NachrichtByZeitraum-Reports.
	 * Darstellen saemtlicher Nachrichten nach der Angabe eines Zeitraums
	 */
	@Override
	public NachrichtByZeitraumReport erstelleNachrichtByZeitraumReport(Date date)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Erstellen eines AllNutzerAbonnements-Reports.
	 * Darstellen saemtlicher Abonnements eines Nutzers.
	 */
	@Override
	public AllNutzerAbonnementsReport erstelleAlleNutzerAbonnementsReport()
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

}
