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
	
	private SearchPanel srcPan;
	
private JFrame frame;
	
	public SearchController(JFrame frame) {
		this.frame = frame;
	}
	
	public void drawSearchPanel(Utente user) {
		srcPan = new SearchPanel();
		srcPan.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(srcPan);

		srcPan.addBackListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				srcPan.setVisible(false);
				HomeController homeController = new HomeController(frame);
				homeController.drawHomePanel(user.getNickname());
			}
		});

		srcPan.addUserSearchListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = srcPan.getUserNameField();
				srcPan.setVisible(false);
				UsersController usersController = new UsersController(frame);
				usersController.drawUsersPanel(user, connectorService.getSearchResult(name));
			}
		});

		srcPan.addCardSearchListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cardName = srcPan.getCardNameField();
				String exp = srcPan.getCardExpField();
				String cardIllustrator = srcPan.getCardIllustratorField();
				int lowerPSValue = srcPan.getPSBarLowerValue();
				int upperPSValue = srcPan.getPSBarUpperValue();
				int lowerValueBarValue = srcPan.getValueBarLowerValue();
				int upperValueBarValue = srcPan.getValueBarUpperValue();
				List<String> cardType = srcPan.getCardTypeSelected();
				List<String> energyType = srcPan.getEnergyTypeSelected();
				List<String> rarityType = srcPan.getRaritySelected();

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
				srcPan.setVisible(false);
				CardsController cardsController = new CardsController(frame);
				cardsController.drawCardsPanel(user, "Carte trovate", carte_trovate, null, null,true);

			}
		});
	}

}
