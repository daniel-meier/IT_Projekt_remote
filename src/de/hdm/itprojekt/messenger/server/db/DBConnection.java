package de.hdm.itprojekt.messenger.server.db;

/**
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
*/

import com.google.appengine.api.rdbms.AppEngineDriver;
import com.google.cloud.sql.jdbc.ResultSet;

public class DBConnection {
	
	private static Connection con = null;
	
	/** 
	 * Die Url mit deren Hilfe die Datenbank angesprochen wird.
	 */
	private static String url = //'jdbc.mysql://127.2.3 ...'
			
	
	public static DBConnection() {
		
	}
	
	/**
	 * 
	 * @return Das DBConnection Objekt
	 */
	public static Connection connection () {
		
	}
	

	/**
	 * Die Klasse DBConnection wird nur einmal instanziiert. Man spricht heierbei
	 * von einem sogenannten <b>Singleton</b>.<p>
	 * Diese Variable ist durch den Bezeichner <code>static</code> nur einmal f¸r 
	 * s‰mtliche eventuellen Instanzen dieser Klassse vorhanden. Sie speichert die einzige Instanz dieser Klasse.
	 * 
	 * @see AbonnementMapper()
	 * @see HashtagMapper()
	 * @see NachrichtMapper()
	 * @see NutzerMapper()
	 * @see UnterhaltungMapper()
	 */
	private static Connection con = null;
	
	/**
	 * Die URL, mit deren Hilfe die Datenbank angesprochen wird. In einer
	 * professionellen Applikation w¸rde diese Zeichenkette aus einer
	 * Konfiguratonsdatei eingelese oder ¸ber einen Parameter von auﬂen
	 * mitgegeben, um bei einer Ver‰nderung dieser URL nicht die gesamte 
	 * Software neu komiieren zu m¸ssen.
	 */
	private static String url ="";
	/**
	 * Diese statische Methode kann aufgerufen werden durch 
	 * <code>DB_COnnection.connection()</code>. Sie erstellt die
	 * Singleton-Eigenschaft sicher, indem sie daf¸r sorgt, dass nur eine einzige 
	 * Instanz von <code>DBConnection</code> existiert. <p>
	 * 
	 * <b>Fazit:</b> DBConnection sollte nicht mittels <code>new</code>
	 * instanziiert werden, sondern stets durch Aufruf dieser statischen Methde.<p>
	 * 
	 * <b>Nachtei:<b> Bei Zusammenbruch der Verbindung zur Datenbank - dies kann z.B.
	 * durch ein unabsichtiges Herunterfahren der Datenbank ausgelˆst werden -
	 * wird keine neue Verbindung aufgebaut, so dass die in einem solchen Fall die 
	 * gesamte Software neu zu starten ist, In einer robusten Lˆsung w¸rde man hier 
	 * die Klasse dahingehend modifizieren, dass bei einer nicht mehr funktionsf‰higen 
	 * Verbindung stets versucht w¸rde, eine neue Verbindung aufzubauen. Dies w¸rde
	 * allerdings ebenfalls den Rahmen dieses Projekts sprengen.
	 * 
	 * @return DAS <code>DBConnection</code>-Objekt.
	 * @see con
	 */
	public static Connection connection() {
		// Wenn es bisher keine Connection zur DB gab, ...
		if ( con == null) {
			try {
				// Ersteinmal muss der passende SB-Treiber geladen werden
				DriverManager.registerDriver(new AppEngingeDriver());
				
				/*
				 * Dann erst kann uns der DriveManager eine Verbindung mit den oben 
				 * in der Variable url angegebenen Verbindungsinformation aufbauen.
				 * 
				 * Diese Verbindung wird dann in der statischen Variable von 
				 * abgespeichert und fortan verwendet.
				 */
				con = DriverManager.getConnection(url);
			}
			catch (SQLException e1) {
				con = null;
				e1.printStackTrace();
			}
		}
		// Zur¸ckgeben der Verbindung
		return con;
	}
}

}
