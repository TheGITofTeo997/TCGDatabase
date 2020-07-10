package it.unibs.db.tcg.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import it.unibs.db.tcg.model.Utente;

public class RankingPanel extends JPanel {

	private static final long serialVersionUID = -4977544573358234319L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static Color backgroundColor;
	private static Color secondaryBackgroundColor;
	private static Color foregroundColor;
	private Font panelFont;
	private JButton btnBack;
	private JList<Utente> list;

	public RankingPanel() {
		setLayout(null);
		secondaryBackgroundColor = Preferences.getSecondaryBackgroundColor();
		backgroundColor = Preferences.getBackgroundColor();
		setBackground(backgroundColor);
		foregroundColor = Preferences.getForegroundColor();
		setForeground(foregroundColor);
		panelFont = Preferences.getFont();
		setFont(panelFont);

		JLabel lblRankingCardValue = new JLabel("Classifica valore carta");
		lblRankingCardValue.setForeground(foregroundColor);
		lblRankingCardValue.setFont(panelFont);
		lblRankingCardValue.setBounds(50, 50, 200, 50);
		lblRankingCardValue.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblRankingCardValue);

		btnBack = new JButton("Back");
		btnBack.setBounds(650, 480, 90, 50);
		btnBack.setFont(panelFont);
		add(btnBack);

	}

	public void addBackListener(ActionListener a) {
		btnBack.addActionListener(a);
	}

	public void setRankingCardValueList(List<Utente> utenti) {
		list = new JList<Utente>();
		DefaultListModel dm = new DefaultListModel();
		for (Utente u : utenti) {
			dm.addElement(new ResultRow(u.getAvatar(), u.getNickname() + "      " + u.getTotalCardsValue() + " �"));
		}
		list.setCellRenderer(new Renderer());
		list.setModel(dm);
		list.setBounds(50, 100, 300, 300);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBackground(backgroundColor);
		list.setFont(panelFont);
		list.setForeground(foregroundColor);
		list.setFixedCellWidth(300);
		list.setFixedCellHeight(50);

		JScrollPane scrollPane = new JScrollPane(this, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportView(list);
		scrollPane.setBounds(50, 100, 300, 300);
		add(scrollPane);
	}

}