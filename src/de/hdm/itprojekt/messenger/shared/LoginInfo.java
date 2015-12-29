package de.hdm.itprojekt.messenger.shared;

import de.hdm.itprojekt.messenger.shared.bo.*;

import java.io.Serializable;

public class LoginInfo implements Serializable {

private static final long serialVersionUID = 1L;
	
	private boolean loggedIn = false;
	private String loginUrl;
	private String logoutUrl;
	private String email;
	private String googleId;
	private Nutzer user;
	
	public boolean isLoggedIn() {
		return loggedIn;
	}
	
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	public String getLoginUrl() {
		return loginUrl;
	}
	
	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}
	
	public String getLogoutUrl() {
		return logoutUrl;
	}
	
	public void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getGoogleId() {
		return googleId;
	}
	
	public void setGoogleId(String googleId) {
		this.googleId = googleId;
	}
	
	public Nutzer getUser() {
		return user;
	}
	
	public void setUser(Nutzer user) {
		this.user = user;
	}
}
