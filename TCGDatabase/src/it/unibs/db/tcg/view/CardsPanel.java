package it.unibs.db.tcg.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;

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
	private JButton btnGroupByNumber;
	private JButton btnGroupByName;
	private JButton btnGroupByExp;

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

		JLabel lblGroupBy = new JLabel("Ordina per");
		lblGroupBy.setForeground(foregroundColor);
		lblGroupBy.setFont(panelFont);
		lblGroupBy.setBounds(50, 450, 100, 50);
		lblGroupBy.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblGroupBy);

		btnGroupByNumber = new JButton("Numero");
		btnGroupByNumber.setBounds(175, 450, 100, 50);
		btnGroupByNumber.setFont(panelFont);
		add(btnGroupByNumber);

		btnGroupByName = new JButton("Nome");
		btnGroupByName.setBounds(300, 450, 100, 50);
		btnGroupByName.setFont(panelFont);
		add(btnGroupByName);

		btnGroupByExp = new JButton("Esp");
		btnGroupByExp.setBounds(425, 450, 100, 50);
		btnGroupByExp.setFont(panelFont);
		add(btnGroupByExp);

	}

	public void setCardList(List<Carta> carte) {
		if (carte.size() == 0)
			showNoCardsFoundImage();

		list = new JList();
		DefaultListModel dm = new DefaultListModel();
		for (Carta c : carte) {
			dm.addElement(
					new ResultRow(c.getImmagine(), c.getNumero() + "/" + c.getAbbrEspansione() + " " + c.getNome()));
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

		JScrollPane scrollPane = new JScrollPane(this, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportView(list);
		scrollPane.setBounds(50, 50, 700, 400);
		Border empty = new EmptyBorder(0, 0, 0, 0);
		scrollPane.setBorder(empty);
		add(scrollPane);

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

	public void addBtnGroupByNumberActionListener(ActionListener a) {
		btnGroupByNumber.addActionListener(a);
	}

	public void addBtnGroupByNameActionListener(ActionListener a) {
		btnGroupByName.addActionListener(a);
	}

	public void addBtnGroupByExpActionListener(ActionListener a) {
		btnGroupByExp.addActionListener(a);
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
