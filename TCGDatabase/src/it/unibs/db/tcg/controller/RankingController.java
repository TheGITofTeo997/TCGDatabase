package it.unibs.db.tcg.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;

import it.unibs.db.tcg.model.ConnectorService;
import it.unibs.db.tcg.model.Utente;
import it.unibs.db.tcg.view.HomePanel;
import it.unibs.db.tcg.view.RankingPanel;

public class RankingController extends Controller {
	private RankingPanel rankingPanel;
	private JFrame frame;

	public RankingController(JFrame frame) {
		this.frame = frame;
	}

	public void drawRankingPanel(Utente user) {
		rankingPanel = new RankingPanel();
		rankingPanel.setBounds(0, 0, 800, 600);
		rankingPanel.setRankingCardValueList(connectorService.getRankingCardValue());
		rankingPanel.setRankingTotalCardList(connectorService.getRankingTotalCardNumber());
		frame.getContentPane().add(rankingPanel);

		rankingPanel.addBackListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rankingPanel.setVisible(false);
				HomeController homeController = new HomeController(frame);
				homeController.drawHomePanel(user.getNickname());
			}
		});
	}
}
