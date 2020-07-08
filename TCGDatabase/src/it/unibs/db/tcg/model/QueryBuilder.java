package it.unibs.db.tcg.model;

public class QueryBuilder {

	protected static String GET_USER_ATTRIBUTES = "SELECT * FROM utente AS U WHERE U.Nickname = ?";

	protected static String GET_USER_COLLECTION = "SELECT Nome_Collezione FROM possiede AS P WHERE P.Nickname = ? AND P.Nome_Collezione = ?";

	protected static String GET_USER_COLLECTIONS = "SELECT Nome_Collezione FROM possiede AS P WHERE P.Nickname = ?";

	protected static String IS_THERE_CARD_IN_COLLECTION = "SELECT *"
			+ " FROM composta JOIN possiede on composta.Nome_Collezione = possiede.Nome_Collezione"
			+ " WHERE possiede.Nickname = ? AND composta.Nome_Collezione = ?"
			+ " AND composta.N_Carta = ? AND composta.Abbr_Espansione = ?";

	protected static String GET_COLLECTION_CARDS = "SELECT carta.Abbr_Espansione, Numero, Nome_Carta, Immagine FROM possiede JOIN composta ON possiede.Nome_Collezione = composta.Nome_Collezione JOIN carta ON composta.N_Carta = carta.Numero WHERE possiede.Nickname = ? AND possiede.Nome_Collezione = ? ORDER BY Abbr_Espansione, Numero";

	protected static String GET_RANDOM_CARD = "SELECT carta.Immagine FROM carta" + " ORDER BY RAND()" + " LIMIT 1";

	protected static String DELETE_CARD_FROM_COLLECTION = "DELETE FROM composta WHERE Nome_Collezione = ? AND N_Carta = ? AND Abbr_Espansione = ?";

	protected static String DELETE_COLLECTION_POSSIEDE_TABLE = "DELETE FROM possiede WHERE possiede.Nickname = ? AND possiede.Nome_Collezione = ? ";

	protected static String DELETE_COLLECTION_COMPOSTA_TABLE = "DELETE FROM composta WHERE composta.Nickname = ? AND composta.Nome_Collezione = ?";

	protected static String DELETE_COLLECTION_COLLECTION_TABLE = "DELETE FROM collezione WHERE collezione.Nickname = ? AND collezione.Nome_Collezione = ?";

	protected static String GET_PUBLIC_USER_COLLECTIONS = " SELECT possiede.Nome_Collezione"
			+ " FROM possiede JOIN collezione ON possiede.Nome_Collezione = collezione.Nome_Collezione"
			+ " WHERE possiede.Nickname = ? AND collezione.Visibile = 1";

	protected static String GET_CARD = "SELECT * FROM carta WHERE carta.Numero = ? AND carta.Abbr_Espansione = ?";

	protected static String GET_MOSSE = "SELECT conosce.Nome_Mossa FROM conosce WHERE conosce.N_Carta = ? AND conosce.Abbr_Espansione = ?";

	protected static String GET_MOSSA_BY_NAME = "SELECT * FROM mossa WHERE mossa.Nome_Mossa = ?";

	protected static String GET_USER_TOTAL_CARDS_VALUE = "SELECT sum(Valore) "
			+ " FROM possiede JOIN composta ON possiede.Nome_Collezione = composta.Nome_Collezione JOIN carta ON composta.N_Carta = carta.Numero"
			+ " WHERE possiede.Nickname = ?";

	protected static String UPDATE_USERNAME = "UPDATE utente " + "SET Nome_Utente = ?" + " WHERE Nickname = ?";

	protected static String UPDATE_MAIL = "UPDATE utente " + "SET Mail = ? WHERE Nickname = ?";

	protected static String UPDATE_AVATAR = "UPDATE utente " + "SET Avatar = ? WHERE Nickname = ?";

	protected static String UPDATE_COLLECTION_NAME_COLLEZIONE_TABLE = "UPDATE collezione "
			+ "SET Nome_Collezione = ? WHERE Nickname = ? AND Nome_Collezione = ?";

	protected static String UPDATE_COLLECTION_NAME_POSSIEDE_TABLE = "UPDATE possiede "
			+ "SET Nome_Collezione = ? WHERE Nickname = ? AND Nome_Collezione = ?";

	protected static String UPDATE_COLLECTION_NAME_COMPOSTA_TABLE = "UPDATE composta "
			+ "SET Nome_Collezione = ? WHERE Nickname = ? AND Nome_Collezione = ?";

	protected static String UPDATE_COLLECTION_VISIBILITY = "UPDATE collezione " + " SET collezione.Visibile = ? "
			+ " WHERE collezione.Nickname = ? AND collezione.Nome_Collezione = ? ";

	protected static String CREATE_USER = "INSERT INTO utente(utente.Nickname, utente.Nome_Utente, utente.Mail, utente.Avatar , utente.Data_Registrazione)"
			+ "VALUES(?,?,?,?,?)";

	protected static String CREATE_COLLECTION_POSSIEDE_TABLE = "INSERT INTO possiede(possiede.Nickname, possiede.Nome_Collezione)"
			+ "VALUES(?, ?)";

	protected static String INSERT_CARD_IN_COMPOSTA = "INSERT INTO composta(composta.Nickname, composta.Nome_Collezione, composta.N_Carta, composta.Abbr_Espansione)\n"
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
}