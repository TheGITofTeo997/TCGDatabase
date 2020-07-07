package it.unibs.db.tcg.model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setIntParameter(int position, int parameter) {
		try {
			stmt.setInt(position, parameter);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setCurrentDateParameter(int position, Timestamp timestamp) {
		try {
			stmt.setTimestamp(position, timestamp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setImageParameter(int position, ImageIcon imageIcon) {
		try {
			BufferedImage bi = getBufferedImage(imageIcon.getImage());
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try {
				ImageIO.write(bi, "png", baos);
			} catch (IOException e) {
				e.printStackTrace();
			}

			byte[] byteArray = baos.toByteArray();
			stmt.setBytes(position, byteArray);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static BufferedImage getBufferedImage(Image img) {
		if (img instanceof BufferedImage) {
			return (BufferedImage) img;
		}

		BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

		Graphics2D bGr = bimage.createGraphics();
		bGr.drawImage(img, 0, 0, null);
		bGr.dispose();

		// Return the buffered image
		return bimage;
	}

	public void setStringParameter(int position, String parameter) {
		try {
			stmt.setString(position, parameter);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void submitParametrizedQuery(String query) {
		try {
			stmt = con.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet executeQuery() {
		ResultSet res = null;
		try {
			res = stmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public void execute() {
		try {
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeStatement() {
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public boolean isReachable() {
		try {

			con = DriverManager.getConnection(url, user, password);
			// wait for 3 seconds and then stop
			DriverManager.setLoginTimeout(3);

			if (con == null) {
				return false;

			} else {
				con.close();
				return true;
			}

		} catch (Exception ex) {
			return false;
		}
	}

}
