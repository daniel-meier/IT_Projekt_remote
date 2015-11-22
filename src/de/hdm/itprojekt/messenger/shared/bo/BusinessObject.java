package de.hdm.itprojekt.messenger.shared.bo;
import java.io.Serializable;
import java.util.Date;

public abstract class BusinessObject implements Serializable {
	
	/**
	 * Anlegen der Attribute
	 */
	private static final long serialVersionUID = 1L;
	private int id = 0;
	private Date erstellungszeitpunkt;
	
	/**
	 * Leerer Konstruktor
	 */
	public BusinessObject(){
		
	}
	
	/**
	 * Auslesen der ID
	 * @return id
	 */
	public int getID(){
		return this.id;
	}
	
	/**
	 * Setzen der ID
	 * @param id
	 */
	public void setID(int id){
		this.id = id;
	}
	
	/**
	 * Auslesen des Erstellungszeitpunktes
	 * @return erstellungszeitpunkt
	 */
	public Date getErstellungszeitpunkt(){
		return this.erstellungszeitpunkt;
	}
	
	/**
	 * Erzeugen einer einfachen textuellen Darstellung der jeweiligen Instanz
	 */
	public String toString() {
		/**
		 * Wir geben den Klassennamen gefolgt von der ID des Objekts zurück
		 */
		return this.getClass().getName() + " #" + this.id;
	  }
	
	
	public boolean equals (Object o){
	/**
	 * Abfragen, ob das Objekt gleich ist und ob ein Objekt gecastet werden kann	
	 */
		return false;
	}
		
	

}
