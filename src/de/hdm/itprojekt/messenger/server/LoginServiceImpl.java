package de.hdm.itprojekt.messenger.server;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hdm.itprojekt.messenger.client.ClientsideSettings;
import de.hdm.itprojekt.messenger.server.db.NutzerMapper;
import de.hdm.itprojekt.messenger.shared.LoginInfo;
import de.hdm.itprojekt.messenger.shared.LoginService;
import de.hdm.itprojekt.messenger.shared.MessengerAdministrationAsync;
import de.hdm.itprojekt.messenger.shared.bo.Nutzer;

public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {
	
	final MessengerAdministrationAsync async = ClientsideSettings.getMessenger();

	
	private static final long serialVersionUID = 1L;
//	private String requestUri;
	
//	public void loginServiceImpl() throws IllegalArgumentException{
//		requestUri = "";
//	}
	
//	private void setURI() {
//		String URIs = "";
//		StringBuffer requestURL = this.perThreadRequest.get().getRequestURL();
//		String queryString = this.perThreadRequest.get().getQueryString();
//		if (queryString == null) {
//			URIs = requestURL.toString();
//			int amountServerletPathChar = this.perThreadRequest.get().getServletPath().length();
//			int amountURISPath = URIs.length();
//			requestUri = URIs.substring(0, amountURISPath - (amountServerletPathChar));
//		}
//		else {
//			requestUri = requestURL.append('?').append(queryString).toString();
//		}
//	}
//
//	@Override
//	public LoginInfo getNutzerInfo() {
//		// TODO Auto-generated method stub
//		UserService userService = UserServiceFactory.getUserService();
//		User nutzer = userService.getCurrentUser();
//		LoginInfo loginInfo = new LoginInfo();
//		setURI();
//		
//		if (nutzer != null) {
//			loginInfo.setLoggedIn(true);
//			loginInfo.setEmail(nutzer.getEmail());
//			//loginInfo.setVorname(nutzer.getVorname());
//			//loginInfo.setNachname(nutzer.getNachname());
//			loginInfo.setLogoutUrl(userService.createLogoutURL(requestUri));
//		} else {
//			loginInfo.setLoggedIn(false);
//			loginInfo.setLoginUrl(userService.createLoginURL(requestUri));
//		}
//		return loginInfo;
//	}

	@Override
	public LoginInfo login(String requestUri) {

		UserService userService = UserServiceFactory.getUserService ();
		User user = userService.getCurrentUser ();
		LoginInfo loginInfo = new LoginInfo ();
		
		if(user!= null) {
			NutzerMapper nMapper = NutzerMapper.getNutzerMapper();

			Nutzer n = nMapper.findByEmail(loginInfo
					.getEmail());
			
			if (n != null){
			}
			else{
				n = new Nutzer();
				n.setEmail(loginInfo.getEmail());
				n.setVorname("undefined");
				n.setNachname("undefined");
				
				async.nutzerAnlegen(n.getEmail(),n.getVorname(),n.getNachname(), null);
				

			}
			
			loginInfo.setLoggedIn (true);
			loginInfo.setEmail(user.getEmail());
			loginInfo.setNickname(user.getNickname());
			loginInfo.setLogoutUrl(userService.createLogoutURL (requestUri));
		} else {
			loginInfo.setLoggedIn(false);
			loginInfo.setLoginUrl (userService.createLoginURL (requestUri));
		}
		return loginInfo;
	}

}
