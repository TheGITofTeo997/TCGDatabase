package it.unibs.db.tcg.model;

public class CartaPokemonBase extends CartaPokemon {
	private String abilita;

	public CartaPokemonBase(int numero, String abbrEspansione) {
		super(numero, abbrEspansione);
		this.abilita = "";
	}

	public String getAbilita() {
		return abilita;
	}

	public void setAbilita(String abilita) {
		this.abilita = abilita;
	}

}
