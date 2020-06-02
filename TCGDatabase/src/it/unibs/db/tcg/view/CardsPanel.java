package it.unibs.db.tcg.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

public class CardsPanel extends JPanel {

	private JList listExpansions;
	private JList listCards;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static Color backgroundColor = new Color(252, 186, 3);
	private static Color secondaryBackgroundColor = new Color(156, 156, 156);
	private static Color foregroundColor = Color.WHITE;
	private static Font panelFont = new Font("Serif", 0, 18);

	public CardsPanel() {
		setLayout(null);
		setBackground(backgroundColor);
		setForeground(foregroundColor);
		setFont(panelFont);
	}

	public void setCards(DefaultListModel<String> cardsName) {
		listCards = new JList(cardsName);
		listCards.setBounds(165, 50, 600, 500);
		listCards.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCards.setBackground(backgroundColor);
		listCards.setFont(panelFont);
		listCards.setForeground(foregroundColor);
		listCards.setFixedCellWidth(listCards.getWidth());
		listCards.setFixedCellHeight(50);
		add(listCards);
	}
	

}
