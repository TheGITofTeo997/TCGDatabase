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
		return "SELECT Composta.Abbr_Espansione, Numero, Nome_Carta, Immagine " + 
				" FROM Possiede JOIN Composta ON Possiede.Nome_Collezione = Composta.Nome_Collezione JOIN Carta ON Composta.N_Carta = Carta.Numero " + 
				" WHERE Possiede.Nickname = '" + nickname + "' AND Possiede.Nome_Collezione = '" + collectionName +"' ORDER BY Abbr_Espansione, Numero";

	}
	
	protected static String GET_CARD(int number, String abbr_exp) {
		return "SELECT *" +
				" FROM Carta " +
				" WHERE Carta.Numero = "+ "'" + number + "'" + "AND Carta.Abbr_Espansione = " + "'" + abbr_exp + "'";

	}
	
	protected static String GET_USER_TOTAL_CARDS_VALUE(String nickname) {
		return "SELECT sum(Valore) " + 
				" FROM Possiede JOIN Composta ON Possiede.Nome_Collezione = Composta.Nome_Collezione JOIN Carta ON Composta.N_Carta = Carta.Numero" + 
				" WHERE Possiede.Nickname = " + "'" + nickname + "'";
	}
	
	protected static String UPDATE_USERNAME(String nickname, String newName) {
		return "UPDATE Utente " +
				"SET Nome_Utente = " + "'" + newName + "'" +
				 "WHERE Nickname = "+ "'" + nickname + "'";
	}
	
	protected static String UPDATE_MAIL(String nickname, String newMail) {
		return "UPDATE Utente " +
				"SET Mail = " + "'" + newMail + "'" +
				 "WHERE Nickname = "+ "'" + nickname + "'";
	}
	
	protected static String GET_CARDS_BY_NAME(String name) {
		return "SELECT Nome_Carta, Immagine, Abbr_Espansione, Numero" + 
				" FROM Carta " + 
				" WHERE Carta.Nome_Carta LIKE '" + name + "%'";
	}
	
	protected static String GET_CARDS_BY_RARITY(String rarity) {
		return "SELECT Nome_Carta, Immagine, Abbr_Espansione, Numero" + 
				" FROM Carta" + 
				" WHERE Carta.Rarita = '" + rarity + "'";
	}
	
	protected static String GET_CARDS_BY_ILLUSTRATOR(String illustrator) {
		return "SELECT Nome_Carta, Immagine, Abbr_Espansione, Numero" + 
				" FROM Carta" + 
				" WHERE Carta.Illustratore LIKE '" + illustrator + "%'";
	}
	
	protected static String GET_CARDS_BY_ECONOMIC_VALUE(int minValue, int maxValue) {
		return "SELECT Nome_Carta, Immagine, Abbr_Espansione, Numero" + 
				" FROM Carta" + 
				" WHERE Carta.Valore >= '" + minValue + "' AND Carta.Valore <= '"+  maxValue +"'";
	}
	
	protected static String GET_CARDS_BY_ENERGY_TYPE(String energyType) {
		return "SELECT Nome_Carta, Immagine, Abbr_Espansione, Numero" + 
				" FROM Carta" + 
				" WHERE Carta.Tipo_Energia = '" + energyType + "'";
	}
	
	protected static String GET_CARDS_BY_PS(int minPS, int maxPS) {
		return "SELECT Nome_Carta, Immagine, Abbr_Espansione, Numero" + 
				" FROM Carta" + 
				" WHERE Carta.PS >= '" + minPS + "' AND Carta.PS <= '" + maxPS + "'";
	}
	
	protected static String GET_CARDS_TYPE(int num) {
		return "SELECT Nome_Carta, Immagine, Abbr_Espansione, Numero" + 
				" FROM Carta" + 
				" WHERE Carta.SEL_Carta = '" + num + "'";
	}
	
	protected static String GET_CARDS_BY_EXP(String exp) {
		return "SELECT Nome_Carta, Immagine, Abbr_Espansione, Numero" + 
				" FROM Carta" + 
				" WHERE Carta.Abbr_Espansione = '" + exp + "'";

	}
	
	protected static String GET_USERS_BY_NAME(String name) {
		return "SELECT *" +
				" FROM Utente" +
				" WHERE Utente.Nome_Utente LIKE '" + name + "%'";
	}
		

}