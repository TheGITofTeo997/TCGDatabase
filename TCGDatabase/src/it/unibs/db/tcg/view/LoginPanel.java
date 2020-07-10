package it.unibs.db.tcg.view;

import java.awt.Color;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;

public class LoginPanel extends JPanel implements KeyListener {

	private static final long serialVersionUID = -125624121548476171L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static Color backgroundColor;
	private static Color secondaryBackgroundColor;
	private static Color foregroundColor;
	private static Font panelFont;

	private List<ActionListener> listenerList = new ArrayList<>();

	private JTextField loginTextField;
	private JButton btnLogin;
	private JButton btnRegister;
	private JLabel lblStatus;
	private JLabel lblStatusText;
	private JButton btnRefreshDatabaseStatus;

	public LoginPanel() {
		setLayout(null);
		secondaryBackgroundColor = Preferences.getSecondaryBackgroundColor();
		backgroundColor = Preferences.getBackgroundColor();
		setBackground(backgroundColor);
		foregroundColor = Preferences.getForegroundColor();
		setForeground(foregroundColor);
		panelFont = Preferences.getFont();
		setFont(panelFont);

		setFocusable(true);
		addKeyListener(this);

		loginTextField = new JTextField();
		loginTextField.setBounds(WIDTH / 2 - 100, HEIGHT / 2 - 25, 200, 50);
		add(loginTextField);
		loginTextField.addKeyListener(this);
		loginTextField.setFont(panelFont);
		loginTextField.setColumns(10);

		JLabel lblDatabaseStatus = new JLabel("Database Status");
		lblDatabaseStatus.setBounds(10, 525, 125, 30);
		lblDatabaseStatus.setFont(getFont());
		lblDatabaseStatus.setForeground(getForeground());
		add(lblDatabaseStatus);

		ImageIcon imageWait = new ImageIcon("resources//waiting.gif");
		imageWait.setImage(imageWait.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		lblStatus = new JLabel(imageWait);
		lblStatus.setBounds(130, 525, 30, 30);
		add(lblStatus);
		
		lblStatusText = new JLabel("");
		lblStatusText.setForeground(Color.WHITE);
		lblStatusText.setBounds(130, 525, 125, 30);
		add(lblStatusText);

		JLabel lblLogin = new JLabel("Nickname");
		lblLogin.setForeground(foregroundColor);
		lblLogin.setBounds(WIDTH / 2 - loginTextField.getWidth(), HEIGHT / 2 - loginTextField.getHeight() / 2, 100, 50);
		lblLogin.setFont(panelFont.deriveFont(Font.BOLD));
		add(lblLogin);

		btnLogin = new JButton("Login");
		btnLogin.setFont(panelFont);
		btnLogin.setEnabled(false);
		btnLogin.setBounds(WIDTH / 2 - 100, HEIGHT / 2 + 100, 200, 50);
		add(btnLogin);

		btnRegister = new JButton("Nuovo utente");
		btnRegister.setFont(panelFont);
		btnRegister.setEnabled(false);
		btnRegister.setBounds(300, 500, 200, 50);
		add(btnRegister);

		JLabel lblLogo = new JLabel();
		lblLogo.setBounds(-20, 0, 800, 200);
		ImageIcon icon = new ImageIcon("resources//login_logo.png");
		Image image = icon.getImage();
		icon = new ImageIcon(image);
		image = image.getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH);
		lblLogo.setIcon(icon);
		add(lblLogo);

		JLabel lblCharizardBackgroundLogin = new JLabel();
		lblCharizardBackgroundLogin.setBounds(400, 250, 400, 400);
		icon = new ImageIcon("resources//login_charizard.png");
		image = icon.getImage();
		icon = new ImageIcon(image);
		image = image.getScaledInstance(lblCharizardBackgroundLogin.getWidth(), lblCharizardBackgroundLogin.getHeight(),
				Image.SCALE_SMOOTH);
		lblCharizardBackgroundLogin.setIcon(icon);
		add(lblCharizardBackgroundLogin);

		btnRefreshDatabaseStatus = new JButton("Refresh");
		btnRefreshDatabaseStatus.setBounds(10, 501, 89, 23);
		add(btnRefreshDatabaseStatus);

	}

	public String getLoginField() {
		return loginTextField.getText();
	}

	@SuppressWarnings("static-access")
	public void showErrorPopup() {
		JOptionPane error = new JOptionPane();
		error.setBounds(getBounds());
		error.showMessageDialog(this, "Inserisci un nickname valido!", "Warning", JOptionPane.ERROR_MESSAGE);
	}

	public void addHomeListener(ActionListener a) {
		btnLogin.addActionListener(a);
	}
	
	public void showWaitingDatabadeConnection() {
		lblStatus.setVisible(true);
		lblStatusText.setVisible(false);
	}

	public void setDatabaseStatus(boolean status) {
		lblStatus.setVisible(false);
		lblStatusText.setVisible(true);
		if (status) {
			lblStatusText.setText("Operational");
			lblStatusText.setForeground(Color.GREEN);
		} else {
			lblStatusText.setText("Unreachable");
			lblStatusText.setForeground(Color.RED);
		}
	}
	
	public void setBtnLoginEnabled(boolean flag) {
		btnLogin.setEnabled(flag);
	}
	
	public void setBtnRegisterEnabled(boolean flag) {
		btnRegister.setEnabled(flag);
	}

	public void addRegistrationListener(ActionListener a) {
		btnRegister.addActionListener(a);
	}

	public void addRefreshDatabaseStatusListener(ActionListener a) {
		btnRefreshDatabaseStatus.addActionListener(a);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
			btnLogin.doClick();
		}

	}
	
	@Override
	public void keyReleased(KeyEvent e) {

	}
}
