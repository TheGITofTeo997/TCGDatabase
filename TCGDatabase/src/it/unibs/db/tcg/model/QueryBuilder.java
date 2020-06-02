package it.unibs.db.tcg.model;

public class QueryBuilder {
	
	protected static String GET_USER_ATTRIBUTES (String nickname) {
		return "SELECT *" + 
				" FROM Utente AS U" + 
				" WHERE U.Nickname = " + "'" + nickname + "'";
	}
	
	protected static String GET_USER_COLLECTIONS(String nickname) {
		return "SELECT Nome_Collezione" +
		" FROM POSSIEDE AS P" +
		" WHERE P.Nickname = " + "'" + nickname + "'";
	}
	
	//da aggiungere a lista query
	protected static String GET_USER_COLLECTION_ABBR_EXPANSION(String nickname, String collezione) {
		return " SELECT Abbreviazione" +
		" FROM POSSIEDE, COMPOSTA, CARTA, ESPANSIONE " +
		" WHERE POSSIEDE.Nickname = " + "'" + nickname + "'" + " AND COMPOSTA.Nome_Collezione = " + "'" + collezione + "'" +
			" AND COMPOSTA.N_Carta = CARTA.Numero AND CARTA.Abbr_Espansione = ESPANSIONE.Abbreviazione";
	}
	
	//da modificare in lista query
	protected static String GET_USER_COLLECTION_EXPANSION_CARDS(String nickname, String collezione, String abbr_esp) {
		return " SELECT Nome_Carta, Immagine" +
		" FROM POSSIEDE, COMPOSTA, CARTA, ESPANSIONE " +
		" WHERE POSSIEDE.Nickname =" +"'" + nickname + "AND COMPOSTA.Nome_Collezione = " + "'" + collezione + "'" +
			"AND CARTA.Abbr_Espansione = " + "'" + abbr_esp + "'";
	}
		
}