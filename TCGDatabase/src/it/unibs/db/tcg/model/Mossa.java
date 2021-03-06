package it.unibs.db.tcg.model;

public class Mossa {
	private String nomeMossa;
	private int energiaRichiesta;
	private String descrizione;
	private int danno;

	public Mossa(String nomeMossa) {
		this.nomeMossa = nomeMossa;
		danno = 0;
	}

	public String getNomeMossa() {
		return nomeMossa;
	}

	public void setNomeMossa(String nomeMossa) {
		this.nomeMossa = nomeMossa;
	}

	public int getEnergiaRichiesta() {
		return energiaRichiesta;
	}

	public void setEnergiaRichiesta(int energiaRichiesta) {
		this.energiaRichiesta = energiaRichiesta;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getDanno() {
		return danno;
	}

	public void setDanno(int danno) {
		this.danno = danno;
	}

}
