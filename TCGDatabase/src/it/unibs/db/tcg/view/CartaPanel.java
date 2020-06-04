package it.unibs.db.tcg.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CartaPanel extends JPanel {
	private static final long serialVersionUID = 3990277761264013805L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static Color backgroundColor = new Color(252, 186, 3);
	private static Color secondaryBackgroundColor = new Color(156, 156, 156);
	private static Color foregroundColor = Color.WHITE;
	private static Font panelFont = new Font("Serif", 0, 16);
	
	private JButton btnBack;
	private JLabel lblPic;
	private JPanel pokemonPanel;
	private JPanel itemPanel;
	private JPanel energyPanel;
	

	/**
	 * Create the panel.
	 */
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
		btnBack.setBounds(650, 520, 90, 50);
		add(btnBack);
		
		lblPic = new JLabel("");
		lblPic.setBounds(60, 50, 250, 350);
		add(lblPic); 
		
		JLabel pkmnlblNum = new JLabel("");
		pkmnlblNum.setBounds(0,0,50,40);
		pkmnlblNum.setForeground(foregroundColor);
		pkmnlblNum.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnlblNum);
		
		JLabel pkmnlblExp = new JLabel("");
		pkmnlblExp.setBounds(50,0,50,40);
		pkmnlblExp.setForeground(foregroundColor);
		pkmnlblExp.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnlblExp);
		
		JLabel pkmnlblName = new JLabel("");
		pkmnlblName.setBounds(100, 0, 300, 40);
		pkmnlblName.setForeground(foregroundColor);
		pkmnlblName.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnlblName);
		
		JLabel pkmnSlblPS = new JLabel("PS");
		pkmnSlblPS.setBounds(400,0,30,40);
		pkmnSlblPS.setForeground(foregroundColor);
		pkmnSlblPS.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblPS);
		
		JLabel pkmnlblPS = new JLabel("");
		pkmnlblPS.setBounds(430,0,50,40);
		pkmnlblPS.setForeground(foregroundColor);
		pkmnlblPS.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnlblPS);
		
		JLabel pkmnSlblType = new JLabel("Tipo Carta");
		pkmnSlblType.setBounds(0, 40, 120, 40);
		pkmnSlblType.setForeground(foregroundColor);
		pkmnSlblType.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblType);
		
		JLabel pkmnlblType = new JLabel("");
		pkmnlblType.setBounds(120, 40, 120, 40);
		pkmnlblType.setForeground(foregroundColor);
		pkmnlblType.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnlblType);
		
		JLabel pkmnSlblIllustrator = new JLabel("Illustratore");
		pkmnSlblIllustrator.setBounds(240, 40, 120, 40);
		pkmnSlblIllustrator.setForeground(foregroundColor);
		pkmnSlblIllustrator.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblIllustrator);
			
		JLabel pkmnlblIllustrator = new JLabel("");
		pkmnlblIllustrator.setBounds(360, 40, 120, 40);
		pkmnlblIllustrator.setForeground(foregroundColor);
		pkmnlblIllustrator.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnlblIllustrator);
		
		JLabel pkmnSlblEnergyType = new JLabel("Tipo Energia");
		pkmnSlblEnergyType.setBounds(0, 80, 80, 40);
		pkmnSlblEnergyType.setForeground(foregroundColor);
		pkmnSlblEnergyType.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblEnergyType);
		
		JLabel pkmnlblEnergyType = new JLabel("");
		pkmnlblEnergyType.setBounds(80 ,80, 90, 40);
		pkmnlblEnergyType.setForeground(foregroundColor);
		pkmnlblEnergyType.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnlblEnergyType);
		
		JLabel pkmnSlblRarity = new JLabel("Rarità");
		pkmnSlblRarity.setBounds(170, 80, 90, 40);
		pkmnSlblRarity.setForeground(foregroundColor);
		pkmnSlblRarity.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblRarity);
		
		JLabel pkmnlblRarity = new JLabel("");
		pkmnlblRarity.setBounds(260, 80, 80, 40);
		pkmnlblRarity.setForeground(foregroundColor);
		pkmnlblRarity.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnlblRarity);
			
		JLabel pkmnSlblValue = new JLabel("Valore");
		pkmnSlblValue.setBounds(340, 80, 90, 40);
		pkmnSlblValue.setForeground(foregroundColor);
		pkmnSlblValue.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblValue);
		
		JLabel pkmnlblValue = new JLabel("");
		pkmnlblValue.setBounds(430, 80, 50, 40);
		pkmnlblValue.setForeground(foregroundColor);
		pkmnlblValue.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnlblValue);
		
		JLabel pkmnSlblDebolezza = new JLabel("Debolezza");
		pkmnSlblDebolezza.setBounds(0, 120, 120, 40);
		pkmnSlblDebolezza.setForeground(foregroundColor);
		pkmnSlblDebolezza.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblDebolezza);
		
		JLabel pkmnlblDebolezza = new JLabel("");
		pkmnlblDebolezza.setBounds(120, 120, 120, 40);
		pkmnlblDebolezza.setForeground(foregroundColor);
		pkmnlblDebolezza.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnlblDebolezza);
		
		JLabel pkmnSlblResistenza = new JLabel("Resistenza");
		pkmnSlblResistenza.setBounds(240, 120, 120, 40);
		pkmnSlblResistenza.setForeground(foregroundColor);
		pkmnSlblResistenza.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblResistenza); 
		
		JLabel pkmnlblResistenza = new JLabel("");
		pkmnlblResistenza.setBounds(360, 120, 120, 40);
		pkmnlblResistenza.setForeground(foregroundColor);
		pkmnlblResistenza.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnlblResistenza); 
		
		JLabel pkmnSlblCostoRitirata = new JLabel("Costo di Ritirata");
		pkmnSlblCostoRitirata.setBounds(0, 160, 120, 40);
		pkmnSlblCostoRitirata.setForeground(foregroundColor);
		pkmnSlblCostoRitirata.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblCostoRitirata); 
		
		JLabel pkmnlblCostoRitirata = new JLabel("");
		pkmnlblCostoRitirata.setBounds(120, 160, 120, 40);
		pkmnlblCostoRitirata.setForeground(foregroundColor);
		pkmnlblCostoRitirata.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnlblCostoRitirata); 
		
		JLabel pkmnSlblAbilita = new JLabel("Abilità");
		pkmnSlblAbilita.setBounds(240, 160, 120, 40);
		pkmnSlblAbilita.setForeground(foregroundColor);
		pkmnSlblAbilita.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblAbilita); 
		
		JLabel pkmnlblAbilita = new JLabel("");
		pkmnlblAbilita.setBounds(360, 160, 120, 40);
		pkmnlblAbilita.setForeground(foregroundColor);
		pkmnlblAbilita.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnlblAbilita); 
		
		JLabel pkmnSlblAttributoSpeciale = new JLabel("Attr. Spec.");
		pkmnSlblAttributoSpeciale.setBounds(0, 200, 100, 75);
		pkmnSlblAttributoSpeciale.setForeground(foregroundColor);
		pkmnSlblAttributoSpeciale.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblAttributoSpeciale); 
		
		JLabel pkmnlblAttributoSpeciale = new JLabel("");
		pkmnlblAttributoSpeciale.setBounds(100, 200, 30, 75);
		pkmnlblAttributoSpeciale.setForeground(foregroundColor);
		pkmnlblAttributoSpeciale.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnlblAttributoSpeciale);
		
		JLabel pkmnSlblRule = new JLabel("Regola");
		pkmnSlblRule.setBounds(150, 200, 50, 75);
		pkmnSlblRule.setForeground(foregroundColor);
		pkmnSlblRule.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnSlblRule); 
		
		JLabel pkmnlblRule = new JLabel("");
		pkmnlblRule.setBounds(200, 200, 280, 75);
		pkmnlblRule.setForeground(foregroundColor);
		pkmnlblRule.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnlblRule); 
		
		JLabel pkmnlblDescription = new JLabel("");
		pkmnlblDescription.setBounds(0, 275, 200, 225);
		pkmnlblDescription.setForeground(foregroundColor);
		pkmnlblDescription.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnlblDescription); 
		
		JLabel pkmnlblNomeMossa1 = new JLabel("");
		pkmnlblNomeMossa1.setBounds(200, 275, 180, 30);
		pkmnlblNomeMossa1.setForeground(foregroundColor);
		pkmnlblNomeMossa1.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnlblNomeMossa1); 
		
		JLabel pkmnlblDannoMossa1 = new JLabel("");
		pkmnlblDannoMossa1.setBounds(380, 275, 100, 30);
		pkmnlblDannoMossa1.setForeground(foregroundColor);
		pkmnlblDannoMossa1.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnlblDannoMossa1); 
		
		JLabel pkmnlblDescrizioneMossa1 = new JLabel("");
		pkmnlblDescrizioneMossa1.setBounds(200, 305, 280, 80);
		pkmnlblDescrizioneMossa1.setForeground(foregroundColor);
		pkmnlblDescrizioneMossa1.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnlblDescrizioneMossa1); 
		
		JLabel pkmnlblNomeMossa2 = new JLabel("");
		pkmnlblNomeMossa2.setBounds(385, 275, 180, 30);
		pkmnlblNomeMossa2.setForeground(foregroundColor);
		pkmnlblNomeMossa2.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnlblNomeMossa2); 
		
		JLabel pkmnlblDannoMossa2 = new JLabel("");
		pkmnlblDannoMossa2.setBounds(385, 275, 100, 30);
		pkmnlblDannoMossa2.setForeground(foregroundColor);
		pkmnlblDannoMossa2.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnlblDannoMossa2); 
		
		JLabel pkmnlblDescrizioneMossa2 = new JLabel("");
		pkmnlblDescrizioneMossa2.setBounds(200, 415, 280, 80);
		pkmnlblDescrizioneMossa2.setForeground(foregroundColor);
		pkmnlblDescrizioneMossa2.setFont(panelFont.deriveFont(Font.BOLD));
		pokemonPanel.add(pkmnlblDescrizioneMossa2); 
		
		
	}
	
	public void addBackListener(ActionListener a) {
		btnBack.addActionListener(a);
	}
}
