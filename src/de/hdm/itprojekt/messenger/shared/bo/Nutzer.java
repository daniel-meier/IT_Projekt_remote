package de.hdm.itprojekt.messenger.shared.bo;

/**
 * BusinessObjects ist die Superklasse von Nutzer. 
 * 
 * @author danielmeier
 *
 */
public class Nutzer extends BusinessObject{
	
	/**
	 * Anlegen der Attribute.
	 */
	private static final long serialVersionUID = 1L;
	private String vorname;
	private String nachname;
	private String email;
	
	/**
	 * (Noch leerer) Konstruktor.
	 */
	public Nutzer () {
		
	}
	
	/**
	 * Auslesen des Vornamens.
	 * @return vorname
	 */
	public String getVorname () {
		return vorname;
	}
	
	/**
	 * Setzen des Vornamens.
	 * @param vorname
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * Auslesen des Nachnamens.
	 * @return nachname
	 */
	public String getNachname() {
		return nachname;
	}

	/**
	 * Setzen des Nachnamens.
	 * @param nachname
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	/**
	 * Auslesen der Email-Adresse.
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setzen der Email-Adresse.
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}	

}
