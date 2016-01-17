package de.hdm.itprojekt.messenger.shared;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.itprojekt.messenger.shared.bo.Abonnement;
import de.hdm.itprojekt.messenger.shared.bo.Hashtag;
import de.hdm.itprojekt.messenger.shared.bo.HashtagAbonnement;
import de.hdm.itprojekt.messenger.shared.bo.Nachricht;
import de.hdm.itprojekt.messenger.shared.bo.Nutzer;
import de.hdm.itprojekt.messenger.shared.bo.NutzerAbonnement;
import de.hdm.itprojekt.messenger.shared.bo.Unterhaltung;

public interface MessengerAdministrationAsync {

	void bearbeiteNachricht(Nachricht nachricht, AsyncCallback<Nachricht> callback);

	void erstelleHashtag(Hashtag hashtag, AsyncCallback<Hashtag> callback);

	void erstelleHashtagAbonnement(HashtagAbonnement String, AsyncCallback<HashtagAbonnement> callback);

	void erstelleNachricht(Nachricht nachricht, AsyncCallback<Nachricht> callback);

	void erstelleNutzerAbonnement(NutzerAbonnement String, AsyncCallback<Abonnement> callback);

	void erstelleUnterhaltung(ArrayList<Nutzer> teilnehmer, AsyncCallback<Unterhaltung> callback);

	void getAllNutzer(AsyncCallback<Vector<Nutzer>> callback);

	void getHashtagByID(int id, AsyncCallback<Hashtag> callback);

	void getHashtagByName(String name, AsyncCallback<Vector<Hashtag>> callback);

	void getNutzerByID(int id, AsyncCallback<Nutzer> callback);

	void getNutzerByName(String name, AsyncCallback<Vector<Nutzer>> callback);

	void getUnterhaltungByID(int id, AsyncCallback<Unterhaltung> callback);

	void init(AsyncCallback<Void> callback);

	void loescheHashtag(Hashtag hashtag, AsyncCallback<Void> callback);

	void loescheHashtagAbonnement(Abonnement abonnement, AsyncCallback<Void> callback);

	void loescheNachricht(Nachricht nachricht, AsyncCallback<Void> callback);

	void loescheNutzer(Nutzer nutzer, AsyncCallback<Void> callback);

	void loescheNutzerAbonnement(Abonnement abonnement, AsyncCallback<Void> callback);

	void loescheUnterhaltung(Unterhaltung unterhaltung, AsyncCallback<Void> callback);

	void login(AsyncCallback<Void> callback);

	void logout(AsyncCallback<Void> callback);

	void nachrichtSenden(Nachricht nachricht, AsyncCallback<Void> callback);

	void nutzerAnlegen(String email, String vorname, String nachname, AsyncCallback<Nutzer> callback);

	void teilnehmerEntfernen(Nutzer teilnehmer, AsyncCallback<Void> callback);

	void teilnehmerHinzufuegen(Nachricht nachricht, AsyncCallback<Vector<Nutzer>> callback);

	void getNutzerCollection(AsyncCallback<Collection<String>> callback);
	
	void getAllHashtags(AsyncCallback<Vector<Hashtag>> callback);

	void getHashtagCollection(AsyncCallback<Collection<String>> callback);

	void hashtagHinzufuegen(AsyncCallback<Vector<Hashtag>> callback);

}
