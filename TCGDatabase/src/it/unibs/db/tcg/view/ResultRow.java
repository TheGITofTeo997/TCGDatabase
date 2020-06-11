package it.unibs.db.tcg.view;

import javax.swing.ImageIcon;

public class ResultRow {
	private ImageIcon immagine;
	private String text;

	public ResultRow(ImageIcon immagine, String text) {
		this.immagine = immagine;
		this.text = text;
	}

	public ImageIcon getImmagine() {
		return immagine;
	}

	public void setImmagine(ImageIcon immagine) {
		this.immagine = immagine;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
