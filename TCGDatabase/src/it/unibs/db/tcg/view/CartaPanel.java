package it.unibs.db.tcg.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import it.unibs.db.tcg.model.CartaEnergia;
import it.unibs.db.tcg.model.CartaPokemon;
import it.unibs.db.tcg.model.CartaPokemonBase;
import it.unibs.db.tcg.model.CartaPokemonSpeciale;
import it.unibs.db.tcg.model.CartaStrumento;
import it.unibs.db.tcg.model.Strings;

public class CartaPanel extends JPanel {
	private static final long serialVersionUID = 3990277761264013805L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static Color backgroundColor = new Color(252, 186, 3);
	private static Color secondaryBackgroundColor = new Color(156, 156, 156);
	private static Color foregroundColor = Color.WHITE;
	private Font panelFont;

	private JButton btnBack;
	private JLabel lblPic;
	private JPanel pokemonPanel;
	private JPanel itemPanel;
	private JPanel energyPanel;

	private JLabel nrglblNum;
	private JLabel nrglblExp;
	private JLabel nrglblName;
	private JLabel nrglblValue;
	private JLabel nrglblType;
	private JLabel nrglblIllustrator;
	private JLabel nrglblRarity;
	private JLabel nrglblEnergyType;

	private JLabel itemlblNum;
	private JLabel itemlblExp;
	private JLabel itemlblName;
	private JLabel itemlblValue;
	private JLabel itemlblType;
	private JLabel itemlblIllustrator;
	private JLabel itemlblRarity;
	private JTextArea itemTextDescription;
	private JTextArea itemlblEffect;

	private JLabel pkmnlblNum;
	private JLabel pkmnlblExp;
	private JLabel pkmnlblName;
	private JLabel pkmnlblPS;
	private JLabel pkmnlblType;
	private JLabel pkmnlblIllustrator;
	private JLabel pkmnlblEnergyType;
	private JLabel pkmnlblRarity;
	private JLabel pkmnlblValue;
	private JLabel pkmnlblDebolezza;
	private JLabel pkmnlblResistenza;
	private JLabel pkmnlblCostoRitirata;
	private JLabel pkmnlblAbilita;
	private JLabel pkmnlblAttributoSpeciale;
	private JTextArea pkmnTextRule;
	private JTextArea pkmnTextDescrizione;
	private JLabel pkmnlblNomeMossa1;
	private JLabel pkmnlblDannoMossa1;
	private JTextArea pkmnDescrizioneMossa1;
	private JLabel pkmnlblNomeMossa2;
	private JLabel pkmnlblDannoMossa2;
	private JTextArea pkmnDescrizioneMossa2;

	private JLabel pkmnSlblAbilita;
	private JLabel pkmnSlblRule;
	private JLabel pkmnSlblAttributoSpeciale;

	private JPanel collectionsPanel;
	private JButton btnAddToCollection;
	private JButton btnRemoveCard;
	private JButton btnWho;
	private JButton btnNextStage;
	private JButton btnPreStage;
	private JList collectionsList;

	public CartaPanel() {
		setLayout(null);
		secondaryBackgroundColor = Preferences.getSecondaryBackgroundColor();
		backgroundColor = Preferences.getBackgroundColor();
		setBackground(backgroundColor);
		foregroundColor = Preferences.getForegroundColor();
		setForeground(foregroundColor);
		panelFont = Preferences.getFont().deriveFont(Strings.DEFAULT_SIZE_FONT - 3);
		setFont(panelFont);

		pokemonPanel = new JPanel();
		pokemonPanel.setBounds(320, 0, 480, 500);
		add(pokemonPanel);
		pokemonPanel.setFocusable(false);
		pokemonPanel.setLayout(null);
		pokemonPanel.setBackground(null);

		itemPanel = new JPanel();
		itemPanel.setBounds(320, 0, 480, 500);
		add(itemPanel);
		itemPanel.setFocusable(false);
		itemPanel.setLayout(null);
		itemPanel.setBackground(null);

		energyPanel = new JPanel();
		energyPanel.setBounds(320, 0, 480, 500);
		add(energyPanel);
		energyPanel.setFocusable(false);
		energyPanel.setLayout(null);
		energyPanel.setBackground(null);

		btnBack = new JButton("Back");
		btnBack.setBounds(650, 505, 90, 50);
		add(btnBack);

		btnNextStage = new JButton("");
		btnNextStage.setVisible(false);
		btnNextStage.setBounds(420, 505, 100, 50);
		add(btnNextStage);

		btnPreStage = new JButton("");
		btnPreStage.setVisible(false);
		btnPreStage.setBounds(320, 505, 100, 50);
		add(btnPreStage);

		lblPic = new JLabel("");
		lblPic.setBounds(60, 50, 250, 350);
		add(lblPic);

		pkmnlblNum = new JLabel("");
		pkmnlblNum.setBounds(0, 0, 30, 40);
		pkmnlblNum.setForeground(foregroundColor);
		pkmnlblNum.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnlblNum);

		pkmnlblExp = new JLabel("");
		pkmnlblExp.setBounds(30, 0, 40, 40);
		pkmnlblExp.setForeground(foregroundColor);
		pkmnlblExp.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnlblExp);

		pkmnlblName = new JLabel("");
		pkmnlblName.setBounds(70, 0, 200, 40);
		pkmnlblName.setForeground(foregroundColor);
		pkmnlblName.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnlblName);

		JLabel pkmnSlblPS = new JLabel("PS");
		pkmnSlblPS.setBounds(270, 0, 30, 40);
		pkmnSlblPS.setForeground(foregroundColor);
		pkmnSlblPS.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblPS);

		pkmnlblPS = new JLabel("");
		pkmnlblPS.setBounds(290, 0, 40, 40);
		pkmnlblPS.setForeground(foregroundColor);
		pkmnlblPS.setHorizontalAlignment(SwingConstants.CENTER);
		pkmnlblPS.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnlblPS);

		JLabel pkmnSlblType = new JLabel("Tipo Carta");
		pkmnSlblType.setBounds(0, 40, 120, 40);
		pkmnSlblType.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		pkmnSlblType.setForeground(foregroundColor);
		pkmnSlblType.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblType);

		pkmnlblType = new JLabel("");
		pkmnlblType.setBounds(120, 40, 120, 40);
		pkmnlblType.setForeground(foregroundColor);
		pkmnlblType.setFont(panelFont);
		pokemonPanel.add(pkmnlblType);

		JLabel pkmnSlblIllustrator = new JLabel("Illustratore");
		pkmnSlblIllustrator.setBounds(240, 40, 120, 40);
		pkmnSlblIllustrator.setForeground(foregroundColor);
		pkmnSlblIllustrator.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		pkmnSlblIllustrator.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblIllustrator);

		pkmnlblIllustrator = new JLabel("");
		pkmnlblIllustrator.setBounds(360, 40, 110, 40);
		pkmnlblIllustrator.setForeground(foregroundColor);
		pkmnlblIllustrator.setFont(panelFont.deriveFont(12));
		pokemonPanel.add(pkmnlblIllustrator);

		JLabel pkmnSlblEnergyType = new JLabel("Tipo Energia");
		pkmnSlblEnergyType.setBounds(0, 80, 100, 40);
		pkmnSlblEnergyType.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		pkmnSlblEnergyType.setForeground(foregroundColor);
		pkmnSlblEnergyType.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblEnergyType);

		pkmnlblEnergyType = new JLabel("");
		pkmnlblEnergyType.setBounds(120, 80, 120, 40);
		pkmnlblEnergyType.setForeground(foregroundColor);
		pkmnlblEnergyType.setFont(panelFont);
		pokemonPanel.add(pkmnlblEnergyType);

		JLabel pkmnSlblRarity = new JLabel("Rarità");
		pkmnSlblRarity.setBounds(240, 80, 120, 40);
		pkmnSlblRarity.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		pkmnSlblRarity.setForeground(foregroundColor);
		pkmnSlblRarity.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblRarity);

		pkmnlblRarity = new JLabel("");
		pkmnlblRarity.setBounds(360, 80, 110, 40);
		pkmnlblRarity.setForeground(foregroundColor);
		pkmnlblRarity.setFont(panelFont.deriveFont(12));
		pokemonPanel.add(pkmnlblRarity);

		JLabel pkmnSlblValue = new JLabel("Valore");
		pkmnSlblValue.setBounds(345, 0, 55, 40);
		pkmnSlblValue.setForeground(foregroundColor);
		pkmnSlblValue.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblValue);

		pkmnlblValue = new JLabel("");
		pkmnlblValue.setBounds(400, 0, 60, 40);
		pkmnlblValue.setForeground(foregroundColor);
		pkmnlblValue.setFont(panelFont);
		pokemonPanel.add(pkmnlblValue);

		JLabel pkmnSlblDebolezza = new JLabel("Debolezza");
		pkmnSlblDebolezza.setBounds(0, 120, 120, 40);
		pkmnSlblDebolezza.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		pkmnSlblDebolezza.setForeground(foregroundColor);
		pkmnSlblDebolezza.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblDebolezza);

		pkmnlblDebolezza = new JLabel("");
		pkmnlblDebolezza.setBounds(120, 120, 120, 40);
		pkmnlblDebolezza.setForeground(foregroundColor);
		pkmnlblDebolezza.setFont(panelFont);
		pokemonPanel.add(pkmnlblDebolezza);

		JLabel pkmnSlblResistenza = new JLabel("Resistenza");
		pkmnSlblResistenza.setBounds(240, 120, 120, 40);
		pkmnSlblResistenza.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		pkmnSlblResistenza.setForeground(foregroundColor);
		pkmnSlblResistenza.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblResistenza);

		pkmnlblResistenza = new JLabel("");
		pkmnlblResistenza.setBounds(360, 120, 110, 40);
		pkmnlblResistenza.setForeground(foregroundColor);
		pkmnlblResistenza.setFont(panelFont);
		pokemonPanel.add(pkmnlblResistenza);

		JLabel pkmnSlblCostoRitirata = new JLabel("Costo Ritirata");
		pkmnSlblCostoRitirata.setBounds(0, 160, 120, 40);
		pkmnSlblCostoRitirata.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		pkmnSlblCostoRitirata.setForeground(foregroundColor);
		pkmnSlblCostoRitirata.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblCostoRitirata);

		pkmnlblCostoRitirata = new JLabel("");
		pkmnlblCostoRitirata.setBounds(120, 160, 120, 40);
		pkmnlblCostoRitirata.setForeground(foregroundColor);
		pkmnlblCostoRitirata.setFont(panelFont);
		pokemonPanel.add(pkmnlblCostoRitirata);

		pkmnSlblAbilita = new JLabel("Abilità");
		pkmnSlblAbilita.setBounds(240, 160, 120, 40);
		pkmnSlblAbilita.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		pkmnSlblAbilita.setForeground(foregroundColor);
		pkmnSlblAbilita.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblAbilita);

		pkmnlblAbilita = new JLabel("");
		pkmnlblAbilita.setBounds(360, 160, 110, 40);
		pkmnlblAbilita.setForeground(foregroundColor);
		pkmnlblAbilita.setFont(panelFont);
		pokemonPanel.add(pkmnlblAbilita);

		pkmnSlblAttributoSpeciale = new JLabel("Attr. Spec.");
		pkmnSlblAttributoSpeciale.setBounds(0, 200, 85, 75);
		pkmnSlblAttributoSpeciale.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		pkmnSlblAttributoSpeciale.setForeground(foregroundColor);
		pkmnSlblAttributoSpeciale.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblAttributoSpeciale);

		pkmnlblAttributoSpeciale = new JLabel("");
		pkmnlblAttributoSpeciale.setBounds(85, 200, 30, 75);
		pkmnlblAttributoSpeciale.setForeground(foregroundColor);
		pkmnlblAttributoSpeciale.setFont(panelFont);
		pokemonPanel.add(pkmnlblAttributoSpeciale);

		pkmnSlblRule = new JLabel("Regola");
		pkmnSlblRule.setBounds(120, 200, 60, 75);
		pkmnSlblRule.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		pkmnSlblRule.setForeground(foregroundColor);
		pkmnSlblRule.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblRule);

		pkmnTextRule = new JTextArea("");
		pkmnTextRule.setBounds(180, 200, 300, 75);
		pkmnTextRule.setForeground(foregroundColor);
		pkmnTextRule.setFont(panelFont.deriveFont(14));
		pkmnTextRule.setAlignmentY(CENTER_ALIGNMENT);
		pkmnTextRule.setEditable(false);
		pkmnTextRule.setLineWrap(true);
		pkmnTextRule.setOpaque(false);
		pkmnTextRule.setWrapStyleWord(true);
		pokemonPanel.add(pkmnTextRule);

		pkmnTextDescrizione = new JTextArea("");
		pkmnTextDescrizione.setBounds(0, 275, 200, 225);
		pkmnTextDescrizione.setForeground(foregroundColor);
		pkmnTextDescrizione.setFont(panelFont.deriveFont(Font.ITALIC).deriveFont(14));
		pkmnTextDescrizione.setEditable(false);
		pkmnTextDescrizione.setLineWrap(true);
		pkmnTextDescrizione.setOpaque(false);
		pkmnTextDescrizione.setWrapStyleWord(true);
		pokemonPanel.add(pkmnTextDescrizione);

		pkmnlblNomeMossa1 = new JLabel("");
		pkmnlblNomeMossa1.setBounds(210, 275, 180, 30);
		pkmnlblNomeMossa1.setForeground(foregroundColor);
		pkmnlblNomeMossa1.setFont(panelFont);
		pokemonPanel.add(pkmnlblNomeMossa1);

		pkmnlblDannoMossa1 = new JLabel("");
		pkmnlblDannoMossa1.setBounds(390, 275, 90, 30);
		pkmnlblDannoMossa1.setForeground(foregroundColor);
		pkmnlblDannoMossa1.setFont(panelFont);
		pokemonPanel.add(pkmnlblDannoMossa1);

		pkmnDescrizioneMossa1 = new JTextArea("");
		pkmnDescrizioneMossa1.setBounds(210, 305, 280, 80);
		pkmnDescrizioneMossa1.setForeground(foregroundColor);
		pkmnDescrizioneMossa1.setFont(panelFont.deriveFont(14));
		pkmnDescrizioneMossa1.setEditable(false);
		pkmnDescrizioneMossa1.setLineWrap(true);
		pkmnDescrizioneMossa1.setOpaque(false);
		pkmnDescrizioneMossa1.setWrapStyleWord(true);
		pokemonPanel.add(pkmnDescrizioneMossa1);

		pkmnlblNomeMossa2 = new JLabel("");
		pkmnlblNomeMossa2.setBounds(210, 385, 180, 30);
		pkmnlblNomeMossa2.setForeground(foregroundColor);
		pkmnlblNomeMossa2.setFont(panelFont);
		pokemonPanel.add(pkmnlblNomeMossa2);

		pkmnlblDannoMossa2 = new JLabel("");
		pkmnlblDannoMossa2.setBounds(390, 385, 90, 30);
		pkmnlblDannoMossa2.setForeground(foregroundColor);
		pkmnlblDannoMossa2.setFont(panelFont);
		pokemonPanel.add(pkmnlblDannoMossa2);

		pkmnDescrizioneMossa2 = new JTextArea("");
		pkmnDescrizioneMossa2.setBounds(210, 415, 280, 80);
		pkmnDescrizioneMossa2.setForeground(foregroundColor);
		pkmnDescrizioneMossa2.setFont(panelFont.deriveFont(14));
		pkmnDescrizioneMossa2.setEditable(false);
		pkmnDescrizioneMossa2.setLineWrap(true);
		pkmnDescrizioneMossa2.setOpaque(false);
		pkmnDescrizioneMossa2.setWrapStyleWord(true);
		pokemonPanel.add(pkmnDescrizioneMossa2);

		/* ITEM PANEL COMPONENTS */
		itemlblNum = new JLabel("");
		itemlblNum.setBounds(0, 0, 30, 40);
		itemlblNum.setForeground(foregroundColor);
		itemlblNum.setFont(panelFont.deriveFont(Font.BOLD));
		itemPanel.add(itemlblNum);

		itemlblExp = new JLabel("");
		itemlblExp.setBounds(30, 0, 40, 40);
		itemlblExp.setForeground(foregroundColor);
		itemlblExp.setFont(panelFont.deriveFont(Font.BOLD));
		itemPanel.add(itemlblExp);

		itemlblName = new JLabel("");
		itemlblName.setBounds(70, 0, 215, 40);
		itemlblName.setForeground(foregroundColor);
		itemlblName.setFont(panelFont.deriveFont(Font.BOLD));
		itemPanel.add(itemlblName);

		JLabel itemSlblValue = new JLabel("Valore");
		itemSlblValue.setBounds(345, 0, 55, 40);
		itemSlblValue.setForeground(foregroundColor);
		itemSlblValue.setFont(panelFont.deriveFont(Font.BOLD));
		itemPanel.add(itemSlblValue);

		itemlblValue = new JLabel("");
		itemlblValue.setBounds(400, 0, 60, 40);
		itemlblValue.setForeground(foregroundColor);
		itemlblValue.setFont(panelFont);
		itemPanel.add(itemlblValue);

		JLabel itemSlblRarity = new JLabel("Rarità");
		itemSlblRarity.setBounds(240, 80, 50, 40);
		itemSlblRarity.setForeground(foregroundColor);
		itemSlblRarity.setFont(panelFont.deriveFont(Font.BOLD));
		itemPanel.add(itemSlblRarity);

		itemlblRarity = new JLabel("");
		itemlblRarity.setBounds(360, 80, 120, 40);
		itemlblRarity.setForeground(foregroundColor);
		itemlblRarity.setFont(panelFont);
		itemPanel.add(itemlblRarity);

		JLabel itemSlblType = new JLabel("Tipo Carta");
		itemSlblType.setBounds(0, 40, 120, 40);
		itemSlblType.setForeground(foregroundColor);
		itemSlblType.setFont(panelFont.deriveFont(Font.BOLD));
		itemPanel.add(itemSlblType);

		itemlblType = new JLabel("");
		itemlblType.setBounds(120, 40, 120, 40);
		itemlblType.setForeground(foregroundColor);
		itemlblType.setFont(panelFont);
		itemPanel.add(itemlblType);

		JLabel itemSlblIllustrator = new JLabel("Illustratore");
		itemSlblIllustrator.setBounds(240, 40, 120, 40);
		itemSlblIllustrator.setForeground(foregroundColor);
		itemSlblIllustrator.setFont(panelFont.deriveFont(Font.BOLD));
		itemPanel.add(itemSlblIllustrator);

		itemlblIllustrator = new JLabel("");
		itemlblIllustrator.setBounds(360, 40, 120, 40);
		itemlblIllustrator.setForeground(foregroundColor);
		itemlblIllustrator.setFont(panelFont);
		itemPanel.add(itemlblIllustrator);

		itemTextDescription = new JTextArea("");
		itemTextDescription.setBounds(0, 275, 200, 225);
		itemTextDescription.setForeground(foregroundColor);
		itemTextDescription.setFont(panelFont.deriveFont(Font.ITALIC));
		itemTextDescription.setEditable(false);
		itemTextDescription.setLineWrap(true);
		itemTextDescription.setOpaque(false);
		itemTextDescription.setWrapStyleWord(true);
		itemPanel.add(itemTextDescription);

		itemlblEffect = new JTextArea("");
		itemlblEffect.setBounds(200, 275, 200, 225);
		itemlblEffect.setForeground(foregroundColor);
		itemlblEffect.setFont(panelFont.deriveFont(Font.ITALIC));
		itemlblEffect.setEditable(false);
		itemlblEffect.setLineWrap(true);
		itemlblEffect.setOpaque(false);
		itemlblEffect.setWrapStyleWord(true);
		itemPanel.add(itemlblEffect);

		/* ENERGY PANEL */
		nrglblNum = new JLabel("");
		nrglblNum.setBounds(0, 0, 30, 40);
		nrglblNum.setForeground(foregroundColor);
		nrglblNum.setFont(panelFont.deriveFont(Font.BOLD));
		energyPanel.add(nrglblNum);

		nrglblExp = new JLabel("");
		nrglblExp.setBounds(30, 0, 30, 40);
		nrglblExp.setForeground(foregroundColor);
		nrglblExp.setFont(panelFont.deriveFont(Font.BOLD));
		energyPanel.add(nrglblExp);

		nrglblName = new JLabel("");
		nrglblName.setBounds(60, 0, 200, 40);
		nrglblName.setForeground(foregroundColor);
		nrglblName.setFont(panelFont.deriveFont(Font.BOLD));
		energyPanel.add(nrglblName);

		JLabel nrgSlblValue = new JLabel("Valore");
		nrgSlblValue.setBounds(350, 0, 70, 40);
		nrgSlblValue.setForeground(foregroundColor);
		nrgSlblValue.setFont(panelFont.deriveFont(Font.BOLD));
		energyPanel.add(nrgSlblValue);

		nrglblValue = new JLabel("");
		nrglblValue.setBounds(420, 0, 60, 40);
		nrglblValue.setForeground(foregroundColor);
		nrglblValue.setFont(panelFont);
		energyPanel.add(nrglblValue);

		JLabel nrgSlblRarity = new JLabel("Rarità");
		nrgSlblRarity.setBounds(240, 80, 120, 40);
		nrgSlblRarity.setForeground(foregroundColor);
		nrgSlblRarity.setFont(panelFont.deriveFont(Font.BOLD));
		energyPanel.add(nrgSlblRarity);

		nrglblRarity = new JLabel("");
		nrglblRarity.setBounds(360, 80, 80, 40);
		nrglblRarity.setForeground(foregroundColor);
		nrglblRarity.setFont(panelFont);
		energyPanel.add(nrglblRarity);

		JLabel nrgSlblType = new JLabel("Tipo Carta");
		nrgSlblType.setBounds(0, 40, 120, 40);
		nrgSlblType.setForeground(foregroundColor);
		nrgSlblType.setFont(panelFont.deriveFont(Font.BOLD));
		energyPanel.add(nrgSlblType);

		nrglblType = new JLabel("");
		nrglblType.setBounds(120, 40, 120, 40);
		nrglblType.setForeground(foregroundColor);
		nrglblType.setFont(panelFont);
		energyPanel.add(nrglblType);

		JLabel nrgSlblIllustrator = new JLabel("Illustratore");
		nrgSlblIllustrator.setBounds(240, 40, 120, 40);
		nrgSlblIllustrator.setForeground(foregroundColor);
		nrgSlblIllustrator.setFont(panelFont.deriveFont(Font.BOLD));
		energyPanel.add(nrgSlblIllustrator);

		nrglblIllustrator = new JLabel("");
		nrglblIllustrator.setBounds(360, 40, 120, 40);
		nrglblIllustrator.setForeground(foregroundColor);
		nrglblIllustrator.setFont(panelFont);
		energyPanel.add(nrglblIllustrator);

		JLabel nrgSlblEnergyType = new JLabel("Tipo Energia");
		nrgSlblEnergyType.setBounds(0, 80, 100, 40);
		nrgSlblEnergyType.setForeground(foregroundColor);
		nrgSlblEnergyType.setFont(panelFont.deriveFont(Font.BOLD));
		energyPanel.add(nrgSlblEnergyType);

		nrglblEnergyType = new JLabel("");
		nrglblEnergyType.setBounds(120, 80, 70, 40);
		nrglblEnergyType.setForeground(foregroundColor);
		nrglblEnergyType.setFont(panelFont);
		energyPanel.add(nrglblEnergyType);

		btnAddToCollection = new JButton("Aggiungi a una collezione");
		btnAddToCollection.setBounds(60, 410, 100, 100);
		btnAddToCollection.setToolTipText("Aggiungi questa carta ad una collezione");
		btnAddToCollection.setIcon(new ImageIcon(new ImageIcon("resources//icon//add_card_to_collection_icon.png")
				.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH)));
		add(btnAddToCollection);

		btnRemoveCard = new JButton("Rimuovi da una collezione");
		btnRemoveCard.setBounds(210, 410, 100, 100);
		btnRemoveCard.setToolTipText("Rimuovi questa carta da una collezione");
		btnRemoveCard.setIcon(new ImageIcon(new ImageIcon("resources//icon//remove_card_from_collection_icon.png")
				.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH)));
		btnRemoveCard.setVisible(false);
		add(btnRemoveCard);

		btnWho = new JButton("Chi ha questa carta?");
		btnWho.setBounds(60, 515, 250, 40);
		btnWho.setFont(panelFont);
		btnWho.setToolTipText("Visualizza quali utenti possiedono questa carta");
		add(btnWho);

	}

	public void addAddToCollectionListener(ActionListener a) {
		btnAddToCollection.addActionListener(a);
	}

	public void addBtnWhoListener(ActionListener a) {
		btnWho.addActionListener(a);
	}

	public void createCollectionListPopup(DefaultListModel<String> collectionsName) {
		collectionsPanel = new JPanel();
		collectionsPanel.setPreferredSize(new Dimension(200, 250));
		if (collectionsName.size() == 0) {
			JLabel lblNoCollection = new JLabel("Non sono presenti collezioni qui");
			lblNoCollection.setBounds(0, 0, 200, 50);
			collectionsPanel.add(lblNoCollection);
		} else {
			collectionsList = new JList(collectionsName);
			collectionsList.setBounds(0, 0, 190, 150);
			collectionsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			collectionsList.setBackground(null);
			collectionsList.setFont(panelFont);
			collectionsList.setFixedCellWidth(collectionsList.getWidth());
			collectionsList.setBorder(new LineBorder(Color.BLACK));
			JScrollPane scrollPane = new JScrollPane(this, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setViewportView(collectionsList);
			scrollPane.setBounds(0, 0, 200, 150);
			collectionsPanel.add(scrollPane);
		}
	}

	public String showCollectionsListPopup() {
		JOptionPane.showMessageDialog(this, collectionsPanel, "Scegli la collezione", JOptionPane.QUESTION_MESSAGE);
		return (String) collectionsList.getSelectedValue();
	}

	public void showNoSelectedPopup() {
		JOptionPane.showMessageDialog(this, "Attenzione, non hai selezionato alcuna collezione");
	}

	public void showErrorPopup() {
		JOptionPane.showMessageDialog(this, "Attenzione, è già presente questa carta nella collezione selezionata");
	}

	public void showCorrectInsertPopup() {
		JOptionPane.showMessageDialog(this, "Inserimento avvenuto correttamente");
	}

	public void setSpecsCartaStrumento(CartaStrumento carta) {
		itemPanel.setVisible(true);
		pokemonPanel.setVisible(false);
		energyPanel.setVisible(false);
		Image image = carta.getImmagine().getImage();
		image = image.getScaledInstance(lblPic.getWidth(), lblPic.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(image);
		lblPic.setIcon(icon);
		itemlblNum.setText(String.valueOf(carta.getNumero()));
		itemlblExp.setText(carta.getAbbrEspansione());
		itemlblType.setText("Strumento");
		itemlblName.setText(carta.getNome());
		itemlblIllustrator.setText(carta.getIllustratore());
		itemlblRarity.setText(carta.getRarita());
		itemlblValue.setText(String.valueOf(carta.getValore()) + " €");
		itemTextDescription.setText(carta.getDescrizione());
		itemlblEffect.setText(carta.getEffetto());
	}

	public void setSpecsCartaEnergia(CartaEnergia carta) {
		energyPanel.setVisible(true);
		pokemonPanel.setVisible(false);
		itemPanel.setVisible(false);
		Image image = carta.getImmagine().getImage();
		image = image.getScaledInstance(lblPic.getWidth(), lblPic.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(image);
		lblPic.setIcon(icon);
		nrglblNum.setText(String.valueOf(carta.getNumero()));
		nrglblExp.setText(carta.getAbbrEspansione());
		nrglblType.setText("Energia");
		nrglblName.setText(carta.getNome());
		nrglblIllustrator.setText(carta.getIllustratore());
		nrglblRarity.setText(carta.getRarita());
		nrglblValue.setText(String.valueOf(carta.getValore()) + " €");
		nrglblEnergyType.setText(carta.getTipo());

	}

	public void setSpecsCartaPokemon(CartaPokemonBase carta) {
		pkmnSlblRule.setVisible(false);
		pkmnSlblAttributoSpeciale.setVisible(false);
		pokemonPanel.setVisible(true);
		itemPanel.setVisible(false);
		energyPanel.setVisible(false);
		setCommonPokemonSpecs(carta);
		pkmnlblAbilita.setText(carta.getAbilita());
	}

	public void setSpecsCartaPokemon(CartaPokemonSpeciale carta) {
		pokemonPanel.setVisible(true);
		itemPanel.setVisible(false);
		energyPanel.setVisible(false);
		pkmnSlblAbilita.setVisible(false);
		setCommonPokemonSpecs(carta);
		pkmnlblAttributoSpeciale.setText(carta.getAttributoSpeciale());
		pkmnTextRule.setText(carta.getRegola());
	}

	private void setCommonPokemonSpecs(CartaPokemon carta) {
		Image image = carta.getImmagine().getImage();
		image = image.getScaledInstance(lblPic.getWidth(), lblPic.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(image);
		lblPic.setIcon(icon);
		pkmnlblNum.setText(String.valueOf(carta.getNumero()));
		pkmnlblExp.setText(carta.getAbbrEspansione());
		pkmnlblType.setText("Pokemon");
		pkmnlblName.setText(carta.getNome());
		pkmnlblIllustrator.setText(carta.getIllustratore());
		pkmnlblRarity.setText(carta.getRarita());
		pkmnlblValue.setText(String.valueOf(carta.getValore()) + " €");
		pkmnlblPS.setText(String.valueOf(carta.getPS()));
		pkmnlblEnergyType.setText(carta.getTipoEnergia());
		pkmnlblCostoRitirata.setText(String.valueOf(carta.getCostoRitirata()));
		pkmnTextDescrizione.setText(carta.getDescrizione());
		pkmnlblDebolezza.setText(carta.getDebolezza());
		pkmnlblResistenza.setText(carta.getResistenza());
		if (carta.getMosse().size() > 0 && carta.getMosse().get(0) != null) {
			pkmnlblNomeMossa1.setText(carta.getMosse().get(0).getNomeMossa());
			pkmnlblDannoMossa1.setText("" + carta.getMosse().get(0).getDanno());
			pkmnDescrizioneMossa1.setText(carta.getMosse().get(0).getDescrizione());
		}
		if (carta.getMosse().size() > 1 && carta.getMosse().get(1) != null) {
			pkmnlblNomeMossa2.setText(carta.getMosse().get(1).getNomeMossa());
			pkmnlblDannoMossa2.setText("" + carta.getMosse().get(1).getDanno());
			pkmnDescrizioneMossa2.setText(carta.getMosse().get(1).getDescrizione());
		}
	}

	public void setVisibleRemoveCardButton() {
		btnRemoveCard.setVisible(true);
	}

	public void setBtnNextStageText(String text) {
		btnNextStage.setVisible(true);
		btnNextStage.setText(text);
	}

	public void addNextStageActionListener(ActionListener a) {
		btnNextStage.addActionListener(a);
	}

	public void setBtnPreStageText(String text) {
		btnPreStage.setVisible(true);
		btnPreStage.setText(text);
	}

	public void addPreStageActionListener(ActionListener a) {
		btnPreStage.addActionListener(a);
	}

	public void callBackDoClick() {
		btnBack.doClick();
	}

	public void addRemoveCardListener(ActionListener a) {
		btnRemoveCard.addActionListener(a);
	}

	public void addBackListener(ActionListener a) {
		btnBack.addActionListener(a);
	}

}
