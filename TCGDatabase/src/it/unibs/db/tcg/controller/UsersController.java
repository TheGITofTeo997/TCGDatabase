package it.unibs.db.tcg.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import it.unibs.db.tcg.model.Utente;
import it.unibs.db.tcg.view.UsersPanel;

public class UsersController extends Controller {
	private UsersPanel usPan;
	
private JFrame frame;
	
	public UsersController(JFrame frame) {
		this.frame = frame;
	}

	public void drawUsersPanel(Utente user, List<Utente> utenti) {
		usPan = new UsersPanel();
		usPan.setBounds(0, 0, 800, 600);
		usPan.setUserList(utenti);
		frame.getContentPane().add(usPan);

		usPan.addUsersListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					Utente u = utenti.get(usPan.getListSelectedIndex());
					// Carta card = connectorService.getCardFromNumberAndAbbrEspansione(c.getNumero(),
					// c.getAbbrEspansione());
					usPan.setVisible(false);
					String nickname = u.getNickname();
					u.setTotalCardsValue(connectorService.getUserTotalCardsValue(nickname));
					u.setCollections(connectorService.getPublicUserCollections(nickname));
					usPan.setVisible(false);
					VisitorAccountController visitorAccountController = new VisitorAccountController(frame);
					visitorAccountController.drawVisitorAccountPanel(user, utenti, u);
				}
			}
		});

		usPan.addBackListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				usPan.setVisible(false);
				SearchController searchController = new SearchController(frame);
				searchController.drawSearchPanel(user);
			}
		});

	}

}
