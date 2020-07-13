package it.unibs.db.tcg.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;

import it.unibs.db.tcg.model.Utente;
import it.unibs.db.tcg.model.util.LogWriter;
import it.unibs.db.tcg.view.StatsPanel;

public class StatsController extends Controller {

	private StatsPanel pannelloStatistiche;

	private JFrame frame;

	public StatsController(JFrame frame) {
		this.frame = frame;
	}
	
	public void disegnaPannelloStatistiche(Utente user, Utente toVisit, List<Utente> utenti, String collezione) {
		pannelloStatistiche = new StatsPanel();
		pannelloStatistiche.setBounds(0, 0, 800, 600);
		Utente temp = toVisit == null ? user : toVisit;
		pannelloStatistiche.setLblTitle(collezione);
		LogWriter.write("Richiesta del numero di carte di ogni espansione della collezione dell'utente al db");
		pannelloStatistiche.setExpList(connectorService.getCollectionCountOfCardsPerExpansion(temp.getNickname(), collezione));
		LogWriter.write("Richiesta del numero per rarità della collezione dell'utente al db");
		pannelloStatistiche.setRarityList(connectorService.getCollectionCountOfCardsPerRarity(temp.getNickname(), collezione));
		LogWriter.write("Richiesta carta dal valore più alto");
		pannelloStatistiche.setMaxValueCard(connectorService.getMaxCardValueInCollection(temp.getNickname(), collezione));
		LogWriter.write("Richiesta carta dal valore più basso");
		pannelloStatistiche.setMinValueCard(connectorService.getMinCardValueInCollection(temp.getNickname(), collezione));
		LogWriter.write("Richiesta valore medio carta");
		pannelloStatistiche.setAvgValueCard(connectorService.getAvgCardValueInCollection(temp.getNickname(), collezione));
		LogWriter.write("Richiesta valore totale collezione");
		pannelloStatistiche.setTotalCollectionValue(connectorService.getTotalCollectionValue(temp.getNickname(), collezione));
		LogWriter.write("Richiesta totale carte collezione");
		pannelloStatistiche.setTotalCardNumber(connectorService.getTotalCollectionCardsNumber(temp.getNickname(), collezione));
		LogWriter.write("Richiesta data inizio collezione");
		pannelloStatistiche.setStartDate(connectorService.getCollectionStartDate(temp.getNickname(), collezione));
		LogWriter.write("Richiesta informazione completezza collezione");
		pannelloStatistiche.setCollectionStateTextAndIcon(connectorService.isCollectionComplete(temp.getNickname(), collezione));
		frame.getContentPane().add(pannelloStatistiche);
	
		pannelloStatistiche.addBackListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pannelloStatistiche.setVisible(false);
				LogWriter.write("Apertura cardsPanel");
				CardsController cardsController = new CardsController(frame);
				if(toVisit == null)
					cardsController.drawUserCardsPanel(user, "Carte della Collezione " + collezione, collezione, user.getCollezioneByNome(collezione).getCardsList(), null,
							null, false);
				else
					cardsController.drawUserCardsPanel(user, "Carte della collezione " + collezione, collezione, toVisit.getCollezioneByNome(collezione).getCardsList(), utenti, toVisit, false);
			}
		});
	}
}
