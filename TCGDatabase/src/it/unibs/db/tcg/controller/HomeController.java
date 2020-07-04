package it.unibs.db.tcg.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unibs.db.tcg.model.ModelGod;
import it.unibs.db.tcg.model.Utente;
import it.unibs.db.tcg.view.HomePanel;

public class HomeController extends Controller{
	
	private HomePanel homePan;
private JFrame frame;
	
	public HomeController(JFrame frame) {
		this.frame = frame;
	}
	public void drawHomePanel(String username) {
		Utente user = model.getUser(username);
		user.setCollections(model.getUserCollections(user.getNickname()));
		homePan = new HomePanel();
		homePan.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(homePan);

		homePan.setAvatar(user.getAvatar());
		homePan.setNickname(user.getNickname());

		homePan.addAccountListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				homePan.setVisible(false);
				user.setTotalCardsValue(model.getUserTotalCardsValue(user.getNickname()));
				AccountController accountController = new AccountController(frame);
				accountController.drawAccountPanel(user.getNickname());
			}
		});

		homePan.addBackListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (homePan.showConfirmDialog() == 0) {
					homePan.setVisible(false);
					LoginController loginController = new LoginController(frame);
					loginController.drawLoginPanel();
				}
			}
		});

		homePan.addSearchListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				homePan.setVisible(false);
				SearchController searchController = new SearchController(frame);
				searchController.drawSearchPanel(user);

			}
		});

		homePan.addNewCollectionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (homePan.showNewCollectionPopup()) {
					String name = homePan.getNameTextField();
					if (!model.hasUserCollection(user.getNickname(), name)) {
						String visible = homePan.getVisibileField();
						int num = 0;
						if (visible.equals("Visibile"))
							num = 1;
						model.createCollection(user.getNickname(), name, num);
					} else
						homePan.showErrorPopup();
				}
			}
		});

		homePan.addRandomCardListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				homePan.showRandomCardPopup(model.getRandomCard());
			}
		});
	}
	
}
