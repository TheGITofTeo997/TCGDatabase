package it.unibs.db.tcg.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import it.unibs.db.tcg.model.Carta;
import it.unibs.db.tcg.model.CartaEnergia;
import it.unibs.db.tcg.model.CartaPokemon;
import it.unibs.db.tcg.model.CartaPokemonBase;
import it.unibs.db.tcg.model.CartaPokemonSpeciale;
import it.unibs.db.tcg.model.CartaStrumento;

public class CartaPanel extends JPanel {
	private static final long serialVersionUID = 3990277761264013805L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static Color backgroundColor = new Color(252, 186, 3);
	private static Color secondaryBackgroundColor = new Color(156, 156, 156);
	private static Color foregroundColor = Color.WHITE;
	private static Font panelFont = new Font("Serif", 0, 15);

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
	private JLabel itemlblDescription;
	private JLabel itemlblEffect;

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
	private JLabel pkmnlblRule;
	private JLabel pkmnlblDescription;
	private JLabel pkmnlblNomeMossa1;
	private JLabel pkmnlblDannoMossa1;
	private JLabel pkmnlblDescrizioneMossa1;
	private JLabel pkmnlblNomeMossa2;
	private JLabel pkmnlblDannoMossa2;
	private JLabel pkmnlblDescrizioneMossa2;

	public CartaPanel() {
		setLayout(null);
		setBackground(backgroundColor);
		setForeground(foregroundColor);
		setFont(panelFont);
		setVisible(true);

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

		lblPic = new JLabel("");
		lblPic.setBounds(60, 50, 250, 350);
		add(lblPic);

		pkmnlblNum = new JLabel("");
		pkmnlblNum.setBounds(0, 0, 30, 40);
		pkmnlblNum.setForeground(foregroundColor);
		pkmnlblNum.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnlblNum);

		pkmnlblExp = new JLabel("");
		pkmnlblExp.setBounds(30, 0, 30, 40);
		pkmnlblExp.setForeground(foregroundColor);
		pkmnlblExp.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnlblExp);

		pkmnlblName = new JLabel("");
		pkmnlblName.setBounds(60, 0, 250, 40);
		pkmnlblName.setForeground(foregroundColor);
		pkmnlblName.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnlblName);

		JLabel pkmnSlblPS = new JLabel("PS");
		pkmnSlblPS.setBounds(310, 0, 30, 40);
		pkmnSlblPS.setForeground(foregroundColor);
		pkmnSlblPS.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblPS);

		pkmnlblPS = new JLabel("");
		pkmnlblPS.setBounds(340, 0, 30, 40);
		pkmnlblPS.setForeground(foregroundColor);
		pkmnlblPS.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnlblPS);

		JLabel pkmnSlblType = new JLabel("Tipo Carta");
		pkmnSlblType.setBounds(0, 40, 120, 40);
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
		pkmnSlblIllustrator.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblIllustrator);

		pkmnlblIllustrator = new JLabel("");
		pkmnlblIllustrator.setBounds(360, 40, 120, 40);
		pkmnlblIllustrator.setForeground(foregroundColor);
		pkmnlblIllustrator.setFont(panelFont);
		pokemonPanel.add(pkmnlblIllustrator);

		JLabel pkmnSlblEnergyType = new JLabel("Tipo Energia");
		pkmnSlblEnergyType.setBounds(0, 80, 100, 40);
		pkmnSlblEnergyType.setForeground(foregroundColor);
		pkmnSlblEnergyType.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblEnergyType);

		pkmnlblEnergyType = new JLabel("");
		pkmnlblEnergyType.setBounds(100, 80, 70, 40);
		pkmnlblEnergyType.setForeground(foregroundColor);
		pkmnlblEnergyType.setFont(panelFont);
		pokemonPanel.add(pkmnlblEnergyType);

		JLabel pkmnSlblRarity = new JLabel("Rarità");
		pkmnSlblRarity.setBounds(240, 80, 50, 40);
		pkmnSlblRarity.setForeground(foregroundColor);
		pkmnSlblRarity.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblRarity);

		pkmnlblRarity = new JLabel("");
		pkmnlblRarity.setBounds(290, 80, 80, 40);
		pkmnlblRarity.setForeground(foregroundColor);
		pkmnlblRarity.setFont(panelFont);
		pokemonPanel.add(pkmnlblRarity);

		JLabel pkmnSlblValue = new JLabel("Valore");
		pkmnSlblValue.setBounds(370, 0, 50, 40);
		pkmnSlblValue.setForeground(foregroundColor);
		pkmnSlblValue.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblValue);

		pkmnlblValue = new JLabel("");
		pkmnlblValue.setBounds(420, 0, 60, 40);
		pkmnlblValue.setForeground(foregroundColor);
		pkmnlblValue.setFont(panelFont);
		pokemonPanel.add(pkmnlblValue);

		JLabel pkmnSlblDebolezza = new JLabel("Debolezza");
		pkmnSlblDebolezza.setBounds(0, 120, 120, 40);
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
		pkmnSlblResistenza.setForeground(foregroundColor);
		pkmnSlblResistenza.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblResistenza);

		pkmnlblResistenza = new JLabel("");
		pkmnlblResistenza.setBounds(360, 120, 120, 40);
		pkmnlblResistenza.setForeground(foregroundColor);
		pkmnlblResistenza.setFont(panelFont);
		pokemonPanel.add(pkmnlblResistenza);

		JLabel pkmnSlblCostoRitirata = new JLabel("Costo di Ritirata");
		pkmnSlblCostoRitirata.setBounds(0, 160, 120, 40);
		pkmnSlblCostoRitirata.setForeground(foregroundColor);
		pkmnSlblCostoRitirata.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblCostoRitirata);

		pkmnlblCostoRitirata = new JLabel("");
		pkmnlblCostoRitirata.setBounds(120, 160, 120, 40);
		pkmnlblCostoRitirata.setForeground(foregroundColor);
		pkmnlblCostoRitirata.setFont(panelFont);
		pokemonPanel.add(pkmnlblCostoRitirata);

		JLabel pkmnSlblAbilita = new JLabel("Abilità");
		pkmnSlblAbilita.setBounds(240, 160, 120, 40);
		pkmnSlblAbilita.setForeground(foregroundColor);
		pkmnSlblAbilita.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblAbilita);

		pkmnlblAbilita = new JLabel("");
		pkmnlblAbilita.setBounds(360, 160, 120, 40);
		pkmnlblAbilita.setForeground(foregroundColor);
		pkmnlblAbilita.setFont(panelFont);
		pokemonPanel.add(pkmnlblAbilita);

		JLabel pkmnSlblAttributoSpeciale = new JLabel("Attr. Spec.");
		pkmnSlblAttributoSpeciale.setBounds(0, 200, 100, 75);
		pkmnSlblAttributoSpeciale.setForeground(foregroundColor);
		pkmnSlblAttributoSpeciale.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblAttributoSpeciale);

		pkmnlblAttributoSpeciale = new JLabel("");
		pkmnlblAttributoSpeciale.setBounds(100, 200, 30, 75);
		pkmnlblAttributoSpeciale.setForeground(foregroundColor);
		pkmnlblAttributoSpeciale.setFont(panelFont);
		pokemonPanel.add(pkmnlblAttributoSpeciale);

		JLabel pkmnSlblRule = new JLabel("Regola");
		pkmnSlblRule.setBounds(150, 200, 50, 75);
		pkmnSlblRule.setForeground(foregroundColor);
		pkmnSlblRule.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblRule);

		pkmnlblRule = new JLabel("");
		pkmnlblRule.setBounds(200, 200, 280, 75);
		pkmnlblRule.setForeground(foregroundColor);
		pkmnlblRule.setFont(panelFont);
		pokemonPanel.add(pkmnlblRule);

		pkmnlblDescription = new JLabel("");
		pkmnlblDescription.setBounds(0, 275, 200, 225);
		pkmnlblDescription.setForeground(foregroundColor);
		pkmnlblDescription.setVerticalAlignment(1);
		pkmnlblDescription.setFont(panelFont.deriveFont(Font.ITALIC));
		pokemonPanel.add(pkmnlblDescription);

		pkmnlblNomeMossa1 = new JLabel("");
		pkmnlblNomeMossa1.setBounds(200, 275, 180, 30);
		pkmnlblNomeMossa1.setForeground(foregroundColor);
		pkmnlblNomeMossa1.setFont(panelFont);
		pokemonPanel.add(pkmnlblNomeMossa1);

		pkmnlblDannoMossa1 = new JLabel("");
		pkmnlblDannoMossa1.setBounds(380, 275, 100, 30);
		pkmnlblDannoMossa1.setForeground(foregroundColor);
		pkmnlblDannoMossa1.setFont(panelFont);
		pokemonPanel.add(pkmnlblDannoMossa1);

		pkmnlblDescrizioneMossa1 = new JLabel("");
		pkmnlblDescrizioneMossa1.setBounds(200, 305, 280, 80);
		pkmnlblDescrizioneMossa1.setForeground(foregroundColor);
		pkmnlblDescrizioneMossa1.setFont(panelFont);
		pokemonPanel.add(pkmnlblDescrizioneMossa1);

		pkmnlblNomeMossa2 = new JLabel("");
		pkmnlblNomeMossa2.setBounds(385, 275, 180, 30);
		pkmnlblNomeMossa2.setForeground(foregroundColor);
		pkmnlblNomeMossa2.setFont(panelFont);
		pokemonPanel.add(pkmnlblNomeMossa2);

		pkmnlblDannoMossa2 = new JLabel("");
		pkmnlblDannoMossa2.setBounds(385, 275, 100, 30);
		pkmnlblDannoMossa2.setForeground(foregroundColor);
		pkmnlblDannoMossa2.setFont(panelFont);
		pokemonPanel.add(pkmnlblDannoMossa2);

		pkmnlblDescrizioneMossa2 = new JLabel("");
		pkmnlblDescrizioneMossa2.setBounds(200, 415, 280, 80);
		pkmnlblDescrizioneMossa2.setForeground(foregroundColor);
		pkmnlblDescrizioneMossa2.setFont(panelFont);
		pokemonPanel.add(pkmnlblDescrizioneMossa2);

		/* ITEM PANEL COMPONENTS */
		itemlblNum = new JLabel("");
		itemlblNum.setBounds(0, 0, 30, 40);
		itemlblNum.setForeground(foregroundColor);
		itemlblNum.setFont(panelFont.deriveFont(Font.BOLD));
		itemPanel.add(itemlblNum);

		itemlblExp = new JLabel("");
		itemlblExp.setBounds(30, 0, 30, 40);
		itemlblExp.setForeground(foregroundColor);
		itemlblExp.setFont(panelFont.deriveFont(Font.BOLD));
		itemPanel.add(itemlblExp);

		itemlblName = new JLabel("");
		itemlblName.setBounds(60, 0, 250, 40);
		itemlblName.setForeground(foregroundColor);
		itemlblName.setFont(panelFont.deriveFont(Font.BOLD));
		itemPanel.add(itemlblName);

		JLabel itemSlblValue = new JLabel("Valore");
		itemSlblValue.setBounds(370, 0, 50, 40);
		itemSlblValue.setForeground(foregroundColor);
		itemSlblValue.setFont(panelFont.deriveFont(Font.BOLD));
		itemPanel.add(itemSlblValue);

		itemlblValue = new JLabel("");
		itemlblValue.setBounds(420, 0, 60, 40);
		itemlblValue.setForeground(foregroundColor);
		itemlblValue.setFont(panelFont);
		itemPanel.add(itemlblValue);

		JLabel itemSlblRarity = new JLabel("Rarità");
		itemSlblRarity.setBounds(240, 80, 50, 40);
		itemSlblRarity.setForeground(foregroundColor);
		itemSlblRarity.setFont(panelFont.deriveFont(Font.BOLD));
		itemPanel.add(itemSlblRarity);

		itemlblRarity = new JLabel("");
		itemlblRarity.setBounds(290, 80, 80, 40);
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

		itemlblDescription = new JLabel("");
		itemlblDescription.setBounds(0, 275, 200, 225);
		itemlblDescription.setForeground(foregroundColor);
		itemlblDescription.setVerticalAlignment(1);
		itemlblDescription.setFont(panelFont.deriveFont(Font.ITALIC));
		itemPanel.add(itemlblDescription);

		itemlblEffect = new JLabel("");
		itemlblEffect.setBounds(200, 275, 200, 225);
		itemlblEffect.setForeground(foregroundColor);
		itemlblEffect.setFont(panelFont);
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
		nrglblName.setBounds(60, 0, 250, 40);
		nrglblName.setForeground(foregroundColor);
		nrglblName.setFont(panelFont.deriveFont(Font.BOLD));
		energyPanel.add(nrglblName);

		JLabel nrgSlblValue = new JLabel("Valore");
		nrgSlblValue.setBounds(370, 0, 50, 40);
		nrgSlblValue.setForeground(foregroundColor);
		nrgSlblValue.setFont(panelFont.deriveFont(Font.BOLD));
		energyPanel.add(nrgSlblValue);

		nrglblValue = new JLabel("");
		nrglblValue.setBounds(420, 0, 60, 40);
		nrglblValue.setForeground(foregroundColor);
		nrglblValue.setFont(panelFont);
		energyPanel.add(nrglblValue);

		JLabel nrgSlblRarity = new JLabel("Rarità");
		nrgSlblRarity.setBounds(240, 80, 50, 40);
		nrgSlblRarity.setForeground(foregroundColor);
		nrgSlblRarity.setFont(panelFont.deriveFont(Font.BOLD));
		energyPanel.add(nrgSlblRarity);

		nrglblRarity = new JLabel("");
		nrglblRarity.setBounds(290, 80, 80, 40);
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
		nrglblEnergyType.setBounds(100, 80, 70, 40);
		nrglblEnergyType.setForeground(foregroundColor);
		nrglblEnergyType.setFont(panelFont);
		energyPanel.add(nrglblEnergyType);

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
		itemlblDescription.setText(carta.getDescrizione());
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
		setCommonPokemonSpecs(carta);
		pkmnlblAttributoSpeciale.setText(carta.getAttributoSpeciale());
		pkmnlblRule.setText(carta.getRegola());
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
		pkmnlblDescription.setText(carta.getDescrizione());
		pkmnlblDebolezza.setText(carta.getDebolezza());
		pkmnlblResistenza.setText(carta.getResistenza());
	}

	public void addBackListener(ActionListener a) {
		btnBack.addActionListener(a);
	}
}
