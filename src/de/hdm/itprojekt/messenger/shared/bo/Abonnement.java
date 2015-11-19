package de.hdm.itprojekt.messenger.shared.bo;

public class Abonnement extends BusinessObject {

	private static final long serialVersionUID = 1L;

	private Nutzer abonnent = null;
	private Abonnement abonnement = null;

	public Abonnement () {
	}
	
	public Nutzer getAbonnent() {
		return abonnent;
	}
	
	public Abonnement getAbonnement() {
		return abonnement;
	}

	public void setAbonnement(Abonnement abonnement) {
		this.abonnement  = abonnement;
	}
	
}
