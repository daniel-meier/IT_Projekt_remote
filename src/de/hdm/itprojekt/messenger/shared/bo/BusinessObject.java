package de.hdm.itprojekt.messenger.shared.bo;
import java.io.Serializable;
import java.util.Date;

public abstract class BusinessObject implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id = 0;
	private Date erstellungszeitpunkt;
	
	public BusinessObject(){
		
	}
	
	public int getID(){
		return this.id;
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public Date getErstellungszeitpunkt(){
		return this.erstellungszeitpunkt;
	}
	
	public String toString() {
		return this.getClass().getName() + " #" + this.id;
	  }
	
	public boolean equals (Object o){
		
		return false;
	}
		
	

}
