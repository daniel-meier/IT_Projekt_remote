package de.hdm.itprojekt.messenger.server;

import de.hdm.itprojekt.messenger.shared.CommonSettings;
import java.util.logging.Logger;

public class ServersideSettings extends CommonSettings {
	private static final String LOGGER_NAME = "Server";
	private static final Logger log = Logger.getLogger(LOGGER_NAME);
	
	public static Logger getLogger(){
		return log;
	}

}
