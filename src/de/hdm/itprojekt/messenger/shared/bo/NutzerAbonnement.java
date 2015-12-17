package de.hdm.itprojekt.messenger.shared.bo;

/**
 * Abonnement ist die Superklasse von NutzerAbonnement
 * @author Sarah Weimer
 *
 */
public class NutzerAbonnement extends Abonnement{
	
	/**
	 * Attribute eines Nutzer Abonnements
	 */
	private static final long serialVersionUID = 1L;
	private int abonnierterNutzerID;
	private Abonnement nutzerAbonnement;
	
	/**
	 * Konstruktor
	 */
	public NutzerAbonnement() {
		
	}
	
	/**
	 * Auslesen der abonnierten Nutzer ID
	 * @return abonnierterNutzerID
	 */
	public int getAbonnierterNutzerID () {
		return abonnierterNutzerID;
	}
	
	/**
	 * Setzen der abonnierten Nutzer ID
	 * @param abonnierterNutzerID
	 */
	public void setAbonnierterNutzerID (int abonnierterNutzerID) {
		this.abonnierterNutzerID = abonnierterNutzerID;
	}
	
	/**
	 * Auslesen des Nutzer Abonnements
	 * @return nutzerAbonnement
	 */
	public Abonnement getNutzerAbonnement() {
		return nutzerAbonnement;
	}

	/**
	 * Setzen des Nutzer Abonnements
	 * @param nutzerAbonnement
	 */
	public void setNutzerAbonnement(Abonnement nutzerAbonnement) {
		this.nutzerAbonnement = nutzerAbonnement;
	}

}
