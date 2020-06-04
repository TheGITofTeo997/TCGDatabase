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
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionListener;

import it.unibs.db.tcg.model.Carta;

public class CardsPanel extends JPanel {

	private static final long serialVersionUID = -7455653311848409614L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static Color backgroundColor = new Color(252, 186, 3);
	private static Color secondaryBackgroundColor = new Color(156, 156, 156);
	private static Color foregroundColor = Color.WHITE;
	private static Font panelFont = new Font("Serif", 0, 18);
	private JLabel lblTitle;
	private JList<Carta> list;
	private JButton btnBack;
	
	

	/**
	 * Create the panel.
	 */
	public CardsPanel() {
		setLayout(null);
		setBackground(backgroundColor);
		setForeground(foregroundColor);
		setFont(panelFont);
		setVisible(true);
		
		
		lblTitle = new JLabel("default");
		lblTitle.setForeground(foregroundColor);
		lblTitle.setFont(panelFont.deriveFont(Font.BOLD));
		lblTitle.setBounds(0,0,WIDTH, 50);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitle);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(650, 450, 90, 50);
		add(btnBack);
	}
	
	public void setCardList(List<Carta> carte) {
		list = new JList();
		DefaultListModel dm = new DefaultListModel();
		for(Carta c : carte) {
			dm.addElement(new CardRow(c.getNumero()+"/"+c.getAbbrEspansione(),c.getImmagine(),c.getNome()));
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

	public void setTitleText(String title) {
		lblTitle.setText(title);
	}
	
	public void addCardListener(ListSelectionListener a) {
		list.addListSelectionListener(a);
	}
	
	public void addBackListener(ActionListener a) {
		btnBack.addActionListener(a);
	}
	
	public int getListSelectedIndex() {
		return list.getSelectedIndex();
	}
}
