package de.hdm.itprojekt.messenger.shared;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

public interface LoginService extends RemoteService {

	public LoginInfo getNutzerInfo();
}
