package it.unibs.db.tcg.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountPanel extends JPanel{
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static Color backgroundColor = new Color(252, 186, 3);
	private static Color secondaryBackgroundColor = new Color(156, 156, 156);
	private static Color foregroundColor = Color.WHITE;
	private static Font panelFont = new Font("Serif", 0, 18);

	private JPanel informationPanel;
	private JLabel lblAvatar;
	private JLabel lblNickname;
	private JLabel lblName;
	private JLabel lblMail;
	private JLabel lblRegistrationDate;
	private JButton btnEdit;
	
	private JPanel collectionsPanel;
	private JLabel lblAvatarSmall;
	private JLabel lblNickname2;
	
	public AccountPanel() {
		setLayout(null);
		setBackground(backgroundColor);
		setForeground(foregroundColor);
		setFont(panelFont);
				
		JPanel menuPanel = new JPanel();
		menuPanel.setBounds(0, 0, WIDTH, 30 );
		add(menuPanel);
		menuPanel.setLayout(null);
	
		JButton btnInfo = new JButton("Informazioni");
		btnInfo.setBounds(0, 0, WIDTH/2, 30);
		btnInfo.setBackground(backgroundColor);
        btnInfo.setForeground(foregroundColor);
        btnInfo.setFont(panelFont.deriveFont(Font.BOLD));
		menuPanel.add(btnInfo);
		
		JButton btnCollections = new JButton("Collezioni");
		btnCollections.setBounds(WIDTH/2, 0, WIDTH/2, 30);
		btnCollections.setBorderPainted(false);
		btnCollections.setFont(panelFont);
		btnCollections.setBackground(secondaryBackgroundColor);
		btnCollections.setForeground(foregroundColor);
		menuPanel.add(btnCollections);
		
		informationPanel = new JPanel();
		informationPanel.setBounds(0, 30, WIDTH, HEIGHT-30);
		informationPanel.setLayout(null);
		informationPanel.setBackground(null);
		add(informationPanel);
		

		lblAvatar = new JLabel("");
		lblAvatar.setBounds(5, 5, 250, 300);
		ImageIcon icon = new ImageIcon("resources//iLTd4oI.png");
		Image image = icon.getImage();
		image = image.getScaledInstance(lblAvatar.getWidth(), lblAvatar.getHeight(), Image.SCALE_SMOOTH);
		icon = new ImageIcon(image);
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
		
		btnEdit = new JButton("");
		btnEdit.setBounds(700, 250, 75, 75);
		btnEdit.setBackground(null);
		btnEdit.setBorder(null);
		btnEdit.setIcon(new ImageIcon(new ImageIcon("resources//edit.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		informationPanel.add(btnEdit);
		
		
		collectionsPanel = new JPanel();
		collectionsPanel.setBounds(0, 30, WIDTH, HEIGHT-30);
		collectionsPanel.setLayout(null);
		collectionsPanel.setBackground(null);
		add(collectionsPanel);
		
		lblAvatarSmall = new JLabel("");
		lblAvatarSmall.setBounds(5, 5, 150, 200);
		ImageIcon icon2 = new ImageIcon("resources//iLTd4oI.png");
		Image image2 = icon2.getImage();
		image2 = image.getScaledInstance(lblAvatarSmall.getWidth(), lblAvatarSmall.getHeight(), Image.SCALE_SMOOTH);
		icon2 = new ImageIcon(image2);
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
		

		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnInfo.setBackground(backgroundColor);
				btnCollections.setBackground(secondaryBackgroundColor);
				btnInfo.setFont(panelFont.deriveFont(Font.BOLD));
				btnCollections.setFont(panelFont.deriveFont(Font.BOLD));
				collectionsPanel.setVisible(false);
				informationPanel.setVisible(true);
			}
		});
		
		btnCollections.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnInfo.setBackground(secondaryBackgroundColor);
				btnCollections.setBackground(backgroundColor);
				btnInfo.setFont(panelFont);
				btnCollections.setFont(panelFont.deriveFont(Font.BOLD));
				informationPanel.setVisible(false);
				collectionsPanel.setVisible(true);
			}
		});
		
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
	
}
