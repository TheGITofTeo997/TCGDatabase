package it.unibs.db.tcg.model;

public class CartaEnergia extends Carta{
	private String tipo;

	public CartaEnergia(int numero, String abbrEspansione) {
		super(numero, abbrEspansione);
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
