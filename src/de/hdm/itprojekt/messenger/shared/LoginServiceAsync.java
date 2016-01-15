package de.hdm.itprojekt.messenger.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {

	void getNutzerInfo(AsyncCallback<LoginInfo> callback);

}