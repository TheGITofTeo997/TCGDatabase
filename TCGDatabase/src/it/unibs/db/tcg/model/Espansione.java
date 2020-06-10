package it.unibs.db.tcg.model;

import java.sql.Date;

import javax.swing.ImageIcon;

public class Espansione {
	private String abbreviazione;
	private String nomeEspansione;
	private ImageIcon icona;
	private int numeroCarte;
	private Date dataRilascio;

	public Espansione(String abbreviazione) {
		this.abbreviazione = abbreviazione;
	}

	public String getAbbreviazione() {
		return abbreviazione;
	}

	public void setAbbreviazione(String abbreviazione) {
		this.abbreviazione = abbreviazione;
	}

	public String getNomeEspansione() {
		return nomeEspansione;
	}

	public void setNomeEspansione(String nomeEspansione) {
		this.nomeEspansione = nomeEspansione;
	}

	public ImageIcon getIcona() {
		return icona;
	}

	public void setIcona(ImageIcon icona) {
		this.icona = icona;
	}

	public int getNumeroCarte() {
		return numeroCarte;
	}

	public void setNumeroCarte(int numeroCarte) {
		this.numeroCarte = numeroCarte;
	}

	public Date getDataRilascio() {
		return dataRilascio;
	}

	public void setDataRilascio(Date dataRilascio) {
		this.dataRilascio = dataRilascio;
	}

}
