package it.unibs.db.tcg.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class RegistrationPanel extends JPanel {

	private static final long serialVersionUID = -125624121548476171L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static Color backgroundColor;
	private static Color secondaryBackgroundColor;
	private static Color foregroundColor;
	private static Font panelFont;

	private JTextField nicknameTextField;
	private JTextField nameTextField;
	private JTextField mailTextField;
	private JLabel lblAvatar;

	private JButton btnRegister;
	private JButton btnBack;

	public RegistrationPanel() {
		setLayout(null);
		secondaryBackgroundColor = Preferences.getSecondaryBackgroundColor();
		backgroundColor = Preferences.getBackgroundColor();
		setBackground(backgroundColor);
		foregroundColor = Preferences.getForegroundColor();
		setForeground(foregroundColor);
		panelFont = Preferences.getFont();
		setFont(panelFont);

		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setForeground(foregroundColor);
		lblNickname.setBounds(50, 50, 100, 25);
		lblNickname.setForeground(foregroundColor);
		lblNickname.setFont(panelFont.deriveFont(Font.BOLD));
		add(lblNickname);

		nicknameTextField = new JTextField();
		nicknameTextField.setBounds(200, 50, 200, 25);
		nicknameTextField.setFont(panelFont);
		add(nicknameTextField);

		JLabel lblName = new JLabel("Name");
		lblName.setForeground(foregroundColor);
		lblName.setBounds(50, 100, 100, 25);
		lblName.setForeground(foregroundColor);
		lblName.setFont(panelFont.deriveFont(Font.BOLD));
		add(lblName);

		nameTextField = new JTextField();
		nameTextField.setBounds(200, 100, 200, 25);
		nameTextField.setFont(panelFont);
		add(nameTextField);

		JLabel lblMail = new JLabel("Mail");
		lblMail.setForeground(foregroundColor);
		lblMail.setBounds(50, 150, 100, 25);
		lblMail.setForeground(foregroundColor);
		lblMail.setFont(panelFont.deriveFont(Font.BOLD));
		add(lblMail);

		mailTextField = new JTextField();
		mailTextField.setBounds(200, 150, 200, 25);
		mailTextField.setFont(panelFont);
		add(mailTextField);

		JLabel lblSAvatar = new JLabel("Avatar");
		lblSAvatar.setForeground(foregroundColor);
		lblSAvatar.setBounds(50, 200, 100, 25);
		lblSAvatar.setForeground(foregroundColor);
		lblSAvatar.setFont(panelFont.deriveFont(Font.BOLD));
		add(lblSAvatar);

		lblAvatar = new JLabel();
		lblAvatar.setBounds(50, 210, 250, 300);
		ImageIcon icon = new ImageIcon("resources//default_avatar.jpg");
		Image image = icon.getImage();
		icon = new ImageIcon(image);
		image = image.getScaledInstance(lblAvatar.getWidth(), lblAvatar.getHeight(), Image.SCALE_SMOOTH);
		lblAvatar.setIcon(icon);
		add(lblAvatar);

		JButton btnChooser = new JButton("Scegli file");
		btnChooser.setBounds(50, 520, 250, 25);
		btnChooser.setFont(panelFont);
		add(btnChooser);

		btnChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = chooseAvatar();
				if (icon != null) {
					lblAvatar.setIcon(icon);
				}
			}
		});

		btnBack = new JButton("Back");
		btnBack.setBounds(650, 480, 90, 50);
		btnBack.setFont(panelFont);
		add(btnBack);

		btnRegister = new JButton("Registrati");
		btnRegister.setBounds(550, 400, 190, 50);
		btnRegister.setFont(panelFont);
		add(btnRegister);

	}

	private ImageIcon chooseAvatar() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("File jpeg, jpg, png", "jpeg", "jpg", "png");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			ImageIcon icon = new ImageIcon(chooser.getSelectedFile().getPath());
			Image image = icon.getImage();
			image = image.getScaledInstance(250, 300, Image.SCALE_SMOOTH);
			icon = new ImageIcon(image);
			return icon;
		}
		return null;
	}

	public void addBackListener(ActionListener a) {
		btnBack.addActionListener(a);
	}

	public void addRegisterListener(ActionListener a) {
		btnRegister.addActionListener(a);
	}

	public String getNicknameText() {
		return nicknameTextField.getText();
	}

	public String getNameText() {
		return nameTextField.getText();
	}

	public String getMailText() {
		return mailTextField.getText();
	}

	public Icon getAvatarImage() {
		return lblAvatar.getIcon();
	}

	public void showErrorPopup() {
		JOptionPane error = new JOptionPane();
		error.setBounds(getBounds());
		error.showMessageDialog(this, "Errore registrazione, nickname già presente",
				"Warning", JOptionPane.ERROR_MESSAGE);
	}

}
