package it.unibs.db.tcg.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;

import it.unibs.db.tcg.model.Carta;
import it.unibs.db.tcg.model.CartaEnergia;
import it.unibs.db.tcg.model.CartaPokemonBase;
import it.unibs.db.tcg.model.CartaPokemonSpeciale;
import it.unibs.db.tcg.model.CartaStrumento;
import it.unibs.db.tcg.model.Strings;
import it.unibs.db.tcg.model.Utente;
import it.unibs.db.tcg.model.util.LogWriter;
import it.unibs.db.tcg.view.CartaPanel;

public class CartaController extends Controller {

	private CartaPanel cardPanel;

	private JFrame frame;

	public CartaController(JFrame frame) {
		this.frame = frame;
	}

	public void drawCartaPanel(Utente user, String title, List<Carta> cardsName, Carta c, List<Utente> utenti,
			Utente toVisit, boolean fromSearchPanel) {
		cardPanel = new CartaPanel();
		cardPanel.setBounds(0, 0, 800, 600);
		LogWriter.write("Richiesta del nome del pokemon allo stage precedente");
		String pre_stage = connectorService.getNamePreStageByNumAndAbbrExp(c.getNumero(), c.getAbbrEspansione());
		LogWriter.write("Richiesta del nome del pokemon allo stage successivo");
		String next_stage = connectorService.getNameNextStageByNumAndAbbrExp(c.getNumero(), c.getAbbrEspansione());
		if(pre_stage != null) cardPanel.setBtnPreStageText(pre_stage);
		if(next_stage != null) cardPanel.setBtnNextStageText(next_stage);
		frame.getContentPane().add(cardPanel);
		
		for (String collection : connectorService.getUserCollections(user.getNickname())) {
			if (connectorService.isThereCardInCollection(user.getNickname(), collection, c.getNumero(),
					c.getAbbrEspansione())) {
				cardPanel.setVisibleRemoveCardButton();
			}
		}
		LogWriter.write("Richiesta del tipo della carta al db");
		String cardType = connectorService.getCardType(c.getNumero(), c.getAbbrEspansione());
		switch (cardType) {
		case Strings.CARTA_POKEMON_BASE:
			cardPanel.setSpecsCartaPokemon((CartaPokemonBase) c);
			break;
		case Strings.CARTA_POKEMON_SPECIALE:
			cardPanel.setSpecsCartaPokemon((CartaPokemonSpeciale) c);
			break;
		case Strings.CARTA_STRUMENTO:
			cardPanel.setSpecsCartaStrumento((CartaStrumento) c);
			break;
		case Strings.CARTA_ENERGIA:
			cardPanel.setSpecsCartaEnergia((CartaEnergia) c);
			break;

		}

		cardPanel.addAddToCollectionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LogWriter.write("Ottenimento delle collezioni possedute dall'utente");
				user.setCollections(connectorService.getUserCollections(user.getNickname()));
				cardPanel.createCollectionListPopup(user.getDefaultListModelCollections());
				String selectedCollection = cardPanel.showCollectionsListPopup();
				if (selectedCollection != null) {
					if (!connectorService.isThereCardInCollection(user.getNickname(), selectedCollection, c.getNumero(),
							c.getAbbrEspansione())) {
						LogWriter.write("Inserimento della carta " + c.getNumero() + "Espansione: "
								+ c.getAbbrEspansione() + " nella collezione " + selectedCollection);
						;
						connectorService.insertCardInCollection(user.getNickname(), selectedCollection, c.getNumero(),
								c.getAbbrEspansione());
						cardPanel.showCorrectInsertPopup();
					} else
						cardPanel.showErrorPopup();
					drawCartaPanel(user, title, cardsName, c, utenti, toVisit, fromSearchPanel);
				} else {
					cardPanel.showNoSelectedPopup();
					drawCartaPanel(user, title, cardsName, c, utenti, toVisit, fromSearchPanel);
				}
			}
		});

		cardPanel.addRemoveCardListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<String> listModel = new DefaultListModel<>();
				for (String collection : connectorService.getUserCollections(user.getNickname())) {
					if (connectorService.isThereCardInCollection(user.getNickname(), collection, c.getNumero(),
							c.getAbbrEspansione())) {
						listModel.addElement(collection);
					}
				}
				cardPanel.createCollectionListPopup(listModel);
				String selectedCollection = cardPanel.showCollectionsListPopup();
				if (selectedCollection != null) {
					if (connectorService.isThereCardInCollection(user.getNickname(), selectedCollection, c.getNumero(),
							c.getAbbrEspansione())) {
						LogWriter.write("Rimozione della carta " + c.getNumero() + "Espansione: "
								+ c.getAbbrEspansione() + "dalla collezione " + selectedCollection);
						connectorService.removeCardFromCollection(selectedCollection, c.getNumero(),
								c.getAbbrEspansione());
						cardPanel.setVisible(false);
						drawCartaPanel(user, title, cardsName, c, utenti, toVisit, fromSearchPanel);
						cardPanel.repaint();
					} else {
						cardPanel.showErrorPopup();
						cardPanel.setVisible(false);
						drawCartaPanel(user, title, cardsName, c, utenti, toVisit, fromSearchPanel);
					}

				} else {
					cardPanel.showNoSelectedPopup();
					cardPanel.setVisible(false);
					drawCartaPanel(user, title, cardsName, c, utenti, toVisit, fromSearchPanel);
				}

			}
		});

		cardPanel.addBtnWhoListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LogWriter.write("Richiesta nickname dei possessori della carta " + c.getNumero() + "Espansione: "
						+ c.getAbbrEspansione());
				List<String> nickname_utenti = connectorService.getUsersByCard(c.getNumero(), c.getAbbrEspansione());
				List<Utente> utenti = new ArrayList<>();
				for (String nickname : nickname_utenti) {
					utenti.add(connectorService.getUser(nickname));
				}
				cardPanel.setVisible(false);
				LogWriter.write("Apertura usersPanel");
				UsersController usersController = new UsersController(frame);
				usersController.drawUsersPanel(user, utenti);
			}
		});
		
		cardPanel.addNextStageActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Carta> cardsName = connectorService.getCardsByName(next_stage);
				cardPanel.setVisible(false);
				CardsController cardsController = new CardsController(frame);
				if (toVisit == null) {
					if (fromSearchPanel)
						cardsController.drawCardsPanel(user, title, cardsName, null, null, true);
					else
						cardsController.drawCardsPanel(user, title, cardsName, null, null, false);
				} else
					cardsController.drawCardsPanel(user, title, cardsName, utenti, toVisit, false);
			}
		});
		
		cardPanel.addPreStageActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Carta> cardsName = connectorService.getCardsByName(pre_stage);
				cardPanel.setVisible(false);
				CardsController cardsController = new CardsController(frame);
				if (toVisit == null) {
					if (fromSearchPanel)
						cardsController.drawCardsPanel(user, title, cardsName, null, null, true);
					else
						cardsController.drawCardsPanel(user, title, cardsName, null, null, false);
				} else
					cardsController.drawCardsPanel(user, title, cardsName, utenti, toVisit, false);
			}
		});

		cardPanel.addBackListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardPanel.setVisible(false);
				CardsController cardsController = new CardsController(frame);
				LogWriter.write("Apertura cardsPanel");
				if (toVisit == null) {
					if (fromSearchPanel)
						cardsController.drawCardsPanel(user, title, cardsName, null, null, true);
					else
						cardsController.drawCardsPanel(user, title, cardsName, null, null, false);
				} else
					cardsController.drawCardsPanel(user, title, cardsName, utenti, toVisit, false);
			}
		});

	}
}
