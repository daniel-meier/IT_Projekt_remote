package de.hdm.itprojekt.messenger.shared;

import java.util.Date;
import java.util.Vector;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.itprojekt.messenger.shared.bo.Abonnement;
import de.hdm.itprojekt.messenger.shared.bo.Hashtag;
import de.hdm.itprojekt.messenger.shared.bo.HashtagAbonnement;
import de.hdm.itprojekt.messenger.shared.bo.Nachricht;
import de.hdm.itprojekt.messenger.shared.bo.Nutzer;
import de.hdm.itprojekt.messenger.shared.bo.NutzerAbonnement;
import de.hdm.itprojekt.messenger.shared.report.AbonnementByHashtagReport;
import de.hdm.itprojekt.messenger.shared.report.AbonnementsByNutzerHashtagReport;
import de.hdm.itprojekt.messenger.shared.report.AbonnementsByNutzerReport;
import de.hdm.itprojekt.messenger.shared.report.AllHashtagAbonnementReport;
import de.hdm.itprojekt.messenger.shared.report.AllNutzerAbonnementsReport;
import de.hdm.itprojekt.messenger.shared.report.NachrichtByNutzerReport;
import de.hdm.itprojekt.messenger.shared.report.NachrichtByNutzerZeitraumReport;
import de.hdm.itprojekt.messenger.shared.report.NachrichtByZeitraumReport;

public interface ReportGeneratorAsync {

	void init(AsyncCallback<Void> callback);

	//void setNutzer(Nutzer nutzer, AsyncCallback<Void> callback);

	void erstelleNachrichtByNutzerReport(int id,
			AsyncCallback<Vector<Nachricht>> callback);

	void erstelleNachrichtByNutzerZeitraumReport(Nutzer nutzer, String von,
			String bis, AsyncCallback<Vector<Nachricht>> callback);

	void erstelleAbonnementByHashtagReport(String name,
			AsyncCallback<Vector<HashtagAbonnement>> callback);

	void erstelleAlleHashtagAbonemmentReport(
			AsyncCallback<Vector<HashtagAbonnement>> callback);

	void erstelleAbonnementByNutzerReport(String nachname,
			AsyncCallback<Vector<NutzerAbonnement>> callback);

	void erstelleAbonnementByNutzerHashtagReport(Abonnement abonnement,
			AsyncCallback<Vector<Abonnement>> callback);

	void erstelleNachrichtByZeitraumReport(Date date,
			AsyncCallback<Vector<Nachricht>> callback);

	void erstelleAlleNutzerAbonnementsReport(
			AsyncCallback<Vector<NutzerAbonnement>> callback);

}
