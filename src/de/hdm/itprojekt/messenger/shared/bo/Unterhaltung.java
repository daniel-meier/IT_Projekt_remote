package de.hdm.itprojekt.messenger.shared.bo;

import java.util.*;
 
/**
 * BusinessObjects ist die Superklasse von Unterhaltung
 * 
 * @author danielmeier
 */
public class Unterhaltung extends BusinessObject{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Anlegen des Attributs teilnehmer vom Typ ArrayList, um einer Unterhaltung verschiedene Nutzer als
	 * Teilnehmer hinzufuegen zu koennen.
	 */
	private ArrayList<Nutzer> teilnehmer;
	
	/**
	 * No-Argument Konstruktor 
	 */
	public Unterhaltung(){
		this.teilnehmer = new ArrayList<Nutzer>();
	}
	
	/**
	 * Hinzufuegen von Nutzer zu einer Unterhaltung.
	 *
	 * @param t
	 * 		Nutzer der hinzugefuegt werden soll.
	 */
	public void setTeilnehmer(Nutzer t){
		if (t != null) {
			teilnehmer.add(t);	}
	}
	
	/**
	 * Auslesen aller Nutzer im Form eines Arrays.
	 * 
	 * @return result
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
	
}
