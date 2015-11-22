package de.hdm.itprojekt.messenger.shared.bo;

/** 
 * BusinessObject ist die Superklasse von Abonnement
 * @author kimbo
 *
 */
public class Abonnement extends BusinessObject {
	
	
/**
 * 
 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Nutzer ist Abonnent
	 */
	private Nutzer abonnent = null;
	
	/**
	 * Abonnement ist Abonnement 
	 */
	private Abonnement abonnement = null;

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
	 * 
	 * @return
	 */
	public Abonnement getAbonnement() {
		return abonnement;
	}

	public void setAbonnement(Abonnement abonnement) {
		this.abonnement  = abonnement;
	}
	
}
