package it.unibs.db.tcg.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingWorker;

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
		
		homePanel.addRankingListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				homePanel.setVisible(false);
				RankingController rankingController = new RankingController(frame);
				rankingController.drawRankingPanel(user);
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
				List<Utente> usersRanking1 = connectorService.getRankingCardValue();
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
		
		

		lblEffect();

		homePanel.addLblPikachuMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblEffect();
			}

		});

	}

	private void lblEffect() {
		SwingWorker<Void, Void> backgroundThread1 = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				int x = 50;
				while (x < 75) {
					homePanel.setLblPikachuX(x);
					x = x + 1;
					Thread.sleep(25);
				}
				return null;
			}

			@Override
			protected void done() {
			};
		};
		backgroundThread1.execute();
	}

}
