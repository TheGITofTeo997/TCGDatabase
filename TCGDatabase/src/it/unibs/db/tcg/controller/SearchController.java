package it.unibs.db.tcg.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;

import it.unibs.db.tcg.model.CardSearchObject;
import it.unibs.db.tcg.model.Carta;
import it.unibs.db.tcg.model.Utente;
import it.unibs.db.tcg.view.SearchPanel;

public class SearchController extends Controller {

	private SearchPanel searchPanel;

	private JFrame frame;

	public SearchController(JFrame frame) {
		this.frame = frame;
	}

	public void drawSearchPanel(Utente user) {
		searchPanel = new SearchPanel();
		searchPanel.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(searchPanel);

		searchPanel.addBackListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchPanel.setVisible(false);
				HomeController homeController = new HomeController(frame);
				homeController.drawHomePanel(user.getNickname());
			}
		});

		searchPanel.addUserSearchListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = searchPanel.getUserNameField();
				searchPanel.setVisible(false);
				UsersController usersController = new UsersController(frame);
				usersController.drawUsersPanel(user, connectorService.getSearchResult(name));
			}
		});

		searchPanel.addCardSearchListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cardName = searchPanel.getCardNameField();
				String exp = searchPanel.getCardExpField();
				String cardIllustrator = searchPanel.getCardIllustratorField();
				int lowerPSValue = searchPanel.getPSBarLowerValue();
				int upperPSValue = searchPanel.getPSBarUpperValue();
				int lowerValueBarValue = searchPanel.getValueBarLowerValue();
				int upperValueBarValue = searchPanel.getValueBarUpperValue();
				List<String> cardType = searchPanel.getCardTypeSelected();
				List<String> energyType = searchPanel.getEnergyTypeSelected();
				List<String> rarityType = searchPanel.getRaritySelected();

				CardSearchObject s = new CardSearchObject();
				s.setCardName(cardName);
				s.setExp(exp);
				s.setCardIllustrator(cardIllustrator);
				s.setLowerPSValue(lowerPSValue);
				s.setUpperPSValue(upperPSValue);
				s.setLowerValueBarValue(lowerValueBarValue);
				s.setUpperValueBarValue(upperValueBarValue);
				s.setCardType(cardType);
				s.setEnergyType(energyType);
				s.setRarityType(rarityType);

				List<Carta> carte_trovate = connectorService.getSearchResult(s);
				searchPanel.setVisible(false);
				CardsController cardsController = new CardsController(frame);
				cardsController.drawCardsPanel(user, "Carte trovate", carte_trovate, null, null, true);

			}
		});
	}

}
