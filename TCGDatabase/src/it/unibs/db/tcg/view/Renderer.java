package it.unibs.db.tcg.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class Renderer extends DefaultListCellRenderer implements ListCellRenderer<Object>{

	private static final long serialVersionUID = 2064272275621778071L;
	private static Font panelFont = new Font("Serif", 0, 18);
	
	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		CardRow cardRow = (CardRow) value;
		setText(cardRow.getNumberAbbr() + " " + cardRow.getNome());
		Image scaledImg = cardRow.getImmagine().getImage().getScaledInstance(35, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImg);
		setIcon(scaledIcon);
		setEnabled(true);
		setFont(panelFont);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
		return this;
		
	}
	
	

}
