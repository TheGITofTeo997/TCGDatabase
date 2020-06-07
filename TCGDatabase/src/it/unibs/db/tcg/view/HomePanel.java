package it.unibs.db.tcg.view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
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

import it.unibs.db.tcg.model.Strings;

import javax.swing.JButton;
import javax.swing.JColorChooser;

public class HomePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8768541615844025092L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static Color backgroundColor;
	private static Color secondaryBackgroundColor;
	private static Color foregroundColor;
	private Font panelFont;

	private List<ActionListener> listenerList = new ArrayList<>();

	private JLabel lblAvatar;
	private JLabel lblNickname;
	private JButton btnSearch;
	private JButton btnViewProfile;
	private JButton btnOption;
	private JButton btnBack;
	private JPanel optionPanel;

	public HomePanel() {
		setLayout(null);
		secondaryBackgroundColor = Preferences.getSecondaryBackgroundColor();
		backgroundColor = Preferences.getBackgroundColor();
		setBackground(backgroundColor);
		foregroundColor = Preferences.getForegroundColor();
		setForeground(foregroundColor);
		panelFont = Preferences.getFont();
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

		btnOption = new JButton("");
		btnOption.setBounds(700, 250, 75, 75);
		btnOption.setBackground(null);
		btnOption.setBorder(null);
		btnOption.setIcon(new ImageIcon(
				new ImageIcon("resources//gear_option.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		add(btnOption);

		btnOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showOptionPanel();
			}
		});

	}

	public void setNickname(String nickname) {
		lblNickname.setText(nickname);
	}

	private void showOptionPanel() {
		optionPanel = new JPanel();
		optionPanel.setLayout(null);
		optionPanel.setForeground(foregroundColor);
		optionPanel.setFont(panelFont);
		optionPanel.setPreferredSize(new Dimension(100, 300));

		JButton btnFont = new JButton("Font");
		btnFont.setBounds(0, 0, 150, 25);
		optionPanel.add(btnFont);
		btnFont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showFontOptionPanel();
			}
		});

		JButton btnBackground = new JButton("Background");
		btnBackground.setBounds(0, 25, 150, 25);
		optionPanel.add(btnBackground);
		btnBackground.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color newColor = showColorChooser();
				if (newColor != null)
					Preferences.setBackgroundColor(newColor);
			}
		});

		JButton btnSecondaryBackground = new JButton("2nd Background");
		btnSecondaryBackground.setBounds(0, 50, 150, 25);
		optionPanel.add(btnSecondaryBackground);
		btnSecondaryBackground.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color newColor = showColorChooser();
				if (newColor != null)
					Preferences.setSecondaryBackgroundColor(newColor);
			}
		});

		JButton btnForeground = new JButton("Foreground");
		btnForeground.setBounds(0, 75, 150, 25);
		optionPanel.add(btnForeground);
		btnForeground.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color newColor = showColorChooser();
				if (newColor != null)
					Preferences.setForegroundColor(newColor);
			}
		});

		JOptionPane.showMessageDialog(this, optionPanel, "Impostazioni", JOptionPane.INFORMATION_MESSAGE);
	}

	private void showFontOptionPanel() {
		Object[] possibilities = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		String s = (String) JOptionPane.showInputDialog(this, "Scegli il Font:", "Font", JOptionPane.PLAIN_MESSAGE,
				btnOption.getIcon(), possibilities, Strings.DEFAULT_FONT);

		if ((s != null) && (s.length() > 0)) {
			Preferences.setFont(new Font(s, 0, Strings.DEFAULT_SIZE_FONT));
		}
	}

	private Color showColorChooser() {
		Color newColor = JColorChooser.showDialog(null, "Choose a color", Color.RED);
		return newColor;
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
