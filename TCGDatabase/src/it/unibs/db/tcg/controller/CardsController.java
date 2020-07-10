package it.unibs.db.tcg.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import it.unibs.db.tcg.model.Carta;
import it.unibs.db.tcg.model.Utente;
import it.unibs.db.tcg.view.CardsPanel;

public class CardsController extends Controller {

	private CardsPanel cardsPanel;

	private JFrame frame;

	public CardsController(JFrame frame) {
		this.frame = frame;
	}

	public void drawCardsPanel(Utente user, String title, List<Carta> cardsName, List<Utente> utenti, Utente toVisit,
			boolean fromSearchPanel) {
		cardsPanel = new CardsPanel();
		cardsPanel.setBounds(0, 0, 800, 600);
		cardsPanel.setTitleText(title);
		cardsPanel.setCardList(cardsName);
		frame.getContentPane().add(cardsPanel);

		cardsPanel.addCardListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					Carta c = cardsName.get(cardsPanel.getListSelectedIndex());
					Carta card = connectorService.getCardFromNumberAndAbbrEspansione(c.getNumero(),
							c.getAbbrEspansione());
					cardsPanel.setVisible(false);
					CartaController cartaController = new CartaController(frame);
					if (toVisit == null)
						cartaController.drawCartaPanel(user, title, cardsName, card, null, null);
					else
						cartaController.drawCartaPanel(user, title, cardsName, card, utenti, toVisit);
				}
			}
		});

		cardsPanel.addBackListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardsPanel.setVisible(false);
				if (fromSearchPanel) {
					SearchController searchController = new SearchController(frame);
					searchController.drawSearchPanel(user);
				} else if (toVisit == null) {
					AccountController accountController = new AccountController(frame);
					accountController.drawAccountPanel(user.getNickname());
				} else {
					VisitorAccountController visitorAccountController = new VisitorAccountController(frame);
					visitorAccountController.drawVisitorAccountPanel(user, utenti, toVisit);
				}

			}
		});

		cardsPanel.addBtnGroupByNumberActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Carta[] item = cardsName.toArray(new Carta[cardsName.size()]);
				int n = item.length;
				Carta temp;
				for (int index = 0; index < n; index++) {
					for (int j = 1; j < (n - index); j++) {
						if (item[j - 1].getNumero() > item[j].getNumero()) {
							temp = item[j - 1];
							item[j - 1] = item[j];
							item[j] = temp;
						}
					}
				}
				List<Carta> cardsName = Arrays.asList(item);
				cardsPanel.setVisible(false);
				drawCardsPanel(user, title, cardsName, utenti, toVisit, fromSearchPanel);
			}

		});

		cardsPanel.addBtnGroupByNameActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Collections.sort(cardsName, new Comparator<Carta>() {
					public int compare(Carta c1, Carta c2) {
						return c1.getNome().compareTo(c2.getNome());
					}
				});

				cardsPanel.setVisible(false);
				drawCardsPanel(user, title, cardsName, utenti, toVisit, fromSearchPanel);

			}
		});

		cardsPanel.addBtnGroupByExpActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Collections.sort(cardsName, new Comparator<Carta>() {
					public int compare(Carta c1, Carta c2) {
						return c1.getAbbrEspansione().compareTo(c2.getAbbrEspansione());
					}
				});

				cardsPanel.setVisible(false);
				drawCardsPanel(user, title, cardsName, utenti, toVisit, fromSearchPanel);

			}
		});
	}

}
