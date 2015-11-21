package de.hdm.itprojekt.messenger.shared;

import java.util.Date;

import com.google.gwt.user.client.rpc.AsyncCallback;

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

public interface ReportGeneratorAsync {

	void init(AsyncCallback<Void> callback);

	void setNutzer(Nutzer nutzer, AsyncCallback<Void> callback);

	void erstelleNachrichtByNutzerReport(Nutzer nutzer,
			AsyncCallback<NachrichtByNutzerReport> callback);

	void erstelleNachrichtByNutzerZeitraumReport(Nutzer nutzer, Date date,
			AsyncCallback<NachrichtByNutzerZeitraumReport> callback);

	void erstelleAbonnementByHashtagReport(Hashtag hashtag,
			AsyncCallback<AbonnementByHashtagReport> callback);

	void erstelleAlleHashtagAbonemmentReport(
			AsyncCallback<AllHashtagAbonnementReport> callback);

	void erstelleAbonnementByNutzerReport(Nutzer nutzer,
			AsyncCallback<AbonnementsByNutzerReport> callback);

	void erstelleAbonnementsByNutzerHashtagReport(Nutzer nutzer,
			Hashtag hashtag,
			AsyncCallback<AbonnementsByNutzerHashtagReport> callback);

	void erstelleNachrichtByZeitraumReport(Date date,
			AsyncCallback<NachrichtByZeitraumReport> callback);

	void erstelleAlleNutzerAbonnementsReport(
			AsyncCallback<AllNutzerAbonnementsReport> callback);

}
