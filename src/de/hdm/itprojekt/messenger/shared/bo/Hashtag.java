package de.hdm.itprojekt.messenger.shared.bo;

public class Hashtag extends BusinessObject {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	public Hashtag(){
		
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName (String name){
		this.name = name;
	}

}
