package de.hdm.itprojekt.messenger.shared;

import java.util.Date;

import com.google.gwt.user.client.rpc.RemoteService;

import de.hdm.itprojekt.messenger.shared.bo.Hashtag;
import de.hdm.itprojekt.messenger.shared.bo.Nutzer;


public interface ReportGenerator extends RemoteService {
	
	//Initialisierung des Objekts
	public void init();
	
	//Setzen des zugeordneten Nutzer
	public void setNutzer (Nutzer nutzer);
	
	//Erstellen eines NachrichtByNutzerReport-Reports.
	//Dieser Report-Typ stellt sämtliche Nachrichten nach Nutzer dar.
	public NachrichtByNutzerReport erstelleNachrichtByNutzerReport(Nutzer nutzer);
	
	//Erstellen eines NachrichtByNutzerZeitraumReport-Reports.
	//Dieser Report-Typ stellt sämtliche Nachrichten nach Nutzer in einem bestimmten Zeitraum dar.
	public NachrichtByNutzerZeitraumReport erstelleNachrichtByNutzerZeitraumReport(Nutzer nutzer, Date date);
	
	//Erstellen eines AbonnementByHashtagReport-Reports.
	//Dieser Report-Typ stellt sämtliche Abonnements eines bestimmten Hashtags dar.
	public AbonnementByHashtagReport erstelleAbonnementByHashtagReport(Hashtag hashtag);
	
	//Erstellen eines AlleHashtagAbonemmentReport-Reports.
	//Dieser Report-Typ stellt sämtliche Hashtag Abonnements aller Nutzer dar.
	public AllHashtagAbonnementReport erstelleAlleHashtagAbonemmentReport();
	
	//Erstellen eines AbonnementByNutzerReport-Reports.
	//Dieser Report-Typ stellt sämtliche Abonnements von Nutzern eines Nutzers dar.
	public AbonnementsByNutzerReport erstelleAbonnementByNutzerReport(Nutzer nutzer);
	
	//Erstellen eines AbonnementsByNutzerHashtagReport-Reports.
	//???
	public AbonnementsByNutzerHashtagReport erstelleAbonnementsByNutzerHashtagReport(Nutzer nutzer, Hashtag hashtag);
	
	//Erstellen eines NachrichtByZeitraumReport-Reports.
	//Dieser Report-Typ stellt sämtliche Nachrichten in einem bestimmten Zeitraum dar.
	public NachrichtByZeitraumReport erstelleNachrichtByZeitraumReport(Date date);
	
	//Erstellen eines AlleNutzerAbonnementsReport-Reports.
	//Dieser Report-Typ stellt sämtliche Nutzer Abonnements aller Nutzer dar.
	public AllNutzerAbonnementsReport erstelleAlleNutzerAbonnementsReport();
	
}
