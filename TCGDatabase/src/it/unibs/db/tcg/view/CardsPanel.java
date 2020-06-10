package it.unibs.db.tcg.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionListener;

import it.unibs.db.tcg.main.TCGMain;
import it.unibs.db.tcg.model.Carta;

public class CardsPanel extends JPanel {

	private static final long serialVersionUID = -7455653311848409614L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static Color backgroundColor;
	private static Color secondaryBackgroundColor;
	private static Color foregroundColor;
	private Font panelFont;
	private JLabel lblTitle;
	private JList<Carta> list;
	private JButton btnBack;

	/**
	 * Create the panel.
	 */
	public CardsPanel() {
		setLayout(null);
		secondaryBackgroundColor = Preferences.getSecondaryBackgroundColor();
		backgroundColor = Preferences.getBackgroundColor();
		setBackground(backgroundColor);
		foregroundColor = Preferences.getForegroundColor();
		setForeground(foregroundColor);
		panelFont = Preferences.getFont();
		setFont(panelFont);

		lblTitle = new JLabel("default");
		lblTitle.setForeground(foregroundColor);
		lblTitle.setFont(panelFont.deriveFont(Font.BOLD));
		lblTitle.setBounds(0, 0, WIDTH, 50);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitle);

		btnBack = new JButton("Back");
		btnBack.setBounds(650, 450, 90, 50);
		btnBack.setFont(panelFont);
		add(btnBack);
	}

	public void setCardList(List<Carta> carte) {
		if (carte.size() == 0)
			showNoCardsFoundImage();

		list = new JList();
		DefaultListModel dm = new DefaultListModel();
		for (Carta c : carte) {
			dm.addElement(new CardRow(c.getNumero() + "/" + c.getAbbrEspansione(), c.getImmagine(), c.getNome()));
		}
		list.setCellRenderer(new Renderer());
		list.setModel(dm);
		list.setBounds(50, 50, 700, 350);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBackground(backgroundColor);
		list.setFont(panelFont);
		list.setForeground(foregroundColor);
		list.setFixedCellWidth(list.getWidth());
		list.setFixedCellHeight(50);
		add(list);
	}

	private void showNoCardsFoundImage() {
		JLabel lblNoCards = new JLabel();
		lblNoCards.setBounds(50, 50, 700, 350);
		ImageIcon icon = new ImageIcon("resources/john.gif");
		lblNoCards.setIcon(icon);
		lblNoCards.setFont(panelFont.deriveFont(Font.BOLD));
		lblNoCards.setHorizontalAlignment(JLabel.CENTER);
		JLabel lblNoCardsText = new JLabel("Non c'è niente qui");
		lblNoCardsText.setHorizontalAlignment(JLabel.CENTER);
		lblNoCardsText.setFont(panelFont.deriveFont(Font.BOLD));
		lblNoCardsText.setForeground(foregroundColor);
		lblNoCardsText.setBounds(50, 410, 700, 20);
		add(lblNoCardsText);
		add(lblNoCards);
	}

	public void setTitleText(String title) {
		lblTitle.setText(title);
	}

	public void addCardListener(ListSelectionListener a) {
		if (list != null)
			list.addListSelectionListener(a);
	}

	public void addBackListener(ActionListener a) {
		btnBack.addActionListener(a);
	}

	public int getListSelectedIndex() {
		return list.getSelectedIndex();
	}
}
