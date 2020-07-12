package it.unibs.db.tcg.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import it.unibs.db.tcg.model.Strings;

import javax.swing.JButton;

import javax.swing.JColorChooser;
import javax.swing.JComboBox;

public class HomePanel extends JPanel {

	private static final long serialVersionUID = -2344441442972902447L;
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
	private JButton btnNewCollection;
	private JButton btnRandomCard;
	private JButton btnRanking;
	private JButton btnHelp;
	private JPanel optionPanel;
	private JPanel newCollectionPanel;
	private JComboBox visibleList;
	private JTextField nameText;
	private JTextArea textInformation;
	

	private JLabel lblPikachuBackground;

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
		lblAvatar.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
		add(lblAvatar);

		textInformation = new JTextArea("Benvenuto nella tua home di TCG Database");
		textInformation.setBounds(600, 40, 175, 100);
		textInformation.setFont(getFont().deriveFont(Font.ITALIC));
		textInformation.setEditable(false);
		textInformation.setLineWrap(true);
		// textInformation.setOpaque(false);
		textInformation.setWrapStyleWord(true);
		textInformation.setBackground(new Color(73, 75, 76));
		textInformation.setForeground(Color.WHITE);
		add(textInformation);

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
		btnSearch.setBounds(225, 40, 100, 100);
		btnSearch.setBackground(new Color(192, 192, 192));
		btnSearch.setForeground(foregroundColor);
		btnSearch.setBackground(null);
		btnSearch.setIcon(new ImageIcon(new ImageIcon("resources//icon//search_icon.png").getImage()
				.getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
		btnSearch.setFont(panelFont.deriveFont(Font.BOLD));
		btnSearch.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				textInformation.setText("Cerca carte o utenti");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				textInformation.setText("");
			}
		});
		add(btnSearch);
		
		btnHelp = new JButton("");
		btnHelp.setBounds(350, 165, 100, 100);
		btnHelp.setBackground(new Color(192, 192, 192));
		btnHelp.setForeground(foregroundColor);
		btnHelp.setBackground(null);
		btnHelp.setIcon(new ImageIcon(new ImageIcon("resources//icon//help_icon.png").getImage()
				.getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
		btnHelp.setFont(panelFont.deriveFont(Font.BOLD));
		btnHelp.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				textInformation.setText("Apri la guida utente");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				textInformation.setText("");
			}
		});
		add(btnHelp);

		btnRanking = new JButton("Ranking");
		btnRanking.setBounds(225, 165, 100, 100);
		btnRanking.setBackground(new Color(192, 192, 192));
		btnRanking.setForeground(foregroundColor);
		btnRanking.setBackground(null);
		btnRanking.setIcon(new ImageIcon(new ImageIcon("resources//icon//ranking_icon.png").getImage()
				.getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
		btnRanking.setFont(panelFont.deriveFont(Font.BOLD));
		btnRanking.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				textInformation.setText("Visualizza le classifiche generali degli utenti");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				textInformation.setText("");
			}
		});
		add(btnRanking);

		btnNewCollection = new JButton("Nuova collezione");
		btnNewCollection.setBounds(350, 40, 100, 100);
		btnNewCollection.setForeground(foregroundColor);
		btnNewCollection.setBackground(null);
		btnNewCollection.setIcon(new ImageIcon(new ImageIcon("resources//icon//new_collection_icon.png").getImage()
				.getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
		btnNewCollection.setFont(panelFont.deriveFont(Font.BOLD));
		btnNewCollection.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				textInformation.setText("Crea una nuova collezione");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				textInformation.setText("");
			}
		});
		add(btnNewCollection);

		btnRandomCard = new JButton("Mostra carta random");
		btnRandomCard.setBounds(475, 40, 100, 100);
		btnRandomCard.setForeground(foregroundColor);
		btnRandomCard.setBackground(null);
		btnRandomCard.setIcon(new ImageIcon(new ImageIcon("resources//icon//random_card_icon.png").getImage()
				.getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
		btnRandomCard.setFont(panelFont.deriveFont(Font.BOLD));
		btnRandomCard.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				textInformation.setText("Mostra una carta random");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				textInformation.setText("");
			}
		});
		add(btnRandomCard);

		btnBack = new JButton("Logout");
		btnBack.setBounds(650, 480, 90, 50);
		btnBack.setFont(panelFont);
		add(btnBack);

		btnOption = new JButton("");
		btnOption.setBounds(675, 400, 75, 75);
		btnOption.setBorder(null);
		btnOption.setBackground(null);
		btnOption.setIcon(new ImageIcon(new ImageIcon("resources//icon//gear_option.png").getImage()
				.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnOption.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				textInformation.setText("Opzioni");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				textInformation.setText("");
			}
		});
		add(btnOption);

		ImageIcon pikachu = new ImageIcon("resources///pikachu.png");
		pikachu.setImage(pikachu.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH));
		lblPikachuBackground = new JLabel(pikachu);
		lblPikachuBackground.setBounds(75, 300, 300, 300);
		lblPikachuBackground.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
				textInformation.setText("Why are you clicking me?");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				textInformation.setText("");
			}
		});
		add(lblPikachuBackground);

		btnOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showOptionPanel();
			}
		});

		createNewCollectionPopup();
	}

	public void setLblPikachuX(int x) {
		lblPikachuBackground.setBounds(x, lblPikachuBackground.getY(), lblPikachuBackground.getWidth(),
				lblPikachuBackground.getHeight());
	}

	public void addLblPikachuMouseListener(MouseListener a) {
		lblPikachuBackground.addMouseListener(a);
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
		Color newColor = JColorChooser.showDialog(null, "Scegli un colore", Color.RED);
		return newColor;
	}

	public void setAvatar(ImageIcon avatar) {
		Image image = avatar.getImage();
		image = image.getScaledInstance(lblAvatar.getWidth(), lblAvatar.getHeight(), Image.SCALE_SMOOTH);
		avatar = new ImageIcon(image);
		lblAvatar.setIcon(avatar);
	}

	public void showRandomCardPopup(ImageIcon card) {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(250, 300));
		Image image = card.getImage();
		image = image.getScaledInstance(250, 300, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(image);
		JLabel lblCard = new JLabel(icon);
		lblCard.setBounds(0, 0, 250, 300);
		panel.add(lblCard);
		JOptionPane.showOptionDialog(null, panel, "Carta Random", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, new Object[] { "Ok" }, null);

	}

	public int showConfirmDialog() {
		JOptionPane confirm = new JOptionPane();
		confirm.setBounds(getBounds());
		return confirm.showConfirmDialog(this,
				"Attenzione, confermando verrai sloggato dal tuo account. Vuoi procedere?", "Question",
				JOptionPane.YES_NO_OPTION);
	}

	public void addNewCollectionListener(ActionListener a) {
		btnNewCollection.addActionListener(a);
	}
	
	public void addHelpListener(ActionListener a) {
		btnHelp.addActionListener(a);
	}

	public void addRandomCardListener(ActionListener a) {
		btnRandomCard.addActionListener(a);
	}

	public void setTextInformationMessage(String text) {
		textInformation.setText(text);
	}

	private void createNewCollectionPopup() {
		newCollectionPanel = new JPanel();
		newCollectionPanel.setName("Nuova collezione");
		newCollectionPanel.setLayout(null);
		newCollectionPanel.setForeground(foregroundColor);
		newCollectionPanel.setFont(panelFont);
		newCollectionPanel.setPreferredSize(new Dimension(200, 300));

		JLabel lblSName = new JLabel("Nome");
		lblSName.setBackground(backgroundColor);
		lblSName.setHorizontalAlignment(JLabel.CENTER);
		lblSName.setBounds(0, 0, 50, 25);
		newCollectionPanel.add(lblSName);

		nameText = new JTextField();
		nameText.setBounds(50, 0, 150, 25);
		newCollectionPanel.add(nameText);

		String[] choices = { "Visibile", "Non Visibile" };

		// Create the combo box, select item at index 4.
		// Indices start at 0, so 4 specifies the pig.
		visibleList = new JComboBox(choices);
		visibleList.setBounds(10, 30, 190, 25);
		visibleList.setSelectedIndex(0);
		newCollectionPanel.add(visibleList);

		JButton btnAddCollection = new JButton("Crea");
		btnAddCollection.setBounds(0, 0, 0, 0);
		newCollectionPanel.add(btnAddCollection);

	}

	public String getNameTextField() {
		return nameText.getText();
	}

	public String getVisibileField() {
		return (String) visibleList.getSelectedItem();
	}

	public boolean showNewCollectionPopup() {
		return (JOptionPane.showConfirmDialog(this, newCollectionPanel) == 0);
	}

	public void addAccountListener(ActionListener a) {
		btnViewProfile.addActionListener(a);
	}

	public void addRankingListener(ActionListener a) {
		btnRanking.addActionListener(a);
	}

	public void addSearchListener(ActionListener a) {
		btnSearch.addActionListener(a);
	}

	public void addBackListener(ActionListener a) {
		btnBack.addActionListener(a);
	}

	public void showErrorPopup() {
		JOptionPane.showMessageDialog(this, "Hai già una collezione con quel nome!");

	}
}
