package it.unibs.db.tcg.view;

import javax.swing.ImageIcon;

public class CardRow {
	private String numberAbbr;
	private ImageIcon immagine;
	private String nome;

	public CardRow(String numberAbbr, ImageIcon immagine, String nome) {
		this.numberAbbr = numberAbbr;
		this.immagine = immagine;
		this.nome = nome;
	}

	public String getNumberAbbr() {
		return numberAbbr;
	}

	public void setNumberAbbr(String numberAbbr) {
		this.numberAbbr = numberAbbr;
	}

	public ImageIcon getImmagine() {
		return immagine;
	}

	public void setImmagine(ImageIcon immagine) {
		this.immagine = immagine;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
