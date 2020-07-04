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

	private CartaPanel carPan;
	
	private JFrame frame;
	
	public CartaController(JFrame frame) {
		this.frame = frame;
	}
	
	public void drawCartaPanel(Utente user, String title, List<Carta> cardsName, Carta c, List<Utente> utenti,
			Utente toVisit) {
		carPan = new CartaPanel();
		carPan.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(carPan);

		for (String collection : model.getUserCollections(user.getNickname())) {
			if (model.isThereCardInCollection(user.getNickname(), collection, c.getNumero(), c.getAbbrEspansione())) {
				carPan.setVisibleRemoveCardButton();
			}
		}

		String cardType = model.getCardType(c.getNumero(), c.getAbbrEspansione());
		switch (cardType) {
		case Strings.CARTA_POKEMON_BASE:
			carPan.setSpecsCartaPokemon((CartaPokemonBase) c);
			break;
		case Strings.CARTA_POKEMON_SPECIALE:
			carPan.setSpecsCartaPokemon((CartaPokemonSpeciale) c);
			break;
		case Strings.CARTA_STRUMENTO:
			carPan.setSpecsCartaStrumento((CartaStrumento) c);
			break;
		case Strings.CARTA_ENERGIA:
			carPan.setSpecsCartaEnergia((CartaEnergia) c);
			break;

		}

		carPan.addAddToCollectionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				carPan.createCollectionListPopup(user.getDefaultListModelCollections());
				String selectedCollection = carPan.showCollectionsListPopup();
				if (selectedCollection != null) {
					if (!model.isThereCardInCollection(user.getNickname(), selectedCollection, c.getNumero(),
							c.getAbbrEspansione())) {
						model.insertCardInCollection(user.getNickname(), selectedCollection, c.getNumero(), c.getAbbrEspansione());
						carPan.showCorrectInsertPopup();
					} else
						carPan.showErrorPopup();
					drawCartaPanel(user, title, cardsName, c, utenti, toVisit);
				} else {
					carPan.showNoSelectedPopup();
					drawCartaPanel(user, title, cardsName, c, utenti, toVisit);
				}
			}
		});

		carPan.addRemoveCardListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<String> listModel = new DefaultListModel<>();
				for (String collection : model.getUserCollections(user.getNickname())) {
					if (model.isThereCardInCollection(user.getNickname(), collection, c.getNumero(),
							c.getAbbrEspansione())) {
						listModel.addElement(collection);
					}
				}
				carPan.createCollectionListPopup(listModel);
				String selectedCollection = carPan.showCollectionsListPopup();
				if (selectedCollection != null) {
					if (model.isThereCardInCollection(user.getNickname(), selectedCollection, c.getNumero(),
							c.getAbbrEspansione())) {
						model.removeCardFromCollection(selectedCollection, c.getNumero(), c.getAbbrEspansione());
						carPan.setVisible(false);
						drawCartaPanel(user, title, cardsName, c, utenti, toVisit);
						carPan.repaint();
					} else {
						carPan.showErrorPopup();
						carPan.setVisible(false);
						drawCartaPanel(user, title, cardsName, c, utenti, toVisit);
					}

				} else {
					carPan.showNoSelectedPopup();
					carPan.setVisible(false);
					drawCartaPanel(user, title, cardsName, c, utenti, toVisit);
				}
				
			}
		});

		carPan.addBackListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				carPan.setVisible(false);
				CardsController cardsController = new CardsController(frame);
				if (toVisit == null)
					cardsController.drawCardsPanel(user, title, cardsName, null, null, false);
				else
					cardsController.drawCardsPanel(user, title, cardsName, utenti, toVisit, false);
			}
		});

	}
}
