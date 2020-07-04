package it.unibs.db.tcg.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import it.unibs.db.tcg.model.Collezione;
import it.unibs.db.tcg.model.ModelGod;
import it.unibs.db.tcg.model.Utente;
import it.unibs.db.tcg.view.AccountPanel;
import it.unibs.db.tcg.view.HomePanel;

public class AccountController extends Controller{

	private AccountPanel acPan;
	
	private JFrame frame;
	
	public AccountController(JFrame frame) {
		this.frame = frame;
	}
	
	public void drawAccountPanel(String username) {
		
		Utente user = model.getUser(username);
		user.setCollections(model.getUserCollections(user.getNickname()));
		
		acPan = new AccountPanel();
		acPan.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(acPan);

		acPan.setNickname(user.getNickname());
		acPan.setMail(user.getMail());
		acPan.setAvatar(user.getAvatar());
		acPan.setUserName(user.getNomeUtente());
		acPan.setRegistrationDate(user.getDataRegistrazione().toString());
		acPan.setTotalValue(model.getUserTotalCardsValue(user.getNickname()));
		user.setCollections(model.getUserCollections(user.getNickname()));
		acPan.setCollections(user.getDefaultListModelCollections());

		acPan.addCollectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					String collection = user.getDefaultListModelCollections().get(acPan.getListSelectedIndex());
					Collezione c = new Collezione(collection);
					c.setCarteCollezione(model.getCardsFromCollection(user.getNickname(), collection));
					acPan.setVisible(false);
					CardsController cardsController = new CardsController(frame);
					cardsController.drawCardsPanel(user, "Carte della Collezione " + collection, c.getCardsList(), null, null, false);
				}
			}
		});

		acPan.addEditListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				acPan.setVisible(false);
				EditController editController = new EditController(frame);
				editController.drawEditPanel(user);
			}
		});

		acPan.addBackListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				acPan.setVisible(false);
				HomeController homeController = new HomeController(frame);
				homeController.drawHomePanel(user.getNickname());
			}
		});

	}
}
