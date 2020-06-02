package it.unibs.db.tcg.model;

import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;

public class Collezione {
	private String nomeCollezione;
	private boolean visibile;
	private Date dataInizio;
	private ArrayList<Carta> carte;
	
	public Collezione(String nomeCollezione) {
		this.nomeCollezione=nomeCollezione;
		carte = new ArrayList<>();
	}
	
	public String getNomeCollezione() {
		return nomeCollezione;
	}
	
	public void setNomeCollezione(String nomeCollezione) {
		this.nomeCollezione = nomeCollezione;
	}
	
	public boolean isVisibile() {
		return visibile;
	}
	
	public void setVisibile(boolean visibile) {
		this.visibile = visibile;
	}
	
	public Date getDataInizio() {
		return dataInizio;
	}
	
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public int getNumeroCarte() {
		return carte.size();
	}
	
	public Carta getCartaByNumeroAndEspansione(int numCarta, String espCarta) {
		for(int i=0; i<carte.size();i++) {
			if (carte.get(i).getNumero() == numCarta && carte.get(i).getAbbrEspansione().equals(espCarta))
				return carte.get(i);
		}
		return null;
	}
	
	public boolean hasCarta(int numCarta, String espCarta) {
		boolean res = true;
		if(getCartaByNumeroAndEspansione(numCarta, espCarta) == null)
			res = false;
		return res;
	}
	
	public void addCarta(Carta c) {
		carte.add(c);
	}
	
	public void removeCartaByNumeroAndEspansione(int numCarta, String espCarta) {
		for(int i=0; i<carte.size();i++) {
			if (carte.get(i).getNumero() == numCarta && carte.get(i).getAbbrEspansione().equals(espCarta))
				carte.remove(i);
		}
	}
	
	public List<String> getCardsListName(){
		return carte.stream().map(carte -> carte.getNome()).collect(Collectors.toList());
	}
	
}
