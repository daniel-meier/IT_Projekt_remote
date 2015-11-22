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

public class ReportGeneratorImpl extends RemoteServiceServlet 
	implements ReportGenerator {

	public ReportGeneratorImpl(){
		
	}
	
	public void init(){
		
	}
	
	@Override
	public void setNutzer(Nutzer nutzer) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NachrichtByNutzerReport erstelleNachrichtByNutzerReport(Nutzer nutzer) 
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NachrichtByNutzerZeitraumReport erstelleNachrichtByNutzerZeitraumReport(
			Nutzer nutzer, Date date) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbonnementByHashtagReport erstelleAbonnementByHashtagReport(
			Hashtag hashtag) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AllHashtagAbonnementReport erstelleAlleHashtagAbonemmentReport() 
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbonnementsByNutzerReport erstelleAbonnementByNutzerReport(
			Nutzer nutzer) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbonnementsByNutzerHashtagReport erstelleAbonnementsByNutzerHashtagReport(
			Nutzer nutzer, Hashtag hashtag) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NachrichtByZeitraumReport erstelleNachrichtByZeitraumReport(Date date) 
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AllNutzerAbonnementsReport erstelleAlleNutzerAbonnementsReport()  
			throws IllegalArgumentException{
		// TODO Auto-generated method stub
		return null;
	}

}
