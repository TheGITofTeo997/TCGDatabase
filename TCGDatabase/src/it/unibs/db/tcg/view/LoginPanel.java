package it.unibs.db.tcg.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPanel extends JPanel implements KeyListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -125624121548476171L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static Color backgroundColor = new Color(252, 186, 3);
	private static Color secondaryBackgroundColor = new Color(156, 156, 156);
	private static Color foregroundColor = Color.WHITE;
	private static Font panelFont = new Font("Serif", 0, 18);
	
	private List<ActionListener> listenerList = new ArrayList<>();
	
	private JTextField loginTextField;
	private JButton btnLogin;

	public LoginPanel() {
		setFont(panelFont);
		setLayout(null);
		setBackground(backgroundColor);

		setFocusable(true);
		addKeyListener(this);
		
		loginTextField = new JTextField();
		loginTextField.setBounds(WIDTH/2 - 100, HEIGHT/2 - 25, 200, 50);
		add(loginTextField);
		loginTextField.setFont(panelFont);
		loginTextField.setColumns(10);
		
		JLabel lblLogin = new JLabel("Nickname");
		lblLogin.setForeground(foregroundColor);
		lblLogin.setBounds(WIDTH/2 - loginTextField.getWidth(), HEIGHT/2- loginTextField.getHeight()/2, 100, 50);
		lblLogin.setFont(panelFont.deriveFont(Font.BOLD));
		add(lblLogin);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(panelFont);
		btnLogin.setBounds(WIDTH/2 - 100, HEIGHT/2 + 100, 200, 50);
		add(btnLogin);

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

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
			btnLogin.doClick();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
}
