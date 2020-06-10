package it.unibs.db.tcg.model;

import java.util.ArrayList;
import java.util.List;

public class CartaPokemon extends Carta {

	private String descrizione;
	private String tipoEnergia;
	private String resistenza = "";
	private String debolezza;
	private int PS;
	private int costoRitirata;
	private int stage;
	private int stage_successivo;
	private ArrayList<Mossa> mosse;

	public CartaPokemon(int numero, String abbrEspansione) {
		super(numero, abbrEspansione);
		mosse = new ArrayList<>();
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getTipoEnergia() {
		return tipoEnergia;
	}

	public void setTipoEnergia(String tipoEnergia) {
		this.tipoEnergia = tipoEnergia;
	}

	public String getResistenza() {
		return resistenza;
	}

	public void setResistenza(String resistenza) {
		this.resistenza = resistenza;
	}

	public String getDebolezza() {
		return debolezza;
	}

	public void setDebolezza(String debolezza) {
		this.debolezza = debolezza;
	}

	public int getPS() {
		return PS;
	}

	public void setPS(int pS) {
		PS = pS;
	}

	public int getCostoRitirata() {
		return costoRitirata;
	}

	public void setCostoRitirata(int costoRitirata) {
		this.costoRitirata = costoRitirata;
	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}

	public int getStage_successivo() {
		return stage_successivo;
	}

	public void setStage_successivo(int stage_successivo) {
		this.stage_successivo = stage_successivo;
	}

	public List<Mossa> getMosse() {
		return mosse;
	}

	public Mossa getMossaByNome(String nomeMossa) {
		for (int i = 0; i < mosse.size(); i++) {
			if (mosse.get(i).getNomeMossa().equals(nomeMossa))
				return mosse.get(i);
		}
		return null;
	}

	public boolean hasMossa(String nomeMossa) {
		boolean res = true;
		if (getMossaByNome(nomeMossa) == null)
			res = false;
		return res;
	}

	public void addMossa(Mossa m) {
		mosse.add(m);
	}

	public void removeMossaFromNome(String nomeMossa) {
		for (int i = 0; i < mosse.size(); i++) {
			if (mosse.get(i).getNomeMossa().equals(nomeMossa))
				mosse.remove(i);
		}
	}

}
