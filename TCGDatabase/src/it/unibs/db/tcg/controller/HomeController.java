package it.unibs.db.tcg.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unibs.db.tcg.model.ConnectorService;
import it.unibs.db.tcg.model.Utente;
import it.unibs.db.tcg.view.HomePanel;

public class HomeController extends Controller {

	private HomePanel homePanel;
	private JFrame frame;

	public HomeController(JFrame frame) {
		this.frame = frame;
	}

	public void drawHomePanel(String username) {
		Utente user = connectorService.getUser(username);
		user.setCollections(connectorService.getUserCollections(user.getNickname()));
		homePanel = new HomePanel();
		homePanel.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(homePanel);

		homePanel.setAvatar(user.getAvatar());
		homePanel.setNickname(user.getNickname());

		homePanel.addAccountListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				homePanel.setVisible(false);
				user.setTotalCardsValue(connectorService.getUserTotalCardsValue(user.getNickname()));
				AccountController accountController = new AccountController(frame);
				accountController.drawAccountPanel(user.getNickname());
			}
		});

		homePanel.addBackListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (homePanel.showConfirmDialog() == 0) {
					homePanel.setVisible(false);
					LoginController loginController = new LoginController(frame);
					loginController.drawLoginPanel();
				}
			}
		});

		homePanel.addSearchListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				homePanel.setVisible(false);
				SearchController searchController = new SearchController(frame);
				searchController.drawSearchPanel(user);

			}
		});

		homePanel.addNewCollectionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (homePanel.showNewCollectionPopup()) {
					String name = homePanel.getNameTextField();
					if (!connectorService.hasUserCollection(user.getNickname(), name)) {
						String visible = homePanel.getVisibileField();
						int num = 0;
						if (visible.equals("Visibile"))
							num = 1;
						connectorService.createCollection(user.getNickname(), name, num);
					} else
						homePanel.showErrorPopup();
				}
			}
		});

		homePanel.addRandomCardListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				homePanel.showRandomCardPopup(connectorService.getRandomCard());
			}
		});
	}

}
