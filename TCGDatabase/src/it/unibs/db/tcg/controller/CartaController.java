package it.unibs.db.tcg.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import it.unibs.db.tcg.view.CartaPanel;

public class CartaController extends Controller {

	private CartaPanel cardPanel;

	private JFrame frame;

	public CartaController(JFrame frame) {
		this.frame = frame;
	}

	public void drawCartaPanel(Utente user, String title, List<Carta> cardsName, Carta c, List<Utente> utenti,
			Utente toVisit) {
		cardPanel = new CartaPanel();
		cardPanel.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(cardPanel);

		for (String collection : connectorService.getUserCollections(user.getNickname())) {
			if (connectorService.isThereCardInCollection(user.getNickname(), collection, c.getNumero(),
					c.getAbbrEspansione())) {
				cardPanel.setVisibleRemoveCardButton();
			}
		}

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
				cardPanel.createCollectionListPopup(user.getDefaultListModelCollections());
				String selectedCollection = cardPanel.showCollectionsListPopup();
				if (selectedCollection != null) {
					if (!connectorService.isThereCardInCollection(user.getNickname(), selectedCollection, c.getNumero(),
							c.getAbbrEspansione())) {
						connectorService.insertCardInCollection(user.getNickname(), selectedCollection, c.getNumero(),
								c.getAbbrEspansione());
						cardPanel.showCorrectInsertPopup();
					} else
						cardPanel.showErrorPopup();
					drawCartaPanel(user, title, cardsName, c, utenti, toVisit);
				} else {
					cardPanel.showNoSelectedPopup();
					drawCartaPanel(user, title, cardsName, c, utenti, toVisit);
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
						connectorService.removeCardFromCollection(selectedCollection, c.getNumero(),
								c.getAbbrEspansione());
						cardPanel.setVisible(false);
						drawCartaPanel(user, title, cardsName, c, utenti, toVisit);
						cardPanel.repaint();
					} else {
						cardPanel.showErrorPopup();
						cardPanel.setVisible(false);
						drawCartaPanel(user, title, cardsName, c, utenti, toVisit);
					}

				} else {
					cardPanel.showNoSelectedPopup();
					cardPanel.setVisible(false);
					drawCartaPanel(user, title, cardsName, c, utenti, toVisit);
				}

			}
		});

		cardPanel.addBackListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardPanel.setVisible(false);
				CardsController cardsController = new CardsController(frame);
				if (toVisit == null)
					cardsController.drawCardsPanel(user, title, cardsName, null, null, false);
				else
					cardsController.drawCardsPanel(user, title, cardsName, utenti, toVisit, false);
			}
		});

	}
}
