package it.unibs.db.tcg.model;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ModelGod {
	
	private Connector connector = new Connector("jdbc:mysql://192.168.1.124:3306/TEST_MIKE", "root", "R2mSDzoz"); 
	
	public ModelGod() {
		connector.openConnection();
	}
	
	
	public boolean isUserExistant(String nickname) {
		ResultSet set = connector.executeQuery(QueryBuilder.GET_USER_ATTRIBUTES(nickname));
		try (set) {
			if(set.next()==false)
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	
	
	
	

}
