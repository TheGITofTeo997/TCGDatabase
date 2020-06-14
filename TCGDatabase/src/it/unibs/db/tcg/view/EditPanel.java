package it.unibs.db.tcg.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class EditPanel extends JPanel {

	private static final long serialVersionUID = 1663931555261779174L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static Color backgroundColor;
	private static Color secondaryBackgroundColor;
	private static Color foregroundColor;
	private Font panelFont;

	private JLabel lblAvatar;
	private JLabel lblName;
	private JLabel lblNickname;
	private JLabel lblMail;
	private JButton btnEditName;
	private JButton btnEditMail;
	private JButton btnBack;

	private JButton btnChangeAvatar;
	private JButton btnDeleteAvatar;

	public EditPanel() {
		setLayout(null);
		secondaryBackgroundColor = Preferences.getSecondaryBackgroundColor();
		backgroundColor = Preferences.getBackgroundColor();
		setBackground(backgroundColor);
		foregroundColor = Preferences.getForegroundColor();
		setForeground(foregroundColor);
		panelFont = Preferences.getFont();
		setFont(panelFont);

		lblAvatar = new JLabel("");
		lblAvatar.setBounds(5, 5, 250, 300);
		ImageIcon icon = new ImageIcon("resources//iLTd4oI.png");
		Image image = icon.getImage();
		icon = new ImageIcon(image);
		image = image.getScaledInstance(lblAvatar.getWidth(), lblAvatar.getHeight(), Image.SCALE_SMOOTH);
		lblAvatar.setIcon(icon);
		add(lblAvatar);

		btnDeleteAvatar = new JButton("Cancella avatar");
		btnDeleteAvatar.setBounds(5, 360, 250, 25);
		add(btnDeleteAvatar);

		btnChangeAvatar = new JButton("Carica...");
		btnChangeAvatar.setBounds(5, 325, 250, 25);
		add(btnChangeAvatar);

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

		btnBack = new JButton("Back");
		btnBack.setBounds(650, 480, 90, 50);
		btnBack.setFont(panelFont);
		add(btnBack);

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

	public void showErrorPopup() {
		JOptionPane error = new JOptionPane();
		error.setBounds(getBounds());
		error.showMessageDialog(this, "Attenzione, campo non valido!", "Warning", JOptionPane.ERROR_MESSAGE);
	}

	public void showCorrectPopup() {
		JOptionPane correct = new JOptionPane();
		correct.setBounds(getBounds());
		correct.showMessageDialog(this, "Modifica effettuata correttamente!", "Correct",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public ImageIcon chooseAvatar() {
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
	
	public boolean showConfirmPopup() {
		return (JOptionPane.showConfirmDialog(this, "Questa operazione eliminerà la tua foto profilo corrente. Vuoi procedere?") == 0);
	}

	public void addEditNameListener(ActionListener a) {
		btnEditName.addActionListener(a);
	}

	public void addEditMailListener(ActionListener a) {
		btnEditMail.addActionListener(a);
	}

	public void addEditAvatarListener(ActionListener a) {
		btnChangeAvatar.addActionListener(a);
	}
	
	public void addDeleteAvatarListener(ActionListener a) {
		btnDeleteAvatar.addActionListener(a);
	}

	public void addBackListener(ActionListener a) {
		btnBack.addActionListener(a);
	}
}
