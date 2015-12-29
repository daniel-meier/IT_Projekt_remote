package de.hdm.itprojekt.messenger.server.report;

import java.util.Date;
import java.util.Vector;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hdm.itprojekt.messenger.shared.ReportGenerator;
import de.hdm.itprojekt.messenger.shared.bo.HashtagAbonnement;
import de.hdm.itprojekt.messenger.shared.bo.Nachricht;
import de.hdm.itprojekt.messenger.shared.bo.NutzerAbonnement;
import de.hdm.itprojekt.messenger.shared.bo.Abonnement;
import de.hdm.itprojekt.messenger.server.db.*;

/**
 * Diese Klasse ist die Implementierungsklasse von ReportGenerator
 * Enthalten sind alle Methoden die von der GUI benoetigt werden.
 * @author Sarah Weimer
 *
 */
public class ReportGeneratorImpl extends RemoteServiceServlet implements ReportGenerator{

	private static final long serialVersionUID = 1L;

	private NutzerAbonnementMapper nutzerAbonnementMapper;
	private NachrichtMapper nachrichtMapper;
	private HashtagAbonnementMapper hashtagAbonnementMapper;
	private AbonnementMapper abonnementMapper;
	
	public ReportGeneratorImpl() throws IllegalArgumentException {
		
	}
	
	/**
	 * Initialisierungsmethode
	 */
	public void init() throws IllegalArgumentException {

	}
	
	/**
	 * Erstellen eines NachrichtByNutzerReport-Reports. 
	 * Darstellen saemtlicher Nachrichten nach der Angabe eines Nutzers.
	 */
	@Override
	public Vector<Nachricht> erstelleNachrichtByNutzerReport(int id)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return this.nachrichtMapper.findByNutzer(id);
	}

	/**
	 * Erstellen eines NachrichtByNutzerZeitraum-Reports.
	 * Darstellen saemtlicher Nachrichten nach der Angabe eines Nutzers und eines Zeitraums.
	 */
	@Override
	public Vector<Nachricht> erstelleNachrichtByNutzerZeitraumReport(
			String nutzer, String von, String bis) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return this.nachrichtMapper.findByNutzerZeitraum(nutzer, von, bis);
	}

	/**
	 * Erstellen eines AbonnementByHashtag-Reports.
	 * Darstellen saemtlicher Abonnements nach der Angabe eines Hashtags.
	 * @param name 
	 */
	@Override
	public Vector<HashtagAbonnement> erstelleAbonnementByHashtagReport(
			String name) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return this.hashtagAbonnementMapper.getHashtagAbonnementByName(name);
	}

	/**
	 * Erstellen eines HashtagAbonnement-Reports.
	 * Darstellen saemtlicher Hashtag-Abonnements.
	 */
	@Override
	public Vector<HashtagAbonnement> erstelleAlleHashtagAbonemmentReport()
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return this.hashtagAbonnementMapper.getAllHashtagAbonnement();
	}

	/**
	 * Erstellen eines AbonnementByNutzer-Reports.
	 * Darstellen saemtlicher Nutzer Abonnements nach Angabe eines Nutzers.
	 */
	@Override
	public Vector<NutzerAbonnement> erstelleAbonnementByNutzerReport(
			String nachname) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return this.nutzerAbonnementMapper.getNutzerAbonnementByNutzer(nachname);
	}

	/**
	 * Erstellen eines AbonnementByNutzerHashtag-Reports
	 * Darstellen aller Abonnements.
	 */
	public Vector<Abonnement> erstelleAbonnementByNutzerHashtagReport
		(Abonnement abonnement) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return this.abonnementMapper.getAllAbonnement();
	} 

	/**
	 * Erstellen eines NachrichtByZeitraum-Reports.
	 * Darstellen saemtlicher Nachrichten nach der Angabe eines Zeitraums
	 */
	@Override
	public Vector<Nachricht> erstelleNachrichtByZeitraumReport(Date date)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return this.nachrichtMapper.getNachrichtByZeitraum(null, null);
	}

	/**
	 * Erstellen eines AllNutzerAbonnements-Reports.
	 * Darstellen saemtlicher Abonnements eines Nutzers.
	 */
	@Override
	public Vector<NutzerAbonnement> erstelleAlleNutzerAbonnementsReport()
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return this.nutzerAbonnementMapper.getAllNutzerAbonnement();
	}

}
