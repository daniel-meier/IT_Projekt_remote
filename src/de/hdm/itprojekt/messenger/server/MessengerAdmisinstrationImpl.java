package de.hdm.itprojekt.messenger.server;



	import java.util.ArrayList;

	import de.hdm.itprojekt.messenger.shared.bo.Abonnement;
	import de.hdm.itprojekt.messenger.shared.bo.Hashtag;
	import de.hdm.itprojekt.messenger.shared.bo.Nachricht;
	import de.hdm.itprojekt.messenger.shared.bo.Nutzer;
	import de.hdm.itprojekt.messenger.shared.bo.Unterhaltung;

	public class MessengerAdmisinstrationImpl {
	
		/** Methode zum einloggen 
		 * 
		 */
		public void login (){
			
		}
		
		/** Erstelle ein HahstagAbonnement
		 * 
		 */
		public Hashtag erstelleHashtagAbonnement (String hashtag){
		 return Abonnement;
		}
		
		/** Eine Nachricht bearbeiten 
		 * 
		 */
		public Nachricht bearbeiteNachricht(String text){
			return Nachricht;
		}
		
		/** Einen Teilnehmer hinzufügen
		 * 
		 */
		public Nachricht teilnehmerHinzufügen (ArrayList<Nutzer> teilnehmer){
			return Nachricht;
		}

		/** Einen Teilnehmer entfernen
		 * 
		 */
		public void teilnehmerEntfernen (ArrayList<Nutzer> teilnehmer){
			
		}
		
		/** Eine Unterhaltung löschen 
		 * 
		 */
		public void loescheUnterhaltung(Unterhaltung unterhaltung){
			
		}
		
		/** Ein HashtagAbonnement löschen 
		 * 
		 */
		public void loescheHashtagAbonnement(Abonnement abonnement){
			
		}
		
		/** Ein init anlegen
		 * 
		 */
		public void init(){
			
		}
		
		/** Einen Nutzer beim Namen ausgeben lassen 
		 * 
		 */
		public Nutzer getNutzerByName (String name){
			return ArrayList<Nutzer>;
		}
		
		/** Ausloggen
		 * 
		 */
		public void logout(){
			
		}
		
		/** Einen Hashtag beim Namen ausgeben lassen 
		 * 
		 */
		public Hashtag getHashtagByName (String name){
			return Hashtag;
		}
		
		/** Einen Nutzer bei der ID ausgeben lassen
		 *  
		 */
		public Nutzer getNutzerByID (int id){
			return Nutzer;
		}
		
		/**Eine Unterhaltung erstellen
		 * 
		 * @return Unterhaltung
		 */
		public Unterhaltung erstelleUnterhaltung(ArrayList<Nutzer> teilnehmer){
			Unterhaltung u = new Unterhaltung();
			return u;
		}
		
		/**NutzerAbonnement loeschen
		 * 
		 * @param abonnement
		 */
		public void loescheNutzerAbonnement(Abonnement abonnement){
			
		}
		
		/**Nutzer anlegen
		 * 
		 * @param email
		 * @param vorname
		 * @param nachname
		 * @return Nutzer
		 */
		public Nutzer nutzerAnlegen(String email, String vorname, String nachname){
			Nutzer n = new Nutzer();
			return n;
		}
		
		/**Unterhaltung nach ID ausgeben
		 * 
		 * @param id
		 * @return Unterhaltung
		 */
		public Unterhaltung getUnterhaltungByID(int id){
			
		}
		
		/**Nachricht erstellen
		 * 
		 * @param nachricht
		 * @return Nachricht
		 */
		public Nachricht erstelleNachricht(String nachricht){
			
		}
		
		/**Nachricht loeschen
		 * 
		 * @param nachricht
		 */
		public void loescheNachricht(Nachricht nachricht){
			
		}
		
		/**NutzerAbonnement erstellen
		 * 
		 * @param nutzer
		 * @return Abonnement
		 */
		public Abonnement erstelleNutzerAbonnement(Nutzer nutzer){
			
		}
		
		/**Hashtag erstellen
		 * 
		 * @param hashtag
		 * @return Hashtag
		 */
		public Hashtag erstelleHashtag(String hashtag){
			
		}
		
		/**Nutzer loeschen
		 * 
		 * @param nutzer
		 */
		public void loescheNutzer(Nutzer nutzer){
			
		}
		
		/**Hashtag loeschen
		 * 
		 * @param hashtag
		 */
		public void loescheHashtag(Hashtag hashtag){
			
		}
		
		/**Alle Nutzer ausgeben
		 * 
		 * @return Nutzer
		 */
		public Nutzer getAllNutzer(){
			return Nutzer;
		}
		
		/**Hashtag nach ID ausgeben
		 * 
		 * @param id
		 * @return Hashtag
		 */
		public Hashtag getHashtagByID(int id){
			
		}
}
