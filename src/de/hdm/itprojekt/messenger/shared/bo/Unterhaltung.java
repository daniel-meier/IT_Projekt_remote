package de.hdm.itprojekt.messenger.shared.bo;

import java.util.*;
 
public class Unterhaltung extends BusinessObject{

	private static final long serialVersionUID = 1L;
	
	//brauchen wir unterhaltungsID wenn wir in BO eh eine ID haben?
	private int unterhaltungsID = 0;
	
	/**
	 * Attribut teilnehmer vom Typ ArrayList um einer Unterhaltung verschiedene Nutzer als
	 * Teilnehmer hinzufügen zu können.
	 */
	private ArrayList<Nutzer> teilnehmer;
	
	/**
	 * Konstruktor 
	 */
	public Unterhaltung(){
		this.teilnehmer = new ArrayList<Nutzer>();
	}
	
	/**
	 * Hinzufügen von Nutzer zu einer Unterhaltung.
	 * 
	 * @param t
	 * 		Nutzer der hinzugefügt werden soll.
	 */
	public void setTeilnehmer(Nutzer t){
		if (t != null) {
			teilnehmer.add(t);	}
	}
	
	/**
	 * Liefert alle Nutzer im Form eines Arrays.
	 * 
	 * @return
	 * 		Array mit allen Nutzern
	 */
	public List<Nutzer> getTeilnehmer(){
		List<Nutzer> result = new ArrayList<Nutzer>();
		for (Nutzer t : this.teilnehmer) {
			//t.getStatement
			result.add(t);
		}
		return result;
	}
	
	public int getUnterhaltungsID(){
		return this.unterhaltungsID;
	}
	
	public void setUnterhaltungsID(int unterhaltungsID){
		unterhaltungsID = this.unterhaltungsID;
	}
}
