package de.hdm.itprojekt.messenger.shared.bo;

/**
 * Klasse Abonnement ist die Superklasse von HashtagAbonnement
 * @author Sarah Weimer
 *
 */
public class HashtagAbonnement extends Abonnement{
	
	/**
	 * Attribute eines Hashtag Abonnements
	 */
	private static final long serialVersionUID = 1L;
	private int abonnierterHashtagID;
	private Abonnement hashtagAbonnement;
//	private String hashtagName;

	/**
	 * Konstruktor
	 */
	public HashtagAbonnement () {
	
	}
	
	/**
	 * Auslesen der abonnierten Hashtag ID
	 * @return abonnierterHashtagID
	 */
	public int getAbonnierterHashtagID () {
		return abonnierterHashtagID;
	}
	
	/**
	 * Setzen der abonnierten Hashtag ID
	 * @param abonnierterHashtagID
	 */
	public void setAbonnierterHashtagID (int abonnierterHashtagID) {
		this.abonnierterHashtagID = abonnierterHashtagID;
	}
	
	/**
	 * Auslesen der HashtagAbonnements 
	 * @return
	 */
	public Abonnement getHashtagAbonnement () {
		return hashtagAbonnement;
	}

	/**
	 * Setzen der HashtagAbonnements
	 * @param hashtagAbonnement
	 */
	public void setHashtagAbonnement(Abonnement hashtagAbonnement) {
		this.hashtagAbonnement = hashtagAbonnement;
	}

//	/**
//	 * Auslesen des Namens eines Hashtags
//	 * @return
//	 */
//	public String getHashtagName() {
//		return hashtagName;
//	}
//
//	/**
//	 * Setzen des Namens eines Hashtags
//	 * @param hashtagName
//	 */
//	public void setHashtagName(String hashtagName) {
//		this.hashtagName = hashtagName;
//	}

}
