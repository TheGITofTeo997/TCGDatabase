package it.unibs.db.tcg.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class RarityRenderer extends DefaultListCellRenderer implements ListCellRenderer<Object> {

	private static final long serialVersionUID = 2064272275621778071L;
	private static Font panelFont = new Font("Serif", 0, 18);
	
	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		RarityResultRow rarityResultRow = (RarityResultRow) value;
		setText(rarityResultRow.getRarity() + ": " + rarityResultRow.getCount() + " carte");
		setEnabled(true);
		setFont(panelFont);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
		return this;
	}
}
