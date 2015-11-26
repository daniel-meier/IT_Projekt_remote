package de.hdm.itprojekt.messenger.shared.bo;

public class NutzerAbonnement extends Abonnement{
	
	private static final long serialVersionUID = 1L;
	private int abonnierterNutzerID;
	
	public int getAbonnierterNutzerID () {
		return abonnierterNutzerID;
	}
	
	public void setAbonnierterNutzerID (int abonnierterNutzerID) {
		this.abonnierterNutzerID = abonnierterNutzerID;
	}

}
