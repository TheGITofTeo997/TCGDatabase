package it.unibs.db.tcg.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisitorAccountPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4259378117098818102L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static Color backgroundColor;
	private static Color secondaryBackgroundColor;
	private static Color foregroundColor;
	private Font panelFont;

	private JPanel informationPanel;
	private JLabel lblAvatar;
	private JLabel lblNickname;
	private JLabel lblName;
	private JLabel lblMail;
	private JLabel lblRegistrationDate;
	private JButton btnBack;
	private JList<String> list;
	private JLabel lblTotalValue;

	private JPanel collectionsPanel;
	private JLabel lblAvatarSmall;
	private JLabel lblNickname2;

	public VisitorAccountPanel() {
		setLayout(null);
		secondaryBackgroundColor = Preferences.getSecondaryBackgroundColor();
		backgroundColor = Preferences.getBackgroundColor();
		setBackground(backgroundColor);
		foregroundColor = Preferences.getForegroundColor();
		setForeground(foregroundColor);
		panelFont = Preferences.getFont();
		setFont(panelFont);

		JPanel menuPanel = new JPanel();
		menuPanel.setBounds(0, 0, WIDTH, 30);
		add(menuPanel);
		menuPanel.setFocusable(false);
		menuPanel.setLayout(null);

		JButton btnInfo = new JButton("Informazioni");
		btnInfo.setBounds(0, 0, WIDTH / 2, 30);
		btnInfo.setBackground(backgroundColor);
		btnInfo.setForeground(foregroundColor);
		btnInfo.setFont(panelFont.deriveFont(Font.BOLD));
		menuPanel.add(btnInfo);

		JButton btnCollections = new JButton("Collezioni");
		btnCollections.setBounds(WIDTH / 2, 0, WIDTH / 2, 30);
		btnCollections.setBorderPainted(false);
		btnCollections.setFont(panelFont);
		btnCollections.setBackground(secondaryBackgroundColor);
		btnCollections.setForeground(foregroundColor);
		menuPanel.add(btnCollections);

		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnInfo.setBackground(backgroundColor);
				btnCollections.setBackground(secondaryBackgroundColor);
				btnInfo.setFont(panelFont.deriveFont(Font.BOLD));
				btnCollections.setFont(panelFont);
				collectionsPanel.setFocusable(false);
				collectionsPanel.setVisible(false);
				informationPanel.setFocusable(true);
				informationPanel.setVisible(true);
			}
		});

		btnCollections.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnInfo.setBackground(secondaryBackgroundColor);
				btnCollections.setBackground(backgroundColor);
				btnInfo.setFont(panelFont);
				btnCollections.setFont(panelFont.deriveFont(Font.BOLD));
				informationPanel.setFocusable(false);
				informationPanel.setVisible(false);
				collectionsPanel.setFocusable(true);
				collectionsPanel.setVisible(true);
			}
		});

		informationPanel = new JPanel();
		informationPanel.setBounds(0, 30, WIDTH, HEIGHT - 30);
		informationPanel.setLayout(null);
		informationPanel.setBackground(null);
		informationPanel.setFocusable(true);
		add(informationPanel);

		lblAvatar = new JLabel("");
		lblAvatar.setBounds(5, 5, 250, 300);
		ImageIcon icon = new ImageIcon("resources//default_avatar.jpeg");
		Image image = icon.getImage();
		icon = new ImageIcon(image);
		image = image.getScaledInstance(lblAvatar.getWidth(), lblAvatar.getHeight(), Image.SCALE_SMOOTH);
		lblAvatar.setIcon(icon);
		informationPanel.add(lblAvatar);

		lblNickname = new JLabel("Nickname");
		lblNickname.setForeground(foregroundColor);
		lblNickname.setBounds(400, 5, 400, 50);
		lblNickname.setFont(panelFont.deriveFont(Font.BOLD));
		informationPanel.add(lblNickname);

		lblName = new JLabel("Nome");
		lblName.setForeground(foregroundColor);
		lblName.setFont(panelFont);
		lblName.setBounds(400, 60, 400, 50);
		informationPanel.add(lblName);

		lblMail = new JLabel("Mail");
		lblMail.setForeground(foregroundColor);
		lblMail.setFont(panelFont);
		lblMail.setBounds(400, 115, 400, 50);
		informationPanel.add(lblMail);

		lblRegistrationDate = new JLabel("Data");
		lblRegistrationDate.setForeground(foregroundColor);
		lblRegistrationDate.setFont(panelFont);
		lblRegistrationDate.setBounds(400, 170, 400, 50);
		informationPanel.add(lblRegistrationDate);

		JLabel lblfirst = new JLabel("Nome ");
		lblfirst.setFont(panelFont);
		lblfirst.setForeground(foregroundColor);
		lblfirst.setBounds(290, 60, 100, 50);
		informationPanel.add(lblfirst);

		JLabel lblsecond = new JLabel("Mail ");
		lblsecond.setFont(panelFont);
		lblsecond.setForeground(foregroundColor);
		lblsecond.setBounds(290, 115, 100, 50);
		informationPanel.add(lblsecond);

		JLabel lblthird = new JLabel("Registrato il");
		lblthird.setFont(panelFont);
		lblthird.setForeground(foregroundColor);
		lblthird.setBounds(290, 170, 100, 50);
		informationPanel.add(lblthird);

		collectionsPanel = new JPanel();
		collectionsPanel.setBounds(0, 30, WIDTH, HEIGHT - 30);
		collectionsPanel.setLayout(null);
		collectionsPanel.setBackground(null);
		collectionsPanel.setFocusable(false);
		collectionsPanel.setVisible(false);
		add(collectionsPanel);

		lblAvatarSmall = new JLabel("");
		lblAvatarSmall.setBounds(5, 5, 150, 200);
		ImageIcon icon2 = new ImageIcon("resources//iLTd4oI.png");
		Image image2 = icon2.getImage();
		icon2 = new ImageIcon(image2);
		image2 = image.getScaledInstance(lblAvatarSmall.getWidth(), lblAvatarSmall.getHeight(), Image.SCALE_SMOOTH);
		lblAvatarSmall.setIcon(icon2);
		collectionsPanel.add(lblAvatarSmall);

		lblNickname2 = new JLabel("Nickname");
		lblNickname2.setForeground(foregroundColor);
		lblNickname2.setBounds(5, 200, 150, 50);
		lblNickname2.setFont(panelFont.deriveFont(Font.BOLD));
		collectionsPanel.add(lblNickname2);

		JLabel lblcollection = new JLabel("Collezioni");
		lblcollection.setForeground(foregroundColor);
		lblcollection.setBounds(300, 5, 400, 50);
		lblcollection.setFont(panelFont.deriveFont(Font.BOLD));
		collectionsPanel.add(lblcollection);

		btnBack = new JButton("Back");
		btnBack.setBounds(650, 450, 90, 50);
		btnBack.setFont(panelFont);
		informationPanel.add(btnBack);

		JLabel lblfourth = new JLabel("Valore tot.");
		lblfourth.setForeground(Color.WHITE);
		lblfourth.setFont(panelFont);
		lblfourth.setBounds(290, 230, 100, 50);
		informationPanel.add(lblfourth);

		lblTotalValue = new JLabel("0");
		lblTotalValue.setForeground(Color.WHITE);
		lblTotalValue.setFont(new Font("Serif", Font.PLAIN, 18));
		lblTotalValue.setBounds(400, 230, 400, 50);
		informationPanel.add(lblTotalValue);

	}

	public void setNickname(String nickname) {
		lblNickname.setText(nickname);
		lblNickname2.setText(nickname);
	}

	public void setUserName(String name) {
		lblName.setText(name);
	}

	public void setMail(String mail) {
		lblMail.setText(mail);
	}

	public void setAvatar(ImageIcon avatar) {
		Image image = avatar.getImage();
		image = image.getScaledInstance(lblAvatar.getWidth(), lblAvatar.getHeight(), Image.SCALE_SMOOTH);
		avatar = new ImageIcon(image);
		lblAvatar.setIcon(avatar);

		image = image.getScaledInstance(lblAvatarSmall.getWidth(), lblAvatarSmall.getHeight(), Image.SCALE_SMOOTH);
		avatar = new ImageIcon(image);
		lblAvatarSmall.setIcon(avatar);
	}

	public void setRegistrationDate(String date) {
		lblRegistrationDate.setText(date);
	}

	public void setCollections(DefaultListModel<String> collectionsName) {
		list = new JList(collectionsName);
		list.setBounds(165, 50, 600, 350);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBackground(null);
		list.setFont(panelFont);
		list.setForeground(foregroundColor);
		list.setFixedCellWidth(list.getWidth());
		list.setBorder(new LineBorder(Color.BLACK));
		collectionsPanel.add(list);
	}

	public void setTotalValue(double value) {
		lblTotalValue.setText(String.valueOf(value) + " €");
	}

	public int getListSelectedIndex() {
		return list.getSelectedIndex();
	}

	public void addCollectionListener(ListSelectionListener a) {
		list.addListSelectionListener(a);
	}

	public void addBackListener(ActionListener a) {
		btnBack.addActionListener(a);
	}
}