package de.hdm.itprojekt.messenger.shared.bo;
import java.io.Serializable;
import java.util.Date;

public abstract class BusinessObject implements Serializable {
	
	/**
	 * Anlegen der Attribute
	 */
	private static final long serialVersionUID = 1L;
	private int id = 0;
	private Date erstellungsdatum;
	
	/**
	 * Beim erzeugen eines Objects wird es mit dem Datum versehen.
	 */
	public BusinessObject(){
		this.erstellungsdatum = new Date();
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
	public Date getErstellungsdatum(){
		return this.erstellungsdatum;
	}
	
	/**
	 * Erzeugen einer einfachen textuellen Darstellung der jeweiligen Instanz
	 */
	public String toString() {
		/**
		 * Wir geben den Klassennamen gefolgt von der ID des Objekts zurÃ¼ck
		 */
		return this.getClass().getName() + " #" + this.id;
	  }
	
	/**
	 * 
	 */
	public boolean equals (Object o){
	/**
	 * Abfragen, ob das Objekt gleich ist und ob ein Objekt gecastet werden kann	
	 */
		boolean result = false;
		if (o != null && o instanceof BusinessObject){
			BusinessObject b = (BusinessObject) o;
			try {
				if (b.getID() == this.id) {
					result = true;
				}
			}
			catch (IllegalArgumentException e) {
				/**
				 * Bei einem Fehler false zurückgeben.
				 */
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
}
