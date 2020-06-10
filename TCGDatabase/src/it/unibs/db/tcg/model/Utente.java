package it.unibs.db.tcg.model;

import java.sql.Date;
import java.util.*;
import javax.swing.*;

public class Utente {
	private String nickname;
	private String nomeUtente;
	private String mail;
	private Date dataRegistrazione;
	private ImageIcon avatar;
	private ArrayList<Collezione> collezioni;
	private double totalCardsValue;

	public Utente() {
		collezioni = new ArrayList<>();
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}

	public ImageIcon getAvatar() {
		return avatar;
	}

	public void setAvatar(ImageIcon avatar) {
		this.avatar = avatar;
	}

	public int getNumeroCollezioni() {
		return collezioni.size();
	}

	public DefaultListModel<String> getDefaultListModelCollections() {
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (Collezione c : collezioni) {
			listModel.addElement(c.getNomeCollezione());
		}
		return listModel;
	}

	public Collezione getCollezioneByNome(String nomeCollezione) {
		for (int i = 0; i < collezioni.size(); i++) {
			if (collezioni.get(i).getNomeCollezione().equals(nomeCollezione))
				return collezioni.get(i);
		}
		return null;
	}

	public boolean hasCollezione(String nomeCollezione) {
		boolean res = true;
		if (getCollezioneByNome(nomeCollezione) == null)
			res = false;
		return res;
	}

	public void setCollections(List<String> collections) {
		for (String s : collections)
			collezioni.add(new Collezione(s));
	}

	public void addCollezione(Collezione c) {
		collezioni.add(c);
	}

	public void removeCollezioneFromNome(String nomeCollezione) {
		for (int i = 0; i < collezioni.size(); i++) {
			if (collezioni.get(i).getNomeCollezione().equals(nomeCollezione))
				collezioni.remove(i);
		}
	}

	public double getTotalCardsValue() {
		return totalCardsValue;
	}

	public void setTotalCardsValue(double total_cards_value) {
		this.totalCardsValue = total_cards_value;
	}

}
