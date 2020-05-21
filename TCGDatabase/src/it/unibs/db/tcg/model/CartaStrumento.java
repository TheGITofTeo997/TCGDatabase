package it.unibs.db.tcg.model;

public class CartaStrumento extends Carta{
	private String descrizione;
	private String effetto;
	
	public CartaStrumento(int numero, String abbrEspansione) {
		super(numero, abbrEspansione);
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public String getEffetto() {
		return effetto;
	}
	
	public void setEffetto(String effetto) {
		this.effetto = effetto;
	}

}
