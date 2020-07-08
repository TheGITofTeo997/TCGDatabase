package it.unibs.db.tcg.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import it.unibs.db.tcg.model.Collezione;
import it.unibs.db.tcg.model.Utente;
import it.unibs.db.tcg.view.AccountPanel;

public class AccountController extends Controller {

	private AccountPanel accountPanel;

	private JFrame frame;

	public AccountController(JFrame frame) {
		this.frame = frame;
	}

	public void drawAccountPanel(String username) {

		Utente user = connectorService.getUser(username);
		user.setCollections(connectorService.getUserCollections(user.getNickname()));

		accountPanel = new AccountPanel();
		accountPanel.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(accountPanel);

		accountPanel.setNickname(user.getNickname());
		accountPanel.setMail(user.getMail());
		accountPanel.setAvatar(user.getAvatar());
		accountPanel.setUserName(user.getNomeUtente());
		accountPanel.setRegistrationDate(user.getDataRegistrazione().toString());
		accountPanel.setTotalValue(connectorService.getUserTotalCardsValue(user.getNickname()));
		user.setCollections(connectorService.getUserCollections(user.getNickname()));
		accountPanel.setCollections(user.getDefaultListModelCollections());

		accountPanel.addCollectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					String collection = user.getDefaultListModelCollections().get(accountPanel.getListSelectedIndex());
					Collezione c = new Collezione(collection);
					c.setCarteCollezione(connectorService.getCardsFromCollection(user.getNickname(), collection));
					accountPanel.setVisible(false);
					CardsController cardsController = new CardsController(frame);
					cardsController.drawCardsPanel(user, "Carte della Collezione " + collection, c.getCardsList(), null,
							null, false);
				}
			}
		});

		accountPanel.addEditListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				accountPanel.setVisible(false);
				EditController editController = new EditController(frame);
				editController.drawEditPanel(user);
			}
		});

		accountPanel.addBackListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				accountPanel.setVisible(false);
				HomeController homeController = new HomeController(frame);
				homeController.drawHomePanel(user.getNickname());
			}
		});

	}
}
