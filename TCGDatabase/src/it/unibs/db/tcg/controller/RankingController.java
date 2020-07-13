package it.unibs.db.tcg.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unibs.db.tcg.model.Utente;
import it.unibs.db.tcg.model.util.LogWriter;
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
		LogWriter.write("Richiesta classifica utenti per totale valore delle carte");
		rankingPanel.setRankingCardValueList(connectorService.getRankingCardValue());
		LogWriter.write("Richiesta classifica utenti per totale numero di carte possedute");
		rankingPanel.setRankingTotalCardList(connectorService.getRankingTotalCardNumber());
		LogWriter.write("Richiesta classifica utenti per massimo valore carta posseduta");
		rankingPanel.setRankingCardMaxValueList(connectorService.getRankingMaxCardValue());
		frame.getContentPane().add(rankingPanel);

		rankingPanel.addBackListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rankingPanel.setVisible(false);
				LogWriter.write("Aperture homePanel");
				HomeController homeController = new HomeController(frame);
				homeController.drawHomePanel(user.getNickname());
			}
		});
	}
}
