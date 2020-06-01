package it.unibs.db.tcg.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class EditPanel extends JPanel {
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static Color backgroundColor = new Color(252, 186, 3);
	private static Color secondaryBackgroundColor = new Color(156, 156, 156);
	private static Color foregroundColor = Color.WHITE;
	private static Font panelFont = new Font("Serif", 0, 18);
	
	private JLabel lblAvatar;
	private JLabel lblName;
	private JLabel lblNickname;
	private JLabel lblMail;
	private JButton btnEditAvatar;
	private JButton btnEditName;
	private JButton btnEditMail;
	private JButton btnSave;
	
	public EditPanel() {
		setLayout(null);
		setBackground(backgroundColor);
		setForeground(foregroundColor);
		setFont(panelFont);
		
		lblAvatar = new JLabel("");
		lblAvatar.setBounds(5, 5, 250, 300);
		ImageIcon icon = new ImageIcon("resources//iLTd4oI.png");
		Image image = icon.getImage();
		icon = new ImageIcon(image);
		image = image.getScaledInstance(lblAvatar.getWidth(), lblAvatar.getHeight(), Image.SCALE_SMOOTH);
		lblAvatar.setIcon(icon);
		add(lblAvatar);
		
		btnEditAvatar = new JButton("Edit Avatar");
		btnEditAvatar.setBounds(5, 325, 250, 25);
		add(btnEditAvatar);
		
		lblNickname = new JLabel("Nickname");
		lblNickname.setForeground(foregroundColor);
		lblNickname.setBounds(400, 5, 400, 50);
		lblNickname.setFont(panelFont.deriveFont(Font.BOLD));
		add(lblNickname);

		lblName = new JLabel("Nome");
		lblName.setForeground(foregroundColor);
		lblName.setFont(panelFont);
		lblName.setBounds(400, 60, 300, 50);
		add(lblName);

		lblMail = new JLabel("Mail");
		lblMail.setForeground(foregroundColor);
		lblMail.setFont(panelFont);
		lblMail.setBounds(400, 115, 300, 50);
		add(lblMail);
		
		JLabel lblfirst = new JLabel("Nome ");
		lblfirst.setFont(panelFont);
		lblfirst.setForeground(foregroundColor);
		lblfirst.setBounds(290, 60, 100, 50);
		add(lblfirst);

		JLabel lblsecond = new JLabel("Mail ");
		lblsecond.setFont(panelFont);
		lblsecond.setForeground(foregroundColor);
		lblsecond.setBounds(290, 115, 100, 50);
		add(lblsecond);
		
		btnEditName = new JButton("Edit Nome");
		btnEditName.setBounds(700, 60, 90, 50);
		add(btnEditName);
		
		btnEditMail = new JButton("Edit Mail");
		btnEditMail.setBounds(700, 115, 90, 50);
		add(btnEditMail);
		
		btnSave = new JButton("Salva");
		btnSave.setBounds(700, 500, 90, 50);
		add(btnSave);
		
	}
	
	public void setNickname(String nickname) {
		lblNickname.setText(nickname);
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
	}
	
	public String showEditPopup() {
		return JOptionPane.showInputDialog("Inserisci il nuovo valore:");
	}
	
	public void addEditNameListener(ActionListener a) {
		btnEditName.addActionListener(a);
	}
	
	public void addEditMailListener(ActionListener a) {
		btnEditMail.addActionListener(a);
	}
	
	public void addEditAvatarListener(ActionListener a) {
		btnEditAvatar.addActionListener(a);
	}
	
	public void addSaveListener(ActionListener a) {
		btnSave.addActionListener(a);
	}
}
