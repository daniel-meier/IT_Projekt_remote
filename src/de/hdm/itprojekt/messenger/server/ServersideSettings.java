package de.hdm.itprojekt.messenger.server;

import de.hdm.itprojekt.messenger.shared.CommonSettings;
import java.util.logging.Logger;

/**
 * Die Klasse ServersideSettings ist eine Subklasse und erbt von der Superklasse CommonSettings
 * @author kimbo
 *
 */
public class ServersideSettings extends CommonSettings {
	
	/**
	 * 
	 */
	private static final String LOGGER_NAME = "Server";
	private static final Logger log = Logger.getLogger(LOGGER_NAME);
	// URL einfuegen
	public static final String PAGE_URL_EDITOR = "";
	// URL einfuegen
	public static final String PAGE_URL_VIEWER = "";

	/**
	 * 
	 * @return
	 */
	public static Logger getLogger() {
		return log;
	}

}
