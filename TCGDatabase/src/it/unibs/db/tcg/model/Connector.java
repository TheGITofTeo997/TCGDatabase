package it.unibs.db.tcg.model;

import java.sql.*;

public class Connector {

	private String url;
	private String user;
	private String password;
	private Connection con;
	private PreparedStatement stmt;

	public Connector(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public void openConnection() {
		try {
			con = DriverManager.getConnection(url, user, password);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		try {
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setIntParameter(int position, int parameter) {
		try {
			stmt.setInt(position, parameter);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setStringParameter(int position, String parameter) {
		try {
			stmt.setString(position, parameter);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void submitParametrizedQuery(String query) {
		try {
			stmt = con.prepareStatement(query);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet executeQuery() {
		ResultSet res = null;
		try {
			res = stmt.executeQuery();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public void execute() {
		try {
			stmt.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeStatement() {
		if (stmt != null)
			try {
				stmt.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
