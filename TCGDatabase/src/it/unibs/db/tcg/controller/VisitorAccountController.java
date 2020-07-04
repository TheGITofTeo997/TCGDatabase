package it.unibs.db.tcg.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import it.unibs.db.tcg.model.Collezione;
import it.unibs.db.tcg.model.Utente;
import it.unibs.db.tcg.view.VisitorAccountPanel;

public class VisitorAccountController extends Controller {
	private VisitorAccountPanel visPan;
	
	private JFrame frame;
	
	public VisitorAccountController(JFrame frame) {
		this.frame = frame;
	}
	public void drawVisitorAccountPanel(Utente user, List<Utente> utenti, Utente toVisit) {
		visPan = new VisitorAccountPanel();
		visPan.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(visPan);

		visPan.setNickname(toVisit.getNickname());
		visPan.setMail(toVisit.getMail());
		visPan.setAvatar(toVisit.getAvatar());
		visPan.setUserName(toVisit.getNomeUtente());
		visPan.setRegistrationDate(toVisit.getDataRegistrazione().toString());
		visPan.setTotalValue(toVisit.getTotalCardsValue());
		visPan.setCollections(toVisit.getDefaultListModelCollections());

		visPan.addCollectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					String collection = toVisit.getDefaultListModelCollections().get(visPan.getListSelectedIndex());
					Collezione c = new Collezione(collection);
					c.setCarteCollezione(connectorService.getCardsFromCollection(toVisit.getNickname(), collection));
					visPan.setVisible(false);
					CardsController cardsController = new CardsController(frame);
					cardsController.drawCardsPanel(user, "Carte della Collezione " + collection, c.getCardsList(), utenti, toVisit, false);
				}
			}
		});

		visPan.addBackListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visPan.setVisible(false);
				UsersController usersController = new UsersController(frame);
				usersController.drawUsersPanel(user, utenti);
			}
		});
	}
}
