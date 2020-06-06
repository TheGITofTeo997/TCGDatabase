package it.unibs.db.tcg.model;

public class QueryBuilder {

	protected static String GET_USER_ATTRIBUTES(String nickname) {
		return "SELECT *" + " FROM Utente AS U" + " WHERE U.Nickname = " + "'" + nickname + "'";
	}

	protected static String GET_USER_COLLECTIONS(String nickname) {
		return "SELECT Nome_Collezione" + " FROM Possiede AS P" + " WHERE P.Nickname = " + "'" + nickname + "'";
	}

	protected static String GET_COLLECTION_CARDS(String nickname, String collectionName) {
		return "SELECT Abbr_Espansione, Numero, Nome_Carta, Immagine" + " FROM Possiede, Composta, Carta"
				+ " WHERE Possiede.Nickname = " + "'" + nickname + "'" + " AND Possiede.Nome_Collezione = " + "'"
				+ collectionName + "'" + " ORDER BY Abbr_Espansione, Numero";

	}
	
	protected static String GET_CARD(int number, String abbr_exp) {
		return "SELECT *" +
				" FROM Carta " +
				" WHERE Carta.Numero = "+ "'" + number + "'" + "AND Carta.Abbr_Espansione = " + "'" + abbr_exp + "'";

	}
	
	protected static String GET_USER_TOTAL_CARDS_VALUE(String nickname) {
		return "SELECT sum(Valore) " + 
				" FROM possiede,composta,carta" + 
				" WHERE Possiede.Nickname = " + "'" + nickname + "'";
	}
	
	protected static String UPDATE_USERNAME(String nickname, String newName) {
		return "UPDATE UTENTE " +
				"SET Nome_Utente = " + "'" + newName + "'" +
				 "WHERE Nickname = "+ "'" + nickname + "'";
	}
	
	protected static String UPDATE_MAIL(String nickname, String newMail) {
		return "UPDATE UTENTE " +
				"SET Mail = " + "'" + newMail + "'" +
				 "WHERE Nickname = "+ "'" + nickname + "'";
	}
	

}