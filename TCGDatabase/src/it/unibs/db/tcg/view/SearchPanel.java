package it.unibs.db.tcg.view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import it.unibs.db.tcg.model.Strings;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SearchPanel extends JPanel {

	private static final long serialVersionUID = -7455653311848409614L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static Color backgroundColor;
	private static Color secondaryBackgroundColor;
	private static Color foregroundColor;
	private Font panelFont;

	private JPanel cardPanel;
	private JPanel userPanel;
	private JButton btnBack;
	private JButton btnRefresh;
	private JButton btnCardSearch;
	private JButton btnUserSearch;

	private JTextField cardNameField;
	private JTextField cardExpField;
	private JTextField cardIllustratorField;
	private JCheckBox pkmnCheckBox;
	private JCheckBox itemCheckBox;
	private JCheckBox energyCheckBox;
	private RangeSlider PSRange;
	private JLabel lblPSLowerRange;
	private JLabel lblPSUpperRange;
	private RangeSlider valueRange;
	private JLabel lblValueLowerRange;
	private JLabel lblValueUpperRange;
	private JPanel energyTypePanel;
	private JCheckBox erbaBox;
	private JCheckBox fuocoBox;
	private JCheckBox acquaBox;
	private JCheckBox lampoBox;
	private JCheckBox psicoBox;
	private JCheckBox lottaBox;
	private JCheckBox oscuritaBox;
	private JCheckBox metalloBox;
	private JCheckBox follettoBox;
	private JCheckBox incoloreBox;
	private JCheckBox dragoBox;
	private JPanel rarityPanel;
	private JCheckBox raraBox;
	private JCheckBox olograficaRaraBox;
	private JCheckBox ultrararaBox;
	private JCheckBox arcobalenoRaraBox;
	private JCheckBox comuneBox;
	private JCheckBox superRaraBox;
	private JCheckBox assoRaraBox;
	private JCheckBox promoBox;
	private JCheckBox nonComuneBox;
	private JCheckBox olograficaRaraEXBox;
	private JCheckBox turboRaraBox;
	private JCheckBox olograficaRaraGXBox;
	private JCheckBox leggendaBox;
	private JCheckBox olograficaRaraLivXBox;
	private JCheckBox olograficaRaraVBox;
	private List<JCheckBox> typeCheckBox;
	private List<JCheckBox> rarityCheckBox;

	private JTextField userNameField;

	public SearchPanel() {
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

		cardPanel = new JPanel();
		cardPanel.setBounds(0, 30, WIDTH, 390);
		cardPanel.setLayout(null);
		cardPanel.setBackground(null);
		cardPanel.setFocusable(true);
		add(cardPanel);

		userPanel = new JPanel();
		userPanel.setBounds(0, 30, WIDTH, 390);
		userPanel.setLayout(null);
		userPanel.setBackground(null);
		userPanel.setFocusable(false);
		userPanel.setVisible(false);
		add(userPanel);

		JButton btnCard = new JButton("Cerca Carta");
		btnCard.setBounds(0, 0, WIDTH / 2, 30);
		btnCard.setBackground(backgroundColor);
		btnCard.setForeground(foregroundColor);
		btnCard.setFont(panelFont.deriveFont(Font.BOLD));
		menuPanel.add(btnCard);

		JButton btnUser = new JButton("Cerca Utente");
		btnUser.setBounds(WIDTH / 2, 0, WIDTH / 2, 30);
		btnUser.setBorderPainted(false);
		btnUser.setFont(panelFont);
		btnUser.setBackground(secondaryBackgroundColor);
		btnUser.setForeground(foregroundColor);
		menuPanel.add(btnUser);

		btnCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCard.setBackground(backgroundColor);
				btnUser.setBackground(secondaryBackgroundColor);
				btnCard.setFont(panelFont.deriveFont(Font.BOLD));
				btnUser.setFont(panelFont);
				userPanel.setFocusable(false);
				userPanel.setVisible(false);
				cardPanel.setFocusable(true);
				cardPanel.setVisible(true);
			}
		});

		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCard.setBackground(secondaryBackgroundColor);
				btnUser.setBackground(backgroundColor);
				btnCard.setFont(panelFont);
				btnUser.setFont(panelFont.deriveFont(Font.BOLD));
				cardPanel.setFocusable(false);
				cardPanel.setVisible(false);
				userPanel.setFocusable(true);
				userPanel.setVisible(true);
			}
		});

		JLabel cardSLblName = new JLabel("Nome");
		cardSLblName.setBounds(0, 0, 100, 50);
		cardSLblName.setForeground(foregroundColor);
		cardSLblName.setFont(panelFont);
		cardPanel.add(cardSLblName);

		cardNameField = new JTextField("");
		cardNameField.setBounds(150, 0, 200, 50);
		cardNameField.setFont(panelFont);
		cardPanel.add(cardNameField);

		JLabel cardSLblPS = new JLabel("PS");
		cardSLblPS.setBounds(360, 0, 30, 50);
		cardSLblPS.setForeground(foregroundColor);
		cardSLblPS.setFont(panelFont);
		cardSLblPS.setVisible(false);
		cardPanel.add(cardSLblPS);

		lblPSUpperRange = new JLabel("500");
		lblPSUpperRange.setBounds(740, 0, 40, 50);
		lblPSUpperRange.setForeground(foregroundColor);
		lblPSUpperRange.setFont(panelFont);
		lblPSUpperRange.setVisible(false);
		cardPanel.add(lblPSUpperRange);

		PSRange = new RangeSlider(0, 500);
		PSRange.setBounds(430, 0, 300, 50);
		PSRange.setLowerValue(0);
		PSRange.setBackground(null);
		PSRange.setUpperValue(500);
		cardPanel.add(PSRange);
		PSRange.setVisible(false);
		PSRange.addChangeListener(e -> PSSliderChanged());

		lblPSLowerRange = new JLabel("0");
		lblPSLowerRange.setBounds(390, 0, 30, 50);
		lblPSLowerRange.setForeground(foregroundColor);
		lblPSLowerRange.setFont(panelFont);
		lblPSLowerRange.setVisible(false);
		cardPanel.add(lblPSLowerRange);

		JLabel cardSLblExp = new JLabel("Espansione");
		cardSLblExp.setBounds(0, 60, 100, 50);
		cardSLblExp.setForeground(foregroundColor);
		cardSLblExp.setFont(panelFont);
		cardPanel.add(cardSLblExp);

		cardExpField = new JTextField("");
		cardExpField.setBounds(150, 60, 200, 50);
		cardExpField.setFont(panelFont);
		cardPanel.add(cardExpField);

		JLabel cardSLbValue = new JLabel("€");
		cardSLbValue.setBounds(360, 60, 30, 50);
		cardSLbValue.setForeground(foregroundColor);
		cardSLbValue.setFont(panelFont);
		cardPanel.add(cardSLbValue);

		lblValueUpperRange = new JLabel("1000");
		lblValueUpperRange.setBounds(740, 60, 40, 50);
		lblValueUpperRange.setForeground(foregroundColor);
		lblValueUpperRange.setFont(panelFont);
		cardPanel.add(lblValueUpperRange);

		valueRange = new RangeSlider(0, 1000);
		valueRange.setBounds(430, 60, 300, 50);
		valueRange.setLowerValue(0);
		valueRange.setBackground(null);
		valueRange.setUpperValue(1000);
		cardPanel.add(valueRange);
		valueRange.addChangeListener(e -> valueSliderChanged());

		lblValueLowerRange = new JLabel("0");
		lblValueLowerRange.setBounds(390, 60, 30, 50);
		lblValueLowerRange.setForeground(foregroundColor);
		lblValueLowerRange.setFont(panelFont);
		cardPanel.add(lblValueLowerRange);

		JLabel cardSLbCardType = new JLabel("Tipologia");
		cardSLbCardType.setBounds(0, 120, 80, 50);
		cardSLbCardType.setForeground(foregroundColor);
		cardSLbCardType.setFont(panelFont);
		cardPanel.add(cardSLbCardType);

		pkmnCheckBox = new JCheckBox("Pokemon");
		pkmnCheckBox.setBounds(150, 120, 100, 50);
		pkmnCheckBox.setFont(panelFont);
		pkmnCheckBox.setForeground(foregroundColor);
		pkmnCheckBox.setBackground(null);
		cardPanel.add(pkmnCheckBox);

		itemCheckBox = new JCheckBox("Strumento");
		itemCheckBox.setBounds(250, 120, 100, 50);
		itemCheckBox.setFont(panelFont);
		itemCheckBox.setForeground(foregroundColor);
		itemCheckBox.setBackground(null);
		cardPanel.add(itemCheckBox);

		energyCheckBox = new JCheckBox("Energia");
		energyCheckBox.setBounds(350, 120, 100, 50);
		energyCheckBox.setFont(panelFont);
		energyCheckBox.setForeground(foregroundColor);
		energyCheckBox.setBackground(null);
		cardPanel.add(energyCheckBox);

		JButton btnEnergyType = new JButton("Tipo Energia");
		btnEnergyType.setBounds(10, 240, 200, 50);
		btnEnergyType.setFont(panelFont);
		cardPanel.add(btnEnergyType);

		JButton btnRarity = new JButton("Rarità");
		btnRarity.setBounds(250, 240, 200, 50);
		btnRarity.setFont(panelFont);
		cardPanel.add(btnRarity);

		btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(650, 420, 90, 50);
		btnRefresh.setFont(panelFont);
		add(btnRefresh);

		btnBack = new JButton("Back");
		btnBack.setBounds(650, 480, 90, 50);
		btnBack.setFont(panelFont);
		add(btnBack);

		createEnergyTypeCheckBox();

		createRarityCheckBox();

		JLabel cardSLblIllustrator = new JLabel("Illustratore");
		cardSLblIllustrator.setBounds(0, 180, 100, 50);
		cardSLblIllustrator.setForeground(foregroundColor);
		cardSLblIllustrator.setFont(panelFont);
		cardPanel.add(cardSLblIllustrator);

		cardIllustratorField = new JTextField("");
		cardIllustratorField.setBounds(150, 180, 200, 50);
		cardIllustratorField.setFont(panelFont);
		cardPanel.add(cardIllustratorField);

		pkmnCheckBox.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					cardSLblPS.setVisible(true);
					PSRange.setVisible(true);
					lblPSLowerRange.setVisible(true);
					lblPSUpperRange.setVisible(true);
				} else {
					cardSLblPS.setVisible(false);
					PSRange.setVisible(false);
					lblPSLowerRange.setVisible(false);
					lblPSUpperRange.setVisible(false);
				}
			}
		});

		btnEnergyType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showEnergyTypeCheckBox();
			}
		});

		btnRarity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showRarityCheckBox();
			}
		});

		JLabel userSLblName = new JLabel("Nome");
		userSLblName.setBounds(0, 0, 100, 50);
		userSLblName.setForeground(foregroundColor);
		userSLblName.setFont(panelFont);
		userPanel.add(userSLblName);

		userNameField = new JTextField("");
		userNameField.setBounds(150, 0, 200, 50);
		userNameField.setFont(panelFont);
		userPanel.add(userNameField);

		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshParameter();
			}
		});

		btnCardSearch = new JButton("Cerca");
		btnCardSearch.setBounds(cardPanel.getWidth() / 2 - 100, 310, 200, 50);
		btnCardSearch.setFont(panelFont);
		cardPanel.add(btnCardSearch);

		btnUserSearch = new JButton("Cerca");
		btnUserSearch.setBounds(userPanel.getWidth() / 2 - 100, 310, 200, 50);
		btnUserSearch.setFont(panelFont);
		userPanel.add(btnUserSearch);
	}

	public String getUserNameField() {
		return userNameField.getText();
	}

	public String getCardNameField() {
		return cardNameField.getText();
	}

	public String getCardExpField() {
		return cardExpField.getText();
	}

	public String getCardIllustratorField() {
		return cardIllustratorField.getText();
	}

	public List<String> getCardTypeSelected() {
		List<String> result = new ArrayList<>();
		if (pkmnCheckBox.isSelected())
			result.add(pkmnCheckBox.getText());
		if (itemCheckBox.isSelected())
			result.add(itemCheckBox.getText());
		if (energyCheckBox.isSelected())
			result.add(energyCheckBox.getText());
		return result;
	}

	public List<String> getRaritySelected() {
		List<String> result = new ArrayList<>();
		for (JCheckBox c : rarityCheckBox) {
			if (c.isSelected())
				result.add(c.getText());
		}
		return result;
	}

	public List<String> getEnergyTypeSelected() {
		List<String> result = new ArrayList<>();
		for (JCheckBox c : typeCheckBox) {
			if (c.isSelected())
				result.add(c.getText());
		}
		return result;
	}

	public int getPSBarLowerValue() {
		return PSRange.getLowerValue();
	}

	public int getPSBarUpperValue() {
		return PSRange.getUpperValue();
	}

	public int getValueBarLowerValue() {
		return valueRange.getLowerValue();
	}

	public int getValueBarUpperValue() {
		return valueRange.getUpperValue();
	}

	public void addBackListener(ActionListener a) {
		btnBack.addActionListener(a);
	}

	public void addUserSearchListener(ActionListener a) {
		btnUserSearch.addActionListener(a);
	}

	public void addCardSearchListener(ActionListener a) {
		btnCardSearch.addActionListener(a);
	}

	private void PSSliderChanged() {
		lblPSLowerRange.setText(String.valueOf(PSRange.getLowerValue()));
		lblPSUpperRange.setText(String.valueOf(PSRange.getUpperValue()));
	}

	private void valueSliderChanged() {
		lblValueLowerRange.setText(String.valueOf(valueRange.getLowerValue()));
		lblValueUpperRange.setText(String.valueOf(valueRange.getUpperValue()));
	}

	private void showRarityCheckBox() {
		JOptionPane.showMessageDialog(this, rarityPanel, "Rarità", JOptionPane.QUESTION_MESSAGE);
	}

	private void createRarityCheckBox() {
		rarityPanel = new JPanel();
		rarityPanel.setLayout(null);
		rarityPanel.setForeground(foregroundColor);
		rarityPanel.setFont(panelFont);
		rarityPanel.setPreferredSize(new Dimension(200, 400));
		rarityCheckBox = new ArrayList<JCheckBox>();

		raraBox = new JCheckBox(Strings.RARA);
		raraBox.setBounds(0, 0, 200, 20);
		rarityPanel.add(raraBox);
		rarityCheckBox.add(raraBox);

		olograficaRaraBox = new JCheckBox(Strings.OLOGRAFICA_RARA);
		olograficaRaraBox.setBounds(0, 25, 200, 20);
		rarityPanel.add(olograficaRaraBox);
		rarityCheckBox.add(olograficaRaraBox);

		olograficaRaraLivXBox = new JCheckBox(Strings.OLOGRAFICA_RARA_LIVX);
		olograficaRaraLivXBox.setBounds(0, 50, 200, 20);
		rarityPanel.add(olograficaRaraLivXBox);
		rarityCheckBox.add(olograficaRaraLivXBox);

		ultrararaBox = new JCheckBox(Strings.ULTRARARA);
		ultrararaBox.setBounds(0, 75, 200, 20);
		rarityPanel.add(ultrararaBox);
		rarityCheckBox.add(ultrararaBox);

		arcobalenoRaraBox = new JCheckBox(Strings.ARCOBALENO_RARA);
		arcobalenoRaraBox.setBounds(0, 100, 200, 20);
		rarityPanel.add(arcobalenoRaraBox);
		rarityCheckBox.add(arcobalenoRaraBox);

		comuneBox = new JCheckBox(Strings.COMUNE);
		comuneBox.setBounds(0, 125, 200, 20);
		rarityPanel.add(comuneBox);
		rarityCheckBox.add(comuneBox);

		olograficaRaraEXBox = new JCheckBox(Strings.OLOGRAFICA_RARA_EX);
		olograficaRaraEXBox.setBounds(0, 150, 200, 20);
		rarityPanel.add(olograficaRaraEXBox);
		rarityCheckBox.add(olograficaRaraEXBox);

		superRaraBox = new JCheckBox(Strings.SUPER_RARA);
		superRaraBox.setBounds(0, 175, 200, 20);
		rarityPanel.add(superRaraBox);
		rarityCheckBox.add(superRaraBox);

		assoRaraBox = new JCheckBox(Strings.ASSO_RARA);
		assoRaraBox.setBounds(0, 200, 200, 20);
		rarityPanel.add(assoRaraBox);
		rarityCheckBox.add(assoRaraBox);

		promoBox = new JCheckBox(Strings.PROMO);
		promoBox.setBounds(0, 225, 200, 20);
		rarityPanel.add(promoBox);
		rarityCheckBox.add(promoBox);

		nonComuneBox = new JCheckBox(Strings.NON_COMUNE);
		nonComuneBox.setBounds(0, 250, 200, 20);
		rarityPanel.add(nonComuneBox);
		rarityCheckBox.add(nonComuneBox);

		olograficaRaraGXBox = new JCheckBox(Strings.OLOGRAFICA_RARA_GX);
		olograficaRaraGXBox.setBounds(0, 275, 200, 20);
		rarityPanel.add(olograficaRaraGXBox);
		rarityCheckBox.add(olograficaRaraGXBox);

		leggendaBox = new JCheckBox(Strings.LEGGENDA);
		leggendaBox.setBounds(0, 300, 200, 20);
		rarityPanel.add(leggendaBox);
		rarityCheckBox.add(leggendaBox);

		turboRaraBox = new JCheckBox(Strings.TURBO_RARA);
		turboRaraBox.setBounds(0, 325, 200, 20);
		rarityPanel.add(turboRaraBox);
		rarityCheckBox.add(turboRaraBox);

		olograficaRaraVBox = new JCheckBox(Strings.OLOGRAFICA_RARA_V);
		olograficaRaraVBox.setBounds(0, 350, 200, 20);
		rarityPanel.add(olograficaRaraVBox);
		rarityCheckBox.add(olograficaRaraVBox);

	}

	private void refreshParameter() {
		userNameField.setText("");
		cardNameField.setText("");
		cardExpField.setText("");
		cardIllustratorField.setText("");
		pkmnCheckBox.setSelected(false);
		itemCheckBox.setSelected(false);
		energyCheckBox.setSelected(false);
		PSRange.setLowerValue(PSRange.getMinimum());
		PSRange.setUpperValue(PSRange.getMaximum());
		valueRange.setLowerValue(valueRange.getMinimum());
		valueRange.setUpperValue(valueRange.getMaximum());

		for (JCheckBox c : typeCheckBox)
			c.setSelected(false);
		for (JCheckBox c : rarityCheckBox)
			c.setSelected(false);

	}

	private void showEnergyTypeCheckBox() {
		JOptionPane.showMessageDialog(this, energyTypePanel, "Tipo Energia", JOptionPane.QUESTION_MESSAGE);
	}

	private void createEnergyTypeCheckBox() {
		Image img;
		ImageIcon ico;
		energyTypePanel = new JPanel();
		energyTypePanel.setLayout(null);
		energyTypePanel.setForeground(foregroundColor);
		energyTypePanel.setFont(panelFont);
		energyTypePanel.setPreferredSize(new Dimension(100, 300));
		typeCheckBox = new ArrayList<JCheckBox>();

		JLabel lblErba = new JLabel("");
		lblErba.setBounds(0, 0, 20, 20);
		img = getEnergyTypeIcon("grass").getImage().getScaledInstance(lblErba.getWidth(), lblErba.getHeight(),
				Image.SCALE_SMOOTH);
		ico = new ImageIcon(img);
		lblErba.setIcon(ico);
		energyTypePanel.add(lblErba);

		erbaBox = new JCheckBox(Strings.ERBA);
		erbaBox.setBounds(25, 0, 80, 20);
		energyTypePanel.add(erbaBox);
		typeCheckBox.add(erbaBox);

		JLabel lblFuoco = new JLabel("");
		lblFuoco.setBounds(0, 25, 20, 20);
		img = getEnergyTypeIcon("fire").getImage().getScaledInstance(lblFuoco.getWidth(), lblFuoco.getHeight(),
				Image.SCALE_SMOOTH);
		ico = new ImageIcon(img);
		lblFuoco.setIcon(ico);
		energyTypePanel.add(lblFuoco);

		fuocoBox = new JCheckBox(Strings.FUOCO);
		fuocoBox.setBounds(25, 25, 80, 20);
		energyTypePanel.add(fuocoBox);
		typeCheckBox.add(fuocoBox);

		JLabel lblAcqua = new JLabel("");
		lblAcqua.setBounds(0, 50, 20, 20);
		img = getEnergyTypeIcon("water").getImage().getScaledInstance(lblAcqua.getWidth(), lblAcqua.getHeight(),
				Image.SCALE_SMOOTH);
		ico = new ImageIcon(img);
		lblAcqua.setIcon(ico);
		energyTypePanel.add(lblAcqua);

		acquaBox = new JCheckBox(Strings.ACQUA);
		acquaBox.setBounds(25, 50, 80, 20);
		energyTypePanel.add(acquaBox);
		typeCheckBox.add(acquaBox);

		JLabel lblLampo = new JLabel("");
		lblLampo.setBounds(0, 75, 20, 20);
		img = getEnergyTypeIcon("lightning").getImage().getScaledInstance(lblLampo.getWidth(), lblLampo.getHeight(),
				Image.SCALE_SMOOTH);
		ico = new ImageIcon(img);
		lblLampo.setIcon(ico);
		energyTypePanel.add(lblLampo);

		lampoBox = new JCheckBox(Strings.LAMPO);
		lampoBox.setBounds(25, 75, 80, 20);
		energyTypePanel.add(lampoBox);
		typeCheckBox.add(lampoBox);

		JLabel lblPsico = new JLabel("");
		lblPsico.setBounds(0, 100, 20, 20);
		img = getEnergyTypeIcon("psychic").getImage().getScaledInstance(lblPsico.getWidth(), lblPsico.getHeight(),
				Image.SCALE_SMOOTH);
		ico = new ImageIcon(img);
		lblPsico.setIcon(ico);
		energyTypePanel.add(lblPsico);

		psicoBox = new JCheckBox(Strings.PSICO);
		psicoBox.setBounds(25, 100, 80, 20);
		energyTypePanel.add(psicoBox);
		typeCheckBox.add(psicoBox);

		JLabel lblLotta = new JLabel("");
		lblLotta.setBounds(0, 125, 20, 20);
		img = getEnergyTypeIcon("fighting").getImage().getScaledInstance(lblLotta.getWidth(), lblLotta.getHeight(),
				Image.SCALE_SMOOTH);
		ico = new ImageIcon(img);
		lblLotta.setIcon(ico);
		energyTypePanel.add(lblLotta);

		lottaBox = new JCheckBox(Strings.LOTTA);
		lottaBox.setBounds(25, 125, 80, 20);
		energyTypePanel.add(lottaBox);
		typeCheckBox.add(lottaBox);

		JLabel lblOscurita = new JLabel("");
		lblOscurita.setBounds(0, 150, 20, 20);
		img = getEnergyTypeIcon("darkness").getImage().getScaledInstance(lblOscurita.getWidth(),
				lblOscurita.getHeight(), Image.SCALE_SMOOTH);
		ico = new ImageIcon(img);
		lblOscurita.setIcon(ico);
		energyTypePanel.add(lblOscurita);

		oscuritaBox = new JCheckBox(Strings.OSCURITA);
		oscuritaBox.setBounds(25, 150, 80, 20);
		energyTypePanel.add(oscuritaBox);
		typeCheckBox.add(oscuritaBox);

		JLabel lblMetallo = new JLabel("");
		lblMetallo.setBounds(0, 175, 20, 20);
		img = getEnergyTypeIcon("metal").getImage().getScaledInstance(lblMetallo.getWidth(), lblMetallo.getHeight(),
				Image.SCALE_SMOOTH);
		ico = new ImageIcon(img);
		lblMetallo.setIcon(ico);
		energyTypePanel.add(lblMetallo);

		metalloBox = new JCheckBox(Strings.METALLO);
		metalloBox.setBounds(25, 175, 80, 20);
		energyTypePanel.add(metalloBox);
		typeCheckBox.add(metalloBox);

		JLabel lblFolletto = new JLabel("");
		lblFolletto.setBounds(0, 200, 20, 20);
		img = getEnergyTypeIcon("fairy").getImage().getScaledInstance(lblFolletto.getWidth(), lblFolletto.getHeight(),
				Image.SCALE_SMOOTH);
		ico = new ImageIcon(img);
		lblFolletto.setIcon(ico);
		energyTypePanel.add(lblFolletto);

		follettoBox = new JCheckBox(Strings.FOLLETTO);
		follettoBox.setBounds(25, 200, 80, 20);
		energyTypePanel.add(follettoBox);
		typeCheckBox.add(follettoBox);

		JLabel lblIncolore = new JLabel("");
		lblIncolore.setBounds(0, 225, 20, 20);
		img = getEnergyTypeIcon("colorless").getImage().getScaledInstance(lblIncolore.getWidth(),
				lblIncolore.getHeight(), Image.SCALE_SMOOTH);
		ico = new ImageIcon(img);
		lblIncolore.setIcon(ico);
		energyTypePanel.add(lblIncolore);

		incoloreBox = new JCheckBox(Strings.INCOLORE);
		incoloreBox.setBounds(25, 225, 80, 20);
		energyTypePanel.add(incoloreBox);
		typeCheckBox.add(incoloreBox);

		JLabel lblDrago = new JLabel("");
		lblDrago.setBounds(0, 250, 20, 20);
		img = getEnergyTypeIcon("dragon").getImage().getScaledInstance(lblDrago.getWidth(), lblDrago.getHeight(),
				Image.SCALE_SMOOTH);
		ico = new ImageIcon(img);
		lblDrago.setIcon(ico);
		energyTypePanel.add(lblDrago);

		dragoBox = new JCheckBox(Strings.DRAGO);
		dragoBox.setBounds(25, 250, 80, 20);
		energyTypePanel.add(dragoBox);
		typeCheckBox.add(dragoBox);
	}

	private ImageIcon getEnergyTypeIcon(String type) {
		ImageIcon icon = new ImageIcon("resources//energytype//" + type + ".png");
		Image image = icon.getImage();
		icon = new ImageIcon(image);
		image = image.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		return icon;
	}

}