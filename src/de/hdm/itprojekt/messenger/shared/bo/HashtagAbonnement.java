package de.hdm.itprojekt.messenger.shared.bo;

public class HashtagAbonnement extends Abonnement{
	
	private static final long serialVersionUID = 1L;
	private int abonnierterHashtagID;


	public HashtagAbonnement () {
	
	}
	
	public int getAbonnierterHashtagID () {
		return abonnierterHashtagID;
	}
	
	public void setAbonnierterHashtagID (int abonnierterHashtagID) {
		this.abonnierterHashtagID = abonnierterHashtagID;
	}


}
