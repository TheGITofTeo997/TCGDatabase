package it.unibs.db.tcg.model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.List;
import java.sql.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ModelGod {

	private Connector connector = new Connector("jdbc:mysql://192.168.1.124:3306/TEST_MIKE", "root", "R2mSDzoz");

	public ModelGod() {
		connector.openConnection();
	}
	
	//close ResultSet???
	public Utente getUser(String nickname) {
		ResultSet set = connector.executeQuery(QueryBuilder.GET_USER_ATTRIBUTES(nickname));
		String _nickname = null;
		String _name = null;
		String _mail = null;
		ImageIcon _avatar = null;
		Date _dataRegistrazione = null;
		try {
			while (set.next()) {
				_nickname = set.getString("Nickname");
				_name = set.getString("Nome_Utente");
				_mail = set.getString("Mail");
				Blob b = set.getBlob(4);
				byte[] imageByte = b.getBytes(1, (int) b.length());
				InputStream is = new ByteArrayInputStream(imageByte);
				BufferedImage imag = ImageIO.read(is);
				Image i = imag;
				_avatar = new ImageIcon(i);
				_dataRegistrazione = set.getDate("Data_Registrazione");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		ArrayList<String> collections = new ArrayList<String>();
		set = connector.executeQuery(QueryBuilder.GET_USER_COLLECTIONS(_nickname));
		try {
			while (set.next()) {
				collections.add(set.getString("Nome_Collezione"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Utente user = new Utente();
		user.setNickname(_nickname);
		user.setNomeUtente(_name);
		user.setMail(_mail);
		user.setAvatar(_avatar);
		user.setDataRegistrazione(_dataRegistrazione);
		user.setCollections(collections);
		return user;
	}

	public boolean isUserExistant(String nickname) {
		ResultSet set = connector.executeQuery(QueryBuilder.GET_USER_ATTRIBUTES(nickname));
		try (set) {
			if (set.next() == false)
				return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
}
