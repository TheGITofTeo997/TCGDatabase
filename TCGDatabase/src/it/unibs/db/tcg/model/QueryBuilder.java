package it.unibs.db.tcg.model;

public class QueryBuilder {

	protected static String GET_USER_ATTRIBUTES = "SELECT * FROM utente AS U WHERE U.Nickname = ?";

	protected static String GET_USER_COLLECTION = "SELECT Nome_Collezione FROM collezione AS C WHERE C.Nickname = ? AND C.Nome_Collezione = ?";

	protected static String GET_USER_COLLECTIONS = "SELECT Nome_Collezione FROM collezione AS C WHERE C.Nickname = ?";

	protected static String IS_THERE_CARD_IN_COLLECTION = "SELECT *"
			+ " FROM composta JOIN collezione on composta.Nome_Collezione = collezione.Nome_Collezione"
			+ " WHERE collezione.Nickname = ? AND composta.Nome_Collezione = ?"
			+ " AND composta.N_Carta = ? AND composta.Abbr_Espansione = ?";

	protected static String GET_COLLECTION_CARDS = "SELECT carta.Abbr_Espansione, Numero, Nome_Carta, Immagine FROM collezione JOIN composta ON collezione.Nome_Collezione = composta.Nome_Collezione JOIN carta ON composta.N_Carta = carta.Numero AND composta.Abbr_Espansione = carta.Abbr_Espansione WHERE collezione.Nickname = ? AND collezione.Nome_Collezione = ? ORDER BY Abbr_Espansione, Numero";

	protected static String GET_RANDOM_CARD = "SELECT carta.Immagine FROM carta" + " ORDER BY RAND()" + " LIMIT 1";

	protected static String DELETE_CARD_FROM_COLLECTION = "DELETE FROM composta WHERE Nome_Collezione = ? AND N_Carta = ? AND Abbr_Espansione = ?";

	protected static String DELETE_COLLECTION_COLLECTION_TABLE = "DELETE FROM collezione WHERE collezione.Nickname = ? AND collezione.Nome_Collezione = ?";

	protected static String GET_PUBLIC_USER_COLLECTIONS = "SELECT Nome_Collezione" + " FROM collezione"
			+ " WHERE Nickname = ? AND Visibile = 1";

	protected static String GET_CARD = "SELECT * FROM carta WHERE carta.Numero = ? AND carta.Abbr_Espansione = ?";

	protected static String GET_MOSSE = "SELECT conosce.Nome_Mossa FROM conosce WHERE conosce.N_Carta = ? AND conosce.Abbr_Espansione = ?";

	protected static String GET_MOSSA_BY_NAME = "SELECT * FROM mossa WHERE mossa.Nome_Mossa = ?";

	protected static String GET_USER_TOTAL_CARDS_VALUE = "SELECT sum(Valore) "
			+ " FROM collezione JOIN composta ON collezione.Nome_Collezione = composta.Nome_Collezione JOIN carta ON composta.N_Carta = carta.Numero"
			+ " WHERE collezione.Nickname = ?";

	protected static String UPDATE_USERNAME = "UPDATE utente " + "SET Nome_Utente = ?" + " WHERE Nickname = ?";

	protected static String UPDATE_MAIL = "UPDATE utente " + "SET Mail = ? WHERE Nickname = ?";

	protected static String UPDATE_AVATAR = "UPDATE utente " + "SET Avatar = ? WHERE Nickname = ?";

	protected static String UPDATE_COLLECTION_NAME_COLLEZIONE_TABLE = "UPDATE collezione "
			+ "SET Nome_Collezione = ? WHERE Nickname = ? AND Nome_Collezione = ?";

	protected static String UPDATE_COLLECTION_VISIBILITY = "UPDATE collezione " + " SET collezione.Visibile = ? "
			+ " WHERE collezione.Nickname = ? AND collezione.Nome_Collezione = ? ";

	protected static String CREATE_USER = "INSERT INTO utente(utente.Nickname, utente.Nome_Utente, utente.Mail, utente.Avatar , utente.Data_Registrazione)"
			+ "VALUES(?,?,?,?,?)";

	protected static String INSERT_CARD_IN_COMPOSTA = "INSERT INTO composta(composta.Nickname, composta.Nome_Collezione, composta.N_Carta, composta.Abbr_Espansione)"
			+ "VALUES(?, ?, ?, ?)";

	protected static String CREATE_COLLECTION_COLLECTION_TABLE = "INSERT INTO collezione(collezione.Nickname, collezione.Nome_Collezione, collezione.Visibile, collezione.Data_Inizio)"
			+ "VALUES(?, ?, ?, ?)";

	protected static String GET_CARDS_BY_NAME = "SELECT Nome_Carta, Immagine, Abbr_Espansione, Numero" + " FROM carta "
			+ " WHERE carta.Nome_Carta LIKE ?";

	protected static String GET_CARDS_BY_RARITY = "SELECT Nome_Carta, Immagine, Abbr_Espansione, Numero" + " FROM carta"
			+ " WHERE carta.Rarita = ?";

	protected static String GET_CARDS_BY_ILLUSTRATOR = "SELECT Nome_Carta, Immagine, Abbr_Espansione, Numero"
			+ " FROM carta" + " WHERE carta.Illustratore LIKE ?";

	protected static String GET_CARDS_BY_ECONOMIC_VALUE = "SELECT Nome_Carta, Immagine, Abbr_Espansione, Numero"
			+ " FROM carta" + " WHERE carta.Valore >= ? AND carta.Valore <= ?";

	protected static String GET_CARDS_BY_ENERGY_TYPE = "SELECT Nome_Carta, Immagine, Abbr_Espansione, Numero"
			+ " FROM carta" + " WHERE carta.Tipo_Energia = ?";

	protected static String GET_CARDS_BY_PS = "SELECT Nome_Carta, Immagine, Abbr_Espansione, Numero" + " FROM carta"
			+ " WHERE carta.PS >= ? AND carta.PS <= ?";

	protected static String GET_CARDS_TYPE = "SELECT Nome_Carta, Immagine, Abbr_Espansione, Numero" + " FROM carta"
			+ " WHERE carta.SEL_Carta = ?";

	protected static String GET_CARDS_BY_EXP = "SELECT Nome_Carta, Immagine, Abbr_Espansione, Numero" + " FROM carta"
			+ " WHERE carta.Abbr_Espansione = ?";

	protected static String GET_USERS_BY_NAME = "SELECT *" + " FROM utente" + " WHERE utente.Nome_Utente LIKE ?";

	protected static String GET_USERS_BY_CARD = "SELECT DISTINCT composta.Nickname"
			+ " FROM composta JOIN collezione ON (composta.Nome_Collezione = collezione.Nome_Collezione AND composta.Nickname = collezione.Nickname) "
			+ " WHERE composta.N_Carta = ? AND composta.Abbr_Espansione = ? AND collezione.Visibile = 1";

	protected static String GET_TOTAL_NUMBER_CARD_COLLECTION = "SELECT COUNT(*)" + " FROM composta"
			+ " WHERE composta.Nickname = ? AND composta.Nome_Collezione = ?";

	protected static String GET_NAME_PRE_STAGE_BY_NUM_AND_ABBR_EXP = "SELECT Stage_precedente" + " FROM evoluzione"
			+ " WHERE Stage_successivo IN ( SELECT Nome_Carta" + " FROM carta"
			+ " WHERE Numero = ? AND Abbr_Espansione = ?)";

	protected static String GET_NAME_NEXT_STAGE_BY_NUM_AND_ABBR_EXP = "SELECT Stage_successivo" + " FROM evoluzione"
			+ " WHERE Stage_precedente IN ( SELECT Nome_Carta" + " FROM carta"
			+ " WHERE Numero = ? AND Abbr_Espansione = ?)";

	protected static String GET_COUNT_OF_CARDS_PER_EXPANSION = "SELECT composta.Abbr_Espansione, espansione.Icona, espansione.Nome_Espansione, COUNT(*)"
			+ " FROM composta JOIN espansione ON composta.Abbr_Espansione = espansione.Abbreviazione "
			+ " WHERE composta.Nickname = ?" + " GROUP BY Abbr_Espansione";

	protected static String GET_COLLECTION_COUNT_OF_CARDS_PER_EXPANSION = "SELECT composta.Abbr_Espansione, espansione.Icona, espansione.Nome_Espansione, COUNT(*)"
			+ " FROM composta JOIN espansione ON composta.Abbr_Espansione = espansione.Abbreviazione"
			+ " WHERE composta.Nickname = ? AND composta.Nome_Collezione = ?" + " GROUP BY Abbr_Espansione";

	protected static String GET_COLLECTION_COUNT_OF_CARDS_PER_RARITY = "SELECT carta.Rarita, COUNT(*)"
			+ " FROM composta JOIN carta ON composta.Abbr_Espansione = carta.Abbr_Espansione AND composta.N_Carta = carta.Numero"
			+ " WHERE composta.Nickname = ? AND composta.Nome_Collezione = ?" + " GROUP BY carta.Rarita";

	protected static String GET_MAX_CARD_VALUE_IN_COLLECTION = "SELECT carta.Nome_Carta, carta.Abbr_Espansione, carta.Valore"
			+ " FROM carta" + " WHERE carta.valore IN (" + " SELECT max(carta.Valore)"
			+ " FROM carta JOIN composta ON carta.Numero = composta.N_Carta AND carta.Abbr_Espansione = composta.Abbr_Espansione"
			+ " WHERE composta.Nickname = ? AND composta.Nome_Collezione = ?)";

	protected static String GET_MIN_CARD_VALUE_IN_COLLECTION = "SELECT carta.Nome_Carta, carta.Abbr_Espansione, carta.Valore"
			+ " FROM carta" + " WHERE carta.valore IN (" + " SELECT min(carta.Valore)"
			+ " FROM carta JOIN composta ON carta.Numero = composta.N_Carta AND carta.Abbr_Espansione = composta.Abbr_Espansione"
			+ " WHERE composta.Nickname = ? AND composta.Nome_Collezione = ?)";

	protected static String GET_AVG_CARD_VALUE_IN_COLLECTION = "SELECT avg(carta.Valore)"
			+ " FROM carta JOIN composta ON carta.Numero = composta.N_Carta AND carta.Abbr_Espansione = composta.Abbr_Espansione"
			+ " WHERE composta.Nickname = ? AND composta.Nome_Collezione = ?";

	protected static String GET_COLLECTION_TOTAL_VALUE = "SELECT sum(carta.Valore)"
			+ " FROM carta JOIN composta ON carta.Numero = composta.N_Carta AND carta.Abbr_Espansione = composta.Abbr_Espansione"
			+ " WHERE composta.Nickname = ? AND composta.Nome_Collezione = ?";

	protected static String GET_COLLECTION_CARD_NUMBER = "SELECT COUNT(*)" + " FROM composta"
			+ " WHERE composta.Nickname = ? AND composta.Nome_Collezione = ?";

	protected static String GET_COLLECTION_START_DATE = "SELECT Data_Inizio" + " FROM collezione"
			+ " WHERE collezione.Nickname = ? AND collezione.Nome_Collezione = ?";

	protected static String IS_COLLECTION_COMPLETE = "SELECT COUNT(*)" + 
			" FROM composta" + 
			" WHERE composta.Nickname = ? AND composta.Nome_Collezione = ? AND ((SELECT COUNT(*)" + 
			"		FROM  (SELECT DISTINCT Abbr_Espansione" + 
			"		FROM composta" + 
			"		WHERE composta.Nickname = ? AND composta.Nome_Collezione = ?) AS P) =" + 
			"			(SELECT COUNT(*)" + 
			"			FROM espansione" + 
			"			WHERE (espansione.Abbreviazione, espansione.N_Carte) IN" + 
			"				(SELECT composta.Abbr_Espansione, COUNT(*)" + 
			"				FROM composta JOIN espansione ON composta.Abbr_Espansione = espansione.Abbreviazione" + 
			"				WHERE composta.Nickname = ? AND composta.Nome_Collezione = ?" + 
			"				GROUP BY Abbr_Espansione)))";
	
	protected static String GET_USER_RANKING_BY_TOTAL_CARDS_VALUE = "SELECT (utente.Nickname) AS Nickname, (utente.Avatar) as Avatar,"
			+ "( SELECT sum(Valore)"
			+ "	FROM collezione JOIN composta ON collezione.Nome_Collezione = composta.Nome_Collezione JOIN carta ON composta.N_Carta = carta.Numero"
			+ "	WHERE collezione.Nickname = utente.Nickname) AS ValoreTotale" + "    FROM utente "
			+ "    ORDER BY ValoreTotale DESC";

	protected static String GET_USER_RANKING_BY_TOTAL_CARDS_NUMBER = "SELECT (utente.Nickname) AS Nickname, (utente.Avatar) as Avatar,"
			+ "			           ( SELECT count(*)"
			+ "				FROM collezione JOIN composta ON collezione.Nome_Collezione = composta.Nome_Collezione JOIN carta ON composta.N_Carta = carta.Numero "
			+ "				WHERE collezione.Nickname = utente.Nickname) AS TotaleCarte" + " FROM utente "
			+ "			    ORDER BY TotaleCarte DESC";

	public static String GET_USER_RANKING_BY_MAX_CARD_VALUE = "SELECT (utente.Nickname) AS Nickname, (utente.Avatar) as Avatar,"
			+ "	 ( SELECT max(Valore) "
			+ "	FROM collezione JOIN composta ON collezione.Nome_Collezione = composta.Nome_Collezione JOIN carta ON composta.N_Carta = carta.Numero"
			+ "	WHERE collezione.Nickname = utente.Nickname) AS ValoreMax    " + " FROM utente "
			+ " ORDER BY ValoreMax DESC";
}