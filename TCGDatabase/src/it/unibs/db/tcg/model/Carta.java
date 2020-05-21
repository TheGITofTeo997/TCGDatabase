package it.unibs.db.tcg.model;

import javax.swing.ImageIcon;

public class Carta {
	private String nome;
	private int numero;
	private String abbrEspansione;
	private String rarita;
	private String illustratore;
	private ImageIcon immagine;
	private double valore;
	
	public Carta(int numero, String abbrEspansione) {
		this.numero = numero;
		this.abbrEspansione = abbrEspansione;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getAbbrEspansione() {
		return abbrEspansione;
	}
	
	public void setAbbrEspansione(String abbrEspansione) {
		this.abbrEspansione = abbrEspansione;
	}
	
	public String getRarita() {
		return rarita;
	}
	
	public void setRarita(String rarita) {
		this.rarita = rarita;
	}
	
	public String getIllustratore() {
		return illustratore;
	}
	
	public void setIllustratore(String illustratore) {
		this.illustratore = illustratore;
	}
	
	public ImageIcon getImmagine() {
		return immagine;
	}
	
	public void setImmagine(ImageIcon immagine) {
		this.immagine = immagine;
	}
	
	public double getValore() {
		return valore;
	}
	
	public void setValore(double valore) {
		this.valore = valore;
	}
	
}
