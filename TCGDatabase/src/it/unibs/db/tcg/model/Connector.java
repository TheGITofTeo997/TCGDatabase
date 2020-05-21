package it.unibs.db.tcg.model;

import java.sql.*;

public class Connector {
	
	private String url;
	private String user;
	private String password;
	private Connection con;
	
	public Connector (String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}
	
	public void openConnection() {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		try {
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet executeQuery(String query) {
		ResultSet res = null;
		try {
			Statement stat = con.createStatement();
			res = stat.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public void execute(String query) {
		try {
			Statement stat = con.createStatement();
			stat.execute(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
