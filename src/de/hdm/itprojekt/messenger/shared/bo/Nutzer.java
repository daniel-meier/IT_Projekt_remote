package de.hdm.itprojekt.messenger.shared.bo;

/**
 * BusinessObjects ist die Superklasse von Nutzer. 
 * 
 * @author danielmeier
 *
 */
public class Nutzer extends BusinessObject{
	
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Vorname des Nutzers
	 */
	private String vorname = "";
	
	/**
	 * Nachname des Nutzers
	 */
	private String nachname = "";
	
	/**
	 * E-Mail des Nutzers
	 */
	private String email;
	
	
	/**
	 *  Konstruktor
	 */
	public Nutzer () {
		
	}
	
	/**
	 *  Test Konstruktor für Gui Entwicklung
	 */
	public Nutzer (String vorname, String nachname, String email) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
	}
	
	
	/**
	 * Auslesen des Vornamens.
	 * @return vorname
	 */
	public String getVorname () {
		return this.vorname;
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
		return this.nachname;
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
		return this.email;
	}

	/**
	 * Setzen der Email-Adresse.
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}	
	
	/**
	 * Erzeugen einer einfachen textuellen Darstellung der Instanz.
	 * Besteht aus dem Text, der durch die Methode toString() aus der 
	 * Superklasse BusinessObjects erzeugt wird.
	 */
	public String toString() {
	    return super.toString() + " " + this.vorname + " " + this.nachname;
	  }

}
