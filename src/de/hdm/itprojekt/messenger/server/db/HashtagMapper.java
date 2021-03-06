package de.hdm.itprojekt.messenger.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import de.hdm.itprojekt.messenger.shared.bo.Hashtag;
import de.hdm.itprojekt.messenger.shared.bo.Nutzer;
import de.hdm.itprojekt.messenger.server.db.DBConnection;

/**
 * HashtagMapper ist eine Subklasse, welche von der Superklasse DBConnection erbt
 * @author kimbo
 *
 */
public class HashtagMapper extends DBConnection {

	private static HashtagMapper hashtagMapper = null;

	protected HashtagMapper() {

	}

	public static HashtagMapper getHashtagMapper() {
		if (hashtagMapper == null) {
			hashtagMapper = new HashtagMapper();
		}
		return hashtagMapper;
	}

	/**
	 * Suche eines Hashtags nach seiner eindeutigen Nummer
	 * 
	 * @param id
	 * @return
	 */
	public Hashtag findbyID(int hashtagID) {
		// DB-Verbindung holen
		Connection con = DBConnection.connection();

		try {
			// Leeres SQL-Statement (JDBC) anlegen
			Statement stmt = con.createStatement();

			// Statement ausfuellen und als Query an die DB schicken
			ResultSet rs = stmt
					.executeQuery("SELECT HashtagID, Erstellungszeitpunkt, HashtagText FROM Hashtag "
							+ "WHERE HashtagID="
							+ hashtagID
							+ " ORDER BY HashtagText DESC");

			/*
			 * Da id Primaerschluessel ist, kann max. nur ein Tupel
			 * zurueckgegeben werden. Pruefe, ob ein Ergebnis vorliegt.
			 */
			if (rs.next()) {
				// Ergebnis-Tupel in Objekt umwandeln
				Hashtag h = new Hashtag();
				h.setID(rs.getInt("HashtagID"));
				h.setErstellungszeitpunkt(rs.getDate("Erstellungszeitpunkt"));
				h.setHashtagtext(rs.getString("HashtagText"));

				return h;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return null;
	}

	/**
	 * Einfuegen eines Hashtag Objekts in die Datenbank
	 * 
	 * @param Hashtag
	 * @return
	 */
	public Hashtag einfuegen(Hashtag hashtag) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT MAX(HashtagID) AS maxid "
					+ "FROM Hashtag");

			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
			if (rs.next()) {
				/*
				 * c erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */
				hashtag.setID(rs.getInt("maxid") + 1);

				stmt = con.createStatement();

				// Jetzt erst erfolgt die tatsächliche Einfügeoperation
				stmt.executeUpdate("INSERT INTO Hashtag (HashtagID, Erstellungszeitpunkt, HashtagText) "
						+ "VALUES ("
						+ hashtag.getID()
						+ ","
						+ hashtag.getErstellungszeitpunkt()
						+ ","
						+ hashtag.getHashtagtext() + ")");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hashtag;
	}

	/**
	 * Bearbeiten eines Hashtag Objekts in der Datenbank
	 * 
	 * @param Hashtag
	 * @return
	 */
	public Hashtag bearbeiten(Hashtag hashtag) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("UPDATE Hashtag SET HashtagText=\""
					+ hashtag.getHashtagtext() + "\" " + "WHERE HashtagID="
					+ hashtag.getID());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hashtag;
	}

	/**
	 * Loeschen eines Hashtag Objekts aus der Datenbank
	 * 
	 * @param Hashtag
	 */
	public void loeschen(Hashtag hashtag) {

		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("DELETE FROM Hashtag WHERE Hashtag="
					+ hashtag.getID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Suchen eines Hashtag Objekts nach seinem Namen
	 * 
	 * @param name
	 * @return
	 */
	public Vector<Hashtag> findByName(String name) {
		Connection con = DBConnection.connection();
		Vector<Hashtag> result = new Vector<Hashtag>();

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Hashtag"
					+ "ORDER BY HashtagText DESC");
			while (rs.next()) {
				Hashtag h = new Hashtag();
				h.setID(rs.getInt("HashtagID"));
				h.setHashtagtext(rs.getString("HashtagText"));

				result.addElement(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

	/**
	 * Auslesen aller Hashtags
	 * 
	 * @return
	 */
	public Vector<Hashtag> getAllHashtags() {

		Connection con = DBConnection.connection();
		// Ergebnisvektor vorbereiten
		Vector<Hashtag> result = new Vector<Hashtag>();

		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt
					.executeQuery("SELECT HashtagID, Erstellungszeitpunkt, "
							+ "HashtagText FROM Hashtag ORDER BY HashtagText");

			// Fuer jeden Eintrag im Suchergebnis wird nun ein Customer-Objekt
			// erstellt.
			while (rs.next()) {
				Hashtag h = new Hashtag();
				h.setID(rs.getInt("HashtagID"));
				h.setErstellungszeitpunkt(rs.getDate("Erstellungszeitpunkt"));
				h.setHashtagtext(rs.getString("HashtagText"));

				// Hinzufuegen des neuen Objekts zum Ergebnisvektor
				result.addElement(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Ergebnisvektor zurueckgeben
		return result;
	}

	public Vector<Hashtag> hashtagInFeldHinzufuegen() {
		// TODO Auto-generated method stub
		Connection con = DBConnection.connection();
		Vector<Hashtag> result = new Vector<Hashtag>();

		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt
					.executeQuery("SELECT HashtagID, Hashtagtext Erstellungszeitpunkt"
							+ "FROM Hashtag");
			while (rs.next()) {
				Hashtag h = new Hashtag();
				h.setID(rs.getInt("HashtagID"));
				h.setHashtagtext(rs.getString("Hashtagtext"));
				h.setErstellungszeitpunkt(rs.getDate("Erstellungszeitpunkt"));

				result.add(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
}
