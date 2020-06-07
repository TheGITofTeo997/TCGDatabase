package it.unibs.db.tcg.view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

public class HomePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8768541615844025092L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static Color backgroundColor = new Color(252, 186, 3);
	private static Color secondaryBackgroundColor = new Color(156, 156, 156);
	private static Color foregroundColor = Color.WHITE;
	private static Font panelFont = new Font("Serif", 0, 18);

	private List<ActionListener> listenerList = new ArrayList<>();

	private JLabel lblAvatar;
	private JLabel lblNickname;
	private JButton btnSearch;
	private JButton btnViewProfile;
	private JButton btnBack;

	public HomePanel() {
		setLayout(null);
		setBackground(backgroundColor);
		setForeground(foregroundColor);
		setFont(panelFont);

		lblAvatar = new JLabel("");
		lblAvatar.setBounds(10, 10, WIDTH / 4 - WIDTH / 40, 200);
		ImageIcon icon = new ImageIcon("resources//iLTd4oI.png");
		Image image = icon.getImage();
		image = image.getScaledInstance(lblAvatar.getWidth(), lblAvatar.getHeight(), Image.SCALE_SMOOTH);
		icon = new ImageIcon(image);
		lblAvatar.setIcon(icon);
		add(lblAvatar);

		btnViewProfile = new JButton("Profilo");
		btnViewProfile.setBounds(10, 220, WIDTH / 4 - WIDTH / 40, 30);
		btnViewProfile.setFont(panelFont);
		add(btnViewProfile);

		lblNickname = new JLabel("Nickname");
		lblNickname.setForeground(foregroundColor);
		lblNickname.setBounds(10, 250, WIDTH / 4 - WIDTH / 40, 50);
		lblNickname.setFont(panelFont.deriveFont(Font.BOLD));
		add(lblNickname);

		JLabel lblProfile = new JLabel("");
		lblProfile.setBounds(0, 0, WIDTH / 4, HEIGHT);
		lblProfile.setOpaque(true);
		lblProfile.setBackground(secondaryBackgroundColor);
		add(lblProfile);

		btnSearch = new JButton("Cerca");
		btnSearch.setBounds(WIDTH / 4, 0, 600, 30);
		btnSearch.setBackground(new Color(192, 192, 192));
		btnSearch.setForeground(foregroundColor);
		btnSearch.setFont(panelFont.deriveFont(Font.BOLD));
		add(btnSearch);

		btnBack = new JButton("Back");
		btnBack.setBounds(650, 450, 90, 50);
		btnBack.setFont(panelFont);
		add(btnBack);

	}

	public void setNickname(String nickname) {
		lblNickname.setText(nickname);
	}

	public void setAvatar(ImageIcon avatar) {
		Image image = avatar.getImage();
		image = image.getScaledInstance(lblAvatar.getWidth(), lblAvatar.getHeight(), Image.SCALE_SMOOTH);
		avatar = new ImageIcon(image);
		lblAvatar.setIcon(avatar);
	}

	public int showConfirmDialog() {
		JOptionPane confirm = new JOptionPane();
		confirm.setBounds(getBounds());
		return confirm.showConfirmDialog(this,
				"Attenzione, confermando verrai sloggato dal tuo account. Vuoi procedere?", "Question",
				JOptionPane.YES_NO_OPTION);
	}

	public void addActionListener(ActionListener a) {
		listenerList.add(a);
	}

	public void addAccountListener(ActionListener a) {
		btnViewProfile.addActionListener(a);

	}

	public void addSearchListener(ActionListener a) {
		btnSearch.addActionListener(a);
	}

	public void addBackListener(ActionListener a) {
		btnBack.addActionListener(a);
	}

}
