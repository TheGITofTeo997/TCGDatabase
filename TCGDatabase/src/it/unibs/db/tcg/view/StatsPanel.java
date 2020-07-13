package it.unibs.db.tcg.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class StatsPanel extends JPanel {

	private static final long serialVersionUID = -4259378117098818102L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static Color backgroundColor;
	private static Color secondaryBackgroundColor;
	private static Color foregroundColor;
	private Font panelFont;

	private JButton btnBack;
	private JPanel listPanel;
	private JList<String> list;
	private JList<String> listExp;
	private JLabel lblMaxValueCard;
	private JLabel lblMinValueCard;
	private JLabel lblAvgValueCard;
	private JLabel lblTotalCardNumber;
	private JLabel lblTotalCollectionValue;
	private JLabel lblStartDataValue;
	private JLabel lblTitle;
	private JLabel lblCollectionState;
	private JLabel lblCollectionStateIcon;

	public StatsPanel() {
		setLayout(null);
		secondaryBackgroundColor = Preferences.getSecondaryBackgroundColor();
		backgroundColor = Preferences.getBackgroundColor();
		setBackground(backgroundColor);
		foregroundColor = Preferences.getForegroundColor();
		setForeground(foregroundColor);
		panelFont = Preferences.getFont();
		setFont(panelFont);

		lblTitle = new JLabel("STATISTICHE");
		lblTitle.setForeground(foregroundColor);
		lblTitle.setFont(panelFont.deriveFont(Font.BOLD));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(WIDTH / 2 - 250, 0, 500, 20);
		add(lblTitle);

		JLabel lblTotalCardsText = new JLabel("Carte totali collezione:");
		lblTotalCardsText.setFont(panelFont.deriveFont(Font.BOLD));
		lblTotalCardsText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		lblTotalCardsText.setForeground(foregroundColor);
		lblTotalCardsText.setFont(panelFont);
		lblTotalCardsText.setBounds(10, 40, 200, 20);
		add(lblTotalCardsText);

		JLabel lblAvgValueText = new JLabel("Valore medio di una carta:");
		lblAvgValueText.setFont(panelFont.deriveFont(Font.BOLD));
		lblAvgValueText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		lblAvgValueText.setForeground(foregroundColor);
		lblAvgValueText.setFont(panelFont);
		lblAvgValueText.setBounds(10, 80, 200, 20);
		add(lblAvgValueText);

		JLabel lblMaxValueCardText = new JLabel("Carta con il valore più alto:");
		lblMaxValueCardText.setFont(panelFont.deriveFont(Font.BOLD));
		lblMaxValueCardText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		lblMaxValueCardText.setForeground(foregroundColor);
		lblMaxValueCardText.setFont(panelFont);
		lblMaxValueCardText.setBounds(10, 120, 200, 20);
		add(lblMaxValueCardText);

		JLabel lblMinValueCardText = new JLabel("Carta con il valore più basso:");
		lblMinValueCardText.setFont(panelFont.deriveFont(Font.BOLD));
		lblMinValueCardText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		lblMinValueCardText.setForeground(foregroundColor);
		lblMinValueCardText.setFont(panelFont);
		lblMinValueCardText.setBounds(10, 200, 220, 20);
		add(lblMinValueCardText);

		JLabel lblTotalValueText = new JLabel("Valore totale collezione:");
		lblTotalValueText.setFont(panelFont.deriveFont(Font.BOLD));
		lblTotalValueText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		lblTotalValueText.setForeground(foregroundColor);
		lblTotalValueText.setFont(panelFont);
		lblTotalValueText.setBounds(10, 280, 200, 20);
		add(lblTotalValueText);

		JLabel lblCountCardsByExpText = new JLabel("Numero carte per espansione:");
		lblCountCardsByExpText.setFont(panelFont.deriveFont(Font.BOLD));
		lblCountCardsByExpText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		lblCountCardsByExpText.setForeground(foregroundColor);
		lblCountCardsByExpText.setFont(panelFont);
		lblCountCardsByExpText.setBounds(410, 80, 300, 20);
		add(lblCountCardsByExpText);

		JLabel lblCountCardsByRarity = new JLabel("Numero carte per rarità:");
		lblCountCardsByRarity.setFont(panelFont.deriveFont(Font.BOLD));
		lblCountCardsByRarity.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		lblCountCardsByRarity.setForeground(foregroundColor);
		lblCountCardsByRarity.setFont(panelFont);
		lblCountCardsByRarity.setBounds(10, 320, 300, 20);
		add(lblCountCardsByRarity);

		JLabel lblStartDate = new JLabel("Data inizio:");
		lblStartDate.setFont(panelFont.deriveFont(Font.BOLD));
		lblStartDate.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		lblStartDate.setForeground(foregroundColor);
		lblStartDate.setFont(panelFont);
		lblStartDate.setBounds(410, 40, 300, 20);
		add(lblStartDate);

		lblStartDataValue = new JLabel("");
		lblStartDataValue.setForeground(foregroundColor);
		lblStartDataValue.setFont(panelFont);
		lblStartDataValue.setBounds(500, 40, 300, 20);
		add(lblStartDataValue);

		lblMaxValueCard = new JLabel("");
		lblMaxValueCard.setForeground(foregroundColor);
		lblMaxValueCard.setFont(panelFont);
		lblMaxValueCard.setBounds(10, 160, 380, 20);
		add(lblMaxValueCard);

		lblMinValueCard = new JLabel("");
		lblMinValueCard.setForeground(foregroundColor);
		lblMinValueCard.setFont(panelFont);
		lblMinValueCard.setBounds(10, 240, 380, 20);
		add(lblMinValueCard);

		lblAvgValueCard = new JLabel("");
		lblAvgValueCard.setForeground(foregroundColor);
		lblAvgValueCard.setFont(panelFont);
		lblAvgValueCard.setBounds(220, 80, 40, 20);
		add(lblAvgValueCard);

		lblTotalCardNumber = new JLabel("");
		lblTotalCardNumber.setForeground(foregroundColor);
		lblTotalCardNumber.setFont(panelFont);
		lblTotalCardNumber.setBounds(220, 40, 40, 20);
		add(lblTotalCardNumber);

		lblTotalCollectionValue = new JLabel("");
		lblTotalCollectionValue.setForeground(foregroundColor);
		lblTotalCollectionValue.setFont(panelFont);
		lblTotalCollectionValue.setBounds(220, 280, 200, 20);
		add(lblTotalCollectionValue);

		lblCollectionState = new JLabel();
		lblCollectionState.setBounds(410, 320, 100, 30);
		lblCollectionState.setFont(panelFont);
		add(lblCollectionState);

		btnBack = new JButton("Back");
		btnBack.setBounds(650, 480, 90, 50);
		add(btnBack);

		listPanel = new JPanel();
		listPanel.setBounds(317, 63, 483, 537);
		listPanel.setLayout(null);
		listPanel.setBackground(null);
		listPanel.setFocusable(false);
		listPanel.setVisible(false);
		add(listPanel);
	}

	public void setMaxValueCard(String maxCardNameExpAndValue) {
		lblMaxValueCard.setText(maxCardNameExpAndValue + " €");
	}

	public void setMinValueCard(String minCardNameExpAndValue) {
		lblMinValueCard.setText(minCardNameExpAndValue + " €");
	}

	public void setAvgValueCard(int avgCardValue) {
		lblAvgValueCard.setText("" + avgCardValue + " €");
	}

	public void setTotalCardNumber(int totalCardNumber) {
		lblTotalCardNumber.setText("" + totalCardNumber);
	}

	public void setTotalCollectionValue(int totalCollectionValue) {
		lblTotalCollectionValue.setText("" + totalCollectionValue + " €");
	}

	public void setStartDate(String startDate) {
		lblStartDataValue.setText(startDate);
	}

	public void setRarityList(Map<String, Integer> rarityMap) {
		list = new JList();
		DefaultListModel dm = new DefaultListModel();
		for (String i : rarityMap.keySet()) {
			dm.addElement(new RarityResultRow(i, rarityMap.get(i)));
		}
		list.setCellRenderer(new RarityRenderer());
		list.setModel(dm);
		list.setBounds(165, 300, 350, 200);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBackground(backgroundColor);
		list.setFont(panelFont);
		list.setForeground(foregroundColor);
		list.setFixedCellWidth(listExp.getWidth());
		list.setFixedCellHeight(50);

		JScrollPane scrollPaneRarity = new JScrollPane(this, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneRarity.setViewportView(list);
		scrollPaneRarity.setBackground(null);
		scrollPaneRarity.setBounds(10, 350, 350, 200);

		scrollPaneRarity.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

		add(scrollPaneRarity);
	}

	public void setLblTitle(String collectionName) {
		lblTitle.setText("Statistiche di " + collectionName);
	}

	public void setCollectionStateTextAndIcon(boolean flag) {
		if (flag) {
			lblCollectionState.setText("Completa");
			lblCollectionState.setForeground(Color.GREEN);
			lblCollectionState.setFont(panelFont.deriveFont(Font.BOLD));
			ImageIcon complete = new ImageIcon("resources//icon//complete_icon.png");
			complete.setImage(complete.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
			lblCollectionStateIcon = new JLabel(complete);
			lblCollectionStateIcon.setBounds(520, 305, 60, 60);
			add(lblCollectionStateIcon);
		} else {
			lblCollectionState.setText("Incompleta");
			lblCollectionState.setFont(panelFont.deriveFont(Font.BOLD));
			lblCollectionState.setForeground(Color.RED);
			ImageIcon not_complete = new ImageIcon("resources//icon//progress_icon.png");
			not_complete.setImage(not_complete.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
			lblCollectionStateIcon = new JLabel(not_complete);
			lblCollectionStateIcon.setBounds(520, 305, 60, 60);
			add(lblCollectionStateIcon);
		}
	}

	public void setExpList(Map<ImageIcon, String> map) {
		listExp = new JList();
		DefaultListModel dm = new DefaultListModel();
		for (ImageIcon i : map.keySet()) {
			dm.addElement(new ResultRow(i, map.get(i)));
		}
		listExp.setCellRenderer(new Renderer());
		listExp.setModel(dm);
		listExp.setBounds(165, 300, 350, 200);
		listExp.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listExp.setBackground(backgroundColor);
		listExp.setFont(panelFont);
		listExp.setForeground(foregroundColor);
		listExp.setFixedCellWidth(listExp.getWidth());
		listExp.setFixedCellHeight(50);

		JScrollPane scrollPaneExp = new JScrollPane(this, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneExp.setViewportView(listExp);
		scrollPaneExp.setBackground(null);
		scrollPaneExp.setBounds(410, 110, 350, 200);

		scrollPaneExp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

		add(scrollPaneExp);
	}

	public void addBackListener(ActionListener a) {
		btnBack.addActionListener(a);
	}
}
