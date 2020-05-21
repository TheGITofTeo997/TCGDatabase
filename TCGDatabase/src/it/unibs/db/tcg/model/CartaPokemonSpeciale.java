package it.unibs.db.tcg.model;

public class CartaPokemonSpeciale extends CartaPokemon{
	private String attributoSpeciale;
	private String regola;
	
	public CartaPokemonSpeciale(int numero, String abbrEspansione) {
		super(numero, abbrEspansione);
	}
	
	public String getAttributoSpeciale() {
		return attributoSpeciale;
	}
	
	public void setAttributoSpeciale(String attributoSpeciale) {
		this.attributoSpeciale = attributoSpeciale;
	}
	
	public String getRegola() {
		return regola;
	}
	
	public void setRegola(String regola) {
		this.regola = regola;
	}

}
