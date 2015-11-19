package de.hdm.itprojekt.messenger.shared.bo;

public class Nutzer extends BusinessObject{
	
	private static final long serialVersionUID = 1L;
	private String vorname;
	private String nachname;
	private String email;
	
	public Nutzer () {
		
	}
	
	public String getVorname () {
		return vorname;
	}
	
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	

}
