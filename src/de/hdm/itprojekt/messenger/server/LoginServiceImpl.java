package de.hdm.itprojekt.messenger.server;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hdm.itprojekt.messenger.server.db.NutzerMapper;
import de.hdm.itprojekt.messenger.shared.LoginInfo;
import de.hdm.itprojekt.messenger.shared.LoginService;
import de.hdm.itprojekt.messenger.shared.bo.Nutzer;
import de.hdm.tellme.shared.bo.Nutzer.eStatus;


public class LoginServiceImpl extends RemoteServiceServlet implements
		LoginService {

	private String uri_;

	public LoginServiceImpl() throws IllegalArgumentException {

		uri_ = "";

	}

	private void setURI() {
		String URIs = "";
		StringBuffer requestURL = this.perThreadRequest.get().getRequestURL();
		String queryString = this.perThreadRequest.get().getQueryString();
		if (queryString == null) {
			URIs = requestURL.toString();

			int amountServerletPathChar = this.perThreadRequest.get()
					.getServletPath().length();
			int amountURISPath = URIs.length();
			uri_ = URIs
					.substring(0, amountURISPath - (amountServerletPathChar));
		} else {
			uri_ = requestURL.append('?').append(queryString).toString();
		}
	}

	private static final long serialVersionUID = -1L;

	@Override
	public LoginInfo getNutzerInfo() {

		UserService userService = UserServiceFactory.getUserService();
		User nutzer = userService.getCurrentUser();
		LoginInfo loginInfo = new LoginInfo();

		setURI();

		if (nutzer != null) {
			NutzerMapper nMapper = NutzerMapper.getNutzerMapper();

			loginInfo.setLoggedIn(true);
			loginInfo.setEmailAddress(nutzer.getEmail());
			loginInfo.setLogoutUrl(userService.createLogoutURL(uri_));

			Nutzer n = nMapper.suchenMitEmailAdresse(loginInfo
					.getEmailAddress());

			if (n.getMailadresse() != null) {
				if (n.getStatus() != eStatus.inaktiv) {
					loginInfo.setUser(n);
				} else {
					nMapper.setzeNutzerAktiv(n.getId());
					loginInfo.setUser(n);
				}
			}

			else {
				Nutzer na = new Nutzer();
				na.setMailadresse(loginInfo.getEmailAddress());
				na.setVorname("undefined");
				na.setNachname("undefined");
				na.setId(nMapper.anlegen(na));

				loginInfo.setUser(na);
			}

		} else {
			loginInfo.setLoggedIn(false);
			loginInfo.setLoginUrl(userService.createLoginURL(uri_));
		}
		return loginInfo;

	}
}