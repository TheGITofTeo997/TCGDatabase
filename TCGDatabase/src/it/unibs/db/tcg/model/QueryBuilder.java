package it.unibs.db.tcg.model;

public class QueryBuilder {
	
	protected static String GET_USER_ATTRIBUTES = "SELECT * FROM Utente AS U WHERE U.Nickname = ?";
	
	protected static String GET_USER_COLLECTION = "SELECT Nome_Collezione FROM Possiede AS P WHERE P.Nickname = ? AND P.Nome_Collezione = ?";
			
	protected static String GET_USER_COLLECTIONS = "SELECT Nome_Collezione FROM Possiede AS P WHERE P.Nickname = ?";
	
	protected static String IS_THERE_CARD_IN_COLLECTION = "SELECT *" + 
			" FROM composta JOIN possiede on composta.Nome_Collezione = possiede.Nome_Collezione" + 
			" WHERE possiede.Nickname = ? AND composta.Nome_Collezione = ?" + 
			" AND composta.N_Carta = ? AND composta.Abbr_Espansione = ?";
	
	protected static String GET_COLLECTION_CARDS = "SELECT Carta.Abbr_Espansione, Numero, Nome_Carta, Immagine FROM Possiede JOIN Composta ON Possiede.Nome_Collezione = Composta.Nome_Collezione JOIN Carta ON Composta.N_Carta = Carta.Numero WHERE Possiede.Nickname = ? AND Possiede.Nome_Collezione = ? ORDER BY Abbr_Espansione, Numero";
	
	protected static String GET_RANDOM_CARD = "SELECT Carta.Immagine FROM Carta" + 
			" ORDER BY RAND()" + 
			" LIMIT 1";
	
	protected static String GET_PUBLIC_USER_COLLECTIONS = " SELECT possiede.Nome_Collezione"
			+ " FROM Possiede JOIN Collezione ON possiede.Nome_Collezione = collezione.Nome_Collezione"
			+ " WHERE Possiede.Nickname = ? AND collezione.Visibile = 1";

	protected static String GET_CARD = "SELECT * FROM Carta WHERE Carta.Numero = ? AND Carta.Abbr_Espansione = ?";

	protected static String GET_USER_TOTAL_CARDS_VALUE = "SELECT sum(Valore) "
			+ " FROM Possiede JOIN Composta ON Possiede.Nome_Collezione = Composta.Nome_Collezione JOIN Carta ON Composta.N_Carta = Carta.Numero"
			+ " WHERE Possiede.Nickname = ?";

	protected static String UPDATE_USERNAME = "UPDATE Utente " + "SET Nome_Utente = ?" + " WHERE Nickname = ?";

	protected static String UPDATE_MAIL = "UPDATE Utente " + "SET Mail = ? WHERE Nickname = ?";

	protected static String UPDATE_AVATAR = "UPDATE Utente " + "SET Avatar = ? WHERE Nickname = ?";

	protected static String CREATE_USER = "INSERT INTO Utente(utente.Nickname, utente.Nome_Utente, utente.Mail, utente.Avatar , utente.Data_Registrazione)"
			+ "VALUES(?,?,?,?,?)";
	
	protected static String CREATE_COLLECTION_POSSIEDE_TABLE= "INSERT INTO possiede(possiede.Nickname, possiede.Nome_Collezione)" + 
			"VALUES(?, ?)";
	
	protected static String INSERT_CARD_IN_COMPOSTA = "INSERT INTO composta(composta.Nome_Collezione, composta.N_Carta, composta.Abbr_Espansione)\n" + 
			"VALUES(?, ?, ?)";
	
	protected static String CREATE_COLLECTION_COLLECTION_TABLE = "INSERT INTO collezione(collezione.Nome_Collezione, collezione.Visibile, collezione.Data_Inizio)" + 
			"VALUES(?, ?, ?)";
	
	protected static String GET_CARDS_BY_NAME = "SELECT Nome_Carta, Immagine, Abbr_Espansione, Numero" + " FROM Carta "
			+ " WHERE Carta.Nome_Carta LIKE ?";

	protected static String GET_CARDS_BY_RARITY = "SELECT Nome_Carta, Immagine, Abbr_Espansione, Numero" + " FROM Carta"
			+ " WHERE Carta.Rarita = ?";

	protected static String GET_CARDS_BY_ILLUSTRATOR = "SELECT Nome_Carta, Immagine, Abbr_Espansione, Numero"
			+ " FROM Carta" + " WHERE Carta.Illustratore LIKE ?";

	protected static String GET_CARDS_BY_ECONOMIC_VALUE = "SELECT Nome_Carta, Immagine, Abbr_Espansione, Numero"
			+ " FROM Carta" + " WHERE Carta.Valore >= ? AND Carta.Valore <= ?";

	protected static String GET_CARDS_BY_ENERGY_TYPE = "SELECT Nome_Carta, Immagine, Abbr_Espansione, Numero"
			+ " FROM Carta" + " WHERE Carta.Tipo_Energia = ?";

	protected static String GET_CARDS_BY_PS = "SELECT Nome_Carta, Immagine, Abbr_Espansione, Numero" + " FROM Carta"
			+ " WHERE Carta.PS >= ? AND Carta.PS <= ?";

	protected static String GET_CARDS_TYPE = "SELECT Nome_Carta, Immagine, Abbr_Espansione, Numero" + " FROM Carta"
			+ " WHERE Carta.SEL_Carta = ?";

	protected static String GET_CARDS_BY_EXP = "SELECT Nome_Carta, Immagine, Abbr_Espansione, Numero" + " FROM Carta"
			+ " WHERE Carta.Abbr_Espansione = ?";

	protected static String GET_USERS_BY_NAME = "SELECT *" + " FROM Utente" + " WHERE Utente.Nome_Utente LIKE ?";
}