package it.unibs.db.tcg.model;

public class QueryBuilder {
	
	protected static String GET_USER_ATTRIBUTES (String nickname) {
		return "SELECT *" + 
				" FROM Utente AS U" + 
				" WHERE U.Nickname = " + "'" + nickname + "'";
	}
	
	
}