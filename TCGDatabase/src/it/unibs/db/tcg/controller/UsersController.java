package it.unibs.db.tcg.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import it.unibs.db.tcg.model.Carta;
import it.unibs.db.tcg.model.Utente;
import it.unibs.db.tcg.model.util.LogWriter;
import it.unibs.db.tcg.view.UsersPanel;

public class UsersController extends Controller {
	private UsersPanel usersPanel;

	private JFrame frame;

	public UsersController(JFrame frame) {
		this.frame = frame;
	}

	public void drawUsersPanel(Utente user, List<Utente> utenti) {
		usersPanel = new UsersPanel();
		usersPanel.setBounds(0, 0, 800, 600);
		usersPanel.setUserList(utenti);
		frame.getContentPane().add(usersPanel);

		usersPanel.addUsersListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					Utente u = utenti.get(usersPanel.getListSelectedIndex());
					usersPanel.setVisible(false);
					LogWriter.write("Richiesta informazioni generali dell'utente " + u.getNickname() + " per visualizzazione profilo");
					String nickname = u.getNickname();
					u.setTotalCardsValue(connectorService.getUserTotalCardsValue(nickname));
					u.setCollections(connectorService.getPublicUserCollections(nickname));
					usersPanel.setVisible(false);
					VisitorAccountController visitorAccountController = new VisitorAccountController(frame);
					visitorAccountController.drawVisitorAccountPanel(user, utenti, u);
				}
			}
		});

		usersPanel.addBackListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				usersPanel.setVisible(false);
				LogWriter.write("Apertura searchPanel");
				SearchController searchController = new SearchController(frame);
				searchController.drawSearchPanel(user);
			}
		});

	}

}
