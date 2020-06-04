package it.unibs.db.tcg.model;

public class QueryBuilder {
	
	protected static String GET_USER_ATTRIBUTES(String nickname) {
		return "SELECT *" + 
				" FROM Utente AS U" + 
				" WHERE U.Nickname = " + "'" + nickname + "'";
	}
	
	protected static String GET_USER_COLLECTIONS(String nickname) {
		return "SELECT Nome_Collezione" +
		" FROM Possiede AS P" +
		" WHERE P.Nickname = " + "'" + nickname + "'";
	}
	
	protected static String GET_COLLECTION_CARDS(String nickname, String collectionName) {
		return "SELECT Abbr_Espansione, Numero, Nome_Carta, Immagine" +
				" FROM Possiede, Composta, Carta" +
				" WHERE Possiede.Nickname = " + "'" + nickname + "'" + " AND Possiede.Nome_Collezione = " + "'" + collectionName + "'" +
				" ORDER BY Abbr_Espansione, Numero";

	}
	
	
		
}