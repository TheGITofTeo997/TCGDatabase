package it.unibs.db.tcg.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import it.unibs.db.tcg.model.Carta;
import it.unibs.db.tcg.model.Collezione;
import it.unibs.db.tcg.model.Utente;
import it.unibs.db.tcg.model.util.LogWriter;
import it.unibs.db.tcg.view.VisitorAccountPanel;

public class VisitorAccountController extends Controller {
	private VisitorAccountPanel visitorAccountPanel;

	private JFrame frame;

	public VisitorAccountController(JFrame frame) {
		this.frame = frame;
	}

	public void drawVisitorAccountPanel(Utente user, List<Utente> utenti, Utente toVisit) {
		visitorAccountPanel = new VisitorAccountPanel();
		visitorAccountPanel.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(visitorAccountPanel);

		visitorAccountPanel.setNickname(toVisit.getNickname());
		visitorAccountPanel.setMail(toVisit.getMail());
		visitorAccountPanel.setAvatar(toVisit.getAvatar());
		visitorAccountPanel.setUserName(toVisit.getNomeUtente());
		visitorAccountPanel.setRegistrationDate(toVisit.getDataRegistrazione().toString());
		visitorAccountPanel.setTotalValue(toVisit.getTotalCardsValue());
		visitorAccountPanel.setCollections(toVisit.getDefaultListModelCollections());

		visitorAccountPanel.addCollectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					String collection = toVisit.getDefaultListModelCollections()
							.get(visitorAccountPanel.getListSelectedIndex());
					Collezione c = new Collezione(collection);
					LogWriter.write("Ottenimento delle carte della collezione " + collection + " dell'utente " + toVisit.getNickname());
					List<Carta> listaCarte = connectorService.getCardsFromCollection(toVisit.getNickname(), collection);
					c.setCarteCollezione(listaCarte);
					toVisit.getCollezioneByNome(collection).setCarteCollezione(listaCarte);
					visitorAccountPanel.setVisible(false);
					CardsController cardsController = new CardsController(frame);
					cardsController.drawUserCardsPanel(user, "Carte della Collezione " + collection, collection, c.getCardsList(),
							utenti, toVisit, false);
				}
			}
		});

		visitorAccountPanel.addBackListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visitorAccountPanel.setVisible(false);
				LogWriter.write("Apertura usersPanel");
				UsersController usersController = new UsersController(frame);
				usersController.drawUsersPanel(user, utenti);
			}
		});
	}
}
