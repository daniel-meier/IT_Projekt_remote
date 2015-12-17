package de.hdm.itprojekt.messenger.shared.bo;

/** 
 * BusinessObject ist die Superklasse von Abonnement
 * @author kimbo
 *
 */
public class Abonnement extends BusinessObject {
	
	/**
	 * Attribute eines Abonnements
	 */
	private static final long serialVersionUID = 1L;
	private Nutzer abonnent = null;
	
	//private Abonnement abonnement = null;

	/**
	 * Leerer Konstruktor
	 */
	public Abonnement () {
	}
	
	/**
	 * Auslesen der Abonnenten
	 * @return abonnent
	 */
	public Nutzer getAbonnent() {
		return abonnent;
	}
	
	/**
	 * Setzen eines Abonnenten
	 * @param abonnent
	 */
	public void setAbonnent(Nutzer abonnent) {
		this.abonnent = abonnent;
	}
	
}
